package TownInfo;

import PlayerInformation.*;
import Tools.*;
import fightInfo.*;

public class Missions {

    private String missionName, problem, thankYouFarewell, greeting, color;
    private String[] mobNames, itemRewards;
    private int[] mobLevels;
    private Player player;
    private Stats playerStats;
    private int XP_Reward;
    private MobSummoner mobSummoner = new MobSummoner();
    private Combat combat;
    private Town town;
    private boolean isMissionComplete = false;
	private Guild guild;
	private int recommendedLevel, cashReward; 

    /**
     * Constructs a mission with all of the information that we will need to run it. 
     * 
     * @param cashReward            - The amount of cash that a player receive for completing the mission
     * @param guild                 - The guild from which the mission is sent from
     * @param missionName           - The name of the mission
     * @param mobNames              - The names of the mobs who are in the mission. 
     * @param mobLevels             - The levels of the mobs in the dungeon
     * @param player                - The player
     * @param problem               - The objective of the mission
     * @param greeting              - What is said to the player once they enter the mission
     * @param thankYouFarewell      - The farewell to the player if they successfully complete the mission
     * @param color                 - The color of the text in the mission
     * @param XP_Reward             - The reward for completing the mission
     * @param itemRewards           - The reward for completing mission
     * @param recommendedLevel      - Recommended level for the mission
     */
    Missions(int cashReward, Guild guild, String missionName, String[] mobNames, int[] mobLevels, Player player, String problem, String greeting, String thankYouFarewell, String color, int XP_Reward, String[] itemRewards, int recommendedLevel){
        this.cashReward = cashReward;
        this.guild = guild;
        this.town = player.getCurrentTown();
        this.missionName = missionName;
        this.mobNames = mobNames;
        this.player = player;
        this.playerStats = player.getPlayerStats();
        this.problem = problem;
        this.thankYouFarewell = thankYouFarewell;
        this.mobLevels = mobLevels;
        this.color = color;
        this.XP_Reward = XP_Reward;
        this.itemRewards = itemRewards;
        this.greeting = greeting;
        this.recommendedLevel = recommendedLevel;
    }

    //returns the name of the mission
    public String getMissionName(){
        return missionName;
    }

    //prints out the information about the mission, including the missions name, rewards, and problem. 
    public void printMissionInfo(){
        Printer.printItalizcizedColor( problem  , "grey");
        Printer.printColor("Rewards: " + XP_Reward + "XP" + " and "+cashReward + " fusion coins!", "green");
        Printer.printColor("This mission is recommended for level " + recommendedLevel+ " players\n", color);
        // Printer.printItalizcizedColor( problem + "\nRewards: " + XP_Reward + "XP & " + itemRewards.toString(),"grey");
    }

    /**
     * Runs the mission by teleporting the user, and introducing them to the problem again, before starting the battle. 
     */
    public void runMission(){
        Stats currentMobStats;
        String[] currentMobAttacks;
        int[] currentMobAttackCosts;
        Printer.printColor("Teleporting...", "blue");
        System.out.println("-----------------------------------------------------------");
        Printer.printColor(greeting, color);
        
        //For each mob in the battle, we will have to fight it with our current Stats. Goal is to defeat all enemies, then we get our reward. 
        for (int i = 0; i < mobNames.length; i++) {

            Printer.printColor("Watch out! A level "+ mobLevels[i] + " "+ mobNames[i] + " has appeared!!! \n", color);
            //makes the stats of the current mob equal to the stats of the 
            if(mobNames[i].equalsIgnoreCase("Cyber Punk")){
                currentMobStats = mobSummoner.newCyberPunk(mobLevels[i]);
            }
            else if(mobNames[i].equalsIgnoreCase("Greater Will Assassin")){
                currentMobStats = mobSummoner.newGreaterWillAssassin(mobLevels[i]);
            }
            else if(mobNames[i].equalsIgnoreCase("Nano Bot Cluster")){
                currentMobStats = mobSummoner.newNanoBotCluster(mobLevels[i]);
            }
            else{
                System.out.println("Incorrect spelling of opponent name");
                return;
            }
            currentMobAttackCosts = mobSummoner.getChosenAttackCosts();
            currentMobAttacks = mobSummoner.getChosenAttacks();
            
            combat = new Combat(player, playerStats, currentMobStats, currentMobAttacks, currentMobAttackCosts, mobSummoner);
            combat.fight(false);

            //if the player died, we go back to the town. 
            if(combat.didPlayerDie() == true){
                missionFailed();
                return;
            }
            Printer.printColor((i+1) + "/" + mobNames.length + " mob's defeated!\n", "green");

            Printer.quickBreak(2000);
        }
        missionSuccessful();
    }

    public boolean isMissionComplete(){return isMissionComplete;}

/**
 * Runs the stuff if the mission is successful. 
 */
    public void missionSuccessful(){

        Printer.printColor(thankYouFarewell, color);
        isMissionComplete = true;

        Printer.printColor("Distributing " + XP_Reward + " XP... ","yellow");
        Printer.quickBreak(1000);
        player.checkXP(XP_Reward);

        Printer.printColor("Distributing " + cashReward + " Fusion coins... ","green");
        player.getBank().deposit(cashReward);
        player.getBank().printBalance();

        Printer.printColor("\nTeleporting back to town!\n", color);
        Printer.quickBreak(1000);
        town.characterEnteringTown();

    }

/**
 * Send player back to hospital if the mission has not been complete. 
 */
    public void missionFailed(){
        Printer.printColor("Teleporting back to town for recovery...","cyan");
        town.playerNeedsHospital();
        return;
    }
}