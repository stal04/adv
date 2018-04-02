/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazObsahBatohu představují základné funkcie príkazu obsah batohu.
 *
 * @author    Lenka Šťastná
 * @version   školský rok 2017/2018
 */
public class PrikazObsahBatohu implements IPrikaz
{
    private static final String NAZEV = "obsah_batohu";
    private HerniPlan plan;

    /**
     * Konštruktor triedy. 
     */
    public PrikazObsahBatohu(HerniPlan plan){
        this.plan=plan;
    }

    /**
     * @param závisia na konkrétnom príkaze, tu nie sú 
     */

    
    public String provedPrikaz(String... parametry){
        if (plan.getBatoh().nazvyVeciVBatohu().isEmpty()) {
            return "Zatiaľ máš prázdny batohu.";   // ak  je batoh prĂˇzdny
        }
        else {
            return "V batohu máš " + plan.getBatoh().nazvyVeciVBatohu() + "."; 
        }
    }
    
    public String getBatoh() {
    	return plan.getBatoh().nazvyVeciVBatohu();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @return nazev prikazu
     */

  
    public String getNazev(){
        return NAZEV;

    }
}
