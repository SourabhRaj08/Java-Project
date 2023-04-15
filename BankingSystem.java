import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class BankingSystem {
    static int accountscheck=0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();
        while (true) {
            System.out.println("\nWelcome To The Banking System. Please Select an Option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. See Account Details");
            System.out.println("6. Printing All Account Details");
            System.out.println("7. Exit");
            System.out.println("Option: ");

            String choice = sc.next();
            Readaccounts ob2=new Readaccounts();
            switch (choice) {
                case "1":
                    sc.nextLine();
                    System.out.println("Please Enter Your Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Account Type(Savings or Current):");
                    String accountType = sc.nextLine();
                    if(!accountType.equals("Savings") && !accountType.equals("Current")&&!accountType.equals("savings") && !accountType.equals("current"))
                    {
                        System.out.println("Please Enter a Valid Input");
                        break;
                    }
                    System.out.println("Enter Your Phone Number:");
                    String phoneNumber = sc.nextLine();
                    if (phoneNumber.length() != 10) {
                        System.out.println("The Number is Invalid!!!");
                        break;
                    }
                    System.out.println("Enter your Age(Your age should be 18 to open a Bank Account):");
                    int age;
                    try {
                        String temp = sc.nextLine();
                        age = Integer.parseInt(temp);
                    } catch (Exception e) {
                        System.out.println("Invalid Input!!!\nPlease Enter Number Only.");
                        continue;
                    }
                    if (age <18 || age >100) {
                        System.out.println("You are not eligible for opening a Bank account.");
                        break;
                    }
                    System.out.println("Please Enter the Initial Deposit:");
                    double deposit = sc.nextDouble();
                    if (deposit < 1000) {
                        System.out.println("Invalid Amount Entered!!!\nMinimum Amount to Deposit is 1000.");
                        break;
                    }
                    bank.createAccount(name, deposit, age, phoneNumber,accountType);
                    accountscheck += 1;
                    Writeaccounts ob1=new Writeaccounts();
                    LocalDate date=LocalDate.now();
                    Readaccounts.read();

                    int account=Readaccounts.Accounts.size()-7;
                    String accounts=(String)Readaccounts.Accounts.get(account);
                    int Accountnum=Integer.parseInt(accounts);
                    Accountnum+=1;

                    ob1.add(Accountnum,name,accountType,age,phoneNumber,deposit,date);
                    ob1.Write();
                    Readaccounts.read();
                    int size=Readaccounts.Accounts.size();
                    size=size-7;
                    System.out.println("Your Account Number is: "+Readaccounts.Accounts.get(size));
                    break;

                case "2":
                    System.out.println("Please Enter Your Account Number:");
                    int accountNumber = sc.nextInt();

                    System.out.println("Please Enter The Amount To Deposit:");
                    double amount = sc.nextDouble();
                    if (amount < 500) {
                        System.out.println("Invalid Amount Entered!!!\nMinimum Amount to Deposit is 500.");
                        break;
                    }
                    ArrayList temp2=new ArrayList();
                    Readaccounts.read();
                    temp2=Readaccounts.Accounts;
                    Delete.deletea();
                    String accountNumbery=Integer.toString(accountNumber);
                    for(int i=0;i<temp2.size();i+=7) {

                        if (temp2.get(i).equals(accountNumbery)) {
                            System.out.print("Deposit Successfull!!\n");
                            double x1 = Double.parseDouble((String) temp2.get(i + 5));
                            x1 = x1 + amount;
                            int c = i + 5;
                            temp2.set(c, x1);
                        }
                        else if(i>Readaccounts.Accounts.size()-7){
                            System.out.println("Account not found");
                        }
                    }
                    Writeaccounts.P1=temp2;
                    Writeaccounts ob=new Writeaccounts();
                    ob.Write();
                    break;
                case "3":
                        System.out.println("Enter Account Type(Savings or Current):");
                        sc.nextLine();
                        String acc_Type = sc.nextLine();
                        if (!acc_Type.equals("Savings") && !acc_Type.equals("Current") && !acc_Type.equals("savings") && !acc_Type.equals("current")) {
                            System.out.println("Please Enter a Valid Input");
                            break;
                        }
                        System.out.println("Please Enter Your Account Number:");
                        accountNumber = sc.nextInt();
                        String accountNumberx = Integer.toString(accountNumber);
                        Readaccounts.read();
                        ArrayList temp = new ArrayList();
                        temp = Readaccounts.Accounts;

                        System.out.println("Please Enter The Amount To Withdraw:");
                        amount = sc.nextDouble();
                        if (amount < 500) {
                            System.out.println("Minimum Amount to Withdraw is 500.");
                            break;
                        }

                        Delete.deletea();
                        for (int i = 0; i < temp.size(); i += 7) {
                            if (temp.get(i).equals(accountNumberx)) {
                                double x1 = Double.parseDouble((String) temp.get(i + 5));
                                if (acc_Type.equals("savings") || acc_Type.equals("Savings")) {
                                    if (x1 > amount) {
                                        x1 = x1 - amount;

                                        int c = i + 5;
                                        temp.set(c, x1);
                                        System.out.print("Withdrawal Successful!!\n ");

                                    } else
                                    {
                                        System.out.println("Insufficient Balance!");
                                    }
                                    } else {
                                    x1 = x1 - amount;

                                    int c = i + 5;
                                    temp.set(c, x1);
                                }
                            }
                        }

                    Writeaccounts.P1=temp;
                    Writeaccounts obb=new Writeaccounts();
                    obb.Write();
                    break;
                case "4":
                    System.out.println("Please Enter Your Account Number:");
                    String accountNumberz = sc.next();

                   Readaccounts.read();
                    for(int i=0;i<Readaccounts.Accounts.size();i+=7)
                    {

                        if(Readaccounts.Accounts.get(i).equals(accountNumberz))
                        {
                            System.out.println("Your Balance is: " +Readaccounts.Accounts.get(i+5));
                        }
                        else if(i>Readaccounts.Accounts.size()-7){
                            System.out.println("Account not found!");
                        }
                    }
                    break;
                case "5":
                    System.out.println("Enter Account Number To See Details");
                    String accountNumberk = sc.next();

                    Readaccounts.read();
                    for(int i=0;i<Readaccounts.Accounts.size();i+=7)
                    {

                        if(Readaccounts.Accounts.get(i).equals(accountNumberk))
                        {
                            System.out.println("Account number: "+Readaccounts.Accounts.get(i)+"\n"+
                                    "Name :"+Readaccounts.Accounts.get(i+1)+"\n"+
                                    "Account Type :"+Readaccounts.Accounts.get(i+2)+"\n"+
                                    "Mobile Number :"+Readaccounts.Accounts.get(i+3)+"\n"+
                                    "Age :"+Readaccounts.Accounts.get(i+4)+"\n"+
                                   "Balance :"+Readaccounts.Accounts.get(i+5)+"\n"+
                                    "Date :"+Readaccounts.Accounts.get(i+6)+"\n");
                            break;
                        }
                        else if(i==Readaccounts.Accounts.size()-7){
                            System.out.println("Account not found");
                        }
                    }
                    break;
                case "6":
                    ob2.read();
                    System.out.println("Printing all Accounts Data");
                    for(int i=0;i<Readaccounts.Accounts.size();i+=7)
                    {
                        System.out.println(Readaccounts.Accounts.get(i)+"\n"+Readaccounts.Accounts.get(i+1)+"\n"+Readaccounts.Accounts.get(i+2)+"\n"+Readaccounts.Accounts.get(i+3)+"\n"+Readaccounts.Accounts.get(i+4)+"\n"+Readaccounts.Accounts.get(i+5)+"\n"+Readaccounts.Accounts.get(i+6)+"\n");
                    }
                    break;
                case "7":
                    System.out.println("Thank You For Using Our Banking System!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Please Select Again.");
            }
        }
    }
}