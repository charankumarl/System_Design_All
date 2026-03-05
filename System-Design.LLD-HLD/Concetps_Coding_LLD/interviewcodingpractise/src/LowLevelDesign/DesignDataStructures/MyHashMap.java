package LowLevelDesign.DesignDataStructures;

public class MyHashMap<K,V> {

    private static final int  INITIAL_SIZE = 1<<4; // 16
    private static final int MAXIMUM_CAPACITY = 1 << 30;  // 2^30

    Entry[] hashTable;

    MyHashMap(){

        hashTable= new Entry[INITIAL_SIZE];
    }

    MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable= new Entry[tableSize];
    }

     final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;   // making all other bits from highest set bit to 1.
        n |= n >>> 2;  // >>> It shifts bits to the right, and fills the leftmost bits with 0, regardless of the number’s sign (positive or negative).
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n + 1);
     }


    class Entry<K,V>{

        K key;
        V value;
        Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    public void put(K key, V value) {

        int hashCode = key.hashCode() % hashTable.length;  // making sure the hashcode is within the range of the hashTable.
        Entry node = hashTable[hashCode];

        if(node == null) {  // 1. If this is the 1st time, then we will create a new node and add it to the hashTable.

            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        }
        else {  // 2. If already present. 1. Verify Key is there if yes then update the value.
                    // 2. If not present then traverse LL till end and add prev node to new node.

            Entry previousNode = node;

            while (node != null) {  // traverse till end.

                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }

            Entry newNode = new Entry(key,value);  // create new node and add it to the end of the LL.
            previousNode.next = newNode;
        }
    }


    public V get(K key) {

        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null) {  // get node and traverse all node in case of collision. And find correct key. Then return value.
            if(node.key.equals(key)) {
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String args[]) {

        MyHashMap<Integer, String> map = new MyHashMap<>(7);
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Shrayansh");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");

        String value = map.get(8);
        System.out.println(value);
    }

    /*
           Purpose of tableSizeFor(cap)
    This is a utility method (used in HashMap and other collections) to compute the smallest power of 2 that is greater than or equal
    to cap.

    So if you pass in 20, it will return 32 because 32 is the smallest power of 2 ≥ 20.

    The trick here is to:

        Set all bits to the right of the most significant 1 bit to 1.
        Then add 1 → which becomes the next power of 2.

        Step 1: int n = cap - 1; → n = 19
        Binary: 0001 0011  // (19 in binary)

        Step 2: n |= n >>> 1
        n         = 0001 0011
        n >>> 1   = 0000 1001
        n | n>>>1 = 0001 1011

        Step 3: n |= n >>> 2
        n         = 0001 1011
        n >>> 2   = 0000 0110
        n | n>>>2 = 0001 1111

        Step 4: n |= n >>> 4
        n         = 0001 1111
        n >>> 4   = 0000 0001
        n | n>>>4 = 0001 1111
        (no change as highest bits already 1s)

        Step 5 & 6: n >>> 8, n >>> 16
        n = 0001 1111  // 31 in decimal

        Step 7: return (n < 0) ? 1 : (n + 1);

        n = 31 → return 32
     */
}
