package TownInfo;

import java.util.ArrayList;

import Tools.*;
import PlayerInformation.*;
public class Guild {

    private String townName;
    private String color;
    ArrayList<Missions> allMissions = new ArrayList<Missions>();
    ArrayList<String>namesOfAllMissions = new ArrayList<String>();

    String slum1MissionName = "Save Train from bandits";
    String[] slum1MissionOpponents = {"cyber punk", "nano bot cluster", "greater will assassin"};
    int[] slum1MissionOpponentLevels = {1, 2, 3};
    String slum1MissionProblem = "Bandits have attacked the hyperloop. Defeat them all to earn a bounty!";
    String slum1MissionGreeting = "Help us! The bandits are attempting to hijack the train!";
    String slum1MissionThankYou = "Thank you so much for your help!";
    int slum1MissionXPReward = 250;
    String[] slum1MissionItems = new String[5];
    String slum1MissionColor = "blue";

    /**
     * Creates the guild and makes it based on the name of the town
     */
    Guild(Town town, Player player, Stats playerStats){

        townName = town.getTownName();
        switch (townName.toLowerCase()) {

            case "slums":
                color = "red";
                Missions slumMission1 = new Missions(this, town, slum1MissionName, slum1MissionOpponents, slum1MissionOpponentLevels, player, playerStats, slum1MissionProblem, slum1MissionGreeting, slum1MissionThankYou, slum1MissionColor, slum1MissionXPReward, slum1MissionItems);
                allMissions.add(slumMission1);
                namesOfAllMissions.add(slum1MissionName);
                break;
        
            default:
                System.out.println("Error: Incorrect town name");
                break;
        }
    }

    /**
     * The player has entered the guild, so we tell them their missions, and get them to ask if they have done any of them. 
     */
    public void runGuild(){
        Printer.printColor("____________________________________________________\n" 
                + "Welcome to the " + townName + " adventurers guild!\n\n" 
                + "Here are some possible missions: \n", color);

        printMissions();

        String missionToDo = ErrorChecker.compareArrayOfStrings(namesOfAllMissions.toArray(new String[namesOfAllMissions.size()]), "Sorry please repeat that!", color);
        
    }

   
    /**
     * Prints out all the missions, and their rewards. 
     */
    public void printMissions(){
        for (Missions quest : allMissions ){
            if(!quest.isMissionComplete()){
                quest.printMissionInfo();
            }
        }
    }
}
