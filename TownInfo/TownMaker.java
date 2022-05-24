package TownInfo;

import PlayerInformation.*;


/**
 * This class builds all of the towns and make them run
 */
public class TownMaker{

    private Bank playerAccount;
    private boolean returnToStory;

    private String notStoreItems[] = new String[2];
    private double notStorePrices[] = new double[2];
    private Town slums, antarcticDomain, theFactoryRealm, landOfSilver, goldenReign;
    private int currentTownLevel = 1;
    private int maxTownLevel = 1;

    
    private String[] thingsToDoAtHospital = {"Get healing", "leave"};
	private Stats playerStats;
	private Player player;

    private String slum1MissionName = "Save Train from bandits";
    private String[] slum1MissionOpponents = {"cyber punk","cyber punk","cyber punk"};
    private int[] slum1MissionOpponentLevels = {1, 2, 3};
    private String slum1MissionProblem = "Bandits have attacked the hyperloop. Defeat them all to earn a bounty!";
    private String slum1MissionGreeting = "Help us! The bandits are attempting to hijack the train!";
    private String slum1MissionThankYou = "Thank you so much for your help!";
    private int slum1MissionXPReward = 400;
    private String[] slum1MissionItems = new String[5];
    private String slum1MissionColor = "blue";
    private int slum1MissionRecommendedLevel = 2;

    private String slum2MissionName = "Save Child from Kidnapper";
    private String[] slum2MissionOpponents = {"nano bot cluster", "nano bot cluster", "greater will assassin"};
    private int[] slum2MissionOpponentLevels = {4, 4, 4};
    private String slum2MissionProblem = "A group of Robots and an Assasin have kidnapped the daughter of Techno-King Bill Musk! \n" + 
            "We need a strike team to infiltrate their hideout and get her back safely. ";
    private String slum2MissionGreeting = "You break into the compound covertly through the sewers.\n"
            + "Once you arive in the basement, you realise that you are going to have to fight your way out.";
    private String slum2MissionThankYou = "Thank you so much for your help!";
    private int slum2MissionXPReward = 550;
    private String[] slum2MissionItems = new String[5];
    private String slum2MissionColor = "purple";
    private int slum2MissionRecommendedLevel = 5;
    
    private String slum3MissionName = "Save Farmer from Destructive Nano Bots";
    private String[] slum3MissionOpponents = {"nano bot cluster", "nano bot cluster","nano bot cluster","nano bot cluster" };
    private int[] slum3MissionOpponentLevels = {7, 7, 7,9};
    private String slum3MissionProblem = "A local Corn Farmer accidentally opened a barrel contained with hunter nano-bots!\n" + 
            "Defeat all the nano-bots to win!";
    private String slum3MissionGreeting = "HELP!!! THOSE NANO BOTS ARE DESTROYING MY CROPS!!!";
    private String slum3MissionThankYou = "Yay! My crops are saved!!!";
    private int slum3MissionXPReward = 650;
    private String[] slum3MissionItems = new String[5];
    private String slum3MissionColor = "yellow";
    private int slum3MissionRecommendedLevel = 7;
    
    private String antarcticMissionName1 = "Stop Yeti Attack!";
    private String[] antarcticMissionOpponents1 = {"yeti", "yeti","yeti" };
    private int[] antarcticMissionOpponentLevels1 = {11, 11, 11};
    private String antarcticMissionProblem1 = "A group of Yeti's have attacked an innocent group of campers! Help the campers by defeating the Yeti's";
    private String antarcticMissionGreeting1 = "AAAaaaaaaaaaaaaaaaaaaaaaHHHHHHHHHHH HELP US BEFORE WE ARE TURNED INTO YETI SNACKS!";
    private String antarcticMissionThankYou1 = "Thank you so much!";
    private int antarcticMissionXPReward1 = 1000;
    private String antarcticMissionColor1 = "cyan";
    private int antarcticMissionRecommendedLevel1 = 11;
    
    private String antarcticMissionName2 = "Help break prisoner our of the jail!";
    private String[] antarcticMissionOpponents2 = {"Greater Will Swordsman", "Greater Will Swordsman","Greater Will Archer" };
    private int[] antarcticMissionOpponentLevels2 = {14, 14, 14};
    private String antarcticMissionProblem2 = "We need a brave and skilled soldier to break into the ice jail and free a prisoner.";
    private String antarcticMissionGreeting2 = "You go for the head on approach: choosing to defeat all enemies in the jail by entering through the front door!";
    private String antarcticMissionThankYou2 = "Are you here to save me !?!?!?!?!";
    private int antarcticMissionXPReward2 = 1300;
    private String antarcticMissionColor2 = "green";
    private int antarcticMissionRecommendedLevel2 = 14;
    
