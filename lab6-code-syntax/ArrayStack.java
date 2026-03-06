// decided to use arraystack instea of linkedstack because of arraystack's relative simplicity. 

public class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int t=-1; // start index of empty stack is -1
    private int capacity;

    public ArrayStack(int capacity) {
        // because isBalanced() will pass the string length to ArrayStack, I didn't bother making a no-argument constructor and setting a default capacity

        data = (E[]) new Object[capacity]; // cast to generic type
        this.capacity = capacity; 
    }

    public int size() {
        return (t+1);
    }

    public boolean isEmpty() {
        return (t == -1);
    }

    public void push(E e) throws IllegalStateException{
        if (t+1 == capacity) {
            throw new IllegalStateException("Stack is full");
        } else {
            data[++t] = e; // increment t, then add the element at incremented t index
        }
    }

    public E top() {
        if(isEmpty()) {
            return null;
        }
        else {
            return data[t];
        }
    }

    public E pop() {
        if(isEmpty()) {
            return null;
        } else {
            E answer = data[t];
            data[t--] = null; // remove top value and then decrement t;
            return answer;
        }
    }

}