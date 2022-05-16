package PlayerInformation;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import Tools.*;

public class Player {
        private String playerClass; 
        private Stats playerStats;
        private String chosenAttacks[];
        private int chosenAttacksCost[];
        private String playerName, chosenClass;
        private Bank bankAccount; 
        private int playerLevel;

        public Player(Bank bankAccount, String name, String[] chosenAttacks, int[] chosenAttacksCost, String nameOfClass) {

                this.bankAccount = bankAccount;
                playerName = name;
                this.chosenAttacks = chosenAttacks;
                this.chosenAttacksCost = chosenAttacksCost;
                chosenClass = nameOfClass;
                playerLevel = 1;
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