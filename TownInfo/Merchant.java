package TownInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import PlayerInformation.*;
import Tools.*;

public class Merchant {
    public double[] priceOfItem, armourPrice;
    public String[] itemsForSale, thingsToDo, armour;
    public String shopName, greeting, farewell, errorMessage, color;
   
    public Town town;
    public Bank playerAccount;
    public Scanner scan = new Scanner(System.in);
	public Stats playerStats;
	public Player mainPlayer;

    /**
     * This gets all the data we will need for the merchant, including what they might sell, what they say, and what they do. 
     * * Basically creates the shop. 
     * @param itemsForSale this is an array of all the items for sale
     * @param priceOfItem2 this is an array which holds the pricing of all the items listed above. 
     * @param shopName this is the name of the business
     * @param thingsToDo this is the things u can do within a building, for example, you can buy, sell, or leave in a shop
     * @param greeting this is what they say at the start
     * @param farewell this is what they say as you leave
     * @param errorMessage this is what they say to you if you say the wrong thing. 
     * @param color this is the color of the text in the store. 
     */
    public Merchant(Player mainPlayer,  Town town, String[] itemsForSale, double[] priceOfItem, String shopName, String[] thingsToDo, String greeting, String farewell, String errorMessage, String color) {
        
        this.mainPlayer = mainPlayer;
        this.playerStats = mainPlayer.getPlayerStats();
        this.itemsForSale = itemsForSale;
        this.priceOfItem = priceOfItem;
        this.shopName = shopName;
        this.greeting = greeting;
        this.farewell = farewell;
        this.thingsToDo = thingsToDo;
        this.errorMessage = errorMessage;
        this.color = color;
        this.playerAccount = mainPlayer.getBank();

    }

    public void addArmour(String[] armour, double[] armourPrice) {
        this.armour = armour; 
        this.armourPrice = armourPrice; 
    }

    /**
     * This method runs when they walk into the store. 
     */
    public void shop(boolean hasGreeting) {
        //Greets them and asks what they want to do. 
        System.out.println("-----------------------------------------------------------");
        if(hasGreeting){
        Printer.printColor(greeting, color);
        }
        
        Printer.printColor("What would you like to do: "+ Arrays.toString(thingsToDo) + "       |       Your balance: " + playerAccount.getBalance(), color);
        String responseBack = ErrorChecker.compareArrayOfStrings(thingsToDo, errorMessage, "red").toLowerCase();

        //based on the possible things they can do in that store and the things listed here, we run commands. 
        
        switch (responseBack.toLowerCase()) {
            // * All things
            case "leave":
                town.characterEnteringTown(true);
                break;

            // * SHOP THINGS

            // This will list out the items we will sell and ask us to buy one or get out. 
            case "show common goods":
                showCommonGoods();
                break;

            // Buys armour and automatically equips the armour 
            case "show armour": 
                buyArmour(); 
                break;

            // This will allow us to sell some of the items in our inventory. 
            case "sell":
                
                shop(false);
                break;

            //Will allow us to be healed. 
            //? Maybe you can buy into health insurance to get reduced healing rates
            case "get healing":
                Printer.printColor("Healing you: ", color);
                playerStats.hospitalHeal();
                playerStats.rest();
                shop(false);
                break;

            //shows bank account balance
            case "view balance":
                Printer.printColor("Here is your current balance: " + playerAccount.getBalance(), color);
                System.out.println("Please enter any character to continue: ");
                scan.next();
                shop(false);
                break;

            //allows you to withdraw
            case "withdraw": 
                double amountForWithdraw = ErrorChecker.doubleWithMinAndMax(0.0,playerAccount.getBalance() + 1, "Please enter much would you like to withdraw: ", color);
                playerAccount.withdraw(amountForWithdraw);
                Printer.printColor("Thank you! Your current balance is "+  playerAccount.getBalance(), color);
                shop(false);
                break;

        }       
    }
    
    
    /**
     * This method is run after player dies to give them a nice wakeup. After a death, they will get sent to the hospital and healed. 
     */
   public void playerDiedWakeup(){

        Printer.printColor("You wake up in the hosptal bed feeling terrible pain.\nYou need to say something to get the attention of a nurse", "cyan");
        scan.next();

        Printer.printItalizcizedColor("Don't strain yourself! You're very lucky that our healer got to you when she did.\n You need to rest\n", "cyan");
        playerStats.rest();
        playerStats.hospitalHeal();

        Printer.printColor("You go to sleep, and wake up three days later feeling refreshed...", "cyan");
        Printer.quickBreak(1000);
        shop(false);

    }   

