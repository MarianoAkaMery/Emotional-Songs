/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * Classe che permette di ritardare l'output a schermo per una migliore visualizzazione
 * 
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: 748236
 * @author Mariano Librici, Matricola: 748240
 */
public class Sleep {
    /**
     * Funzione che permette il ritardo dell'output a schermo per una miglior visualizzazione.
     * 
     * @param ms indica, in millesecondi, quanto deve durare il ritardo.
     */
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }}
}