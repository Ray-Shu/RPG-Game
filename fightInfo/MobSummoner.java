package fightInfo;

import PlayerInformation.*;
public class MobSummoner {

    private String mobName;
    private String chosenMobAttacks[];
    private int[] chosenAttackCosts;

    //*Used cuz i dont wanna keep checking back and forth if im inputting the right stats, will delete once done
    //maxHP, maxMP, maxSpd, maxAtk, maxPhysDmg, maxMagicDmg, maxDef, maxEnd, maxStam, maxPhysRes, maxMagicRes, maxDodge, maxVit, maxCritRate,maxCritDmg,maxLuck;

    private final String CYBER_PUNK_ATTACKS[] = {"Right Hook!", "Bionic Crunch", "Weak Kick", "Drunken Fist!" };
    private final int CP_MP_COSTS[] = {5,8,3,10};
    private double[] cyberPunkValues = {100.0, 50.0, 0.5, 2.0, 4.0, 1.0, 10.0, 5.0, 40.0, 8.0, 7.0, 1.0, 1.0, 1.0, 1.0, 1.0};

    private final String GREATER_WILL_ASSASSIN_ATTACKS[] = {"Chromium Daggers!", "Nano-electric Volley!", "Frenzied Kicks!", "Cruel Assassin's Flowing Fist!"};
    private final int GREATER_WILL_ASSASSIN_COSTS[] = {10, 15, 6, 8};
    private double[] GreaterWillAssassinStats = {110, 60, 1.3, 2.5, 3.0, 4.0, 7, 4.0, 140.0, 6.0, 6.0, 4.0, 2.0, 3.0, 9.0, 1.0};
    
    private final String NANO_BOT_ATTACKS[] = {"Synthetic Infection!", "Integrated Combustion!", "Coordinated Ion Drill!", "Neon-Laser Cascade!"}; 
    private final int NANO_BOT_COST[] = {5, 10, 7, 8}; 
    private double[] nanoBotStats = {150, 60, 0.9, 3.0, 5.0, 1.0, 5, 2.0, 130, 3, 3, 2.0, 1.0, 4.5, 4.0, 1.0}; 
    
    private final String[] WARDEN_OF_DIRT_ATTACKS = {"Strange Hurl", "Soil of Pestilence", "Rooted", "Souls of Reveangance"};
    private final int[] WARDEN_DIRT_ATTACK_COSTS = {40,20,10,30};
    private double[] WardenDirtStats = {450, 400, 20, 20, 20.0, 3, 10, 4.0, 240, 6, 6, 2.0, 2.0, 4.5, 4.0, 3.0}; 

    //* Returns Arrays of Attacks
    //returns the greater will assasin's attacks
    public String[] getGreaterWillAssasinAttacks(){return GREATER_WILL_ASSASSIN_ATTACKS;}

    //returns the cyber punk's attacks
    public String[] getCyberPunkAttacks(){return CYBER_PUNK_ATTACKS;}

    //returns the nano bot's attacks
    public String[] getNanoBotAttacks(){return NANO_BOT_ATTACKS;}

    //returns the warden of dirt's attacks
    public String[] getWardenOfDirtAttacks(){return WARDEN_OF_DIRT_ATTACKS;}


    //* Returns Array's of attack costs. 

    //returns the greater will assasin's attack costs
    public int[] getGreaterWillAssasinAttackCosts(){return GREATER_WILL_ASSASSIN_COSTS;}

    //returns the cyber punk's attack costs
    public int[] getCyberPunkAttackCosts(){return CP_MP_COSTS;}

    //returns the nano bot's attack costs
    public int[] getNanoBotAttackCosts(){return NANO_BOT_COST;}

    //returns the warden of dirt's attack costs
    public int[] getWardenOfDirtAttackCosts(){return WARDEN_DIRT_ATTACK_COSTS;}

    // ?ion drill: fire radioactive ions towards you
    
