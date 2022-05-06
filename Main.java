import fightInfo.*;
import PlayerInformation.*;
import StoryInformation.*;

public class Main {
    
    static MobSummoner mobSummoner = new MobSummoner();
    public static void main(String[] args) {
        boolean finishedGame = false;

        while (!finishedGame) {

            //*Town Testing
            // Bank playerAccount = new Bank(1000);
            // Town town = new Town("Golden", 1, playerAccount);
            // town.characterEnteringTown();
           
            // //* Combat Testing (using class: cyborg)
            Player player = new Player("hsajkfh");
            Stats playerStats = player.forceCombat();

            Stats mobStats = mobSummoner.newCyberPunk(1);
            String mobAttacks[] = mobSummoner.CYBER_PUNK_ATTACKS;
            int mobAttacksCost[] = mobSummoner.CP_MP_COSTS;

            Combat combat = new Combat(player, playerStats, mobStats, mobAttacks, mobAttacksCost, mobSummoner);
            combat.fight(true);

            // *StoryLine (currently working on chapter One)
            // MainStory story = new MainStory();
            // //story.prologue();
            // story.chapterOne(); 


            finishedGame = true;

        }

    }
}
