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
            Player player = new Player("hsajkfh");
            Stats playerStats = player.forceCombat();

            Stats mobStats = mobSummoner.newCyberPunk(1);
            String mobAttacks[] = mobSummoner.CYBER_PUNK_ATTACKS;
            String mobAttacksCost[] = mobSummoner.CYBER_PUNK_ATTACKS;

            Combat combat = new Combat(player, playerStats, mobStats, mobAttacks, mobAttacksCost, mobSummoner);
            combat.fight();

            // *StoryLine (currently working on chapter One)
            // MainStory story = new MainStory();
            // // //story.prologue();
            // story.chapterOne(); 


            finishedGame = true;

        }

    }
}
