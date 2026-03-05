package MainCache;

import EvictionAlgorithms.EvictionAlgorithm;
import Executors.KeyBasedExecutor;
import StorageMechanisms.Interfaces.CacheStorage;
import StorageMechanisms.Interfaces.DBStorage;
import WritePolicies.WritePolicy;

import java.util.NoSuchElementException;
import java.util.concurrent.*;

// Cache.java
import java.util.concurrent.CompletableFuture;

public class Cache<K, V> {
    private final CacheStorage<K, V> cacheStorage;
    private final DBStorage<K, V> dbStorage;
    private final WritePolicy<K, V> writePolicy;
    private final EvictionAlgorithm<K> evictionAlgorithm;
    private final KeyBasedExecutor keyBasedExecutor;

    ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * Constructs the cache.
     *
     * @param cacheStorage  The in-memory cache (with limited capacity).
     * @param dbStorage     The underlying persistent storage (database).
     * @param writePolicy   The write-through policy.
     * @param evictionAlgorithm  The eviction strategy (custom LRU implementation).
     * @param numExecutors  Number of single-thread executors for key-based dispatch.
     */
    public Cache(CacheStorage<K, V> cacheStorage, DBStorage<K, V> dbStorage,
                 WritePolicy<K, V> writePolicy, EvictionAlgorithm<K> evictionAlgorithm,
                 int numExecutors) {
        this.cacheStorage = cacheStorage;
        this.dbStorage = dbStorage;
        this.writePolicy = writePolicy;
        this.evictionAlgorithm = evictionAlgorithm;
        this.keyBasedExecutor = new KeyBasedExecutor(numExecutors);
    }

    /**
     * Reads data from the cache for the given key.
     * Updates the eviction algorithm as the key is accessed.
     */
    public CompletableFuture<V> accessData(K key) {
        return keyBasedExecutor.submitTask(key, () -> {
            try {
                if (!cacheStorage.containsKey(key)) {
                    throw new Exception("Key not found in cache: " + key);
                }
                evictionAlgorithm.keyAccessed(key);
                return cacheStorage.get(key);
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        });
    }

    public CompletableFuture<V> accessData1(K key) {
        return CompletableFuture.supplyAsync(() -> {
           try {
               V value = cacheStorage.get(key);

               if (value == null) {       ///  if not there in cache, throw exception
                   throw new CompletionException(
                           new NoSuchElementException("Key not found in cache: " + key)
                   );
               }

               evictionAlgorithm.keyAccessed(key);   /// update LRU status, move the key to head
               return value;
           }
           catch (Exception e) {
                throw new CompletionException(e);
           }
        }, executor);
    }

    /**
     * Writes (or updates) data in both the cache and DB storage using the write-through policy.
     * If the key is new and the cache is at capacity, evicts the least recently used key from the cache.
     */
    public CompletableFuture<Void> updateData(K key, V value) {
        return keyBasedExecutor.submitTask(key, () -> {
            try {
                if (cacheStorage.containsKey(key)) {
                    // Update case: perform concurrent write.
                    writePolicy.write(key, value, cacheStorage, dbStorage);
                    evictionAlgorithm.keyAccessed(key);
                } else {
                    // New key: If the cache is full, evict one key.
                    if (cacheStorage.size() >= cacheStorage.getCapacity()) {
                        K evictedKey = evictionAlgorithm.evictKey();
                        if (evictedKey != null) {
                            // Removal on the evicted key's executor to maintain ordering.
                            int currentIndex = keyBasedExecutor.getExecutorIndexForKey(key);
                            int evictedIndex = keyBasedExecutor.getExecutorIndexForKey(evictedKey);
                            if (currentIndex == evictedIndex) {
                                cacheStorage.remove(evictedKey);
                            } else {
                                CompletableFuture<Void> removalFuture = keyBasedExecutor.submitTask(evictedKey, () -> {
                                    try {
                                        cacheStorage.remove(evictedKey);
                                        return null;
                                    } catch (Exception ex) {
                                        throw new CompletionException(ex);
                                    }
                                });
                                removalFuture.join();
                            }
                        }
                    }
                    // Write the new key/value concurrently to both storages.
                    writePolicy.write(key, value, cacheStorage, dbStorage);
                    evictionAlgorithm.keyAccessed(key);
                }
                return null;
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        });
    }

    public CompletableFuture<Void> updateData1(K key, V value) {
        return CompletableFuture.runAsync(() -> {
            synchronized(this) { // lock the cache instance
                try {
                    V existing = cacheStorage.get(key);  /// instead if cache ! contains key, we use like this in mutli-threaded env
                    if (existing != null) {
                        writePolicy.write(key, value, cacheStorage, dbStorage);  /// add to cache thriugh write policy and to db
                        evictionAlgorithm.keyAccessed(key);
                        return;
                    }

                    if (cacheStorage.size() >= cacheStorage.getCapacity()) {    // if cache full, evict LRU key
                        K evictedKey = evictionAlgorithm.evictKey();
                        if (evictedKey != null) cacheStorage.remove(evictedKey);
                    }

                    writePolicy.write(key, value, cacheStorage, dbStorage);    /// write this new value to cache and DB
                    evictionAlgorithm.keyAccessed(key);   /// update the LRU status to head

                } catch (Exception e) {
                    throw new CompletionException(e);
                }
            }
        }, executor);
    }

    /**
     * Shuts down all executors.
     */
    public void shutdown() throws InterruptedException {
       executor.shutdown();

       if(executor.awaitTermination(1, TimeUnit.SECONDS)){
           executor.shutdownNow();
       }
       executor.shutdown();

       keyBasedExecutor.shutdown();
    }
}
