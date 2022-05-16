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

        public Stats getPlayerStats() {return playerStats;}
        public Bank getBank(){return bankAccount;}
        public String getName(){return playerName;}
        public String getPlayerClass(){return chosenClass;}
        public String[] getChosenAttacks(){return chosenAttacks;}
        public int[] getAttacksCosts (){return chosenAttacksCost;}
        public int getLevel(){return playerLevel;}
        public Town getCurrentTown() {return townMaker.getCurrentTown();}
        public PlayerCreation getCreator(){return creator;}
        public void addLevel(){playerLevel++;}

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