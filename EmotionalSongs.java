import java.io.FileNotFoundException;
import java.util.*;
/**All’avvio l’applicazione mostra un menu iniziale dove:
Tutti possono:
• cercare brani con titolo, autore, anno
• visualizzare le emozioni associate a ciascuna canzone selezionata
• registrarsi al’applicazione
Gli utenti registrati possono:
• creare playlist
• inserire le emozioni provate all’ascolto di determinate canzoni*/

public class EmotionalSongs {

    static Scanner scan=new Scanner(System.in);

    public static void DisplayMenu() throws FileNotFoundException{
        boolean continua = true;

        while(continua==true){
            System.out.println("Benvenuti in EmotionaSongs\n");
            System.out.println("Cosa si desidera fare?\n \n1- Cercare Brano\n \n2- Visualizzare Emozoni\n \n3- Registrazione\n \n4- Login\n \n5- Close\n \n");
            System.out.println("Scegliere un opzione (1, 2, 3, 4, 5):");
            int Choise=scan.nextInt();
            scan.nextLine();

            switch(Choise){
                case 1: {
                    CercaBrano.cercaBranoMusicale();
                    break;
                }
                case 2:{
                    System.out.println("Benvenuti in EmotionaSongs");
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
                    Boolean LoginValidator=LoginChecker.LoginCheckNew(UserdId2,PasswordId2);

                    if (LoginValidator==true){
                            
                            System.out.println("\nLogin effettuato con successo!\n \n");
                            Sleep.wait(3500);
                            System.out.println("Cosa si desidera fare?\n \n1- Creare Playlist\n \n2- Inserire emozioni\n \n");
                            System.out.println("Scegliere un opzione (1 o 2):");
                            int LoggedChoise=scan.nextInt();
                            scan.nextLine();

                            switch(LoggedChoise){
                                case 1:{
                                    RegistraPlaylist.Registra();
                                    break;
                                }
                                case 2:{
                                    System.out.println("Benvenuti in EmotionaSongs");
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
                case 5:{

                    System.out.println("See you soon!\n");
                    continua = false;
                    break;
                    
                }
                default:{
                    System.out.println("\nScelta non valida\n");
                    break;
                }
            }
        }   
    }



    public static void main(String[] args) throws FileNotFoundException{
        DisplayMenu();
        
}
}