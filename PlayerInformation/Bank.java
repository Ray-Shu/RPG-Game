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

    public void deposit (double amount) {
        balance += amount;
    }

    public boolean doesPlayerHaveEnoughMoney(double amount){
        if(balance - amount >= 0){
            return true;
        }
        return false;
    }

    public void printBalance(){
        Printer.printColor("Your balance is now "+ balance,"white");
    }
}
