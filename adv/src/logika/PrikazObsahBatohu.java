/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance tĹ™Ă­dy PrikazObsahBatohu pĹ™edstavujĂ­ zĂˇkladnĂ© funkcie prĂ­kazu obsah batohu.
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   ĹˇkolskĂ˝ rok 2017/2018
 */
public class PrikazObsahBatohu implements IPrikaz
{
    private static final String NAZEV = "obsah_batohu";
    private HerniPlan plan;

    /**
     * KonĹˇtruktor triedy. 
     */
    public PrikazObsahBatohu(HerniPlan plan){
        this.plan=plan;
    }

    /**
     * @param zĂˇvisia na konkrĂ©tnom prĂ­kaze, tu nie sĂş 
     */

    
    public String provedPrikaz(String... parametry){
        if (plan.getBatoh().nazvyVeciVBatohu().isEmpty()) {
            return "ZatiaÄľ mĂˇm prĂˇzdny batoh.";   // ak  je batoh prĂˇzdny
        }
        else {
            return "V batohu mĂˇm " + plan.getBatoh().nazvyVeciVBatohu() + "."; // vypiĹˇe, ÄŤo sa nachĂˇdza v batohu
        }
    }

    /**
     *  Metoda vracĂ­ nĂˇzev pĹ™Ă­kazu (slovo kterĂ© pouĹľĂ­vĂˇ hrĂˇÄŤ pro jeho vyvolĂˇnĂ­)
     *  
     *  @return nazev prikazu
     */

  
    public String getNazev(){
        return NAZEV;

    }
}
