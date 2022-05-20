package PlayerInformation;

import java.util.Arrays;

public class Armours {
   
    // private double armourPieceHP;
    // private double armourPieceMP;
    // private double armourPieceSpd;
    // private double armourPieceAtk;
    // private double armourPiecePhysDmg;
    // private double armourPieceMagicDmg;
    // private double armourPieceDef;
    // private double armourPieceEnd;
    // private double armourPieceStam;
    // private double armourPiecePhysRes;
    // private double armourPieceMagicRes;
    // private double armourPieceDodge;
    // private double armourPieceVit;
    // private double armourPieceCritRate; 
    // private double armourPieceCritDmg;
    // private double armourPieceLuck;
    // private double[] armourStats = {armourPieceHP, armourPieceMP, armourPieceSpd, armourPieceAtk, armourPiecePhysDmg, armourPieceMagicDmg, 
    // armourPieceDef, armourPieceEnd, armourPieceStam, armourPiecePhysRes, armourPieceMagicRes, armourPieceDodge, armourPieceVit, 
    // armourPieceCritRate, armourPieceCritDmg, armourPieceLuck}; 

    private Stats playerStats;
    private Player mainPlayer;  
    private String chosenClass; 

    private double[] statsBeforeArmour;
    private double[] statsAfterArmour; 
    private double[] equipmentStats; 
    
    //*ARMOUR TYPES
    private String[] heavyArmour = {"Helm", "Chestplate", "Greaves", "Heelguards"}; 
    private String[] lightArmour = {"Visor", "Quasiplate", "Chaps", "Shoes"};
    private String[] mageArmour = {"Hood", "Robe", "Leggings", "Boots" };


    //*ALL ARMOUR STATS 
    // maxHP, maxMP, maxSpd, maxAtk, maxPhysDmg, maxMagicDmg, maxDef, maxEnd,maxStam,
    // maxPhysRes, maxMagicRes, maxDodge, maxVit, maxCritRate,maxCritDmg,maxLuck;

    //battered spectral armour
    private String batteredSpectral = "Battered Spectral";
    private String getBatteredSpectral(){return batteredSpectral;}
    private double[] batteredSpectralHeavyStats = { 15, 10, 0.05, 1.5, 3, 3, 4, 2, 2, 1, 1, 2, 1, 2, 3, 1 };
    private double[] batteredSpectralLightStats = { 10, 10, 0.07, 2, 2, 2, 1.5, 2, 2, 1, 1, 2, 2, 2, 3.5, 2 };
    private double[] batteredSpectralMageStats = { 12, 12, 0.04, 2.5, 1, 3, 1, 2, 2, 1, 2.5, 1, 2, 3, 2.5, 1.5 };

    //superior spectral armour 
    private String superiorSpectral = "Superior Spectral"; 
    private double[] superiorSpectralHeavyStats = { 20, 15, 0.06, 2.4, 4.5, 3, 4.5, 2, 3, 3, 1.5, 2, 1.5, 3, 4, 1.5 };
    private double[] superiorSpectralLightStats = { 13, 15, 0.08, 2.1, 2.5, 2.5, 2, 2.5, 3, 2, 1.5, 3, 2.5, 3, 4.5, 2.5 };
    private double[] superiorSpectralMageStats = { 18, 20, 0.04, 2, 1, 4.5, 1.5, 2, 2, 2, 3, 1.5, 4, 3.5, 4, 2 };

    //TODO: implement a "check what you're wearing thing to implement additional armour stats"

    public Armours(Player mainPlayer, String chosenClass) {
        this.mainPlayer = mainPlayer; 
        this.chosenClass = chosenClass; 
        this.playerStats = mainPlayer.getPlayerStats();

        statsBeforeArmour = playerStats.getCurrentStats(); 
    }

    public void equipArmour(String armour) { 
        
        switch (armour.toLowerCase()) {
            case "battered spectral": 
                equipBatteredSpectral(); 
                break;
            case "superior spectral": 
                equipSuperiorSpectral(); 
                break;
        }
    }

