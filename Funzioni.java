import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Funzioni {
    
    static Scanner scanner = new Scanner(System.in);
    static String pathSong = "Canzoni.dati.csv";
    static String pathPlaylist = "CreaPlaylistProva.csv";
    static Boolean registrare = false;


    public static void cercaBranoMusicale(){

        
        System.out.println("\nCosa si desidera fare?\n \n1- Ricerca per Brano\n \n2- Ricerca per Autore\n \n3- Ricerca per Anno\n \n");
        System.out.println("Scegliere un opzione (1, 2, 3):");
        int scelta = scanner.nextInt();
        
        switch(scelta){

            //ricerca per nome

            case 1: {
                try {


                    String [] nextLine;
                    String[] output;
                    String checkers;    
                    int SkipFirstLine=0;
                    int Counter=0;
                    CSVReader reader = new CSVReader(new FileReader(pathSong));

                    System.out.println("\nBrano da cercare:");
                    String SongToFind = scanner.next();
                    System.out.println("");



                    while ((nextLine = reader.readNext()) != null)

                    {
                       
                        checkers= Arrays.toString(nextLine);
                        output = checkers.split(",");
                        
                        if (SkipFirstLine!=0){
                            if (output[0].contains(SongToFind)){
                                System.out.println(output[0]);
                                Counter=Counter+1;
                                if(registrare = true){
                                    //registre anche sulla playlist
                                }
                            }
                                
                        }

                        SkipFirstLine+=1;
                    }     
                    
                    

                    Sleep.wait(3500);

                    if (Counter==0){
                        System.out.println("\nNessun brano corrispondente trovato\n");

                    }

                    Sleep.wait(3500);
                    System.out.println("\n");

                }

                catch (Exception e) {
                    System.out.println("File non trovato");
                    e.printStackTrace();  
                }

                break;
            }

            //ricerca per autore

            case 2:{
                try {

                    String [] nextLine;
                    String[] output;
                    String checkers;
                    int SkipFirstLine=0;
                    int Counter=0;
                    CSVReader reader = new CSVReader(new FileReader("Canzoni.dati.csv"));

                    System.out.println("Autore da cercare:");
                    String ArtistToFind = scanner.next();
                    System.out.println("");
    
                    while ((nextLine = reader.readNext()) != null)

                    {
                        checkers= Arrays.toString(nextLine);
                        output = checkers.split(",");
                        
                        if (SkipFirstLine!=0){
                            if (output[1].contains(ArtistToFind)){
                                System.out.println(output[0]);
                                Counter=Counter+1;
                            }
                        }

                        SkipFirstLine+=1;
                    } 

                    Sleep.wait(3500);

                    if (Counter==0){
                        System.out.println("\nNessun brano corrispondente trovato\n");

                    }

                    Sleep.wait(3500);
                    System.out.println("\n");


                }

                

                catch (Exception e) {
                    System.out.println("File non trovato");
                    e.printStackTrace();  
                }
                
                break;
            }

            //ricerca per anno

            case 3:{
                try {

                    String [] nextLine;
                    String[] output;
                    String checkers;
                    int SkipFirstLine=0;
                    int Counter=0;

                    CSVReader reader = new CSVReader(new FileReader("Canzoni.dati.csv"));

                    System.out.println("Anno da cercare:");
                    String YearsToFind = scanner.next();
                    System.out.println(" ");

    
                    while ((nextLine = reader.readNext()) != null)

                    {
                       
                        checkers= Arrays.toString(nextLine);
                        output = checkers.split(",");
                        
                        if (SkipFirstLine!=0){
                            if (output[2].contains(YearsToFind)){
                                System.out.println(output[0]);
                                Counter=Counter+1;
                            }
                                

                        }

                        SkipFirstLine+=1;
                    } 

                    Sleep.wait(3500);

                    if (Counter==0){
                        System.out.println("\nNessun brano corrispondente trovato\n");

                    }
                    
                    Sleep.wait(3500);
                    System.out.println("\n");


                }

                
                catch (Exception e) {
                    System.out.println("File non trovato");
                    e.printStackTrace();  
                }
                
                break;
            }

            default:{
                    System.out.println("Opzione non valida");
                
            }
        }        
    }

    public static void RegistraPlaylist(){
        
        
        int maxSong = 980;
        
        String buffer = "";
        String[] brani = new String[maxSong];
        String[] autori = new String[maxSong];
        String[] anno = new String[maxSong];
        
        int i=0;  //numero totale di canzoni nella lista
        
        try{
            
            BufferedReader br=new BufferedReader(new FileReader(pathSong));
            
            while((buffer = br.readLine()) != null){
                String[] val = buffer.split(",");

                brani[i]=val[0];
                autori[i]=val[1];
                anno[i]=val[2];

                i++;
            }

            System.out.println("\nQui potrai creare le tue playlist. Iniziamo!");
            System.out.println("Inserisci il tuo nome, così gli altri utenti sapranno che questa playlist è stata creata da te.");
            String nomeUtente = scanner.nextLine();
            System.out.println("\n");


            System.out.println("Inserisci il nome della playlist");
            String nomePlaylist = scanner.nextLine();
            System.out.println();


            System.out.println("Cosa si desidera fare?\n \n1- Comporre la playlist inserendo brani a tua scelta.\n \n2- Comporre la playlist inserendo tutti i brani di un autore a tua scelta.\n \n3- Comporre la playlist inserendo tutti i brani di anno a tua scelta.\n \n");
            System.out.println("Scegliere un opzione (1, 2, 3):");
            int Choise = scanner.nextInt();
            scanner.nextLine();

            
            //parte di creazione della playlist
            
            
            FileWriter fw = new FileWriter(pathPlaylist,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.println();
            pw.print(nomePlaylist);
            pw.println("\t" + nomeUtente);
            pw.println(brani[0] + "," + autori[0] + "," + anno[0]);
            
            
            boolean trovato=false;
            int k=1;
            String titolo="";
            
            //mettere canzoni singole
            switch (Choise){
                case 1:{

                    System.out.println("Inserisci le canzoni. Quando hai terminato l'inserimento digita\"0\"");

                    do{
                        System.out.println("Cerca il titolo della " + k +"^ canzone da inserire nella playlist");
                        titolo=scanner.nextLine();
                        
                        for(i=1;i<980;i++){
                            if(titolo.equals(brani[i])){
                                trovato=true;
                                pw.println(brani[i] + "," + autori[i] + "," + anno[i]);
                        } }
    
                        if(trovato==false){
                            System.out.println("Il brano cercato non esiste.");
                            Sleep.wait(3500);

                        }else{
                            System.out.println("Brano aggiunto alla playlist!");
                            Sleep.wait(3500);

                        }
                        if(titolo.equals("0")){
                            System.out.println("Inserimento terminato.");
                            Sleep.wait(3500);

                        }
                        
                        k++;
                        trovato=false;
                    }while(!(titolo.equals("0")));

                    break;

                }
    
    
                //mettere tutte le canzoni di autori
                
                case 2:{
                    
                    System.out.println("Inserisci il nome di un autore. Tutte le sue canzoni verranno aggiunte alla playlist.");
                    String nomedellAutore=scanner.nextLine();
                        
                    for(i=1;i<980;i++){
                        if(nomedellAutore.equals(autori[i])){
                            trovato=true;
                            pw.println(brani[i] + "," + autori[i] + "," + anno[i]);
                        }
                    }
                    
                    if(trovato==false){
                        System.out.println("Non c'è nessun brano dell'autore cercato");
                        Sleep.wait(3500);

                    }else{
                        System.out.println("Tutti i brani di " + nomedellAutore + " sono stati aggiunti alla playlist!");
                        Sleep.wait(3500);

                    }

                    break;
                }
    
    
                //mettere tutte le canzoni di un anno
    
                case 3:{
                    
                    System.out.println("Inserisci un anno di cui vuoi inserire tutte le canzoni nella playlist.");
                    String an=scanner.nextLine();
                        
                    for(i=1;i<980;i++){
                        if(an.equals(anno[i])){
                            trovato=true;
                            pw.println(brani[i] + "," + autori[i] + "," + anno[i]);
                        }
                    }
                    
                    if(trovato==false){
                        System.out.println("Non c'è nessun brano dell'anno cercato");
                        

                    }else{
                        System.out.println("Tutti i brani dell'anno " + an + " sono stati aggiunti alla playlist!");
                        

                    }

                    break;

                }

                default:{
                    System.out.println("\nScelta non valida\n");
                    

                    break;
                }

            }
            
            pw.flush();
            br.close();
            pw.close();
        
        }

        catch(FileNotFoundException e){
            System.out.println("File non trovato!");
            

        }

        catch(IOException e){
            System.out.println("Si è verificato un problema!");
            

        }

        catch(Exception e){
            System.out.println("Si è verificato un problema!");
         

        }

        
    }

    public static void inserisciEmozioniBrano(){
        //una volta loggato puoi accedere a questa funzione e cercare playlist e confrontare con nome utente se 
        //esiste iniziare
        //chiedere per ogni canzoni della playlist se e' si vuole inserire una emozione
    }

    public static void visualizzaEmozioneBrano(){
     /*una volta ricercato il brano, deve essere possibile selezionare il brano e visualizzare tutte
    le informazioni relative al brano selezionato. deve anche essere possibile visualizzare un prospetto riassuntivo delle emozioni
    associate a quel brano o l’indicazione che il brano ricercato non contiene emozioni inserite
    dagli utenti. Nel caso di presenza di tag emozionali per quel brano, si potranno
    visualizzare le emozioni associate dagli utenti, in forma aggregata, con il numero di utenti
    per ciascuna emozione e, ad esempio, la media del punteggio per ciascuna emozione,
    oltre agli eventuali commenti lasciati dagli utenti.
    */
    }

}




