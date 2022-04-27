import java.util.Scanner;

public class Player {
        final String CLASSES[] = { "cyborg", "hacker", "terminator", "laser swordsman", "rogue", "mystic" };
        Stats playerStats;

        final String CYBORG_ATTACKS[] = {"Laser Barrage", "Charged Shot", "Cyber Shield", "Overload"};
        final String CYBORG_ATTACK_INFO[] = {"Laser Barrage unleashes a flury of low damage laser shots on the opponents", 
                "The Charged Shot unleashes a powerful blast capable dealing major damage", 
                "The Cyber Shield increases defence for the next 3 turns", 
                "Overload greatly increases attack for the next 3 turns"};

        final String HACKER_ATTACKS[] = {"Drone Army", "Stolen Missile", "Watchful Vulture", "Watchful Vulture"};
        final String HACKER_ATTACKS_INFO[] = {"Drone Army summons an army of drones dealing large damage as they attack over 3 turns",
                "With the Stolen Missile ability, the hacker siezes a missile from the government and tries to use it to destroy their enemies",
                "The hacker's Watchful Vulture ability uses realtime satalite imagery to locate enemies and ensure hits for the next 3 turns",
                "The hacker gets \"In The System\" with their final ability to disable their enemy robots for 2 turns"};

        final String TERMINATOR_ATTACKS[] = {"Machine Gun Fury", "First Impact Fists", "Deceiving Blast of Cybernetic Proportions", "Hunker Down"};
        final String TERMINATOR_ATTACKS_INFO[] = {"The Terminator unleashes their Machine gun to deal major damage to opponents",
                "The Terminator gets a heavily impactful strike on their enemy. ",
                "The Terminators special move surprises enemies and blinding them for 2 turns. ",
                "The Hunker Down ability increases ATK, but removes chance of dodging an attack. "};

        final String SWORDSMAN_ATTACKS[] = {"Swift Thrust of the Sword", "Fatal Erruption Of Bullets", "Lightning Clone Strike", "Rest"};
        final String SWORDSMAN_ATTACKS_INFO[] = {"",
                "",
                "",
                ""};
        
        final String ROGUE_ATTACKS[] = {"Quick Blast", "Death Strike", "Secret Mushroom Strike", "Forbidden Smoke of the Holy Tree"};
        final String ROGUE_ATTACKS_INFO[] = {"",
                "",
                "",
                ""};
        
        final String MYSTIC_ATTACKS[] = {"Dragon Shatter", "Simple Strike", "Frost Erruption" , "Burning Prison"};
        final String MYSTIC_ATTACKS_INFO[] = {"",
                "",
                "",
                ""};
        
        final String REVEREND_ATTACKS[] = {"holy_flash_of_radiant_light", "divine_smite", "holy_healing", "prayer"};
        final String REVEREND_ATTACKS_INFO[] = {"",
                "",
                "",
                ""};
        
        private final String CHOOSE_CRATE_AND_CRATE_INFO[] = {"1", "2", "3", "4", "5", "6", "7", "M1", "M2", "M3", "M4", "M5", "M6", "M7"};
        
        private final String CHOOSE_CRATE[] = {"1", "2", "3", "4", "5", "6", "7"};
        
        private final String CRATE_INFO[] = {"M1", "M2", "M3", "M4", "M5", "M6", "M7"};
        

        String chosenAttacks[];
        String descriptionOfAttacks[];
        private static Scanner scan = new Scanner(System.in);
        public static String characterName;

