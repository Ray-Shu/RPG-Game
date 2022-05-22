package TownInfo;

import Tools.*;

import java.util.Scanner;

import PlayerInformation.*;
import TownInfo.*;
import fightInfo.*;

public class Dungeon {
    //TODO: FIX TOWN ERROR

    private String[] yesOrNo = {"yes","no"};
    private int recommendedLvl, requiredLevel, bossLevel;
    private Player player;
    private Town town;
    private String[] mobNamesFromRoom1, mobNamesFromRoom2, mobNamesFromRoom3, bossDialogLines;
	private int[] mobLevelsFromRoom1, mobLevelsFromRoom2, mobLevelsFromRoom3;
	private int[] goldPerRoom, xpPerRoom;
	private String color, bossName;


    private MobSummoner summoner = new MobSummoner();
    private int[] currentMobAttackCosts;
    private String[] currentMobAttacks;
    private Stats currentMobStats;
	private boolean hasDungeonBeenDefeated = false, returnToStory, hasPlayerDied = false;

    /**
     * Creates a dungeon for the character to enter to try to get to the next floor. 
     * @param mobNamesFromRoom1 - These are the mob names from the first room
     * @param mobLevelsFromRoom1 - These are the levels of the mobs in room 1
     * @param mobLevelsFromRoom2 - These are the levels of the mobs in room 2
     * @param mobNamesFromRoom2  - these are the mob names of the mobs in room 2
     * @param mobLevelsFromRoom3  - these are the levels of them mobs from room 3
     * @param mobNamesFromRoom3  - These are the names of the mobs from room 3
     * @param bossName          - This is the boss's name
     * @param bossLevel         - This is the boss's level
     * @param bossDialogLines   - This is the dialog lines the boss says
     * @param goldPerRoom       - This is the amount of gold gained from each room
     * @param xpPerRoom         - This is the amount of xp gained from each room
     * @param recommendedLvl    - The recommended level for the dungeon
     * @param requiredLevel     - This is the required level for the dungeon
     * @param player            - This is the player
     * @param town              - The town
     * @param color             - The color
     */
    Dungeon( String[]mobNamesFromRoom1, int[] mobLevelsFromRoom1, int[] mobLevelsFromRoom2, String[] mobNamesFromRoom2, int[] mobLevelsFromRoom3, String[] mobNamesFromRoom3, String bossName, int bossLevel, String[] bossDialogLines, int[] goldPerRoom, int[] xpPerRoom, int recommendedLvl, int requiredLevel, Player player, Town town, String color){
        
        this.mobNamesFromRoom1 = mobNamesFromRoom1;
        this.mobNamesFromRoom2 = mobNamesFromRoom2;
        this.mobNamesFromRoom3 = mobNamesFromRoom3;
        
        this.mobLevelsFromRoom1 = mobLevelsFromRoom1;
        this.mobLevelsFromRoom2 = mobLevelsFromRoom2;
        this.mobLevelsFromRoom3 = mobLevelsFromRoom3;
        
        this.bossDialogLines = bossDialogLines;
        this.bossName = bossName;
        this.bossLevel = bossLevel;

        this.goldPerRoom = goldPerRoom;
        this.xpPerRoom = xpPerRoom;
        
        this.player = player;
        this.recommendedLvl = recommendedLvl;
        this.requiredLevel = requiredLevel;

        this.town = town;
        this.color = color;

    }

    /**
     * the character has entered the dungeon... 
     *  current dungeon before running it. 
     */
    public void characterEnteringDungeon(boolean returnToStory){

        this.returnToStory = returnToStory;
        System.out.println("\n-----------------------------------------------------------");

        //checks if they are the recommended level. If they are not, we will print out a message warning them. 
        if(player.getLevel() < recommendedLvl){
            Printer.printColor("This dungeon might be too hard for you...", "red");
        }
        Printer.printColor("Would you like to enter this dungeon? (yes or no)", "color");

        //gets their decission
        String answer = ErrorChecker.compareArrayOfStrings(yesOrNo, "Its yes or no...", "color");
        
        //if they want into the dungeon, we run the dungeon. If not, we wait a second then leave. 
        if(answer.equalsIgnoreCase("yes")){
            runDungeon();
        }
        else{
            Printer.printColor("Alright if your not going in dont hang around.", "color");
            Printer.quickBreak(1000);
            town.characterEnteringTown(returnToStory);
        }
    }


