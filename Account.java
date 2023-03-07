public class Account {
public String phoneNumber;
public final int age;
public int accountNumber;
public String name;
public double balance;

public Account(int accountNumber, String name, double deposit, int age, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = deposit;
        this.age=age;
        this.phoneNumber=phoneNumber;
        }

public void deposit(double amount)
        {
        balance += amount;
        }

public boolean withdraw(double amount) {
        if (amount <= balance) {
        balance -= amount;
        return true;
        } else {
        return false;
        }
        }

public double getBalance()
        {
        return balance;
        }

@Override
public String toString()
        {
        String a="name :"+name+"\n"+"account number :"+accountNumber+"\n"+"age :"+age+"\n"+"Current balance :"+balance+"\n"+"Phone number :"+phoneNumber;
        return a;
        }
}