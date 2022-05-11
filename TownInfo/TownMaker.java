package TownInfo;

import PlayerInformation.*;

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

    TownMaker(Bank playerAccount, Player player, Stats playerStats){
        this.playerAccount = playerAccount;
        this.player = player;
        this.playerStats = playerStats;
    }

    public void makeSlums(){
        slums = new Town("The Slums", 1, playerAccount);
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, slumBankName, thingsToDoInSlumBank, greeting4SlumBank, farewell4SlumBank, error4SlumBank, colorOfSlumBank);
        slums.addBuilding(player, playerStats, playerAccount, notStoreItems, notStorePrices, "Hospital",thingsToDoAtHospital, "Welcome to the Hospital! We are ready to heal you!", "Thank you for coming", "Sorry could you repeat that?", "white");
        Guild slumsAdventurersGuild = new Guild(slums, player, playerStats);
        slums.addGuild(slumsAdventurersGuild);
    }

    public void runSlums(){
        slums.characterEnteringTown();
    }

    public void goToCurrentTown(){
        switch (townLevel) {
            case 1:
                runSlums();
                break;
            case 2: 

                break;
        }
    }

    public void nextTown(){
        townLevel++;
    }

}