package fightInfo;

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import Tools.*;
import PlayerInformation.*;

/**
 * This class holds all those moves used by all of our classes. 
 * Also determines which move that the character wants to use
 * also runs the enemies moves
 * WARNING: THIS CLASS IS VERY LONG
 */
public class Moves {
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    StatsCalculator calculator = new StatsCalculator();
    DecimalFormat df = new DecimalFormat("###.00");
    StatsCalculator statsCalculator = new StatsCalculator();

    //* General moves that will be used by many people
    
    /**
     * Tells the player that they do not have enough MP to use a certain attack 
     */
    public void tooTired() {
        Printer.printColor("\nToo tired! Not enough MP to use that attack", "red");
    }

    /**
     * Helps disable someone
     */
    public void disabled(int howManyTurns, Stats victimStats) {
        victimStats.setHowLongDisabled(howManyTurns);
    }


    //* Cyborg moves

    /**
     * A medium damage attack where the cyborg attacks with a lazer rifle
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void laser_barrage (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Sending Laser Barrage!", "red");
        double moveAttack = 5;
        double missMultiplier = 1.0; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    /**
     * A high damage attack where the cyborg fires a strong charged shot at the enemy
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void charged_shot (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Sending charged shot!", "red");
        double moveAttack = 7.5;
        double missMultiplier = 1.3;
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier); 
        
    }
    
    /**
     * The cyborg turns on a high density shield, which increases their defense by 50% for 4 turns
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void cyber_shield (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing defense stats for 3 turns!", "blue");
        attackerStats.defUpTime(1.5, 4);
        Printer.printColor("Your defense has increased by 50% ",  "cyan");
    }
    
    /**
     * The cyborg overloads its circuits, increasing the strength of its attacks by 50% for 4 moves. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void overload (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing attack stats for 3 rounds!", "yellow");
        attackerStats.atkUpTime(1.5, 4);
        Printer.printColor("Your Attack has increased by 50% ",  "cyan");
    }
    
    //* The Moves Of the Rogue

    /**
     * The rogue quickly plants a bomb on the enemy, dealing minimal damage
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void quick_blast (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Quickly planting explosives before running away!", "purple");
        double moveAttack = 5;
        double missMultiplier = 1.3; 
        attackerStats.speedUpTime(1.2, 2);
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    /**
     * The rogue uses a high damage blunt attack
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void death_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Rogue Sneaks up on their opponent and strikes them down. ", "white");
        double moveAttack = 9;
        double missMultiplier = 0.3; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    /**
     * The rogue poisons the enemy, greatly reducing their speed. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void secret_mushroom_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Rogue poisins the enemy, slowing them down!", "green");
        victimStats.speedUpTime(0.4, 4);
    }
    
    /**
     * This move surrounds the player in a smoke, increasing their speed and dodge capabilities
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void forbidden_smoke (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The rogue smokes the enemy, increasing mobility and their dodge capabilities!", "grey");
        attackerStats.speedUpTime(1.5, 4);
        attackerStats.dodgeUpTime(4, 4);
    }
    

    //* The Hacker's Moves

    /**
     * The hacker infects the enemy with a virus, dealing medium harm to their systems. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void virus (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The hacker uses a virus to harm enemy systems!", "yellow");
        double moveAttack = 5;
        double missMultiplier = 0.8; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    /**
     * The hacker uses malicious technology to hijack the government missiles, dealing major damage. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void stolen_missile (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Hijacking government missile...", "blue");
        double moveAttack = 10;
        double missMultiplier = 2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    /**
     * The hacker uses satellite imagery to increase their accuracy, decreasing the enemies ability to dodge. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void watchful_vulture (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Increasing accuracy (3 turns)", "blue");
        victimStats.dodgeUpTime(0.1, 4);
    }
    
    /**
     * Disables the enemy for 2 turns.
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void in_the_system (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Disabling the enemies (2 turns)...", "blue");
        disabled(2, victimStats);
    }
    

    //* The Terminators Moves

    /**
     * The terminator uses strong machine guns to tear down their enemies, using strong guns
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void machine_gun_fury (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Unleashing the Machine Gun!", "cyan");
        double moveAttack =  7;
        double missMultiplier = 0.7; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    /**
     * The terminator strikes fast, dealing minor damage. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void first_impact_fists (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Time to strike fast!", "blue");
        double moveAttack =  8;
        double missMultiplier = 1.3; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    /**
     * The player's dodge capabilities increase greatly, as the other person gets blinded. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void decieving_blast_of_cybernetic_proportions (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Blinding the enemy for 2 rounds! ", "yellow");
        attackerStats.dodgeUpTime(20, 3);
    }

    /**
     * The terminator gets into a defensive position, increasing their attack strength by 50% for some turns. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void hunker_down (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Moving to a defensive position! ", "purple");
        attackerStats.atkUpTime(1.5, 4);
    }
    
    //* The Holy Reverend's moves

    /**
     * The Holy Reverend uses some sort of flash attack on the enemy, dealing minor damage
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void holy_flash_of_radiant_light (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Unleashing God's light on the enemy!", "yellow");
        double moveAttack = 5;
        double missMultiplier = 1.3; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    /**
     * The reverend summons lightning on the enemies, dealing major damage.   
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void divine_smite (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Thunder Release!!!", "white");
        double moveAttack = 9;
        double missMultiplier = 1.8; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    /**
     * The reverend heals himself by 35%
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void holy_healing (Stats attackerStats) {
        Printer.printColor("Healing up!", "yellow");
        double howMuchHeal = (attackerStats.getMaxHP() * 0.35) + (random.nextDouble() * 10);
        attackerStats.combatHeal(howMuchHeal, attackerStats);
    }

    /**
     * The reverend prays, increasing their attack and speed greatly  
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void prayer (Stats attackerStats) {
        Printer.printColor("Praying to the lord...", "cyan");
        attackerStats.atkUpTime(2, 3);
        attackerStats.speedUpTime(2, 3);
    }

    //* These are the laser swordsman's attacks

    /**
     * The laser swordsman swiftly thrusts their sword into the enemy, dealing little damage
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void swift_thrust_of_the_sword (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman outpaces their enemy to deal a powerful blow!", "green");
        double moveAttack = 3.5;
        double missMultiplier = 1.2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    /**
     * The laser swordsman shoots, dealing medium damage. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void fatal_erruption_of_bullets (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman uses a gun to eliminate their enemies!", "yellow");
        double moveAttack = 7;
        double missMultiplier = 0.6; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    /**
     * The laser swordsman summons clones to attack the enemy. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void lightning_clone_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("The Swordsman's moves at supersonic speeds to summon clones which all attack the enemy!", "white");
        double moveAttack = 8;
        double missMultiplier = 0.2; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    /**
     * The laser swordsman meditates 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     */
    public void meditation (Stats attackerStats) {
        Printer.printColor("The swordsman is meditating to gain MP, SPD and HP...", "purple");
        //speeds up character by 20% for 2 rounds
        attackerStats.speedUpTime(1.2, 2);
        attackerStats.setCurrentMP(attackerStats.getCurrentMP() + 15);
        attackerStats.setCurrentHP(attackerStats.getCurrentHP() + 50);
    }
    
