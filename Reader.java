import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Semplice classe per testare i file csv per capire come gestire l'elenco delle canzoni
*/
public class Reader {
    public static void main(String args[]){
        //path per mio pc, c'e' da capire come inserire una che vada bene per tutti
        String path = "C:\\Users\\Emanuele Buggin\\Documents\\GitHub\\Emotional-songs\\provaFileCsv.csv";
        String riga = "";

        try {
            //lettura del file
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            //controllo che il file non sia "finito"
            while((riga = buffer.readLine()) != null){
                //lettura della "prima colonna"
                String[] valoriLetti = riga.split(",");
                System.out.println("NOME BRANO" + valoriLetti[0]);
            }
            }catch (FileNotFoundException e) {
                System.out.println("File non trovato");
                e.printStackTrace();  
            }catch(IOException e){
                e.printStackTrace();
            }
    }
}
