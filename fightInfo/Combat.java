package fightInfo; 

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import PlayerInformation.*;
import Tools.*;
/**
 * This class does all the stuff we need to have a fight. We use information from moves to pull off our combat scenes. 
 */
public class Combat extends Moves{
    
    private DecimalFormat df = new DecimalFormat("###.00");
    private Random random = new Random();

    private int[] mobAttackCosts, playerAttackCosts;
    private double playerTurnRate, mobTurnRate;
    private Stats  mobStats, playerStats;
    private Inventory playerInventory;
    private MobSummoner mobSummoner;
    private String[] playerAttacks;
    private PlayerCreation creator; 
    private String[] mobAttacks;
    private Player player; 
    
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

        this.playerAttackCosts = player.getAttacksCosts();
        this.playerAttacks = player.getChosenAttacks();
        this.mobAttackCosts = mobAttacksCost;
        this.creator = player.getCreator();
        this.mobSummoner = mobSummoner;
        this.playerStats = playerStats;
        this.mobAttacks = mobAttacks;
        this.mobStats = mobStats;
        this.player = player;

        playerTurnRate = playerStats.getCurrentSpeed();   
        mobTurnRate = mobStats.getCurrentSpeed();
        
    }

    /**
     * Creates a fight between the player and a robot. They take turns based on who has a higher turn rate,
     * which is based on the speed of the player and robot, and try to defeat each other before they die. 
     * 
     * @param isTutorial        - If it is a tutorial, we will print out some information about how to do combat
     */
    public void fight(boolean isTutorial) {

        boolean hasMobAttacked = isTutorial;

        //while no one is dead, we will keep looping the fight
        while(playerStats.getCurrentHP() > 0 && mobStats.getCurrentHP() > 0){

            //checks if it is a tutorial. If it is, we tell the a bit about how to fight. 
            if (isTutorial) {
                Printer.printColor("\nWelcome to your first fight! Both you and your opponent will have attacks which use MP. \nYour goal is to use those attacks to defeat your enemy before dying or running out of MP! \n", "purple"); 
                isTutorial = false;
            }

            //if the player is not disabled, and their turn rate is higher than the mobs, they will get a turn. 
            if (isPlayerTurn() && playerStats.getHowLongDisabled() == 0){
                
                //tells player it is their turn and their mp and their enemy's remaining HP
                System.out.println("\u001B[36m-----------------------------------------------------------\u001B[36m");
                Printer.printColor("It is your turn! Your current MP: "+ df.format(playerStats.getCurrentMP()) + " | Enemy HP: "+ df.format(mobStats.getCurrentHP()) + "\n", "cyan");
                
                listAttacks();
                
                //makes them enter in another number if the option does not correspond to an attack or the inventory. 
                int option = ErrorChecker.intWithMinAndMax(1, 5, "Choose an attack", "white");
                if(option != 5){
                    playerMove(option); 
                } else {
                    //if they want to use the inventory, we will repeat their turn after it, as they did not make an attack. 
                    //Repeat is in the show inventory method. 
                    showInventory();  
                    return;
                }
                
                //checks the player to see if they have any more active boost, and decreases them by one. 
                checkPlayerBoosts();
                System.out.println();

                //the stuff after the character's turn is over. 
                Printer.printColor("Enemy HP after attack: " + checkIfZeroHP(mobStats) + "\n", "cyan");
                System.out.println("\u001B[36m-----------------------------------------------------------\u001B[36m");
                playerTurnOver();
                
            }

            //if the mob is not disabled and it is the mob's turn, we 
            else if (!isPlayerTurn() && mobStats.getHowLongDisabled() == 0){

                System.out.println("\u001B[31m-----------------------------------------------------------\u001B[31m");
                
                //if it is a tutorial, we will say a warning before the enemies attack once. 
                if(hasMobAttacked){
                    Printer.print("Watch out! It is the enemies turn and they are going to attack you! ");
                    hasMobAttacked = false;
                }

                //gives some info about the mob, before attacking and decreasing any timed boosts we may have. 
                Printer.printColor("It is the opponents turn! " + mobSummoner.getMobName() + "'s current MP: " + df.format(mobStats.getCurrentMP()) + " Your HP: "+ df.format(playerStats.getCurrentHP()) + "\n", "red");
                mobMove();
                checkMobBoosts();
                System.out.println();

                //tells the player some information about their health, before ending the player's turn. 
                Printer.printColor("Your HP After Attack: " +  checkIfZeroHP(playerStats) + "\n", "red");
                System.out.println("\u001B[31m-----------------------------------------------------------\u001B[31m");
                mobTurnOver();

            }

            //if neither the player or mob is disabled, we will check who is disabled
            else {
                isAnyoneDisabled();
            }

        }

        //checks who died, before printing that the fights over.
        whoDied();
        Printer.printColor("Fight Over", "yellow");
        Printer.printColor(". \n. \n. \n", "yellow");

        //ending boosts: 

        playerStats.atkUpTime(1,0);
        playerStats.defUpTime(1, 0);
        playerStats.setHowLongDisabled(0);
        playerStats.dodgeUpTime(1,0);
        playerStats.speedUpTime(1,0);
        return;

    }   

    //ensures that after the player exits the inventory, they still have their turn 
    public void showInventory(){
        player.showInventory();
        fight(false); 
    }

    /**
     * Checks the HP of the player or the mob, before returning the HP as 0 if they are dead, or just formatted. 
     * @param whoseTurn:    The stats of the person who we want to check
     * @return a string of the number of whose turn it is. 
     */
    public String checkIfZeroHP(Stats whoseTurn) {
        //if their HP is too low, we will 
        if (whoseTurn.getCurrentHP() < 0) {
            return "0";
        } else {
            return df.format(whoseTurn.getCurrentHP());
        }
    
    }

    /**
     * checks if it is the player's turn. Player's turn occurs when their turnrate is greater than or equal to  that of the mob
     * @return: True if it is the player's turn, false if else. 
     */
    public boolean isPlayerTurn() {
        if (playerTurnRate >= mobTurnRate){return true;}
        else{return false;}
    }
    
    /**
     * After an attack, we subtract the other player's turn rate to it and then give the other player their turn rate. 
     */
    public void playerTurnOver() {
        playerTurnRate -= mobStats.getCurrentSpeed();
        mobTurnRate += mobStats.getCurrentSpeed() * mobStats.getSpeedMultiplier();
        Printer.quickBreak(1000);
    }
    
    /**
     * Same as player turn rate, but for the mob class. 
     */
    public void mobTurnOver() {
        mobTurnRate -= playerStats.getCurrentSpeed();
        playerTurnRate += playerStats.getCurrentSpeed() * playerStats.getSpeedMultiplier();
        Printer.quickBreak(1000);
    }

    /**
     * Checks who died. 
     */
    private void whoDied () {
        
        //if it was the player who died, we will play the player death method. 
        if(playerStats.getCurrentHP() <= 0){
            Player.playerDied();
        }
        //if the mob died, we run their death message. 
        else{
            Printer.printColor(mobSummoner.getMobName() + " has been defeated!", "green");
        }

    }

    /**
     * Gives a boolean of whether or not it was the player who died in the fight
     * @return: True if the player did die, false if else. 
     */
    public boolean didPlayerDie() {
        if(playerStats.getCurrentHP() <= 0){
            return true;
        }
        return false;
    }

    /**
     * Prints out a list of the attacks of the user, along with all the options like leave and inventory. 
     */
    public void listAttacks() {

        int i = 0;
        Printer.printColor("Here are your moves:\n", "cyan");

        //prints out the name of the attack and its mp cost, and then an index to access it when calling it. 
        while(i < playerAttacks.length) {
            System.out.println("("+ (i + 1) + ") "+ playerAttacks[i] + "\tMP COST: "+ playerAttackCosts[i]);
            i++;
        }

        System.out.println("("+(i + 1)+") Inventory");  
        System.out.println("\u001B[36m-----------------------------------------------------------\u001B[36m");
    }
    
    /**
     * This method checks which class the player chose by comparing their attacks to the array of cyborg attacks, before 
     * running those attacks.  
     */
    public void playerMove(int option) {
        
        //This checks which class the player is, and then runs their respected moves based on that. 
        if (playerAttacks == creator.getCyborgAttacks()){
            cyborgAttack(playerStats, mobStats, player, option);
        }
        else if (playerAttacks == creator.getHackerAttacks()){
            hackAttack(playerStats, mobStats, player, option);
        }
        else if (playerAttacks == creator.getTerminatorAttacks()){
            terminatorAttack(playerStats, mobStats, player, option);
        }
        else if (playerAttacks == creator.getSwordsmanAttacks()){
            swordsmanAttack(playerStats, mobStats, player, option);
        }
        else if (playerAttacks == creator.getRogueAttacks()){
            rogueAttack(playerStats, mobStats, player, option);
        }
        else if (playerAttacks == creator.getMysticAttacks()){
            mysticAttack(playerStats, mobStats, player, option);
        }
        else {
            reverendAttack(playerStats, mobStats, player, option);
        }        
    }
    
    /**
     * Does the mobs move.
     * 
     * @param playerStats2
     * @param mobStats2
     */
    public void mobMove() {

        double mp = mobStats.getCurrentMP();
        ArrayList<Integer> movesWeCanDo = new ArrayList<Integer>();

        //fills an arrayList with all the moves that we could possibly afford with our current mp
        for (int i = 0; i < mobAttackCosts.length; i++) {
            //puts the index of the mob attack cost into the array, so we can reference the size of the array later.
            if (mobAttackCosts[i] <= mp) {
                movesWeCanDo.add(i);
            }
        }

        //If the mob lacks the necessary MP to do an attack, they will die. 
        if (movesWeCanDo.isEmpty()) {
            System.out.println("The enemy has run out of battery!");
            mobStats.setCurrentHP(0.0);
            return;
        }
    
        //gets a random attack from the list of attacks that we are able to do. 
        int index = random.nextInt(movesWeCanDo.size());

        //Determines the mob, and then uses their attacks
        if (mobAttacks == mobSummoner.getCyberPunkAttacks()) {
            cyberPunkAttack(mobStats, playerStats, index);
        }
        
        //Determines the mob, and then uses their attacks
        if (mobAttacks == mobSummoner.getGreaterWillAssasinAttacks()) {
            greaterWillAssassinAttack(mobStats, playerStats, index);
        }
        
        //Determines the mob, and then uses their attacks
        if (mobAttacks == mobSummoner.getNanoBotAttacks()){
            nanoBotClusterAttacks(mobStats, playerStats, index);
        }

        //Determines the mob, and then uses their attacks
        if (mobAttacks == mobSummoner.getWardenOfDirtAttacks()){
            wardenOfDirtMoves(mobStats, playerStats, index);
        }
        
        

    }

    public void isAnyoneDisabled(){
        //Checks if the enemy is disabled. If they are, we will skip their turn and say they are disabled. 
            if(mobStats.getHowLongDisabled() > 0){
                Printer.printColor("----------------------------------------------------------", "red");
                Printer.printColor("Mob is disabled!!!" ,"red");
                mobStats.setHowLongDisabled(mobStats.getHowLongDisabled() -1);
                mobTurnOver();
                Printer.printColor("----------------------------------------------------------", "red");
            }

            //Checks if the player is disabled. If they are, we will skip their turn and say they are disabled. 
            if(playerStats.getHowLongDisabled() > 0){
                Printer.printColor("----------------------------------------------------------", "red");
                Printer.printColor("Player is disabled!!!" ,"red");
                playerStats.setHowLongDisabled(playerStats.getHowLongDisabled() -1);
                playerTurnOver();
                Printer.printColor("----------------------------------------------------------", "red");
            }
    }

    //checks if any of the player's stats are currently boosts
    public void checkPlayerBoosts(){
        //checks if the player's temp ATK multiplier is active, and then it 
            if(playerStats.getHowLongAtkUp() > 0){
                playerStats.setHowLongAtkUp(playerStats.getHowLongAtkUp() - 1);
                if(playerStats.getHowLongAtkUp() ==0){
                    Printer.printColor("Player ATK boost over!", "cyan");
                    playerStats.applyAttackUp(1);
                }
            }

        //checks if the player's attack speed multiplier is active, and then it 
            if(playerStats.getHowLongSpeedUp() > 0){
                playerStats.setHowLongSpeedUp(playerStats.getHowLongSpeedUp() - 1);
                if(playerStats.getHowLongSpeedUp()==0){
                    Printer.printColor("Player SPD boost over!", "cyan");
                    playerStats.applyAttackUp(1);
                }
            }
        //checks if the player's temp def multiplier is active, and then it 
            if(playerStats.getHowLongDefUp()> 0){
                playerStats.setHowLongDefUp(playerStats.getHowLongDefUp() - 1);
                if(playerStats.getHowLongDefUp() ==0){
                    Printer.printColor("Player DEF boost over!", "cyan");
                    playerStats.applyDefenceUp(1);
                }
            }

        //checks if the player's temp dodge multiplier is active, and then it 
            if(playerStats.getHowLongDodgeUp() > 0){
                playerStats.setHowLongDodgeUp(playerStats.getHowLongDodgeUp() - 1);
                if(playerStats.getHowLongDodgeUp() ==0){
                    Printer.printColor("Player DODGE boost over!", "cyan");
                    playerStats.applyDodgeUp(1);
                }
            }



    }

    //checks if any of the mobs's stats are currently boosts
    public void checkMobBoosts(){
        //checks if the mobs's temp speed multiplier is active, and then it 
            if(mobStats.getHowLongSpeedUp() > 0){
                mobStats.setHowLongSpeedUp(mobStats.getHowLongSpeedUp() - 1);
                if(mobStats.getHowLongSpeedUp() ==0){
                    Printer.printColor("Mob SPD boost over!", "cyan");
                    mobStats.applySpeedUp(1);
                }
            }
            //checks if the mobs's temp atk multiplier is active, and then it 
            if(mobStats.getHowLongAtkUp()>0){
                mobStats.setHowLongAtkUp(mobStats.getHowLongAtkUp() - 1);
                if(mobStats.getHowLongAtkUp() ==0){
                    Printer.printColor("Mob ATK boost over!", "cyan");
                    mobStats.applyAttackUp(1);
                }
            }

            if(mobStats.getHowLongDefUp() > 0){
                mobStats.setHowLongDefUp(mobStats.getHowLongDefUp() - 1);
                if(mobStats.getHowLongDefUp() ==0){
                    Printer.printColor("Mob DEF boost over!", "cyan");
                    mobStats.applyDefenceUp(1);
                }
            }
            //checks if the mobs's temp dodge multiplier is active, and then it 
            if(mobStats.getHowLongDodgeUp() > 0){
                mobStats.setHowLongDodgeUp(mobStats.getHowLongDodgeUp() -1);
                if(mobStats.getHowLongDodgeUp() ==0){
                    Printer.printColor("Mob DODGE boost over!", "cyan");
                    mobStats.applyDodgeUp(1);
                }
            }

        
    }
}
