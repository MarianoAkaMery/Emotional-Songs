import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;
import com.opencsv.CSVWriter;


public class Registrazione extends LoginChecker{


    static Scanner scan=new Scanner(System.in);


    //Registration function 
    public static boolean RegistrazioneNew() throws FileNotFoundException{
        
        System.out.println("Benvenuto nella registrazione account di EmotionalSongs\n");
        boolean ContinuaLogin = true;
        ArrayList<String> LoginSession =new ArrayList<>();
        while(ContinuaLogin==true){

            //Inserimento Nome
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
            
            //Inserimento Cognome
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

            //Inserimento CodiceFiscale    
            System.out.println("Inserisci il tuo codice fiscale:");
            String FiscalCode=scan.nextLine();
            LoginSession.add(FiscalCode);
    
            if (FiscalCode.length()!=16){
                System.out.println("codice fiscale inserito non valido\n");
                Sleep.wait(3500);
                break;
            } 

            //Inserimento Indirizzo
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

            //Inserimento Email          
            System.out.println("Inserisci il tuo indirizzo di posta elettronica:");
            String EmailAddress=scan.nextLine();
            LoginSession.add(EmailAddress);
            
    
            if (EmailAddress.indexOf('@')==-1){
                System.out.println("Indirizzo di posta elettronica inserito non valido\n");
                Sleep.wait(3500);
                break;
            }

            //Inserimento UserId
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

            //Inserimento Password      
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
                    //Salvataggio dati nel csv + return 
                    File file=new File("UtentiRegistrati.dati.csv" );
                    // create FileWriter object with file as parameter
                    FileWriter outputfile = new FileWriter(file, true);
            
                    // create CSVWriter object filewriter object as parameter
                    CSVWriter writer = new CSVWriter(outputfile);         
                    String [] CsvLogin={LoginSession.get(0),LoginSession.get(1),LoginSession.get(2),LoginSession.get(3),LoginSession.get(4),LoginSession.get(5),LoginSession.get(6)} ;
                    writer.writeNext(CsvLogin);
                    // Now clear the stream
                    // using flush() method
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
