import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 


public class Inventory { 
     private List<Item> items; 
     public Inventory() { 
         this.items = new ArrayList<>(); 
     } 
     public void addItem(Item item) {
        items.add(item);
     } 

     public void display() {
        // Since I'm not adding/removing items, a standard for-each loop is sufficient
        System.out.print(" - ");
        for (Item item : items) {
            System.out.print(item.getName() + " - ");
        }
        System.out.println();
     } 

     public void combineItems(String name1, String name2) { 
            boolean found1 = false; 
            boolean found2 = false; 

            Iterator<Item> iter = items.iterator(); 

            // First pass: make sure both name1 and name 2 exist within the list. 
            while (iter.hasNext()) { 
                Item current = iter.next(); 
                if (current.getName().equals(name1)) { 
                    found1 = true;
                } else if (current.getName().equals(name2)) { 
                    found2 = true;
                } 
            } 

            // Second pass: delete name1 and name 2 if the BOTH exist within the list. 
    
            iter = items.iterator(); // iterator must be re-created to reset at the beginning
            if (found1 && found2) {
                while (iter.hasNext()) { 
                    Item current = iter.next(); 
                    if (current.getName().equals(name1)) { 
                        found1 = true;
                        iter.remove(); 
                    } else if (current.getName().equals(name2)) { 
                        found2 = true;
                        iter.remove(); 
                    } 
                } 

                // Now, after the iterator loop finishes, I can add the new item.
                Item new_item = new Item(name1 + " " + name2);
                this.addItem(new_item);
            }

        } 
}