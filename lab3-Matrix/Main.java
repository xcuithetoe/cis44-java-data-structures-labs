public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== Testing Matrix Class\n");
        
        Matrix m1 = new Matrix(2, 3);
        m1.populateRandom();
        System.out.println("Matrix 1 (2x3):");
        System.out.println(m1);
        
        Matrix m2 = new Matrix(2, 3);
        m2.populateRandom();
        System.out.println("\nMatrix 2 (2x3):");
        System.out.println(m2);
        
        Matrix sum = m1.add(m2);
        System.out.println("\nSum of matrices:");
        System.out.println(sum);
        
        System.out.println("\n=== Testing Multiplication\n");
        
        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(3, 2);
        
        a.populateRandom();
        b.populateRandom();
        
        System.out.println("Matrix A (2x3):");
        System.out.println(a);
        System.out.println("Matrix B (3x2):");
        System.out.println(b);
        
        Matrix product = a.multiply(b);
        System.out.println("\nProduct A x B (2x2):");
        System.out.println(product);
        
        System.out.println("\n=== Testing Constructor with 2D Array\n");
        
        int[][] arrayData = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        
        Matrix m3 = new Matrix(arrayData);
        System.out.println("Matrix from 2D array:");
        System.out.println(m3);
        
        System.out.println("\n=== Testing exceptions\n");
        
        try {
            Matrix wr1 = new Matrix(2, 2);
            wr1.populateRandom();
            System.out.println("\nTrying to add incompatible matrices:");
            m1.add(wr1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            System.out.println("\nTrying to multiply incompatible matrices:");
            a.multiply(m1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nDone!!!");
    }
}
