package banking;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private AtomicLong accSeq = new AtomicLong();
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        // complete the function
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        Collection<Account> values = accounts.values();
        Optional<Account> optAccount = values.stream().filter(e -> e.getAccountNumber().equals(accountNumber)).findFirst();
        return optAccount.orElse(null);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
        Long accountNumber = accSeq.incrementAndGet();
        Account account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // complete the function
        Long accountNumber = accSeq.incrementAndGet();
        Account account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function

        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).validatePin(pin);
        }

        return false;
    }

    public double getBalance(Long accountNumber) {
        // complete the function

        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).getBalance();
        }

        return 0.0;
    }

    public void credit(Long accountNumber, double amount) {
        // complete the function
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).creditAccount(amount);
        }
    }

    public boolean debit(Long accountNumber, double amount) {
        // complete the function
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).debitAccount(amount);
        }
        return false;
    }
}
