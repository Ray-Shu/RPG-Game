package TownInfo;

import Tools.*;
import PlayerInformation.*;
public class Teleporter {
    private Player mainPlayer;
    private TownMaker townMaker;
    private int maxTownLevel;
    private int currentTownLevel;

    /**
     * Creates a teleporter, which will be in each town. 
     */
    Teleporter(Player player){
        mainPlayer = player;
        townMaker = player.getTownMaker();
    }

    /**
     * Runs when a player is in a town, and chooses to go to the teleporter. 
     */
    public void runTeleporter(){


    }

    /**
     * Prints a list of every unlocked town. 
     */
    void listTowns(){
        maxTownLevel = townMaker.getMaxTownLevel();
        currentTownLevel = townMaker.getCurrentTownLevel();
        
        int i = 1;
        while (maxTownLevel <= 1) {
            if(currentTownLevel != maxTownLevel){
                //Printer.printColor("(" + i + ") " + townMaker.getTown(i).getTownName(), "blue");
            }
            i++;
            maxTownLevel--;
        }


        // Printer.printColor(, "white");
    }


    








}

