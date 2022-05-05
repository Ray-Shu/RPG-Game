import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Moves {

    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    StatsCalculator calculator = new StatsCalculator();
    DecimalFormat df = new DecimalFormat("###.00");
    StatsCalculator statsCalculator = new StatsCalculator();

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
    public void disabled(int howManyTurns, Stats victimStats) {
        victimStats.howLongDisabled = howManyTurns;
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
                    if(!attackerStats.canDefUp()){Printer.printColor("DEF already buffed to max!", "red");break;}
                    attackMPcost = 5;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    cyber_shield(attackerStats, victimStats);
                    return;
                case 4:
                    if(!attackerStats.canAtkUp()){Printer.printColor("ATK already buffed to max!", "red");break;}
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
        double moveAttack = 5 * attackerStats.currentAtk;
        double missMultiplier = 1.0; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    public void charged_shot (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Sending charged shot!", "red");
        double moveAttack = 7.5 * attackerStats.currentAtk;
        double missMultiplier = 1.3;
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier); 
        
    }
    
    public void cyber_shield (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing defence stats for 3 turns!", "blue");
        attackerStats.defUpTime(1.5, 4);
        Printer.printColor("Your defence has increased by 50% ",  "cyan");
    }

    public void overload (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing attack stats for 3 rounds!", "yellow");
        attackerStats.atkUpTime(1.5, 4);
        Printer.printColor("Your Attack has increased by 50% ",  "cyan");
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
                        virus(attackerStats, victimStats);
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



    public void virus (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The hacker uses a virus to harm enemy systems!", "yellow");
        double moveAttack = 5 * attackerStats.currentAtk;
        double missMultiplier = 0.8; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    public void stolen_missile (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Hijacking Government missile...", "blue");
        double moveAttack = 16 * attackerStats.currentAtk;
        double missMultiplier = 2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    
    public void watchful_vulture (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing accuracy for 3 turns", "blue");
        victimStats.dodgeUpTime(0.1, 4);
    }
    
    public void in_the_system (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Disabling the enemies...", "blue");
        disabled(2, victimStats);
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
                    attackMPcost = 15;
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
                    if(!attackerStats.canAtkUp()){Printer.printColor("ATK already buffed to max!", "red");break;}  
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
        Printer.printColor("Unleashing the Machine Gun!", "cyan");
        double moveAttack =  9* attackerStats.currentAtk;
        double missMultiplier = 0.7; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void first_impact_fists (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Time to strike fast!", "blue");
        double moveAttack =  6* attackerStats.currentAtk;
        double missMultiplier = 1.3; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void decieving_blast_of_cybernetic_proportions (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Blinding the enemy for 2 rounds! ", "yellow");
        attackerStats.dodgeUpTime(20, 3);
    }
    public void hunker_down (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Moving to a defensive position! ", "purple");
        attackerStats.atkUpTime(1.5, 3);
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
                    medatation(attackerStats);
                    return;
                default: 
                    Printer.print("Please enter a valid number: ");
                    break;
                }
            swordsmanAttack(attackerStats, victimStats);
    }


    public void swift_thrust_of_the_sword (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman outpaces their enemy to deal a powerful blow!", "green");
        double moveAttack = 6 * attackerStats.currentAtk;
        double missMultiplier = 1.2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void fatal_erruption_of_bullets (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman uses a gun to eliminate their enemies!", "yellow");
        double moveAttack = 15 * attackerStats.currentAtk;
        double missMultiplier = 0.6; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    public void lightning_clone_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman's moves at supersonic speeds to summon clones which all attack the enemy!", "white");
        double moveAttack = 20 * attackerStats.currentAtk;
        double missMultiplier = 0.2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void medatation (Stats attackerStats) {
        Printer.printColor("The swordsman is meditating to gain MP, SPD and HP...", "purple");
        //speeds up character by 20% for 2 rounds
        attackerStats.speedUpTime(1.2, 2);
        attackerStats.currentMP += 15;
        attackerStats.currentHP =+ 50;
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
                    if(!attackerStats.canSpeedUp()){Printer.printColor("Speed buff maxed out!", "yellow");}
                    if(!attackerStats.canDodgeUp()){Printer.printColor("Dodge buff maxed out!", "yellow");}
                    return;
                default: 
                    Printer.print("Please enter a valid number: ");
                    break;
                }
            rogueAttack(attackerStats, victimStats);
    }

    //This attack deals minor damage to opponents and speeds up the attacker
    public void quick_blast (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Quickly planting explosives before running away!", "purple");
        double moveAttack = 4 * attackerStats.currentAtk;
        double missMultiplier = 1.3; 
        attackerStats.speedUpTime(1.2, 2);
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    //this attack is a blunt force attack dealing major damage to the enemies
    public void death_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Rogue Sneaks up on their opponent and strikes them down. ", "white");
        double moveAttack = 12 * attackerStats.currentAtk;
        double missMultiplier = 0.3; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    //todo: Implement decay status effect
    public void secret_mushroom_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Rogue Poisins the enemy, weakening their defence", "green");
        victimStats.dodgeUpTime(0.4, 4);
    }
    
    public void forbidden_smoke (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The rogue smokes the enemy, increasing mobility and their dodge capabilities!", "grey");
        //speeds up character by 20% for 2 rounds
        attackerStats.speedUpTime(1.5, 4);
        attackerStats.dodgeUpTime(4, 4);

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
        Printer.printColor("Summoning Dragon to strike!", "white");
        double moveAttack = 20 * attackerStats.currentAtk;
        double missMultiplier = 1.4; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void simple_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Using the simple mana strike!", "white");
        double moveAttack = 5 * attackerStats.currentAtk;
        double missMultiplier = 0.5; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    public void frost_eruption (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Freezing the enemy", "cyan");
        victimStats.speedUpTime(0.25, 4);
        victimStats.dodgeUpTime(0.5, 4);
    }

    public void burning_prison (Stats attackerStats, Stats victimStats) {
        Printer.printColor("TRAPPING THE ENEMY!", "red");
        disabled(3, victimStats);
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
                    holy_flash_of_radiant_light(attackerStats, victimStats);
                    return;
                case 2:
                    attackMPcost = 20;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    divine_smite(attackerStats, victimStats);
                    return;
                case 3:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    holy_healing(attackerStats);
                    return;
                case 4:
                    attackMPcost = 10;
                    if(attackMPcost > attackerStats.currentMP){tooTired(); break;}
                    attackerStats.currentMP -= attackMPcost;
                    prayer(attackerStats);
                    if(!attackerStats.canSpeedUp()){Printer.printColor("Speed buff maxed out!", "yellow");}
                    if(!attackerStats.canAtkUp()){Printer.printColor("Atk buff maxed out!", "yellow");}
                    return;
                default: 
                    Printer.print("Please enter a valid number: ");
                    break;
                }
            reverendAttack(attackerStats, victimStats);
    }
    public void holy_flash_of_radiant_light (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Unleashing God's light on the enemy!", "yellow");
        double moveAttack = 8 * attackerStats.currentAtk;
        double missMultiplier = 1.3; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void divine_smite (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Thunder Release!!!", "white");
        double moveAttack = 13 * attackerStats.currentAtk;
        double missMultiplier = 1.8; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void holy_healing (Stats attackerStats) {
        Printer.printColor("Healing up!", "yellow");
        attackerStats.heal();
    }
    public void prayer (Stats attackerStats) {
        Printer.printColor("Praying to the lord!", "cyan");
        attackerStats.atkUpTime(2, 3);
        attackerStats.speedUpTime(2, 3);
    }

    public void cyberPunkAttack(int index) {
        if(index==1){
            
        }
        if(index ==2){

        }
        if(index==3){

        }
        if(index ==4){

        }

    }


}
