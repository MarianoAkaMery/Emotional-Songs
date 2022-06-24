import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.util.*;
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
    static String pathEmozioni = "Emozioni.dati.csv";
    public static void cercaBranoMusicale(){

        try{

            FileWriter fw = new FileWriter(pathPlaylist,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            System.out.println("\nCosa si desidera fare?\n \n1- Ricerca per Brano\n \n2- Ricerca per Autore\n \n3- Ricerca per Anno\n\n");
            System.out.println("Scegliere un opzione (1, 2, 3):");
            int scelta = scanner.nextInt();
            String nomePlaylist = "";

        switch(scelta){

            //ricerca per nome
            
            case 1: {
                
                try {
                    
                    if(registrare ==  true){
                        System.out.println("\nQui potrai creare le tue playlist. Iniziamo!");
                        System.out.println("Inserisci il nome della playlist");
                        nomePlaylist = scanner.next(); 

                    }

                    String [] nextLine;
                    String[] output;
                    String checkers;    
                    Boolean Counter = false;
                    CSVReader reader = new CSVReader(new FileReader(pathSong));

                    System.out.println("\nBrano da cercare:");
                    String SongToFind = scanner.next();
                    System.out.println("");

                    while ((nextLine = reader.readNext()) != null){
                       
                        checkers= Arrays.toString(nextLine).replace("[", "").replace("]", "");
                        
                        output = checkers.split(",");
                        
                        if (output[0].contains(SongToFind)){
                                System.out.println(output[0]);
                                Counter = true;
                                if(registrare == true){
                                    
                                    pw.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + output[0] + "," + output[1] + "," + output[2]);
                                }
                            }
                    }     
                    if (Counter == false){
                        System.out.println("\nNessun brano corrispondente trovato\n");

                    }

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
                    if(registrare ==  true){
                        System.out.println("\nQui potrai creare le tue playlist. Iniziamo!");
                        System.out.println("Inserisci il nome della playlist");
                        nomePlaylist = scanner.next();  
                    }
                    String [] nextLine;
                    String[] output;
                    String checkers;
                    Boolean Counter = false;
                    CSVReader reader = new CSVReader(new FileReader(pathSong));

                    System.out.println("Autore da cercare:");
                    String ArtistToFind = scanner.next();
                    System.out.println("");
    
                    while ((nextLine = reader.readNext()) != null)

                    {
                        checkers= Arrays.toString(nextLine).replace("[", "").replace("]", "");
                        output = checkers.split(",");
                        
                            if (output[1].contains(ArtistToFind)){
                                System.out.println(output[0]);
                                Counter = true;
                                if(registrare == true){
                                    pw.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + output[0] + "," + output[1] + "," + output[2]);}
                            }
                    } 

                    Sleep.wait(3500);

                    if (Counter == false){
                        System.out.println("\nNessun brano corrispondente trovato\n");

                    }


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
                    if(registrare ==  true){
                        System.out.println("\nQui potrai creare le tue playlist. Iniziamo!");
                        System.out.println("Inserisci il nome della playlist");
                        nomePlaylist = scanner.next();  
                    }
                    String [] nextLine;
                    String[] output;
                    String checkers;
                    Boolean Counter = false;

                    CSVReader reader = new CSVReader(new FileReader(pathSong));

                    System.out.println("Anno da cercare:");
                    String YearsToFind = scanner.next();
                    System.out.println(" ");

    
                    while ((nextLine = reader.readNext()) != null)

                    {
                       
                        checkers= Arrays.toString(nextLine).replace("[", "").replace("]", "");
                        output = checkers.split(",");
                        
                            if (output[2].contains(YearsToFind)){
                                System.out.println(output[0]);
                                Counter = true;
                                if(registrare == true){
                                    pw.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + output[0] + "," + output[1] + "," + output[2]);}
                            }

                    } 

                    Sleep.wait(3500);

                    if (Counter == false){
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
        pw.flush();
        bw.close();
        pw.close();
    
      } catch(FileNotFoundException e){
            System.out.println("File non trovato!");
            

        }

        catch(IOException e){
            System.out.println("Si è verificato un problema!");
            

        }

        catch(Exception e){
            System.out.println("Si è verificato un problema!");
         

        }  
    }

    public static void RegistraPlaylist(){
        
        try{
            
            registrare=true;
            cercaBranoMusicale();

        }catch(Exception e){
            System.out.println("Si è verificato un problema!");
        }
    }
       

    public static void inserisciEmozioniBrano() throws IOException, CsvValidationException{
        //una volta loggato puoi accedere a questa funzione e cercare playlist e confrontare con nome utente se 
        //esiste iniziare
        //chiedere per ogni canzoni della playlist se e' si vuole inserire una emozione
        FileWriter fw = new FileWriter(pathEmozioni,true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        
        CSVReader reader = new CSVReader(new FileReader(pathPlaylist));
                String [] nextLine;
                String[] output;
                String checkers;
                    
                System.out.println("Nome Playlist registrata in precedenza da cercare:");
                String nomePlaylist2String = scanner.next();

                    while ((nextLine = reader.readNext()) != null)
                    {
                        checkers= Arrays.toString(nextLine).replace("[", "").replace("]", "");
                        output = checkers.split(",");
                            if (output[0].equals(EmotionalSongs.nomeUtente)){

                                if(output[1].contains(nomePlaylist2String)){
                                    //chiedere se si vuole inserire emozione per canzone
                                    System.out.println("4");
                                    //file emozione nome-playlist-canzone-emozioni
                                    System.out.println("Vuoi inseire emozioni per la canzone" + output[2]);
                                    System.out.println("1-Si,0-No");
                                    int decisione = scanner.nextInt();
                                    int risposta = 0;
                                    if( decisione == 1){
                                        System.out.println("Dare valutazioni da 1 a 5 per le seguenti emozioni provate");
                                        //3 Amazemant
                                        do{
                                            System.out.println("Amazemant,Amazement Feeling of wonder or happiness");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Amazemant = String.valueOf(risposta);

                                        //4 Solemnity
                                        do{
                                            System.out.println("Solemnity Feeling of transcendence, inspiration. Thrills.");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Solemnity = String.valueOf(risposta);

                                        //5 Tenderness
                                        do{
                                            System.out.println("Solemnity Feeling of transcendence, inspiration. Thrills.");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Tenderness = String.valueOf(risposta);
                                        
                                        //6 Nostalgia
                                        do{
                                            System.out.println("Solemnity Feeling of transcendence, inspiration. Thrills.");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Nostalgia = String.valueOf(risposta);

                                        //7 Calmness
                                        do{
                                            System.out.println("Solemnity Feeling of transcendence, inspiration. Thrills.");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Calmness = String.valueOf(risposta);

                                        //8 Power
                                        do{
                                            System.out.println("Solemnity Feeling of transcendence, inspiration. Thrills.");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Power = String.valueOf(risposta);

                                        //9 Joy
                                        do{
                                            System.out.println("Solemnity Feeling of transcendence, inspiration. Thrills.");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Joy = String.valueOf(risposta);

                                        //10 Tension
                                        do{
                                            System.out.println("Solemnity Feeling of transcendence, inspiration. Thrills.");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Tension = String.valueOf(risposta);
                                        
                                        //11 Sadness
                                        do{
                                            System.out.println("Solemnity Feeling of transcendence, inspiration. Thrills.");
                                            risposta = scanner.nextInt();
                                        }while(risposta<1 && risposta >5);
                                        String Sadness = String.valueOf(risposta);

                                        pw.println(EmotionalSongs.nomeUtente+","+nomePlaylist2String+","+output[2]+","+Amazemant+","+Solemnity+","+Tenderness+","+Nostalgia + "," + Calmness + "," + Power + "," + Joy + "," + Tension+ "," + Sadness);}
                                        pw.flush();
                                   
                                   
                                    } 
                                    
                                    }
                                    
                                }
                               
                                

                    
                    bw.close();
                    pw.close();             
        
    }

    public static void visualizzaEmozioneBrano() throws CsvValidationException, NumberFormatException, IOException{
     /*una volta ricercato il brano, deve essere possibile selezionare il brano e visualizzare tutte
    le informazioni relative al brano selezionato. deve anche essere possibile visualizzare un prospetto riassuntivo delle emozioni
    associate a quel brano o l’indicazione che il brano ricercato non contiene emozioni inserite
    dagli utenti. Nel caso di presenza di tag emozionali per quel brano, si potranno
    visualizzare le emozioni associate dagli utenti, in forma aggregata, con il numero di utenti
    per ciascuna emozione e, ad esempio, la media del punteggio per ciascuna emozione,
    oltre agli eventuali commenti lasciati dagli utenti.

    cioe ricerca nel brano nel file emozioni e per ogni emozione numero di utenti e media voto
    */
    CSVReader reader = new CSVReader(new FileReader(pathEmozioni));
    int votoAmazement = 0;
    int votoSolemnity = 0;
    int votoTenderness = 0;
    int votoNostalgia = 0;
    int votoCalmness = 0;
    int votoPower = 0;
    int votoJoy = 0;
    int votoTension = 0;
    int votoSadness = 0;
    int numeroPersone = 0;

        System.out.println("Brano da cercare:");
        String brano = scanner.nextLine();
        String [] nextLine;
        String[] output;
        String checkers;

        while ((nextLine = reader.readNext()) != null)
        {
            checkers= Arrays.toString(nextLine).replace("[", "").replace("]", "");
            output = checkers.split(",");

            if(output[2].contains(brano)){
                
                votoAmazement += Integer.parseInt(output[3].trim());;
                votoSolemnity += Integer.parseInt(output[4].trim());
                votoTenderness += Integer.parseInt(output[5].trim());
                votoNostalgia += Integer.parseInt(output[6].trim());
                votoCalmness += Integer.parseInt(output[7].trim());
                votoPower += Integer.parseInt(output[8].trim());
                votoJoy += Integer.parseInt(output[9].trim());
                votoTension += Integer.parseInt(output[10].trim());
                votoSadness += Integer.parseInt(output[11].trim());
                numeroPersone++;}

            }

    
  
    if(numeroPersone == 0){
        System.out.println("Nessuno ha inserito emozioni per questo brano");
    }
    else{
        float mediaAmazement = votoAmazement/numeroPersone;
        float mediaSolemnity = votoSolemnity/numeroPersone;
        float mediaTenderness = votoTenderness/numeroPersone;
        float mediaNostalgia = votoNostalgia/numeroPersone;
        float mediaCalmness = votoCalmness/numeroPersone;
        float mediaPower = votoPower/numeroPersone;
        float mediaJoy =votoJoy/numeroPersone;
        float mediaTension = votoTension/numeroPersone;
        float mediaSadness = votoSadness/numeroPersone;

        System.out.println("Prospetto delle emozioni provate dagli utenti per questo brano");
        System.out.println("Voto Medio Stupore" + (mediaAmazement) );
        System.out.println("Voto Medio Solennita'" + (mediaSolemnity) );
        System.out.println("Voto Medio Brividi" + (mediaTenderness) );
        System.out.println("Voto Medio Nostalgia" + (mediaNostalgia) );
        System.out.println("Voto Medio Calma" + (mediaCalmness) );
        System.out.println("Voto Medio Potenza" + (mediaPower) );
        System.out.println("Voto Medio Gioia" + (mediaJoy) );
        System.out.println("Voto Medio Tensione" + (mediaTension) );
        System.out.println("Voto Medio Tristezza" + (mediaSadness) );
    }
    

}

}