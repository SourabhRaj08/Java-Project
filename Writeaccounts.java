import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
public class Writeaccounts {
    static ArrayList P1=new ArrayList ();
    int Accountnum;
    String name;
    String Accounttype;
    String ph_no;
    double Balance;
    int age;
    LocalDate dateofcreation;

    public void add(int Accountnum,String name,String Accounttype,int age,String ph_no, double Balance,LocalDate dateofcreation)
    {
        this.Accountnum=Accountnum;
        this.Accounttype=Accounttype;
        this.name=name;
        this.age=age;
        this.ph_no=ph_no;
        this.Balance=Balance;
        this.dateofcreation=dateofcreation;
        P1.add(Accountnum);
        P1.add(name);
        P1.add(Accounttype);
        P1.add(ph_no);
        P1.add(age);

        P1.add(Balance);
        String x=dateofcreation.toString();
        P1.add(x);

    }

    public void Write()
    {
        try
        {
            FileWriter ob1=new FileWriter("Accounts.txt",true);
            for(int i=0;i< P1.size();i+=7)
            {

                ob1.write(P1.get(i)+"\n"+P1.get(i+1)+"\n"+P1.get(i+2)+"\n"+P1.get(i+3)+"\n"+P1.get(i+4)+"\n"+P1.get(i+5)+"\n"+P1.get(i+6)+"\n");
            }
            ob1.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}