    private String antarcticMissionName3 = "Assassinate the president of the yeti's!";
    private String[] antarcticMissionOpponents3 = {"Yeti" };
    private int[] antarcticMissionOpponentLevels3 = {17};
    private String antarcticMissionProblem3 = "We need someone to stop the villainous Yeti president from forcing the yeti's to do terrible things";
    private String antarcticMissionGreeting3 = "You sneak around, finding the Yeti. As you attempt to strike, the yeti notices you!";
    private String antarcticMissionThankYou3 = "*clunk*";
    private int antarcticMissionXPReward3 = 1600;
    private String antarcticMissionColor3 = "green";
    private int antarcticMissionRecommendedLevel3 = 16;

    //slum dungeon stuff
    private String[] slumBossDialog = {"VERY IMPRESSIVE VERY IMPRESSIVE!!! BEEP",
    "CHALLENGER HAS MANAGED TO MAKE IT ALL THE WAY TO FIGHT ME!!! BEEP", 
    "TOO BAD CHALLENGER WILL NOT BEAT ME!!! BEEEEEEP!!!", "I AM THE WARDEN OF DIRT!!!!"};
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
    
    //antarctic dungeon stuff
    private String[] antarcticBossDialog = {"PREPARE YOUR SELF CHALLENGER!",
    "I WILL DESTROY YOU WITH THE AMAZINGLY POWERFUL FROST!","I AM THE ALL POWERFUL WARDEN OF FROST!" };
    private int[] antarcticDungeonGoldPerFloor = {1000,1500,2000,5000};
    private int[] antarcticDungeonXPperFloor = {400,500,600,1500};

    private String[] antarcticDungeonMobsFloor1 = {"Greater Will Swordsman", "Greater Will Swordsman", "Greater Will Swordsman"};
    private int[] antarcticDungeonFloor1MobLevels = {13,13,13};
    private String[] antarcticDungeonMobsFloor2 = {"Yeti", "Yeti", "Yeti"};
    private int[] antarcticDungeonFloor2MobLevels = {14,14,14};
    private String[] antarcticDungeonMobsFloor3 = {"Yeti", "Greater Will Swordsman", "Greater Will Archer"};
    private int[] antarcticDungeonFloor3MobLevels = {15,15,15};
    private String antarcticBossName = "Warden of Frost";
    private int antarcticBossLevel = 15;

    private int antarcticDungeonRecommendedLevel = (15);
    private int antarcticDungeonRequiredLevel = (13);
    private Dungeon antarcticDungeon;
    
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
    
