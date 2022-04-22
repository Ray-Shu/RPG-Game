public class Main {
    public static void main(String[] args) {
        boolean finishedGame = false;

        while (!finishedGame) {

            Bank playerAccount = new Bank(1000);
            Town town = new Town("Golden", 1, playerAccount);
            town.characterEnteringTown();
            // // *Character class selection process
            // Player player = new Player(); 
            // player.nameSelection();
            // player.classSelection();
            // finishedGame = true; 

        }

    }
}
