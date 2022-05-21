package PlayerInformation;
import java.text.DecimalFormat;
import java.util.Arrays;

import Tools.*;
import TownInfo.Town;


 
public class Stats {

        private DecimalFormat df = new DecimalFormat("###.00");

        private double maxHP, maxMP, maxSpd, maxAtk, maxPhysDmg, maxMagicDmg, maxDef, maxEnd, maxStam, maxPhysRes, maxMagicRes, maxDodge, maxVit,
                        maxCritRate, maxCritDmg, maxLuck;
                        
        private double currentHP, currentMP, currentSpd, currentAtk, currentPhysDmg, currentMagicDmg, currentDef, currentEnd, currentStam,
                currentPhysRes, currentMagicRes, currentDodge, currentVit, currentCritRate, currentCritDmg, currentLuck;

        private double speedMultiplier = 1, atkMultiplier = 1, hpMultiplier = 1, dodgeMultiplier = 1, defMultiplier = 1, allStats[], currentStats[];
        
        private String displayStats[];
        private int XP_TO_LVL_UP = 100;
        private int level, howLongDisabled, howLongSpeedUp, howLongAtkUp, howLongDefUp, howLongDodgeUp, xp = 0;

        
        //return how long disabled
        public int getHowLongDisabled(){return howLongDisabled;}

        //sets how long we are disabled for
        public void setHowLongDisabled(int toWhat){howLongDisabled = toWhat;}

        //returns the length of time speed is up
        public int getHowLongSpeedUp(){return howLongSpeedUp;}

        //sets how long speed is up for
        public void setHowLongSpeedUp(int toWhat){howLongSpeedUp = toWhat;}

        //returns the length of time the atk is up for
        public int getHowLongAtkUp(){return howLongAtkUp;}

        //sets the amount of time attack is up
        public void setHowLongAtkUp(int toWhat){howLongAtkUp = toWhat;}

        //returns the length of time def is up for 
        public int getHowLongDefUp(){return howLongDefUp;}

        //sets the amount of time dodge is up
        public void setHowLongDefUp(int toWhat){howLongDefUp = toWhat;}

        //returns the length of time dodge is up for
        public int getHowLongDodgeUp(){return howLongDodgeUp;}

        //sets the amount of time dodge is up
        public void setHowLongDodgeUp(int toWhat){howLongDodgeUp = toWhat;}

	//returns the xp needed to level up. 
        public int getXP_TO_LVL_UP(){return XP_TO_LVL_UP;}

        //returns the player's xp
        public int getXP(){return xp;}


        //*STAT MULTIPLIERS

        //returns the players hp multiplier 
        public double getHPMultiplier() {return hpMultiplier;}

        // returns the player's speed multiplier
        public double getSpeedMultiplier() {return speedMultiplier;}

        //returns the players atk multiplier
        public double getAtkMultiplier() {return atkMultiplier;}

        // returns the players defence multiplier
        public double getDefMultiplier() {return defMultiplier;}

        // returns the players dodge multiplier
        public double getDodgeMultiplier() {return dodgeMultiplier;}
        

        //*STAT GETTERS
        //returns the player's current HP
        public double getCurrentHP(){return currentHP;}

        // returns current mp
        public double getCurrentMP() {return currentMP;}

        // returns the current speed of the player
        public double getCurrentSpeed() {return currentSpd;}

        //returns the player's current atk
        public double getCurrentAttack(){return currentAtk * atkMultiplier;}

        //returns the players current physical damage
        public double getCurrentPhysDmg(){return currentPhysDmg;}

        // returns the players current magic damage
        public double getCurrentMagicDmg() {return currentMagicDmg;}

        // returns the players current defense 
        public double getCurrentDef() {return currentDef;}

        // returns the players current endurance 
        public double getCurrentEnd() {return currentEnd;}

        // returns the players current stamina 
        public double getCurrentStam() {return currentStam;}

        // returns the players current physical resistance 
        public double getCurrentPhysRes() {return currentPhysRes;}

        // returns the players current magic resistance 
        public double getCurrentMagicRes() {return currentMagicRes;}

        // returns the players current dodge 
        public double getCurrentDodge() {return currentDodge;}

        // returns the players current vitality 
        public double getCurrentVit() {return currentVit;}

        // returns the players current crit rate
        public double getCurrentCritRate() {return currentCritRate;}

        // returns the players current crit damage 
        public double getCurrentCritDmg() {return currentCritDmg;}

