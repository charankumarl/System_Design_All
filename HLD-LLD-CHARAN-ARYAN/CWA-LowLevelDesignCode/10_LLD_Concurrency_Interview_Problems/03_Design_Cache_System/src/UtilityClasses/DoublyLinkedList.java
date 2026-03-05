package UtilityClasses;

public class DoublyLinkedList<K> {
    private DoublyLinkedListNode<K> head = new DoublyLinkedListNode<>(null);
    private DoublyLinkedListNode<K> tail = new DoublyLinkedListNode<>(null);

    public DoublyLinkedList() {
//        this.head = null;
//        this.tail = null;
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Adds a node to the Head of the DLL of the list. This Recently Used
     */
    public void addNodeAtHead(DoublyLinkedListNode<K> node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    /**
     * Detaches a node from the list.
     */
    public void detachNode(DoublyLinkedListNode<K> node) {
        if (node == null) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Returns the Tail.Prev node (the least recently used).
     */
    public DoublyLinkedListNode<K> getTail() {
        return tail.prev;
    }

    /**
     * Removes the Tail.Prev node from the list.
     */

    public void removeTail() {

        DoublyLinkedListNode<K> node = tail.prev;

        detachNode(node);   /// remove last node
    }
}
