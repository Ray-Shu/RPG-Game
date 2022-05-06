public class MobSummoner {

    public String chosenMobAttacks[];
    public final String CYBER_PUNK_ATTACKS[] = {"Right Hook!", "Bionic Crunch", "Weak Kick", "Drunken Fist!" };
    public final int CP_MP_COSTS[] = {5,8,3,10};

    private double[] cyberPunkValues = {150.0, 50.0, 0.5, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
    private String mobName;
    
    /**
     * Creates a new cyberpunk with a given level
     * @param lvl is the level of the mob
     * @return the stats of the new cyberpunk. 
     */
    public Stats newCyberPunk(int lvl){
        
        mobName = "Cyber Punk";
        chosenMobAttacks = CYBER_PUNK_ATTACKS;

        //Calculates the mob's stats based on their level
        double lvlMultiplier = 1+ lvl/10 - 0.1;
        return new Stats(cyberPunkValues[0] * lvlMultiplier, cyberPunkValues[1] * lvlMultiplier, cyberPunkValues[2] * lvlMultiplier, cyberPunkValues[3] * lvlMultiplier,
                 cyberPunkValues[4] * lvlMultiplier, cyberPunkValues[5] * lvlMultiplier, cyberPunkValues[6] * lvlMultiplier, cyberPunkValues[7] * lvlMultiplier, 
                 cyberPunkValues[8] * lvlMultiplier, cyberPunkValues[9] * lvlMultiplier, cyberPunkValues[10] * lvlMultiplier, cyberPunkValues[11] * lvlMultiplier, 
                 cyberPunkValues[12] * lvlMultiplier, cyberPunkValues[13] * lvlMultiplier, cyberPunkValues[14] * lvlMultiplier, cyberPunkValues[15] * lvlMultiplier);

    }

    //@returns mob name
    public String getMobName(){
        return mobName;
    }
}