import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class RegistraPlaylist{

    public static void Registra(){
        
        Scanner scan = new Scanner(System.in);
        int maxSong = 980;
        String pathSong = "Canzoni.dati.csv";
        String pathPlaylist = "CreaPlaylistProva.csv";
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
            String nomeUtente = scan.nextLine();
            System.out.println("\n");


            System.out.println("Inserisci il nome della playlist");
            String nomePlaylist = scan.nextLine();
            System.out.println();


            System.out.println("Cosa si desidera fare?\n \n1- Comporre la playlist inserendo brani a tua scelta.\n \n2- Comporre la playlist inserendo tutti i brani di un autore a tua scelta.\n \n3- Comporre la playlist inserendo tutti i brani di anno a tua scelta.\n \n");
            System.out.println("Scegliere un opzione (1, 2, 3):");
            int Choise = scan.nextInt();
            scan.nextLine();

            
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
                        titolo=scan.nextLine();
                        
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
                    String nomedellAutore=scan.nextLine();
                        
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
                    String an=scan.nextLine();
                        
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
}