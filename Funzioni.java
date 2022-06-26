import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;
import java.util.*;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: XXXXXX
 */

public class Funzioni {
    
    /**
     * Creazione oggetto "scanner" di tipo Scanner per inserimento da tastiera.
     */
    static Scanner scanner = new Scanner(System.in);
    /**
     * Path del file dove sono salvate tutti i brani.
     */
    static String pathSong = "Canzoni.dati.csv";
    /**
     * Path del file dove sono salvate le playlist.
     */
    static String pathPlaylist = "CreaPlaylist.csv";
    /**
     * Path del file dove sono salvate tutte emozioni provate durante l'ascolto dei brani.
     */
    static String pathEmozioni = "Emozioni.dati.csv";
    /**
     * Permette di registrare le playlist se uguale a "true".
     */
    static Boolean registrarePlaylist = false;

    /**
     * Funzione che permette di ricercare nel file "Canzoni.dati.csv".
     */
    public static void cercaBranoMusicale(){

        try{
            FileWriter fileWriter = new FileWriter(pathPlaylist,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            System.out.println("\nCosa si desidera fare?\n \n1- Ricerca per Brano\n \n2- Ricerca per Autore\n \n3- Ricerca per Anno\n\n");
            System.out.println("Scegliere un opzione (1, 2, 3):");
            /**
             * Permette di scegliere in base a quale parametro effettuare la ricerca
             */
            int scelta = scanner.nextInt();
            String nomePlaylist = "";

        switch(scelta){

            /**
             * Permette di cercare un brano in base al nome.
             */
            
            case 1: {
                
                try {
                    
                    if(registrarePlaylist ==  true){
                        System.out.println("\nQui potrai creare le tue playlist. Iniziamo!");
                        System.out.println("Inserisci il nome della playlist");
                        nomePlaylist = scanner.next(); 
                    }

                    /**
                     * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
                     */
                    String [] nextLinea;
                    /**
                     * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato diviso in "blocchi" 
                     * prendendo come divisione tra i vari blocchi il carattere ",".
                     */
                    String[] output;
                    /**
                     * String che permette la divisione in blocchi tramite la funzione split().
                     */
                    String checkers;  
                    /**
                     * Boolean che se uguale a false avvisa che nessun brano e' stato trovato.
                     */  
                    Boolean branoNonTrovato = false;
                    CSVReader reader = new CSVReader(new FileReader(pathSong));

                    System.out.println("\nBrano da cercare:");
                    String branoDaTrovare = scanner.next();
                    System.out.println("");

                    while ((nextLinea = reader.readNext()) != null){
                       
                        checkers= Arrays.toString(nextLinea).replace("[", "").replace("]", "");  
                        output = checkers.split(",");
                        
                        if (output[0].contains(branoDaTrovare)){
                                System.out.println(output[0]);
                                branoNonTrovato = true;
                                if(registrarePlaylist == true){
                                    
                                    printWriter.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + output[0] + "," + output[1] + "," + output[2]);
                                }
                            }
                    }     
                    if (branoNonTrovato == false){
                        System.out.println("\nNessun brano corrispondente trovato\n");

                    }

                }

                catch (Exception e) {
                    System.out.println("File non trovato");
                    e.printStackTrace();  
                }

                break;
            }

            /**
             * Permette di cercare un brano in base all'autore.
             */

            case 2:{

                try {
                    if(registrarePlaylist ==  true){
                        System.out.println("\nQui potrai creare le tue playlist. Iniziamo!");
                        System.out.println("Inserisci il nome della playlist");
                        nomePlaylist = scanner.next();  
                    }

                    /**
                     * Crea un array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
                    */
                    String [] nextLinea;
                    /**
                     * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato diviso in "blocchi" 
                     * prendendo come divisione tra i vari blocchi il carattere ",".
                     */
                    String[] output;
                    /**
                     * String che permette la divisione in blocchi tramite la funzione split().
                     */
                    String checkers;
                    /**
                     * Boolean che se uguale a false avvisa che nessun brano e' stato trovato.
                     */
                    Boolean branoNonTrovato = false;
                    CSVReader reader = new CSVReader(new FileReader(pathSong));

                    System.out.println("Autore da cercare:");
                    String artistaDaTrovare = scanner.next();
                    System.out.println("");
    
                    while ((nextLinea = reader.readNext()) != null)

                    {
                        checkers= Arrays.toString(nextLinea).replace("[", "").replace("]", "");
                        output = checkers.split(",");
                        
                            if (output[1].contains(artistaDaTrovare)){
                                System.out.println(output[0]);
                                branoNonTrovato = true;
                                if(registrarePlaylist == true){
                                    printWriter.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + output[0] + "," + output[1] + "," + output[2]);}
                            }
                    } 

                    if (branoNonTrovato == false){
                        System.out.println("\nNessun brano corrispondente trovato\n");
                    }

                }
                catch (Exception e) {
                    System.out.println("File non trovato");
                    e.printStackTrace();  
                }
                break;
            }

            /**
             * Permette di cercare un brano in base all'anno di pubblicazione.
             */

            case 3:{
                try {

                    if(registrarePlaylist ==  true){
                        System.out.println("\nQui potrai creare le tue playlist. Iniziamo!");
                        System.out.println("Inserisci il nome della playlist");
                        nomePlaylist = scanner.next();  
                    }

                    /**
                     * Crea un array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
                     */
                    String [] nextLinea;
                    /**
                     * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato diviso in "blocchi" 
                     * prendendo come divisione tra i vari blocchi il carattere ",".
                     */
                    String[] output;
                    /**
                     * String che permette la divisione in blocchi tramite la funzione split().
                     */
                    String checkers;
                    /**
                     * Boolean che se uguale a false avvisa che nessun brano e' stato trovato.
                     */
                    Boolean branoNonTrovato = false;

                    CSVReader reader = new CSVReader(new FileReader(pathSong));

                    System.out.println("Anno da cercare:");
                    String annoDaTrovare = scanner.next();
                    System.out.println(" ");

                    while ((nextLinea = reader.readNext()) != null)

                    {
                       
                        checkers= Arrays.toString(nextLinea).replace("[", "").replace("]", "");
                        output = checkers.split(",");
                        
                            if (output[2].contains(annoDaTrovare)){
                                System.out.println(output[0]);
                                branoNonTrovato = true;
                                if(registrarePlaylist == true){
                                    printWriter.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + output[0] + "," + output[1] + "," + output[2]);}
                            }

                    } 

                    if (branoNonTrovato == false){
                        System.out.println("\nNessun brano corrispondente trovato\n");

                    }
                    
                }

                
                catch (Exception e) {
                    System.out.println("File non trovato");
                    e.printStackTrace();  
                }
                
                break;
            }
            
            /**
             * Se inserito un valore non valido, permette di inserne uno nuovo.
             */
            default:{
                    System.out.println("Opzione non valida");
            }
        } 

