import java.util.Random;
import java.util.Scanner;

public class Moves {

    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    //* General stuff

    /**
     * Prints out that they are too tired. 
     */
    public void tooTired() {
        Printer.printColor("\nToo tired! Not enough MP to use that attack", "red");
    }

    /**
     * Skips that player for a few turns
     */
    public void disabled(int howManyTurns, Stats playerStats, Stats victimStats) {
        
    }

    /**
     * Checks if the opponent did dodge the attack. 
     */
    public boolean didDodge(Stats victimStats, double missMultiplier) {
        double effectiveDodge = victimStats.currentDodge * missMultiplier;
        if(random.nextDouble() <= effectiveDodge) {
            return true;
        }
        return false;
    }

    /**
     * Sees if the attack crit. Returns the damage if it crit or if it did not crit. 
     */
    public double applyCrit(Stats attackerStats, double damage) {
        double critDamage = attackerStats.currentCritDmg * damage;
        if(random.nextDouble() <= attackerStats.currentCritRate / 100){
            return critDamage;
        }
        return damage;
    }

    //* THESE ARE THE PLAYER'S ATTACKS

     // CYBORG ATTACKS: 

    public void cyborgAttack(Stats attackerStats, Stats victimStats) {
        int attackMPcost;
        int index= 0;
        while(!scan.hasNextInt()){
                    Printer.print("Please enter an integer");
                    scan.next();
                }
                index = scan.nextInt();
                switch (index) {
                    case 1:
                    attackMPcost = 5;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    laser_barrage(attackerStats, victimStats);
                    return;
                case 2:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    charged_shot(attackerStats, victimStats);
                    return;
                case 3:
                    attackMPcost = 5;
                    if(attackMPcost > playerStats.currentMP){tooTired(); break;}
                    cyber_shield(attackerStats, victimStats);
                    return;
                case 4:
                    attackMPcost = 20;
                    if(attackMPcost > playerStats.currentMP){tooTired(); break;}
                    overload(attackerStats, victimStats);
                    return;
                    default: 
                        Printer.print("Please enter a valid number: ");
                        break;
                }
            hackAttack(attackerStats, victimStats);
    }

     public void laser_barrage (Stats attackerStats, Stats victimStats) {
        
    }

    public void charged_shot (Stats attackerStats, Stats victimStats) {

    }

    public void cyber_shield (Stats attackerStats, Stats victimStats) {

    }

    public void overload (Stats attackerStats, Stats victimStats) {

    }

    // HACKER ATTACKS: 

    public void hackAttack(Stats attackerStats, Stats victimStats) {
        int attackMPcost;
        int index= 0;
        while(!scan.hasNextInt()){
                    Printer.print("Please enter an integer");
                    scan.next();
                }
                index = scan.nextInt();
                switch (index) {
                    case 1:
                        attackMPcost = 5;
                        if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                        drone_army(attackerStats, victimStats);
                        return;
                    case 2:
                        attackMPcost = 20;
                        if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                        stolen_missile(attackerStats, victimStats);
                        return;
                    case 3:
                        attackMPcost = 5;
                        if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                        watchful_vulture(attackerStats, victimStats);
                        return;
                    case 4:
                        attackMPcost = 10;
                        if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                        in_the_system(attackerStats, victimStats);
                        return;
                    default: 
                        Printer.print("Please enter a valid number: ");
                        break;
                }
            hackAttack(attackerStats, victimStats);
    }



    public void drone_army (Stats attackerStats, Stats victimStats) {

    }

    public void stolen_missile (Stats attackerStats, Stats victimStats) {

    }

    public void watchful_vulture (Stats attackerStats, Stats victimStats) {

    }

    public void in_the_system (Stats attackerStats, Stats victimStats) {

    }

    // TERMINATOR ATTACKS:
    public void machine_gun_fury (Stats attackerStats, Stats victimStats) {

    }
    public void first_impact_fists (Stats attackerStats, Stats victimStats) {

    }
    public void decieving_blast_of_cybernetic_proportions (Stats attackerStats, Stats victimStats) {

    }
    public void hunker_down (Stats attackerStats, Stats victimStats) {

    }
    
    // LAZER SWORDSMAN ATTACKS: 
    public void swift_thrust_of_the_sword (Stats attackerStats, Stats victimStats) {
        
    }
    public void fatal_erruption_of_bullets (Stats attackerStats, Stats victimStats) {

    }
    public void lightning_clone_strike (Stats attackerStats, Stats victimStats) {

    }
    public void rest (Stats attackerStats) {

    }

    // ROGUE ATTACKS: 
    public void quick_blast (Stats attackerStats, Stats victimStats) {

    }
    public void death_strike (Stats attackerStats, Stats victimStats) {

    }
    public void secret_mushroom_strike (Stats attackerStats, Stats victimStats) {

    }
    public void forbidden_smoke (Stats attackerStats, Stats victimStats) {

    }

    // MYSTIC ATTACKS: 
    public void dragon_shatter (Stats attackerStats, Stats victimStats) {

    }
    public void simple_strike (Stats attackerStats, Stats victimStats) {

    }
    public void frost_eruption (Stats attackerStats, Stats victimStats) {

    }
    public void burning_prison (Stats attackerStats, Stats victimStats) {

    }

    // REVEREND ATTACKS: 
    public void holy_flash_of_radiant_light (Stats attackerStats, Stats victimStats) {

    }
    public void divine_smite (Stats attackerStats, Stats victimStats) {

    }
    public void holy_healing (Stats attackerStats, Stats victimStats) {

    }
    public void prayer (Stats attackerStats, Stats victimStats) {
        
    }
}
