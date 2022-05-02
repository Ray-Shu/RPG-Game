import java.util.Random;

public class StatsCalculator {
    // * Calculates all of the stats for stuff 
    Random random = new Random();

    /**
     * Sees if the attack crit. Returns the damage if it crit or if it did not crit. 
     */
    public double applyCrit(double damage, double critDmg, double critRate) {
        double critDamage = critDmg * damage;
        if(random.nextDouble() <= critRate / 100){
            System.out.println("crit!");
            return critDamage;
        }
        return damage;
    }

    /**
     * DODGE WILL BE CALLED BEFORE TRUE ATTACK IS CALLED 
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
     * 
     * @param attackerStats - all of the necessary attacker stats to calculate true attack 
     * @param defenderStats - all of the necessary defender stats 
     * @return - returns the true damage of the attack, when all of the factors are considered 
     */

    public double trueDamage(Stats attackerStats, Stats defenderStats, double moveAttack) { 
        double atk = moveAttack;
        double magicDmg = attackerStats.currentMagicDmg; 
        double physDmg = attackerStats.currentPhysDmg; 
        double cr = attackerStats.currentCritRate; 
        double cd = attackerStats.currentCritDmg;

        double def = defenderStats.currentDef; 
        double magicDef = defenderStats.currentMagicRes; 
        double physDef = defenderStats.currentPhysRes; 

        //calculates the true physical damage 
        double truePhysDmg = physDmg * (100/(100 + physDef)); 

        //calculates the true magic damage 
        double trueMagicDmg = magicDmg * (100/(100 + magicDef)); 
        
        //combines attack with magicAtk and physAtk 
        atk = atk + truePhysDmg + trueMagicDmg;

        double trueAtk = atk * (100/(100 + def));

        double trueDamage = applyCrit(trueAtk, cd, cr);

        return trueDamage;
    }
}