        printWriter.flush();
        bufferedWriter.close();
        printWriter.close();
    
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

    /**
     * Funzione alla quale si puo' accedere solamente  dopo essersi loggati nell'applicazione e permette di 
     * registrare una playlist musicale.
     */
    public static void RegistraPlaylist(){
        
        try{
            
            registrarePlaylist = true;
            cercaBranoMusicale();

        }catch(Exception e){
            System.out.println("Si è verificato un problema!");
        }
    }
    
    /**
     * Funzione alla quale si puo' accedere solamente dopo essersi loggati nell'applicazione e dopo
     * aver creato almeno una playlist con almeno una canzone, permette di inserire emozioni provate 
     * durante l'ascolto di uno o piu' brani.
     * @throws IOException
     * @throws CsvValidationException
     */
    public static void inserisciEmozioniBrano() throws IOException, CsvValidationException{

        FileWriter fileWriter = new FileWriter(pathEmozioni,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        
        CSVReader reader = new CSVReader(new FileReader(pathPlaylist));
        /**
         * Crea un array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
         */
        String [] nextLinea;
        /**
         * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato diviso in "blocchi" 
         * prendendo come divisione tra i vari blocchi il carattere ",".
         */
        String[] output;
        /**
         * String che permette la divisione in blocchi tramite la funzione split().
         */
        String checkers;
        /**
         *  Inserimento del nome della playlist
         */
        String nomePlaylist = "";
        do{
        System.out.println("Nome Playlist registrata in precedenza da cercare:");
        nomePlaylist = scanner.next();}while(!(nomePlaylist == ""));

        while ((nextLinea = reader.readNext()) != null){
            
            checkers= Arrays.toString(nextLinea).replace("[", "").replace("]", "");
            output = checkers.split(",");
            
            if (output[0].equals(EmotionalSongs.nomeUtente)){

                if(output[1].contains(nomePlaylist)){

                    System.out.println("Vuoi inserire emozioni per la canzone" + output[2]);
                    System.out.println("X per inserire emozioni, altro per non inserire.");
                    /**
                     * Ad ogni ciclo (while) viene chiesto se inserire emozioni riguardo al brano corrente.
                     */
                    int decisione = scanner.next().charAt(0);
                    int risposta = 0;

                    if( decisione == 'X'){
                        
                        System.out.println("Dare valutazioni da 1 a 5 per le seguenti emozioni provate.");
                        /**
                         * Ciclo riguardante emozione: Amazemant
                         */
                        do{
                            System.out.println("Stupore: Sensazione di meraviglia o felicità.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Amazemant = String.valueOf(risposta);

                        /**
                         * Ciclo riguardante emozione: Solemnity
                         */
                        do{
                            System.out.println("Solennità: Sensazione di trascendenza, ispirazione.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Solemnity = String.valueOf(risposta);                

                        /**
                         * Ciclo riguardante emozione: Tenderness
                         */
                        do{
                            System.out.println("Brividi: Tenerezza Sensualità, affetto, sentimento d'amore.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Tenderness = String.valueOf(risposta);

                        /**
                         * Ciclo riguardante emozione: Nostalgia
                         */            
                        do{
                            System.out.println("Nostalgia; Sentimenti sognanti, malinconici e sentimentali.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Nostalgia = String.valueOf(risposta);

                        /**
                         * Ciclo riguardante emozione: Calmness
                         */
                        do{
                            System.out.println("Calma: Rilassamento, serenità, meditazione.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Calmness = String.valueOf(risposta);

                        /**
                         * Ciclo riguardante emozione: Power
                         */
                        do{
                            System.out.println("Potenza: Sentirsi forte, eroico, trionfante, energico.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Power = String.valueOf(risposta);

                        /**
                         * Ciclo riguardante emozione: Joy
                         */
                        do{
                            System.out.println("Gioia: Sensazione di ballare, di rimbalzare, di essere animati, di divertirsi.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Joy = String.valueOf(risposta);

                        /**
                         * Ciclo riguardante emozione: Tension
                         */
                        do{
                            System.out.println("Tensione: Sensazione di nervosismo, impazienza, irritazione.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Tension = String.valueOf(risposta);

                        /**
                         * Ciclo riguardante emozione: Sadness
                         */                                        
                        do{
                            System.out.println("Tristezza: Sensazione di depressione, tristezza.");
                            risposta = scanner.nextInt();
                        }while(risposta > 5 || risposta == 0);
                        String Sadness = String.valueOf(risposta);

                        printWriter.println(EmotionalSongs.nomeUtente+","+nomePlaylist+","+output[2]+","+Amazemant+","+Solemnity+","+Tenderness+","+Nostalgia + "," + Calmness + "," + Power + "," + Joy + "," + Tension+ "," + Sadness);
                    }
                        printWriter.flush();                      
                    }                                  
                }                                   
            }                 
            bufferedWriter.close();
            printWriter.close();             
    }

    /**
     * Funzione che permette di visualizzare le emozioni provate dagli utenti per un brano specifico
     * @throws CsvValidationException
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void visualizzaEmozioneBrano() throws CsvValidationException, NumberFormatException, IOException{

    CSVReader reader = new CSVReader(new FileReader(pathEmozioni));
    
    /**
     * Variabili per inserire valutazioni delle emozioni.
     */
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
    /**
     * Crea un array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
     */
    String [] nextLinea;
    /**
     * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato diviso in "blocchi" 
     * prendendo come divisione tra i vari blocchi il carattere ",".
     */
    String[] output;
    /**
     * String che permette la divisione in blocchi tramite la funzione split().
     */
    String checkers;

    while ((nextLinea = reader.readNext()) != null){

        checkers= Arrays.toString(nextLinea).replace("[", "").replace("]", "");
        output = checkers.split(",");

        if(output[2].equals(brano)){
            /**
             * Per ogni ciclo somma il voto di ogni emozione, e il contatore del numero di persone
             */
            votoAmazement += Integer.parseInt(output[3].trim());;
            votoSolemnity += Integer.parseInt(output[4].trim());
            votoTenderness += Integer.parseInt(output[5].trim());
            votoNostalgia += Integer.parseInt(output[6].trim());
            votoCalmness += Integer.parseInt(output[7].trim());
            votoPower += Integer.parseInt(output[8].trim());
            votoJoy += Integer.parseInt(output[9].trim());
            votoTension += Integer.parseInt(output[10].trim());
            votoSadness += Integer.parseInt(output[11].trim());
            numeroPersone++;
        }

    }

    if(numeroPersone == 0){
        System.out.println("Nessuno ha inserito emozioni per questo brano");
    }
    else{
        /**
         * Calcola la media di ogni emozione.
         */
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