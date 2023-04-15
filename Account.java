public class Account {
    public String phoneNumber;
    public final int age;
    public int accountNumber;
    public String accountType;
    public String name;
    public double balance;

    public Account(int accountNumber, String name, double deposit, int age, String phoneNumber, String accountType)
    {
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountType= accountType;
        this.balance = deposit;
        this.age=age;
        this.phoneNumber=phoneNumber;
    }
}