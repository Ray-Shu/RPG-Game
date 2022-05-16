package TownInfo;

import PlayerInformation.*;


/**
 * This class builds all of the towns and make them run
 */
public class TownMaker{

    private Bank playerAccount;
    private String notStoreItems[] = new String[2];
    private double notStorePrices[] = new double[2];
    private Town slums;
    private int townLevel = 1;

    private String slumBankName = "Broken Bank";
    private String[] thingsToDoInSlumBank = {"withdraw", "view balance"};
    private String greeting4SlumBank = "Welcome to the broken bank! How can I help you?";
    private String farewell4SlumBank = "Adios!";
    private String error4SlumBank = "Please repeat that";
    private String colorOfSlumBank = "grey";
    
    private String[] thingsToDoAtHospital = {"get healing"};
	private Stats playerStats;
	private Player player;

    /**
     * Constructs the townmaker by giving the player's account, stats, and their identity. 
     * 
     * @param player - The player
     */
    public TownMaker(Player player){
        this.playerAccount = player.getBank();
        this.player = player;
        this.playerStats = player.getPlayerStats();
    }

    /**
     * Constructs all of the buildings within the town of slums
     */
    public void makeSlums(){
        slums = new Town("the slums", 1, player, "grey");
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, slumBankName, thingsToDoInSlumBank, greeting4SlumBank, farewell4SlumBank, error4SlumBank, colorOfSlumBank);
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        Guild slumsAdventurersGuild = new Guild(slums, player, playerStats);
        slums.addGuild(slumsAdventurersGuild);
    }

    //runs the slums. 
    //This is temporary. 
    public void runSlums(){
        slums.characterEnteringTown();
    }

    /**
     * TODO: make multiple towns, and then when we call this method, it will move us to that town. 
     */
    public void goToCurrentTown(){
        switch (townLevel) {
            case 1:
                runSlums();
                break;
            case 2: 

                break;
        }
    }

    //Moves us to the next town
    public void nextTown(){townLevel++; goToCurrentTown();}

}