import java.util.*;
/**All’avvio l’applicazione mostra un menu iniziale dove:
Tutti possono:
• cercare brani con titolo, autore, anno
• visualizzare le emozioni associate a ciascuna canzone selezionata
• registrarsi al’applicazione
Gli utenti registrati possono:
• creare playlist
• inserire le emozioni provate all’ascolto di determinate canzoni*/

public class EmotionalSongs extends Registrazione{

    static Scanner scan=new Scanner(System.in);

    public static void DisplayMeny(){
        boolean continua = true;

        while(continua==true){
            System.out.println("Benvenuti in EmotionaSongs\n");
            System.out.println("Cosa si desidera fare?\n \n1- Cercare Brano\n \n2- Visualizzare Emozoni\n \n3- Registrazione\n \n4- Login\n \n5- Close\n \n");
            System.out.println("Scegliere un opzione (1, 2, 3, 4, 5, 6):");
            int Choise=scan.nextInt();
            scan.nextLine();

            switch(Choise){
                case 1: {
                    System.out.println("Benvenuti in EmotionaSongs");
                    break;
                }
                case 2:{
                    System.out.println("Benvenuti in EmotionaSongs");
                    break;
                }
                case 3:{
                    RegistrazioneNew();
                    break;
                }
                case 4:{
                    System.out.println("Login Part");
                    Boolean Login=true;

                    if (Login==true){

                            System.out.println("Benvenuto XXXXXX\n \n");
                            System.out.println("Cosa si desidera fare?\n \n1- Creare Playlist\n \n2- Inserire emozioni\n \n");
                            System.out.println("Scegliere un opzione (1 o 2):");
                            int LoggedChoise=scan.nextInt();
                            scan.nextLine();

                            switch(LoggedChoise){
                                case 1:{
                                    System.out.println("Benvenuti in EmotionaSongs");
                                    break;
                                }
                                case 2:{
                                    System.out.println("Benvenuti in EmotionaSongs");
                                    break;
                                }
                            }
                    }
                    break;
                }
                case 5:{
                    continua = false;
                    break;
                }
                default:{
                    System.out.println("\nScelta non valida");
                    break;
                }
            }
        }   
    }



    public static void main(String[] args){
        boolean ContinuaMenu=true;
        while(ContinuaMenu==true){
            DisplayMeny();
        }
}
}
