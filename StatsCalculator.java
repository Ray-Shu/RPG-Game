import java.util.Random;
import java.text.DecimalFormat;

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
        double chance = random.nextDouble(100);

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
        double dodge = victimStats.currentDodge / 100; 
        double effectiveDodge = dodge * missMultiplier;
        double chance = random.nextDouble(1);

        if(chance <= effectiveDodge) {
            return true;
        }

        return false;
    }

    /**
     * 
     * @param attackerStats - all of the necessary attacker stats to calculate true attack 
     * @param defenderStats - all of the necessary defender stats 
     * @return - returns the true damage of the attack, when all of the factors are considered 
     */

    public void doDamage(Stats attackerStats, Stats victimStats, double moveAttack, double missMultiplier) { 
        double atk = moveAttack;
        double magicDmg = attackerStats.currentMagicDmg; 
        double physDmg = attackerStats.currentPhysDmg; 
        double cr = attackerStats.currentCritRate; 
        double cd = attackerStats.currentCritDmg;

        double def = victimStats.currentDef; 
        double magicDef = victimStats.currentMagicRes; 
        double physDef = victimStats.currentPhysRes; 

        //calculates the true physical damage 
        double truePhysDmg = physDmg * (100/(100 + physDef)); 

        //calculates the true magic damage 
        double trueMagicDmg = magicDmg * (100/(100 + magicDef)); 
        
        //combines attack with magicAtk and physAtk 
        atk = atk + truePhysDmg + trueMagicDmg;

        double trueAtk = atk * (100/(100 + def));

        if (didDodge(victimStats, missMultiplier)){
            Printer.print("Your attack missed!");
            return;
        }

        double trueDamage = applyCrit(trueAtk, cd, cr);

        double randomDamageMultiplier = random.nextDouble(50);
        
        trueDamage = trueDamage + (trueDamage * (randomDamageMultiplier / 100));  

        victimStats.currentHP -= trueDamage;
        Printer.printColor("Your attack did " + df.format(trueDamage) + " damage!",  "cyan");
    
    }
}


