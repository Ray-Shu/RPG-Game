import fightInfo.*;
import PlayerInformation.*;
import StoryInformation.*;
import PlayerAssistants.*;
public class Main {
    
    static MobSummoner mobSummoner = new MobSummoner();
    public static void main(String[] args) {
        boolean finishedGame = false;

        while (!finishedGame) {

            //*Town Testing
            // Bank playerAccount = new Bank(1000);
            // TownMaker townMaker = new Townmaker(playerAccount);
            //townMaker.makeSlums;
            //townMaker.runSlums;
            
           
            //* Combat Testing (using class: cyborg)
            // Player player = new Player("bruhmoment");
            // player.playerDied();
            //Checkpoints checkpoint = new Checkpoint(player);
            

            // Stats mobStats = mobSummoner.newNanoBotCluster(1);
            // String mobAttacks[] = mobSummoner.NANO_BOT_ATTACKS;
            // int mobAttacksCost[] = mobSummoner.NANO_BOT_COST;

            // do {
            //checkpoints.backToCheckpoint();
            //Time to fight
            // Combat combat = new Combat(player, player.playerStats, mobStats, mobAttacks, mobAttacksCost, mobSummoner);
            // combat.fight(true);
            // } while(combat.hasPlayerDied());

            
            //*StoryLine (currently working on chapter One)
            // MainStory story = new MainStory();
            // story.prologue();
            
            
            //*InventoryTesting
            Inventory inventory = new Inventory(); 
            inventory.showInventory();


            // finishedGame = true;

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


    }

//     public void goToCurrentTown(){
//         townMaker.goToCurrentTown();
//     }
}
