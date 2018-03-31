package logika;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import logika.Vec;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova; Lenka Šťastná
 * @version pro školní rok 2017/2018
 */

public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // susedné miestnosti
    private Map<String, Vec> seznamVeci; // veci v miestnosti
    private Map<String, Postava> seznamPostav; // postavy v miestnosti
    private boolean jeZamceny = false; 
  
    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<Prostor>();
        seznamVeci = new HashMap<String, Vec>();
        seznamPostav = new HashMap<String, Postava>();
        this.jeZamceny = jeZamceny;
    

    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Prostor)) {
            return false;   
        }
       
        Prostor druhy = (Prostor) obj;

        

        return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }


    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */

    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */

    public String dlouhyPopis() {
        if(nazvyVeci() == "" && nazvyPostav() == "")
        {return "Si v miestnosti " + popis + ".\n"
        + popisVychodu(); 
       }
       
        else if(nazvyVeci() == "")
        {return "Si v miestnosti " + popis + ".\n"
        + popisVychodu() + "\n" + 
         "postavy v miestnosti: " + nazvyPostav(); 
       }
       
       else if(nazvyPostav() == "")
        {return "Si v miestnosti " + popis + ".\n"
        + popisVychodu() + "\n" + 
        "veci v miestnosti: " + nazvyVeci();
       }
       
       return "Si v miestnosti " + popis + ".\n"
        + popisVychodu() + "\n" + 
        "veci v miestnosti: " + nazvyVeci() + 
        "\n" + "postavy v miestnosti: " + nazvyPostav(); 
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */

    public String popisVychodu() {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
            if (sousedni.jeZamceny()) { 
                vracenyText += "(zamknutý)";
            }
        }
        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null, priestor sa vyhledává v listu prostoru.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */

    public Prostor vratSousedniProstor(String nazevSousedneho) {
        for (Prostor sousedni : vychody) {  //vypisuje priestory susedne
            if (sousedni.getNazev().equals(nazevSousedneho)) {
                return sousedni;
            }
        }
        return null;  // prostor nenajdeny
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */

    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    /** 
     * Vypíše názvy věcí
     */

    public String nazvyVeci () {
        String nazvy = "";
        for (String jmenoVeci : seznamVeci.keySet()){
            nazvy += jmenoVeci + " ";
        }
        return nazvy;
    }

    /**
     * Metóda vloží postavu do priestoru.
     */

    public void vlozPostavu(Postava postava)
    {
        seznamPostav.put(postava.getJmeno(), postava);
    }

    /**
     * Metóda vloží vec do priestoru.
     */

    public void vlozVec(Vec vec){
        seznamVeci.put(vec.getJmeno(), vec);
    }

    /**
     * Metóda vyberie vec z priestoru.
     * 
     */

    public Vec vyberVec(String jmenoVeci)
    {
        Vec vyberam = null;
        
        if ((seznamVeci.containsKey(jmenoVeci)) && (seznamVeci.get(jmenoVeci).jePrenositelna() )){
            vyberam = seznamVeci.get(jmenoVeci);
            seznamVeci.remove(jmenoVeci);
        }
        return vyberam; 

    }

    /**
     * Metóda, či priestor obsahuje vec.
     * 
     */

    public boolean obsahujeVec (String jmenoVeci) {

        return seznamVeci.containsKey(jmenoVeci);
    }

    /**
     * Metoda nájde postavu.
     */

    public Postava najdiPostavu(String jmeno)
    {
        return seznamPostav.get(jmeno);
    }

    /** 
     * Vypíše názvy postav v priestore.
     */

    public String nazvyPostav () {
        String nazvy = "";
        for (String jmenoPostavy : seznamPostav.keySet()){
            nazvy += jmenoPostavy + " ";
        }
        return nazvy;
    }

    /** 
     * Nájde vec v priestore.
     */

    public Vec najdiVecVProstoru(String jmeno) {
        return seznamVeci.get(jmeno);
    }

    /** 
     * Či je priestor zamknutý
     */

    public boolean jeZamceny()
    {
        return jeZamceny;
    }

    /** 
     * Nastaví, či je priestor zamknutý, alebo nie.
     */

    public void setZamceny(boolean value)
    {
        this.jeZamceny = value;
    }
    public Collection<Vec> getVeci() {
    	return Collections.unmodifiableCollection(seznamVeci.values());
    }
    
  
}
