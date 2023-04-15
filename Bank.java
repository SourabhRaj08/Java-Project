
public class Bank {
    public int accountNumberCounter = 1;
    public Account[] accounts = new Account[100];
    public void createAccount(String name, double deposit, int age, String phoneNumber,String accountType) {
        Account account = new Account(accountNumberCounter, name, deposit, age, phoneNumber,accountType);
        accounts[accountNumberCounter] = account;
        System.out.println("Account Created Successfully!!");
        accountNumberCounter++;
    }

}
