package logika;

import java.util.Observable;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Lenka Šťastná
 *@version    pro školní rok 2017/2018
 */
public class HerniPlan extends Observable{

    private Prostor aktualniProstor;
    private Batoh batoh;
    private Postava postava;
    private Hra hra;
    private int pokus = 0; //číslo pokusu

    private Vec vec;
    private boolean vyhra = false; //inicializácia
    private boolean prohra = false; //inicializacia

    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví kralovstvi.
     */
    public HerniPlan() {
        zalozProstoryHry();
        batoh = new Batoh();
    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví kralovstvi.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
    	Prostor hospoda = new Prostor("hospoda","hospoda, v ktorej varí krčmár pivo", -51.0, -149.0);
        Prostor knihovna = new Prostor("knihovna", "knižnica, v ktorej sa nachádzajú staré recepty", 35.0, 40.0);
        Prostor vedec = new Prostor("vedec","vedcovo doupě", 40.0, 90.0);
        Prostor radnice = new Prostor("radnice","radnica v ktorej sa nachádzajú rôzne spisy, dokumenty a informácia, že drak sa nachádza v nepriateľskom kráľovstve!", 250.0, 40.0);
        Prostor nepratelskeKralovstvi = new Prostor("nepratelske_kralovstvi","nepriateľské kráľovstvo, ktoré strážia strážci", 250.0, 150.0);
        Prostor carodej = new Prostor("carodej","doupě chamtivého čarodeja, ktorý prahne po diamantoch", 150.0, 40.0);
        Prostor kralovstvi = new Prostor("kralovstvi","kráľovstvo, ktorému zmizol drak, kráľovstvo ti dalo za úlohu priniesť mu draka", 0, 0);

        // přiřazují se průchody mezi prostory (sousedící prostory)
        kralovstvi.setVychod(nepratelskeKralovstvi);
        kralovstvi.setVychod(hospoda);
        hospoda.setVychod(knihovna);
        hospoda.setVychod(vedec);
        knihovna.setVychod(hospoda);
        vedec.setVychod(carodej);
        carodej.setVychod(vedec);
        carodej.setVychod(radnice);
        radnice.setVychod(nepratelskeKralovstvi);
        radnice.setVychod(carodej);
        nepratelskeKralovstvi.setVychod(kralovstvi);
        nepratelskeKralovstvi.setVychod(radnice);

        // predmety v miestnostiach       
        knihovna.vlozVec(new Vec("recept", true));
        kralovstvi.vlozVec(new Vec("recept", true));
        hospoda.vlozVec(new Vec("pivo", false));
        hospoda.vlozVec(new Vec("tlacenka", false));
        nepratelskeKralovstvi.vlozVec(new Vec("drak", true));

        // postavy v miestnostiach
        hospoda.vlozPostavu(new Postava("krcmar","Informácie vymením len za recept na staré pivo, nájdeš ho v knihovne."));
        carodej.vlozPostavu(new Postava("carodej","Vymením lektvar za diamant."));
        vedec.vlozPostavu(new Postava("vedec","Informácie dám, len ak uhádneš rovnicu x^2-6x+9=0, zadaj výsledok v tvare res_rovnici cislo."));
        nepratelskeKralovstvi.vlozPostavu(new Postava("straz","Prelstiť nás môžeš len lektvarom."));
        kralovstvi.vlozPostavu(new Postava("straz","Prelstiť nás môžeš len lektvarom."));

        // zamknute miestnosti
        vedec.setZamceny(true);

        aktualniProstor = kralovstvi;  // hra začíná v kralovstvi       
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     *  Metóda vracia meno aktuálneho priestoru, kde sa hráč nachádza
     *
     *@return     String
     */
    public String nazevProstoru(){
        return aktualniProstor.getNazev();
    }

    /**
     *  Metoda vracia odkaz na vec
     *
     *@return     Vec
     */
    public Vec getVec(){
        return vec;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

    /**
     *  Metóda vracia odkaz na batoh.
     *
     *@return     Batoh
     */ 
    public Batoh getBatoh() {
        return batoh;
    }

    /**
     *  Metoda vracia odkaz na postavu
     *
     *@return     Postava
     */ 
    public Postava getPostava(){
        return postava;
    }

    /**
     *  Metoda vracia odkaz na hru.
     *
     *@return     Hra
     */
    public Hra getHra(){
        return hra;
    }

    /**
     * Metóda vracia zostávajúci počet pokusov pri hádaní riešenia rovnice.
     * @return int
     */
    public int getPokus(){
        return pokus;
    }

    /**
     * Metóda zvyšuje počet pokusov, začínajú od nuly.
     */
    public void spatnaOdpoved(){
        pokus++;
    }

    /**
     *  Metóda vracia výhru.
     *
     *@return     vyhra
     */
    public boolean jeVyhra() {
        return vyhra;
    }

    /**
     *  Metóda stanoví výhru.
     *  @param boolean stav
     */
    public void setVyhra(boolean stav) {
        this.vyhra = stav;
    }

    /**
     *  Metoda vracia prehru.
     *
     *@return     prohra
     */
    public boolean jeProhra() {
        return prohra;
    }

    /**
     *  Metóda stanoví prehru.
     *  @param boolean stav
     */
    public void setProhra(boolean stav) {
        this.prohra = stav;
    }
    
    
}
