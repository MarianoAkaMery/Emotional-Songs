package emotionalsongs;

import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * Classe per la ricerca di un brano tramite diversi parametri.
 * 
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: 748240
 */

public class CercaBrano {

    /**
     * Creazione oggetto "scanner" di tipo Scanner per inserimento da tastiera.
     */
    static Scanner scanner = new Scanner(System.in);
    
 
    
    /** 
     * @param args[]
     */
    public static void main(String args[]){  
        cercaBranoMusicale();
    }

    public static void cercaBranoMusicale(){

        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));   


        System.out.println("Cosa si desidera fare?\n \n1- Ricerca per Brano\n \n2- Ricerca per Autore\n \n3- Ricerca per Anno\n");
        System.out.println("Scegliere un opzione (1, 2 o 3):");
        /**
         * Permette di scegliere in base a quale parametro effettuare la ricerca
         */
        int scelta = scanner.nextInt();
        
        
        switch(scelta){
            /**
             * Ricerca per nome brano.
             */
            case 1: {
                try {

                    /**
                     * Array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
                     */
                    String [] nextLine;
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
                     * Permette di saltare la prima riga del file.
                     */  
                    int SkipFirstLine=0;
                    CSVReader reader = new CSVReader(new FileReader("emotionalsongs.data.Canzoni.dati.csv"));

                    System.out.println("Brano da cercare:");
                    String SongToFind;
                    SongToFind = obj.readLine();



                    while ((nextLine = reader.readNext()) != null)

                    {
                       
                        checkers= Arrays.toString(nextLine);
                        output = checkers.split(",");
                        
                        if (SkipFirstLine!=0){
                            String song=output[0];
                            if (song.contains(SongToFind)){
                                System.out.println("La canzone:  " + "-" + output[0].replace("[", "") + "  è presente nel Data Set");
                            }
                                
                        }
                        SkipFirstLine+=1;
                    }     
                    
                    Sleep.wait(3500);
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

                    /**
                     * Crea un array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
                    */
                    String [] nextLine;
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
                     * Permette di saltare la prima riga del file.
                     */ 
                    int SkipFirstLine=0;
                    CSVReader reader = new CSVReader(new FileReader("emotionalsongs.data.Canzoni.dati.csv"));

                    System.out.println("Autore da cercare:");
                    String SongToFind = scanner.next();
    
                    while ((nextLine = reader.readNext()) != null)

                    {
                       
                        checkers= Arrays.toString(nextLine);
                        output = checkers.split(",");
                        
                        if (SkipFirstLine!=0){
                            if (output[1].contains(SongToFind)){
                                System.out.println("-" +output[0].replace("[", ""));
                            }
                                
                        }
                        SkipFirstLine+=1;
                    } 

                    Sleep.wait(3500);

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
                    /**
                     * Crea un array di tipo String che conterra' ad ogni ciclo una riga del file selezionato.
                     */
                    String [] nextLine;
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
                     * Permette di saltare la prima riga del file.
                     */ 
                    int SkipFirstLine=0;
                    CSVReader reader = new CSVReader(new FileReader("emotionalsongs.data.Canzoni.dati.csv"));

                    System.out.println("Anno da cercare:");
                    String SongToFind = scanner.next();
    
                    while ((nextLine = reader.readNext()) != null)

                    {
                       
                        checkers= Arrays.toString(nextLine);
                        output = checkers.split(",");
                        
                        if (SkipFirstLine!=0){
                            if (output[2].contains(SongToFind)){
                                System.out.println("-" +output[0].replace("[", ""));
                            }

                                
                        }
                        SkipFirstLine+=1;
                    } 

                    Sleep.wait(3500);

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
                
                System.out.println("elemento non trovato");
                
                
            }
        }


        
        }
        
    }