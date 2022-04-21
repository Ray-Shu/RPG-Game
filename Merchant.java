import java.util.Arrays;

public class Merchant {
    private int[] priceOfItem;
    private String[] itemsForSale;
    private String shopName;
    private String greeting;
    private String farewell;
    private String errorMessage;
    private String[] thingsToDo;
    private String color;

    /**
     * This gets all the data we will need for the merchant, including what they might sell, what they say, and what they do. 
     * @param itemsForSale this is a list of the items that the shop might sell
     * @param priceOfItem this is a list of corresponding prices to those items
     * @param shopName this is the shops/business's name
     * @param thingsToDo this is the things that you can do at the store, such as buy, sell, heal, enchant, drink ect. 
     * @param greeting this is what they say once they enter the shop
     * @param farewell this is what they say when they leave the shop
     * @param errorMessage this is what they say when the user types the wrong thing
     * @param color this is the color of the text. 
     */
    Merchant(String[] itemsForSale, int[] priceOfItem, String shopName, String[] thingsToDo, String greeting, String farewell, String errorMessage, String color) {
        this.itemsForSale = itemsForSale;
        this.priceOfItem = priceOfItem;
        this.shopName = shopName;
        this.greeting = greeting;
        this.farewell = farewell;
        this.thingsToDo = thingsToDo;
        this.errorMessage = errorMessage;
        this.color = color;
    }

    /**
     * This runs when they enter the shop. It asks them what they want to do in the store, and then runs it. 
     */
    public void shop() {
        System.out.println("-----------------------------------------------------------");
        Printer.printColor(greeting, color);
        Printer.printColor("What would you like to do: "+ Arrays.toString(thingsToDo), color);
        //makes the user enter one of the things to do at that store. 
        String responseBack = ErrorChecker.compareArrayOfStrings(thingsToDo, errorMessage).toLowerCase();
        
        //out of the possible things that can happen in the store, one will be chosen by the user and it will run that. 
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
        }
    }
}
