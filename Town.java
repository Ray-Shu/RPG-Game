import java.util.ArrayList;

public class Town {

    public static int floorLvl;
    public static String townName;
    // Store templates for the stores

    private static String[] shopForSale = { "car", "shoe", "pizza", "macaroni" };
    private static int[] shopPrices = { 100, 10, 99, 88 };
    private static String shopName = "Bobs Random Things";
    private static String[] thingsAtShop = { "buy", "sell", "leave" };
    private static String shopGreeting = "Welcome to Bobs Random Thing! We sell lots of random things.";
    private static String shopFarewell = "Thank you for shopping at Bobs random things";
    private static String shopErrorMessage = "Sorry didn't hear you there could you repeat that?";

    private static String[] hospitalForSale, bankforsale = new String[5];
    private static int[] hospitalPrices, bankPrices = new int[5];
    private static String hospitalName = "The Cool Hospital";
    private static String[] thingsAtHospital = { "get healing", "sell" };
    private static String hospitalGreeting = "Welcome to the hospital!";
    private static String hospitalFarewell = "Thank you for coming to the hospital I hope we enjoyed your stay. ";
    private static String hospitalErrorMessage = "Please speak clearly";
    private static Bank playerAccount;

    private static String bankName = "Golden Bank Of Reign";
    static String[] thingsAtBank = { "withdraw", "view balance", "leave" };
    static String bankGreeting = "Welcome to the bank!";
    static String bankFarewell = "Thank you for coming to the bank";
    private static String bankErrorMessage = "Please speak clearly.";

    Merchant bank, hospital, shop;
    Merchant allMerchants[] = new Merchant[3];

    ArrayList<String> namesOfThingsInTown = new ArrayList<String>();
            
    Town(String townName, int floorLvl, Bank playerAccount) {
        this.playerAccount = playerAccount;
        this.townName = townName;
        this.floorLvl = floorLvl;

        bank = new Merchant(playerAccount, this, bankforsale, bankPrices, bankName, thingsAtBank, bankGreeting,
                bankFarewell, bankErrorMessage, "red");

        shop = new Merchant(playerAccount, this, shopForSale, shopPrices, shopName, thingsAtShop, shopGreeting,
        shopFarewell, shopErrorMessage, "green");

        hospital = new Merchant(playerAccount, this, hospitalForSale, hospitalPrices, hospitalName,
        thingsAtHospital, hospitalGreeting, hospitalFarewell, hospitalErrorMessage, "purple");

        allMerchants[0] = bank;
        allMerchants[1] = shop;
        allMerchants[2] = hospital;
        
        // makes a list of all the names of shops in town.
        for (int i = 0; i < allMerchants.length; i++) {
            namesOfThingsInTown.add(i, allMerchants[i].shopName);
        }
    }

    public void characterEnteringTown() {

        // welcomes the character to town and shows them what we have here
        Printer.printColor("Welcome to " + townName + ", traveler! Here is a brochure with all you can do here! \n",
                "blue");
        for (Merchant merchant : allMerchants) {
            Printer.printColor(merchant.getShopName(), "blue");
        }
        Printer.printColor("\n" + "Where do you want to go?", "blue");

        // gets them to enter a shop name as to where they want to go, and then runs
        // that shop.
        String whereMerchantWantsToGO = ErrorChecker.compareArrayOfStrings(
                namesOfThingsInTown.toArray(new String[namesOfThingsInTown.size()]),
                "Sorry could you repeat that?", "blue");
        for (Merchant merchant : allMerchants) {
            if (whereMerchantWantsToGO == merchant.getShopName()) {
                merchant.shop();
            }
        }
    }

}
