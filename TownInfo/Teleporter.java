package TownInfo;

import Tools.*;
import PlayerInformation.*;
public class Teleporter {
    private Player mainPlayer;
    private TownMaker townMaker;
    private int maxTownLevel;
    private Object currentTownLevel;

    /**
     * Creates a teleporter, which will be in each town. 
     */
    HyperLoop(Player player){
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

        Printer.printColor("", color);
    }


    public void








}
}