        // returns the players current luck
        public double getCurrentLuck() {return currentLuck;}


        //*STAT SETTERS 
        // sets current hp
        public void setCurrentHP(double toWhat){currentHP = toWhat; updateStats();}

        // sets current MP
        public void setCurrentMP(double toWhat){currentMP = toWhat; updateStats();}

        // sets current Spd 
        public void setCurrentSpd(double toWhat){currentSpd = toWhat; updateStats();}

        // sets current Atk
        public void setCurrentAtk(double toWhat){currentAtk = toWhat; updateStats();}

        // sets current physical damage
        public void setCurrentPhysDmg(double toWhat){currentPhysDmg = toWhat; updateStats();}

        // sets current magical damage 
        public void setCurrentMagicDmg(double toWhat){currentMagicDmg = toWhat; updateStats();}

        // sets current defense 
        public void setCurrentDef(double toWhat){currentDef = toWhat; updateStats();}

        // sets current endurance 
        public void setCurrentEnd(double toWhat){currentEnd = toWhat; updateStats();}

        // sets currentStam 
        public void setCurrentStam(double toWhat){currentStam = toWhat; updateStats();}

        // sets current physical resistance 
        public void setCurrentPhysRes(double toWhat){currentPhysRes = toWhat; updateStats();}

        // sets current magical resistance 
        public void setCurrentMagicRes(double toWhat){currentMagicRes = toWhat; updateStats();}

        //sets current dodge 
        public void setCurrentDodge(double toWhat){currentDodge = toWhat; updateStats();}

        // sets current vitality
        public void setCurrentVit(double toWhat){currentVit = toWhat; updateStats();}

        //sets current crit rate 
        public void setCurrentCritRate(double toWhat){currentCritRate = toWhat; updateStats();}

        //sets current crit damage
        public void setCurrentCritDmg(double toWhat){currentCritDmg = toWhat; updateStats();}

        //sets current luck 
        public void setCurrentLuck(double toWhat){currentLuck = toWhat; updateStats();}

        //returns max HP
        public double getMaxHP(){return maxHP;}

        //currentHP, currentMP, currentSpd, currentAtk, currentPhysDmg, currentMagicDmg, currentDef, currentEnd, currentStam,
                //currentPhysRes, currentMagicRes, currentDodge, currentVit, currentCritRate, currentCritDmg, currentLuck;

        /**
         * This class will contain information about the stats of the player and the
         * mobs.
         * 
         * @param hp       - health pool | how much health one has
         * @param mp       - mana point | how much mana one has
         * @param spd      - speed | turn-based attack is based on who has higher speed
         * @param atk      - attack | dependent on def, physRes, magicRes, critRate,
         *                 critDmg
         * @param pd       - physical damage | only accounts for damage done through
         *                 physical contact
         * @param md       - magic damage | only accounts for damage done through magic
         * @param def      - defense | dependent on physRes, magicRes
         * @param end      - endurance | as the battle continues, speed will decrease.
         *                 having higher endurance means speed will lower at a slower
         *                 rate
         * @param sta      - stamina | stamina dictates the 'quality' of attack a
         *                 character can do: a LIGHT attack will do less damage but
         *                 consume less stamina;
         *                 a MEDIUM attack will do medium damage and consume a medium
         *                 amount of stamina;
         *                 a HEAVY attack will do high damage but will consume a lot of
         *                 stamina
         *                 Stamina will regenerate as turns continue
         * @param physRes  - physical resistance | used in calculation with def;
         *                 dictates the amount of 'physical' damage a character will
         *                 recieve
         * @param magicRes - magic resistance | used in calculation with def; dictates
         *                 the amount of 'magical' damage a character will recieve
         * @param dodge    - dodge chance | the chance a character has at dodging an
         *                 enemy attack; dodging an attack means that the attack will
         *                 'miss' and not do any damage
         * @param vit      - vitality | dictates how much the character will regenerate
         *                 their hp at the end of a room
         * @param cr       - crit rate | the chance of being able to deal a 'critical
         *                 hit'
         * @param cd       - crit damage | the amount of damage increased onto base
         *                 damage when a 'critical hit' is induced
         * @param luck     - luck | dictates how much gold a character will get after
         *                 slaying a foe. 
         // ?                  Maybe impacts miss. 
         */

