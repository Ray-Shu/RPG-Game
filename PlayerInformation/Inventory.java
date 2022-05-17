package PlayerInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Tools.ErrorChecker;
import Tools.Printer;

public class Inventory {

    Player mainPlayer;
    Stats playerStats; 

    String headPiece; 
    String chestPiece; 
    String legPiece; 
    String boots; 

    int addedStorage; 
    int storageUsed; 
    int maxStorage = 5; 

    Scanner in = new Scanner(System.in);

    ArrayList<String> playerInventory = new ArrayList<String>(maxStorage); 
    ArrayList<String> categorizedInventory = new ArrayList<String>();

    String[] inventoryChoice = {"1", "2", "3", "4", "e"}; 


    String[] healingPots = {"Strong Healing Potion", "Healing Potion", "Weak Healing Potion"}; 

    public Inventory() { 
        //Armours armour = new Armours();
    }   

    public void createInventory(Stats playerStats){
        this.playerStats = playerStats; 

        categorizedInventory.add("Healing Potions");
        categorizedInventory.add("Mana Elixirs");
        categorizedInventory.add("Revivals");
        categorizedInventory.add("Misc Potions");

        // TODO: add more necessities
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

    //Displays the inventory
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


        //ArrayList<String> sortedInventory = new ArrayList<String>(playerInventory);  
        // //* Sorts the arraylist into alphabetical order
        // Collections.sort(sortedInventory, String.CASE_INSENSITIVE_ORDER);

        // Printer.printColor("\nItems\n--------------------------------------------------------------------------------------------------------------------------------","yellow");
        // //*Displays items in your inventory, to the side of you armours
        // for (int i = 0; i < sortedInventory.size(); i++) {
        //     if( i != 0 && i < sortedInventory.size()) {
        //         System.out.print(" | ");
        //     }
        //     System.out.print("[" + (i+1) + "] " + sortedInventory.get(i));
        //     storageUsed++; 
            
        // } 
        // Printer.print("\n\n[" + storageUsed + "]" + "/" + "[" + maxStorage + "]"); 

        // Printer.printColor("--------------------------------------------------------------------------------------------------------------------------------","yellow");

        // Printer.printColor("\n\n[E] Exit Inventory","yellow");

        // in.nextLine(); 
        

        Printer.printColor("\nItems\n--------------------------------------------------------------------------------------------------------------------------------\n","yellow");
        for (int i = 0; i < categorizedInventory.size(); i++) {
            if (i != 0 && i < categorizedInventory.size()) { 
                System.out.print(" | ");
            }
            System.out.print("[" + (i+1) + "] " + categorizedInventory.get(i));


        }
        Printer.printColor("\n\n--------------------------------------------------------------------------------------------------------------------------------","yellow");
        Printer.printColor("\n\n[E] Exit Inventory\n","yellow");

        String inventoryOptions = ErrorChecker.compareArrayOfStrings(inventoryChoice, "Choose a proper input.", "white");

        switch(inventoryOptions.toLowerCase()){
            case "1": 
                healingPotionsList(); 
                break; 

            case "2":
                manaElixirList(); 
                break; 
            
            case "3": 
                revivalsList(); 
                break; 

            case "4": 
                miscPotionsList(); 
                break; 

            case "e": 
                return; 
        }
    }

    //a list of healing potions 
    public void healingPotionsList() {
        for (int i = 0; i < healingPots.length; i++) {
            System.out.println(healingPots[i]);
        }   
        Printer.printColor("\n[B] Go back", "yellow");

        String[] chooseOption = {"1", "2", "3", "b"};
        
        String option = ErrorChecker.compareArrayOfStrings(chooseOption, "Choose a proper input", "white"); 

        switch(option.toLowerCase()) {
            case "1": 
                break; 

            case "2": 
                break; 

            case "3": 
                break; 
            
            case "b": 
                showInventory(); 
        }


        //heals 100% of health 
        //heals 50% of health 
        //heals 25% of health 
    }

    //a list of mana potions
    public void manaElixirList() {
        System.out.println("show mana");
        //restores 100% of mana
        //restores 50% of mana
        //restores 25% of mana 
    }

    //a list of revivals 
    public void revivalsList() {
        System.out.println("show revivals");
        //just have one item that can cheat one death 
    }

    //a list misc potions() 
    public void miscPotionsList() {
        System.out.println("misc potions");
        //luck potions
        //crit damage potions
        //crit rate potions
        //extra gold potions 
    }






    


}
