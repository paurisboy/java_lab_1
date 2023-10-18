package lib.list;
/**
 * The LinkedList class represents a singly linked list designed to store elements of type T.
 * It supports operations for adding, getting, and removing elements, as well as providing information
 * about the size of the list and whether it's empty.
 *
 * @param <T> The type of elements stored in the list.
 */
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     * The nested Node class represents a list node that stores data for an element and a reference to the next node.
     *
     * @param <T> The data type of the element.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        /**
         * The constructor creates a new node with the given data.
         *
         * @param data The data of the element.
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Method for adding an element to the end of the list.
     *
     * @param data The data of the element to be added.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Method for getting an element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element in the list corresponding to the specified index.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Method for removing an element at the specified index.
     *
     * @param index The index of the element to be removed.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Method for getting the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Method for checking if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method for clearing the list, removing all elements.
     */
    public void clear() {
        head = null;
        size = 0;
    }
}
