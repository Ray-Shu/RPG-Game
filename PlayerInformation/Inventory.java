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

    //*POTION STUFF
    int howManyGreaterHealingPots = 0; 
    int howManyHealingPots = 0; 
    int howManyWeakHealingPots = 0; 

    int howManyGreaterManaPots = 0;
    int howManyManaPots = 0;
    int howManyWeakManaPots = 0;

    private Armours armours; 

    Scanner in = new Scanner(System.in);

    ArrayList<String> playerInventory = new ArrayList<String>(maxStorage); 
    ArrayList<String> categorizedInventory = new ArrayList<String>();

    String[] inventoryChoice = {"1", "2", "3", "4", "e"}; 
    String[] healingPots = {"Strong Healing Potion", "Healing Potion", "Weak Healing Potion"}; 

    public Inventory(Stats playerStats) {
        this.playerStats = playerStats;

        categorizedInventory.add("Healing Potions");
        categorizedInventory.add("Mana Elixirs");
        categorizedInventory.add("Revivals");
        categorizedInventory.add("Misc Potions");
        // TODO: add more necessities
    }   

    public void addInventory(ArrayList<String> itemsToAdd) {
        playerInventory.addAll(itemsToAdd);

        String[] items = itemsToAdd.toArray(new String[itemsToAdd.size()]);

        for(int i = 0; i < items.length; i++){
            if (items[i].equals("Greater Healing Pots")) {
                howManyGreaterHealingPots++;
            } 
            if (items[i].equals("Healing Pots")) {
                howManyHealingPots++;
            }
            if (items[i].equals("Weak Healing Pots")) {
                howManyWeakHealingPots++;
            }
            if (items[i].equals("Greater Mana Pots")) {
                howManyGreaterManaPots++;
            }
            if (items[i].equals("Mana Pots")) {
                howManyManaPots++;
            }
            if (items[i].equals("Weak Mana Pots")) {
                howManyWeakManaPots++;
            }
        }
        
        
    }
    
    //displays the armour; referenced from 'armours' class
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


       

        Printer.printColor("\nItems\n------------------------------------------------------------------------------\n","yellow");
        for (int i = 0; i < categorizedInventory.size(); i++) {
            if (i != 0 && i < categorizedInventory.size()) { 
                System.out.print(" | ");
            }
            System.out.print("[" + (i+1) + "] " + categorizedInventory.get(i));


        }
        Printer.printColor("\n\n------------------------------------------------------------------------------","yellow");
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
        //Prints out the amount of each type of healing pot
        Printer.printColor("Which healing pot would you like to consume?", "white");
        Printer.printColor("[1]     " + "[" + howManyGreaterHealingPots + "] Greater Healing pots", "white");
        Printer.printColor("[2]     " + "[" + howManyHealingPots + "] Healing pots", "white");
        Printer.printColor("[3]     " + "[" + howManyWeakHealingPots + "] Weak Healing pots", "white");

        Printer.printColor("\n[B] Go back", "yellow");

        String[] chooseOption = {"1", "2", "3", "b"};
        
        String option = ErrorChecker.compareArrayOfStrings(chooseOption, "Choose a proper input", "white"); 

        switch(option.toLowerCase()) {
            //heals 70%, 40%, 20% respectively 
            case "1": 
                if(howManyGreaterHealingPots > 0) {
                    playerStats.setCurrentHP(playerStats.getCurrentHP() + (playerStats.getMaxHP() * 0.7));
                    howManyGreaterHealingPots--; 
                    Printer.printColor("You have healed to " + playerStats.getCurrentHP() + " HP!", "yellow");
                    showInventory();
                } else {
                    Printer.printColor("You don't have any Greater Healing Pots.", "red");
                    showInventory();
                }
                break; 

            case "2": 
                if (howManyHealingPots > 0) {
                    playerStats.setCurrentHP(playerStats.getCurrentHP() + (playerStats.getMaxHP() * 0.4));
                    howManyHealingPots--;
                    Printer.printColor("You have healed to " + playerStats.getCurrentHP() + " HP!", "yellow");
                    showInventory();
                } else {
                    Printer.printColor("You don't have any Healing Pots.", "red");
                    showInventory();
                }
                break; 

            case "3": 
                if (howManyWeakHealingPots > 0) {
                    playerStats.setCurrentHP(playerStats.getCurrentHP() + (playerStats.getMaxHP() * 0.20));
                    howManyWeakHealingPots--;
                    Printer.printColor("You have healed to " + playerStats.getCurrentHP() + " HP!", "yellow");
                    showInventory();
                } else {
                    Printer.printColor("You don't have any Weak Healing Pots.", "red");
                    showInventory();
                }
                break; 
            
            case "b": 
                showInventory(); 
        }
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


    //*SOME UNUSED STUFF

        
        // ArrayList<String> sortedInventory = new ArrayList<String>(playerInventory);
        // //* Sorts the arraylist into alphabetical order
        // Collections.sort(sortedInventory, String.CASE_INSENSITIVE_ORDER);

        // Printer.printColor("\nItems\n--------------------------------------------------------------------------------------------------------------------------------","yellow");
        // //*Displays items in your inventory, to the side of you armours
        // for (int i = 0; i < sortedInventory.size(); i++) {
        // if( i != 0 && i < sortedInventory.size()) {
        // System.out.print(" | ");
        // }
        // System.out.print("[" + (i+1) + "] " + sortedInventory.get(i));
        // storageUsed++;

        // }
        // Printer.print("\n\n[" + storageUsed + "]" + "/" + "[" + maxStorage + "]");

        // Printer.printColor("--------------------------------------------------------------------------------------------------------------------------------","yellow");

        // Printer.printColor("\n\n[E] Exit Inventory","yellow");

        // in.nextLine();


        //*MAXED STORAGE THING
        // if(playerInventory.size() > maxStorage){
        // int extraSpace = playerInventory.size() - maxStorage;
        // int n = extraSpace;

        // Printer.printColor("Inventory is full.", "red");

        // for (int i = 0; i < n; i++){
        // Printer.printColor("The item " + playerInventory.get(playerInventory.size() -
        // extraSpace) + " is unable to be put into your inventory.","red");
        // playerInventory.remove(playerInventory.size() - extraSpace);

        // extraSpace--;
        // }

        // }


}