    /**
     * This method runs our dungeon. Our dungeons are structured as followed:
     * We do some battles with regular mobs
     * then we have a boss fight
     * then dungeon over if we win all the battles. 
     */
    public void runDungeon(){
        Scanner scan = new Scanner(System.in);
        //welcomes them to the dungeon

        System.out.println("\n-----------------------------------------------------------");
        Printer.printColor("Welcome to the dungeon!!!", color);
        Printer.printColor("Battle your way through three rooms of enemies and defeat the boss to earn the next town medallion!", color);
        Printer.printColor("Good luck!", color);
        System.out.println("\n-----------------------------------------------------------\n");
        Printer.quickBreak(1800);

        //For each mob in the battle, we will have to fight it with our current Stats. Goal is to defeat all enemies, then we get our reward. 
        runRoom(mobNamesFromRoom1, mobLevelsFromRoom1, 1);

        //Checks if the player died in the previous room
        if(!hasPlayerDied){
            Printer.printColor("Congratulation for beating the first room!\nYou have been fully healed and recovered all mp!\n" + 
                    "Hear are your rewards: " + xpPerRoom[0] + "XP and " + goldPerRoom[0] + " fusion coins! They are now being distributed.", color);
            
            //gives the player rewards.
            player.checkXP(xpPerRoom[0]);
            player.getBank().deposit(goldPerRoom[0]);
            player.getPlayerStats().hospitalHeal();
            player.getPlayerStats().rest();
            Printer.quickBreak(2000);
            System.out.print("Enter any character to continue: ");
            scan.next();
            
            runRoom(mobNamesFromRoom2, mobLevelsFromRoom2, 2);
        }
        else{
            scan.close();
            return;
        }
        
        //Checks if the player died in the previous room
        if(!hasPlayerDied){
            Printer.printColor("Congratulation for beating the second room!\n You have been fully healed and recovered all mp!\n" + 
            "Hear are your rewards: " + xpPerRoom[1] + "XP and " + goldPerRoom[1] + " fusion coins! They are now being distributed.", color);
    
            //gives the player rewards.
            player.checkXP(xpPerRoom[1]);
            player.getBank().deposit(goldPerRoom[1]);
            player.getPlayerStats().hospitalHeal();
            player.getPlayerStats().rest();
            Printer.quickBreak(2000);
            System.out.print("Enter any character to continue: ");
            scan.next();

            runRoom(mobNamesFromRoom3, mobLevelsFromRoom3, 3);
        }
        else{
            scan.close();
            return;
        }
  
        if(hasPlayerDied){
            scan.close();
            return;
        }

        Printer.printColor("Congratulation for beating the third room!\n You have been fully healed and recovered all mp!\n" + 
        "Hear are your rewards: " + xpPerRoom[2] + "XP and " + goldPerRoom[2] + " fusion coins! They are now being distributed.", color);

        //gives the player rewards.
        player.checkXP(xpPerRoom[2]);
        player.getBank().deposit(goldPerRoom[2]);
        player.getPlayerStats().hospitalHeal();
        player.getPlayerStats().rest();
        Printer.quickBreak(2000);
        System.out.print("Enter any character to continue: ");
        scan.next();

        //* Beginning of the boss fight: 
        //print our boss dialog lines with some time in between sayings
        for (String line : bossDialogLines) {
            Printer.printColor(line + "\n", color);
            Printer.quickBreak(500);
        }

        //summons the boss
        summonMob(bossName, bossLevel);   
        Combat combat = new Combat(player, player.getPlayerStats(), currentMobStats, currentMobAttacks, currentMobAttackCosts, summoner);
        combat.fight(false);

        //if the mission failed, we die and end it. 
        if(combat.didPlayerDie() == true){
            missionFailed();
            scan.close();
            return;
        } 

        victory();
    }

