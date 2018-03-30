package logika;

/**
 *  Třída PrikazKonec implementuje pro hru příkaz konec.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Lenka Šťastná
 *@version    pro školní rok 2017/2018
 *  
 */

public class PrikazKonec implements IPrikaz {
    private static final String NAZEV = "konec";
    private Hra hra;

    /**
     *  Konstruktor třídy
     *  
     *  @param hra odkaz na hru, která má být příkazem konec ukončena
     */    
    public PrikazKonec(Hra hra) {
        this.hra = hra;
    }

    /**
     * V případě, že příkaz má jen jedno slovo "konec" hra končí(volá se metoda setKonecHry(true))
     * jinak pokračuje např. při zadání "konec a".
     * 
     * @return zpráva, kterou vypíše hra hráči
     */

   
    public String provedPrikaz(String... parametry) {
        if (parametry.length > 0) {
            return "Príkaz konca hry sa zadáva v tvare: konec.";
        }
        else {
            hra.setKonecHry(true);
            return "Hra ukončená príkazom konec.";
        }
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
