package TownInfo;

import Tools.*;
import PlayerInformation.*;
public class Teleporter {
    private Player mainPlayer;
    private TownMaker townMaker;
    private int maxTownLevel;
    private int currentTownLevel;
    private Town[] allTowns;

    /**
     * Creates a teleporter, which will be in each town. 
     */
    Teleporter(Player player){
        mainPlayer = player;
        townMaker = player.getTownMaker();
        allTowns = townMaker.getAllTowns();
    }

    /**
     * Runs when a player is in a town, and chooses to go to the teleporter. 
     */
    public void runTeleporter(boolean returnToStory){
        //Welcomes them to the teleporter.
        getCurrentTownLevel();
        System.out.println("-----------------------------------------");
        Printer.printColor("Hey Traveler! You are currently in "+townMaker.getCurrentTown().getTownName() , "cyan");
        Printer.printColor("Here are all the towns: \n", "cyan");

        listTowns();
        
        int chosenTownLevel = ErrorChecker.intWithMinAndMax(0, maxTownLevel, "\nWhere would you like to go?", "cyan");


        //based on their choice, we run something. 
        switch (chosenTownLevel) {
            case 0:
                townMaker.getCurrentTown().characterEnteringTown(returnToStory);
                Printer.printColor("Leaving...", "white");
                Printer.quickBreak(1000);
                return;
        
            case 1: 
                townMaker.setCurrentTownLevel(1);
                break;

            case 2: 
                townMaker.setCurrentTownLevel(2);
                break;

            case 3: 
                townMaker.setCurrentTownLevel(3);
                break;

            case 4: 
                townMaker.setCurrentTownLevel(4);
                break;

            case 5: 
                townMaker.setCurrentTownLevel(5);
                break;
        }
        Printer.printColor("Teleporting...", "cyan");
        townMaker.getCurrentTown().characterEnteringTown(returnToStory);
    }   

    /**
     * Updates the current town level and max town Level. 
     */
    void getCurrentTownLevel(){
        maxTownLevel = townMaker.getMaxTownLevel();
        currentTownLevel = townMaker.getCurrentTownLevel();
    }

    /**
     * Prints a list of every unlocked town. 
     */
    void listTowns(){
        Printer.printColor("(0) Leave", "white");

        //for we are going to list something for every town. 
        for (int j = 0; j < allTowns.length; j++) {

            //if we have unlocked a certain level, we can play it. 
            if((j+1) <= maxTownLevel){
                Printer.printColor("(" + (j+1) + ") " + allTowns[j].getTownName(), "white");
            }

            //if we are yet to unlock a floor, we will not be able to play it. 
            else{
                Printer.printColor("(" + (j+1) + ") [LOCKED]" + allTowns[j].getTownName(), "white");
            }
        }

    }


    








}

