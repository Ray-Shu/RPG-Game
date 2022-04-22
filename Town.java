import java.util.ArrayList;

public class Town {
    
    public static int floorLvl;
    public static String townName;
    //Store templates for the stores


    private static String[] shopForSale = {"car", "shoe", "pizza", "macaroni"};
    private static int[] shopPrices = {100, 10, 99, 88};
    private static String shopName = "Bobs Random Things";
    private static String[] thingsAtShop = {"buy", "sell", "leave"};
    private static String shopGreeting = "Welcome to Bobs Random Thing! We sell lots of random things.";
    private static String shopFarewell = "Thank you for shopping at Bobs random things";
    private static String shopErrorMessage = "Sorry didn't hear you there could you repeat that?";
    
    private static String[] hospitalForSale = new String[5];
    private static int[] hospitalPrices = new int[5];
    private static String hospitalName = "The Cool Hospital";
    private static String[] thingsAtHospital = {"get healing", "sell"};
    private static String hospitalGreeting = "Welcome to the hospital!";
    private static String hospitalFarewell = "Thank you for coming to the hospital I hope we enjoyed your stay. ";
    private static String hospitalErrorMessage = "Please speak clearly";


    Merchant shop = new Merchant(this, shopForSale, shopPrices, shopName, thingsAtShop, shopGreeting, shopFarewell, shopErrorMessage, "green");
    Merchant hospital = new Merchant(this,hospitalForSale, hospitalPrices, hospitalName, thingsAtHospital, hospitalGreeting, hospitalFarewell, hospitalErrorMessage, "purple");
    Merchant allThingsInTown[] = {shop, hospital};
    ArrayList<String> namesOfThingsInTown = new ArrayList<String>();

    Town(String townName, int floorLvl) {
        this.townName = townName;
        this.floorLvl = floorLvl;
        //makes a list of all the names of shops in town. 
        for (int i = 0; i < allThingsInTown.length; i++) {
            namesOfThingsInTown.add(i,allThingsInTown[i].shopName);
        }
    }

    public void characterEnteringTown(){

        //welcomes the character to town and shows them what we have here
        Printer.printColor("Welcome to " + townName + " traveler! Here is a brochure with all you can do here! \n", "blue");
        for (Merchant merchant : allThingsInTown) {
            Printer.printColor(merchant.shopName, "blue");
        }
        System.out.println("\n" + "Where do you want to go?");

        //gets them to enter a shop name as to where they want to go, and then runs that shop. 
        String whereMerchantWantsToGO = ErrorChecker.compareArrayOfStrings(namesOfThingsInTown.toArray(new String[namesOfThingsInTown.size()]),
                 "Sorry could you repeat that?", "blue");
        for (Merchant merchant : allThingsInTown) {
            if(whereMerchantWantsToGO == merchant.shopName){
                merchant.shop();
            }
        }
    }

    public void runHospital() {
        hospital.shop();
    }
    public void runShop() {
        shop.shop();
    }
}
