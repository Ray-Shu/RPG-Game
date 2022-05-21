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

    private String slumBankName = "Broken Bank";
    private String[] thingsToDoInSlumBank = {"withdraw", "view balance", "leave"};
    private String greeting4SlumBank = "Welcome to the broken bank! How can I help you?";
    private String farewell4SlumBank = "Adios!";
    private String error4SlumBank = "Please repeat that";
    private String colorOfSlumBank = "grey";
    
    private String[] thingsToDoAtHospital = {"Get healed", "leave"};
	private Stats playerStats;
	private Player player;


    private String slumArmouryName = "Slums Armoury";
    private String[] thingsToDoInSlumArmoury = {"Buy", "leave"};
    private String[] slumArmouryItems = {};
    private int[] slumArmouryPrices = {};
    private String greeting4SlumArmoury = "Welcome to the armoury! How may I help you?";
    private String farewell4SlumArmoury = "Please never come again!";
    private String error4SlumArmoury = "Please repeat that";
    private String colorOfSlumArmoury = "cyan";

    //* This is all very temporary, and just for dungeon testing. 
    private String[] slumDungeonMobs = {"Cyber Punk", "Nano Bot Cluster", "Greater Will Assasin", "Warden Of Dirt"};
    private String[] slumBossDialog = {"VERY IMPRESSIVE VERY IMPRESSIVE!!! BEEP",
        "CHALLENGER HAS MANAGED TO MAKE IT ALL THE WAY TO FIGHT ME!!! BEEP", 
        "TOO BAD CHALLENGER WILL NOT BEAT ME!!!"};
    private int[] slumDungeonGoldPerMob = {200,300,400,1200};
    private int[] slumDungeonXPperMob = {100,200,300,450};
    private int[] slumDungeonMobLevels = {10,10,11,12};
    private int slumDungeonRecommendedLevel = (10);
    private int slumDungeonRequiredLevel = (6);
    private Town slumsTown = getCurrentTown();
    
    private Dungeon slumDungeon = new Dungeon(slumDungeonMobs, slumBossDialog, slumDungeonGoldPerMob, slumDungeonXPperMob, slumDungeonMobLevels, slumDungeonRecommendedLevel, slumDungeonRequiredLevel, player, slumsTown, "purple");

    private String teleporterName = "Teleportation Circle";
    private Town[] allTowns = {slums};
    


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
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, slumBankName, thingsToDoInSlumBank, greeting4SlumBank, farewell4SlumBank, error4SlumBank, colorOfSlumBank);
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
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
     * TODO: make multiple towns, and then when we call this method, it will move us to that town. 
     */
    public Town getCurrentTown(){
        switch (currentTownLevel){
            case 1:
                return slums;
            case 2: 

                

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

}