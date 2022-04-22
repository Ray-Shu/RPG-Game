public class Player {
    final String CLASSES[] = { "cyborg", "hacker", "terminator", "lazer swordsman", "rogue", "mystic" };

    // Creates the player by asking questions and stuff. Chooses classes
    public void classSelection() {
        Printer.printColor("Which class would you like to be?", "purple");

        // * Prints the stats for all of the classes
        // Cyborg
        System.out.println();
        Printer.printColor("Cyborg" + '\n' + "HP: 200" + '\n' + "MP: 100" + '\n' + "SPD: 1.00" + '\n' + "ATK: 5" + '\n'
                + "Physical Damage: 5" + '\n' + "Magic Damage: 0", "blue");
        System.out.println('\n' + "--------------------------------------------------");

        // Hacker
        System.out.println();
        Printer.printColor("Hacker" + '\n' + "HP: 300" + '\n' + "MP: 80" + '\n' + "SPD: 0.75" + '\n' + "ATK: 4" + '\n'
                + "Physical Damage: 3" + '\n' + "Magic Damage: 3", "green");
        System.out.println('\n' + "--------------------------------------------------");

        // Terminator
        System.out.println();
        Printer.printColor("Terminator" + '\n' + "HP: 300" + '\n' + "MP: 90" + '\n' + "SPD: 0.70" + '\n' + "ATK: 5"
                + '\n' + "Physical Damage: 6" + '\n' + "Magic Damage: 0", "red");
        System.out.println('\n' + "--------------------------------------------------");

        String chosenClass = ErrorChecker.compareArrayOfStrings(CLASSES, "Please choose a valid class", "purple");
        switch (chosenClass) {
            // * string param must be all lower-case
            case "cyborg":
                Printer.printColor("You chose Cyborg.", "cyan");
                break;
            case "hacker":
                Printer.printColor("You chose Hacker.", "cyan");
                break;
            case "terminator":
                Printer.printColor("You chose Terminator.", "cyan");
                break;
            case "lazer swordsman":
                Printer.printColor("You chose Lazer Swordsman.", "cyan");
                break;
            case "rogue":
                Printer.printColor("You chose Rogue.", "cyan");
                break;
            case "mystic":
                Printer.printColor("You chose Mystic.", "cyan");
                break;

        }
    }
}