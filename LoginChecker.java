import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.*;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: XXXXXX
 * @author Mariano Librici, Matricola: XXXXXX
 */

public class LoginChecker {
    static Scanner scan=new Scanner(System.in);
    //Login function 
    public static boolean LoginCheckNew(String UserId ,String PasswordId) {

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