    /**
     * Runs the room
     * @param mobNames  - A group of names of the mobs
     * @param mobLevels - the levels of the mobs in the room
     * @param xpReward  - the xp reward from the room
     * @param cashReward - The cash reward from the room
     */
    public void runRoom(String[]mobNames, int[] mobLevels, int roomNumber){
        Printer.printColor("Entering the "+ (roomNumber) + " room! ", color);
        Printer.quickBreak(1000);

        for (int i = 0; i < mobNames.length; i++) {

            Printer.printColor("Watch out! A level "+ mobLevels[i] + " "+ mobNames[i] + " has appeared!!! \n", color);

            //makes creates a new mob with the given level, with stats based on the level of that mob. 
            summonMob(mobNames[i], mobLevels[i]);          

            Combat combat = new Combat(player, player.getPlayerStats(), currentMobStats, currentMobAttacks, currentMobAttackCosts, summoner);
            combat.fight(false);

            //if the player died, we go back to the town. 
            if(combat.didPlayerDie() == true){
                missionFailed();
                return;
            } 

            //says that we defeated the mob!
            Printer.printColor((i+1) + "/" + mobNames.length + " mob's defeated!\n", "green");
            Printer.quickBreak(2000);
        }
    }

    /**
     * Summons a mob based on a given name and level. 
     * @param mobName: The name of the mob
     * @param i: Index
     */

    public void summonMob(String mobName, int mobLevel){

        //if Cyber punk, we will summon a new cyberpunk and get the stats for it.
        if(mobName.equalsIgnoreCase("Cyber Punk")){
            currentMobStats = summoner.newCyberPunk(mobLevel);
        }
        
        //if Greater will assasin, we will summon a new assasin and get the stats for it.
        else if(mobName.equalsIgnoreCase("Greater Will Assassin")){
            currentMobStats = summoner.newGreaterWillAssassin(mobLevel);
        }

        else if(mobName.equalsIgnoreCase("Nano Bot Cluster")){
            currentMobStats = summoner.newNanoBotCluster(mobLevel);
        }

        else if(mobName.equalsIgnoreCase("Warden of Dirt")){ 
            currentMobStats = summoner.newWardenDirtStats(mobLevel);
        }
        
        if(mobName.equalsIgnoreCase("Greater Will Archer")){
            currentMobStats = summoner.newGreaterWillArcher(mobLevel);
        }

        else if(mobName.equalsIgnoreCase("Greater Will Swordsman")){
            currentMobStats = summoner.newGreaterWillSwordsman(mobLevel);
        }

        else if(mobName.equalsIgnoreCase("Yeti")){
            currentMobStats = summoner.newYeti(mobLevel);
        }

        else if(mobName.equalsIgnoreCase("Quantum Sensory Droid")){ 
            currentMobStats = summoner.newQuantumSensoryDroid(mobLevel);
        }
        
        else{
            System.out.println("Incorrect spelling of opponent name");
            return;
        }
        currentMobAttackCosts = summoner.getChosenAttackCosts();
        currentMobAttacks = summoner.getChosenAttacks();
    }


    /**
    * Send player back to hospital if the mission has not been complete. 
    */

    void missionFailed(){

        Printer.printColor("Teleporting back to town for recovery...","cyan");
        Printer.quickBreak(2000);
        hasPlayerDied = true;
        town.playerNeedsHospital();
        
    }

    /**
     * This method runs after the player has defeated the final dungeon boss. It unlocks the next floor for them, and enables them
     * teleporter at the first floor. 
     */

    void victory(){
        Printer.printColor("Congratulations! You have beat the dungeon!!!", "green");
        Printer.printColor("Distribution your rewards!", "green");
        player.checkXP(xpPerRoom[mobNamesFromRoom2.length-1]);
        player.getBank().deposit(goldPerRoom[mobNamesFromRoom2.length-1]);
        Printer.quickBreak(1500);

        hasDungeonBeenDefeated = true;
        Printer.printColor("You have gained the next Medallion, enabling you to go to the next town!", color);
        player.getTownMaker().increaseMaxTownLevel();
        player.getTownMaker().increaseCurrentTownLevel();
    }   
        
    //Returns a boolean of whether the dungeon has been defeated or not. 
    public boolean hasDungeonBeenDefeated(){return hasDungeonBeenDefeated;}

    /**
     * Checks if the player is a high enough level to enter the dungeon. 
     * @return
     */
    public boolean isLocked(){
        if(player.getLevel() >= requiredLevel){return false;}
        return true;
    }

    //gives back the required level for the dungeon. 
    public int getRequiredLevel() {return requiredLevel;}
}