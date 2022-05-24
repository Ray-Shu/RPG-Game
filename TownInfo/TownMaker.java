package TownInfo;

import PlayerInformation.*;
import fightInfo.MobSummoner;


/**
 * This class builds all of the towns and make them run
 */
public class TownMaker{

    
    //*SLUMS MERCHANT 
    private String[] slumsItemsForSale = {"Weak Healing Pots", "Weak Mana Pots"};
    private double[] slumsPriceOfItem2 = {150, 150}; 
    private String[] slumsArmour = {"Superior Spectral Armour"};
    private double[] slumsArmourPrice = {5500}; 
    private String slumsShopName = "Common Shack"; 
    private String[] slumsThingsToDo = {"Show common goods", "Show armour", "Leave"}; 
    private String slumsGreeting = "Welcome to the Common Shack! What can I do for you?"; 
    private String slumsFarewell = "Thanks for coming!"; 
    private String slumsErrorMessage = "Looks like that isn't in the store, pick something else yeah?"; 
    private Merchant slumsMerchant;

    //*ANTARCTIC DOMAIN MERCHANT
    private String[] antarcticItemsForSale = {"Healing Pots", "Mana Pots"}; 
    private double[] antarcticPriceOfItem2 = {300, 300}; 
    private String[] antarcticArmour = {"Battered Chromium Armour", "Superior Chromium Armour"};
    private double[] antarcticArmourPrice = {6000, 9000}; 
    private String antarcticShopName = "Frozen Anvil"; 
    private String[] antarcticThingsToDo = { "Show common goods", "Show armour", "Leave" };
    private String antarcticGreeting = "Ugh... Another customer? What do you want?"; 
    private String antarcticFarewell = "Thanks for your money."; 
    private String antarcticErrorMessage = "Are you blind? That ain't in the store."; 
    private Merchant antarcticMerchant; 

    //* Slum dungeon stuff
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
    private int slumBossLevel = 9;
    private int slumDungeonRecommendedLevel = (8);
    private int slumDungeonRequiredLevel = (6);
    private Dungeon slumDungeon;
    
    //*Antarctic dungeon stuff
    private String[] antarcticBossDialog = {"PREPARE YOUR SELF CHALLENGER!",
    "I WILL DESTROY YOU WITH THE AMAZINGLY POWERFUL FROST!", };
    private int[] antarcticDungeonGoldPerFloor = {1000,1500,2000,5000};
    private int[] antarcticDungeonXPperFloor = {400,500,600,1500};
    private String[] antarcticDungeonMobsFloor1 = {"Greater Will Swordsman", "Greater Will Swordsman", "Greater Will Swordsman"};
    private int[] antarcticDungeonFloor1MobLevels = {17,17,17};
    private String[] antarcticDungeonMobsFloor2 = {"Yeti", "Yeti", "Yeti"};
    private int[] antarcticDungeonFloor2MobLevels = {18,18,18};
    private String[] antarcticDungeonMobsFloor3 = {"Yeti", "Greater Will Swordsman", "Greater Will Archer"};
    private int[] antarcticDungeonFloor3MobLevels = {19,19,19};
    private String antarcticBossName = "Warden of Frost";
    private int antarcticBossLevel = 20;
    private int antarcticDungeonRecommendedLevel = (20);
    private int antarcticDungeonRequiredLevel = (15);
    private Dungeon antarcticDungeon;
    


    public final String merchantColor = "green";
    private Bank playerAccount;
    private String notStoreItems[] = new String[2];
    private double notStorePrices[] = new double[2];
    private Town slums, antarcticDomain, theFactoryRealm, landOfSilver, goldenReign;
    private int currentTownLevel = 1;
    private int maxTownLevel = 1;
    private String[] thingsToDoAtHospital = {"Get healing", "leave"};
	private Stats playerStats;
	private Player player;
    private Town[] allTowns = new Town[5];
    
    private Teleporter tp;

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

    //Returns the slums armour
    public String[] getSlumsArmour(){
        return slumsArmour;
    }

    //returns slum armour pieces
    public double[] getSlumsArmourPrices(){
        return slumsArmourPrice;
    }
    
    //Returns the slums armour
    public String[] getAntarcticArmour(){
        return slumsArmour;
    }