    /**
     * Creates a new cyberpunk with a given level
     * @param lvl is the level of the mob
     * @return the stats of cyberpunk
     */
    public Stats newCyberPunk(int lvl){
        
        mobName = "Cyberpunk";
        chosenMobAttacks = CYBER_PUNK_ATTACKS;
        chosenAttackCosts = CP_MP_COSTS;
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
        chosenAttackCosts = GREATER_WILL_ASSASSIN_COSTS;

        double lvlMultiplier = 1 + (double)lvl/10 - 0.1;
        return new Stats( GreaterWillAssassinStats[0] * lvlMultiplier, GreaterWillAssassinStats[1] * lvlMultiplier, GreaterWillAssassinStats[2] * lvlMultiplier, 
                GreaterWillAssassinStats[3] * lvlMultiplier, GreaterWillAssassinStats[4] * lvlMultiplier, GreaterWillAssassinStats[5] * lvlMultiplier,
                GreaterWillAssassinStats[6] * lvlMultiplier, GreaterWillAssassinStats[7] * lvlMultiplier, GreaterWillAssassinStats[8] * lvlMultiplier, 
                GreaterWillAssassinStats[9] * lvlMultiplier, GreaterWillAssassinStats[10] * lvlMultiplier, GreaterWillAssassinStats[11] * lvlMultiplier,
                GreaterWillAssassinStats[12] * lvlMultiplier, GreaterWillAssassinStats[13] * lvlMultiplier, GreaterWillAssassinStats[14] * lvlMultiplier, GreaterWillAssassinStats[15] * lvlMultiplier);


    }

    public Stats newWardenDirtStats(int lvl){
        mobName = "Warden of Dirt"; 
        chosenMobAttacks = WARDEN_OF_DIRT_ATTACKS; 
        chosenAttackCosts = WARDEN_DIRT_ATTACK_COSTS;

        double lvlMultiplier = 1 + (double)lvl/10 - 0.1;

        return new Stats( WardenDirtStats[0] * lvlMultiplier, WardenDirtStats[1] * lvlMultiplier, WardenDirtStats[2] * lvlMultiplier, 
                WardenDirtStats[3] * lvlMultiplier, WardenDirtStats[4] * lvlMultiplier, WardenDirtStats[5] * lvlMultiplier,
                WardenDirtStats[6] * lvlMultiplier, WardenDirtStats[7] * lvlMultiplier, WardenDirtStats[8] * lvlMultiplier, 
                WardenDirtStats[9] * lvlMultiplier, WardenDirtStats[10] * lvlMultiplier, WardenDirtStats[11] * lvlMultiplier,
                WardenDirtStats[12] * lvlMultiplier, WardenDirtStats[13] * lvlMultiplier, WardenDirtStats[14] * lvlMultiplier, WardenDirtStats[15] * lvlMultiplier);

    }

    public Stats newNanoBotCluster(int lvl) {
        mobName = "Nano-Bot Cluster"; 
        chosenMobAttacks = NANO_BOT_ATTACKS; 
        chosenAttackCosts = NANO_BOT_COST;

        double lvlMultiplier = 1 + (double)lvl/10 - 0.1;
        
        return new Stats(
                nanoBotStats[0] * lvlMultiplier, nanoBotStats[1] * lvlMultiplier, nanoBotStats[2] * lvlMultiplier,
                nanoBotStats[3] * lvlMultiplier, nanoBotStats[4] * lvlMultiplier, nanoBotStats[5] * lvlMultiplier,
                nanoBotStats[6] * lvlMultiplier, nanoBotStats[7] * lvlMultiplier, nanoBotStats[8] * lvlMultiplier,
                nanoBotStats[9] * lvlMultiplier, nanoBotStats[10] * lvlMultiplier, nanoBotStats[11] * lvlMultiplier,
                nanoBotStats[12] * lvlMultiplier, nanoBotStats[13] * lvlMultiplier, nanoBotStats[14] * lvlMultiplier, nanoBotStats[15] * lvlMultiplier);
    }

    

    //@returns mob name
    public String getMobName(){
        return mobName;
    }
    
    //@return chosen Attacks
    public String[] getChosenAttacks(){
        return chosenMobAttacks;
    }

    //@return cost of the mobs attacks
    public int[] getChosenAttackCosts(){
        return chosenAttackCosts;
    }
}