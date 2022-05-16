package TownInfo;

import Tools.*;
import PlayerInformation.*;
import TownInfo.*;

public class Dungeon {

    private String[] yesOrNo = {"yes","no"};
    private int recommendedLevel, requiredLevel;
    private Player player;
    private Town town;
    private Stats[] mobStats;
    private String[] mobAttacks;

    /**
     * Creates a dungeon for the character to enter to try to get to the next floor. 
     * @param mobStats          - the stats of the mobs
     * @param mobAttacks        - the attacks of the mobs
     * @param mobLevels         - the levels of the mobs   
     * @param recommendedLvl    - the recommended level of the player entering the dungeon
     * @param requiredLevel     - the required level of the player entering the dungeon.
     * @param player            - the player entering the dungeon
     * @param town              - the town from which the player is entering the dungeon. 
     */
    Dungeon(int[] goldPerMob, int[] xpPerMob, Stats[] mobStats, String[] mobAttacks, int[] mobLevels, int recommendedLvl, int requiredLevel, Player player, Town town){
        
        recommendedLevel = recommendedLvl;
        this.requiredLevel = requiredLevel;
        this.player = player;
        this.town = town;
        this.mobStats = mobStats;
        this.mobAttacks = mobAttacks;

    }

    /**
     * the character has entered the dungeon... We need to check if they are leveled up enough for this current dungeon before running it. 
     */
    public void characterEnteringDungeon(){
        Printer.printColor("------------------------------------------------","white");
        
        //checks if they are the required lvl. If not, back to town it is. 
        if(player.getLevel() < requiredLevel){
            Printer.printColor("Sorry! You do not meet the required level! Please leave the dungeon","");
            Printer.quickBreak(1000);
            town.characterEnteringTown();
            return;
        }

        //checks if they are the recommended level
        if(player.getLevel() < recommendedLevel){
            Printer.printColor("This dungeon might be too hard for you...", "red");
        }
        Printer.printColor("Would you like to enter this dungeon? (yes or no)", "red");


        //gets their decission
        String answer = ErrorChecker.compareArrayOfStrings(yesOrNo, "Its yes or no...", "red");
        if(answer.equalsIgnoreCase("yes")){
            runDungeon();
        }
        else{
            town.characterEnteringTown();
        }
    }


    public void runDungeon(){

    }
}