    //returns slum armour pieces
    public double[] getAntarcticArmourPrices(){
        return slumsArmourPrice;
    }
    /**
     * Constructs all of the buildings within the town of slums
     */
    public void makeTowns(){
        tp = new Teleporter(player);

        //Creates the slums
        slums = new Town("The Slums", 1, player, "grey");

        Merchant slumsMerchant = new Merchant(player, player.getCurrentTown(), slumsItemsForSale,
                slumsPriceOfItem2, slumsShopName, slumsThingsToDo, slumsGreeting, slumsFarewell, slumsErrorMessage,
                merchantColor);
        this.slumsMerchant = slumsMerchant;
        slums.addMerchant(slumsMerchant);
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        slumDungeon = new Dungeon(slumDungeonMobsFloor1, slumDungeonFloor1MobLevels, slumDungeonFloor2MobLevels, slumDungeonMobsFloor2, slumDungeonFloor3MobLevels, slumDungeonMobsFloor3, slumBossName, slumBossLevel, slumBossDialog, slumDungeonGoldPerFloor, slumDungeonXPperFloor, slumDungeonRecommendedLevel, slumDungeonRequiredLevel, player, slums, "purple");
        Guild slumsAdventurersGuild = new Guild(player);
        slums.addGuild(slumsAdventurersGuild);
        slums.addDungeon(slumDungeon);
        slums.addTeleporter(tp);
        allTowns[0] = slums;
        
        antarcticDomain = new Town("The Antarctic Domain", 2, player,"blue");
        antarcticMerchant = new Merchant(player, antarcticDomain, antarcticItemsForSale,
                antarcticPriceOfItem2, antarcticShopName, antarcticThingsToDo, antarcticGreeting, antarcticFarewell, antarcticErrorMessage,
                merchantColor);
        antarcticDomain.addMerchant(antarcticMerchant);
        antarcticDomain.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");        
        antarcticDungeon = new Dungeon(antarcticDungeonMobsFloor1, antarcticDungeonFloor1MobLevels, antarcticDungeonFloor2MobLevels, antarcticDungeonMobsFloor2, antarcticDungeonFloor3MobLevels, antarcticDungeonMobsFloor3, antarcticBossName, antarcticBossLevel, antarcticBossDialog, antarcticDungeonGoldPerFloor, antarcticDungeonXPperFloor, antarcticDungeonRecommendedLevel, antarcticDungeonRequiredLevel, player, antarcticDomain, "purple");
        Guild antarcticAdventurersGuild = new Guild(player);
        antarcticDomain.addGuild(antarcticAdventurersGuild);
        antarcticDomain.addDungeon(antarcticDungeon);
        antarcticDomain.addTeleporter(tp);
        allTowns[1] = antarcticDomain;
        
        theFactoryRealm = new Town("The Factory Realm", 3, player,"cyan");
        theFactoryRealm.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        Guild factoryAdventurersGuild = new Guild(player);
        theFactoryRealm.addTeleporter(tp);
        allTowns[2] = theFactoryRealm;
        
        landOfSilver = new Town("The Land Of Silver", 4, player,"cyan");
        landOfSilver.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        Guild silverAdventurersGuild = new Guild(player);
        landOfSilver.addTeleporter(tp);
        allTowns[3] = landOfSilver;
        
        goldenReign = new Town("The Golden Reign", 5, player,"yellow");
        goldenReign.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        Guild goldenReignGuild = new Guild(player);
        goldenReign.addTeleporter(tp);
        allTowns[4] = goldenReign;
       
    }

   
    //returns slum merchant
    public Merchant getSlumsMerchant(){
        return slumsMerchant;
    }
    
    //returns antarctic merchant
    public Merchant getAntarcticMerchant(){
        return antarcticMerchant;
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

    public void setCurrentTownLevel(int townLevel){currentTownLevel = townLevel;}

    /**
     * Adds a building to the town
     * @param town      - the town that the building is going to be added to
     * @param merchant  - the merchant that the town will have
     */
    public void addBuildingToTown(Town town, Merchant merchant){
        town.addMerchant(merchant);
    }

    public Town[] getAllTowns() {
        return allTowns;
    }

    public Town getAntarcticDomain() {
        return antarcticDomain;
    }
}