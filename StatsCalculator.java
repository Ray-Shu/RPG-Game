import java.util.Random;

public class StatsCalculator {
    // * Calculates all of the stats for stuff 
    Random random = new Random();

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

    /**
     * A formula to calculate the attack 
     * 
     * @param damageStats holds all of the damage stats needed to calculate true attack 
     * @return trueAttack will be the actual damage dealt 
     */
    public double trueAttack(double[] damageStats) { 
        double trueAttack = 0; 

        return trueAttack;
    }
}


