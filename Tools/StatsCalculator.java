package Tools;

import java.util.Random;
import java.text.DecimalFormat;
import PlayerInformation.*;
public class StatsCalculator {
    // * Calculates all of the stats for stuff 
    Random random = new Random();
    DecimalFormat df = new DecimalFormat("###.00");
    
    /**
     * Sees if the attack crit. Returns the damage if it crit or if it did not crit. 
     */
    public double applyCrit(double damage, double critDmg, double critRate) {
        critDmg = 2;
        double critDamage = critDmg * damage;
        double chance = random.nextDouble() * 100; 

        if(chance <= critRate){
            Printer.printColor("Critical hit!", "red");
            return critDamage;
        }

        return damage;
    }

    /**
     * DODGE WILL BE CALLED BEFORE TRUE ATTACK IS CALLED 
     * Checks if the opponent did dodge the attack. 
     */
    public boolean didDodge(Stats victimStats, double missMultiplier) {
        double victimDodge = victimStats.getCurrentDodge() * (victimStats.getDodgeMultiplier() / 100); 
        double effectiveDodge = victimDodge * missMultiplier;
        double chance = random.nextDouble();

        if(chance <= effectiveDodge) {
            return true;
        }

        return false;
    }

    /**
     * Calculates the proper amount of damage a character should do
     * @param attackerStats - all of the necessary attacker stats to calculate true attack 
     * @param defenderStats - all of the necessary defender stats 
     * @param moveAttack - the strength of the attack
     * @param missMultiplier - makes an attack more or less likely to strike the target. 
     * @return - returns the true damage of the attack, when all of the factors are considered 
     */

    public void doDamage(Stats attackerStats, Stats victimStats, double moveAttack, double missMultiplier) { 

        //These are the stats that we will need for calculating the correct damage
        double atk = moveAttack * attackerStats.getCurrentAttack();
        double magicDmg = attackerStats.getCurrentMagicDmg(); 
        double physDmg = attackerStats.getCurrentPhysDmg(); 
        double cr = attackerStats.getCurrentCritRate(); 
        double cd = attackerStats.getCurrentCritDmg();
        double def = victimStats.getCurrentDef() * victimStats.getDefMultiplier();
        double magicDef = victimStats.getCurrentMagicRes(); 
        double physDef = victimStats.getCurrentPhysRes(); 

        //calculates the true physical damage 
        double truePhysDmg = physDmg * (100/(100 + physDef)); 

        //calculates the true magic damage 
        double trueMagicDmg = magicDmg * (100/(100 + magicDef)); 
        
        //combines attack with magicAtk and physAtk 
        atk = atk + truePhysDmg + trueMagicDmg;

        double trueAtk = atk * (100/(100 + def));

        //Checks if the attack will hit or not
        if (didDodge(victimStats, missMultiplier)){
            Printer.print("Your attack missed!");
            return;
        }

        double trueDamage = applyCrit(trueAtk, cd, cr);

        double randomDamageMultiplier = random.nextDouble() * 20;
        
        //calculates the damage which the player will take after crit and randomization
        trueDamage = (trueDamage + (trueDamage * (randomDamageMultiplier / 100))) / 1.35;  
        victimStats.setCurrentHP(victimStats.getCurrentHP() - trueDamage);

        Printer.printColor("Your attack did " + df.format(trueDamage) + " damage!",  "cyan");
    
    }
    public void mobDoDamage(Stats attackerStats, Stats victimStats, double moveAttack, double missMultiplier) { 

        //These are the stats that we will need for calculating the correct damage
        double atk = moveAttack * attackerStats.getAtkMultiplier();
        double magicDmg = attackerStats.getCurrentMagicDmg(); 
        double physDmg = attackerStats.getCurrentPhysDmg(); 
        double cr = attackerStats.getCurrentCritRate(); 
        double cd = attackerStats.getCurrentCritDmg();
        double def = victimStats.getCurrentDef() * victimStats.getDefMultiplier();
        double magicDef = victimStats.getCurrentMagicRes(); 
        double physDef = victimStats.getCurrentPhysRes(); 

        //calculates the true physical damage 
        double truePhysDmg = physDmg * (100/(100 + physDef)); 

        //calculates the true magic damage 
        double trueMagicDmg = magicDmg * (100/(100 + magicDef)); 
        
        //combines attack with magicAtk and physAtk 
        atk = atk + truePhysDmg + trueMagicDmg;

        double trueAtk = atk * (100/(100 + def));

        //Checks if the attack will hit or not
        if (didDodge(victimStats, missMultiplier)){
            Printer.print("You dodged enemy attack!");
            return;
        }

        double trueDamage = applyCrit(trueAtk, cd, cr);

        double randomDamageMultiplier = random.nextInt(50);
        
        //calculates the damage which the player will take after crit and randomization
        trueDamage = trueDamage + (trueDamage * (randomDamageMultiplier / 100));  
        victimStats.setCurrentHP(victimStats.getCurrentHP() - trueDamage);

        Printer.printColor("Their attack did " + df.format(trueDamage) + " damage!",  "cyan");
    
    }
}


