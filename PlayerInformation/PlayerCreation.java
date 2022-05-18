package PlayerInformation;
import Tools.*;
import TownInfo.TownMaker;


public class  PlayerCreation {
    private String playerClass; 
    private Stats playerStats;
    private String chosenAttacks[];
    private int chosenAttacksCost[];
    private String playerName;
    private String chosenClass; 

    private final String CLASSES[] = { "cyborg", "hacker", "terminator", "laser swordsman", "rogue", "mystic", "reverend" };

    public final String CYBORG_ATTACKS[] = {"Laser Barrage", "Charged Shot", "Cyber Shield", "Overload"};
    public final int CYBORG_ATTACK_COSTS[] = {0,15,5,20};
    public final String CYBORG_ATTACK_INFO[] = {"Laser Barrage unleashes a flury of low damage laser shots on the opponents", 
            "The Charged Shot unleashes a powerful blast capable dealing major damage", 
            "The Cyber Shield increases defense for the next 3 turns", 
            "Overload greatly increases attack for the next 3 turns"};

    private final String HACKER_ATTACKS[] = {"Virus Attack", "Stolen Missile", "Watchful Vulture", "In The System"};
    private final int HACKER_ATTACK_COSTS[] = {0,20,5,10};
    private final String HACKER_ATTACKS_INFO[] = {"The hacker uses a virus to destroy enemy systems, dealing strong damage!",
            "With the Stolen Missile ability, the hacker seizes a missile from the government and tries to use it to destroy their enemies",
            "The hacker's Watchful Vulture ability uses realtime satellite imagery to locate enemies and ensure hits for the next 3 turns",
            "The hacker gets \"In The System\" with their final ability to disable their enemy robots for 2 turns"};

    private final String TERMINATOR_ATTACKS[] = {"Machine Gun Fury\t\t\t", "First Impact Fists\t\t\t", "Deceiving Blast of Cybernetic Proportions", "Hunker Down\t\t\t\t"};
    private final int TERMINATOR_ATTACK_COSTS[] = {0,5,10,10};
    private final String TERMINATOR_ATTACKS_INFO[] = {"The Terminator unleashes their Machine gun to deal major damage to opponents",
            "The Terminator gets a heavily impactful strike on their enemy. ",
            "The Terminators special move surprises enemies and blinding them for 2 turns. ",
            "The Hunker Down ability increases ATK, but removes chance of dodging an attack. "};

    private final String SWORDSMAN_ATTACKS[] = {"Swift Thrust of the Sword", "Fatal Eruption Of Bullets", "Lightning Clone Strike", "Meditation\t\t"};
    private final int SWORDSMAN_ATTACK_COSTS[] = {0,13,25,0};
    private final String SWORDSMAN_ATTACKS_INFO[] = {"The Swordsman outpaces their enemy to deal a powerful blow. ",
            "The Swordsman uses a gun to eliminate their enemies. ",
            "The Swordsman's moves at supersonic speeds to summon clones which all attack the enemy. ",
            "The Swordsman Sleeps"};
    
    private final String ROGUE_ATTACKS[] = {"Quick Blast\t\t", "Death Strike\t", "Secret Mushroom Strike", "Forbidden Smoke\t"};
    private final int ROGUE_ATTACK_COSTS[] = {0,12,10,5};
    private final String ROGUE_ATTACKS_INFO[] = {"The agile Rogue quickly blasts the enemy with explosives before they get to react. ",
            "The Rogue Sneaks up on their opponent and strikes them down. ",
            "The Rogue poisons their opponent",
            "The Rogue uses smoke to deceive their enemy. "};
    
    private final String MYSTIC_ATTACKS[] = {"Dragon Shatter", "Simple Strike", "Frost Eruption" , "Burning Prison"};
    private final int MYSTIC_ATTACK_COSTS[] = {20,0,10,5};
    private final String MYSTIC_ATTACKS_INFO[] = {"Summons a dragon who strikes their opponent, dealing major damage. ",
            "The attack uses a small blast of mana to damage their opponent. ",
            "Frost Eruption slows the enemies and does a little damage. ",
            "The Mystic traps their enemy in a burning prison!"}; 

    public final String REVEREND_ATTACKS[] = {"Holy Flash of Radiant Light\t", "Divine Smite\t\t", "Holy Healing\t\t", "Prayer\t\t\t"};
    public final int REVEREND_ATTACK_COSTS[] = {0,20,10,10};
    public final String REVEREND_ATTACKS_INFO[] = {"The Reverend manipulates the divine light to blind the enemy and deal major damage!",
            "The divine smite summons lightning to stun enemies and deal major damage. ",
            "Holy healing heals the player",
            "The prayer increases attack and speed. "};
    
