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
    public void nameSelection () {
        Printer.printColor("What is your name?", "red");
        characterName = scan.nextLine();
        Printer.printColor("Welcome back " + characterName, "red");
        System.out.println("\n" + "-------------------------------------------");
    }
    
    /**
     *  * CLASS SELECTION AND STAT DISTRIBUTION
     * This part of the code makes the user enter one of the classes listed above, and then
     * creates the character's stats based off of those inputted values. 
     * TODO: Finish writing out classes and determining base stats
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
        //Maybe we add description of character here?
        Printer.printColor("The cyborg is a well rounded assault unit with strong offensive and defensive abilities. "
                + "\nCyborgs are highly skilled in hand to hand combat and with laser rifles. \n", "yellow");
        
        Printer.printColor("HP: 200" + '\n' + "MP: 100" + '\n' + "SPD: 1.00" + '\n' + "ATK: 5" + '\n'
                + "Physical Damage: 5" + '\n' + "Magic Damage: 0", "blue");
        System.out.println('\n' + "--------------------------------------------------");
        //Maybe we have it pause quickly so the user can see the information about the class more. 
        quickBreak();

        // Hacker
        System.out.println();
        Printer.printColor("Hacker" + '\n' + "HP: 300" + '\n' + "MP: 80" + '\n' + "SPD: 0.75" + '\n' + "ATK: 4" + '\n'
                + "Physical Damage: 3" + '\n' + "Magic Damage: 3", "green");
        System.out.println('\n' + "--------------------------------------------------");
        
        quickBreak();
        // Terminator
        System.out.println();
        Printer.printColor("Terminator" + '\n' + "HP: 300" + '\n' + "MP: 90" + '\n' + "SPD: 0.70" + '\n' + "ATK: 5"
                + '\n' + "Physical Damage: 6" + '\n' + "Magic Damage: 0", "red");
        System.out.println('\n' + "--------------------------------------------------");
    
        
        String chosenClass = ErrorChecker.compareArrayOfStrings(CLASSES, "Please choose a valid class", "purple");
        switch (chosenClass) {
            // * string param must be all lower-case
            case "cyborg":
                playerStats = new Stats(5.0, 200.0, 100.0, 1.0, 5.0, 5.0, 0.0, 5.0, 5.0, 5.0, 5.0, 5.0);
                Printer.printColor("You chose Cyborg.", "cyan");
                break;
            case "hacker":
                Printer.printColor("You chose Hacker.", "cyan");
                break;
            case "terminator":
                Printer.printColor("You chose Terminator.", "cyan");
                break;
            case "laser swordsman":
                Printer.printColor("You chose laser Swordsman.", "cyan");
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
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}