    //* These are the mystic's attack's

    /**
     * The mystic uses a strong dragon-based attack to defeat their enemies. This is a strong attack
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     */
    public void dragon_shatter (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Summoning Dragon to strike!", "white");
        double moveAttack = 10;
        double missMultiplier = 1.4; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }

    /**
     * The mystic uses a simple strike of mana, of medium damage
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     */
    public void simple_strike (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Using the simple mana strike!", "white");
        double moveAttack = 5;
        double missMultiplier = 0.5; 
        statsCalculator.doDamage(attackerStats, victimStats, moveAttack, missMultiplier);
    }
    
    /**
     * The mystic uses a frost attack, slowing down the enemy, and decreasing their dodge ability
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     */
    public void frost_eruption (Stats attackerStats, Stats victimStats) {
        Printer.printColor("Freezing the enemy", "cyan");
        victimStats.speedUpTime(0.25, 4);
        victimStats.dodgeUpTime(0.5, 4);
    }
    
    /**
     * This attack disables the enemy. 
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     */
    public void burning_prison (Stats attackerStats, Stats victimStats) {
        Printer.printColor("TRAPPING THE ENEMY!", "red");
        disabled(3, victimStats);
    }


/**
 * *These are the player attacks. They determine which attack the player wants to do, based on an index. 
 */

