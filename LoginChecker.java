import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.*;

public class LoginChecker {
    static Scanner scan=new Scanner(System.in);
    //Login function 
    public static boolean LoginCheckNew(String UserId,String PasswordId) {

        try {
    
            CSVReader reader = new CSVReader(new FileReader("UtentiRegistrati.dati.csv"));
            
            String [] nextLinea;
            String[] output;
            String checkers;    
            int i=0;        

            
            while ((nextLinea = reader.readNext()) != null)
            {
               
                checkers= Arrays.toString(nextLinea);
                output = checkers.split(",");
                
                if (i!=0){
                    if (output[5].contains(UserId) & output[6].contains(PasswordId) )
                    return true;
                }
                i++;
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
