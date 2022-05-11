package PlayerInformation;

import java.util.ArrayList;

import Tools.Printer;

public class Inventory {

    ArrayList<String> inventory = new ArrayList<String>(30); 

    public Inventory() {
        inventory.add("item1");
        inventory.add("item2");
        inventory.add("item3");
        inventory.add("item4");
        inventory.add("item5");
    }   
    
    /**
     * 
     * @param newItems - the new items the player collected, and wants added 
     */
    public void inventoryAdd(int newItems) {

    }

    public void showInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            Printer.print("[" + i + "]" + inventory.get(i) + " | " );
        }
    }



    


}
