import fightInfo.*;
import PlayerInformation.*;
import StoryInformation.*;
import Tools.Printer;

import java.util.ArrayList;

import TownInfo.*;

public class Main {
    
    static MobSummoner mobSummoner = new MobSummoner();
    public static void main(String[] args) {
           
        // *InventoryTesting
        //inventoryTest();

        // //* Combat Testing (using class: cyborg)
        //* Probaly broken... LOL
        // Player player = new Player("bruhmoment");
        // Stats playerStats = player.getPlayerStats();
        // Player.playerDied();
        // Checkpoints checkpoint = new Checkpoints(playerStats);
            

        // Stats mobStats = mobSummoner.newNanoBotCluster(1);
        // String mobAttacks[] = mobSummoner.NANO_BOT_ATTACKS;
        // int mobAttacksCost[] = mobSummoner.NANO_BOT_COST;
        // Combat combat = new Combat(player, player.playerStats, mobStats, mobAttacks, mobAttacksCost, mobSummoner);

        // do {
        // checkpoint.backToCheckpoint();
        // //Time to fight
        // combat.fight(true);
        // } while(combat.didPlayerDie());
            

                    
        // *Story Line (currently working on chapter One) 
        // storyTesting();
        MainStory story = new MainStory();
        story.startStory(); 
    
                    
        //* Town Tests
        // Bank bank = new Bank(1000);
        // PlayerCreation lord = new PlayerCreation(bank, "Jeff");
        // Player player = lord.testPlayer();
        // TownMaker townMaker = new TownMaker(player);
        // player.makeTownMaker(townMaker);
        // player.checkXP(10000);
        // townMaker.makeTowns();
        // townMaker.increaseMaxTownLevel();
        // townMaker.getCurrentTown().characterEnteringTown(false);
            
            
        /**
         * SOME BUGS THAT I'VE FOUND WHILE TESTING SOME STUFF
         * IF I DONT GET AROUND TO FIXING THEM, ILL LIST THEM HERE
         * 
         * BUGS:
         * unmappable character for encoding windows keeps occuring
         * for now, copy past: javac -encoding UTF-8 PlayerInformation/Player.java
         * until theres a better fix
         * 
         * the attack 'overload' for cyborg shows a bugged mp cost
         */

        //!MAKING THE ATTACK STAT RLY HIGH SO I CAN DO TESTS QUICKER 
        //!IF YOU WANT TO CHANGE IT TO NORMAL, REMOVE THE *(90) MULTIPLIER IN STATS CALCULATOR method doDamage

        //!TEMPORARY CHANGE TO PRINTING OUT CLASSES TO TEST FASTER
        //!UNCOMMENT IN PLAYERCREATION TO FIX


    }

//     public void goToCurrentTown(){
//         townMaker.goToCurrentTown();
//     }


    public static void storyTesting(){ 
        
    }
}
