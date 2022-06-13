import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.*;


public class CercaBrano {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]){  
        cercaBranoMusicale();
    }

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
                    CSVReader reader = new CSVReader(new FileReader("Canzoni.dati.csv"));

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
}