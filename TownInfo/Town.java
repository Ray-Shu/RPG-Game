package TownInfo;

import java.util.ArrayList;
import PlayerInformation.*;
import Tools.*;

public class Town {
    //* Variables that we will need during this code 

    //this array list will be filled with the names of all the shops in the town. 
    ArrayList<String> namesOfThingsInTown = new ArrayList<String>();
    Merchant bank, hospital, shop;
    ArrayList<Merchant> allMerchants = new ArrayList<Merchant>();
    String townName;
    Bank playerAccount;
    int floorLvl;
    Guild guild;
    // * INFORMATION REGARDING WHAT EACH STORE WILL CONTAIN
    //TODO: Must make actual stores later, and customizability to make it so not every town is the same.


    /**
     * This is the creation of the town. It sets up all the merchants, links up banking, and gets all the
     * information needed to run a town, such as its name and floor level
     * @param townName this is the name of the town. Higher the level, the higher the prestigious town title. 
     * @param floorLvl this is the level of the society. Higher, the more prestigious. 
     * @param playerAccount this is the players bank account
     */
    Town(String townName, int floorLvl, Bank playerAccount) {

        //we need to pass through the players account information so that we can have a single constant account throughout 
        //all of the classes
        this.playerAccount = playerAccount;
        this.townName = townName;
        this.floorLvl = floorLvl;
    }

    /**
     * Shows a list of all the buildings plus the guilds
     */
    public void showBuildings(){
        allMerchants.forEach((e) -> {
            System.out.println(e.shopName);  
        });
        System.out.println(townName + " Adventurers Guild");
    }

    //@return's the name of the townn
    public String getTownName(){return townName;}

    //adds a new building to the town. 
    public void addBuilding(Player player, Stats playerStats, Bank playerAccount, String[] itemsForSale, double[] priceOfItem, String shopName, String[] thingsToDo, String greeting, String farewell, String errorMessage, String color){
        allMerchants.add(new Merchant(player, playerStats, playerAccount, this, itemsForSale, priceOfItem, shopName, thingsToDo, greeting, farewell, errorMessage, color));
        namesOfThingsInTown.add(shopName);
    }

    //adds a guild to the town. 
    public void addGuild(Guild guild){
        this.guild = guild;
        namesOfThingsInTown.add(townName + " Adventurers Guild");
    }

    public void addDungeon(){

    }


    public void characterEnteringTown() {

        // welcomes the character to town
        Printer.printColor("Welcome to " + townName + ", traveler on floor " + floorLvl + "!\n"
            + "Here is a brochure with all you can do here! \n","blue");
        
        showBuildings();
        Printer.printColor("\n" + "Where do you want to go?", "blue");

        // gets them to enter a shop name as to where they want to go, and then runs
        // that shop.
        String whereMerchantWantsToGO = ErrorChecker.compareArrayOfStrings(namesOfThingsInTown.toArray(new String[namesOfThingsInTown.size()]), 
                    "Sorry could you repeat that?", "blue");
            
        //once we have a value, we let them shop at one of the places they asked for. 
        //this checks which name of the shop they entered, then sends them in. 
        allMerchants.forEach((e) -> {
            if (whereMerchantWantsToGO.equalsIgnoreCase(e.getShopName())) {
                e.shop();
                return;
            }
        });
        if(whereMerchantWantsToGO.equalsIgnoreCase(townName + " Adventurers Guild")){
            guild.runGuild();
        }
    }

    //runs Hospital
    public void runHospital(){
        allMerchants.forEach((e) -> {
            if(e.shopName.equalsIgnoreCase("Hospital")){
                e.shop();
                return;
            }
        });
    }
}
