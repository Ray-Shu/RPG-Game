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
    private String[] mobNames;

    /**
     * Creates a dungeon for the character to enter to try to get to the next floor. 
     * @param bossDialogLines   - the lines that the boss says. 
     * @param goldPerMob        - the amount of gold given per mob defeated. 
     * @param xpPerMob          - the amount of XP given for defeating a mob. 
     * @param mobStats          - the stats of the mobs
     * @param mobAttacks        - the attacks of the mobs
     * @param mobLevels         - the levels of the mobs   
     * @param recommendedLvl    - the recommended level of the player entering the dungeon
     * @param requiredLevel     - the required level of the player entering the dungeon.
     * @param player            - the player entering the dungeon
     * @param town              - the town from which the player is entering the dungeon. 
     */
    Dungeon(String[]mobNames, String[] bossDialogLines, int[] goldPerMob, int[] xpPerMob, Stats[] mobStats, String[] mobAttacks, int[] mobLevels, int recommendedLvl, int requiredLevel, Player player, Town town){
        this.mobNames = mobNames;
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
    //     Stats currentMobStats;
    //     String[] currentMobAttacks;
    //     int[] currentMobAttackCosts;
    //     Printer.printColor("\n-----------------------------------------------------", "blue");
    //     Printer.printColor("Welcome to the dungeon!!!", "red");
        
    //     //For each mob in the battle, we will have to fight it with our current Stats. Goal is to defeat all enemies, then we get our reward. 
    //     for (int i = 0; i < mobNames.length; i++) {

    //         Printer.printColor("Watch out! A level "+ mobLevels[i] + " "+ mobNames[i] + " has appeared!!! \n", color);
    //         //makes the stats of the current mob equal to the stats of the 
    //         if(mobNames[i].equalsIgnoreCase("Cyber Punk")){
    //             currentMobStats = mobSummoner.newCyberPunk(mobLevels[i]);
    //         }
    //         else if(mobNames[i].equalsIgnoreCase("Greater Will Assassin")){
    //             currentMobStats = mobSummoner.newGreaterWillAssassin(mobLevels[i]);
    //         }
    //         else if(mobNames[i].equalsIgnoreCase("Nano Bot Cluster")){
    //             currentMobStats = mobSummoner.newNanoBotCluster(mobLevels[i]);
    //         }
    //         else{
    //             System.out.println("Incorrect spelling of opponent name");
    //             return;
    //         }
    //         currentMobAttackCosts = mobSummoner.getChosenAttackCosts();
    //         currentMobAttacks = mobSummoner.getChosenAttacks();
            
    //         combat = new Combat(player, playerStats, currentMobStats, currentMobAttacks, currentMobAttackCosts, mobSummoner);
    //         combat.fight(false);

    //         //if the player died, we go back to the town. 
    //         if(combat.didPlayerDie() == true){
    //             missionFailed();
    //             return;
    //         }
    //         Printer.printColor((i+1) + "/" + mobNames.length + " mob's defeated!\n", "green");

    //         Printer.quickBreak(2000);
    //     }
    //     missionSuccessful();
    // }
    }
}
