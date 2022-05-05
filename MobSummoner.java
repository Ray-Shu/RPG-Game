public class MobSummoner {
    String chosenMobAttacks[];

    final String CYBER_PUNK_ATTACKS[] = {"Right Hook!", "Bionic Crunch", "Weak Kick", "Drunken Fist!" };
    final int CP_MP_COSTS[] = {5,8,3,10};
    double[] cyberPunkValues = {150.0, 50.0, 0.5, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
    int cyber_punk_level;

    MobSummoner(){
        
    }

    public Stats newCyberPunk(int lvl){
        double lvlMultiplier = 1+ lvl/10 - 0.1;
        cyber_punk_level = lvl;
        return new Stats(cyberPunkValues[0]*lvlMultiplier, cyberPunkValues[1]*lvlMultiplier, cyberPunkValues[2]*lvlMultiplier, cyberPunkValues[3]*lvlMultiplier, cyberPunkValues[4]*lvlMultiplier, cyberPunkValues[5]*lvlMultiplier, cyberPunkValues[6]*lvlMultiplier, cyberPunkValues[7]*lvlMultiplier, cyberPunkValues[8]*lvlMultiplier, cyberPunkValues[9]*lvlMultiplier, cyberPunkValues[10]*lvlMultiplier, cyberPunkValues[11]*lvlMultiplier, cyberPunkValues[12]*lvlMultiplier, cyberPunkValues[13]*lvlMultiplier, cyberPunkValues[14]*lvlMultiplier, cyberPunkValues[15]*lvlMultiplier);
    }

    
}