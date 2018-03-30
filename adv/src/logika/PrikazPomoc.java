/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance tĹ™Ă­dy PrikazPomoc pĹ™edstavujĂ­ pomoc.
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   ĹˇkolskĂ˝ rok 2017/2018
 */
public class PrikazPomoc implements IPrikaz
{
    //== DatovĂ© atributy (statickĂ© i instancĂ­)======================================

    //== Konstruktory a tovĂˇrnĂ­ metody =============================================
    private static final String NAZEV = "pomoc";
    private HerniPlan plan;

    /**
     *  KonĹˇtruktor triedy. 
     */    
    public PrikazPomoc(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Vracia pomoc po zadani prikazu "pomoc". 
     *  
     *  @return napoveda ke hre
     */
    
    public String provedPrikaz(String... parametry) { // v kaĹľdej miesnosti vracia konkrĂ©tnu pomoc
        if(plan.nazevProstoru().equals("kralovstvi")) {
            return "CieÄľom je priniesĹĄ draka. ZaÄŤni v hospode";
        }
        if (plan.nazevProstoru().equals("hospoda")) {
            return "PorozprĂˇvaj sa s krÄŤmĂˇrom, on ti povie, ÄŤo chce za vĂ˝menu informĂˇciĂ­.";
        }
        if (plan.nazevProstoru().equals("knihovna")) {
            return "SĂş tam nejakĂ© zaujĂ­mavĂ© veci na zobratie?";
        }
        if (plan.nazevProstoru().equals("vedec")) {
            return "PorozprĂˇvaj sa s vedcom, on ti poradĂ­.";
        }
        if (plan.nazevProstoru().equals("carodej")) {
            return "PorozprĂˇvaj sa s ÄŤarodejom, on ti povie, ÄŤo chce.";
        }
        if (plan.nazevProstoru().equals("radnice")) {
            return "NaĹˇla si na radnici nejakĂş zaujĂ­mavĂş informĂˇciu?";
        }
        else {
            return "PouĹľi lektvar a osloboÄŹ draka.";
        }
    }

    /**
     *  Metoda vracĂ­ nĂˇzev pĹ™Ă­kazu (slovo kterĂ© pouĹľĂ­vĂˇ hrĂˇÄŤ pro jeho vyvolĂˇnĂ­)
     *  
     *  @ return nazev prikazu
     */
    
    public String getNazev() {
        return NAZEV;
    }
}
