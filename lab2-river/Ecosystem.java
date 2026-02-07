import java.util.Random;

// Step 1: Create the abstract parent class
abstract class Animal {
    // You can add shared attributes or methods here if needed
    // An abstract method for toString() can be helpful for visualization
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        // You can add logic here to initially populate the river
        
        
        initialPopulate();
    }

    private void initialPopulate() {
        for (int i = 0; i < river.length; i++) {
            int r = random.nextInt(10);
            if (r < 3) {
                river[i] = new Fish();
            } else if (r == 3) {
                river[i] = new Bear();
            } else {
                river[i] = null;
            }
        }
    }

    private int pickMoveTarget(int i) {
        int move = random.nextInt(3) - 1; // -1, 0, +1
        int target = i + move;
        if (target < 0) target = 0;
        if (target >= river.length) target = river.length - 1;
        return target;
    }

    private void spawnSameTypeBaby(Animal baby, Animal[] next) {
        for (int tries = 0; tries < river.length * 2; tries++) {
            int idx = random.nextInt(river.length);
            if (next[idx] == null) {
                //System.out.println("spawned: " + baby.toString() + " @ " + idx);:w
                next[idx] = baby;
                // System.out.println("baby spawned: " + baby.toString() + " @ " + idx);
                return;
            }
        }
        for (int i = 0; i < next.length; i++) {
            if (next[i] == null) {
                next[i] = baby;
                // System.out.println("baby spawned: " + baby.toString() + " @ " + i);
                return;
            }
        }
    }

    private Animal handleCollision(Animal a, Animal b, Animal[] next) {
        // System.out.println("collision: " + a.toString() + " vs " + b.toString());
        if (a instanceof Bear && b instanceof Bear) {
            spawnSameTypeBaby(new Bear(), next);
            return a;
        }
        if (a instanceof Fish && b instanceof Fish) {
            spawnSameTypeBaby(new Fish(), next);
            return a;
        }

        if (a instanceof Bear && b instanceof Fish) return a;
        if (a instanceof Fish && b instanceof Bear) return b;

        return a;
    }

    public void runStep() {
        // This is the core logic for a single time step.
        // 1. Create a new array for the next state.
        // 2. Iterate through the current river array.
        // 3. For each animal, decide its next move.
        // 4. Handle collisions and place animals in the new array.
        // 5. Replace the old river with the new one.
        Animal[] next = new Animal[river.length];

        for (int i = 0; i < river.length; i++) {
            Animal current = river[i];
            if (current == null) continue;

            int target = pickMoveTarget(i);
            

            // System.out.println("move: " + current.toString() + " @ " + i + " -> " + target);

            if (next[target] == null) {
                next[target] = current;
            } else {
                next[target] = handleCollision(current, next[target], next);
            }
        }

        river = next;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); // Create a river of size 20
        eco.visualize();
        // Loop to run multiple steps...
        for (int step = 1; step <= 20; step++) {
            eco.runStep();
            eco.visualize();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // ignore
            }
        }
    }
}
