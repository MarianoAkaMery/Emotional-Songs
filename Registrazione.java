import java.util.*;

public class Registrazione {


    static Scanner scan=new Scanner(System.in);

    //Sleep Function to visualize errors
    public static void wait(int ms){
    try{
        Thread.sleep(ms);
    }
    catch(InterruptedException ex){
        Thread.currentThread().interrupt();
    }}

    //Registration function 
    public static void RegistrazioneNew(){

        System.out.println("Benvenuto nella registrazione account di EmotionalSongs\n");
        boolean ContinuaLogin = true;
        while(ContinuaLogin==true){

            //Inserimento Nome
            try{        
                System.out.println("Inserisci il tuo nome:");
                String Name=scan.nextLine();

            }
            catch(Exception e) {
                System.out.println("Nome inserito non valido");
                wait(3500);
                break;
                
            }
            
            //Inserimento Cognome
            try{        
                System.out.println("Inserisci il tuo cognome:");
                String Surname=scan.nextLine();

            }
            catch(Exception e) {
                System.out.println("Cognome inserito non valido");
                wait(3500);
                break;            
            }

            //Inserimento CodiceFiscale    
            System.out.println("Inserisci il tuo codice fiscale:");
            String FiscalCode=scan.nextLine();
    
            if (FiscalCode.length()!=16){
                System.out.println("codice fiscale inserito non valido");
                wait(3500);
                break;
            } 

            //Inserimento Indirizzo
            try{        
                System.out.println("Inserisci il tuo indirizzo fisico:");
                String PhysicalAddress=scan.nextLine();
    
            }
            catch(Exception e) {
                System.out.println("Indirizzo fisico inserito non valido");
                wait(3500);
                break;
            }

            //Inserimento Email          
            System.out.println("Inserisci il tuo indirizzo di posta elettronica:");
            String EmailAddress=scan.nextLine();
    
            if (EmailAddress.indexOf('@')==-1){
                System.out.println("Indirizzo di posta elettronica inserito non valido");
                wait(3500);
                break;
            }

            //Inserimento UserId
            try{        
                System.out.println("Inserisci il tuo UserdId:");
                String UserId=scan.nextLine();
    
    
            }
            catch(Exception e) {
                System.out.println("UserId inserito non valido");
                wait(3500);
                break;
            }

            //Inserimento Password      
            System.out.println("Inserisci la tua password:\n(Minimo 7 caratteri)");
            String UserPassword=scan.nextLine();
    
    
            if (UserPassword.length()<6)
                System.out.println("Password inserita non valida");
                wait(3500);
                break;
            }

            //Salvataggio dati nel csv + return 
        }

}
