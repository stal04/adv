/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

import java.util.Set;
import java.util.HashSet;
/*******************************************************************************
 * Instance třídy PrikazDej představují darovanie.
 *
 * @author    Lenka Šťastná
 * @version   školský rok 2017/2018
 */
public class PrikazDej implements IPrikaz
{
    private Batoh batoh;
    private HerniPlan plan;
    private static final String NAZEV = "dej";
    private Postava postava;
    private Hra hra;
    private Prostor prostor;
    private Set<Prostor> vychody;

    /**
     * konštruktor
     */

    public PrikazDej(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = plan.getBatoh();
        this.postava = postava;
        this.prostor=plan.getAktualniProstor();
        this.vychody = new HashSet<Prostor>();

    }

    /**
     *  @parametre závisia na príkaze, používam 2, čo a komu dať, čiže vec a postavu
     *  @return vráti String podla podmienky.
     */

    @Override  
    public String provedPrikaz(String... parametry){
        if (parametry.length < 2 || parametry.length >3 ) {  //zle zadanĂ˝ prĂ­kaz
            return "Zadaj príkaz v tvare - dej niečo niekomu.";
        }
        else{
            Prostor aktualniProstor = plan.getAktualniProstor();
            String aktualni = plan.nazevProstoru();

            if (plan.nazevProstoru().equals("carodej") && batoh.obsahujeVecBatoh("diamant") && parametry[0].equals("diamant") && parametry[1].equals("carodej") ){   //ak sa jednĂˇ o ÄŤarodeja, po predanĂ­ diamantu nĂˇm dĂˇ lektvar a informĂˇciu o radnici                                 
                batoh.vyberVecZBatohu("diamant");
                plan.getAktualniProstor().vlozVec(new Vec("lektvar",true));
                plan.getAktualniProstor().vlozVec(new Vec("diamant",false));
                return "Ďakujem za diamant, na oplátku ti dám lektvar, ktorým môžeš uspať strážcov draka, informácia, kde sa nachádza drak je na radnici." + '\n' +"veci v miestnosti: " + plan.getAktualniProstor().nazvyVeci();
            }

            if (plan.nazevProstoru().equals("hospoda") && batoh.obsahujeVecBatoh("recept") && parametry[0].equals("recept") && parametry[1].equals("krcmar") ){      //po predanĂ­ receptu nĂˇm dĂˇ mapu                             
                batoh.vyberVecZBatohu("recept");
                plan.getAktualniProstor().vlozVec(new Vec("mapa",true));
                plan.getAktualniProstor().vlozVec(new Vec("recept",false));
                return "Ďakujem za recept na pivo, pokračuj k vedcovi, on ti poradí ďalej. Tu máš mapu, aby si trafil." + '\n' +"veci v miestnosti: " + plan.getAktualniProstor().nazvyVeci();
            }
        }

        if (plan.nazevProstoru().equals("nepratelske_kralovstvi") && batoh.obsahujeVecBatoh("lektvar") && parametry[0].equals("lektvar") && parametry[1].equals("straz") ) {     //po danĂ­ lektvĂˇru strĂˇĹľi je drak oslobodenĂ˝                             
            batoh.vyberVecZBatohu("lektvar");
            plan.getAktualniProstor().vlozVec(new Vec("drak",true));

            return "Uspal si strážcov, zober draka a odovzdaj ho kráľovi." + '\n' +"veci v miestnosti: " + plan.getAktualniProstor().nazvyVeci();

        }
        return "Nič sa nestalo, nikomu si nič nedal.";
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @return nazev prikazu
     */

    @Override
    public String getNazev(){
        return NAZEV;
    }

}