    /**
     * Runs the moves of the indicated class, based on the attack that they chose, and the cost of the attack. 
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     * @param attackMPcost      - the cost of the attack
     * @param index             - the index of the attack chosen
     */
    public void hackAttack(Stats attackerStats, Stats victimStats, double attackMPcost, int index) {
        switch (index) {
            
            case 1:
                attackMPcost = 0;
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                virus(attackerStats, victimStats);
                return;
            case 2:
                attackMPcost = 20;
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                stolen_missile(attackerStats, victimStats);
                return;
            case 3:
                attackMPcost = 5;
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                watchful_vulture(attackerStats, victimStats);
                return;
            case 4:
                attackMPcost = 10;
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                in_the_system(attackerStats, victimStats);
                return;
        }
    }

    
    /**
     * Runs the moves of the indicated class, based on the attack that they chose, and the cost of the attack. 
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     * @param attackMPcost      - the cost of the attack
     * @param index             - the index of the attack chosen
     */
   public void cyborgAttack(Stats attackerStats, Stats victimStats, double attackMPcost, int index) {

    //we are passed through an index based on the attack chosen by the player, which we use to run that particular attack
       switch (index) {
           case 1:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                laser_barrage(attackerStats, victimStats);
                return;

            case 2:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                charged_shot(attackerStats, victimStats);
                return;

            case 3:        
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                cyber_shield(attackerStats, victimStats);
                return;

            case 4:           
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                overload(attackerStats, victimStats);
                return;
       }
   }


   /**
     * Runs the moves of the indicated class, based on the attack that they chose, and the cost of the attack. 
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     * @param attackMPcost      - the cost of the attack
     * @param index             - the index of the attack chosen
     */
    public void terminatorAttack(Stats attackerStats, Stats victimStats, double attackMPcost, int index) {

    //we are passed through an index based on the attack chosen by the player, which we use to run that particular attack

        switch (index) {
            case 1:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                machine_gun_fury(attackerStats, victimStats);
                return;

            case 2:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                first_impact_fists(attackerStats, victimStats);
                return;

            case 3:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                decieving_blast_of_cybernetic_proportions(attackerStats, victimStats);
                return;

            case 4:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                hunker_down(attackerStats, victimStats);
                return;
        }
    }

    
    /**
     * Runs the moves of the indicated class, based on the attack that they chose, and the cost of the attack. 
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     * @param attackMPcost      - the cost of the attack
     * @param index             - the index of the attack chosen
     */
    public void swordsmanAttack(Stats attackerStats, Stats victimStats, double attackMPcost, int index) {
        
        //we are passed through an index based on the attack chosen by the player, which we use to run that particular attack
        switch (index) {
        case 1:
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            swift_thrust_of_the_sword(attackerStats, victimStats);
            return;

        case 2:
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            fatal_erruption_of_bullets(attackerStats, victimStats);
            return;

        case 3:
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            lightning_clone_strike(attackerStats, victimStats);
            return;

        case 4:
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            meditation(attackerStats);
            return;
        }
    }


    /**
     * Runs the moves of the indicated class, based on the attack that they chose, and the cost of the attack. 
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     * @param attackMPcost      - the cost of the attack
     * @param index             - the index of the attack chosen
     */
    public void rogueAttack(Stats attackerStats, Stats victimStats, double attackMPcost, int index) {

        //we are passed through an index based on the attack chosen by the player, which we use to run that particular attack
        switch (index) {
            case 1:
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            quick_blast(attackerStats, victimStats);
            return;

        case 2:
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            death_strike(attackerStats, victimStats);
            return;

        case 3:
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            secret_mushroom_strike(attackerStats, victimStats);
            return;

        case 4:
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
            forbidden_smoke(attackerStats, victimStats);
            if(!attackerStats.canSpeedUp()){Printer.printColor("Speed buff maxed out!", "yellow");}
            if(!attackerStats.canDodgeUp()){Printer.printColor("Dodge buff maxed out!", "yellow");}
            return;
        }
    }
    

