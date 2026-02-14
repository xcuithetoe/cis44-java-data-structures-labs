/*
 Create a class named Matrix.java.
The class must have a private instance variable: private int[][] data;.
Implement the following public methods:
public Matrix(int rows, int cols): Constructor that initializes the matrix with the given dimensions.
public Matrix(int[][] data): Constructor that initializes the matrix with a pre-existing 2D array.
public void populateRandom(): Fills the matrix with random integer values between 1 and 10.
public Matrix add(Matrix other): Adds this matrix to another matrix. Challenge: If the matrices do not have the same dimensions, this method must throw an IllegalArgumentException. Returns a new Matrix object that is the sum of the two.
public Matrix multiply(Matrix other): Multiplies this matrix by another matrix. Challenge: If the number of columns in this matrix does not equal the number of rows in the other matrix, throw an IllegalArgumentException. Returns a new Matrix object that is the product.
@Override public String toString(): Returns a string representation of the matrix, formatted in rows and columns.*
 */



public class Matrix
{
    
    // The class must have a private instance variable: private int[][] data;.
    private int[][] data;
    
    //Constructor that initializes the matrix with the given dimensions.
    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }
    
    // Constructor that initializes the matrix with a pre-existing 2D array.
    public Matrix(int[][] data) {
        System.out.println("copy constructor\n");
        this.data = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }
    
    //Fills the matrix with random integer values between 1 and 10.
    public void populateRandom()
    {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                int r = (int)(Math.random() * 10) + 1;
                //System.out.println("random " + r);
                data[i][j] = r;
            }
        }
    }
    
    //   Adds this matrix to another matrix. Challenge: If the matrices do not have the same dimensions, this method must throw an IllegalArgumentException. Returns a new Matrix object that is the sum of the two.
    public Matrix add(Matrix other) {
        if (this.data.length != other.data.length || this.data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices must have same dimensions for addition");
        }
        
        Matrix result = new Matrix(data.length, data[0].length);

        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        
        return result;
    }
    
    //Multiplies this matrix by another matrix. Challenge: If the number of columns in this matrix does not equal the number of rows in the other matrix, throw an IllegalArgumentException. Returns a new Matrix object that is the product.
    public Matrix multiply(Matrix other) {
        if (this.data[0].length != other.data.length) {
            throw new IllegalArgumentException("Number of columns in first matrix must equal number of rows in second matrix");
        }
        
        Matrix result = new Matrix(this.data.length, other.data[0].length);
        
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < other.data[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < this.data[0].length; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                //System.out.println("sum " + sum);

                result.data[i][j] = sum;
            }
        }
        
        return result;
    }
    
    //Returns a string representation of the matrix, formatted in rows and columns.*

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                sb.append(data[i][j]);
                if (j < data[0].length - 1) {
                    sb.append(" ");
                }
            }
            if (i < data.length - 1) {
                sb.append("\n");
            }
        }
        
        return sb.toString();
    }
}
