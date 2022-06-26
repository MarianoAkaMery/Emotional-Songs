/**
 * Progetto laboratorio A: "Emotional songs", anno 2021-2022
 * @author Davide Buggin, Matricola: 749715
 * @author Emanuele Buggin, Matricola:748676
 * @author Marco Calcaterra, Matricola: XXXXXX
 * @author Mariano Librici, Matricola: XXXXXX
 */
public class Sleep {
    /**
     * Funzione che permette il ritardo dell' output a schermo 
     * per una miglior visualizzazione
     * @param ms
     */
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }}
}