package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 * <p>
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account {
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;

    protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        // complete the constructor
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = getBalance() + startingDeposit;
    }

    public AccountHolder getAccountHolder() {
        // complete the function
        return accountHolder;
    }

    public boolean validatePin(int attemptedPin) {
        // complete the function
        return this.pin == attemptedPin;
    }

    public double getBalance() {
        // complete the function
        return balance;
    }

    public Long getAccountNumber() {
        // complete the function
        return accountNumber;
    }

    public void creditAccount(double amount) {
        // complete the function
        this.balance = balance + amount;
    }

    public boolean debitAccount(double amount) {
        // complete the function

        boolean isAvailable = balance >= amount;
        if (isAvailable) {
            balance = balance - amount;
        }
        return isAvailable;
    }
}
