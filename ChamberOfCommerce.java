public class ChamberOfCommerce {
    //Store templates for the stores
    private static String[] shopForSale = {"car", "shoe", "pizza", "macaroni"};
    private static int[] shopPrices = {100, 10, 99, 88};
    private static String shopName = "Bobs Random Things";
    private static String[] thingsAtShop = {"buy", "sell"};
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

    Merchant shop = new Merchant(shopForSale, shopPrices, shopName, thingsAtShop, shopGreeting, shopFarewell, shopErrorMessage, "green");
    Merchant hospital = new Merchant(hospitalForSale, hospitalPrices, hospitalName, thingsAtHospital, hospitalGreeting, hospitalFarewell, hospitalErrorMessage, "purple");

    public void runHospital() {
        hospital.shop();
    }
    public void runShop() {
        shop.shop();
    }
}
