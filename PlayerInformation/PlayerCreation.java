package PlayerInformation;
import Tools.*;
import TownInfo.TownMaker;


public class  PlayerCreation {
    private final String CLASSES[] = { "cyborg", "hacker", "terminator", "laser swordsman", "rogue", "mystic", "reverend" };
    public final String CYBORG_ATTACKS[] = {"Laser Barrage", "Charged Shot", "Cyber Shield", "Overload\t"};
    public final int CYBORG_ATTACK_COSTS[] = {0,15,5,20};

    private final String HACKER_ATTACKS[] = {"Virus Attack", "Stolen Missile", "Watchful Vulture", "In The System"};
    private final int HACKER_ATTACK_COSTS[] = {0,20,5,10};

    private final String TERMINATOR_ATTACKS[] = {"Machine Gun Fury\t\t\t", "First Impact Fists\t\t\t", "Deceiving Blast of Cybernetic Proportions", "Hunker Down\t\t\t\t"};
    private final int TERMINATOR_ATTACK_COSTS[] = {0,5,10,10};

    private final String SWORDSMAN_ATTACKS[] = {"Swift Thrust of the Sword", "Fatal Eruption Of Bullets", "Lightning Clone Strike", "Meditation\t\t"};
    private final int SWORDSMAN_ATTACK_COSTS[] = {0,13,25,0};
    
    private final String ROGUE_ATTACKS[] = {"Quick Blast\t\t", "Death Strike\t", "Secret Mushroom Strike", "Forbidden Smoke\t"};
    private final int ROGUE_ATTACK_COSTS[] = {0,12,10,5};
    
    private final String MYSTIC_ATTACKS[] = {"Dragon Shatter", "Simple Strike", "Frost Eruption" , "Burning Prison"};
    private final int MYSTIC_ATTACK_COSTS[] = {20,0,10,5};
    
    public final String REVEREND_ATTACKS[] = {"Holy Flash of Radiant Light\t", "Divine Smite\t\t", "Holy Healing\t\t", "Prayer\t\t\t"};
    public final int REVEREND_ATTACK_COSTS[] = {0,20,10,10};
    
    public final String CHOOSE_CRATE_AND_CRATE_INFO[] = {"1", "2", "3", "4", "5", "6", "7", "M1", "M2", "M3", "M4", "M5", "M6", "M7"};


    public Bank bankAccount;
    private String playerClass; 
    private Stats playerStats;
    private String chosenAttacks[];
    private int chosenAttacksCost[];
    private String playerName;
    private String chosenClass; 
    public TownMaker townMaker;

    /**
     * Creates the player creator which will create a character
     * @param bankAccount       - The bank account
     * @param name              - The player name
     */
    public PlayerCreation(Bank bankAccount, String name){
        playerName = name;
        this.bankAccount = bankAccount;
    }

    /**
     * Creates a test player, and returns it
     */
    public Player testPlayer(){
        playerStats = new Stats(150, 250, 1.25, 3.0, 0.0, 6.0, 4.0, 6.0, 200.0, 1.0, 6.0, 0.0, 5.0, 0.0, 0.0, 1.0);
        return new Player(playerStats, bankAccount, playerName,REVEREND_ATTACKS,REVEREND_ATTACK_COSTS,"reverend",this);
    }

    /**
     * Makes a new player. This is supposed to be used after we have chosen a character. 
     * @return
     */
    public Player getPlayer(){
        return new Player(playerStats, bankAccount, playerName, chosenAttacks, chosenAttacksCost, chosenClass,this); 
    }

