/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazSeber představují zobratie.
 *
 * @author    Lenka Šťastná
 * @version   0.00.000
 */
public class PrikazSeber implements IPrikaz
{
    private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Batoh batoh;

    /**
     * konštruktor
     */
    public PrikazSeber(HerniPlan plan){
        this.plan = plan;
        this.batoh = plan.getBatoh();
    }

    /**
     *  @parametre podľa príkazu, tu konkrétne je to string, akú vec má zobrať
     */
   
    public String provedPrikaz(String... parametry){
        if (parametry.length == 0) {
            return "Zadaj príkaz v tvare seber vec."; 
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        
        if (aktualniProstor.obsahujeVec(nazevVeci)){ // či vôbec priestor obsahuje vec
            Vec vec = aktualniProstor.vyberVec(nazevVeci);
            if (vec == null) {  // ak obsahuje, ale pri výbere je nulová, nie je prenosná
                return "Táto vec je neprenosná, nemôžeš si ju zobrať.";
            } else {
                if ( batoh.vlozVecDoBatohu(vec)) { // dal si si vec do batohu
                	plan.pozoruj();
                    return "Zobral si "+ vec.getJmeno() + "." + "\nVec "+nazevVeci+" je vložená do batohu."; 
                }            
                else { plan.pozoruj();
                    aktualniProstor.vlozVec(vec);                                  
                    return "Máš plný batoh.";
                }
            }
        }
        else {
            return "Nič také tu neni."; // priestor neobsahuje vec
        }
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

