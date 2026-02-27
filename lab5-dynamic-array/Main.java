public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // create and add some initial items. I'll pretend the adventure game is Minecraft!

        // ideally these become "Diamond Pickaxe"
        Item diamond = new Item("Diamond");
        Item pickaxe = new Item("Pickaxe"); 

        Item dragon = new Item("Dragon");
        Item apple = new Item("Apple");
        Item leather = new Item("Leather");
        Item boots = new Item("Boots");

        inventory.addItem(diamond);       
        inventory.addItem(dragon);       
        inventory.addItem(apple);    
        inventory.addItem(leather);       
        inventory.addItem(pickaxe);  
        inventory.addItem(boots);

        // Display initial inventory
        System.out.print("Initial inventory: ");
        inventory.display();
        
        // Combine diamond and pickaxe to create a diamond pickaxe
        inventory.combineItems("Diamond", "Pickaxe");

        // Display final inventory
        System.out.print("Final inventory: ");
        inventory.display();

    }
}
