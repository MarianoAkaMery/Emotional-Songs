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
        //ho scoperto (EMA) che se il file e' nella path della classe si puo' omettere la prima parte, cosi' rendendolo accessibile a tutti
        String path = "provaFileCsv.csv";
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
            buffer.close();
            }catch (FileNotFoundException e) {
                System.out.println("File non trovato");
                e.printStackTrace();  
            }catch(IOException e){
                e.printStackTrace();
            }
    }
}
