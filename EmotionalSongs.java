import java.io.IOException;
import java.util.Scanner;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: XXXXXX
 * @author Mariano Librici, Matricola: XXXXXX
 */

import com.opencsv.exceptions.CsvValidationException;

public class EmotionalSongs {

    /**
     * Classe principale con la funzione "DisplayMenu" che mostra il menu dell'applicazione
     */
    public static String nomeUtente = null;
    static Scanner scan=new Scanner(System.in);

    public static void main(String[] args) throws CsvValidationException, IOException{
        DisplayMenu();
}

    /**
     * All'avvio del programma, verra' mostrato un menu dove:
     * per chi non ha effettuato il login sara' possibile cercare brani(in varie modalita'), visualizzare emozioni riguardanti specifici brani e registrarsi
     * mentre per chi ha effettuato il login, oltre alle funzioni precedenti, sara' possibile creare playlist e inserire emozioni provate durante l'ascolto di brani musicali, 
     * @throws CsvValidationException single line is invalid
     * @throws IoException produced by failed or interrupted I/O operations.
     */
    public static void DisplayMenu() throws CsvValidationException, IOException{
        /**
         *  Consente la ripetizione del codice fino a quando non si seleziona "7"
         */
        boolean continua = true;

        while(continua==true){

            System.out.println("Benvenuti in EmotionaSongs");
            System.out.println("Cosa si desidera fare?\n1- Cercare Brano\n2- Visualizzare Emozoni\n3- Registrazione\n4- Login\n5- Registra Playlist\n6- Inserisci l'emozioni \n7- Close\n");
            System.out.println("Scegliere un opzione (1, 2, 3, 4, 5, 6, 7):");
            int Choise=scan.nextInt();
            scan.nextLine();
            /**
             * Gestisce l'avvenuto "login" di un utente
             */
            Boolean LoginValidator = false;
            
            switch(Choise){
                /**
                 * Permette di cercare un brano
                 */
                case 1: {
                    Funzioni.cercaBranoMusicale();
                    break;
                }
                /**
                 * Permette di visualizzare le emozioni riguardo a una canzone specifica
                 */
                case 2:{
                    Funzioni.visualizzaEmozioneBrano();
                    break;
                }
                /**
                 * Permette di registrarsi nell'applicazione
                 */
                case 3:{
                    Boolean RegistrationStatus=Registrazione.RegistrazioneNew();
                    if (RegistrationStatus==true){
                        System.out.println("\nRegistrazione effettuata con successo!!\n");
                        Sleep.wait(3500);
                    }
                    else{
                        System.out.println("Registrazione non effettuata correttamente!\n");
                        Sleep.wait(3500);
                    }
                    break;
                }
                /**
                 * Permette di loggarsi nell'applicazione
                 */
                case 4:{
                    /**
                     * Inserimento del nome utente
                     */
                    System.out.println("Inseririe UserId:");
                    String UserdId = scan.nextLine();
                    /**
                     * Inserimento dell password
                     */
                    System.out.println("Inseririe Password:");
                    String PasswordId = scan.nextLine();
                    LoginValidator = LoginChecker.LoginCheckNew(UserdId,PasswordId);
                    nomeUtente = UserdId;
                    
                    if(LoginValidator == true){
                        System.out.println("\nLogin effettuato con successo!\n \n");
                    }
                    else{
                        System.out.println("Credenziali di accesso errate!\n");
                    }
                    break;
                }
                /**
                 * Permette, se loggati, di registrare una playlist
                 */
                case 5:{
                    if (LoginValidator==true){
                    Funzioni.RegistraPlaylist();}
                    else{
                        System.out.println("Effettuare prima il login!\n");
                        Sleep.wait(2000);
                    }
                    break;
                }
                /**
                 * Permette, se loggati, di inserire un'emozione riguardo ad un brano specifico
                 */
                case 6:{
                    if (LoginValidator==true){
                        Funzioni.inserisciEmozioniBrano();}
                    else{
                        System.out.println("Effettuare prima il login!\n");
                        Sleep.wait(2000);
                        }
                    break;
                }
                /**
                 * Permette di chiudere l'applicazione
                 */
                case 7:{
                    System.out.println("See you soon!\n");
                    continua = false;
                    break;                  
                }
                /**
                 * Permette se inserito un numero non valido di inserirne un altro
                 */
                default:{
                    System.out.println("\nScelta non valida\n");
                    Sleep.wait(2000);
                    break;
                }
            }
        }   
    }
}