package logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček, Lenka Šťastná
 *@version    pro školní rok 2017/2018
 */
public class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Batoh batoh;

    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */    
    public PrikazJdi(HerniPlan plan) {
        this.plan = plan;
        this.batoh=plan.getBatoh();
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
   
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám ísť? Zadaj prosím prosím príkaz s parametrom miesta.";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);
        String sucasnyProstor = plan.nazevProstoru();

        if(sucasnyProstor.equals(smer)){ 
            return "V tomto priestore si teraz.";

        } else{
            if (sousedniProstor == null) {
                return "Tam sa odtiaľto nedostaneš!";
            }

            if (sousedniProstor.jeZamceny() && !(batoh.obsahujeVecBatoh("mapa"))) {
                return "Dvere do miestnosti "+sousedniProstor.getNazev()
                +" sú zamknuté.";
            }
        }
        plan.setAktualniProstor(sousedniProstor);
        return sousedniProstor.dlouhyPopis();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
   
    public String getNazev() {
        return NAZEV;
    }

}
