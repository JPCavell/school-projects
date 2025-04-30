package account.number.manager.assignment.jacob.cavell;

import java.util.Random;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Account Number Manager
 * File Name: AccountNumberGenerator.java
 */
public class AccountNumberGenerator {

    Random rand = new Random();

    private static AccountNumberGenerator instance;

    private AccountNumberGenerator() {
    }

    /*
     * This method is to get the single instance of AccountNumberGenerator, creating it if needed.
     */
    public static synchronized AccountNumberGenerator getInstance() {
        if (instance == null) {
            instance = new AccountNumberGenerator();
        }
        return instance;
    }

    /*
     * This method is to get and return the next randomized account number stored into int numberGenerated.
     */
    public synchronized int getNextNumber() {

        int numberGenerated = rand.nextInt(10000);
        return numberGenerated;
    }

    /*
     * This method is the driver method that will get the instance of AccountNumberGenerator and
     * print fice randomized account numbers.
     */
    public static void main(String[] args) {

        AccountNumberGenerator generator = AccountNumberGenerator.getInstance();

        for (int i = 0; i < 5; i++) {
            int accountNumber = generator.getNextNumber();
            System.out.println("Generated Account Number: " + accountNumber);
        }
    }

}
