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
    private double[] cyberPunkValues = {100.0, 50.0, 0.5, 4, 4.0, 1.0, 10.0, 5.0, 40.0, 8.0, 7.0, 1.0, 1.0, 1.0, 1.0, 1.0};
    
    private final String GREATER_WILL_ASSASSIN_ATTACKS[] = {"Chromium Daggers!", "Nano-electric Volley!", "Frenzied Kicks!", "Cruel Assassin's Flowing Fist!"};
    private final int GREATER_WILL_ASSASSIN_COSTS[] = {10, 15, 6, 8};
    private double[] greaterWillAssassinStats = {110, 60, 1.3, 2.9, 6.0, 4.0, 7, 4.0, 140.0, 6.0, 6.0, 4.0, 2.0, 3.0, 9.0, 1.0};
    
    private final String NANO_BOT_ATTACKS[] = {"Synthetic Infection!", "Integrated Combustion!", "Coordinated Ion Drill!", "Neon-Laser Cascade!"}; 
    private final int NANO_BOT_COST[] = {5, 10, 7, 8}; 
    private double[] nanoBotStats = {150, 60, 0.9, 5.0, 5.0, 1.0, 5, 2.0, 130, 3, 3, 2.0, 1.0, 4.5, 4.0, 1.0}; 
    
    private final String[] WARDEN_OF_DIRT_ATTACKS = {"Strange Hurl", "Soil of Pestilence", "Rooted", "Souls of Reveangance"};
    private final int[] WARDEN_DIRT_ATTACK_COSTS = {40,20,10,30};
    private double[] wardenDirtStats = {320, 90, 0.7, 2.1, 5.0, 5 , 10, 4.0, 240, 6, 6, 2.0, 2.0, 4.5, 4.0, 3.0}; 
    
    private final String[] GREATER_WILL_ARCHER_ATTACKS = {"Sharpshooter", "Shock-dart","Cloaked", "Aim Bot"};
    private final int[] GREATER_WILL_ARCHER_ATTACK_COSTS = {7,15,5,5};
    private double[] greaterWillArcherStats = {100.0, 65.0, 1.3, 5, 5, 1.0, 3, 5, 40.0, 3.0, 3.0, 1.0, 1.0, 1.0, 1.0, 1.0};
    
    private final String[] GREATER_WILL_SWORDSMAN_ATTACKS = {"Quick Slash","Devastating Swing","Ultimate Rage","Light-speed Crash"};
    private final int[] GREATER_WILL_SWORDSMAN_ATTACK_COSTS = {6,15,10,15};
    private double[] greaterWillSwordsmanStats = {125.0, 85.0, 0.9, 5.2, 4, 2.0, 5, 9, 80.0, 8.0, 5.0, 1.0, 1.0, 1.3, 1.3, 1.0};
    
    //Stats stat = new Stats(hp, mp, spd, atk, pd, md, def, end, stam, physRes, magicRes, dodge, vit, cr, cd, luck);
    private final String[] YETIS_ATTACKS = {"Body Slam","Cataclysmic Claws","Snowball Strike","Blizzard"};
    private final int[] YETIS_ATTACK_COSTS = {11,22,7,8};
    private double[] yetiStats = {230.0, 100.0, 0.9, 6, 5, 4.0, 3, 5, 100.0, 8.0, 8.0, 0.8, 1.0, 1.4, 1.4, 1.0};
    
    private final String[] QUANTUM_SENSORY_DROID_ATTACKS = {"Gravitational Slam!", "Atomic Annihilation!", "Power-down", "Astrogate Evasion!"};
    private final int[] QUANTUM_SENSORY_DROID_ATTACK_COSTS = {9, 15, 0, 5};
    private double[] quantumSensoryDroidStats = {80.0, 90.0, 2.3, 10, 3, 5, 4, 5, 10.0, 30.0, 3.0, 1.0, 1.0, 2.0, 2.0, 1.0};   
    
    private final String[] WARDEN_OF_FROST_ATTACKS = {"Torrent of Frost", "Icicle Eruption", "Cataclysmic Blizzard", "Relentless Hailstorm"};
    private final int[] WARDEN_OF_FROST_ATTACK_COSTS = {10, 15, 9, 25};
    private double[] wardenOfFrostStats = {400, 100, 1.2, 10, 5.0, 5 , 10, 4.0, 240, 6, 6, 2.0, 2.0, 4.5, 4.0, 3.0}; 
    
    //Stats stat = new Stats(hp, mp, spd, atk, pd, md, def, end, stam, physRes, magicRes, dodge, vit, cr, cd, luck);

    //* Returns Arrays of Attacks
    //returns the greater will assasin's attacks
    public String[] getGreaterWillAssasinAttacks(){return GREATER_WILL_ASSASSIN_ATTACKS;}

    //returns the cyber punk's attacks
    public String[] getCyberPunkAttacks(){return CYBER_PUNK_ATTACKS;}

    //returns the nano bot's attacks
    public String[] getNanoBotAttacks(){return NANO_BOT_ATTACKS;}

    //returns the warden of dirt's attacks
    public String[] getWardenOfDirtAttacks(){return WARDEN_OF_DIRT_ATTACKS;}

    //returns the greater will archer's attacks
    public String[] getGreaterWillArcherAttacks(){return GREATER_WILL_ARCHER_ATTACKS;}
    
    //returns the greater will swordsman's attacks
    public String[] getGreaterWillSwordsmanAttacks(){return GREATER_WILL_SWORDSMAN_ATTACKS;}
    
    //returns the yeti's attacks
    public String[] getYetiAttacks(){return YETIS_ATTACKS;}
    
    //returns the quantum sensory droid's attacks
    public String[] getQuantumSensoryDroidAttacks(){return QUANTUM_SENSORY_DROID_ATTACKS;}

    //returns the warden of frost's attacks
    public String[] getWardenOfFrostAttacks(){return WARDEN_OF_FROST_ATTACKS;}

    //* Returns Array's of attack costs. 

    //returns the greater will assasin's attack costs
    public int[] getGreaterWillAssasinAttackCosts(){return GREATER_WILL_ASSASSIN_COSTS;}

    //returns the cyber punk's attack costs
    public int[] getCyberPunkAttackCosts(){return CP_MP_COSTS;}

    //returns the nano bot's attack costs
    public int[] getNanoBotAttackCosts(){return NANO_BOT_COST;}

    //returns the warden of dirt's attack costs
    public int[] getWardenOfDirtAttackCosts(){return WARDEN_DIRT_ATTACK_COSTS;}
    
    //returns the greater will archer's attack costs
    public int[] getGreaterWillArcherAttackCosts(){return GREATER_WILL_ARCHER_ATTACK_COSTS;}

    //returns the greater will swordsman attacks costs
    public int[] getGreaterWillSwordsmanAttackCosts(){return GREATER_WILL_SWORDSMAN_ATTACK_COSTS;}

    //returns the yeti's attack costs
    public int[] getYetiAttackCosts(){return YETIS_ATTACK_COSTS;}

    //returns the quantum sensory droid attack costs
    public int[] getQuantumSensoryDroidAttackCosts(){return QUANTUM_SENSORY_DROID_ATTACK_COSTS;}

    //returns the Warden Of Frost's attack costs
    public int[] getWardenOfFrostAttackCosts(){return WARDEN_OF_FROST_ATTACK_COSTS;}
    
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
        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;

        return new Stats(cyberPunkValues[0] * lvlMultiplier, cyberPunkValues[1] * lvlMultiplier, cyberPunkValues[2] * lvlMultiplier, cyberPunkValues[3] * lvlMultiplier,
                 cyberPunkValues[4] * lvlMultiplier, cyberPunkValues[5] * lvlMultiplier, cyberPunkValues[6] * lvlMultiplier, cyberPunkValues[7] * lvlMultiplier, 
                 cyberPunkValues[8] * lvlMultiplier, cyberPunkValues[9] * lvlMultiplier, cyberPunkValues[10] * lvlMultiplier, cyberPunkValues[11] * lvlMultiplier, 
                 cyberPunkValues[12] * lvlMultiplier, cyberPunkValues[13] * lvlMultiplier, cyberPunkValues[14] * lvlMultiplier, cyberPunkValues[15] * lvlMultiplier);

    }

    public Stats newGreaterWillAssassin(int lvl){
        mobName = "Greater Will Assassin"; 
        chosenMobAttacks = GREATER_WILL_ASSASSIN_ATTACKS; 
        chosenAttackCosts = GREATER_WILL_ASSASSIN_COSTS;

        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;
        return new Stats( greaterWillAssassinStats[0] * lvlMultiplier, greaterWillAssassinStats[1] * lvlMultiplier, greaterWillAssassinStats[2] * lvlMultiplier, 
                greaterWillAssassinStats[3] * lvlMultiplier, greaterWillAssassinStats[4] * lvlMultiplier, greaterWillAssassinStats[5] * lvlMultiplier,
                greaterWillAssassinStats[6] * lvlMultiplier, greaterWillAssassinStats[7] * lvlMultiplier, greaterWillAssassinStats[8] * lvlMultiplier, 
                greaterWillAssassinStats[9] * lvlMultiplier, greaterWillAssassinStats[10] * lvlMultiplier, greaterWillAssassinStats[11] * lvlMultiplier,
                greaterWillAssassinStats[12] * lvlMultiplier, greaterWillAssassinStats[13] * lvlMultiplier, greaterWillAssassinStats[14] * lvlMultiplier, greaterWillAssassinStats[15] * lvlMultiplier);


    }

    public Stats newWardenDirtStats(int lvl){
        mobName = "Warden of Dirt"; 
        chosenMobAttacks = WARDEN_OF_DIRT_ATTACKS; 
        chosenAttackCosts = WARDEN_DIRT_ATTACK_COSTS;

        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;

        return new Stats( wardenDirtStats[0] * lvlMultiplier, wardenDirtStats[1] * lvlMultiplier, wardenDirtStats[2] * lvlMultiplier, 
                wardenDirtStats[3] * lvlMultiplier, wardenDirtStats[4] * lvlMultiplier, wardenDirtStats[5] * lvlMultiplier,
                wardenDirtStats[6] * lvlMultiplier, wardenDirtStats[7] * lvlMultiplier, wardenDirtStats[8] * lvlMultiplier, 
                wardenDirtStats[9] * lvlMultiplier, wardenDirtStats[10] * lvlMultiplier, wardenDirtStats[11] * lvlMultiplier,
                wardenDirtStats[12] * lvlMultiplier, wardenDirtStats[13] * lvlMultiplier, wardenDirtStats[14] * lvlMultiplier, wardenDirtStats[15] * lvlMultiplier);

    }

    public Stats newNanoBotCluster(int lvl) {
        mobName = "Nano-Bot Cluster"; 
        chosenMobAttacks = NANO_BOT_ATTACKS; 
        chosenAttackCosts = NANO_BOT_COST;

        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;
        
        return new Stats(
                nanoBotStats[0] * lvlMultiplier, nanoBotStats[1] * lvlMultiplier, nanoBotStats[2] * lvlMultiplier,
                nanoBotStats[3] * lvlMultiplier, nanoBotStats[4] * lvlMultiplier, nanoBotStats[5] * lvlMultiplier,
                nanoBotStats[6] * lvlMultiplier, nanoBotStats[7] * lvlMultiplier, nanoBotStats[8] * lvlMultiplier,
                nanoBotStats[9] * lvlMultiplier, nanoBotStats[10] * lvlMultiplier, nanoBotStats[11] * lvlMultiplier,
                nanoBotStats[12] * lvlMultiplier, nanoBotStats[13] * lvlMultiplier, nanoBotStats[14] * lvlMultiplier, nanoBotStats[15] * lvlMultiplier);
    }

    public Stats newGreaterWillArcher(int lvl) {
        mobName = "Greater Will Archer"; 
        chosenMobAttacks = GREATER_WILL_ARCHER_ATTACKS; 
        chosenAttackCosts = GREATER_WILL_ARCHER_ATTACK_COSTS;

        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;
        
        return new Stats(
                greaterWillArcherStats[0] * lvlMultiplier, greaterWillArcherStats[1] * lvlMultiplier, greaterWillArcherStats[2] * lvlMultiplier,
                greaterWillArcherStats[3] * lvlMultiplier, greaterWillArcherStats[4] * lvlMultiplier, greaterWillArcherStats[5] * lvlMultiplier,
                greaterWillArcherStats[6] * lvlMultiplier, greaterWillArcherStats[7] * lvlMultiplier, greaterWillArcherStats[8] * lvlMultiplier,
                greaterWillArcherStats[9] * lvlMultiplier, greaterWillArcherStats[10] * lvlMultiplier, greaterWillArcherStats[11] * lvlMultiplier,
                greaterWillArcherStats[12] * lvlMultiplier, greaterWillArcherStats[13] * lvlMultiplier, greaterWillArcherStats[14] * lvlMultiplier, greaterWillArcherStats[15] * lvlMultiplier);
    }

    public Stats newGreaterWillSwordsman(int lvl) {
        mobName = "Greater Will Swordsman"; 
        chosenMobAttacks = GREATER_WILL_SWORDSMAN_ATTACKS; 
        chosenAttackCosts = GREATER_WILL_SWORDSMAN_ATTACK_COSTS;

        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;
        
        return new Stats(
                greaterWillSwordsmanStats[0] * lvlMultiplier, greaterWillSwordsmanStats[1] * lvlMultiplier, greaterWillSwordsmanStats[2] * lvlMultiplier,
                greaterWillSwordsmanStats[3] * lvlMultiplier, greaterWillSwordsmanStats[4] * lvlMultiplier, greaterWillSwordsmanStats[5] * lvlMultiplier,
                greaterWillSwordsmanStats[6] * lvlMultiplier, greaterWillSwordsmanStats[7] * lvlMultiplier, greaterWillSwordsmanStats[8] * lvlMultiplier,
                greaterWillSwordsmanStats[9] * lvlMultiplier, greaterWillSwordsmanStats[10] * lvlMultiplier, greaterWillSwordsmanStats[11] * lvlMultiplier,
                greaterWillSwordsmanStats[12] * lvlMultiplier, greaterWillSwordsmanStats[13] * lvlMultiplier, greaterWillSwordsmanStats[14] * lvlMultiplier, greaterWillSwordsmanStats[15] * lvlMultiplier);
    }

    public Stats newYeti(int lvl) {
        mobName = "Yeti"; 
        chosenMobAttacks = YETIS_ATTACKS; 
        chosenAttackCosts = YETIS_ATTACK_COSTS;

        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;
        
        return new Stats(
                yetiStats[0] * lvlMultiplier, yetiStats[1] * lvlMultiplier, yetiStats[2] * lvlMultiplier,
                yetiStats[3] * lvlMultiplier, yetiStats[4] * lvlMultiplier, yetiStats[5] * lvlMultiplier,
                yetiStats[6] * lvlMultiplier, yetiStats[7] * lvlMultiplier, yetiStats[8] * lvlMultiplier,
                yetiStats[9] * lvlMultiplier, yetiStats[10] * lvlMultiplier, yetiStats[11] * lvlMultiplier,
                yetiStats[12] * lvlMultiplier, yetiStats[13] * lvlMultiplier, yetiStats[14] * lvlMultiplier, yetiStats[15] * lvlMultiplier);
    }
    public Stats newQuantumSensoryDroid(int lvl) {
        mobName = "Quantum Sensory Droid"; 
        chosenMobAttacks = QUANTUM_SENSORY_DROID_ATTACKS; 
        chosenAttackCosts = QUANTUM_SENSORY_DROID_ATTACK_COSTS;

        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;
        
        return new Stats(
                quantumSensoryDroidStats[0] * lvlMultiplier, quantumSensoryDroidStats[1] * lvlMultiplier, quantumSensoryDroidStats[2] * lvlMultiplier,
                quantumSensoryDroidStats[3] * lvlMultiplier, quantumSensoryDroidStats[4] * lvlMultiplier, quantumSensoryDroidStats[5] * lvlMultiplier,
                quantumSensoryDroidStats[6] * lvlMultiplier, quantumSensoryDroidStats[7] * lvlMultiplier, quantumSensoryDroidStats[8] * lvlMultiplier,
                quantumSensoryDroidStats[9] * lvlMultiplier, quantumSensoryDroidStats[10] * lvlMultiplier, quantumSensoryDroidStats[11] * lvlMultiplier,
                quantumSensoryDroidStats[12] * lvlMultiplier, quantumSensoryDroidStats[13] * lvlMultiplier, quantumSensoryDroidStats[14] * lvlMultiplier, quantumSensoryDroidStats[15] * lvlMultiplier);
    }

    public Stats newWardenOfFrost(int lvl) {
        mobName = "Warden Of Frost"; 
        chosenMobAttacks = WARDEN_OF_FROST_ATTACKS; 
        chosenAttackCosts = WARDEN_OF_FROST_ATTACK_COSTS;

        double lvlMultiplier = Math.pow(1.1, lvl) - 0.1;
        
        return new Stats(
                wardenOfFrostStats[0] * lvlMultiplier, wardenOfFrostStats[1] * lvlMultiplier, wardenOfFrostStats[2] * lvlMultiplier,
                wardenOfFrostStats[3] * lvlMultiplier, wardenOfFrostStats[4] * lvlMultiplier, wardenOfFrostStats[5] * lvlMultiplier,
                wardenOfFrostStats[6] * lvlMultiplier, wardenOfFrostStats[7] * lvlMultiplier, wardenOfFrostStats[8] * lvlMultiplier,
                wardenOfFrostStats[9] * lvlMultiplier, wardenOfFrostStats[10] * lvlMultiplier, wardenOfFrostStats[11] * lvlMultiplier,
                wardenOfFrostStats[12] * lvlMultiplier, wardenOfFrostStats[13] * lvlMultiplier, wardenOfFrostStats[14] * lvlMultiplier, wardenOfFrostStats[15] * lvlMultiplier);
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