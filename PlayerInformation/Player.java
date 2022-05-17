package PlayerInformation;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import Tools.*;
import TownInfo.*;

public class Player {
        private String playerClass; 
        private Stats playerStats;
        private String chosenAttacks[];
        private int chosenAttacksCost[];
        private String playerName, chosenClass;
        private Bank bankAccount; 
        private int playerLevel;
        private TownMaker townMaker;
        private PlayerCreation creator;

        public Player(Stats stats, Bank bankAccount, String name, String[] chosenAttacks, int[] chosenAttacksCost, String nameOfClass, PlayerCreation creator) {

                this.bankAccount = bankAccount;
                playerName = name;
                this.chosenAttacks = chosenAttacks;
                this.chosenAttacksCost = chosenAttacksCost;
                chosenClass = nameOfClass;
                playerLevel = 1;
                this.creator = creator;
                playerStats = stats;
        }

        public void makeTownMaker(TownMaker townMaker){
                this.townMaker = townMaker;
        }
        //*End of testing combat stuff

        /**
         * ALL INVENTORY RELATED STUFF
         * Reference to this when showing or adding to inventory
         */

        Inventory playerInventory = new Inventory();
        public void createInventory(){
                
                playerInventory.createInventory(playerStats); 
        }

        public void showInventory(){
                playerInventory.showInventory(); 
                
        }

        public void addToInventory(ArrayList<String> itemsToAdd){
                playerInventory.addInventory(itemsToAdd);
        }


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

        public void levelUp(){
                playerLevel++;
                Printer.printColor("---------------------------------------------------------", "yellow");
                Printer.printColor("██      ███████ ██    ██ ███████ ██          ██    ██ ██████  ██ \n"
                                +"██      ██      ██    ██ ██      ██          ██    ██ ██   ██ ██ \n"
                               + "██      █████   ██    ██ █████   ██          ██    ██ ██████  ██ \n"
                                +"██      ██       ██  ██  ██      ██          ██    ██ ██         \n"
                                +"███████ ███████   ████   ███████ ███████      ██████  ██      ██ \n", "yellow");
                Printer.printColor("Congratulations! You have reached level " +playerLevel+"!", "yellow");
                // Printer.printColor("", color);
                Printer.printColor("---------------------------------------------------------", "yellow");
                playerStats.statsUp(1.1);
        }

        //checks if the user is ready for a level up
        public void checkXP() {
                if(playerStats.getXP() / playerStats.getXP_TO_LVL_UP() >= 1){
                        playerStats.addXP(-playerStats.getXP_TO_LVL_UP());
                        levelUp();
                        checkXP();
                }
        }
        


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