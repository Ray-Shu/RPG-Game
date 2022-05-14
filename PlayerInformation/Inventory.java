package PlayerInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; 

import Tools.Printer;

public class Inventory {
    String headPiece; 
    String chestPiece; 
    String legPiece; 
    String boots; 

    int addedStorage; 
    int storageUsed; 
    int maxStorage = 5; 

    ArrayList<String> playerInventory = new ArrayList<String>(maxStorage); 

    public Inventory() { 
        
        //Armours armour = new Armours();
    }   

    public void addInventory(ArrayList<String> itemsToAdd) {
        playerInventory.addAll(itemsToAdd);
        
        if(playerInventory.size() > maxStorage){ 
            int extraSpace = playerInventory.size() - maxStorage; 
            int n = extraSpace;

            Printer.printColor("Inventory is full.", "red");

            for (int i = 0; i < n; i++){
                Printer.printColor("The item " + playerInventory.get(playerInventory.size() - extraSpace) + " is unable to be put into your inventory.","red");
                playerInventory.remove(playerInventory.size() - extraSpace); 
                
                extraSpace--; 
            }
            
        }
    }

    public int storageUpgrade() {
        maxStorage += 5; 
        return maxStorage; 
    }
    
    /**
     * 
     * @param newItems - the new items the player collected, and wants added 
     */
    public void playerInventoryAddEquippedArmour(String headPiece, String chestPiece, String legPiece, String boots) {
        this.headPiece = headPiece; 
        this.chestPiece = chestPiece; 
        this.legPiece = legPiece; 
        this.boots = boots;
    }

    public void showInventory() {

        //*Displays armours 
        String armour[] = {headPiece, chestPiece, legPiece, boots}; 
        Printer.printColor("\nArmour\n-------------------------------------------------------------\n", "yellow");
        for (String armourPiece : armour) {
            if(armourPiece == null) {
                Printer.print("Empty");
                System.out.println();
            } else {
                Printer.print(armourPiece);
                System.out.println();
            }
        }
        Printer.printColor("-------------------------------------------------------------","yellow");

        System.out.println();  


        ArrayList<String> sortedInventory = new ArrayList<String>(playerInventory);  
        //* Sorts the arraylist into alphabetical order
        Collections.sort(sortedInventory, String.CASE_INSENSITIVE_ORDER);

        Printer.printColor("\nItems\n--------------------------------------------------------------------------------------------------------------------------------","yellow");
        //*Displays items in your inventory, to the side of you armours
        for (int i = 0; i < sortedInventory.size(); i++) {
            if( i != 0 && i < sortedInventory.size()) {
                System.out.print(" | ");
            }
            System.out.print("[" + (i+1) + "] " + sortedInventory.get(i));
            storageUsed++; 
            
        } 
        Printer.print("\n\n[" + storageUsed + "]" + "/" + "[" + maxStorage + "]"); 

        Printer.printColor("--------------------------------------------------------------------------------------------------------------------------------","yellow");

        Printer.printColor("\n\n[E] Exit Inventory","yellow");

        

        
    }



    


}
