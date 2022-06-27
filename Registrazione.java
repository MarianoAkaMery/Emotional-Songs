import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;
import com.opencsv.CSVWriter;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * Classe che permette di registrarsi alla'applicazione 
 * 
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: 748240
 */

public class Registrazione extends LoginChecker{


    static Scanner scan=new Scanner(System.in);

    /**
     * Funzione che permette la registrazione all'applicazione.
     * 
     * @throws FileNotFoundException se il file non viene trovato.
     */
    public static boolean RegistrazioneNew() throws FileNotFoundException{
        
        System.out.println("Benvenuto nella registrazione account di EmotionalSongs\n");
        boolean ContinuaLogin = true;
        ArrayList<String> LoginSession =new ArrayList<>();
        while(ContinuaLogin==true){
            /**
             * Aggiunta del nome.
            */ 
            try{        
                System.out.println("Inserisci il tuo nome:");
                String Name=scan.nextLine();
                LoginSession.add(Name);

            }
            catch(Exception e) {
                System.out.println("Nome inserito non valido\n");
                Sleep.wait(3500);
                break;
                
            }
            /**
             * Aggiunta del cognome.
             */
            try{        
                System.out.println("Inserisci il tuo cognome:");
                String Surname=scan.nextLine();
                LoginSession.add(Surname);

            }
            catch(Exception e) {
                System.out.println("Cognome inserito non valido\n");
                Sleep.wait(3500);
                break;            
            }
            /**
             * Aggiunta del codice fiscale.
             */    
            System.out.println("Inserisci il tuo codice fiscale:");
            String FiscalCode=scan.nextLine();
            LoginSession.add(FiscalCode);
    
            if (FiscalCode.length()!=16){
                System.out.println("codice fiscale inserito non valido\n");
                Sleep.wait(3500);
                break;
            } 

            /**
             * Aggiunta dell'indirizzo fisico.
             */
            try{        
                System.out.println("Inserisci il tuo indirizzo fisico:");
                String PhysicalAddress=scan.nextLine();
                LoginSession.add(PhysicalAddress);
    
            }
            catch(Exception e) {
                System.out.println("Indirizzo fisico inserito non valido\n");
                Sleep.wait(3500);
                break;
            }

            /**
             * Aggiunta dell'indirizzo di posta elettronica
             */     
            System.out.println("Inserisci il tuo indirizzo di posta elettronica:");
            String EmailAddress=scan.nextLine();
            LoginSession.add(EmailAddress);
            
    
            if (EmailAddress.indexOf('@')==-1){
                System.out.println("Indirizzo di posta elettronica inserito non valido\n");
                Sleep.wait(3500);
                break;
            }

            /**
             * Aggiunta dell'UserId
             */ 
            try{        
                System.out.println("Inserisci il tuo UserdId:");
                String UserId=scan.nextLine();
                LoginSession.add(UserId);
    
    
            }
            catch(Exception e) {
                System.out.println("UserId inserito non valido\n");
                Sleep.wait(3500);
                break;
            }


            /**
             * Aggiunta della Password.
             */                
            System.out.println("Inserisci la tua password:\n(Minimo 7 caratteri)");
            String UserPassword=scan.nextLine();
            LoginSession.add(UserPassword);
    
    
            if (UserPassword.length()<6)
                System.out.println("Password inserita non valida\n");
                Sleep.wait(3500);
                break;
            }

            if (LoginSession.size()==7){

                try {

                    File file=new File("UtentiRegistrati.dati.csv" );
                    FileWriter outputfile = new FileWriter(file, true);
                    CSVWriter writer = new CSVWriter(outputfile);         
                    String [] CsvLogin={LoginSession.get(0),LoginSession.get(1),LoginSession.get(2),LoginSession.get(3),LoginSession.get(4),LoginSession.get(5),LoginSession.get(6)} ;
                    writer.writeNext(CsvLogin);
                    writer.flush();
                    writer.close();
                    
                    return true;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }

            }
            else{
                return false;
            }    


            return false;
            

        }

}
