package PlayerInformation;

public class Armours {
    String armourType;  //light | heavy | mage 
    String armour;  //what the armour is 
    String headPiece; 
    String chestPiece; 
    String legPiece; 
    String boots; 

    Stats playerStats; 

    double armourSetHP; 
    double armourSetMP; 
    double armourSetSpd; 
    double armourSetAtk; 
    double armourSetPhysDmg; 
    double armourSetMagicDmg; 
    double armourSetDef; 
    double armourSetEnd; 
    double armourSetStam; 
    double armourSetPhysRes; 
    double armourSetMagicRes; 
    double armourSetDodge; 
    double armourSetVit; 
    double armourSetCritRate; 
    double armourSetCritDmg; 
    double armourSetLuck;

    double armourPieceHP;
    double armourPieceMP;
    double armourPieceSpd;
    double armourPieceAtk;
    double armourPiecePhysDmg;
    double armourPieceMagicDmg;
    double armourPieceDef;
    double armourPieceEnd;
    double armourPieceStam;
    double armourPiecePhysRes;
    double armourPieceMagicRes;
    double armourPieceDodge;
    double armourPieceVit;
    double armourPieceCritRate; 
    double armourPieceCritDmg;
    double armourPieceLuck;



    //TODO: implement a "check what youre wearing thing to implement additional armour stats"

    public Armours(Stats playerStats) {
        this.playerStats = playerStats; 
    }

    public void equipArmour(String armourType, String headPiece, String chestPiece, String legPiece, String boots){ 
        this.headPiece = headPiece; 
        this.chestPiece = chestPiece; 
        this.legPiece = legPiece; 
        this.boots = boots; 
    }


    //*Check what armour the user is wearing
    public void checkArmour() {
        switch(armour.toLowerCase()) {
            case "battered spectral armour": 
                batteredSpectralArmourType(); 
                break; 
            case "superior spectral armour":

                break;  
            //TODO: add more armours
        }
    }

    private void batteredSpectralArmourType() {
        switch(armourType.toLowerCase()){
            case "light": 
                
                break; 

            case "heavy": 

                break; 

            case "mage": 

                break; 
        }
    }


    
    //*STATS ON THE ARMOUR SETS 
    private void batteredSpectralLightArmourSet() {
        armourSetHP = 20; 
        armourSetMP = 20; 
        armourSetSpd = 0.1; 
        armourSetAtk = 2; 
        armourSetPhysDmg = 1; 
        armourSetMagicDmg = 1; 
        armourSetDef = 4; 
        armourSetEnd = 0; 
        armourSetStam = 10; 
        armourSetPhysRes = 1; 
        armourSetMagicRes = 3; 
        armourSetDodge = 1; 
        armourSetVit = 1; 
        armourSetCritRate = 1; 
        armourSetCritDmg = 3; 
        armourSetLuck = 2;
    }





    //*armourSet STATS WHEN EQUIPPED 

    





    
}
