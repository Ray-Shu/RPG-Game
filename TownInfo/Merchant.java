package TownInfo;

import java.util.Arrays;
import java.util.Scanner;
import PlayerInformation.*;
import Tools.*;

public class Merchant {
    public double[] priceOfItem;
    public String[] itemsForSale, thingsToDo;
    public String shopName, greeting, farewell, errorMessage, color;
    private Town town;
    public Bank playerAccount;
    private Scanner scan = new Scanner(System.in);
	private Stats playerStats;
	private Player player;

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
    Merchant(Player player, Stats playerStats, Bank playerAccount, Town town, String[] itemsForSale, double[] priceOfItem2, String shopName, String[] thingsToDo, String greeting, String farewell, String errorMessage, String color) {
        
        this.player = player;
        this.playerStats = playerStats;
        this.itemsForSale = itemsForSale;
        this.priceOfItem = priceOfItem2;
        this.shopName = shopName;
        this.greeting = greeting;
        this.farewell = farewell;
        this.thingsToDo = thingsToDo;
        this.errorMessage = errorMessage;
        this.color = color;
        this.playerAccount = playerAccount;

    }

    /**
     * This method runs when they walk into the store. 
     */
    public void shop() {
        //Greets them and asks what they want to do. 
        System.out.println("-----------------------------------------------------------");
        Printer.printColor(greeting, color);
        Printer.printColor("What would you like to do: "+ Arrays.toString(thingsToDo), color);
        String responseBack = ErrorChecker.compareArrayOfStrings(thingsToDo, errorMessage, "red").toLowerCase();

        //based on the possible things they can do in that store and the things listed here, we run commands. 
        // ? better than having a million classes cus reusability?
        switch (responseBack) {
            // * All things
            case "leave":
                town.characterEnteringTown();
                break;

            // * SHOP THINGS

            // This will list out the items we will sell and ask us to buy one or get out. 
            case "buy":
                System.out.println("Items for sale: ");
                for (int i = 0; i < itemsForSale.length; i++) {
                    System.out.println(itemsForSale[i]+ " for " + priceOfItem[i] + " grams of gold");
                }

                String whatTheyWant = ErrorChecker.compareArrayOfStrings(itemsForSale, errorMessage, color);

                for (int i = 0; i < itemsForSale.length; i++) {

                    if(itemsForSale[i].equals(whatTheyWant)){

                        if(playerAccount.doesPlayerHaveEnoughMoney(priceOfItem[i])){
                            playerAccount.withdraw(priceOfItem[i]);
                            //inventory.addItem(itemsForSale[i]);
                            Printer.printColor("Thank you for your money! Your remaining balance is " + playerAccount.balance, color);
                        }
                        
                    }
                }
                break;

            // This will allow us to sell some of the items in our inventory. 
            case "sell":
                Printer.printColor("Here are your items and how much they are worth: ",color);
                break;

            //this will be for when we can upgrade weapons
            case "upgrade":
                break;

            //this will let us view our special talents. 
            case "view talents":
                Printer.printColor("Here are your talents", color);
                break;

            //Will allow us to be healed. 
            //? Maybe you can buy into health insurance to get reduced healing rates
            case "get healing":
                Printer.printColor("Healing you: ", color);
                playerStats.hospitalHeal();
                break;

            //shows bank account balance
            case "view balance":
                Printer.printColor("Here is your current balance: " + playerAccount.getBalance(), color);
                System.out.println("Please enter any character to continue: ");
                scan.next();
                shop();
                break;

            //allows you to withdraw
            case "withdraw": 
                double amountForWithdraw = ErrorChecker.doubleWithMinAndMax(0.0,playerAccount.getBalance() + 1, "Please enter much would you like to withdraw: ", color);
                playerAccount.withdraw(amountForWithdraw);
                Printer.printColor("Thank you! Your current balance is "+  playerAccount.getBalance(), color);
                shop();
                break;
                
        }        
    }
    
    

    public String getShopName() {
        return shopName;
    }

}

