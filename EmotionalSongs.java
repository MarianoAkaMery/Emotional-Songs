import java.io.IOException;
import java.util.*;
/*All’avvio l’applicazione mostra un menu iniziale dove:
Tutti possono:
• cercare brani con titolo, autore, anno
• visualizzare le emozioni associate a ciascuna canzone selezionata
• registrarsi al’applicazione
Gli utenti registrati possono:
• creare playlist
• inserire le emozioni provate all’ascolto di determinate canzoni*/

import com.opencsv.exceptions.CsvValidationException;

public class EmotionalSongs {
    public static String nomeUtente = null;
    public static void main(String[] args) throws CsvValidationException, IOException{
        DisplayMenu();
}

    static Scanner scan=new Scanner(System.in);

    public static void DisplayMenu() throws CsvValidationException, IOException{
        boolean continua = true;

        while(continua==true){

            System.out.println("Benvenuti in EmotionaSongs");
            System.out.println("Cosa si desidera fare?\n1- Cercare Brano\n2- Visualizzare Emozoni\n3- Registrazione\n4- Login\n5- Registra Playlist\n6- Inserisci l'emozioni \n7- Close\n");
            System.out.println("Scegliere un opzione (1, 2, 3, 4, 5, 6, 7):");
            int Choise=scan.nextInt();
            scan.nextLine();
            Boolean LoginValidator = false;
            
            switch(Choise){

                case 1: {
                    Funzioni.cercaBranoMusicale();
                    break;
                }

                case 2:{
                    Funzioni.visualizzaEmozioneBrano();
                    break;
                }

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

                case 4:{
                    System.out.println("Inseririe UserId:");
                    String UserdId2=scan.nextLine();
                    System.out.println("Inseririe Password:");
                    String PasswordId2=scan.nextLine();
                    LoginValidator=LoginChecker.LoginCheckNew(UserdId2,PasswordId2);
                    nomeUtente = UserdId2;
                    
                    if(LoginValidator == true){
                        System.out.println("\nLogin effettuato con successo!\n \n");
                    }
                    else{
                        System.out.println("Credenziali di accesso errate!\n");
                    }
                    break;
                }

                case 5:{
                    if (LoginValidator==true){
                    Funzioni.RegistraPlaylist();}
                    else{
                        System.out.println("Effettuare prima il login!\n");
                        Sleep.wait(2000);
                    }
                    break;
                }

                case 6:{
                    if (LoginValidator==true){
                        Funzioni.inserisciEmozioniBrano();}
                    else{
                        System.out.println("Effettuare prima il login!\n");
                        Sleep.wait(2000);
                        }
                    break;
                }

                case 7:{
                    System.out.println("See you soon!\n");
                    continua = false;
                    break;                  
                }

                default:{
                    System.out.println("\nScelta non valida\n");
                    Sleep.wait(2000);
                    break;
                }
            }
        }   
    }
}