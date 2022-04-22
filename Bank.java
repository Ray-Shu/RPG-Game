public class Bank {
    public static double balance;

    /**
     * Creates a bank account with a certain amount of money
     * @param balance is the initial balance of the account
     */
    Bank(double balance){
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
}
