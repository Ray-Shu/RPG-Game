package TownInfo;

import java.util.ArrayList;
import Tools.*;
import PlayerInformation.*;

/**
 * This class holds all the information about our guild's missions, and then creates the guild with these missions depending on the town. 
 */
public class Guild {

    private String townName;
    private String color;
    private ArrayList<Missions> allMissions = new ArrayList<Missions>();
    private ArrayList<String>namesOfAllMissions = new ArrayList<String>();
	private Town town;


    private String slum1MissionName = "Save Train from bandits";
    private String[] slum1MissionOpponents = {"cyber punk","cyber punk","cyber punk"};
    private int[] slum1MissionOpponentLevels = {1, 2, 3};
    private String slum1MissionProblem = "Bandits have attacked the hyperloop. Defeat them all to earn a bounty!";
    private String slum1MissionGreeting = "Help us! The bandits are attempting to hijack the train!";
    private String slum1MissionThankYou = "Thank you so much for your help!";
    private int slum1MissionXPReward = 250;
    private String[] slum1MissionItems = new String[5];
    private String slum1MissionColor = "blue";
    private int slum1MissionRecommendedLevel = 2;

    private String slum2MissionName = "Save Child from Kidnapper";
    private String[] slum2MissionOpponents = {"nano bot cluster", "nano bot cluster", "greater will assassin"};
    private int[] slum2MissionOpponentLevels = {2, 2, 4};
    private String slum2MissionProblem = "A group of Robots and an Assasin have kidnapped the daughter of Techno-King Bill Musk! \n" + 
            "We need a strike team to infiltrate their hideout and get her back safely. ";
    private String slum2MissionGreeting = "You break into the compound covertly through the sewers\n"
            + "Once iyou arive in the basement, you realise that you are going to have to fight your way out.";
    private String slum2MissionThankYou = "Thank you so much for your help!";
    private int slum2MissionXPReward = 350;
    private String[] slum2MissionItems = new String[5];
    private String slum2MissionColor = "purple";
    private int slum2MissionRecommendedLevel = 3;
    
    private String slum3MissionName = "Save Farmer from Destructive Nano Bots";
    private String[] slum3MissionOpponents = {"nano bot cluster", "nano bot cluster","nano bot cluster","nano bot cluster" };
    private int[] slum3MissionOpponentLevels = {5, 5, 5,5};
    private String slum3MissionProblem = "A local Corn Farmer accidentally openned a barrel contained with hunter nano-bots!\n" + 
            "Defeat all the nano-bots to win!";
    private String slum3MissionGreeting = "HELP!!! THOSE NANO BOTS ARE DESTROYING MY CROPS!!!";
    private String slum3MissionThankYou = "Yay! My crops are saved!!!";
    private int slum3MissionXPReward = 350;
    private String[] slum3MissionItems = new String[5];
    private String slum3MissionColor = "yellow";
    private int slum3MissionRecommendedLevel = 5;
    
    /**
     * Creates the guild and gives missions based on the town that we are in. 
     * @param town is the town which the guild is currently in
     * @param playerStats is the stats of the player which we use to create missions
     * @param player is the player who has missions. 
     */
    Guild(Town town, Player player, Stats playerStats){
        this.town = town;

        //checks which town we are in, and then creates missions based on that town. 
        switch (town.getTownName().toLowerCase()) {

            //if the town is slums, we create all the slum missions and so on for every town. 
            case "the slums":
                //color of slum Guild text is red. 
                color = "red";
                //Creates slum missions. 
                Missions slumMission1 = new Missions(this, town, slum1MissionName, slum1MissionOpponents, slum1MissionOpponentLevels, player, playerStats, slum1MissionProblem, slum1MissionGreeting, slum1MissionThankYou, slum1MissionColor, slum1MissionXPReward, slum1MissionItems, slum1MissionRecommendedLevel);
                allMissions.add(slumMission1);
                namesOfAllMissions.add(slum1MissionName);

                Missions slumMission2 = new Missions(this, town, slum2MissionName, slum2MissionOpponents, slum2MissionOpponentLevels, player, playerStats, slum2MissionProblem, slum2MissionGreeting, slum2MissionThankYou, slum2MissionColor, slum2MissionXPReward, slum2MissionItems, slum2MissionRecommendedLevel);
                allMissions.add(slumMission2);
                namesOfAllMissions.add(slum1MissionName);

                Missions slumMission3 = new Missions(this, town, slum3MissionName, slum3MissionOpponents, slum3MissionOpponentLevels, player, playerStats, slum3MissionProblem, slum3MissionGreeting, slum3MissionThankYou, slum3MissionColor, slum3MissionXPReward, slum3MissionItems, slum3MissionRecommendedLevel);
                allMissions.add(slumMission2);
                namesOfAllMissions.add(slum1MissionName);

                break;
    
            //runs if we mispelt the name of the town
            default:
                System.out.println("Error: Incorrect town name");
                break;
        }
    }

    /**
     * The player has entered the guild, so we tell them the missions they are yet to complete, before running them
     */
    public void runGuild(){
        Printer.printColor("____________________________________________________\n" 
                + "Welcome to the " + townName + " adventurers guild!\n\n" 
                + "Here are some possible missions: \n", color);

        printMissions();

        Printer.printColor("\nWhich mission would you like to go on?", color);
        int missionToDo = ErrorChecker.intWithMinAndMax(1, allMissions.size(), "\nWhich mission would you like to go on?", color);
        if(missionToDo < allMissions.size()){
            allMissions.get(missionToDo).runMission();
        }
        else{
            town.characterEnteringTown();
        }
    }

   
    /**
     * Prints out all the missions, and their rewards. 
     */
    public void printMissions(){
        int i = 0;
        for (i = 0; i < allMissions.size();i++ ){
            if(!allMissions.get(i).isMissionComplete()){
            //prints the index of the mission.
                Printer.printColor("(" + (i+1) + " ) "
                    + allMissions.get(i).getMissionName() + ": ", color);
                allMissions.get(i).printMissionInfo();
            }
        }
        Printer.printColor("(" + (i+1) + " ) Leave", color);
    }
}
