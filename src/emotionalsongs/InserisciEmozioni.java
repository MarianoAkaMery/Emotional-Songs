package emotionalsongs;

import com.opencsv.CSVReader;
import java.util.*;
import java.io.*;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * 
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: 748240
 */

public class InserisciEmozioni {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]){  
        inserisciEmozioniBrano();
    }

    public static void inserisciEmozioniBrano(){

        try{
            FileWriter fileWriter = new FileWriter("emotionalsongs.data.Emozioni.dati.csv",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        
        CSVReader reader = new CSVReader(new FileReader("emotionalsongs.data.CreaPlaylist.csv"));
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
       
        System.out.println("Nome Playlist registrata in precedenza da cercare:");
        nomePlaylist = scanner.next();
        int cont = 0;
        while ((nextLinea = reader.readNext()) != null){
            
            checkers= Arrays.toString(nextLinea).replace("[", "").replace("]", "");
            output = checkers.split(",");

            if (output[0].equals(EmotionalSongs.nomeUtente)){

                if(output[1].equals(" "+nomePlaylist)){

                    cont++;
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

                        printWriter.println(EmotionalSongs.nomeUtente+","+nomePlaylist+","+output[2].substring(1)+","+Amazemant+","+Solemnity+","+Tenderness+","+Nostalgia + "," + Calmness + "," + Power + "," + Joy + "," + Tension+ "," + Sadness);
                    }
                        printWriter.flush();                      
                    }else{
                        
                    }                          
                }                                   
            } 
            if(cont == 0){
                System.out.println("Nessuna Playlist creata da " + EmotionalSongs.nomeUtente+ " con il nome "+nomePlaylist);
            }                
            bufferedWriter.close();
            printWriter.close();  

            

        }
        catch (Exception e) {
            System.out.println("File non trovato");
            e.printStackTrace();  
        }
    }
}
