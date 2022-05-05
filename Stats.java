import java.util.Arrays;

public class Stats {
        public double maxHP, maxMP, maxSpd, maxAtk, maxPhysDmg, maxMagicDmg, maxDef, maxEnd, maxStam, maxPhysRes, maxMagicRes, maxDodge, maxVit,
                        maxCritRate, maxCritDmg, maxLuck;
        public double currentHP, currentMP, currentSpd, currentAtk, currentPhysDmg, currentMagicDmg, currentDef, currentEnd, currentStam,
                currentPhysRes, currentMagicRes, currentDodge, currentVit, currentCritRate, currentCritDmg, currentLuck;

        public double speedMultiplier = 1, atkMultiplier = 1, hpMultiplier = 1, dodgeMultiplier = 1, defMultiplier = 1;
        
        double allStats[], currentStats[];
        String displayStats[];

        int level = 1;
        double xp = 0;
        final int XP_TO_LVL_UP = 100;
        public int howLongDisabled, howLongSpeedUp, howLongAtkUp, howLongDefUp, howLongDodgeUp;
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

        Stats(double hp, double mp, double spd, double atk, double pd, double md, double def, double end, double stam,
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

        // * prints out the stats of the player
        // more will be added here, this is just to test
        public void getInfo(String chosenClass) {

                Printer.printColor(
                                chosenClass.substring(0, 1).toUpperCase() + chosenClass.substring(1).toLowerCase()
                                                + ":",
                                "white");
                System.out.println();
                int i = 0;
                for (Double element : allStats) {
                        Printer.printColor(displayStats[i] + ": " + String.valueOf(element), "white");
                        i++;
                }
        }

        public void addXP(int xpGained) {
                xp =+ xpGained;
                checkXP();
        }

        public void checkXP() {
                if(xp / XP_TO_LVL_UP == 1){
                        xp-= XP_TO_LVL_UP;
                        levelUp();
                        checkXP();
                }
        }

        public void levelUp() {
                Printer.printColor("---------------------------------------------------------", "yellow");
                Printer.printColor("Congratulations! Your level has increased!", "yellow");
                Printer.printColor("---------------------------------------------------------", "yellow");
                Double statPercentageIncreasePerLevel = 1.05;
                for (int i = 0; i < allStats.length; i++) {
                        allStats[i] = allStats[i] * statPercentageIncreasePerLevel;
                        currentStats[i] = currentStats[i] * statPercentageIncreasePerLevel;
                }
        }

        public void heal() {
                currentHP = maxHP;
        }

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
                if(defMultiplier == 2){return false;}
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
                if(dodgeMultiplier == 2){return false;}
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
