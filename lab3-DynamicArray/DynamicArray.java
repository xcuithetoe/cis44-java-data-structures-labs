/**
 Create a generic class named DynamicArray.java.
The class must have the following private instance variables:
An array to store the elements: private T[] data;
An integer to track the number of elements: private int size;
An integer for the initial capacity (e.g., private static final int INITIAL_CAPACITY = 10;).
Implement the following public methods:
public DynamicArray(): A constructor that initializes the internal array with the initial capacity.
public void add(T element): Adds an element to the end of the list. If the internal array is full, this method must trigger a private resize() method before adding the new element.
public T get(int index): Returns the element at the specified index. Throws an IndexOutOfBoundsException if the index is invalid.
public T remove(int index): Removes the element at the specified index. All subsequent elements must be shifted to the left to fill the gap. Returns the removed element. Throws an IndexOutOfBoundsException if the index is invalid.
public int size(): Returns the number of elements in the list.
Implement a private resize() method that creates a new array with double the capacity of the old one and copies the elements over.*
 */


public class DynamicArray<T>
{
    
    //An array to store the elements: private T[] data;
    //An integer to track the number of elements: private int size;
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 3;
    
    // A constructor that initializes the internal array with the initial capacity.
    public DynamicArray() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    
    // Adds an element to the end of the list. If the internal array is full, this method must trigger a private resize() method before adding the new element.
    public void add(T element) {
        if (size == data.length) {
            resize();
        }
        
        data[size] = element;
        size++;
    }
    
    //Returns the element at the specified index. Throws an IndexOutOfBoundsException if the index is invalid.

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        return data[index];
    }
    
    //Removes the element at the specified index. All subsequent elements must be shifted to the left to fill the gap. Returns the removed element. Throws an IndexOutOfBoundsException if the index is invalid.
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        T removedElement = data[index];
        
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        
        data[size - 1] = null;
        size--;
        
        return removedElement;
    }
    
    //Returns the number of elements in the list.
    public int size() {
        return size;
    }
    
    //a private resize() method that creates a new array with double the capacity of the old one and copies the elements over.*
    private void resize() {
        int newCapacity = data.length * 2;
        T[] newData = (T[]) new Object[newCapacity];
        
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        
        data = newData;
    }
    
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]).append(", ");
        }
        
        sb.append(data[size - 1]).append("]");
        return sb.toString();
    }
}