        public Stats(double hp, double mp, double spd, double atk, double pd, double md, double def, double end, double stam,
                        double physRes, double magicRes, double dodge, double vit, double cr, double cd, double luck) {
                maxHP = hp;
                maxMP = mp;
                maxSpd = spd;
                maxAtk = atk;
                maxPhysDmg = pd;
                maxMagicDmg = md;
                maxDef = def;
                maxEnd = end;
                maxStam = stam;
                maxPhysRes = physRes;
                maxMagicRes = magicRes;
                maxDodge = dodge;
                maxVit = vit;
                maxCritRate = cr;
                maxCritDmg = cd;
                maxLuck = luck;

                double[] allStats = { maxHP, maxMP, maxSpd, maxAtk, maxPhysDmg, maxMagicDmg, maxDef, maxEnd, maxStam, maxPhysRes, maxMagicRes, maxDodge,
                                maxVit, maxCritRate, maxCritDmg, maxLuck };

                //converts the 'max' variables to 'current' 
                currentToMax();
                
                double currentStats[] = {currentHP, currentMP, currentSpd, currentAtk, currentPhysDmg, currentMagicDmg, currentDef, currentEnd, currentStam, 
                        currentPhysRes, currentMagicRes, currentDodge, currentVit, currentCritRate, currentCritDmg, currentLuck};
                
                this.allStats = allStats;
                this.currentStats = currentStats; 

                
                String[] displayStats = { "HP", "MP", "Speed", "Attack", "Physical Damage", "Magic Damage", "Defense",
                                "Endurance", "Stamina", "Phyical Resistance", "Magic Resistance", "Dodge", "Vitality",
                                "Crit Rate",
                                "Crit Damage", "Luck" };

                this.displayStats = displayStats;
        }

        private void updateStats() {
                double currentStats[] = {currentHP, currentMP, currentSpd, currentAtk, currentPhysDmg, currentMagicDmg, currentDef, currentEnd, currentStam, 
                        currentPhysRes, currentMagicRes, currentDodge, currentVit, currentCritRate, currentCritDmg, currentLuck};
                this.currentStats = Arrays.copyOf(currentStats, currentStats.length); 
        }

        public double[] getCurrentStats(){
                double currentStats[] = {currentHP, currentMP, currentSpd, currentAtk, currentPhysDmg, currentMagicDmg, currentDef, currentEnd, currentStam, 
                      currentPhysRes, currentMagicRes, currentDodge, currentVit, currentCritRate, currentCritDmg, currentLuck};
                return currentStats;
        }

        public void currentToMax(){
                currentHP = maxHP; 
                currentMP = maxMP; 
                currentSpd = maxSpd; 
                currentAtk = maxAtk; 
                currentPhysDmg = maxPhysDmg; 
                currentMagicDmg = maxMagicDmg; 
                currentDef = maxDef; 
                currentEnd = maxEnd; 
                currentStam = maxStam; 
                currentPhysRes = maxPhysRes; 
                currentMagicRes = maxMagicRes; 
                currentDodge = maxDodge; 
                currentVit = maxVit; 
                currentCritRate = maxCritRate; 
                currentCritDmg = maxCritDmg; 
                currentLuck = maxLuck;
        }

        //Prints out the stats of the player
        public void getClassInfo(String chosenClass) {

                Printer.printColor(
                                chosenClass.substring(0, 1).toUpperCase() + chosenClass.substring(1).toLowerCase()
                                                + ":",
                                "white");
                System.out.println();

                for (int i = 0; i < displayStats.length; i++) {
                        double replaceToStats = currentStats[i]; 
                        Printer.print(displayStats[i] + ": " + df.format(replaceToStats)); 
                }
        } 

        //Adds xp to the user
        public void addXP(int xpGained) {
                xp += xpGained;
        }

        //increases the stats of the user by a certain percentage for a level up. 
        public void statsUp(double statPercentageIncreasePerLevel) {
                XP_TO_LVL_UP *= 1.2;
                //increases the cur
                maxHP *= statPercentageIncreasePerLevel; 
                maxMP *= statPercentageIncreasePerLevel; 
                maxSpd *= statPercentageIncreasePerLevel; 
                maxAtk *= statPercentageIncreasePerLevel; 
                maxPhysDmg *= statPercentageIncreasePerLevel; 
                maxMagicDmg *= statPercentageIncreasePerLevel; 
                maxDef *= statPercentageIncreasePerLevel; 
                maxEnd *= statPercentageIncreasePerLevel; 
                maxStam *= statPercentageIncreasePerLevel; 
                maxPhysRes *= statPercentageIncreasePerLevel; 
                maxMagicRes *= statPercentageIncreasePerLevel; 
                maxDodge *= statPercentageIncreasePerLevel; 
                maxVit *= statPercentageIncreasePerLevel; 
                maxCritRate *= statPercentageIncreasePerLevel; 
                maxCritDmg *= statPercentageIncreasePerLevel; 
                maxLuck *= statPercentageIncreasePerLevel;

                currentToMax();
        }

