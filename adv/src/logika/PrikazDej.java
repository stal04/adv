/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

import java.util.Set;
import java.util.HashSet;
/*******************************************************************************
 * Instance tĹ™Ă­dy PrikazDej pĹ™edstavujĂ­ darovanie.
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   ĹˇkolskĂ˝ rok 2017/2018
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
     * konĹˇtruktor
     */

    public PrikazDej(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = plan.getBatoh();
        this.postava = postava;
        this.prostor=plan.getAktualniProstor();
        this.vychody = new HashSet<Prostor>();

    }

    /**
     *  @parametre zĂˇvisia na prĂ­kaze, pouĹľĂ­vam 2, ÄŤo a komu daĹĄ, ÄŤiĹľe vec a postavu
     *  @return vrĂˇti String podla podmienky.
     */

   
    public String provedPrikaz(String... parametry){
        if (parametry.length < 2 || parametry.length >3 ) {  //zle zadanĂ˝ prĂ­kaz
            return "Zadaj prĂ­kaz v tvare - dej nieÄŤo niekomu.";
        }
        else{
            Prostor aktualniProstor = plan.getAktualniProstor();
            String aktualni = plan.nazevProstoru();

            if (plan.nazevProstoru().equals("carodej") && batoh.obsahujeVecBatoh("diamant") && parametry[0].equals("diamant") && parametry[1].equals("carodej") ){   //ak sa jednĂˇ o ÄŤarodeja, po predanĂ­ diamantu nĂˇm dĂˇ lektvar a informĂˇciu o radnici                                 
                batoh.vyberVecZBatohu("diamant");
                plan.getAktualniProstor().vlozVec(new Vec("lektvar",true));
                plan.getAktualniProstor().vlozVec(new Vec("diamant",false));
                return "ÄŽakujem za diamant, na oplĂˇtku ti dĂˇm lektvar, ktorĂ˝m mĂ´ĹľeĹˇ uspaĹĄ strĂˇĹľcov draka, informĂˇcia, kde sa nachĂˇdza drak je na radnici." + '\n' +"veci v miestnosti: " + plan.getAktualniProstor().nazvyVeci();
            }

            if (plan.nazevProstoru().equals("hospoda") && batoh.obsahujeVecBatoh("recept") && parametry[0].equals("recept") && parametry[1].equals("krcmar") ){      //po predanĂ­ receptu nĂˇm dĂˇ mapu                             
                batoh.vyberVecZBatohu("recept");
                plan.getAktualniProstor().vlozVec(new Vec("mapa",true));
                plan.getAktualniProstor().vlozVec(new Vec("recept",false));
                return "ÄŽakujem za recept na pivo, pokraÄŤuj k vedcovi, on ti poradĂ­ ÄŹalej. Tu mĂˇĹˇ mapu, aby si trafil." + '\n' +"veci v miestnosti: " + plan.getAktualniProstor().nazvyVeci();
            }
        }

        if (plan.nazevProstoru().equals("nepratelske_kralovstvi") && batoh.obsahujeVecBatoh("lektvar") && parametry[0].equals("lektvar") && parametry[1].equals("straz") ) {     //po danĂ­ lektvĂˇru strĂˇĹľi je drak oslobodenĂ˝                             
            batoh.vyberVecZBatohu("lektvar");
            plan.getAktualniProstor().vlozVec(new Vec("drak",true));

            return "Uspal si strĂˇĹľcov, zober draka a odovzdaj ho krĂˇÄľovi." + '\n' +"veci v miestnosti: " + plan.getAktualniProstor().nazvyVeci();

        }
        return "NiÄŤ sa nestalo, nikomu si niÄŤ nedal.";
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
