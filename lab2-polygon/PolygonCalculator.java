/*
Define a Polygon interface that has abstract methods area() and perimeter().
Implement concrete classes for Triangle, Quadrilateral, Pentagon, Hexagon, and Octagon. Each class should implement the Polygon interface.
Implement classes for IsoscelesTriangle, EquilateralTriangle, Rectangle, and Square. These classes must have the appropriate inheritance relationships.
Write a simple console-based user interface that allows a user to create polygons of various types, input their dimensions, and then outputs their area and perimeter.
*/

import java.util.Scanner;

// Step 1: Define the interface
interface Polygon {
    double area();
    double perimeter();
}

// Step 2: Implement a base class for a specific shape
class Triangle implements Polygon {
    double side1, side2, side3;
    
    public Triangle(double s1, double s2, double s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    
    public double area() {
        double s = (side1 + side2 + side3) / 2.0;
        // System.out.println("Triangle semi-perimeter = "+ s);
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    public double perimeter() {
        // System.out.println("Calculating perimeter for Triangle");
        return side1 + side2 + side3;
    }
}


class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
        // System.out.println("Created IsoscelesTriangle with equal sides="+ equalSide + ", base="+ base);
    }
}

// EquilateralTriangle inherits from Triangle
class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, side, side);
        // System.out.println("Created EquilateralTriangle with side="+ side);
    }
}

// Quadrilateral class
class Quadrilateral implements Polygon {
    double side1, side2, side3, side4;
    
    public Quadrilateral(double s1, double s2, double s3, double s4) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
        side4 = s4;
        // System.out.println("Created Quadrilateral with sides "+ s1 + ", "+ s2 + ", "+ s3 + ", "+ s4);
    }
    
    public double area() {
        // System.out.println("Quadrilateral area not calculable from sides alone");
        return 0; // Can't calculate without angles/diagonals
    }
    
    public double perimeter() {
        // System.out.println("Calculating perimeter for Quadrilateral");
        return side1 + side2 + side3 + side4;
    }
}

// Step 3: Create a subclass using inheritance
class Rectangle extends Quadrilateral {
    public Rectangle(double length, double width) {
        super(length, width, length, width);
        // System.out.println("Created Rectangle with length="+ length + ", width="+ width);
    }
    
    public double area() {
        // System.out.println("Calculating Rectangle area: "+ side1 + "* "+ side2);
        return side1 * side2;
    }
}

// Step 4: Create a more specific subclass
class Square extends Rectangle {
    public Square(double len) {
        super(len, len);
    }
}

// Pentagon class (regular)
class Pentagon implements Polygon {
    double side;
    
    public Pentagon(double s) {
        side = s;
    }
    
    public double area() {
        // System.out.println("Calculating Pentagon area");
        return (1.0 /      4)*Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }
    
    public double perimeter() {
        // System.out.println("Calculating Pentagon perimeter");
        return 5 * side;
    }
}


class Hexagon implements Polygon {
    double side;
    
    public Hexagon(double s) {
        side = s;
        // System.out.println("Created Hexagon with side="+ s);
    }
    
    public double area() {
        // System.out.println("Calculating Hexagon area");
        return (3.0 * Math.sqrt(3) / 2.0) * side * side;
    }
    
    public double perimeter() {
        // System.out.println("Calculating Hexagon perimeter");
        return 6 * side;
    }
}

// Octagon class (regular)
class Octagon implements Polygon {
    double side;
    
    public Octagon(double s) {
        side = s;
        // System.out.println("Created Octagon with side="+ s);
    }
    
    public double area() {
        // System.out.println("Calculating Octagon area");
        return 2.0 * (1 + Math.sqrt(2)) * side * side;
    }
    
    public double perimeter() {
        // System.out.println("Calculating Octagon perimeter");
        return 8 * side;
    }
}

// Main class for user interface
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        System.out.println("Polygon Calculator");
        System.out.println("==================");
        
        // Simple menu loop
        do {
            System.out.println("\nChoose a polygon:");
            System.out.println("1. Triangle");
            System.out.println("2. Isosceles Triangle");
            System.out.println("3. Equilateral Triangle");
            System.out.println("4. Quadrilateral");
            System.out.println("5. Rectangle");
            System.out.println("6. Square");
            System.out.println("7. Pentagon");
            System.out.println("8. Hexagon");
            System.out.println("9. Octagon");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            
            // System.out.println("User selected option "+ choice);
            
            Polygon p = null;
            
            // Create polygon based on choice
            if (choice == 1) {
                System.out.print("Enter side 1: ");
                double s1 = scanner.nextDouble();
                System.out.print("Enter side 2: ");
                double s2 = scanner.nextDouble();
                System.out.print("Enter side 3: ");
                double s3 = scanner.nextDouble();
                p = new Triangle(s1, s2, s3);
                // System.out.println("Created generic Triangle object");
            }
            else if (choice == 2) {
                System.out.print("Enter equal side length: ");
                double eq = scanner.nextDouble();
                System.out.print("Enter base length: ");
                double base = scanner.nextDouble();
                p = new IsoscelesTriangle(eq, base);
                // System.out.println("Created IsoscelesTriangle object");
            }
            else if (choice == 3) {
                System.out.print("Enter side length: ");
                double s = scanner.nextDouble();
                p = new EquilateralTriangle(s);
                // System.out.println("Created EquilateralTriangle object");
            }
            else if (choice == 4) {
                System.out.print("Enter side 1: ");
                double s1 = scanner.nextDouble();
                System.out.print("Enter side 2: ");
                double s2 = scanner.nextDouble();
                System.out.print("Enter side 3: ");
                double s3 = scanner.nextDouble();
                System.out.print("Enter side 4: ");
                double s4 = scanner.nextDouble();
                p = new Quadrilateral(s1, s2, s3, s4);
                // System.out.println("Created Quadrilateral object");
            }
            else if (choice == 5) {
                System.out.print("Enter length: ");
                double len = scanner.nextDouble();
                System.out.print("Enter width: ");
                double wid = scanner.nextDouble();
                p = new Rectangle(len, wid);
                // System.out.println("Created Rectangle object");
            }
            else if (choice == 6) {
                System.out.print("Enter side length: ");
                double s = scanner.nextDouble();
                p = new Square(s);
                // System.out.println("Created Square object");
            }
            else if (choice == 7) {
                System.out.print("Enter side length: ");
                double s = scanner.nextDouble();
                p = new Pentagon(s);
                // System.out.println("Created Pentagon object");
            }
            else if (choice == 8) {
                System.out.print("Enter side length: ");
                double s = scanner.nextDouble();
                p = new Hexagon(s);
                // System.out.println("Created Hexagon object");
            }
            else if (choice == 9) {
                System.out.print("Enter side length: ");
                double s = scanner.nextDouble();
                p = new Octagon(s);
                // System.out.println("Created Octagon object");
            }
            else if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Invalid choice!");
                continue;
            }
            
            // Display results
            System.out.println("\nResults:");
            // System.out.println("Calling area() method...");
            System.out.println("Area = "+ p.area());
            // System.out.println("Calling perimeter() method...");
            System.out.println("Perimeter = "+ p.perimeter());
            
        } while (choice != 0);
        
        scanner.close();
        // System.out.println("Scanner closed, program ending");
    }
}