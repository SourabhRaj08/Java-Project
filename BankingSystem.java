import java.util.Scanner;
public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        while (true) {
            System.out.println("\nWelcome to the banking system. Please select an option:");
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. See Account Details");
            System.out.println("6. Exit");
            System.out.println("Option: ");

            String choice = scanner.next();
            switch (choice) {
                case "1":
                    scanner.nextLine();
                    System.out.println("Please enter your name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter your Phone Number:");
                    String phoneNumber = scanner.nextLine();
                    if(phoneNumber.length()<10 || phoneNumber.length()>10){
                        System.out.println("The number is invalid.");
                        break;
                    }
                    System.out.println("Enter your Age(Your age should be above 18 to open a Bank Account):");
                    int age=scanner.nextInt();
                    if(age<18)
                    {
                        System.out.println("You are not eligible for opening a Bank account.");
                        break;
                    }
                    System.out.println("Please enter the Initial Deposit:");
                    double deposit = scanner.nextDouble();
                    bank.createAccount(name, deposit, age, phoneNumber);
                    break;
                case "2":
                    System.out.println("Please enter your account number:");
                    int accountNumber = scanner.nextInt();
                    System.out.println("Please enter the amount to deposit:");
                    double amount = scanner.nextDouble();
                    bank.deposit(accountNumber, amount);
                    break;
                case "3":
                    System.out.println("Please enter your account number:");
                    accountNumber = scanner.nextInt();
                    System.out.println("Please enter the amount to withdraw:");
                    amount = scanner.nextDouble();
                    bank.withdraw(accountNumber, amount);
                    break;
                case "4":
                    System.out.println("Please enter your account number:");
                    accountNumber = scanner.nextInt();
                    System.out.println("Your account balance is: " + bank.checkBalance(accountNumber));
                    break;
                case "5":
                    System.out.println("Enter account number to see Details");
                    int acc= scanner.nextInt();
                    bank.show_accounts(acc);
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}

class Bank {
    private int accountNumberCounter = 1;
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

class Account {
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
        String a="name :"+name+"\n"+"account number :"+accountNumber+"\n"+"age :"+age+"\n"+"Current balance"+balance+"\n"+"Phone number :"+phoneNumber;
        return a;
    }
}
