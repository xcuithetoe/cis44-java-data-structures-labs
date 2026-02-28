import java.util.Iterator;


public class LinkedPositionalList<E> implements Iterable<E> {
    // --- Nested Node Class (implements Position) ---
    private static class Node<E> implements Position<E> {
        // ... element, prev, next pointers and methods ...
        private E stop; // ie, "Eiffel Tower"
        private Node<E> prev;
        private Node<E> next;
        public Node(E stop, Node prev, Node next) {
            this.stop = stop;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() throws IllegalStateException{
            if (next == null) { // this is a trailer node and should not be exposed to the user
                throw new IllegalStateException("Position no longer valid");
            }
            return stop;
        }

        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setStop(E stop) {
            this.stop = stop;
        }
        public void setPrev(Node<E> prev) {
            this.prev = prev; 
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }

    }
    
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        // ... constructor to create sentinel nodes ...
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }
    
    // ... Implement all the Positional List methods ...

    // private utility method helping to cast user-inputed positions into nodes
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if(node.getNext() == null) {
            throw new IllegalArgumentException("p is no longer in the list");
        }
        return node;
    }

    // this method ensures sentinals aren't exposed when a user calls first(), last(), before(), or after().  
    private Position<E> position(Node<E> node) {
        if (node == header || node ==  trailer) {
            return null; // as part of encapsulation, this code ensures sentinals aren't exposed to the user
        }
        return node;
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    private Position<E> addBetween(E stop, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<E>(stop, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    public Position<E> addFirst(E stop) {
        return addBetween(stop, header, header.getNext());
    }

    public Position<E> addLast(E stop) {
        return addBetween(stop, trailer.getPrev(), trailer);
    }

    public Position<E> addBefore(Position<E> p, E stop) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(stop, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E stop) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(stop, node, node.getNext());
    }

    public E set(Position<E> p, E stop) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E previous = node.getElement();
        node.setStop(stop);
        return previous;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> before = node.getPrev();
        Node<E> after = node.getNext();
        before.setNext(after);
        after.setPrev(before);
        size--;
        E previous = node.getElement();
        node.setStop(null);
        node.setNext(null);
        node.setPrev(null);
        return previous;
    }


    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator<E> {
        Position<E> cursor = first(); // Start at the first element
        
        public boolean hasNext() {
            return cursor != null;
        }
        
        public E next() {
            // Store the element at the current cursor
            // Advance the cursor to the next position using after()
            // Return the stored element

            E current = cursor.getElement();
            cursor = after(cursor);
            return current;
            
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
      