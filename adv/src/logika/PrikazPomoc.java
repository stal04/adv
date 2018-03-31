/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazPomoc představují pomoc.
 *
 * @author    Lenka Šťastná
 * @version   školský rok 2017/2018
 */
public class PrikazPomoc implements IPrikaz
{
    
    private static final String NAZEV = "pomoc";
    private HerniPlan plan;

    /**
     *  Konštruktor triedy. 
     */    
    public PrikazPomoc(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Vracia pomoc po zadani prikazu "pomoc". 
     *  
     *  @return napoveda ke hre
     */
    
    public String provedPrikaz(String... parametry) { 
        if(plan.nazevProstoru().equals("kralovstvi")) {
            return "Cieľom je priniesť draka. Začni v hospode.";
        }
        if (plan.nazevProstoru().equals("hospoda")) {
            return "Porozprávaj sa s krčmárom, on ti povie, čo chce za výmenu informácií.";
        }
        if (plan.nazevProstoru().equals("knihovna")) {
            return "Sú tam nejaké zaujímavé veci na zobratie?";
        }
        if (plan.nazevProstoru().equals("vedec")) {
            return "Porozprávaj sa s vedcom, on ti poradí.";
        }
        if (plan.nazevProstoru().equals("carodej")) {
            return "Porozprávaj sa s čarodejom, on ti povie, čo chce.";
        }
        if (plan.nazevProstoru().equals("radnice")) {
            return "Našla si na radnici nejakú zaujímavú informáciu?";
        }
        else {
            return "Použi lektvar a osloboď draka.";
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    
    public String getNazev() {
        return NAZEV;
    }
}