    /**
     * Runs the moves of the indicated class, based on the attack that they chose, and the cost of the attack. 
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     * @param attackMPcost      - the cost of the attack
     * @param index             - the index of the attack chosen
     */
    public void mysticAttack(Stats attackerStats, Stats victimStats, double attackMPcost, int index) {      

        //we are passed through an index based on the attack chosen by the player, which we use to run that particular attack
        switch (index) {
            case 1:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                dragon_shatter(attackerStats, victimStats);
                return;

            case 2:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                simple_strike(attackerStats, victimStats);
                return;

            case 3:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                frost_eruption(attackerStats, victimStats);
                return;

            case 4:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                burning_prison(attackerStats, victimStats);
                return;
        }
    }


    /**
     * Runs the moves of the indicated class, based on the attack that they chose, and the cost of the attack. 
     * @param attackerStats     - the stats of the attacker
     * @param victimStats       - the stats of the victim
     * @param attackMPcost      - the cost of the attack
     * @param index             - the index of the attack chosen
     */
    public void reverendAttack(Stats attackerStats, Stats victimStats, double attackMPcost, int index) {

        //we are passed through an index based on the attack chosen by the player, which we use to run that particular attack
        switch (index) {
            case 1:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                holy_flash_of_radiant_light(attackerStats, victimStats);
                return;

            case 2:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                divine_smite(attackerStats, victimStats);
                return;

            case 3:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                holy_healing(attackerStats);
                return;

            case 4:
                attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMPcost);
                prayer(attackerStats);
                if(!attackerStats.canSpeedUp()){Printer.printColor("Speed buff maxed out!", "yellow");}
                if(!attackerStats.canAtkUp()){Printer.printColor("Atk buff maxed out!", "yellow");}
                return;
}
    }



    //*ENEMY ATTACKS

    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void cyberPunkAttack(Stats attackerStats, Stats victimStats, int attackMpCost, int index) {

        //This attack is the right hook. A low damage attack. 
        if(index==0){
            Printer.printColor("Punk Robot uses the classic right hook!", "white");
            double moveAttack = 3 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.8; 
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //this is a high damage attack. It is the bionic crunch
        if(index ==1){
            Printer.printColor("The Punk uses Bionic Crunch!", "white");
            double moveAttack = 6 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.8; 
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //this is the weak kick: A very weak attack
        if(index==2){
            Printer.printColor("Punk Robot uses a weak kick!", "white");
            double moveAttack = 2 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.8; 
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //This is the drunken Fist. It increases the speed and attack of the enemy. 
        if(index ==3){
            Printer.printColor("Cyberpunk drinks alcohol to increase speed and atk!", "white");
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            attackerStats.atkUpTime(2, 3);
            attackerStats.speedUpTime(2, 3);
        }
    }
    

    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void greaterWillAssassinAttack(Stats attackerStats, Stats victimStats,int attackMpCost, int index) {

        //This is the medium attack of Chromium daggers. 
        if (index == 0) {
            Printer.printColor("Greater Will Assassin throws 3 chromium daggers at you!", "white");
            double moveAttack = 3 * attackerStats.getCurrentAttack();
            double missMultiplier = 2.1;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost); 
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //this is the assasin's nano-electric volley. a high damage attack
        if (index == 1) {
            Printer.printColor("Greater Will Assassin throws many electrifying nano projectiles at you!", "white");
            double moveAttack = 5 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.4;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        // this is the assassin's frenzied kicks: low damage. 
        if (index == 2) {
            Printer.printColor("Assassin uses a series of swift kicks!", "white");
            double moveAttack = 2 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.9;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //Cruel Assassin's Flowing Fist: this is a medium damage attack
        if (index == 3) {
            Printer.printColor("Greater Will Assassin uses the rock-smashing flowing fist technique!", "white");
            double moveAttack = 2.5 * attackerStats.getCurrentAttack(); 
            double missMultiplier = 1.5;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier); 
        }
    }

    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void nanoBotClusterAttacks(Stats attackerStats, Stats victimStats, int attackMpCost, int index) {

        //Synethic Infection: This is a medium attack
        if (index == 0) {
            Printer.printColor("The Nano-Bots swarm around you and infect your body!", "white");
            double moveAttack = 2.5 * attackerStats.getCurrentAttack();
            double missMultiplier = 0;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //This is a strong attack of integrated combustion
        if (index == 1) {
            Printer.printColor("Each Nano-Bot charges towards you and explodes around you!", "white");
            double moveAttack = 7 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.4;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //This is a medium attack: Coordinated ion drill
        if (index == 2) {
            Printer.printColor("The Nano-Bot Cluster fires radioactive ions towards you!", "white");
            double moveAttack = 4 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.9;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //This is a neon-lazer cascade. 
        if (index == 3) {
            Printer.printColor("Making distance from you, the Nano-Bot Cluster fires off neon-laser beams toward you!", "white");
            double moveAttack = 4.3 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.5;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
    }
    
    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void wardenOfDirtMoves(Stats attackerStats, Stats victimStats, int attackMpCost, int index) {

        //This Strange Hurl is a strong attack
        if (index == 0) {
            Printer.printColor("The Warden Hurls a random object at you!", "white");
            double moveAttack = 8.3 * attackerStats.getCurrentAttack();
            double missMultiplier = 2;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //soil of pestilence does a medium amount of damage
        if (index == 1) {
            Printer.printColor("The Warden of Dirt uses Soil of Pestilence! You are plagued by a disease, dealing major damage!", "white");
            double moveAttack = 19 * attackerStats.getCurrentAttack();
            double missMultiplier = 0.2;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //rooted increases defensive stats
        if (index == 2) {
            Printer.printColor("The Warden uses Rooted, greatly enhancing their defensive capabilities.", "white");
            attackerStats.defUpTime(3, 4);      
            attackerStats.applyDefenceUp(4);
        }

        //souls of revengance greatly increases attack strength.         
        if (index == 3) {
            Printer.printColor("The Warden of Dirt uses souls of reveangance greatly improve their attack strength!", "white");
            attackerStats.atkUpTime(2,4);
        }
    }

    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void greaterWillArcherMoves(Stats attackerStats, Stats victimStats, int attackMpCost, int index) {

        if (index == 0) {
            // Sharpshooter
            Printer.printColor("The Greater Will Archer sends a high precision arrow at the enemy!", "white");
            double moveAttack = 1.8 * attackerStats.getCurrentAttack();
            double missMultiplier = 0.1;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //shock-dart deals medium damage, and slows down enemy
        if (index == 1) {
            Printer.printColor("The Archer fires off a shock-dart, dealing major damage and reducing your speed!", "white");
            double moveAttack = 3.4 * attackerStats.getCurrentAttack();
            double missMultiplier = 2;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            attackerStats.speedUpTime(0.75, 2);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //cloaked: Increases evasion and speed
        if (index == 2) {
            Printer.printColor("The archer puts on their cloak to increase evasion and speed", "white");
            attackerStats.dodgeUpTime(3, 3);        
            attackerStats.speedUpTime(2,3);
        }

        //aimbot: greatly increases accuracy
        if (index == 3) {
            Printer.printColor("Archer temporarily enables aim bot to greatly increase accuracy!", "white");
            victimStats.dodgeUpTime(0.1, 3);
        }
    }

    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void greaterWillSwordsmanMoves(Stats attackerStats, Stats victimStats, int attackMpCost, int index) {

        //a light attack: quick slash
        if (index == 0) {
            //Quick Slash
            Printer.printColor("Swordsman Quickly slashes the enemies!", "white");
            double moveAttack = 2.8 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.5;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //a devastatingly strong swing
        if (index == 1) {
            Printer.printColor("The Swordsman Heavily Swings their sword!", "white");
            double moveAttack = 10.3 * attackerStats.getCurrentAttack();
            double missMultiplier = 2.3;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //ultimate rage makes the swordsman angry and more powerful
        if (index == 2) {
            Printer.printColor("The swordsman becomes enraged, increasing their attack ability!" ,"white");
            attackerStats.atkUpTime(2, 3);
        }

        //lightspeed crash hurls the swordsman at you at a very high speed. 
        if (index == 3) {
            Printer.printColor("The Swordsman hurls themselves towards you at the speed of light!", "white");
            double moveAttack = 7.2 * attackerStats.getCurrentAttack();
            double missMultiplier = 4;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
    }

    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void yetiMoves(Stats attackerStats, Stats victimStats, int attackMpCost, int index) {

        //Yeti slams into you
        if (index == 0) {
            Printer.printColor("The Yeti uses body slam, dealing major damage!", "white");
            double moveAttack = 7.2 * attackerStats.getCurrentAttack();
            double missMultiplier = 2;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //Yeti slaps claws into you
        if (index == 1) {
            Printer.printColor("The Yeti swipes at you with their cataclysmic claws!", "white");
            double moveAttack = 16 * attackerStats.getCurrentAttack();
            double missMultiplier = 0.2;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //Yeti strikes you with a snowball
        if (index == 2) {
            Printer.printColor("The Yeti tosses a snowball at you!", "white");
            double moveAttack = 4.8 * attackerStats.getCurrentAttack();
            double missMultiplier = 1.4;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //a blizard speeds up the yeti, and makes them dodge more. 
        if (index == 3) {
            // Blizzard
            Printer.printColor("The yeti summons a blizzard, increasing their speed and dodge capabilities", "white");
            attackerStats.dodgeUpTime(2,4);
            attackerStats.speedUpTime(2,4);
        }
    }

    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void quantumSensoryDroidAttacks(Stats attackerStats, Stats victimStats, int attackMpCost, int index) {
        //slams enemies to the ground: Gravitational slam
        if (index == 0) {
            Printer.printColor("Quantum Sensory Droid uses gravitational slam, hurling you to the ground!", "white");
            double moveAttack = 5.3 * attackerStats.getCurrentAttack();
            double missMultiplier = 0.8;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        
        //atomic annihilation: Rips enemies to atoms
        if (index == 1) {
            Printer.printColor("The Quantum Sensory Droid attempts to break their enemy down to atoms!", "white");
            double moveAttack = 12 * attackerStats.getCurrentAttack();
            double missMultiplier = 0.2;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }

        //droid rests, 
        if (index == 2) {
            Printer.printColor("Quantum Sensory Droid powers down to heal and regenerate MP.", "white");
            attackerStats.combatHeal(attackerStats.getMaxHP() /5, attackerStats);
            attackerStats.combatRest(attackerStats.getMaxMP() /5, attackerStats);
        }

        //droid starts avoiding using astrogates
        if (index == 3) {
            Printer.printColor("The Quantum Sensory Droid greatly increases speed!", "white");
            attackerStats.speedUpTime(2,4);
        }
    }


    /**
     * This method does the attack for a mob, based on which mob they are, and which attack they chose to do during the randomization of attacks that they can afford. 
     * @param attackerStats     - The stats of the attacker
     * @param victimStats       - The stats of the victim
     * @param attackMpCost      - The attack's mp cost
     * @param index             - The index of the attack.
     */
    public void wardenOfFrostAttacks(Stats attackerStats, Stats victimStats, int attackMpCost, int index) {
        //Torrent of frost summons frost and throws it at the enemy
        if (index == 0) {
            Printer.printColor("The Warden of Frost fires a Torrent of Frost at the enemy!", "white");
            double moveAttack = 10 * attackerStats.getCurrentAttack();
            double missMultiplier = 0.8;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
    
        //icicly eruption does icicles
        if (index == 1) {
            Printer.printColor("The Warden of Frost summons Icicles from the ground, dealing medium damage!", "white");
            double moveAttack = 12 * attackerStats.getCurrentAttack();
            double missMultiplier = 0.2;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
        
        //cataclysmic blizard increases their dodge abilities
        if (index == 2) {
            Printer.printColor("The Warden of Frost summons a blizzard, greatly increasing their evasion", "white");
            attackerStats.dodgeUpTime(10, 3);
        }
    
        //relentless hailstorm does lots of damage. 
        if (index == 3) {
            // Relentless Hailstorm
            Printer.printColor("The Warden of Frost unleashes a relentless barrage of hail, dealing major damage!", "white");
            double moveAttack = 32 * attackerStats.getCurrentAttack();
            double missMultiplier = 0.2;
            attackerStats.setCurrentMP(attackerStats.getCurrentMP() - attackMpCost);
            statsCalculator.mobDoDamage(attackerStats, victimStats, moveAttack, missMultiplier);
        }
    }
}
