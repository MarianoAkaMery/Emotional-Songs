package emotionalsongs;

import java.io.*;
import com.opencsv.*;
import java.util.*;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * Classe che permette la visualizzazione delle emozioni provate dopo l'ascolto di brani
 * 
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: 748240
 */

public class VisualizzaEmozioneBrano {

    static Scanner scan = new Scanner(System.in);
    
    /** 
     * @param args[]
     * @throws FileNotFoundException
     */
    public static void main(String args[])throws FileNotFoundException{  
        visualizzaEmozioneBrano();
    }

     /**
     * Funzione che permette di visualizzare le emozioni provate dagli utenti per un brano specifico
     * 
     * @throws FileNotFoundException File non trovato.
     */
    public static void visualizzaEmozioneBrano() throws FileNotFoundException{

    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

    CSVReader reader = new CSVReader(new FileReader("emotionalsongs.data.Emozioni.dati.csv"));
    
    /**
     * Variabili per inserire valutazioni delle emozioni.
     */
    try{
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
        String SongToFind;
        SongToFind = obj.readLine();
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

            String song=output[2].substring(1);
            if((song).equals(SongToFind)){
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

            System.out.println(" ");
            System.out.println("Prospetto delle emozioni provate dagli utenti per questo brano:\n");
            System.out.println("Voto Medio Stupore: " + (mediaAmazement) );
            System.out.println("Voto Medio Solennita':  " + (mediaSolemnity) );
            System.out.println("Voto Medio Brividi:  " + (mediaTenderness) );
            System.out.println("Voto Medio Nostalgia: " + (mediaNostalgia) );
            System.out.println("Voto Medio Calma: " + (mediaCalmness) );
            System.out.println("Voto Medio Potenza: " + (mediaPower) );
            System.out.println("Voto Medio Gioia: " + (mediaJoy) );
            System.out.println("Voto Medio Tensione: " + (mediaTension) );
            System.out.println("Voto Medio Tristezza: " + (mediaSadness) );
        }
    }
    catch (FileNotFoundException e) {
        System.out.println("ERRORE");
         
    }
    catch (Exception e) {
        System.out.println("ERRORE");
        e.printStackTrace();  
    }
    
    scan.close();

    } 
}
