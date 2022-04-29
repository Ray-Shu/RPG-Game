import java.util.Random;
import java.util.Scanner;

public class Moves {

    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    StatsCalculator calculator = new StatsCalculator();

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
                    attackerStats.currentMP -= attackMPcost;
                    laser_barrage(attackerStats, victimStats);
                    return;
                case 2:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    charged_shot(attackerStats, victimStats);
                    return;
                case 3:
                    attackMPcost = 5;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    cyber_shield(attackerStats, victimStats);
                    return;
                case 4:
                    attackMPcost = 20;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    overload(attackerStats, victimStats);
                    return;
                    default: 
                        Printer.print("Please enter a valid number: ");
                        break;
                }
            cyborgAttack(attackerStats, victimStats);
    }

    public void laser_barrage (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Sending Laser Barrage!", "red");
    }

    public void charged_shot (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Sending charged shot!", "red");

    }

    public void cyber_shield (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing defence stats!", "blue");
    }

    public void overload (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing attack stats!", "yellow");
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
                        attackerStats.currentMP -= attackMPcost;
                        drone_army(attackerStats, victimStats);
                        return;
                    case 2:
                        attackMPcost = 20;
                        if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                        attackerStats.currentMP -= attackMPcost;
                        stolen_missile(attackerStats, victimStats);
                        return;
                    case 3:
                        attackMPcost = 5;
                        if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                        attackerStats.currentMP -= attackMPcost;
                        watchful_vulture(attackerStats, victimStats);
                        return;
                    case 4:
                        attackMPcost = 10;
                        if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                        attackerStats.currentMP -= attackMPcost;
                        in_the_system(attackerStats, victimStats);
                        return;
                    default: 
                        Printer.print("Please enter a valid number: ");
                        break;
                }
            hackAttack(attackerStats, victimStats);
    }



    public void drone_army (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Summoning drone army!", "green");
    }

    public void stolen_missile (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Stealing missile", "blue");
    }

    public void watchful_vulture (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing defence stats!", "blue");
    }

    public void in_the_system (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing defence stats!", "blue");
    }

    // TERMINATOR ATTACKS:
    

    public void terminatorAttack(Stats attackerStats, Stats victimStats) {
        int attackMPcost;
        int index= 0;
        while(!scan.hasNextInt()){
                    Printer.print("Please enter an integer");
                    scan.next();
                }
                index = scan.nextInt();
                switch (index) {
                    case 1:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    machine_gun_fury(attackerStats, victimStats);
                    return;
                case 2:
                    attackMPcost = 5;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    first_impact_fists(attackerStats, victimStats);
                    return;
                case 3:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    decieving_blast_of_cybernetic_proportions(attackerStats, victimStats);
                    return;
                case 4:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    hunker_down(attackerStats, victimStats);
                    return;
                default: 
                    Printer.print("Please enter a valid number: ");
                    break;
                }
            terminatorAttack(attackerStats, victimStats);
    }

    public void machine_gun_fury (Stats attackerStats, Stats victimStats) {

    }
    public void first_impact_fists (Stats attackerStats, Stats victimStats) {

    }
    public void decieving_blast_of_cybernetic_proportions (Stats attackerStats, Stats victimStats) {

    }
    public void hunker_down (Stats attackerStats, Stats victimStats) {

    }
    
    // LAZER SWORDSMAN ATTACKS: 

    public void swordsmanAttack(Stats attackerStats, Stats victimStats) {
        int attackMPcost;
        int index= 0;
        while(!scan.hasNextInt()){
                    Printer.print("Please enter an integer");
                    scan.next();
                }
                index = scan.nextInt();
                switch (index) {
                    case 1:
                    attackMPcost = 7;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    swift_thrust_of_the_sword(attackerStats, victimStats);
                    return;
                case 2:
                    attackMPcost = 13;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    fatal_erruption_of_bullets(attackerStats, victimStats);
                    return;
                case 3:
                    attackMPcost = 25;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    lightning_clone_strike(attackerStats, victimStats);
                    return;
                case 4:
                    attackMPcost = 0;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    death_strike(attackerStats, victimStats);
                    return;
                default: 
                    Printer.print("Please enter a valid number: ");
                    break;
                }
            swordsmanAttack(attackerStats, victimStats);
    }

    public void swift_thrust_of_the_sword (Stats attackerStats, Stats victimStats) {
        
    }
    public void fatal_erruption_of_bullets (Stats attackerStats, Stats victimStats) {

    }
    public void lightning_clone_strike (Stats attackerStats, Stats victimStats) {

    }
    public void rest (Stats attackerStats) {

    }

    // ROGUE ATTACKS: 

    public void rogueAttack(Stats attackerStats, Stats victimStats) {
        int attackMPcost;
        int index= 0;
        while(!scan.hasNextInt()){
                    Printer.print("Please enter an integer");
                    scan.next();
                }
                index = scan.nextInt();
                switch (index) {
                    case 1:
                    attackMPcost = 4;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    quick_blast(attackerStats, victimStats);
                    return;
                case 2:
                    attackMPcost = 12;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    death_strike(attackerStats, victimStats);
                    return;
                case 3:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    secret_mushroom_strike(attackerStats, victimStats);
                    return;
                case 4:
                    attackMPcost = 5;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    forbidden_smoke(attackerStats, victimStats);
                    return;
                default: 
                    Printer.print("Please enter a valid number: ");
                    break;
                }
            rogueAttack(attackerStats, victimStats);
    }
    public void quick_blast (Stats attackerStats, Stats victimStats) {

    }
    public void death_strike (Stats attackerStats, Stats victimStats) {

    }
    public void secret_mushroom_strike (Stats attackerStats, Stats victimStats) {

    }
    public void forbidden_smoke (Stats attackerStats, Stats victimStats) {

    }

    // MYSTIC ATTACKS: 

    public void mysticAttack(Stats attackerStats, Stats victimStats) {
        int attackMPcost;
        int index= 0;
        while(!scan.hasNextInt()){
                    Printer.print("Please enter an integer");
                    scan.next();
                }
                index = scan.nextInt();
                switch (index) {
                    case 1:
                    attackMPcost = 22;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    dragon_shatter(attackerStats, victimStats);
                    return;
                case 2:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    simple_strike(attackerStats, victimStats);
                    return;
                case 3:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    frost_eruption(attackerStats, victimStats);
                    return;
                case 4:
                    attackMPcost = 5;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    burning_prison(attackerStats, victimStats);
                    return;
                default: 
                    Printer.print("Please enter a valid number: ");
                    break;
                }
            mysticAttack(attackerStats, victimStats);
    }

    public void dragon_shatter (Stats attackerStats, Stats victimStats) {

    }
    public void simple_strike (Stats attackerStats, Stats victimStats) {

    }
    public void frost_eruption (Stats attackerStats, Stats victimStats) {

    }
    public void burning_prison (Stats attackerStats, Stats victimStats) {

    }

    // REVEREND ATTACKS: 

    public void reverendAttack(Stats attackerStats, Stats victimStats) {
        int attackMPcost;
        int index= 0;
        while(!scan.hasNextInt()){
                    Printer.print("Please enter an integer");
                    scan.next();
                }
                index = scan.nextInt();
                switch (index) {
                    case 1:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    dragon_shatter(attackerStats, victimStats);
                    return;
                case 2:
                    attackMPcost = 20;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    simple_strike(attackerStats, victimStats);
                    return;
                case 3:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    frost_eruption(attackerStats, victimStats);
                    return;
                case 4:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    burning_prison(attackerStats, victimStats);
                    return;
                default: 
                    Printer.print("Please enter a valid number: ");
                    break;
                }
            reverendAttack(attackerStats, victimStats);
    }
    public void holy_flash_of_radiant_light (Stats attackerStats, Stats victimStats) {

    }
    public void divine_smite (Stats attackerStats, Stats victimStats) {

    }
    public void holy_healing (Stats attackerStats, Stats victimStats) {

    }
    public void prayer (Stats attackerStats, Stats victimStats) {
        
    }
}
