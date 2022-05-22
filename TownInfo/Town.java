package TownInfo;

import java.util.ArrayList;
import java.util.Scanner;

import PlayerInformation.*;
import Tools.*;

public class Town {
    //* Variables that we will need during this code 

    //this array list will be filled with the names of all the shops in the town. 
    private ArrayList<String> namesOfThingsInTown = new ArrayList<String>();
    private ArrayList<Merchant> allMerchants = new ArrayList<Merchant>();
    private String townName;
    private int floorLvl;
    private Guild guild;
	private String color;
    //TODO: Finish making comments
    private Player player;
    private Dungeon dungeon;
    private Scanner scan = new Scanner(System.in);

    /**
     * This is the creation of the town. It sets up all the merchants, links up banking, and gets all the
     * information needed to run a town, such as its name and floor level
     * @param townName this is the name of the town. Higher the level, the higher the prestigious town title. 
     * @param floorLvl this is the level of the society. Higher, the more prestigious. 
     * @param playerAccount this is the players bank account
     */
    Town(String townName, int floorLvl, Player player, String color) {

        //we need to pass through the players account information so that we can have a single constant account throughout 
        //all of the classes
        this.player = player;
        this.townName = townName;
        this.floorLvl = floorLvl;
        this.color =  color;
    }

    /**
     * Shows a list of all the buildings plus the guilds
     */
    public void showBuildings(){
        int i = 1;
        for (i = 1; i <= allMerchants.size(); i++) {
            Printer.printColor("("+i+") " + allMerchants.get(i-1).shopName, "white");  
        }
        Printer.printColor("("+i+") " + townName + " Adventurers Guild", "white");  
        
        i++;
        if(dungeon.isLocked()){
            Printer.printColor("("+i+") [Locked]"+ townName + " Dungeon", "grey");
        }
        else{
            Printer.printColor("("+i+") "+ townName + " Dungeon", "white");
        }
    }

    //gets townName
    public String getTownName(){return townName;}

    //adds a new building to the town. 
    public void addBuilding(Player player, Stats playerStats, Bank playerAccount, String[] itemsForSale, double[] priceOfItem, String shopName, String[] thingsToDo, String greeting, String farewell, String errorMessage, String color){
        allMerchants.add(new Merchant(player, this, itemsForSale, priceOfItem, shopName,
                thingsToDo, greeting, farewell, errorMessage, color));
        namesOfThingsInTown.add(shopName);
    }

    //adds a guild to the town. 
    public void addGuild(Guild guild){
        this.guild = guild;
        namesOfThingsInTown.add(townName + " Adventurers Guild");
    }
    
    public Guild getGuild(){
        return guild;
    }
    public void addDungeon(Dungeon dungeon){
        this.dungeon = dungeon;
        namesOfThingsInTown.add("dungeon");
    }

    /**
     * The player moves into the town, so we welcome them, and show them all of the buildings
     */
    public void characterEnteringTown(boolean returnToStory) {

        // welcomes the character to town
        System.out.println("-----------------------------------------------------------");
        Printer.printColor("Here is a map of " + townName +" with all you can do here! \n", color);
        
        showBuildings();
        Printer.printColor("\n" + "Where would you like to visit?", color);

        // gets them to enter a shop name as to where they want to go, and then runs
        // that shop.
        int chosenInt;
        boolean hasPlayerChosen = false;
        do {
            while(!scan.hasNextInt()){
                Printer.printColor("Please enter an integer!", "red");
                scan.next();
            }
            chosenInt = scan.nextInt();
            if(chosenInt > 0 && chosenInt <= (allMerchants.size()+2)){
                hasPlayerChosen = true;
            }
            else{
                Printer.printColor("Please enter a valid number!", "grey");;
            }
        } while (hasPlayerChosen == false);

        hasPlayerChosen = false;
        //once we have a value, we let them shop at one of the places they asked for. 
        //this checks which name of the shop they entered, then sends them in. 
        if(chosenInt <= allMerchants.size()){
            allMerchants.get((chosenInt-1)).shop(true);
        }

        //checks if they want to run the guild
        else if(chosenInt == allMerchants.size() + 1 ){
        guild.runGuild(returnToStory);
        }
        else if(dungeon.isLocked()){
            Printer.printColor("Sorry! You do not meet the required level for this dungeon!\nPlease come back once you reach level " + dungeon.getRequiredLevel(),"white");
            Printer.quickBreak(1000);
            characterEnteringTown(returnToStory);
        }
        else{
            dungeon.characterEnteringDungeon(returnToStory);
        }
    }

    /**
     * Locates the hospital within the town before sending the player there. 
     * To be used when the player dies. 
     */
    public void playerNeedsHospital(){

        allMerchants.forEach((e) -> {

            if(e.shopName.equalsIgnoreCase("Hospital")){
                e.playerDiedWakeup();
                return;
            }

        });

    }
}
