package TownInfo;

import java.util.ArrayList;

import Tools.*;
import PlayerInformation.*;
public class Guild {

    private String townName;
    private String color;
    private ArrayList<Missions> allMissions = new ArrayList<Missions>();
    private ArrayList<String>namesOfAllMissions = new ArrayList<String>();

    private String slum1MissionName = "Save Train from bandits";
    private String[] slum1MissionOpponents = {"cyber punk", "nano bot cluster", "greater will assassin"};
    private int[] slum1MissionOpponentLevels = {1, 2, 3};
    private String slum1MissionProblem = "Bandits have attacked the hyperloop. Defeat them all to earn a bounty!";
    private String slum1MissionGreeting = "Help us! The bandits are attempting to hijack the train!";
    private String slum1MissionThankYou = "Thank you so much for your help!";
    private int slum1MissionXPReward = 250;
    private String[] slum1MissionItems = new String[5];
    private String slum1MissionColor = "blue";

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

        Printer.printColor("\nWhich mission would you like to go on?", color);
        String missionToDo = ErrorChecker.compareArrayOfStrings(namesOfAllMissions.toArray(new String[namesOfAllMissions.size()]), "Sorry please repeat that!", color);
        
        allMissions.forEach((e) -> {
            if (missionToDo.equalsIgnoreCase(e.getMissionName())) {
                e.runMission();
                return;
            }
        });
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
