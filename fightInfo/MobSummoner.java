package fightInfo;

import PlayerInformation.*;
public class MobSummoner {

    private String mobName;
    public String chosenMobAttacks[];

    public final String CYBER_PUNK_ATTACKS[] = {"Right Hook!", "Bionic Crunch", "Weak Kick", "Drunken Fist!" };
    public final int CP_MP_COSTS[] = {5,8,3,10};
    public double[] cyberPunkValues = {150.0, 50.0, 0.5, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};

    public final String GREATER_WILL_ASSASSIN_ATTACKS[] = {"Chromium Daggers!", "Nano-electric Volley!", "Frenzied Kicks!", "Cruel Assassin's Flowing Fist!"};
    public final int GREATER_WILL_ASSASSIN_COSTS[] = {10, 15, 6, 8};
    public double[] GreaterWillAssassinStats = {200, 60, 2.0, 5.0, 6.0, 4.0, 3.5, 4.0, 140.0, 4.0, 4.0, 4.0, 2.0, 3.0, 9.0, 1.0};
    
    /**
     * Creates a new cyberpunk with a given level
     * @param lvl is the level of the mob
     * @return the stats of cyberpunk
     */
    public Stats newCyberPunk(int lvl){
        
        mobName = "Cyberpunk";
        chosenMobAttacks = CYBER_PUNK_ATTACKS;

        //Calculates the mob's stats based on their level
        double lvlMultiplier = 1 + (double)lvl/10 - 0.1;

        return new Stats(cyberPunkValues[0] * lvlMultiplier, cyberPunkValues[1] * lvlMultiplier, cyberPunkValues[2] * lvlMultiplier, cyberPunkValues[3] * lvlMultiplier,
                 cyberPunkValues[4] * lvlMultiplier, cyberPunkValues[5] * lvlMultiplier, cyberPunkValues[6] * lvlMultiplier, cyberPunkValues[7] * lvlMultiplier, 
                 cyberPunkValues[8] * lvlMultiplier, cyberPunkValues[9] * lvlMultiplier, cyberPunkValues[10] * lvlMultiplier, cyberPunkValues[11] * lvlMultiplier, 
                 cyberPunkValues[12] * lvlMultiplier, cyberPunkValues[13] * lvlMultiplier, cyberPunkValues[14] * lvlMultiplier, cyberPunkValues[15] * lvlMultiplier);

    }

    public Stats newGreaterWillAssassin(int lvl){
        mobName = "Greater Will Assassin"; 
        chosenMobAttacks = GREATER_WILL_ASSASSIN_ATTACKS; 

        double lvlMultiplier = 1 + lvl / 10 - 0.1;

        return new Stats( GreaterWillAssassinStats[0] * lvlMultiplier, GreaterWillAssassinStats[1] * lvlMultiplier, GreaterWillAssassinStats[2] * lvlMultiplier, 
                GreaterWillAssassinStats[3] * lvlMultiplier, GreaterWillAssassinStats[4] * lvlMultiplier, GreaterWillAssassinStats[5] * lvlMultiplier,
                GreaterWillAssassinStats[6] * lvlMultiplier, GreaterWillAssassinStats[7] * lvlMultiplier, GreaterWillAssassinStats[8] * lvlMultiplier, 
                GreaterWillAssassinStats[9] * lvlMultiplier, GreaterWillAssassinStats[10] * lvlMultiplier, GreaterWillAssassinStats[11] * lvlMultiplier,
                GreaterWillAssassinStats[12] * lvlMultiplier, GreaterWillAssassinStats[13] * lvlMultiplier, GreaterWillAssassinStats[14] * lvlMultiplier, GreaterWillAssassinStats[15] * lvlMultiplier);

    }

    //@returns mob name
    public String getMobName(){
        return mobName;
    }
    
}