    public double[] getEquipment() {
        return equipmentStats;
    }
    
    /** 
     * method only works if there is already equipment on
     * removes the equipmentand the added stats
     * @param armourStatsToRemove - the addition stats of the armour
     */
    public void removeEquipment(double[] armourStatsToRemove) {

        // removes equipment from display
        mainPlayer.addEquippedArmourToInventory(null, null, null, null);

        for (int i = 0; i < statsBeforeArmour.length; i++) {
            statsBeforeArmour[i] = statsAfterArmour[i] - armourStatsToRemove[i];
        }

        playerStats.setCurrentHP(statsBeforeArmour[0]);
        playerStats.setCurrentMP(statsBeforeArmour[1]);
        playerStats.setCurrentSpd(statsBeforeArmour[2]);
        playerStats.setCurrentAtk(statsBeforeArmour[3]);
        playerStats.setCurrentPhysDmg(statsBeforeArmour[4]);
        playerStats.setCurrentMagicDmg(statsBeforeArmour[5]);
        playerStats.setCurrentDef(statsBeforeArmour[6]);
        playerStats.setCurrentEnd(statsBeforeArmour[7]);
        playerStats.setCurrentStam(statsBeforeArmour[8]);
        playerStats.setCurrentPhysRes(statsBeforeArmour[9]);
        playerStats.setCurrentMagicRes(statsBeforeArmour[10]);
        playerStats.setCurrentDodge(statsBeforeArmour[11]);
        playerStats.setCurrentVit(statsBeforeArmour[12]);
        playerStats.setCurrentCritRate(statsBeforeArmour[13]);
        playerStats.setCurrentCritDmg(statsBeforeArmour[14]);
        playerStats.setCurrentLuck(statsBeforeArmour[15]);

    }



    private void equipBatteredSpectral() {
        
        String bs = batteredSpectral; 
        switch(chosenClass.toLowerCase()) {
            case "cyborg": 
                mainPlayer.addEquippedArmourToInventory(bs + " " + heavyArmour[0], bs + " " + heavyArmour[1], bs + " " + heavyArmour[2], bs + " " + heavyArmour[3]);
                addEquippedStats(batteredSpectralHeavyStats); 
                break; 
            case "hacker": 
                mainPlayer.addEquippedArmourToInventory(bs + " " + heavyArmour[0], bs + " " + heavyArmour[1], bs + " " + heavyArmour[2], bs + " " + heavyArmour[3]);
                addEquippedStats(batteredSpectralHeavyStats); 
                break;
            case "terminator": 
                mainPlayer.addEquippedArmourToInventory(bs + " " + heavyArmour[0], bs + " " + heavyArmour[1], bs + " " + heavyArmour[2], bs + " " + heavyArmour[3]);
                addEquippedStats(batteredSpectralHeavyStats); 
                break;
            case "lazer swordsman": 
                mainPlayer.addEquippedArmourToInventory(bs + " " + lightArmour[0], bs + " " + lightArmour[1], bs + " " + lightArmour[2], bs + " " + lightArmour[3]);
                addEquippedStats(batteredSpectralLightStats);
                break; 
            case "rogue": 
                mainPlayer.addEquippedArmourToInventory(bs + " " + lightArmour[0], bs + " " + lightArmour[1], bs + " " + lightArmour[2], bs + " " + lightArmour[3]);
                addEquippedStats(batteredSpectralLightStats);
                break;
            case "mystic": 
                mainPlayer.addEquippedArmourToInventory(bs + " " + mageArmour[0], bs + " " + mageArmour[1], bs + " " + mageArmour[2], bs + " " + mageArmour[3]);
                addEquippedStats(batteredSpectralMageStats);
                break; 
            case "reverend": 
                mainPlayer.addEquippedArmourToInventory(bs + " " + mageArmour[0], bs + " " + mageArmour[1], bs + " " + mageArmour[2], bs + " " + mageArmour[3]);
                addEquippedStats(batteredSpectralMageStats);
                break; 
        }
    }

