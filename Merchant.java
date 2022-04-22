import java.util.Arrays;
import java.util.Scanner;

public class Merchant {
    public int[] priceOfItem;
    public String[] itemsForSale;
    public String shopName;
    public String greeting;
    public String farewell;
    public String errorMessage;
    public String[] thingsToDo;
    public String color;
    private Town town;
    private Bank playerAccount;
    private Scanner scan = new Scanner(System.in);

    /**
     * This gets all the data we will need for the merchant, including what they might sell, what they say, and what they do. 
     * @param itemsForSale
     * @param priceOfItem
     * @param shopName
     * @param thingsToDo
     * @param greeting
     * @param farewell
     * @param errorMessage
     * @param color
     */
    Merchant(Bank playerAccount, Town town, String[] itemsForSale, int[] priceOfItem, String shopName, String[] thingsToDo, String greeting, String farewell, String errorMessage, String color) {
        this.itemsForSale = itemsForSale;
        this.priceOfItem = priceOfItem;
        this.shopName = shopName;
        this.greeting = greeting;
        this.farewell = farewell;
        this.thingsToDo = thingsToDo;
        this.errorMessage = errorMessage;
        this.color = color;
        this.town = town;
        this.playerAccount = playerAccount;
    }

    public void shop() {
        System.out.println("-----------------------------------------------------------");
        Printer.printColor(greeting, color);
        Printer.printColor("What would you like to do: "+ Arrays.toString(thingsToDo), color);
        String responseBack = ErrorChecker.compareArrayOfStrings(thingsToDo, errorMessage, "red").toLowerCase();
        
        switch (responseBack) {
            case "buy":
                System.out.println("Items for sale: ");
                for (int i = 0; i < itemsForSale.length; i++) {
                    System.out.println(itemsForSale[i]+ " for " + priceOfItem[i] + " grams of gold");
                }
                break;

            case "sell":
                Printer.printColor("Here are your items and how much they are worth: ",color);
                break;
            case "upgrade":
                break;
            case "view talents":
                Printer.printColor("Here are your talents", color);
                break;
            case "get healing":
                Printer.printColor("Healing you: ", color);
                break;
            case "leave":
                town.characterEnteringTown();
                break;
            case "view balance":
                Printer.printColor("Here is your current balance: ", color);
                System.out.println("Please enter any character to continue: ");
                scan.next();
                shop();
                break;
            case "withdraw": 
                double amountForWithdraw = ErrorChecker.doubleWithMinAndMax(0.0,playerAccount.getBalance(), "Please enter much would you like to withdraw: ", color);
                playerAccount.withdraw(amountForWithdraw);
                break;
                
        }
        
        
        
    }
}
