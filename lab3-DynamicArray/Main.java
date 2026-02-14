public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== Testing DynamicArray\n");
        
        DynamicArray<String> names = new DynamicArray<>();
        
        names.add("A");
        names.add("B");
        names.add("C");
        
        System.out.println("Size: " + names.size());
        System.out.println("Element at index 1: " + names.get(1));
        System.out.println("All elements: " + names);
        
        String removed = names.remove(1);
        System.out.println("\nRemoved: " + removed);
        System.out.println("New size: " + names.size());
        System.out.println("after removal: " + names);
        
        System.out.println("\n=== Testing Resize");
        
        DynamicArray<Integer> numbers = new DynamicArray<>();
        
        for (int i = 0; i < 15; i++) {
            numbers.add(i);
        }
        
        System.out.println("Added 15 numbers");
        System.out.println("Size: " + numbers.size());
        System.out.println("Numbers: " + numbers);
        
        System.out.println("\n=== Testing Exceptions");
        
        try {
            names.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("get error: " + e.getMessage());
        }

        try {
            names.remove(10000);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("remove error: " + e.getMessage());
        }

        
        System.out.println("\nDone!!!!!!");
    }
}
