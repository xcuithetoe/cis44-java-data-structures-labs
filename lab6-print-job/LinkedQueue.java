public class LinkedQueue<E> implements Queue<E> {
    // use linked list implementation because number of print jobs is unknown
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedQueue() {}
    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E element) {
        list.addLast(element);
    }
    public E dequeue() {
        return list.removeFirst();
    }

    public E first() {
        return list.first();
    }

}