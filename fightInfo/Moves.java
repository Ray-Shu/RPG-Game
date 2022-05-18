package fightInfo;

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import Tools.*;
import PlayerInformation.*;

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
        victimStats.setHowLongDisabled(howManyTurns);
    }


    //* THESE ARE THE PLAYER'S ATTACKS

     // CYBORG ATTACKS: 

    public void cyborgAttack(Stats attackerStats, Stats victimStats, Player player, int index) {
        int attackMPcost;

        // int index= 0;
        // while(!scan.hasNextInt()){
        //     Printer.print("Please enter an integer");
        //     scan.next();
        // }

        //index = scan.nextInt();
        switch (index) {
            case 1:
            attackMPcost = 0;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            laser_barrage(attackerStats, victimStats);
            return;
        case 2:
            attackMPcost = 10;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            charged_shot(attackerStats, victimStats);
            return;
        case 3:
            if(!attackerStats.canDefUp()){Printer.printColor("DEF already buffed to max!", "red");break;}
            attackMPcost = 5;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            cyber_shield(attackerStats, victimStats);
            return;
        case 4:
            if(!attackerStats.canAtkUp()){Printer.printColor("ATK already buffed to max!", "red");break;}
            attackMPcost = 20;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            overload(attackerStats, victimStats);
            return;
    
        default:
            Printer.print("Please enter a valid number: ");
            break;
        }
    }

    public void laser_barrage (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Sending Laser Barrage!", "red");
        double moveAttack = 5 * attackerStats.getCurrentAttack();
        double missMultiplier = 1.0; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    public void charged_shot (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Sending charged shot!", "red");
        double moveAttack = 7.5 * attackerStats.getCurrentAttack();
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

    public void hackAttack(Stats attackerStats, Stats victimStats, Player player, int index) {
        int attackMPcost;
        // int index= 0;
        // while(!scan.hasNextInt()){
        //     Printer.print("Please enter an integer");
        //     scan.next();
        // }
        // index = scan.nextInt();

        switch (index) {
            case 1:
            attackMPcost = 0;
                if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                virus(attackerStats, victimStats);
                return;
            case 2:
                attackMPcost = 20;
                if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                stolen_missile(attackerStats, victimStats);
                return;
            case 3:
                attackMPcost = 5;
                if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                watchful_vulture(attackerStats, victimStats);
                return;
            case 4:
                attackMPcost = 10;
                if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                in_the_system(attackerStats, victimStats);
                return;
            default: 
                Printer.print("Please enter a valid number: ");
                break;
                    
        }
    }



    public void virus (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The hacker uses a virus to harm enemy systems!", "yellow");
        double moveAttack = 5 * attackerStats.getCurrentAttack();
        double missMultiplier = 0.8; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    public void stolen_missile (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Hijacking government missile...", "blue");
        double moveAttack = 17.5 * attackerStats.getCurrentAttack();
        double missMultiplier = 2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    
    public void watchful_vulture (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing accuracy (3 turns)", "blue");
        victimStats.dodgeUpTime(0.1, 4);
    }
    
    public void in_the_system (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Disabling the enemies (2 turns)...", "blue");
        disabled(2, victimStats);
    }

    // TERMINATOR ATTACKS:
    

    public void terminatorAttack(Stats attackerStats, Stats victimStats, Player player, int index) {
        int attackMPcost;
        // int index= 0;
        // while(!scan.hasNextInt()){
        //     Printer.print("Please enter an integer");
        //     scan.next();
        // }
        // index = scan.nextInt();
        switch (index) {
            case 1:
            attackMPcost = 0;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            machine_gun_fury(attackerStats, victimStats);
            return;
        case 2:
            attackMPcost = 5;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            first_impact_fists(attackerStats, victimStats);
            return;
        case 3:
            attackMPcost = 10;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            decieving_blast_of_cybernetic_proportions(attackerStats, victimStats);
            return;
        case 4:
            if(!attackerStats.canAtkUp()){Printer.printColor("ATK already buffed to max!", "red");break;}  
            attackMPcost = 10;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            hunker_down(attackerStats, victimStats);
            return;
        
        default: 
            Printer.print("Please enter a valid number: ");
            break;
        }
    }

    public void machine_gun_fury (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Unleashing the Machine Gun!", "cyan");
        double moveAttack =  9* attackerStats.getCurrentAttack();
        double missMultiplier = 0.7; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void first_impact_fists (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Time to strike fast!", "blue");
        double moveAttack =  6* attackerStats.getCurrentAttack();
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

    public void swordsmanAttack(Stats attackerStats, Stats victimStats, Player player, int index) {
        int attackMPcost;
        // int index= 0;
        // while(!scan.hasNextInt()){
        //     Printer.print("Please enter an integer");
        //     scan.next();
        // }
        // index = scan.nextInt();

        switch (index) {
            case 1:
            attackMPcost = 0;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            swift_thrust_of_the_sword(attackerStats, victimStats);
            return;
        case 2:
            attackMPcost = 13;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            fatal_erruption_of_bullets(attackerStats, victimStats);
            return;
        case 3:
            attackMPcost = 25;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            lightning_clone_strike(attackerStats, victimStats);
            return;
        case 4:
            attackMPcost = 0;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            meditation(attackerStats);
            return;
        default: 
            Printer.print("Please enter a valid number: ");
            break;     
        }
    }


    public void swift_thrust_of_the_sword (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman outpaces their enemy to deal a powerful blow!", "green");
        double moveAttack = 6 * attackerStats.getCurrentAttack();
        double missMultiplier = 1.2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void fatal_erruption_of_bullets (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman uses a gun to eliminate their enemies!", "yellow");
        double moveAttack = 15 * attackerStats.getCurrentAttack();
        double missMultiplier = 0.6; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    public void lightning_clone_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman's moves at supersonic speeds to summon clones which all attack the enemy!", "white");
        double moveAttack = 20 * attackerStats.getCurrentAttack();
        double missMultiplier = 0.2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void meditation (Stats attackerStats) {
        Printer.printColor("The swordsman is meditating to gain MP, SPD and HP...", "purple");
        //speeds up character by 20% for 2 rounds
        attackerStats.speedUpTime(1.2, 2);
        attackerStats.setCurrentMP(attackerStats.getCurrentMP() + 15);
        attackerStats.setCurrentHP(attackerStats.getCurrentHP() + 50);
    }

    // ROGUE ATTACKS: 

    public void rogueAttack(Stats attackerStats, Stats victimStats, Player player, int index) {
        int attackMPcost;
        // int index= 0;
        // while(!scan.hasNextInt()){
        //     Printer.print("Please enter an integer");
        //     scan.next();
        // }
        // index = scan.nextInt();

        switch (index) {
            case 1:
            attackMPcost = 0;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            quick_blast(attackerStats, victimStats);
            return;
        case 2:
            attackMPcost = 12;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            death_strike(attackerStats, victimStats);
            return;
        case 3:
            attackMPcost = 10;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            secret_mushroom_strike(attackerStats, victimStats);
            return;
        case 4:
            
            attackMPcost = 5;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            forbidden_smoke(attackerStats, victimStats);
            if(!attackerStats.canSpeedUp()){Printer.printColor("Speed buff maxed out!", "yellow");}
            if(!attackerStats.canDodgeUp()){Printer.printColor("Dodge buff maxed out!", "yellow");}
            // return;
                player.showInventory();
                return;
        default: 
            Printer.print("Please enter a valid number: ");
            break;
        }
    }
    //This attack deals minor damage to opponents and speeds up the attacker
    public void quick_blast (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Quickly planting explosives before running away!", "purple");
        double moveAttack = 4 * attackerStats.getCurrentAttack();
        double missMultiplier = 1.3; 
        attackerStats.speedUpTime(1.2, 2);
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    //this attack is a blunt force attack dealing major damage to the enemies
    public void death_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Rogue Sneaks up on their opponent and strikes them down. ", "white");
        double moveAttack = 6 * attackerStats.getCurrentAttack();
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

    public void mysticAttack(Stats attackerStats, Stats victimStats, Player player, int index) {
        int attackMPcost;
        // int index= 0;
        // while(!scan.hasNextInt()){
        //     Printer.print("Please enter an integer");
        //     scan.next();
        // }
        // index = scan.nextInt();
        switch (index) {
            case 1:
            attackMPcost = 22;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            dragon_shatter(attackerStats, victimStats);
            return;
        case 2:
            attackMPcost = 0;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            simple_strike(attackerStats, victimStats);
            return;
        case 3:
            attackMPcost = 10;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            frost_eruption(attackerStats, victimStats);
            return;
        case 4:
            attackMPcost = 5;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            burning_prison(attackerStats, victimStats);
            return;
        default: 
            Printer.print("Please enter a valid number: ");
            // break;
                player.showInventory();
                return;
        }
    }

    public void dragon_shatter (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Summoning Dragon to strike!", "white");
        double moveAttack = 12 * attackerStats.getCurrentAttack();
        double missMultiplier = 1.4; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void simple_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Using the simple mana strike!", "white");
        double moveAttack = 5 * attackerStats.getCurrentAttack();
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

    public void reverendAttack(Stats attackerStats, Stats victimStats, Player player, int index) {
        int attackMPcost;
        // int index= 0;
        // while(!scan.hasNextInt()){
        //             Printer.print("Please enter an integer");
        //             scan.next();
        //         }
        // index = scan.nextInt();

        switch (index) {
            case 1:
            attackMPcost = 0;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            holy_flash_of_radiant_light(attackerStats, victimStats);
            return;
        case 2:
            attackMPcost = 20;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            divine_smite(attackerStats, victimStats);
            return;
        case 3:
            attackMPcost = 10;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            holy_healing(attackerStats);
            return;
        case 4:
            attackMPcost = 10;
            if(attackMPcost > attackerStats.getCurrentMP()){tooTired(); break;}
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            prayer(attackerStats);
            if(!attackerStats.canSpeedUp()){Printer.printColor("Speed buff maxed out!", "yellow");}
            if(!attackerStats.canAtkUp()){Printer.printColor("Atk buff maxed out!", "yellow");}
            return;
        default: 
            Printer.print("Please enter a valid number: ");
            break;
        }
    }
    public void holy_flash_of_radiant_light (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Unleashing God's light on the enemy!", "yellow");
        double moveAttack = 8 * attackerStats.getCurrentAttack();
        double missMultiplier = 1.3; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void divine_smite (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Thunder Release!!!", "white");
        double moveAttack = 14.5 * attackerStats.getCurrentAttack();
        double missMultiplier = 1.8; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    public void holy_healing (Stats attackerStats) {
        Printer.printColor("Healing up!", "yellow");
        double howMuchHeal = (attackerStats.getMaxHP() * 0.35) + (random.nextDouble() * 10);
        attackerStats.combatHeal(howMuchHeal, attackerStats);
    }
    public void prayer (Stats attackerStats) {
        Printer.printColor("Praying to the lord...", "cyan");
        attackerStats.atkUpTime(2, 3);
        attackerStats.speedUpTime(2, 3);
    }



    //*ENEMY ATTACKS
    public void cyberPunkAttack(Stats attackerStats, Stats victimStats, int index) {
        int attackMpCost = 0; 

        if(index==0){
            attackMpCost = 5; 
            Printer.printColor("Punk Robot uses the classic right hook!", "white");
            double moveAttack = 3 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.8; 
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if(index ==1){
            attackMpCost = 8;
            Printer.printColor("The Punk uses Bionic Crunch!", "white");
            double moveAttack = 6 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.8; 
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if(index==2){
            attackMpCost = 3;
            Printer.printColor("Punk Robot uses a weak kick!", "white");
            double moveAttack = 2 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.8; 
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if(index ==3){
            attackMpCost = 10;
            Printer.printColor("Cyberpunk drinks alcohol to increase speed and atk!", "white");
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            attackerStats.atkUpTime(2, 3);
            attackerStats.speedUpTime(2, 3);
        }

    }
    
    public void greaterWillAssassinAttack(Stats attackerStats, Stats victimStats, int index) {
        int attackMpCost; 

        if (index == 0) {
            //Chromium Daggers
            attackMpCost = 10; 
            Printer.printColor("Greater Will Assassin throws 3 chromium daggers at you!", "white");
            double moveAttack = 3 * attackerStats.getCurrentAttack();
            double missMultiplier = 2.1;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost); 
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if (index == 1) {
            //Nano-electric Volley
            attackMpCost = 15; 
            Printer.printColor("Greater Will Assassin throws many electrifying nano projectiles at you!", "white");
            double moveAttack = 5 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.4;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if (index == 2) {
            //Frenzied Kicks
            attackMpCost = 6;
            Printer.printColor("Assassin uses a series of swift kicks!", "white");
            double moveAttack = 2 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.9;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if (index == 3) {
            //Cruel Assassin's Flowing Fist
            attackMpCost = 8;
            Printer.printColor("Greater Will Assassin uses the rock-smashing flowing fist technique!", "white");
            double moveAttack = 2.5 * attackerStats.getCurrentAttack(); 
            double missMultiplier = 1.5;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
           
        }

    }

    public void nanoBotClusterAttacks(Stats attackerStats, Stats victimStats, int index) {
        int attackMpCost;

        if (index == 0) {
            // Synethic Infection
            attackMpCost = 5;
            Printer.printColor("The Nano-Bots swarm around you and infect your body!", "white");
            double moveAttack = 2.5 * attackerStats.getCurrentAttack();
            double missMultiplier = 0;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if (index == 1) {
            // Integrated Combustion
            attackMpCost = 10;
            Printer.printColor("Each Nano-Bot charges towards you and explodes around you!", "white");
            double moveAttack = 7 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.4;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if (index == 2) {
            // Coordinated Ion Drill 
            attackMpCost = 7;
            Printer.printColor("The Nano-Bot Cluster fires radioactive ions towards you!", "white");
            double moveAttack = 4 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.9;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        if (index == 3) {
            // Neon-Laser Cascade
            attackMpCost = 8;
            Printer.printColor("Making distance from you, the Nano-Bot Cluster fires off neon-laser beams toward you!", "white");
            double moveAttack = 4.3 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.5;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);

        }

    }



    


}
