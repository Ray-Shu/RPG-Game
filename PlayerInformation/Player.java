package PlayerInformation;
import java.util.ArrayList;
// import java.util.jar.Attributes.Name;

import Tools.*;
import TownInfo.*;

public class Player {
        private Armours armour;
        private String playerClass; 
        private Stats playerStats;
        private String chosenAttacks[];
        private int chosenAttacksCost[];
        private String playerName, chosenClass;
        private Bank bankAccount; 
        private int playerLevel = 1;
        private int maxTownLevel;
        private TownMaker townMaker;
        private PlayerCreation creator;
        private Inventory playerInventory; 

        public Player(Stats stats, Bank bankAccount, String name, String[] chosenAttacks, int[] chosenAttacksCost, String nameOfClass, PlayerCreation creator) {

                this.bankAccount = bankAccount;
                playerName = name;
                this.chosenAttacks = chosenAttacks;
                this.chosenAttacksCost = chosenAttacksCost;
                chosenClass = nameOfClass;
                playerLevel = 1;
                this.creator = creator;
                playerStats = stats;
                this.armour = new Armours(this);
                this.playerInventory = new Inventory(stats);
        }

        public void makeTownMaker(TownMaker townMaker){
                this.townMaker = townMaker;
        }
        //*End of testing combat stuff

        /**
         * *ALL INVENTORY RELATED STUFF
         * Reference to this when showing or adding to inventory
         */
                
        public Inventory getInventory() {return playerInventory;}
        
        public void showInventory(){
                playerInventory.showInventory();
        }

        public void addToInventory(ArrayList<String> itemsToAdd){
                playerInventory.addInventory(itemsToAdd);
        }

        //adds the equipment to inventory from player class
        public void addEquippedArmourToInventory(String headPiece, String chestPiece, String legPiece, String boots) {
                playerInventory.playerInventoryAddEquippedArmour(headPiece, chestPiece, legPiece, boots);
        }

        //returns info about players armour
        public Armours getArmour(){return armour;} 
        
        public void updateArmour() {armour.updateArmour();}

        //returns info about the townmaker
        public TownMaker getTownMaker(){return townMaker;}

        //returns information about the player.
        public Stats getPlayerStats() {return playerStats;}
        
        //returns information about the player.
        public Bank getBank(){return bankAccount;}
        
        //returns information about the player.
        public String getName(){return playerName;}
        
        //returns information about the player.
        public String getPlayerClass(){return chosenClass;}
        
        //returns information about the player.
        public String[] getChosenAttacks(){return chosenAttacks;}
        
        //returns information about the player.
        public int[] getAttacksCosts (){return chosenAttacksCost;}
        
        //returns information about the player.
        public int getLevel(){return playerLevel;}
        
        //returns information about the player.
        public Town getCurrentTown() {return townMaker.getCurrentTown();}
        
        //returns information about the player.
        public PlayerCreation getCreator(){return creator;}

        //increases the level of the player, tells them they leveled up, and how much they increased by. 
        public void levelUp(){
                playerLevel++;
                playerStats.hospitalHeal();
                playerStats.rest();
                System.out.println("\u001B[33m-----------------------------------------------------------\u001B[33m");
                System.out.println("\u001B[32m" + 
                                 "██      ███████ ██    ██ ███████ ██          ██    ██ ██████  ██ \n"
                                +"██      ██      ██    ██ ██      ██          ██    ██ ██   ██ ██ \n"
                               + "██      █████   ██    ██ █████   ██          ██    ██ ██████  ██ \n"
                                +"██      ██       ██  ██  ██      ██          ██    ██ ██         \n"
                                +"███████ ███████   ████   ███████ ███████      ██████  ██      ██ \n \u001B[32m");
                Printer.printColor("Congratulations! You have reached level " +playerLevel+"! \nYou're stats have increased, you have been healed and you have rested.", "yellow");
                //todo: Make this print out stat increases
                System.out.println("\u001B[33m-----------------------------------------------------------\u001B[33m");
                playerStats.statsUp(1.1);
                armour.updateArmour();
        }

        /**
        * Checks if the user is ready for a level up, and adds a bit of xp. 
        * @param howMuchXPGained        - the amount of xp gained. 
        */
        public void checkXP(int howMuchXPGained) {
                playerStats.addXP(howMuchXPGained);

                //if the xp is greater than the required xp to level up, we will level up and check if we can level up again. 
                if(playerStats.getXP() >= playerStats.getXP_TO_LVL_UP()){
                        playerStats.addXP(-playerStats.getXP_TO_LVL_UP());
                        levelUp();
                        checkXP(0);
                }

        }
        

        /**
         * Runs when thhe player dies. Prints out a cool message.
         */
        public static void playerDied() {
                System.out.println("\u001B[31m" + 
                        "-----------------------------------------------------------\n"+
                        " ▓██   ██▓ ▒█████   █    ██    ▓█████▄  ██▓▓█████ ▓█████▄ \n" + 
                        " ▒██  ██▒▒██▒  ██▒ ██  ▓██▒   ▒██▀ ██▌▓██▒▓█   ▀ ▒██▀ ██▌\n"+
                        " ▒██ ██░▒██░  ██▒▓██  ▒██░   ░██   █▌▒██▒▒███   ░██   █▌\n"+
                        " ░ ▐██▓░▒██   ██░▓▓█  ░██░   ░▓█▄   ▌░██░▒▓█  ▄ ░▓█▄   ▌\n"+
                        " ░ ██▒▓░░ ████▓▒░▒▒█████▓    ░▒████▓ ░██░░▒████▒░▒████▓ \n"+
                        " ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒     ▒▒▓  ▒ ░▓  ░░ ▒░ ░ ▒▒▓  ▒ \n"+
                        "▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░     ░ ▒  ▒  ▒ ░ ░ ░  ░ ░ ▒  ▒ \n"+
                        "▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░     ░ ░  ░  ▒ ░   ░    ░ ░  ░ \n"+
                        "░ ░         ░ ░     ░           ░     ░     ░  ░   ░    \n"+
                        "░ ░                           ░                  ░\n"+
                        "-----------------------------------------------------------"+
                        "\u001B[31m");
        }



}