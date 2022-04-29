import java.util.Random;
import java.util.Scanner;

public class Combat extends Moves{
    String[] mobAttacks;
    Stats  mobStats, playerStats;
    Double playerTurnRate, mobTurnRate;
    Player player;
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    int[] attackCosts;
    /**
     * Constructs a fight between a player and a mob. 
     * @param player this is the player who is fighting the mob
     * @param playerStats this is the stats of that player
     * @param mobStats this is the stats of the mob
     * @param mobAttacks this is the list of possible mob attacks. 
     */
    Combat(Player player, Stats playerStats, Stats mobStats , String[] mobAttacks){
        this.playerStats = playerStats;
        this.player = player;
        this.mobStats = mobStats;
        this.mobAttacks = mobAttacks;
        this.attackCosts = player.chosenAttacksCost;
    }

    /**
     * Turns are based on speed. The player with the highest speed will get the turn. 
     */
    public boolean isPlayerTurn() {
        if (playerTurnRate> mobTurnRate){return true;}
        else{return false;}
    }
    
    /**
     * After an attack, we subtract the other player's turn rate to it and then give the other player their turn rate. 
     */
    public void playerTurnOver() {
        playerTurnRate -= mobTurnRate;
        mobTurnRate += mobStats.currentSpd;
    }

    /**
     * Same as player turn rate, but opposite. 
     */
    public void mobTurnOver() {
        mobTurnRate -= playerTurnRate;
        playerTurnRate += playerStats.currentSpd;
    }


    

    /**
     * Prints out a list of the attacks of the user, along with all the options like leave and inventory. 
     * todo: Implement leave and inventory options. 
     */
    public void listAttacks() {
        int i = 0;
        Printer.printColor("Here are your moves:\n", "cyan");
        while(i < player.chosenAttacks.length) {
            Printer.printColor("("+ i + ") "+ player.chosenAttacks[i], "white");
            i++;
        }
        Printer.print("("+i+") Inventory");
    }
    
    public void playerMove( Stats attackerStats, Stats victimStats) {
        listAttacks();
        
        //checks which class we are, and then prompts them to answer a thing. 
        if (player.chosenAttacks == player.CYBORG_ATTACKS){
            cyborgAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.HACKER_ATTACKS){
            hackAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.TERMINATOR_ATTACKS){
            terminatorAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.SWORDSMAN_ATTACKS){
            swordsmanAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.ROGUE_ATTACKS){
            rogueAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.MYSTIC_ATTACKS){
            mysticAttack(attackerStats, victimStats);
        }
        else {
            reverendAttack(attackerStats, victimStats);
        }        
    }


    /**
     * Does the mobs move
     */
    public void mobMove() {

    }

    
}
