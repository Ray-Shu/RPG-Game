package PlayerInformation;

import Tools.Printer;

public class Bank {
    public double balance;

    /**
     * Creates a bank account with a certain amount of money
     * @param balance is the initial balance of the account
     */
    public Bank(double balance){
        this.balance = balance;
    }
    
    /**
     * Withdraws some money from their account
     * @param amount is the amount to withdraw
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Returns the balance of the account
     * @return the balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Puts money into the account
     * @param amount    - the amount of money the user is putting into the account
     */
    public void deposit (double amount) {
        balance += amount;
    }


    /**
     * Checks if the player has enough money to make a purchase
     * @param amount        - the cost of the item
     * @return boolean      - true if they have enough to buy, false if else. 
     */
    public boolean doesPlayerHaveEnoughMoney(double amount){
        //checks if our balance is greater than or equal to the amount the method calls. 
        if(balance >= amount){
            return true;
        }
        return false;
    }

    /**
     * Prints out how much money we have in our account. 
     */
    public void printBalance(){
        Printer.printColor("Your balance is now "+ balance,"white");
    }
}
