package fightInfo; 

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import PlayerInformation.*;
import Tools.*;
/**
 * This class does all the stuff we need to have a fight
 */
public class Combat extends Moves{
    
    private DecimalFormat df = new DecimalFormat("###.00");
    private Scanner scan = new Scanner(System.in);
    private Random random = new Random();

    private double playerTurnRate, mobTurnRate;
    private Stats  mobStats, playerStats;
    private MobSummoner mobSummoner;
    private String[] mobAttacks;
    private int[] mobAttackCosts;
    private int[] playerAttackCosts;
    private Player player;
    private boolean hasPlayerDied = false;
    /**
     * Constructs the arena for a fight between a mob and a player. 
     * Does not call the fight method, but might make it later. 
     * 
     * @param player this is the player who is fighting the mob
     * @param playerStats this is the stats of that player
     * @param mobStats this is the stats of the mob
     * @param mobAttacks this is the list of possible mob attacks.
     * @param mobAttacksCost is the mp cost for the mobs attacks 
     * @param mobSummoner - this is the thing mobSummoner which has a lot of the information about the summoner
     */
    public Combat(Player player, Stats playerStats, Stats mobStats , String[] mobAttacks, int[] mobAttacksCost, MobSummoner mobSummoner){

        this.playerStats = playerStats;
        this.player = player;
        this.playerAttackCosts = player.chosenAttacksCost;
        this.mobStats = mobStats;
        this.mobAttacks = mobAttacks;
        this.mobSummoner = mobSummoner;
        this.mobAttackCosts = mobAttacksCost;

        mobTurnRate = mobStats.currentSpd;
        playerTurnRate = playerStats.currentSpd;   

    }

    /**
     * Starts a fight between the player and the mob, before 
     */
    public void fight(boolean isTutorial) {
        boolean hasMobAttacked = isTutorial;

        while(playerStats.currentHP > 0 && mobStats.currentHP > 0){

            if (isTutorial) {
                Printer.printColor("\nWelcome to your first fight! Both you and your opponent will have attacks which use MP. \nYour goal is to use those attacks to defeat your enemy before dying or running out of MP! \n", "purple"); 
                isTutorial = false;
            }

            if (isPlayerTurn() && playerStats.howLongDisabled == 0){
                
                Printer.printColor("----------------------------------------------------------", "cyan");

                Printer.printColor("It is your turn! Your current MP: "+ playerStats.currentMP + " | Enemy HP: "+ df.format(mobStats.currentHP) + "\n", "cyan");
                

                playerMove();
                checkPlayerBoosts();
                System.out.println();

                Printer.printColor("Enemy HP after attack: " + checkIfZeroHP("mob") + "\n", "cyan");
                Printer.printColor("----------------------------------------------------------", "cyan");
                playerTurnOver();

            }

            else if (mobStats.howLongDisabled == 0){

                Printer.printColor("----------------------------------------------------------", "red");

                if(hasMobAttacked){
                    Printer.print("Watch out! It is the enemies turn and they are going to attack you! ");
                    hasMobAttacked = false;
                }
                Printer.printColor("It is the opponents turn! " + mobSummoner.getMobName() + "'s current MP: " + mobStats.currentMP + " Your HP: "+ df.format(playerStats.currentHP) + "\n", "red");
                mobMove();
                checkMobBoosts();
                System.out.println();

                Printer.printColor("Your HP After Attack: " +  checkIfZeroHP("player") + "\n", "red");
                Printer.printColor("----------------------------------------------------------", "red");
                mobTurnOver();

            }

            isAnyoneDisabled();

        }

        whoDied();
        Printer.printColor("Fight Over", "yellow");
        return;

    }

    //*Doesn't display negative numbers when whoever is killed
    public String checkIfZeroHP(String whoseTurn) {
        if(whoseTurn.equalsIgnoreCase("player")) {
            if (playerStats.currentHP < 0) {
                return "0";
            } else {
                return df.format(playerStats.currentHP);
            }
       
        }

        if(whoseTurn.equalsIgnoreCase("mob")) {
            if (mobStats.currentHP < 0){
                return "0";
            } else {
                return df.format(mobStats.currentHP);
            }
        }

        return whoseTurn;
    }

