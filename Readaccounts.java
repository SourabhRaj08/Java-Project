import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Readaccounts {
    static ArrayList Accounts=new ArrayList();
    public static void read()throws
            IOException, FileNotFoundException
    {
        Accounts.clear();
        File ob1=new File("Accounts.txt");
        Scanner sc=new Scanner(ob1);
        while(sc.hasNextLine())
        {
            String random=sc.nextLine();
            Accounts.add(random);
        }
    }
}