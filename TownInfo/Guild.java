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
	private Town town;


    
    /**
     * Creates the guild and gives missions based on the town that we are in. 
     * @param town is the town which the guild is currently in
     * @param player is the player who has missions.
     */
    Guild(Player player, Town town, String color){
        this.town = town;
        townName = town.getTownName();
        this.color = color;
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
        Printer.printColor("(" + (i+1) + ") Leave", color);
    }

    public void addMission(Missions slumMission1) {
        allMissions.add(slumMission1);
    }
}
