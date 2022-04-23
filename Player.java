import java.util.Scanner;

public class Player {
        final String CLASSES[] = { "cyborg", "hacker", "terminator", "laser swordsman", "rogue", "mystic" };
        Stats playerStats;
        private static Scanner scan = new Scanner(System.in);
        public static String characterName;

        /**
         * * NAMING OF CHARACTER:
         * gets the user to enter a name.
         */
        public void nameSelection() {
                Printer.printColor("What is your name?", "red");
                characterName = scan.nextLine();
                Printer.printColor("Welcome back " + characterName, "red");
                System.out.println("\n" + "-------------------------------------------");
        }

        /**
         * * CLASS SELECTION AND STAT DISTRIBUTION
         * This part of the code makes the user enter one of the classes listed above,
         * and then
         * creates the character's stats based off of those inputted values.
         * TODO: Finish writing out classes and determining base stats | NEARLY
         * FINISHED, MAY NEED TO ADD ADJUSTMENTS
         * TODO: Implement random perks
         */

        // yellow cyan
        // Creates the player by asking questions and stuff. Chooses classes
        public void classSelection() {
                Printer.printColor("Class Selection: ", "white");

                // * Prints the stats for all of the classes

                // Cyborg
                System.out.println();
                Printer.printColor("Cyborg:", "blue");

                // character description
                Printer.printColor(
                                "The Cyborg is a well rounded assault unit with strong offensive and defensive abilities. "
                                                + "\nCyborgs are highly skilled in hand to hand combat and with laser rifles. \n",
                                "white");

                Printer.printColor("HP: 200" + '\n' + "MP: 100" + '\n' + "SPD: 1.00" + '\n' + "ATK: 5" + '\n'
                                + "DEF: 5", "blue");
                System.out.println('\n' + "--------------------------------------------------");
                quickBreak();

                // Hacker
                System.out.println();
                Printer.printColor("Hacker: ", "green");

                // character description
                Printer.printColor("Unparalleled in their mastery and knowledge of all technology related," +
                                "\nthe Hacker is a tank unit who wields control over an arsenal of automated technological weaponry. \n",
                                "white");
                Printer.printColor("HP: 300" + '\n' + "MP: 80" + '\n' + "SPD: 0.75" + '\n' + "ATK: 3" + '\n'
                                + "DEF: 7", "green");
                System.out.println('\n' + "--------------------------------------------------");
                quickBreak();

                // Terminator
                System.out.println();
                Printer.printColor("Terminator: ", "red");

                // character description
                Printer.printColor(
                                "The Terminator is an unpredictable aggressive beast who specializes in close-range combat."
                                                + "\nBlinded by fury, these individuals wreak havoc on anything that may get on their nerves.\n",
                                "white");
                Printer.printColor("HP: 250" + '\n' + "MP: 50" + '\n' + "SPD: 1.00" + '\n' + "ATK: 6"
                                + '\n' + "DEF: 3", "red");
                System.out.println('\n' + "--------------------------------------------------");
                quickBreak();

                // Lazer Swordsman
                System.out.println();
                Printer.printColor("Lazer Swordsman: ", "cyan");

                // character description
                Printer.printColor("The Lazer Swordsman is a composed, well-balanced and versatile individual."
                                + "\nJack of all trades yet master of none. \n", "white");
                Printer.printColor(
                                "HP: 200" + '\n' + "MP: 100" + '\n' + "SPD: 1.25" + '\n' + "ATK: 5"
                                                + '\n' + "DEF: 6",
                                "cyan");
                System.out.println('\n' + "--------------------------------------------------");
                quickBreak();

                // Rogue
                System.out.println();
                Printer.printColor("Rogue: ", "yellow");

                // character description
                Printer.printColor(
                                "The Rogue is sneaky, speedy thief. They make up for their fragility with their evasion and high damage output."
                                                + "\nA glass cannon of sorts. \n",
                                "white");
                Printer.printColor(
                                "HP: 150" + '\n' + "MP: 100" + '\n' + "SPD: 1.50" + '\n' + "ATK: 7"
                                                + '\n' + "DEF: 2",
                                "yellow");
                System.out.println('\n' + "--------------------------------------------------");
                quickBreak();

                // Mystic
                System.out.println();
                Printer.printColor("Mystic ", "purple");

                // character description
                Printer.printColor(
                                "The Mystic is a mysterious individual; while their origins, and their tools-of-the-trade are unknown,"
                                                +
                                                "\nthey offer a service irrefutable for the rebels. Blessed by the Gods, the mystic specializes in magic of many elements. \n",
                                "white");
                Printer.printColor(
                                "HP: 200" + '\n' + "MP: 100" + '\n' + "SPD: 1.25" + '\n' + "ATK: 7"
                                                + '\n' + "DEF: 3",
                                "purple");
                System.out.println('\n' + "--------------------------------------------------");

                // asks which class to be
                System.out.println();
                Printer.printColor("Which class would you like to select?", "white");
                String chosenClass = ErrorChecker.compareArrayOfStrings(CLASSES, "Please choose a valid class",
                                "purple");
                switch (chosenClass) {
                        // * string param must be all lower-case
                        case "cyborg":
                                playerStats = new Stats(200.0, 100.0, 1.00, 5.0, 7.0, 4.0, 5.0, 8.0, 100.0, 6.0,
                                                3.0, 0.0, 0.0, 0.0,
                                                0.0, 1.0);
                                Printer.printColor("You chose Cyborg.", "cyan");

                                playerStats.getInfo(chosenClass);

                                break;
                        case "hacker":
                                playerStats = new Stats(300.0, 80.0, 0.75, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0,
                                                1.0, 0.0, 0.0, 0.0,
                                                0.0, 1.0);
                                Printer.printColor("You chose Hacker.", "cyan");

                                playerStats.getInfo(chosenClass);
                                break;
                        case "terminator":
                                Printer.printColor("You chose Terminator.", "cyan");
                                break;
                        case "laser swordsman":
                                Printer.printColor("You chose Laser Swordsman.", "cyan");
                                break;
                        case "rogue":
                                Printer.printColor("You chose Rogue.", "cyan");
                                break;
                        case "mystic":
                                Printer.printColor("You chose Mystic.", "cyan");
                                break;

                }

        }

        public void quickBreak() {
                try {
                        Thread.sleep(0);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }

}