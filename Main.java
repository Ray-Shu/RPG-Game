import fightInfo.*;
import PlayerInformation.*;
import StoryInformation.*;

import java.util.ArrayList;

import PlayerAssistants.*;
import TownInfo.*;

public class Main {
    
    static MobSummoner mobSummoner = new MobSummoner();
    public static void main(String[] args) {
        boolean finishedGame = false;

        while (!finishedGame) {
 
            // // *Town Testing
            // Player player = new Player("bruhmoment");
            // Bank playerAccount = new Bank(1000);
            // TownMaker townMaker = new TownMaker(playerAccount,player, player.forceCombat());
            // townMaker.makeSlums();
            // townMaker.runSlums();
            
            // *InventoryTesting
            //inventoryTest();

            // //* Combat Testing (using class: cyborg)
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
            

                    
            //*Story Line (currently working on chapter One)
            // MainStory story = new MainStory();
            // story.prologue();
                    
            //Town Tests
            Bank bank = new Bank(1000);
            PlayerCreation lord = new PlayerCreation(bank, "Jeff");
            Player player = lord.testPlayer();
            TownMaker townMaker = new TownMaker(player);
            player.makeTownMaker(townMaker);
            townMaker.makeSlums();
            townMaker.runSlums();
             
            finishedGame = true;

        }

        /**
         * SOME BUGS THAT I'VE FOUND WHILE TESTING SOME STUFF
         * IF I DONT GET AROUND TO FIXING THEM, ILL LIST THEM HERE
         * 
         * BUGS:
         * unmappable character for encoding windows keeps occuring
         * for now, copy past: javac -encoding UTF-8 PlayerInformation/Player.java
         * until theres a better fix
         */


         //Will work more on inventory; need to have it sync with Combat and implement 'leave' function in inventory
    }

//     public void goToCurrentTown(){
//         townMaker.goToCurrentTown();
//     }

    public static void inventoryTest(){
        ArrayList<String> itemsToAdd = new ArrayList<String>(); 
            
            //itemsToAdd.add("Rogue helm"); 
            itemsToAdd.add("Mage hood");
            itemsToAdd.add("mana potion");
            itemsToAdd.add("health potion");
            itemsToAdd.add("Superior Spectral Helm");
            itemsToAdd.add("Speed potion");
            itemsToAdd.add("cyborg weapon");
            itemsToAdd.add("xenon blaster");

            // Player player = new Player("test"); 
            // Stats playerStats = player.getPlayerStats(); 
            //inventory.addInventory(itemsToAdd);
            // inventory.playerInventoryAddEquippedArmour("Battered Spectral Helm", "Battered Spectral Chestplate", "Battered Spectral Leggings", null);
            // inventory.showInventory();
    }
}
