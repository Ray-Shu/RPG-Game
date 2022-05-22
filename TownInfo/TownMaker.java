package TownInfo;

import PlayerInformation.*;
import fightInfo.MobSummoner;


/**
 * This class builds all of the towns and make them run
 */
public class TownMaker{

    private Bank playerAccount;
    private String notStoreItems[] = new String[2];
    private double notStorePrices[] = new double[2];
    private Town slums, antarcticDomain;
    private int currentTownLevel = 1;
    private int maxTownLevel = 1;

    
    private String[] thingsToDoAtHospital = {"Get healed", "leave"};
	private Stats playerStats;
	private Player player;


    private String[] slumBossDialog = {"VERY IMPRESSIVE VERY IMPRESSIVE!!! BEEP",
    "CHALLENGER HAS MANAGED TO MAKE IT ALL THE WAY TO FIGHT ME!!! BEEP", 
    "TOO BAD CHALLENGER WILL NOT BEAT ME!!! BEEEEEEP!!!"};
    private int[] slumDungeonGoldPerFloor = {200,300,400,1200};
    private int[] slumDungeonXPperFloor = {100,200,300,450};


    private String[] slumDungeonMobsFloor1 = {"Cyber Punk", "Cyber Punk", "Nano Bot Cluster"};
    private int[] slumDungeonFloor1MobLevels = {10,10,10};
    private String[] slumDungeonMobsFloor2 = {"Cyber Punk", "Nano Bot Cluster", "Greater Will Assassin"};
    private int[] slumDungeonFloor2MobLevels = {10,10,10};
    private String[] slumDungeonMobsFloor3 = {"Nano Bot Cluster", "Nano Bot Cluster", "Greater Will Assassin"};
    private int[] slumDungeonFloor3MobLevels = {10,10,10};
    private String slumBossName = "Warden of Dirt";
    private int slumBossLevel = 10;

    private int slumDungeonRecommendedLevel = (10);
    private int slumDungeonRequiredLevel = (6);
    
    private Dungeon slumDungeon;
    private String teleporterName = "Teleportation Circle";
    private Town[] allTowns = {slums, antarcticDomain};
    


    /**
     * Constructs the townmaker by giving the player's account, stats, and their identity. 
     * 
     * @param player - The player
     */
    public TownMaker(Player player){
        playerAccount = player.getBank();
        this.player = player;
        playerStats = player.getPlayerStats();
    }
    
    /**
     * Constructs all of the buildings within the town of slums
     */
    public void makeTowns(){
        slums = new Town("The Slums", 1, player, "grey");
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        slumDungeon = new Dungeon(slumDungeonMobsFloor1, slumDungeonFloor1MobLevels, slumDungeonFloor2MobLevels, slumDungeonMobsFloor2, slumDungeonFloor3MobLevels, slumDungeonMobsFloor3, slumBossName, slumBossLevel, slumBossDialog, slumDungeonGoldPerFloor, slumDungeonXPperFloor, slumDungeonRecommendedLevel, slumDungeonRequiredLevel, player, slums, "purple");
        Guild slumsAdventurersGuild = new Guild(player);
        slums.addGuild(slumsAdventurersGuild);
        slums.addDungeon(slumDungeon);

        antarcticDomain = new Town("The Antarctic Domain", 2, player,"blue");
        // antarcticDomain.addBuilding(player, playerStats, playerAccount, itemsForSale, priceOfItem, shopName, thingsToDo, greeting, farewell, errorMessage, color);
    }

    //runs the slums. 
    //This is temporary. 
    public void runSlums(){
        slums.characterEnteringTown(true);
    }

    /**
     */
    public Town getCurrentTown(){
        switch (currentTownLevel){
            case 1:
                return slums;
            case 2: 
                return antarcticDomain;
            default: 
                return slums;
        }
    }

    //gives the current town level
    public int getCurrentTownLevel(){return currentTownLevel;}
    
    //increments the max town level
    public void increaseMaxTownLevel(){maxTownLevel++;}

    //Decreases the current town level
    public void decreaseCurrentTownLevel(){maxTownLevel++;}

    //Increases the current town level
    public void increaseCurrentTownLevel(){currentTownLevel++;}

    public int getMaxTownLevel(){return maxTownLevel;}

    /**
     * Adds a building to the town
     * @param town      - the town that the building is going to be added to
     * @param merchant  - the merchant that the town will have
     */
    public void addBuildingToTown(Town town, Merchant merchant){
        town.addMerchant(merchant);
    }
}