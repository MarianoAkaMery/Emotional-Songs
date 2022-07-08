package emotionalsongs;

import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.*;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * Classe che permette di controllare i dati al momento del login
 * 
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: 748240
 */

public class LoginChecker {
    static Scanner scan = new Scanner(System.in);
    
    /**
     * Funzione che controlla se i dati inseriti al momento del login siano corretti.
     * 
     * @param UserId IdUser dell'utente.
     * @param PasswordId Password dell'utente.
     * @return True se il login e' stato eseguito correttamente, false in caso di credenziali errate.
     */
    public static boolean LoginCheckNew(String UserId ,String PasswordId) {

        try {
    
            CSVReader reader = new CSVReader(new FileReader("emotionalsongs.data.UtentiRegistrati.dati.csv"));
                
            /**
             * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
             */
            String [] nextLinea;
            /**
             * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato diviso in "blocchi" 
             * prendendo come divisione tra i vari blocchi il carattere ",".
             */
            String[] output;
            /**
             * String che permette la divisione in blocchi tramite la funzione split().
             */
            String checkers;    
            int i=0;        

            
            while ((nextLinea = reader.readNext()) != null)
            {
            
            checkers= Arrays.toString(nextLinea);
            output = checkers.split(",");
            if (i!=0){
            String user=output[5].substring(1);
            String pass=output[6].replace("]", "").substring(1);
            
            if (user.equals(UserId) & pass.equals(PasswordId) )
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