    /**
     * Turns are based on speed. The player with the highest speed will get the turn. 
     */
    public boolean isPlayerTurn() {
        if (playerTurnRate >= mobTurnRate){return true;}
        else{return false;}
    }
    
    /**
     * After an attack, we subtract the other player's turn rate to it and then give the other player their turn rate. 
     */
    public void playerTurnOver() {
        playerTurnRate -= mobStats.currentSpd;
        mobTurnRate += mobStats.currentSpd * mobStats.speedMultiplier;
        // Printer.printItalizcizedColor("Type any letter to continue...", "white");
        // scan.next();
        quickBreak(1000);
    }
    
    /**
     * Same as player turn rate, but for the mob class. 
     */
    public void mobTurnOver() {
        mobTurnRate -= playerStats.currentSpd;
        playerTurnRate += playerStats.currentSpd * playerStats.speedMultiplier;
        // Printer.printItalizcizedColor("Type any letter to continue...", "white");
        // scan.next();
        quickBreak(1000);
    }

    /**
     * Checks who died. 
     */
    private void whoDied () {
        
        if(playerStats.currentHP <= 0){
            Player.playerDied();
            
        }

        else{
            Printer.printColor(mobSummoner.getMobName() + " has been defeated[!}!", "green");
        }

    }

    public boolean didPlayerDie() {
        if(playerStats.currentHP <= 0){
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * Prints out a list of the attacks of the user, along with all the options like leave and inventory. 
     * todo: Implement leave and inventory options.
     */
    public void listAttacks() {
        int i = 0;
        Printer.printColor("Here are your moves:\n", "cyan");
        while(i < player.chosenAttacks.length) {
            Printer.printColor("("+ (i + 1) + ") "+ player.chosenAttacks[i] + "\tMP COST: "+ playerAttackCosts[i], "white");
            i++;
        }
        Printer.print("("+(i + 1)+") Inventory\n----------------------------------------------------------");

    }
    
    /**
     * Prints out the player's moves, then does the attack based on their response. 
     */
    public void playerMove() {
        listAttacks();
        
        //checks which class we are, and then prompts them to answer a thing. 
        if (player.chosenAttacks == player.getCyborgAttacks()){
            cyborgAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.getHackerAttacks()){
            hackAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.getTerminatorAttacks()){
            terminatorAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.getSwordsmanAttacks()){
            swordsmanAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.getRogueAttacks()){
            rogueAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.getMysticAttacks()){
            mysticAttack(playerStats, mobStats);
        }
        else {
            reverendAttack(playerStats, mobStats);
        }        
    }
    
    /**
     * Does the mobs move
     * 
     * @param playerStats2
     * @param mobStats2
     */
    public void mobMove() {

        double mp = mobStats.currentMP;
        ArrayList<Integer> movesWeCanDo = new ArrayList<Integer>();

        for (int i = 0; i < mobAttackCosts.length; i++) {
            if (mobAttackCosts[i] <= mp) {
                movesWeCanDo.add(i);
            }
        }
        if (movesWeCanDo.isEmpty()) {
            System.out.println("The enemy has run out of battery!");
            mobStats.currentHP = 0;
            return;
        }
        ;

        int index = random.nextInt(movesWeCanDo.size());
        if (mobAttacks == mobSummoner.CYBER_PUNK_ATTACKS) {
            cyberPunkAttack(mobStats, playerStats, index);
        }
        if (mobAttacks == mobSummoner.GREATER_WILL_ASSASSIN_ATTACKS) {
            greaterWillAssassinAttack(mobStats, playerStats, index);
        }
        if (mobAttacks == mobSummoner.NANO_BOT_ATTACKS) {
            nanoBotClusterAttacks(mobStats, playerStats, index);
        }
    }

    public void isAnyoneDisabled(){
        //Checks if the enemy is disabled. If they are, we will skip their turn and say they are disabled. 
            if(mobStats.howLongDisabled > 0){
                Printer.printColor("----------------------------------------------------------", "red");
                Printer.printColor("Mob is disabled!!!" ,"red");
                mobStats.howLongDisabled --;
                mobTurnOver();
                Printer.printColor("----------------------------------------------------------", "red");
            }

            //Checks if the player is disabled. If they are, we will skip their turn and say they are disabled. 
            if(playerStats.howLongDisabled > 0){
                Printer.printColor("----------------------------------------------------------", "red");
                Printer.printColor("Player is disabled!!!" ,"red");
                playerStats.howLongDisabled --;
                playerTurnOver();
                Printer.printColor("----------------------------------------------------------", "red");
            }
    }

    //checks if any of the player's stats are currently boosts
    public void checkPlayerBoosts(){
        //checks if the player's temp ATK multiplier is active, and then it 
            if(playerStats.howLongAtkUp > 0){
                playerStats.howLongAtkUp--;
                if(playerStats.howLongAtkUp ==0){
                    Printer.printColor("Player ATK boost over!", "cyan");
                    playerStats.applyAttackUp(1);
                }
            }

        //checks if the player's attack speed multiplier is active, and then it 
            if(playerStats.howLongSpeedUp > 0){
                playerStats.howLongSpeedUp--;
                if(playerStats.howLongSpeedUp ==0){
                    Printer.printColor("Player SPD boost over!", "cyan");
                    playerStats.applyAttackUp(1);
                }
            }
        //checks if the player's temp def multiplier is active, and then it 
            if(playerStats.howLongDefUp > 0){
                playerStats.howLongDefUp--;
                if(playerStats.howLongDefUp ==0){
                    Printer.printColor("Player ATK boost over!", "cyan");
                    playerStats.applyDefenceUp(1);
                }
            }

        //checks if the player's temp dodge multiplier is active, and then it 
            if(playerStats.howLongDodgeUp > 0){
                playerStats.howLongDodgeUp--;
                if(playerStats.howLongDodgeUp ==0){
                    Printer.printColor("Player SPD boost over!", "cyan");
                    playerStats.applyDodgeUp(1);
                }
            }



    }

    //checks if any of the mobs's stats are currently boosts
    public void checkMobBoosts(){
        //checks if the mobs's temp speed multiplier is active, and then it 
            if(mobStats.howLongSpeedUp > 0){
                mobStats.howLongSpeedUp--;
                if(mobStats.howLongSpeedUp ==0){
                    Printer.printColor("Mob SPD boost over!", "cyan");
                    mobStats.applySpeedUp(1);
                }
            }
            //checks if the mobs's temp atk multiplier is active, and then it 
            if(mobStats.howLongAtkUp>0){
                mobStats.howLongAtkUp--;
                if(mobStats.howLongAtkUp ==0){
                    Printer.printColor("Mob ATK boost over!", "cyan");
                    mobStats.applyAttackUp(1);
                }
            }

            if(mobStats.howLongDefUp > 0){
                mobStats.howLongDefUp--;
                if(mobStats.howLongDefUp ==0){
                    Printer.printColor("Mob DEF boost over!", "cyan");
                    mobStats.applyDefenceUp(1);
                }
            }
            //checks if the mobs's temp dodge multiplier is active, and then it 
            if(mobStats.howLongDodgeUp > 0){
                mobStats.howLongDodgeUp--;
                if(mobStats.howLongDodgeUp ==0){
                    Printer.printColor("Mob DODGE boost over!", "cyan");
                    mobStats.applyDodgeUp(1);
                }
            }

        
    }

    /**
     * input the time in milliseconds 
     * @param t - time in milliseconds
     */
    public void quickBreak(int t) {
        try {
                Thread.sleep(t);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    // public boolean hasPlayerDied(){
    //      return hasPlayerDied;
    // }
}
