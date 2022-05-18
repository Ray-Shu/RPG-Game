package PlayerInformation;

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
        String bs = batteredSpectral; 
        switch(chosenClass.toLowerCase()) {
            case "cyborg": 
                mainPlayer.addEquippedArmourToInventory(bs + " " + heavyArmour[0], bs + " " + heavyArmour[1], bs + " " + heavyArmour[2], bs + " " + heavyArmour[3]);
                
                break; 
            case "hacker": 

                break;
            case "terminator": 

                break;
            case "lazer swordsman": 

                break; 
            case "rogue": 

                break;
            case "mystic": 

                break; 
            case "reverend": 

                break; 
        }
    }
}
