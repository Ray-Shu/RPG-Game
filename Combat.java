import java.util.Random;
import java.util.Scanner;

public class Combat extends Moves{
    String[] mobAttacks;
    Stats  mobStats, playerStats;
    Double playerTurnRate, mobTurnRate;
    Player player;
    Random random = new Random();
    Scanner scan = new Scanner(System.in);

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
        Printer.printColor("Here are your moves:\n", "cyan");
        for (int i = 0; i < player.chosenAttacks.length; i++) {
            Printer.printColor("("+ i + ") "+ player.chosenAttacks[i], "white");
        }
    }
    
    public void playerMove( Stats attackerStats, Stats victimStats) {
        int attackMPcost;
        int index= 0;
        //checks if we are a cyborg class
        if (player.chosenAttacks == player.CYBORG_ATTACKS){
            cyborgAttack(attackerStats, victimStats);
        }

        //checks if we are a hacker
        else if (player.chosenAttacks == player.HACKER_ATTACKS){
            hackAttack(attackerStats, victimStats);
        }

        //checks if we are a terminator
        else if (player.chosenAttacks == player.TERMINATOR_ATTACKS){
            switch (index) {
                case 1:
                    machine_gun_fury(playerStats, victimStats);
                    break;
                case 2:
                    first_impact_fists(playerStats, victimStats);
                    break;
                case 3:
                    decieving_blast_of_cybernetic_proportions(playerStats, victimStats);
                    break;
                case 4:
                    hunker_down(playerStats, victimStats);
                    break;
            }
        }
        //checks if we are a Laser Swordsman
        else if (player.chosenAttacks == player.SWORDSMAN_ATTACKS){
            switch (index) {
                case 1:
                    swift_thrust_of_the_sword(playerStats, victimStats);
                    break;
                case 2:
                    fatal_erruption_of_bullets(playerStats, victimStats);
                    break;
                case 3:
                    lightning_clone_strike(playerStats, victimStats);
                    break;
                case 4:
                    rest(playerStats);
                    break;
            }
        }

        //checks if we are a rogue
        else if (player.chosenAttacks == player.ROGUE_ATTACKS){
            switch (index) {
                case 1:
                    quick_blast(playerStats, victimStats);
                    break;
                case 2:
                    death_strike(playerStats, victimStats);
                    break;
                case 3:
                    secret_mushroom_strike(playerStats, victimStats);
                    break;
                case 4:
                    forbidden_smoke(playerStats, victimStats);
                    break;
            }
        }

        //checks if we are a Mystic
        else if (player.chosenAttacks == player.MYSTIC_ATTACKS){
            switch (index) {
                case 1:
                    dragon_shatter(playerStats, victimStats);
                    break;
                case 2:
                    simple_strike(playerStats, victimStats);
                    break;
                case 3:
                    frost_eruption(playerStats, victimStats);
                    break;
                case 4:
                    burning_prison(playerStats, victimStats);
                    break;
            }
        }

        // we are the reverend
        else {
            switch (index) {
                case 1:
                    holy_flash_of_radiant_light(playerStats, victimStats);
                    break;
                case 2:
                    divine_smite(playerStats, victimStats);
                    break;
                case 3:
                    holy_healing(playerStats, victimStats);
                    break;
                case 4:
                    prayer(playerStats, victimStats);
                    break;
            }
        }        
    }


    /**
     * Does the mobs move
     */
    public void mobMove() {

    }

    
}
