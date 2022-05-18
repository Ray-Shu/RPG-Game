package PlayerAssistants;

import PlayerInformation.*;

public class Checkpoints {

        Stats playerStats;
        double[] saveStats;
        boolean hasCheckPointBeenUsed = false; 
        
        public Checkpoints(Stats playerStats){
                saveStats = playerStats.getCurrentStats();
                this.playerStats = playerStats;
        }

        public void backToCheckpoint(){
                playerStats.setCurrentHP(saveStats[0]);
                playerStats.currentMP = saveStats[1];
                playerStats.currentAtk= saveStats[2];
                playerStats.currentPhysDmg = saveStats[3];
                playerStats.currentMagicDmg = saveStats[5];
                playerStats.currentDef = saveStats[6];
                playerStats.currentEnd= saveStats[7];
                playerStats.currentStam = saveStats[8];
                playerStats.currentPhysRes = saveStats[9];
                playerStats.currentMagicDmg = saveStats[10];
                playerStats.currentDodge= saveStats[11];
                playerStats.currentVit = saveStats[12];
                playerStats.currentCritRate = saveStats[13];
                playerStats.currentCritDmg = saveStats[14];
                playerStats.currentLuck = saveStats[15];
                hasCheckPointBeenUsed = true;
        }

        boolean hasCheckPointBeenUsed(){
                return hasCheckPointBeenUsed;
        }
}