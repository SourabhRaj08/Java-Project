import java.util.Scanner;
public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        while (true) {
            System.out.println("\nWelcome to the banking system. Please select an option:");
            System.out.println("1. Create account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
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
                    if(phoneNumber.length() != 10){
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
