package TownInfo;

import Tools.*;
import PlayerInformation.*;
import TownInfo.*;
import fightInfo.*;

public class Dungeon {

    private String[] yesOrNo = {"yes","no"};
    private int recommendedLevel, requiredLevel;
    private Player player;
    private Town town;
    private Stats[] mobStats;
    private String[] mobAttacks, mobNames, bossDialogLines;
	private int[] mobLevels;
	private int[] goldPerMob, xpPerMob;
	private String color;

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
    Dungeon( String[]mobNames, String[] bossDialogLines, int[] goldPerMob, int[] xpPerMob, Stats[] mobStats, String[] mobAttacks, int[] mobLevels, int recommendedLvl, int requiredLevel, Player player, Town town, String color){
        
        this.bossDialogLines = bossDialogLines;
        this.goldPerMob = goldPerMob;
        this.xpPerMob = xpPerMob;
        this.mobNames = mobNames;
        recommendedLevel = recommendedLvl;
        this.requiredLevel = requiredLevel;
        this.player = player;
        this.town = town;
        this.mobStats = mobStats;
        this.mobAttacks = mobAttacks;
        this.mobLevels = mobLevels;
        this.color = color;
    }

    /**
     * the character has entered the dungeon... We need to check if they are leveled up enough for this current dungeon before running it. 
     */
    public void characterEnteringDungeon(){
        Printer.printColor("------------------------------------------------","white");
        //checks if they are the required lvl. If not, back to town it is. 
        if(player.getLevel() < requiredLevel){
            Printer.printColor("Sorry! You do not meet the required level! Please leave the dungeon",color);
            Printer.quickBreak(1000);
            town.characterEnteringTown();
            return;
        }

        //checks if they are the recommended level
        if(player.getLevel() < recommendedLevel){
            Printer.printColor("This dungeon might be too hard for you...", "red");
        }
        Printer.printColor("Would you like to enter this dungeon? (yes or no)", "color");

        //gets their decission
        String answer = ErrorChecker.compareArrayOfStrings(yesOrNo, "Its yes or no...", "color");
        if(answer.equalsIgnoreCase("yes")){
            runDungeon();
        }
        else{
            Printer.printColor("Alright if your not going in dont hang around.", "color");
            Printer.quickBreak(1000);
            town.characterEnteringTown();
        }
    }


    public void runDungeon(){
        MobSummoner summoner = new MobSummoner();
        Stats currentMobStats;
        String[] currentMobAttacks;
        int[] currentMobAttackCosts;
        Printer.printColor("\n-----------------------------------------------------", "blue");
        Printer.printColor("Welcome to the dungeon!!!", color);
        
        //For each mob in the battle, we will have to fight it with our current Stats. Goal is to defeat all enemies, then we get our reward. 
        for (int i = 0; i < mobNames.length - 1; i++) {

            Printer.printColor("Watch out! A level "+ mobLevels[i] + " "+ mobNames[i] + " has appeared!!! \n", color);
            //makes the stats of the current mob equal to the stats of the 
            if(mobNames[i].equalsIgnoreCase("Cyber Punk")){
                currentMobStats = summoner.newCyberPunk(mobLevels[i]);
            }
            else if(mobNames[i].equalsIgnoreCase("Greater Will Assassin")){
                currentMobStats = summoner.newGreaterWillAssassin(mobLevels[i]);
            }
            else if(mobNames[i].equalsIgnoreCase("Nano Bot Cluster")){
                currentMobStats = summoner.newNanoBotCluster(mobLevels[i]);
            }
            
            else{
                System.out.println("Incorrect spelling of opponent name");
                return;
            }
            currentMobAttackCosts = summoner.getChosenAttackCosts();
            currentMobAttacks = summoner.getChosenAttacks();
            

            Combat combat = new Combat(player, player.getPlayerStats(), currentMobStats, currentMobAttacks, currentMobAttackCosts, summoner);
            combat.fight(false);
            //if the player died, we go back to the town. 
            if(combat.didPlayerDie() == true){
                missionFailed();
                return;
            }
            Printer.printColor((i+1) + "/" + mobNames.length + " mob's defeated!\n", "green");

            Printer.quickBreak(2000);
        }

        for (String line : bossDialogLines) {
            Printer.printColor(line + "\n", color);
        }


    }


    /**
    * Send player back to hospital if the mission has not been complete. 
    */
    public void missionFailed(){
        Printer.printColor("Teleporting back to town for recovery...","cyan");
        Printer.quickBreak(2000);
        town.playerNeedsHospital();
        return;
    }
    }