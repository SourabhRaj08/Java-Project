 public class Bank {
    public int accountNumberCounter = 1;
    public Account[] accounts = new Account[100];
    public void createAccount(String name, double deposit, int age, String phoneNumber) {
        Account account = new Account(accountNumberCounter, name, deposit, age, phoneNumber);
        accounts[accountNumberCounter - 1] = account;
        System.out.println("Account created.\nYour Account number is: " + accountNumberCounter);
        accountNumberCounter++;
    }
    public void show_accounts(int account_num)
    {
        System.out.println(accounts[account_num-1]);
    }

    public void deposit(int accountNumber, double amount) {
        Account account = accounts[accountNumber - 1];
        account.deposit(amount);
        System.out.println("Deposit successful. New balance is: " + account.getBalance());
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = accounts[accountNumber - 1];
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance is: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal unsuccessful.");
        }
    }

    public double checkBalance(int accountNumber) {
        Account account = accounts[accountNumber - 1];
        return account.getBalance();

    }
}
