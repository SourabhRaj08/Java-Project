import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Delete {
    public static void deletea()
    {
        File x=new File("Accounts.txt");
        if (!x.exists()) {

        } else if (!x.isFile()) {

        } else {
            try {
                FileWriter fw = new FileWriter(x, false);
                fw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
