package PlayerAssistants;

import PlayerInformation.*;

public class Checkpoints {

        Stats playerStats;
        double[] saveStats;
        boolean hasCheckPointBeenUsed = false; 

        public Checkpoints() {

        }

        public void createCheckpoint(Stats playerStats){
                saveStats = playerStats.getCurrentStats();
                this.playerStats = playerStats;
        }

        public void backToCheckpoint(){
                playerStats.setCurrentHP(saveStats[0]);
                playerStats.setCurrentMP(saveStats[1]);
                playerStats.setCurrentSpd(saveStats[2]);
                playerStats.setCurrentAtk(saveStats[3]);
                playerStats.setCurrentPhysDmg(saveStats[4]);
                playerStats.setCurrentMagicDmg(saveStats[5]);
                playerStats.setCurrentDef(saveStats[6]);
                playerStats.setCurrentEnd(saveStats[7]);
                playerStats.setCurrentStam(saveStats[8]);
                playerStats.setCurrentPhysRes(saveStats[9]);
                playerStats.setCurrentMagicRes(saveStats[10]);
                playerStats.setCurrentDodge(saveStats[11]);
                playerStats.setCurrentVit(saveStats[12]);
                playerStats.setCurrentCritRate(saveStats[13]);
                playerStats.setCurrentCritDmg(saveStats[14]);
                playerStats.setCurrentLuck(saveStats[15]);
                hasCheckPointBeenUsed = true;
        }

        boolean hasCheckPointBeenUsed(){
                return hasCheckPointBeenUsed;
        }
}