/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;


/*******************************************************************************
 * Instance tĹ™Ă­dy Mluv pĹ™edstavujĂ­ ...
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   ĹˇkolskĂ˝ rok 2017/2018
 */
public class PrikazMluv implements IPrikaz
{
    private HerniPlan plan;
    private static final String NAZEV = "mluv";

    /**
     * KonĹˇtruktor triedy.
     *
     */ 
    public PrikazMluv(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     *  PrĂ­kaz mluv. VĹˇetky postavy v hre vedia hovoriĹĄ a pomĂ´Ĺľu k vĂ˝hre.
     *  @param - meno postavy
     *  @return - reÄŤ postavy
     *
     */ 

   
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nezadal si s ktorou postavou chceĹˇ hovoriĹĄ.";
        }
        String jmeno = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        Postava postava = aktualniProstor.najdiPostavu(jmeno);
        if (postava == null) {
            return "Postava sa nenachĂˇdza v tomto priestore.";
        }
        if (postava.getJmeno().contains("carodej")) {
            return postava.getRec();
        }
        if (postava.getJmeno().contains("vedec")) {
            return postava.getRec();
        }
        if (postava.getJmeno().contains("krcmar")) {
            return postava.getRec();
        }
        if (postava.getJmeno().contains("straz")) {
            return postava.getRec();
        }

        return "Postava neexistuje, alebo sa s Ĺ�ou nedĂˇ rozprĂˇvaĹĄ.";

    }

    /**
     *  Metoda vracĂ­ nĂˇzev pĹ™Ă­kazu (slovo kterĂ© pouĹľĂ­vĂˇ hrĂˇÄŤ pro jeho vyvolĂˇnĂ­
     *  
     *  @ return nazev prikazu
     */
    
    public String getNazev() {
        return NAZEV;
    }
}