    //returns the shopname
    public String getShopName() {return shopName;}


    //displays the goods of the specific floors merchant 
    private void showCommonGoods() {
        int[] intOptions = IntStream.rangeClosed(1, itemsForSale.length).toArray();

        String[] convertToStringOptions = Arrays.stream(intOptions)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        String[] exit = {"[e] Exit"}; 

        String[] option = Stream.concat(Arrays.stream(convertToStringOptions), Arrays.stream(exit))
                .toArray(String[]::new);

        Printer.printColor("Items for Sale: ", color);
        System.out.println();

        for (int i = 0; i < itemsForSale.length; i++) {
            Printer.printColor("[" + (i+1) + "] " + itemsForSale[i] + " for " + priceOfItem[i] + " Fusion Coins", color);
        } 
        Printer.printColor("[e] Exit", color);

        String choose = ErrorChecker.compareArrayOfStrings(option, errorMessage, color);

        for(int i = 0; i < itemsForSale.length; i++) {
            if (choose.toLowerCase().equals(option[i])) {
                if(playerAccount.doesPlayerHaveEnoughMoney(priceOfItem[i])){
                    playerAccount.withdraw(priceOfItem[i]);
                    //adds the item to inventory 
                    ArrayList<String> addItem = new ArrayList<String>(); 
                    addItem.add(itemsForSale[i]); 
                    mainPlayer.addToInventory(addItem);
                    Printer.printColor("Thank you for your purchase! Your remaining balance is " + playerAccount.balance, color);
                } else {
                    Printer.printColor("Sorry, it looks like you don't have enough money.", color);
                }
            }
        }

        shop(false); 

    }

    private void buyArmour(){
        int[] intOptions = IntStream.rangeClosed(1, armour.length).toArray();

        String[] convertToStringOptions = Arrays.stream(intOptions)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        String[] exit = { "[e] Exit" };

        String[] option = Stream.concat(Arrays.stream(convertToStringOptions), Arrays.stream(exit))
                .toArray(String[]::new);

        Printer.printColor("Items for Sale: ", color);
        
        for (int i = 0; i < armour.length; i++) {
                Printer.printColor("[" + (i + 1) + "] " + armour[i] + " for " + armourPrice[i] + " Fusion Coins", color);
        }
        Printer.printColor("[e] Exit", color);

        String choose = ErrorChecker.compareArrayOfStrings(option, errorMessage, color);

        for (int i = 0; i < armour.length; i++) {
            if (choose.toLowerCase().equals(option[i])) {
                if (playerAccount.doesPlayerHaveEnoughMoney(armourPrice[i])) {
                    playerAccount.withdraw(armourPrice[i]);
                    Armours equipArmour = new Armours(mainPlayer); 
                    equipArmour.equipArmour(armour[i]);
                    Printer.printColor("You have obtained: " + Arrays.toString(armour) + ". Equipping now...", "purple");
                    Printer.printColor(
                            "Thank you for your purchase! Your remaining balance is " + playerAccount.balance, color);
                } else {
                    Printer.printColor("Sorry, it looks like you don't have enough money.", color);
                }
            }
        }
        shop(false); 
    }
}
