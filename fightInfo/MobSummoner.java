package fightInfo;

import PlayerInformation.*;
public class MobSummoner {

    private String mobName;
    public String chosenMobAttacks[];

    public final String CYBER_PUNK_ATTACKS[] = {"Right Hook!", "Bionic Crunch", "Weak Kick", "Drunken Fist!" };
    public final int CP_MP_COSTS[] = {5,8,3,10};
    public double[] cyberPunkValues = {150.0, 50.0, 0.5, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};

    public final String GREATER_WILL_ASSASSIN[] = {"Chromium Daggers!", "Nano-electric Volley!", "Frenzied Kicks!", "Cruel Assassin's Flowing Fist!"};
    public final int GREATER_WILL_ASSASSIN_COSTS[] = {10, 15, 6, 8};
    public double[] GreaterWillAssassinStats = {200, 60, 2.0, 5.0, 6.0, 4.0, 3.5, 4.0, 140.0, 4.0, 4.0, 4.0, 2.0, 3.0, 9.0, 1.0};
    
    /**
     * Creates a new cyberpunk with a given level
     * @param lvl is the level of the mob
     * @return the stats of cyberpunk
     */
    public Stats newCyberPunk(int lvl){
        
        mobName = "Cyberpunk"
        chosenMobAttacks = CYBER_PUNK_ATTACKS;

        //Calculates the mob's stats based on their level
        double lvlMultiplier = 1+ lvl/10 - 0.1;
        for (double stat : mobStats) {
            stat = stat * lvlMultiplier; 
        }
        
        return new Stats(mobStats[0], mobStats[1], mobStats[2], mobStats[3], mobStats[4], mobStats[5], mobStats[6], mobStats[7], mobStats[8], mobStats[9], mobStats[10], mobStats[11], mobStats[12], mobStats[13], mobStats[14], mobStats[15]);

        // return new Stats(cyberPunkValues[0] * lvlMultiplier, cyberPunkValues[1] * lvlMultiplier, cyberPunkValues[2] * lvlMultiplier, cyberPunkValues[3] * lvlMultiplier,
        //          cyberPunkValues[4] * lvlMultiplier, cyberPunkValues[5] * lvlMultiplier, cyberPunkValues[6] * lvlMultiplier, cyberPunkValues[7] * lvlMultiplier, 
        //          cyberPunkValues[8] * lvlMultiplier, cyberPunkValues[9] * lvlMultiplier, cyberPunkValues[10] * lvlMultiplier, cyberPunkValues[11] * lvlMultiplier, 
        //          cyberPunkValues[12] * lvlMultiplier, cyberPunkValues[13] * lvlMultiplier, cyberPunkValues[14] * lvlMultiplier, cyberPunkValues[15] * lvlMultiplier);

    }

    //@returns mob name
    public String getMobName(){
        return mobName;
    }
    
}