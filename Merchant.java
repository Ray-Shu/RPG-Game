import java.util.Arrays;

public class Merchant {
    private int[] priceOfItem;
    private String[] itemsForSale;
    private String shopName;
    private String greeting;
    private String farewell;
    private String errorMessage;
    private String[] thingsToDo;

    Merchant(String[] itemsForSale, int[] priceOfItem, String shopName, String[] thingsToDo, String greeting, String farewell, String errorMessage) {
        this.itemsForSale = itemsForSale;
        this.priceOfItem = priceOfItem;
        this.shopName = shopName;
        this.greeting = greeting;
        this.farewell = farewell;
        this.thingsToDo = thingsToDo;
        this.errorMessage = errorMessage;
    }

    public void shop() {
        System.out.println("-----------------------------------------------------------");
        Printer.print(greeting);
        Printer.print("What would you like to do: "+ Arrays.toString(thingsToDo));
        int responseBack = ErrorChecker.compareArrayOfStrings(thingsToDo, errorMessage);
        
        switch (responseBack) {
            case 1: //buy
                System.out.println("Items for sale: ");
                for (int i = 0; i < itemsForSale.length; i++) {
                    System.out.println(itemsForSale[i]+ " for " + priceOfItem[i] + " grams of gold");
                }
                
                break;
            case 2:
        
            default:
                break;
        }
        
        
    }
}
