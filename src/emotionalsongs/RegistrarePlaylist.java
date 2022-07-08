package emotionalsongs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * Classe che permette di registrare playlist
 * 
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: 748240
 */

public class RegistrarePlaylist{

    public static void main(String args[]){  
        RegistraPlaylist();
    }

    /**
     * Funzione alla quale si puo' accedere solamente  dopo essersi loggati nell'applicazione e permette di 
     * registrare una playlist musicale.
     */
    public static void RegistraPlaylist(){
        /**
         * Path del file dove sono salvate tutti i brani.
         */
        String path1="emotionalsongs.data.Canzoni.dati.csv";
        /**
         * Path del file dove sono salvate le playlist.
         */       
        String path2="emotionalsongs.data.CreaPlaylist.csv";
        /**
         * Stringa che permette di leggere una riga da file
         */
        String line="";
        Scanner scan=new Scanner(System.in);

        String[] brani=new String[980];
        String[] autori=new String[980];
        String[] anno=new String[980];
        /**
         * Conta il numero di canzoni totali
         */
        int i=0;  
        
        try{
            
            BufferedReader br=new BufferedReader(new FileReader(path1));
            
            while((line=br.readLine())!=null){
                String[] val=line.split(",");

                brani[i]=val[0];
                autori[i]=val[1];
                anno[i]=val[2];

                i++;
            }

            System.out.println("\nQui potrai creare le tue playlist. Iniziamo!");
            System.out.println("Inserisci il nome della playlist");
            String nomePlaylist=scan.nextLine();
            System.out.println();

            System.out.println("Cosa si desidera fare?\n \n1- Comporre la playlist inserendo brani a tua scelta.\n \n2- Comporre la playlist inserendo tutti i brani di un autore a tua scelta.\n \n3- Comporre la playlist inserendo tutti i brani di anno a tua scelta.\n \n");
            System.out.println("Scegliere un opzione (1, 2, 3):");
            int Choise=scan.nextInt();
            scan.nextLine();
            
            FileWriter fw = new FileWriter(path2,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);


            boolean trovato=false;
            int k=1;
            String titolo="";
            
            /**
             * Permette di cercare un brano in base al nome.
             */
            switch (Choise){
                case 1:{

                    System.out.println("Inserisci le canzoni. Quando hai terminato l'inserimento digita\"0\"");

                    do{
                        System.out.println("Cerca il titolo della " + k +"^ canzone da inserire nella playlist");
                        titolo=scan.nextLine();
                        
                        for(i=1;i<980;i++){
                            if(titolo.equals(brani[i])){
                                trovato=true;
                                
                                pw.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + brani[i] + "," + autori[i] + "," + anno[i]);
                            }
                        }
    
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
    
    
                /**
                 * Permette di cercare un brano in base all'autore.
                 */
                 case 2:{
                    
                    System.out.println("Inserisci il nome di un autore. Tutte le sue canzoni verranno aggiunte alla playlist.");
                    String nomedellAutore=scan.nextLine();
                        
                    for(i=1;i<980;i++){
                        if(nomedellAutore.equals(autori[i])){
                            trovato=true;
                            pw.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + brani[i] + "," + autori[i] + "," + anno[i]);
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
    
    
                /**
                 * Permette di cercare un brano in base all'anno di pubblicazione.
                 */
    
                case 3:{
                    
                    System.out.println("Inserisci un anno di cui vuoi inserire tutte le canzoni nella playlist.");
                    String an=scan.nextLine();
                        
                    for(i=1;i<980;i++){
                        if(an.equals(anno[i])){
                            trovato=true;
                            pw.println(EmotionalSongs.nomeUtente+ "," + nomePlaylist+ "," + brani[i] + "," + autori[i] + "," + anno[i]);
                        }
                    }
                    
                    if(trovato==false){
                        System.out.println("Non c'è nessun brano dell'anno cercato");
                        Sleep.wait(3500);

                    }else{
                        System.out.println("Tutti i brani dell'anno " + an + " sono stati aggiunti alla playlist!");
                        Sleep.wait(3500);

                    }

                    break;

                }

                default:{
                    System.out.println("\nScelta non valida\n");
                    Sleep.wait(3500);

                    break;
                }

            }
            
            pw.flush();
            br.close();
            pw.close();
        
        }

        catch(FileNotFoundException e){
            System.out.println("File non trovato!");
            Sleep.wait(3500);

        }

        catch(IOException e){
            System.out.println("Si è verificato un problema!");
            Sleep.wait(3500);

        }

        catch(Exception e){
            System.out.println("Si è verificato un problema!");
            Sleep.wait(3500);

        }

        
        scan.close();
    }
}