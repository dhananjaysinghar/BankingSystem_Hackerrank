package banking;

/**
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction {
    private Long accountNumber;
    private Bank bank;

    /**
     * @param bank          The bank where the account is housed.
     * @param accountNumber The customer's account number.
     * @param attemptedPin  The PIN entered by the customer.
     * @throws Exception Account validation failed.
     */
    public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
        // complete the function

        if (bank.authenticateUser(accountNumber, attemptedPin)) {
            this.bank = bank;
            this.accountNumber = accountNumber;
        } else {
            throw new Exception("Invalid cred");
        }

    }

    public double getBalance() {
        // complete the function
        return bank.getBalance(accountNumber);
    }

    public void credit(double amount) {
        // complete the function
        bank.credit(accountNumber, amount);
    }

    public boolean debit(double amount) {
        // complete the function
        return bank.debit(accountNumber, amount);
    }
}
