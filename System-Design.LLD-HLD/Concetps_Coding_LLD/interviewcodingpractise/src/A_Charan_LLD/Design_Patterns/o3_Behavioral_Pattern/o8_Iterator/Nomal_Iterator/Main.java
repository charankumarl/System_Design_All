package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o8_Iterator.Nomal_Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));

        for(int i : list){
            System.out.print(i);
        }
        System.out.println();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }

        /*
            Immutable List (List.of(...))
            Created using List.of(...) (Java 9+).

            Cannot be modified after creation — no adding, removing, or changing elements.

            Any attempt to do so will throw UnsupportedOperationException.

            List<Integer> list = List.of(1, 2, 3);
            list.add(4); // ❌ Throws exception
            list.set(0, 100); // ❌ Throws exception
---------------------------------------------------------------------------------------------

            Normal (Mutable) List (e.g., ArrayList)
            Can be modified anytime.

            List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
            list.add(4);     // ✅ Works
            list.set(0, 100); // ✅ Works
         */
    }
}
