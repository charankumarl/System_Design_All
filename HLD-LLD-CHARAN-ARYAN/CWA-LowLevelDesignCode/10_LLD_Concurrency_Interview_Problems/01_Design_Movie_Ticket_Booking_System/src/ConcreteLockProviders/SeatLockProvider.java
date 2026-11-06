package ConcreteLockProviders;

import CommonEnum.SeatStatus;
import CoreClasses.Seat;
import CoreClasses.SeatLock;
import CoreClasses.Show;
import CoreClasses.User;
import Interfaces.ISeatLockProvider;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class SeatLockProvider implements ISeatLockProvider {

    // Timeout in seconds after which a lock expires
    private final Integer lockTimeout;

    // Stores the locks per show and seat
    private final Map<Show, Map<Seat, SeatLock>> locks;

    // One ReentrantLock per (show, seat) — lets unrelated seats/shows book in parallel
    private final Map<Show, Map<Seat, ReentrantLock>> seatLockObjects;

    // Constructor to initialize lock store and timeout
    public SeatLockProvider(Integer lockTimeout) {
        this.locks = new ConcurrentHashMap<>();
        this.seatLockObjects = new ConcurrentHashMap<>();
        this.lockTimeout = lockTimeout;
    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, User user) throws Exception {

        // per-show maps — mirrors how `locks` is scoped, so seat A1 in show X
        // doesn't block seat A1 in show Y
        Map<Seat, SeatLock> seatLocks = locks.computeIfAbsent(show, s -> new ConcurrentHashMap<>());
        Map<Seat, ReentrantLock> seatLockMap = seatLockObjects.computeIfAbsent(show, s -> new ConcurrentHashMap<>());

        // sort so two requests needing overlapping seats always acquire them in the
        // same order — prevents deadlock (A locks seat1 then wants seat2, B locks
        // seat2 then wants seat1)

        Collections.sort(seats, Comparator.comparing(Seat::getSeatId));

        /**
         * Sort by multiple fields (e.g. by department, then by salary within each):
         * Collections.sort(employees,
         *     Comparator.comparing(Employee::getDepartment)
         *               .thenComparing(Employee::getSalary));
         */

        List<ReentrantLock> acquired = new ArrayList<>();
        try {

            // This is the Place Slow down will happen. Since Reetrant is Atomic, 1 req get locks and other will waiting for same seat lock. But remaining req will move forwards.
            for (Seat seat : seats) {
                ReentrantLock seatLock = seatLockMap.computeIfAbsent(seat, s -> new ReentrantLock());
                seatLock.lock();
                acquired.add(seatLock);
            }

            // all requested locks held — now safe to check + act as one atomic step
            for (Seat seat : seats) {
                SeatLock existingLock = seatLocks.get(seat);
                if (existingLock != null && !existingLock.isLockExpired()) {
                    throw new Exception("Seat " + seat.getSeatId() + " is already locked.");
                }
            }

            Date now = new Date();
            for (Seat seat : seats) {
                SeatLock lock = new SeatLock(seat, show, lockTimeout, now, user);
                seatLocks.put(seat, lock);
                seat.seatStatus = SeatStatus.LOCKED;
            }

        } finally {
            // release everything this call acquired, even on failure
            for (ReentrantLock seatLock : acquired) {
                seatLock.unlock();
            }
        }
    }

    /**
     *lockSeats(Show show, List<Seat> seats, User user)
     * A customer picks a show (e.g. "Avengers, 6pm") and a list of seats (e.g. [A1, A2, A3]), identifying themselves as user.
     * Goal: lock those seats for that user so nobody else can grab them while they pay.
     *
     * Why 2 maps, not 1
     *
     * Map 1 — seatLocks (the actual lock data): "which user holds which seat, until when?"
     * Map<Seat, SeatLock> seatLocks = locks.computeIfAbsent(show, s -> new ConcurrentHashMap<>());
     * SeatLock is the real booking info: seat, user, timestamp, expiry. This is the source of truth — "Seat A1 is locked by Alice until 10:05am."
     *
     * Map 2 — seatLockMap (just a synchronization tool): "which lock object do I grab before touching Seat A1's data?"
     * Map<Seat, ReentrantLock> seatLockMap = seatLockObjects.computeIfAbsent(show, s -> new ConcurrentHashMap<>());
     * ReentrantLock here has no booking info at all — it's purely a traffic-control object.
     * Its only job: make sure two threads don't both try to read-then-write seatLocks for the same seat at the same time.
     *
     * Why not just one map? Because the data (who booked what) and the locking mechanism (who gets to touch that data right now) are different concerns. If you tried to synchronized on the SeatLock object itself, it wouldn't exist yet for a never-booked seat — you need a lock object that exists before any booking happens, so the very first person to touch that seat still gets proper mutual exclusion.
     *
     * Both maps are scoped per show (locks.computeIfAbsent(show,...) and seatLockObjects.computeIfAbsent(show,...)) so seat A1 of the 3pm show is completely unrelated to seat A1 of the 6pm show.
     *
     *      Step by step
     *
     * Step 1 — get this show's two maps (or create them if first time):
     *
     * Map<Seat, SeatLock> seatLocks = locks.computeIfAbsent(show, ...);
     * Map<Seat, ReentrantLock> seatLockMap = seatLockObjects.computeIfAbsent(show, ...);
     *
     * Step 2 — sort the requested seats by ID:
     *
     * List<Seat> sortedSeats = seats.stream().sorted(...).collect(...);
     * Why: if customer A wants [A1, A2] and customer B wants [A2, A1] at the same instant, sorting forces both to try locking A1 first, then A2 — same order for everyone. Prevents deadlock (A holding A1 waiting for A2, while B holds A2 waiting for A1 — stuck forever).
     *
     * Step 3 — acquire a lock for every requested seat, one at a time, in sorted order:
     *
     * for (Seat seat : sortedSeats) {
     *     ReentrantLock seatLock = seatLockMap.computeIfAbsent(seat, s -> new ReentrantLock());
     *     seatLock.lock();        // blocks here if someone else holds it
     *     acquired.add(seatLock); // remember what we grabbed, to release later
     * }
     * Only seats this specific request cares about get locked — an unrelated request for seats [B1, B2] uses different lock objects, so it runs in parallel, not blocked by this one.
     *
     * Step 4 — now that all needed seat-locks are held, safely check if any seat is already booked:
     *
     * for (Seat seat : sortedSeats) {
     *     SeatLock existingLock = seatLocks.get(seat);
     *     if (existingLock != null && !existingLock.isLockExpired()) {
     *         throw new Exception(...); // someone else already has it, still valid
     *     }
     * }
     * This check is now safe — nobody else can sneak in and lock these same seats mid-check, because we're holding their ReentrantLocks.
     *
     * Step 5 — all clear, actually lock every seat:
     *
     * for (Seat seat : sortedSeats) {
     *     SeatLock lock = new SeatLock(seat, show, lockTimeout, now, user);
     *     seatLocks.put(seat, lock);         // write to the DATA map
     *     seat.seatStatus = SeatStatus.LOCKED;
     * }
     *
     * Step 6 — finally: release every lock this call grabbed, success or failure:
     *
     * for (ReentrantLock seatLock : acquired) {
     *     seatLock.unlock();
     * }
     * Even if step 4 threw an exception halfway through, whatever was already locked in step 3 still gets released — no stuck locks left behind.
     *
     * One-line takeaway
     *
     * One map stores the booking truth (who owns which seat). The other map stores traffic-control objects used only to make sure the check-then-lock sequence on
     * specific seats happens safely and without blocking unrelated seats/shows.
     */

    @Override
    public void unlockSeats(final Show show, final List<Seat> seats, final User user) {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if (seatLocks == null) return;
        Map<Seat, ReentrantLock> seatLockMap = seatLockObjects.get(show);
        if (seatLockMap == null) return;

        // same sorted-order acquisition as lockSeats — keeps lock ordering
        // consistent across every method that touches these seats
        List<Seat> sortedSeats = seats.stream()
                .sorted(Comparator.comparing(Seat::getSeatId))
                .collect(Collectors.toList());

        List<ReentrantLock> acquired = new ArrayList<>();
        try {
            for (Seat seat : sortedSeats) {
                ReentrantLock seatLock = seatLockMap.computeIfAbsent(seat, s -> new ReentrantLock());
                seatLock.lock();
                acquired.add(seatLock);
            }

            for (Seat seat : sortedSeats) {
                SeatLock lock = seatLocks.get(seat);
                if (lock != null && lock.getLockedBy().equals(user)) {
                    seatLocks.remove(seat);
                }
            }
        } finally {
            for (ReentrantLock seatLock : acquired) {
                seatLock.unlock();
            }
        }
    }

    @Override
    public boolean validateLock(final Show show, final Seat seat, final User user) {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if (seatLocks == null) return false;
        Map<Seat, ReentrantLock> seatLockMap = seatLockObjects.get(show);
        if (seatLockMap == null) return false;

        ReentrantLock seatLock = seatLockMap.computeIfAbsent(seat, s -> new ReentrantLock());
        seatLock.lock();
        try {
            SeatLock lock = seatLocks.get(seat);
            seatLocks.remove(seat);        /// we are either booking or not booking, so remove the seat from the LOCK. So if it booked,
            if (!isValid(lock, user)) {    /// it will go to BOOKED status, if not booked, it will be available for others to book.
                return false;
            }
        } finally {
            seatLock.unlock();
        }

        return true;
    }

    private boolean isValid(SeatLock lock, User user) {

        return lock != null && !lock.isLockExpired() && lock.getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(final Show show) {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if (seatLocks == null) {
            return Collections.emptyList();
        }
        synchronized (seatLocks) {
            return seatLocks.entrySet().stream()
                    .filter(entry -> !entry.getValue().isLockExpired())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }
}
