/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance tĹ™Ă­dy PrikazSeber pĹ™edstavujĂ­ zobratie.
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   0.00.000
 */
public class PrikazSeber implements IPrikaz
{
    private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Batoh batoh;

    /**
     * konĹˇtruktor
     */
    public PrikazSeber(HerniPlan plan){
        this.plan = plan;
        this.batoh = plan.getBatoh();
    }

    /**
     *  @parametre podÄľa prĂ­kazu, tu konkrĂ©tne je to string, akĂş vec mĂˇ zobraĹĄ
     */
   
    public String provedPrikaz(String... parametry){
        if (parametry.length == 0) {
            return "Zadaj prĂ­kaz v tvare seber vec."; //chĂ˝ba, ÄŤo treba zobraĹĄ
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        
        if (aktualniProstor.obsahujeVec(nazevVeci)){ // ÄŤi vĂ´bec priestor obsahuje vec
            Vec vec = aktualniProstor.vyberVec(nazevVeci);
            if (vec == null) {  // ak obsahuje, ale pri vĂ˝bere je nulovĂˇ, nie je prenosnĂˇ
                return "TĂˇto vec je neprenosnĂˇ, nemĂ´ĹľeĹˇ si ju zobraĹĄ.";
            } else {
                if ( batoh.vlozVecDoBatohu(vec)) { // dal si si vec do batohu
                    return "Zobral si "+ vec.getJmeno() + "." + "\nVec "+nazevVeci+" je vloĹľenĂˇ do batohu."; 
                }            
                else {
                    aktualniProstor.vlozVec(vec);  //nedĂˇĹˇ doĹ�ho ÄŹalĹˇiu vec                                 
                    return "MĂˇĹˇ plnĂ˝ batoh.";
                }
            }
        }
        else {
            return "Nic takovĂ©ho tu nenĂ­."; // priestor neobsahuje vec
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

