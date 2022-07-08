package emotionalsongs;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * 
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: 748240
 */

public class EmotionalSongs{
    /**
     * Classe principale con la funzione "DisplayMenu" che mostra il menu dell'applicazione
    */
    public static String nomeUtente = null;
    static Scanner scan=new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException{
        DisplayMenu();

    }

    /**
     * All'avvio del programma, verra' mostrato un menu dove:
     * per chi non ha effettuato il login sara' possibile cercare brani(in varie modalita'), 
     * visualizzare emozioni riguardanti specifici brani e registrarsi, 
     * mentre per chi ha effettuato il login, oltre alle funzioni precedenti, 
     * sara' possibile creare playlist e inserire emozioni provate durante l'ascolto di brani musicali, 
     * 
     * @throws FileNotFoundExecption File non trovato.
     */
    public static void DisplayMenu() throws FileNotFoundException{
        /**
         * Consente la ripetizione del codice fino a quando non si seleziona "5"
         */
        boolean continua = true;
        /**
         * Una volta effettuato il login non ci sara' bisogno di ripeterlo     
         */
        boolean LoginAlreadyDone=false;
        /**
         * Gestisce l'avvenuto "login" di un utente
         */
        boolean LoginValidator=false;
        int Choise;

        while(continua==true){
            if (LoginAlreadyDone==true){
                System.out.println("\nCosa si desidera fare?\n \n1- Cercare Brano\n \n2- Visualizzare Emozoni\n \n3- Registrazione\n \n4- Regista Playlist o Emozioni\n \n5- Close\n \n");
                System.out.println("Scegliere un opzione (1, 2, 3, 4, 5):");
                Choise=scan.nextInt();
                scan.nextLine();

            }
            else{
            System.out.println("Benvenuti in EmotionaSongs\n");
            System.out.println("Cosa si desidera fare?\n \n1- Cercare Brano\n \n2- Visualizzare Emozoni\n \n3- Registrazione\n \n4- Login\n \n5- Close\n \n");
            System.out.println("Scegliere un opzione (1, 2, 3, 4, 5):");
            Choise=scan.nextInt();
            scan.nextLine();
            }

            switch(Choise){
                /**
                 * Permette di cercare un brano
                 */
                case 1: {
                    CercaBrano.cercaBranoMusicale();
                    break;
                }
                /**
                 * Permette di visualizzare le emozioni riguardo a una canzone specifica
                 */
                case 2:{
                    VisualizzaEmozioneBrano.visualizzaEmozioneBrano();
                    break;
                }
                /**
                 * Permette di registrarsi nell'applicazione
                 */
                case 3:{
                    Boolean RegistrationStatus=RegistrazioneUtente.Registrazione();
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

                    if(LoginAlreadyDone==true){
                        LoginValidator=true;}
                    else{
                        System.out.println("Inseririe UserId:");
                        String UserdId2=scan.nextLine();
                        System.out.println("Inseririe Password:");
                        String PasswordId2=scan.nextLine();
                        LoginValidator=LoginChecker.LoginCheckNew(UserdId2,PasswordId2);
                        nomeUtente = UserdId2;
                    }
                    if (LoginValidator==true){
                            LoginAlreadyDone=true;
                            System.out.println("\nLogin effettuato con successo!\n \n");
                            Sleep.wait(3500);
                            System.out.println("Cosa si desidera fare?\n \n1- Creare Playlist\n \n2- Inserire emozioni\n \n");
                            System.out.println("Scegliere un opzione (1 o 2):");
                            int LoggedChoise=scan.nextInt();
                            scan.nextLine();

                            switch(LoggedChoise){
                                /**
                                 * Permette di registrare una playlist.
                                 */
                                case 1:{
                                    RegistrarePlaylist.RegistraPlaylist();
                                    break;
                                }
                                /**
                                 * Permette di registrare un' emozione.
                                 */
                                case 2:{
                                    InserisciEmozioni.inserisciEmozioniBrano();
                                    break;
                                }
                            }
                    }
                    else{
                        System.out.println("Credenziali di accesso errate!\n");
                        Sleep.wait(3500);
                    }

                    break;
                }

                /**
                 * Permette di chiudere l'applicazione
                 */
                case 5:{

                    System.out.println("See you soon!\n");
                    continua = false;
                    break;

                }

                /**
                 * Permette se inserito un numero non valido di inserirne un altro
                 */
                default:{
                    System.out.println("\nScelta non valida\n");
                    break;
                }
            }
        }   
    }
}