        public void printCrateInfo() {
                //* CRATE ONE INFO - Cyborg
                Printer.printColor("[1] Crate One:", "blue"); 
                Printer.print("Battered Spectral Helm");
                Printer.print("Battered Spectral Chestplate");
                Printer.print("Battered Spectral Greaves"); 
                Printer.print("Battered Spectral Heelguards");
                Printer.print("[M1] - More info");
        
                System.out.println();
        
        
                //* CRATE TWO INFO - Hacker
                Printer.printColor("[2] Crate Two:", "green"); 
                Printer.print("Battered Spectral Helm");
                Printer.print("Battered Spectral Chestplate");
                Printer.print("Battered Spectral Greaves"); 
                Printer.print("Battered Spectral Heelguards");
                Printer.print("[M2] - More info");
        
                System.out.println();
        
        
                //* CRATE THREE INFO - Terminator
                Printer.printColor("[3] Crate Three:", "red"); 
                Printer.print("Battered Spectral Helm");
                Printer.print("Battered Spectral Chestplate");
                Printer.print("Battered Spectral Greaves"); 
                Printer.print("Battered Spectral Heelguards");
                Printer.print("[M3] - More info");
        
                System.out.println();
        
                //* CRATE FOUR INFO - Lazer Swordsman
                Printer.printColor("[4] Crate Four:", "cyan"); 
                Printer.print("Battered Spectral Visor");
                Printer.print("Battered Spectral Quasiplate");
                Printer.print("Battered Spectral Chaps"); 
                Printer.print("Battered Spectral Shoes");
                Printer.print("[M4] - More info");
        
                System.out.println();
        
                //* CRATE FIVE INFO - Rogue
                Printer.printColor("[5] Crate Five:", "yellow"); 
                Printer.print("Battered Spectral Visor");
                Printer.print("Battered Spectral Quasiplate");
                Printer.print("Battered Spectral Chaps"); 
                Printer.print("Battered Spectral Shoes");
                Printer.print("[M5] - More info");
        
                System.out.println();
        
                //* CRATE SIX INFO - Mystic
                Printer.printColor("[6] Crate Six:", "purple"); 
                Printer.print("Battered Spectral Hood ");
                Printer.print("Battered Spectral Robe");
                Printer.print("Battered Spectral Leggings"); 
                Printer.print("Battered Spectral Boots");
                Printer.print("[M6] - More info");
         
                System.out.println();
         
                //* CRATE SEVEN INFO - Reverend
                Printer.printColor("[7] Crate Seven:", "white"); 
                Printer.print("Battered Spectral Hood");
                Printer.print("Battered Spectral Robe");
                Printer.print("Battered Spectral Leggings"); 
                Printer.print("Battered Spectral Boots");
                Printer.print("[M7] - More info");
         
                System.out.println();
        
                Printer.printItalizcizedColor("Enter the number of the crate to choose it. Enter [M#] to get more info on the crate\n", "purple");

                String chooseCrateOrCrateInfo = ErrorChecker.compareArrayOfStrings(CHOOSE_CRATE_AND_CRATE_INFO, "It's not that hard to choose a proper option is it?", "red");

                switch(chooseCrateOrCrateInfo) {
                        case "1": 
                        
                        break; 
                         
                        
                        case "2": 
                        
                        break; 

                        
                        case "3": 
                        
                        break; 


                        case "4": 
                        
                        break; 


                        case "5": 
                        
                        break; 

                        
                        case "6": 
                        
                        break; 
                        

                        case "7": 
                        
                        break; 


                        case "M1": 
                        
                        break; 
                        

                        case "M2": 
                        
                        break; 

                        
                        case "M3": 
                        
                        break; 
                        
                        
                        case "M4": 
                        
                        break; 

                        
                        case "M5": 
                        
                        break; 

                        
                        case "M6": 
                        
                        break; 


                        case "M7": 
                        
                        break; 
                }
                 
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
                //* Asks which class to be
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
                                chosenAttacks = CYBORG_ATTACKS;
                                break;
                        case "hacker":
                                playerStats = new Stats(300.0, 80.0, 0.75, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0,
                                                1.0, 0.0, 0.0, 0.0,
                                                0.0, 1.0);
                                Printer.printColor("You chose Hacker.", "cyan");

                                playerStats.getInfo(chosenClass);
                                chosenAttacks = HACKER_ATTACKS;
                                break;
                        case "terminator":
                                Printer.printColor("You chose Terminator.", "cyan");
                                chosenAttacks = TERMINATOR_ATTACKS;
                                break;
                        case "laser swordsman":
                                Printer.printColor("You chose Laser Swordsman.", "cyan");
                                chosenAttacks = SWORDSMAN_ATTACKS;
                                break;
                        case "rogue":
                                Printer.printColor("You chose Rogue.", "cyan");
                                chosenAttacks = ROGUE_ATTACKS;
                                break;
                        case "mystic":
                                Printer.printColor("You chose Mystic.", "cyan");
                                chosenAttacks = MYSTIC_ATTACKS;
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