        //heals the person/mob
        //combatHeal is used when players or opponents use moves that specifically heal
        //DIFFERENT THAN FULL HEALING FROM DEATH --> we can implement a new method for that
      
        public void combatHeal(double howMuchHeal, Stats attackerStats) {
                Printer.printColor("Healed: " + df.format(howMuchHeal) + " HP.","yellow");
                if(attackerStats.currentHP + howMuchHeal > attackerStats.maxHP){
                        attackerStats.currentHP = attackerStats.maxHP;
                        return;
                }

                attackerStats.currentHP += howMuchHeal;
                
        }

        //heals player back to full health
        public void hospitalHeal(){
                currentHP = maxHP;
        }

        //Recovers mp
        public void rest() {
                currentMP = maxMP;
        }

        //* SPEED MULTIPLIER STUFF
        //returns a boolean reguarding wether not the user can increase their speed. 
        public boolean canSpeedUp() {
                if(speedMultiplier == 2){return false;}
                else{return true;}
        }

        //increases the player's speed multiplier
        public void applySpeedUp(double multiplier){
                speedMultiplier *= multiplier;
                //maxes speed out at two
                if(speedMultiplier >= 2){
                        speedMultiplier = 2;
                }
                //if they enter 1 for the speed up, speed up multiplier goes to 1. 
                if(multiplier == 1){
                        speedMultiplier = 1;
                }
        }

        //increases the players speed up time for a while. 
        public void speedUpTime(double multiplier, int howLongSpeedUp){
                this.howLongSpeedUp += howLongSpeedUp;
                applySpeedUp(multiplier);
        }

        //* ATTACK MULTIPLIER BOOST STUFF
        //returns a boolean reguarding wether not the user can increase their atk. 
        public boolean canAtkUp() {
                if(atkMultiplier == 2){return false;}
                else{return true;}
        }

        //increases the player's attack multiplier
        public void applyAttackUp(double multiplier){
                atkMultiplier *= multiplier;
                //maxes speed out at two
                if(atkMultiplier >= 2){
                        atkMultiplier = 2;
                }
                //if they enter 1 for the speed up, speed up multiplier goes to 1. 
                if(multiplier == 1){
                        atkMultiplier = 1;
                }
        }

        public void atkUpTime(double multiplier, int howLongAtkUp){
                this.howLongAtkUp += howLongAtkUp;
                applyAttackUp(multiplier);
        }

        //* DEFENCE MULTIPLIER STUFF
        //returns a boolean reguarding wether not the user can increase their atk. 
        public boolean canDefUp() {
                if(defMultiplier == 3){return false;}
                else{return true;}
        }

        //applies the player's def multiplier
        public void applyDefenceUp(double multiplier){
                defMultiplier *= multiplier;
                //maxes def out at two
                if(defMultiplier >= 3){
                        defMultiplier = 3;
                }
                //if they enter 1 for the def up, def up multiplier goes to 1. 
                if(multiplier == 1){
                        defMultiplier = 1;
                }
        }

        public void defUpTime(double multiplier, int howLongDefUp){
                this.howLongDefUp += howLongDefUp;
                applyDefenceUp(multiplier);
        }

        //* DODGE MULTIPLIER STUFF
        //returns a boolean reguarding wether not the user can increase their atk. 
        public boolean canDodgeUp() {
                if(dodgeMultiplier == 20){return false;}
                else{return true;}
        }

        //increases the player's speed multiplier
        public void applyDodgeUp(double multiplier){
                dodgeMultiplier *= multiplier;
                //maxes speed out at two
                if(dodgeMultiplier >= 20){
                        dodgeMultiplier = 20;
                }
                //if they enter 1 for the speed up, speed up multiplier goes to 1. 
                if(multiplier == 1){
                        dodgeMultiplier = 1;
                }
        }

        public void dodgeUpTime(double multiplier, int howLongDodgeUp){
                this.howLongDodgeUp += howLongDodgeUp;
                applyDodgeUp(multiplier);
        }

        
}
