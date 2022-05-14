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
	private int recommendedLevel; 

    //TODO: ADD COMMENTS TO THIS PART
    //I will do later, cause my extensions do not work with liveshare and this would take ages.
    Missions(Guild guild, Town town, String missionName, String[] mobNames, int[] mobLevels, Player player, Stats playerStats, String problem, String greeting, String thankYouFarewell, String color, int XP_Reward, String[] itemRewards, int recommendedLevel){
        
        this.guild = guild;
        this.town = town;
        this.missionName = missionName;
        this.mobNames = mobNames;
        this.player = player;
        this.playerStats = playerStats;
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
        Printer.printItalizcizedColor( problem + "\nRewards: " + XP_Reward + "XP", "grey");
        Printer.printColor("This mission is recommended for level " + recommendedLevel+ " players", color);
        // Printer.printItalizcizedColor( problem + "\nRewards: " + XP_Reward + "XP & " + itemRewards.toString(),"grey");
    }

    /**
     * Runs the mission by teleporting the user, and introducing them to the problem again, before starting the battle. 
     */
    public void runMission(){
        Stats currentMobStats;
        String[] currentMobAttacks;
        int[] currentMobAttackCosts;
        Printer.printColor("Teleporting... \n--------------------------------------------", "blue");
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
        Printer.printColor("Rewards: " + XP_Reward + "XP & " + itemRewards.toString(),"grey\n");
        Printer.quickBreak(1000);
        playerStats.addXP(XP_Reward);
        isMissionComplete = true;
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