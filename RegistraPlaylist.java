import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RegistraPlaylist{
    public static void main(String[] args){
        
        String path1="Canzoni.dati.csv";
        String path2="CreaPlaylistProva.csv";
        String line="";
        Scanner scan=new Scanner(System.in);

        String[] brani=new String[980];
        String[] autori=new String[980];
        String[] anno=new String[980];
        
        int i=0;  //numero totale di canzoni nella lista
        
        try{
            
            BufferedReader br=new BufferedReader(new FileReader(path1));
            
            while((line=br.readLine())!=null){
                String[] val=line.split(",");

                brani[i]=val[0];
                autori[i]=val[1];
                anno[i]=val[2];

                i++;
            }

            System.out.println("Benvenuto! Qui potrai creare le tue playlist. Iniziamo!!");
            System.out.println("Inserisci il tuo nome, così gli altri utenti sapranno che questa playlist è stata creata da te.");
            String nomeUtente=scan.nextLine();

            System.out.println("Inserisci il nome della playlist");
            String nomePlaylist=scan.nextLine();

            System.out.println("Digita \"1\" se vuoi comporre la playlist inserendo brani a tua scelta.");
            System.out.println("Digita \"2\" se vuoi comporre la playlist inserendo tutti i brani di un autore a tua scelta.");
            System.out.println("Digita \"3\" se vuoi comporre la playlist inserendo tutti i brani di anno a tua scelta.");
            char scelta=scan.nextLine().charAt(0);

            
            //parte di creazione della playlist
            
            
            FileWriter fw = new FileWriter(path2,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);

            
            pw.println("NOME PLAYLIST: " + nomePlaylist);
            pw.println("Creata da: " + nomeUtente);
            pw.println();
            pw.println(brani[0] + "," + autori[0] + "," + anno[0]);
            
            
            boolean trovato=false;
            int k=1;
            String titolo="";
            System.out.println("Scelta: "+scelta);

            if(scelta=='1'){
                System.out.println("Hai scelto di inserire brani singoli");
            }
            if(scelta=='2'){
                System.out.println("Hai scelto di inserire brani per autore");
            }
            if(scelta=='3'){
                System.out.println("Hai scelto di inserire brani per anno");
            }
            
            //mettere canzoni con singole
            if(scelta=='1'){
                System.out.println("Inserisci le canzoni. Quando hai terminato l'inserimento digita\"0\"");
                do{
                    System.out.println("Cerca il titolo della " + k +"^ canzone da inserire nella playlist");
                    titolo=scan.nextLine();
                    
                    for(i=1;i<980;i++){
                        if(titolo.equals(brani[i])){
                            trovato=true;
                            pw.println(brani[i] + "," + autori[i] + "," + anno[i]);
                        }
                    }

                    if(trovato==false){
                        System.out.println("Il brano cercato non esiste.");
                    }else{
                        System.out.println("Brano aggiunto alla playlist!");
                    }
                    if(titolo.equals("0")){
                        System.out.println("Inserimento terminato.");
                    }
                    
                    k++;
                    trovato=false;
                }while(!(titolo.equals("0")));
            }


            //mettere tutte le canzoni di autori
            
            if(scelta=='2'){
                
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
                }else{
                    System.out.println("Tutti i brani di " + nomedellAutore + " sono stati aggiunti alla playlist!");
                }
            }


            //mettere tutte le canzoni di un anno

            if(scelta=='3'){
                
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
            }
            
            pw.flush();
            br.close();
        
        
    }catch(FileNotFoundException e){
            System.out.println("File non trovato!!");
        }catch(IOException e){
            System.out.println("Si è verificato un problema");
        }
        
        scan.close();
    }
}