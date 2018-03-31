/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance třídy resRovnici představují riešenie rovnice.
 *
 * @author    Lenka Šťastná
 * @version   školský rok 2017/2018
 */
public class PrikazResRovnici implements IPrikaz
{
    private static final String NAZEV = "res_rovnici";
    private HerniPlan plan;

    /**
     *  konštruktor
     *  
     */
    public PrikazResRovnici(HerniPlan plan){
        this.plan=plan;

    }

    /**
     *  @parametre závisia na príkazoch, používam jeden, správny výsledok
     *  
     */

    
    public String provedPrikaz(String... parametry){
        if (parametry.length == 0) {
            return "Zadaj príkaz v tvare res_rovnici cislo."; //zle zadaný príkaz
        }

        if(plan.getAktualniProstor().getNazev().equals("vedec")) { 
            while(plan.getPokus() <2){ // mĂˇĹˇ 3 pokusy
                if((parametry[0].equals("3") || parametry[0].equals("tri"))){            

                    plan.getAktualniProstor().vlozVec(new Vec("diamant", true)); 
                    return "Správne, pokračuj k čarodejovi. \nveci v miesnoti: " + plan.getAktualniProstor().nazvyVeci();
                } 

                else { 
                    plan.spatnaOdpoved();
                    return "Nesprávne, môžeš hádať ešte " + (3- plan.getPokus()) + "krát";
                }

            }
            plan.setProhra(true); 
            return "hra ukončená";
        }
        return "V tejto miestnosti nemôžeš odpovedať.";
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

