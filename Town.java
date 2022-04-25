import java.util.ArrayList;

public class Town {
    //* Variables that we will need during this code 

    //this array list will be filled with the names of all the shops in the town. 
    ArrayList<String> namesOfThingsInTown = new ArrayList<String>();
    Merchant bank, hospital, shop;
    Merchant allMerchants[];
    String townName;
    Bank playerAccount;
    int floorLvl;

    // * INFORMATION REGARDING WHAT EACH STORE WILL CONTAIN

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

    private static String bankName = "Golden Bank Of Reign";
    static String[] thingsAtBank = { "withdraw", "view balance", "leave" };
    static String bankGreeting = "Welcome to the bank!";
    static String bankFarewell = "Thank you for coming to the bank";
    private static String bankErrorMessage = "Please speak clearly.";



    /**
     * This is the creation of the town. It sets up all the merchants, links up banking, and gets all the
     * information needed to run a town, such as its name and floor level
     * @param townName this is the name of the town. Higher the level, the higher the prestigious town title. 
     * @param floorLvl this is the level of the society. Higher, the more prestigious. 
     * @param playerAccount this is the players bank account
     */
    Town(String townName, int floorLvl, Bank playerAccount) {

        //we need to pass through the players account information so that we can have a single constant account throughout 
        //all of the classes
        this.playerAccount = playerAccount;
        this.townName = townName;
        this.floorLvl = floorLvl;

        // INFORMATION ABOUT THE STORES
        bank = new Merchant(playerAccount, this, bankforsale, bankPrices, bankName, thingsAtBank, bankGreeting,
                bankFarewell, bankErrorMessage, "red");

        shop = new Merchant(playerAccount, this, shopForSale, shopPrices, shopName, thingsAtShop, shopGreeting,
                shopFarewell, shopErrorMessage, "green");

        hospital = new Merchant(playerAccount, this, hospitalForSale, hospitalPrices, hospitalName,
                thingsAtHospital, hospitalGreeting, hospitalFarewell, hospitalErrorMessage, "purple");

        //initializes array of all the merchants
        allMerchants = new Merchant[] {bank, shop, hospital};
        
        // makes a list of all the names of shops in town.
        for (int i = 0; i < allMerchants.length; i++) {
            namesOfThingsInTown.add(i, allMerchants[i].shopName);
        }
    }

    public void characterEnteringTown() {

        // welcomes the character to town
        Printer.printColor("Welcome to " + townName + ", traveler on floor " + floorLvl + "!\n"
            + "Here is a brochure with all you can do here! \n","blue");

        //prints out all the merchants in the town. 
        for (Merchant merchant : allMerchants) {
            Printer.printColor(merchant.getShopName(), "blue");
        }
        Printer.printColor("\n" + "Where do you want to go?", "blue");

        // gets them to enter a shop name as to where they want to go, and then runs
        // that shop.
        String whereMerchantWantsToGO = ErrorChecker.compareArrayOfStrings(
                //makes the names of all the things in town into an actual array, then uses that to check if the user
                //enters that value
                namesOfThingsInTown.toArray(new String[namesOfThingsInTown.size()]),
                "Sorry could you repeat that?", "blue");

            //once we have a value, we let them shop at one of the places they asked for. 
            //this checks which name of the shop they entered, then sends them in. 
        for (Merchant merchant : allMerchants) {
            if (whereMerchantWantsToGO == merchant.getShopName()) {
                merchant.shop();
                return;
            }
        }
    }

}