    public final String CHOOSE_CRATE_AND_CRATE_INFO[] = {"1", "2", "3", "4", "5", "6", "7", "M1", "M2", "M3", "M4", "M5", "M6", "M7"};
    public Bank bankAccount;
    public TownMaker townMaker;

    public PlayerCreation(Bank bankAccount, String name){

        playerName = name;
        this.bankAccount = bankAccount;
    }
    public Player testPlayer(){
        playerStats = new Stats(150, 250, 1.25, 3.0, 0.0, 6.0, 4.0, 6.0, 200.0, 1.0, 6.0, 0.0, 5.0, 0.0, 0.0, 1.0);
        return new Player(playerStats, bankAccount, playerName,REVEREND_ATTACKS,REVEREND_ATTACK_COSTS,"reverend",this);
    }

    public Player getPlayer(){
        return new Player(playerStats, bankAccount, playerName, chosenAttacks, chosenAttacksCost, chosenClass,this); 
    }


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

public void chooseCyborg(String chosenClass){
        playerStats = new Stats(200.0, 100.0, 1.00, 5.0, 7.0, 4.0, 5.0, 8.0, 100.0, 6.0,
                                        3.0, 1.0, 1.0, 1.0, 1.0, 1.0);
        Printer.printColor("Cyborg, a good choice.", "blue");
        chosenAttacks = CYBORG_ATTACKS;
        chosenAttacksCost = CYBORG_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
        
}

public void chooseHacker(String chosenClass){
        playerStats = new Stats(300.0, 80.0, 0.75, 3.0, 8.0, 1.0, 7.0, 10.0, 150.0, 8.0,
                                        1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
        Printer.printColor("Hacker, a good choice.", "green");
        chosenAttacks = HACKER_ATTACKS;
        chosenAttacksCost = HACKER_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
}

public void chooseTerminator(String chosenClass){
        playerStats = new Stats(300.0, 90.0, 0.8, 5.0, 8.0, 0.0, 7.0, 10.0, 200.0, 9.0, 3.0, 1.0, 1.0, 1.0, 1.0, 1.0);

        Printer.printColor("Terminator, a good choice.", "red");
        chosenAttacks = TERMINATOR_ATTACKS;
        chosenAttacksCost = TERMINATOR_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
}

public void chooseLazerSwordsman(String chosenClass){
        playerStats = new Stats(200.0, 130.0, 1.25, 8.0, 4.0, 4.0, 5.0, 7.0, 100.0, 4.0, 4.0, 1.0, 1.0, 1.0, 1.0, 1.0);

        Printer.printColor("Lazer Swordsman, a good choice.", "cyan");
        chosenAttacks = SWORDSMAN_ATTACKS;
        chosenAttacksCost = SWORDSMAN_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
}

public void chooseRogue(String chosenClass){
        playerStats = new Stats(125.0, 150.0, 2.0, 9.0, 10.0, 6.0, 2.0, 3.0, 130.0, 3.0, 3.0, 5.0, 1.0, 1.0, 1.0, 1.0);

        Printer.printColor("Rogue, a good choice.", "yellow");
        chosenAttacks = ROGUE_ATTACKS;
        chosenAttacksCost = ROGUE_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
        
}

public void chooseMystic(String chosenClass){
        playerStats = new Stats(175.0, 200.0, 1.0, 7.0, 1.0, 10.0, 4.0, 5.0, 150.0, 3.0, 5.0, 1.0, 1.0, 1.0, 1.0, 1.0);

        Printer.printColor("Mystic, a good choice.", "purple");
        chosenAttacks = MYSTIC_ATTACKS;
        chosenAttacksCost = MYSTIC_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
}

public void chooseReverend(String chosenClass){
        playerStats = new Stats(150, 250, 1.25, 3.0, 0.0, 6.0, 4.0, 6.0, 200.0, 1.0, 6.0, 0.0, 5.0, 0.0, 0.0, 1.0);

        Printer.printColor("Reverend, a good choice.", "red");
        chosenAttacks = REVEREND_ATTACKS;
        chosenAttacksCost = REVEREND_ATTACK_COSTS;
        this.chosenClass = chosenClass; 
        
}

public String getChosenClass(){return chosenClass;}
public String getPlayerName() {return playerName;}        
public String[] getCyborgAttacks(){return CYBORG_ATTACKS;}
public String[] getHackerAttacks(){return HACKER_ATTACKS;}
public String[] getTerminatorAttacks(){return TERMINATOR_ATTACKS;}
public String[] getReverendAttacks(){return REVEREND_ATTACKS;}
public String[] getMysticAttacks(){return MYSTIC_ATTACKS;}
public String[] getRogueAttacks(){return ROGUE_ATTACKS;}
public String[] getSwordsmanAttacks(){return SWORDSMAN_ATTACKS;}


}
