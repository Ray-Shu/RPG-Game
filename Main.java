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
            // Town town = new Town("Golden", 1, playerAccount);
            // town.characterEnteringTown();
            
           
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
            MainStory story = new MainStory();
            //story.prologue();
            story.chapterOne(); 


            finishedGame = true;

        }

        /**
         * SOME BUGS THAT I'VE FOUND WHILE TESTING SOME STUFF
         * IF I DONT GET AROUND TO FIXING THEM, ILL LIST THEM HERE
         * 
         * BUGS:
         * nothing happens if player mp is out 
         * 
         */

         //? Possibly make healing heal around 40% hp? 

    }
}