    /**
     * Constructs all of the buildings within the town of slums
     */
    public void makeTowns(){
        tp = new Teleporter(player);

        //create all the towns
        slums = new Town("The Slums", 1, player, "grey");
        antarcticDomain = new Town("The Antarctic Domain", 2, player,"blue");
        goldenReign = new Town("The Golden Reign", 5, player,"yellow");
        theFactoryRealm = new Town("The Factory Realm", 3, player,"cyan");
        landOfSilver = new Town("The Land Of Silver", 4, player,"cyan");
        Town[] allTowns = {slums, antarcticDomain, goldenReign, theFactoryRealm, landOfSilver};
        this.allTowns = allTowns;
        
        //Creates the slums
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        slumDungeon = new Dungeon(slumDungeonMobsFloor1, slumDungeonFloor1MobLevels, slumDungeonFloor2MobLevels, slumDungeonMobsFloor2, slumDungeonFloor3MobLevels, slumDungeonMobsFloor3, slumBossName, slumBossLevel, slumBossDialog, slumDungeonGoldPerFloor, slumDungeonXPperFloor, slumDungeonRecommendedLevel, slumDungeonRequiredLevel, player, slums, "purple");
        Guild slumsAdventurersGuild = new Guild(player, slums, "grey");
        slums.addGuild(slumsAdventurersGuild);
        slums.addDungeon(slumDungeon);
        slums.addTeleporter(tp);
        
        //Creates slum missions. 
        Missions slumMission1 = new Missions(1000, slumsAdventurersGuild, slum1MissionName, slum1MissionOpponents, slum1MissionOpponentLevels, player, slum1MissionProblem, slum1MissionGreeting, slum1MissionThankYou, slum1MissionColor, slum1MissionXPReward, slum1MissionItems, slum1MissionRecommendedLevel);
        slumsAdventurersGuild.addMission(slumMission1);

        Missions slumMission2 = new Missions(1750, slumsAdventurersGuild, slum2MissionName, slum2MissionOpponents, slum2MissionOpponentLevels, player,  slum2MissionProblem, slum2MissionGreeting, slum2MissionThankYou, slum2MissionColor, slum2MissionXPReward, slum2MissionItems, slum2MissionRecommendedLevel);
        slumsAdventurersGuild.addMission(slumMission2);


        Missions slumMission3 = new Missions(2500, slumsAdventurersGuild, slum3MissionName, slum3MissionOpponents, slum3MissionOpponentLevels, player,  slum3MissionProblem, slum3MissionGreeting, slum3MissionThankYou, slum3MissionColor, slum3MissionXPReward, slum3MissionItems, slum3MissionRecommendedLevel);
        slumsAdventurersGuild.addMission(slumMission3);

        //creates antarctic domain
        antarcticDomain.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");        
        antarcticDungeon = new Dungeon(antarcticDungeonMobsFloor1, antarcticDungeonFloor1MobLevels, antarcticDungeonFloor2MobLevels, antarcticDungeonMobsFloor2, antarcticDungeonFloor3MobLevels, antarcticDungeonMobsFloor3, antarcticBossName, antarcticBossLevel, antarcticBossDialog, antarcticDungeonGoldPerFloor, antarcticDungeonXPperFloor, antarcticDungeonRecommendedLevel, antarcticDungeonRequiredLevel, player, antarcticDomain, "purple");
        Guild antarcticAdventurersGuild = new Guild(player, antarcticDomain, "cyan");
        antarcticDomain.addGuild(antarcticAdventurersGuild);
        antarcticDomain.addDungeon(antarcticDungeon);
        antarcticDomain.addTeleporter(tp);

        //creates antarctic missions
        Missions antarcticMission1 = new Missions(4500, slumsAdventurersGuild, antarcticMissionName1, antarcticMissionOpponents1, antarcticMissionOpponentLevels1, player,  antarcticMissionProblem1, antarcticMissionGreeting1, antarcticMissionThankYou1, antarcticMissionColor1, antarcticMissionXPReward1, slum3MissionItems, antarcticMissionRecommendedLevel1);
        antarcticAdventurersGuild.addMission(antarcticMission1);
        
        Missions antarcticMission2 = new Missions(5000, slumsAdventurersGuild, antarcticMissionName2, antarcticMissionOpponents2, antarcticMissionOpponentLevels2, player,  antarcticMissionProblem2, antarcticMissionGreeting2, antarcticMissionThankYou2, antarcticMissionColor2, antarcticMissionXPReward2, slum3MissionItems, antarcticMissionRecommendedLevel2);
        antarcticAdventurersGuild.addMission(antarcticMission2);
        
        Missions antarcticMission3 = new Missions(6500, slumsAdventurersGuild, antarcticMissionName3, antarcticMissionOpponents3, antarcticMissionOpponentLevels3, player,  antarcticMissionProblem3, antarcticMissionGreeting3, antarcticMissionThankYou3, antarcticMissionColor3, antarcticMissionXPReward3, slum3MissionItems, antarcticMissionRecommendedLevel3);
        antarcticAdventurersGuild.addMission(antarcticMission3);
        
        //?Other realms for the next version!!!
        theFactoryRealm.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        Guild factoryAdventurersGuild = new Guild(player, theFactoryRealm, "cyan");
        theFactoryRealm.addTeleporter(tp);
        
        landOfSilver.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        Guild silverAdventurersGuild = new Guild(player, landOfSilver, "cyan");
        landOfSilver.addTeleporter(tp);
        
        goldenReign.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        Guild goldenReignGuild = new Guild(player, goldenReign, "cyan");
        goldenReign.addTeleporter(tp);
    }

    /**
     * Gives the current town level. 
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
    public void decreaseCurrentTownLevel(){maxTownLevel--;}

    //Increases the current town level
    public void increaseCurrentTownLevel(){currentTownLevel++;}

    //returns the max town level
    public int getMaxTownLevel(){return maxTownLevel;}

    //sets the current town level
    public void setCurrentTownLevel(int townLevel){currentTownLevel = townLevel;}

    /**
     * Adds a building to the town
     * @param town      - the town that the building is going to be added to
     * @param merchant  - the merchant that the town will have
     */
    public void addBuildingToTown(Town town, Merchant merchant){
        town.addMerchant(merchant);
    }

    //returns an array of all the towns
    public Town[] getAllTowns() {
        return allTowns;
    }
}