    private void equipSuperiorSpectral() {

        String ss = superiorSpectral;
        switch (chosenClass.toLowerCase()) {
            case "cyborg":
                mainPlayer.addEquippedArmourToInventory(ss + " " + heavyArmour[0], ss + " " + heavyArmour[1],
                        ss + " " + heavyArmour[2], ss + " " + heavyArmour[3]);
                addEquippedStats(superiorSpectralHeavyStats);
                break;
            case "hacker":
                mainPlayer.addEquippedArmourToInventory(ss + " " + heavyArmour[0], ss + " " + heavyArmour[1],
                        ss + " " + heavyArmour[2], ss + " " + heavyArmour[3]);
                addEquippedStats(superiorSpectralHeavyStats);
                break;
            case "terminator":
                mainPlayer.addEquippedArmourToInventory(ss + " " + heavyArmour[0], ss + " " + heavyArmour[1],
                        ss + " " + heavyArmour[2], ss + " " + heavyArmour[3]);
                addEquippedStats(superiorSpectralHeavyStats);
                break;
            case "lazer swordsman":
                mainPlayer.addEquippedArmourToInventory(ss + " " + lightArmour[0], ss + " " + lightArmour[1],
                        ss + " " + lightArmour[2], ss + " " + lightArmour[3]);
                addEquippedStats(superiorSpectralLightStats);
                break;
            case "rogue":
                mainPlayer.addEquippedArmourToInventory(ss + " " + lightArmour[0], ss + " " + lightArmour[1],
                        ss + " " + lightArmour[2], ss + " " + lightArmour[3]);
                addEquippedStats(superiorSpectralLightStats);
                break;
            case "mystic":
                mainPlayer.addEquippedArmourToInventory(ss + " " + mageArmour[0], ss + " " + mageArmour[1],
                        ss + " " + mageArmour[2], ss + " " + mageArmour[3]);
                addEquippedStats(superiorSpectralMageStats);
                break;
            case "reverend":
                mainPlayer.addEquippedArmourToInventory(ss + " " + mageArmour[0], ss + " " + mageArmour[1],
                        ss + " " + mageArmour[2], ss + " " + mageArmour[3]);
                addEquippedStats(superiorSpectralMageStats);
                break;
        } 
    }


    //adds the stats of the equipped armour to player stats 
    private void addEquippedStats(double[] equipmentStats){
        this.equipmentStats = equipmentStats; 
        
        statsAfterArmour = Arrays.copyOf(statsBeforeArmour, statsBeforeArmour.length); 

        for (int i = 0; i < statsAfterArmour.length; i++) { 
            statsAfterArmour[i] += equipmentStats[i]; 
        }
          //maxHP, maxMP, maxSpd, maxAtk, maxPhysDmg, maxMagicDmg, maxDef, maxEnd, maxStam, 
        //maxPhysRes, maxMagicRes, maxDodge, maxVit, maxCritRate,maxCritDmg,maxLuck;
        playerStats.setCurrentHP(statsAfterArmour[0]);
        playerStats.setCurrentMP(statsAfterArmour[1]);
        playerStats.setCurrentSpd(statsAfterArmour[2]);
        playerStats.setCurrentAtk(statsAfterArmour[3]); 
        playerStats.setCurrentPhysDmg(statsAfterArmour[4]);
        playerStats.setCurrentMagicDmg(statsAfterArmour[5]);
        playerStats.setCurrentDef(statsAfterArmour[6]); 
        playerStats.setCurrentEnd(statsAfterArmour[7]); 
        playerStats.setCurrentStam(statsAfterArmour[8]); 
        playerStats.setCurrentPhysRes(statsAfterArmour[9]); 
        playerStats.setCurrentMagicRes(statsAfterArmour[10]);
        playerStats.setCurrentDodge(statsAfterArmour[11]);
        playerStats.setCurrentVit(statsAfterArmour[12]); 
        playerStats.setCurrentCritRate(statsAfterArmour[13]);
        playerStats.setCurrentCritDmg(statsAfterArmour[14]);
        playerStats.setCurrentLuck(statsAfterArmour[15]);
    }

}
  

    