    /**
     * Prints out the information about the crate
     */
    public void printCrateInfo() {
        //* CRATE ONE INFO - Cyborg
        Printer.printColor("[1] Crate One - Cyborg:", "blue"); 
        Printer.print("Battered Spectral Helm");
        Printer.print("Battered Spectral Chestplate");
        Printer.print("Battered Spectral Greaves"); 
        Printer.print("Battered Spectral Heelguards");
        Printer.print("[M1] - More info");

        System.out.println();


        //* CRATE TWO INFO - Hacker
        Printer.printColor("[2] Crate Two - Hacker:", "green"); 
        Printer.print("Battered Spectral Helm");
        Printer.print("Battered Spectral Chestplate");
        Printer.print("Battered Spectral Greaves"); 
        Printer.print("Battered Spectral Heelguards");
        Printer.print("[M2] - More info");

        System.out.println();


        //* CRATE THREE INFO - Terminator
        Printer.printColor("[3] Crate Three - Terminator:", "red"); 
        Printer.print("Battered Spectral Helm");
        Printer.print("Battered Spectral Chestplate");
        Printer.print("Battered Spectral Greaves"); 
        Printer.print("Battered Spectral Heelguards");
        Printer.print("[M3] - More info");

        System.out.println();

        //* CRATE FOUR INFO - Lazer Swordsman
        Printer.printColor("[4] Crate Four - Lazer Swordsman:", "cyan"); 
        Printer.print("Battered Spectral Visor");
        Printer.print("Battered Spectral Quasiplate");
        Printer.print("Battered Spectral Chaps"); 
        Printer.print("Battered Spectral Shoes");
        Printer.print("[M4] - More info");

        System.out.println();

        //* CRATE FIVE INFO - Rogue
        Printer.printColor("[5] Crate Five - Rogue:", "yellow"); 
        Printer.print("Battered Spectral Visor");
        Printer.print("Battered Spectral Quasiplate");
        Printer.print("Battered Spectral Chaps"); 
        Printer.print("Battered Spectral Shoes");
        Printer.print("[M5] - More info");

        System.out.println();

        //* CRATE SIX INFO - Mystic
        Printer.printColor("[6] Crate Six - Mystic:", "purple"); 
        Printer.print("Battered Spectral Hood");
        Printer.print("Battered Spectral Robe");
        Printer.print("Battered Spectral Leggings"); 
        Printer.print("Battered Spectral Boots");
        Printer.print("[M6] - More info");
 
        System.out.println();
 
        //* CRATE SEVEN INFO - Reverend
        Printer.printColor("[7] Crate Seven - Reverend:", "white"); 
        Printer.print("Battered Spectral Hood");
        Printer.print("Battered Spectral Robe");
        Printer.print("Battered Spectral Leggings"); 
        Printer.print("Battered Spectral Boots");
        Printer.print("[M7] - More info");
 
        System.out.println();

        Printer.printItalizcizedColor("Enter the number of the crate to choose it. Enter [M#] to get more info on the crate\n", "purple");

        Classes classInfo = new Classes(this); 
        //scan.nextLine();
        String chooseCrateOrCrateInfo = ErrorChecker.compareArrayOfStrings(CHOOSE_CRATE_AND_CRATE_INFO, "It's not that hard to choose a proper option, is it?", "red");

        //based on their answer, we choose a class, or give more information about that class. 
        switch(chooseCrateOrCrateInfo) {
                case "1": 
                        chooseCyborg("cyborg");
                break; 
                 
                
                case "2": 
                        chooseHacker("hacker");
                break; 

                
                case "3": 
                        chooseTerminator("terminator");
                break; 


                case "4": 
                        chooseLazerSwordsman("lazer swordsman");
                break; 


                case "5": 
                        chooseRogue("rogue");
                break; 

                
                case "6": 
                        chooseMystic("mystic");
                break; 
                

                case "7": 
                        chooseReverend("reverend");
                break; 


                case "M1": 
                        classInfo.cyborgInfo();
                break; 
                

                case "M2": 
                        classInfo.hackerInfo(); 
                break; 

                
                case "M3": 
                        classInfo.terminatorInfo();
                break; 
                
                
                case "M4": 
                        classInfo.lazerSwordsmanInfo();
                break; 

                
                case "M5": 
                        classInfo.rogueInfo();
                break; 

                
                case "M6": 
                        classInfo.mysticInfo();
                break; 


                case "M7": 
                        classInfo.reverendInfo();
                break; 
        }
} //end of printCrateInfo method 

/**
 * Makes the player into a cyborg
 * @param chosenClass   - The chosen class
 */
public void chooseCyborg(String chosenClass){
        playerStats = new Stats(200.0, 100.0, 1.00, 5.0, 7.0, 4.0, 5.0, 8.0, 100.0, 6.0,
                                        3.0, 1.0, 1.0, 1.0, 1.0, 1.0);
        Printer.printColor("Cyborg, a good choice.", "blue");
        chosenAttacks = CYBORG_ATTACKS;
        chosenAttacksCost = CYBORG_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
        
}

/**
 * Makes the player into a hacker
 * @param chosenClass   - The chosen class
 */
public void chooseHacker(String chosenClass){
        playerStats = new Stats(250.0, 80.0, 0.75, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0,
                                        1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
        Printer.printColor("Hacker, a good choice.", "green");
        chosenAttacks = HACKER_ATTACKS;
        chosenAttacksCost = HACKER_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
}

/**
 * Makes the player into a terminator
 * @param chosenClass   - The chosen class
 */
public void chooseTerminator(String chosenClass){
        playerStats = new Stats(200.0, 90.0, 0.8, 4, 8.0, 0.0, 7.0, 10.0, 200.0, 9.0, 3.0, 1.0, 1.0, 1.0, 1.0, 1.0);

        Printer.printColor("Terminator, a good choice.", "red");
        chosenAttacks = TERMINATOR_ATTACKS;
        chosenAttacksCost = TERMINATOR_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
}

/**
 * Makes the player into a lazer swordsman
 * @param chosenClass   - The chosen class
 */
public void chooseLazerSwordsman(String chosenClass){
        playerStats = new Stats(200.0, 130.0, 1.25, 5.4, 4.0, 4.0, 5.0, 7.0, 100.0, 4.0, 4.0, 1.0, 1.0, 1.0, 1.0, 1.0);

        Printer.printColor("Lazer Swordsman, a good choice.", "cyan");
        chosenAttacks = SWORDSMAN_ATTACKS;
        chosenAttacksCost = SWORDSMAN_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
}

/**
 * Makes the player into a rogue
 * @param chosenClass   - The chosen class
 */
public void chooseRogue(String chosenClass){
        playerStats = new Stats(125.0, 150.0, 2.0, 3.7, 10.0, 6.0, 2.0, 3.0, 130.0, 3.0, 3.0, 5.0, 1.0, 1.0, 1.0, 1.0);

        Printer.printColor("Rogue, a good choice.", "yellow");
        chosenAttacks = ROGUE_ATTACKS;
        chosenAttacksCost = ROGUE_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
        
}

/**
 * Makes the player into a mystic
 * @param chosenClass   - The chosen class
 */
public void chooseMystic(String chosenClass){
        playerStats = new Stats(175.0, 200.0, 1.0, 5.0, 1.0, 10.0, 4.0, 5.0, 150.0, 3.0, 5.0, 1.0, 1.0, 1.0, 1.0, 1.0);

        Printer.printColor("Mystic, a good choice.", "purple");
        chosenAttacks = MYSTIC_ATTACKS;
        chosenAttacksCost = MYSTIC_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
}

/**
 * Makes the player into a reverend
 * @param chosenClass   - The chosen class
 */
public void chooseReverend(String chosenClass){
        playerStats = new Stats(150, 250, 1.25, 3.0, 0.0, 6.0, 4.0, 6.0, 200.0, 1.0, 6.0, 0.0, 5.0, 0.0, 0.0, 1.0);

        Printer.printColor("Reverend, a good choice.", "red");
        chosenAttacks = REVEREND_ATTACKS;
        chosenAttacksCost = REVEREND_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
        
}

//returns information about the chosenClass
public String getChosenClass(){return chosenClass;}

//returns information about the name
public String getPlayerName() {return playerName;}

//returns information about the attacks        
public String[] getCyborgAttacks(){return CYBORG_ATTACKS;}

//returns information about the attacks
public String[] getHackerAttacks(){return HACKER_ATTACKS;}

//returns information about the attacks
public String[] getTerminatorAttacks(){return TERMINATOR_ATTACKS;}

//returns information about the attacks
public String[] getReverendAttacks(){return REVEREND_ATTACKS;}

//returns information about the attacks
public String[] getMysticAttacks(){return MYSTIC_ATTACKS;}

//returns information about the attacks
public String[] getRogueAttacks(){return ROGUE_ATTACKS;}

//returns information about the attacks
public String[] getSwordsmanAttacks(){return SWORDSMAN_ATTACKS;}

}
