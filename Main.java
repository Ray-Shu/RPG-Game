public class Main {
    public static void main(String[] args) {
        boolean finishedGame = false;

        while (!finishedGame) {

            // Bank playerAccount = new Bank(1000);
            // Town town = new Town("Golden", 1, playerAccount);
            // town.characterEnteringTown();

            // MainStory story = new MainStory();
            // story.prologue();

            Player player = new Player("hsajkfh");
            Stats playerStats = player.forceCombat();
            Stats mobStats = new Stats(300.0, 80.0, 0.75, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0,
                                                1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
            String mobAttacks[] = {};
            Combat combat = new Combat(player, playerStats, mobStats, mobAttacks);
            combat.fight();
            // // *Prologue

            // // *Character class selection process
            // Player player = new Player();
            // player.nameSelection();
            // player.classSelection();

            finishedGame = true;

        }

    }
}
