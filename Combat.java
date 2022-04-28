import java.util.Random;

public class Combat extends Moves{
    String[] mobAttacks;
    Stats  mobStats, playerStats;
    Double playerTurnRate, mobTurnRate;
    Player player;
    Random random = new Random();
    
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

    public void playerAttack() {
        
    }

    public void mobAttack() {

    }

    public void listAttacks() {
        Printer.printColor("Here are your moves:\n", "cyan");
        for (int i = 0; i < player.chosenAttacks.length; i++) {
            Printer.printColor("("+ i + ") "+ player.chosenAttacks[i], "white");
        }
    }

    public void disabled(Stats playerStats, Stats victimStats) {
        
    }

    public boolean didDodge(Stats victimStats, double missMultiplier) {
        double effectiveDodge = victimStats.currentDodge * missMultiplier;
        if(random.nextDouble() <= effectiveDodge) {
            return true;
        }
        return false;
    }

    public double applyCrit(Stats attackerStats, double damage) {
        double critDamage = attackerStats.currentCritDmg * damage;
        if(random.nextDouble() <= attackerStats.currentCritRate / 100){
            return critDamage;
        }
        return damage;
    }
    
    public void doMove(int index, Stats playerStats, Stats victimStats) {
        //checks if we are a cyborg class
        if (player.chosenAttacks == player.CYBORG_ATTACKS){
            switch (index) {
                case 1:
                    laser_barrage(playerStats, victimStats);
                    break;
                case 2:
                    charged_shot(playerStats, victimStats);
                    break;
                case 3:
                    cyber_shield(playerStats, victimStats);
                    break;
                case 4:
                    overload(playerStats, victimStats);
                    break;
            }
        }

        //checks if we are a hacker
        else if (player.chosenAttacks == player.HACKER_ATTACKS){
            switch (index) {
                case 1:
                    drone_army(playerStats, victimStats);
                    break;
                case 2:
                    stolen_missile(playerStats, victimStats);
                    break;
                case 3:
                    watchful_vulture(playerStats, victimStats);
                    break;
                case 4:
                    in_the_system(playerStats, victimStats);
                    break;
            }
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

        //checks if we are a Mystic
        else if (player.chosenAttacks == player.MYSTIC_ATTACKS){
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

        // we are the reverend
        else {
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



        
        
    }
}
