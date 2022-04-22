public class Main {
    public static void main(String[] args) {
        boolean finishedGame = false;

        while (!finishedGame) {

            // *Character class selection process
            Player player = new Player();
            player.classSelection();
            finishedGame = true;

        }

    }
}
