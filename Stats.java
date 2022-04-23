import java.util.Arrays;

public class Stats {
        public Double hp, mp, spd, atk, physDmg, magicDmg, def, end, stam, physRes, magicRes, dodge, vit,
                        critRate,
                        critDmg, luck;

        Double allStatsInfo[];
        String displayStats[];

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
         *                 slaying a foe //TODO more info will be added to luck
         */

        Stats(Double hp, Double mp, Double spd, Double atk, Double pd, Double md, Double def, Double end, Double stam,
                        Double physRes, Double magicRes, Double dodge, Double vit, Double cr, Double cd, Double luck) {
                this.hp = hp;
                this.mp = mp;
                this.spd = spd;
                this.atk = atk;
                this.physDmg = pd;
                this.magicDmg = md;
                this.def = def;
                this.end = end;
                this.stam = stam;
                this.physRes = physRes;
                this.magicRes = magicRes;
                this.dodge = dodge;
                this.vit = vit;
                this.critRate = cr;
                this.critDmg = cd;
                this.luck = luck;

                Double[] allStatsInfo = { hp, mp, spd, atk, physDmg, magicDmg, def, end, stam, physRes, magicRes, dodge,
                                vit,
                                critRate, critDmg, luck };

                this.allStatsInfo = allStatsInfo;

                String[] displayStats = { "HP", "MP", "Speed", "Attack", "Physical Damage", "Magic Damage", "Defense",
                                "Endurance", "Stamina", "Phyical Resistance", "Magic Resistance", "Dodge", "Vitality",
                                "Crit Rate",
                                "Crit Damage", "Luck" };

                this.displayStats = displayStats;
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
                for (Double element : allStatsInfo) {
                        Printer.printColor(displayStats[i] + ": " + String.valueOf(element), "white");
                        i++;
                }
        }

}
