import java.util.Scanner;
public class BankingSystem {

    static int accountscheck=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        while (true) {
            System.out.println("\nWelcome To The Banking System. Please Select an Option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. See Account Details");
            System.out.println("6. Exit");
            System.out.println("Option: ");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    scanner.nextLine();
                    System.out.println("Please Enter Your Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Your Phone Number:");
                    String phoneNumber = scanner.nextLine();
                    if(phoneNumber.length() != 10){
                        System.out.println("The Number is Invalid!!!");
                        break;
                    }
                    System.out.println("Enter your Age(Your age should be above 18 to open a Bank Account):");
                    int age=scanner.nextInt();
                    if(age<18 || age>110)
                    {
                        System.out.println("You are not eligible for opening a Bank account.");
                        break;
                    }
                    System.out.println("Please Enter the Initial Deposit:");
                    double deposit = scanner.nextDouble();
                    if(deposit<1000)
                    {
                        System.out.println("Invalid Amount Entered!!!\nMinimum Amount to Deposit is 1000.");
                        break;
                    }
                    bank.createAccount(name, deposit, age, phoneNumber);
                    accountscheck+=1;
                    break;
                case "2":
                    System.out.println("Please Enter Your Account Number:");
                    int accountNumber = scanner.nextInt();
                    if(accountNumber>accountscheck)
                    {
                        System.out.println("Invalid Account Number!!!");
                        break;
                    }
                    System.out.println("Please Enter The Amount To Deposit:");
                    double amount = scanner.nextDouble();
                    if(amount<500)
                    {
                        System.out.println("Invalid Amount Entered!!!\nMinimum Amount to Deposit is 500.");
                        break;
                    }
                    bank.deposit(accountNumber, amount);
                    break;
                case "3":
                    System.out.println("Please Enter Your Account Number:");
                    accountNumber = scanner.nextInt();
                    if(accountNumber>accountscheck)
                    {
                        System.out.println("Invalid Account Number!!!");
                        break;
                    }
                    System.out.println("Please Enter The Amount To Withdraw:");
                    amount = scanner.nextDouble();
                    if(amount<100)
                    {
                        System.out.println("Minimum Amount to Withdraw is 100.");
                        break;
                    }
                    bank.withdraw(accountNumber, amount);
                    break;
                case "4":
                    System.out.println("Please Enter Your Account Number:");
                    accountNumber = scanner.nextInt();
                    if(accountNumber>accountscheck)
                    {
                        System.out.println("Invalid Account Number!!!");
                        break;
                    }
                    System.out.println("Your Account Balance is: " + bank.checkBalance(accountNumber));
                    break;
                case "5":
                    System.out.println("Enter Account Number To See Details");
                    int acc= scanner.nextInt();
                    if(acc>accountscheck)
                    {
                        System.out.println("Invalid Account Number!!!");
                        break;
                    }
                    bank.show_accounts(acc);
                    break;
                case "6":
                    System.out.println("Thank You For Using Our Banking System!!!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice. Please Select Again.");
            }
        }
    }
}