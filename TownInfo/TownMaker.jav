package TownInfo;

public class TownMaker{
    private Bank playerAccount;
    private String notStoreItems[] = new String[2];
    private double notStorePrices[] = new double[2];


    private String slumBankName = "Broken Bank";
    private String[] thingsToDoInSlumBank = {"withdraw", "view balance"};
    private String greeting4SlumBank = "Welcome to the broken bank! How can I help you?";
    private String farewell4SlumBank = "Adios!";
    private String error4SlumBank = "Please repeat that";
    private String colorOfSlumBank = "grey";


    TownMaker(Bank playerAccount){
        this.playerAccount = playerAccount;
    }

    public void makeSlums(){
        Town slums = new Town("The Slums", 1, playerAccount);
        slums.addBuilding(playerAccount, notStoreItems, notStorePrices, slumBankName, thingsToDoInSlumBank, greeting4SlumBank, farewell4SlumBank, error4SlumBank, colorOfSlumBank);
    }

    public void runSlums(){

    }









}