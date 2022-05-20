package TownInfo;

import PlayerInformation.*;


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
    
    private String[] thingsToDoAtHospital = {"get healing", "leave"};
	private Stats playerStats;
	private Player player;

    private String teleporterName = "Hyper Loop!";
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
        // slums.addDungeon(new Dungeon(bossDialogLines, goldPerMob, xpPerMob, mobStats, mobAttacks, mobLevels, recommendedLvl, requiredLevel, player, town));

        antarcticDomain = new Town("The Antarctic Domain", 2, player,"blue");
        // antarcticDomain.addBuilding(player, playerStats, playerAccount, itemsForSale, priceOfItem, shopName, thingsToDo, greeting, farewell, errorMessage, color);
    }

    //runs the slums. 
    //This is temporary. 
    public void runSlums(){
        slums.characterEnteringTown();
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

    //Moves us to the next town

}