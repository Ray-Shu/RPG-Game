package PlayerInformation;

import java.util.Arrays;

public class Armours {
    private String armour;  //what the armour is 
    private String armourType;  //light | heavy | mage 
    private String headPiece; 
    private String chestPiece; 
    private String legPiece; 
    private String boots; 

    
    //maxHP, maxMP, maxSpd, maxAtk, maxPhysDmg, maxMagicDmg, maxDef, maxEnd, maxStam, 
    //maxPhysRes, maxMagicRes, maxDodge, maxVit, maxCritRate,maxCritDmg,maxLuck;

    private double armourPieceHP;
    private double armourPieceMP;
    private double armourPieceSpd;
    private double armourPieceAtk;
    private double armourPiecePhysDmg;
    private double armourPieceMagicDmg;
    private double armourPieceDef;
    private double armourPieceEnd;
    private double armourPieceStam;
    private double armourPiecePhysRes;
    private double armourPieceMagicRes;
    private double armourPieceDodge;
    private double armourPieceVit;
    private double armourPieceCritRate; 
    private double armourPieceCritDmg;
    private double armourPieceLuck;
    private double[] armourStats = {armourPieceHP, armourPieceMP, armourPieceSpd, armourPieceAtk, armourPiecePhysDmg, armourPieceMagicDmg, 
    armourPieceDef, armourPieceEnd, armourPieceStam, armourPiecePhysRes, armourPieceMagicRes, armourPieceDodge, armourPieceVit, 
    armourPieceCritRate, armourPieceCritDmg, armourPieceLuck}; 

    private Stats playerStats;
    private Player mainPlayer;  
    private String chosenClass; 

    private double[] statsBeforeArmour;
    private double[] statsAfterArmour; 
    
    private String batteredSpectral = "Battered Spectral";
    private String[] heavyArmour = {"Helm", "Chestplate", "Greaves", "Heelguards"}; 
    private String[] lightArmour = {"Visor", "Quasiplate", "Chaps", "Shoes"};
    private String[] mageArmour = {"Hood", "Robe", "Leggings", "Boots" };

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
        }
    }

    private void equipBatteredSpectral() {
        double[] batteredSpectralHeavyStats = {15, 10, 0.05, 3, 3, 3, 4, 2, 2, 1, 1, 2, 1, 2, 3, 1}; 
        double[] batteredSpectralLightStats = {10, 10, 0.07, 2, 2, 2, 1.5, 2, 2, 1, 1, 2, 2, 2, 3.5, 2}; 
        double[] batteredSpectralMageStats = {12, 12, 0.04, 3.5, 1, 3, 1, 2, 2, 1, 2.5, 1, 2, 3, 2.5, 1.5}; 
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


    //adds the stats of the equipped armour to player stats 
    private void addEquippedStats(double[] equipmentStats){
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
