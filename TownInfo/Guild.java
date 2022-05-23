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
    private int slum1MissionXPReward = 360;
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
    private int slum2MissionXPReward = 450;
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
    private int slum3MissionXPReward = 550;
    private String[] slum3MissionItems = new String[5];
    private String slum3MissionColor = "yellow";
    private int slum3MissionRecommendedLevel = 7;
	private boolean returnToStory;
    
    private String antarcticMissionName1 = "Stop Yeti Attack!";
    private String[] antarcticMissionOpponents1 = {"yeti", "yeti","yeti" };
    private int[] antarcticMissionOpponentLevels1 = {11, 11, 11};
    private String antarcticMissionProblem1 = "A group of Yeti's have attacked an innocent group of campers! Help the campers by defeating the Yeti's";
    private String antarcticMissionGreeting1 = "AAAaaaaaaaaaaaaaaaaaaaaaHHHHHHHHHHH HELP US BEFORE WE ARE TURNED INTO YETI SNACKS!";
    private String antarcticMissionThankYou1 = "Thank you so much!";
    private int antarcticMissionXPReward1 = 650;
    private String antarcticMissionColor1 = "cyan";
    private int antarcticMissionRecommendedLevel1 = 11;
    
    private String antarcticMissionName2 = "Help break prisoner our of the jail!";
    private String[] antarcticMissionOpponents2 = {"Greater Will Swordsman", "Greater Will Swordsman","Greater Will Archer" };
    private int[] antarcticMissionOpponentLevels2 = {14, 14, 14};
    private String antarcticMissionProblem2 = "We need a brave and skilled soldier to break into the ice jail and free a prisoner.";
    private String antarcticMissionGreeting2 = "You go for the head on approach: choosing to defeat all enemies in the jail by entering through the front door!";
    private String antarcticMissionThankYou2 = "Are you here to save me !?!?!?!?!";
    private int antarcticMissionXPReward2 = 850;
    private String antarcticMissionColor2 = "green";
    private int antarcticMissionRecommendedLevel2 = 14;
    
    private String antarcticMissionName3 = "Assassinate the president of the yeti's!";
    private String[] antarcticMissionOpponents3 = {"Yeti" };
    private int[] antarcticMissionOpponentLevels3 = {35};
    private String antarcticMissionProblem3 = "We need someone to stop the villainous Yeti president from forcing the yeti's to do terrible things";
    private String antarcticMissionGreeting3 = "You sneak around, finding the Yeti. As you attempt to strike, the yeti notices you!";
    private String antarcticMissionThankYou3 = "*clunk*";
    private int antarcticMissionXPReward3 = 1000;
    private String antarcticMissionColor3 = "green";
    private int antarcticMissionRecommendedLevel3 = 16;

    /**
     * Creates the guild and gives missions based on the town that we are in. 
     * @param town is the town which the guild is currently in
     * @param player is the player who has missions.
     */
    Guild(Player player){
        town = player.getCurrentTown();
        townName = town.getTownName();

        //todo: Make missions for other towns. 
        //checks which town we are in, and then creates missions based on that town. 
        switch (town.getTownName().toLowerCase()) {

            //if the town is slums, we create all the slum missions and so on for every town. 
            case "the slums":
                //color of slum Guild text is red. 
                color = "red";
                //Creates slum missions. 
                Missions slumMission1 = new Missions(1000, this, slum1MissionName, slum1MissionOpponents, slum1MissionOpponentLevels, player, slum1MissionProblem, slum1MissionGreeting, slum1MissionThankYou, slum1MissionColor, slum1MissionXPReward, slum1MissionItems, slum1MissionRecommendedLevel);
                allMissions.add(slumMission1);
                namesOfAllMissions.add(slum1MissionName);

                Missions slumMission2 = new Missions(1750, this, slum2MissionName, slum2MissionOpponents, slum2MissionOpponentLevels, player,  slum2MissionProblem, slum2MissionGreeting, slum2MissionThankYou, slum2MissionColor, slum2MissionXPReward, slum2MissionItems, slum2MissionRecommendedLevel);
                allMissions.add(slumMission2);
                namesOfAllMissions.add(slum1MissionName);

                Missions slumMission3 = new Missions(2001, this, slum3MissionName, slum3MissionOpponents, slum3MissionOpponentLevels, player,  slum3MissionProblem, slum3MissionGreeting, slum3MissionThankYou, slum3MissionColor, slum3MissionXPReward, slum3MissionItems, slum3MissionRecommendedLevel);
                allMissions.add(slumMission3);
                namesOfAllMissions.add(slum2MissionName);
                
                break;
                
            case "The Antarctic Domain":
                color = "blue";
                
                //shows missions
                Missions antarcticMission1 = new Missions(2000, this, antarcticMissionName1, antarcticMissionOpponents1, antarcticMissionOpponentLevels1, player,  antarcticMissionGreeting1, antarcticMissionProblem1, antarcticMissionThankYou1, antarcticMissionColor1, antarcticMissionXPReward1, slum3MissionItems, antarcticMissionRecommendedLevel1);
                allMissions.add(antarcticMission1);
                namesOfAllMissions.add(antarcticMissionName1);
                
                Missions antarcticMission2 = new Missions(3000, this, antarcticMissionName2, antarcticMissionOpponents2, antarcticMissionOpponentLevels2, player,  antarcticMissionGreeting2, antarcticMissionProblem2, antarcticMissionThankYou2, antarcticMissionColor2, antarcticMissionXPReward2, slum3MissionItems, antarcticMissionRecommendedLevel2);
                allMissions.add(antarcticMission2);
                namesOfAllMissions.add(antarcticMissionName2);
                
                Missions antarcticMission3 = new Missions(4000, this, antarcticMissionName3, antarcticMissionOpponents3, antarcticMissionOpponentLevels3, player,  antarcticMissionGreeting3, antarcticMissionProblem3, antarcticMissionThankYou3, antarcticMissionColor3, antarcticMissionXPReward3, slum3MissionItems, antarcticMissionRecommendedLevel3);
                allMissions.add(antarcticMission3);
                namesOfAllMissions.add(antarcticMissionName3);

                break;

            case "The Factory Realm":
                color = "green";


                break;

            case "The Land Of Silver":
                color = "yellow";


                break;

            case "The Golden Reign":
                color = "purple";


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
    public void runGuild(boolean returnToStory){
        System.out.println("-----------------------------------------------------------");
        if(returnToStory){
        Printer.printColor("Welcome to the " + townName + " adventurers guild!\n\n" 
                + "Here are some possible missions: \n", color);
        }

        printMissions();

        int missionToDo = ErrorChecker.intWithMinAndMax(1, (allMissions.size() + 1), "\nWhich mission would you like to go on?", color);
        
        if(missionToDo <= allMissions.size()){
            allMissions.get(missionToDo-1).runMission(returnToStory);
        }
        else{
            town.characterEnteringTown(returnToStory);
        }
    }

   
    /**
     * Prints out all the missions, and their rewards. 
     */
    public void printMissions(){
        int i = 0;
        //removes completed missions from the array
        
        for (int n = 0; n < allMissions.size(); n++) {
            if(allMissions.get(n).isMissionComplete()){
                allMissions.remove(n);
                n--;
            }
        }

        if(allMissions.isEmpty()){
            Printer.printColor("There are no more missions to complete!", "white");
        }

        for (i = 0; i < allMissions.size();i++ ){
            
            //prints the index of the mission.
                Printer.printColor("(" + (i+1) + ") "
                    + allMissions.get(i).getMissionName() + ": ", color);
                allMissions.get(i).printMissionInfo();
        }
        Printer.printColor("(" + (i+1) + " ) Leave", color);
    }
}
