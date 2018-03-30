package logika;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import logika.Vec;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Trida Prostor - popisuje jednotlivĂ© prostory (mĂ­stnosti) hry
 *
 * Tato tĹ™Ă­da je souÄŤĂˇstĂ­ jednoduchĂ© textovĂ© hry.
 *
 * "Prostor" reprezentuje jedno mĂ­sto (mĂ­stnost, prostor, ..) ve scĂ©nĂˇĹ™i hry.
 * Prostor mĹŻĹľe mĂ­t sousednĂ­ prostory pĹ™ipojenĂ© pĹ™es vĂ˝chody. Pro kaĹľdĂ˝ vĂ˝chod
 * si prostor uklĂˇdĂˇ odkaz na sousedĂ­cĂ­ prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova; Lenka Ĺ ĹĄastnĂˇ
 * @version pro ĹˇkolnĂ­ rok 2017/2018
 */
public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // susednĂ© miestnosti
    private Map<String, Vec> seznamVeci; // veci v miestnosti
    private Map<String, Postava> seznamPostav; // postavy v miestnosti
    private boolean jeZamceny = false; // inicializĂˇcia zamknutĂ˝ch priestorov
    private double x;
    private double y;
    /**
     * VytvoĹ™enĂ­ prostoru se zadanĂ˝m popisem, napĹ™. "kuchyĹ�", "hala", "trĂˇvnĂ­k
     * pĹ™ed domem"
     *
     * @param nazev nazev prostoru, jednoznaÄŤnĂ˝ identifikĂˇtor, jedno slovo nebo
     * vĂ­ceslovnĂ˝ nĂˇzev bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis, double x, double y) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<Prostor>();
        seznamVeci = new HashMap<String, Vec>();
        seznamPostav = new HashMap<String, Postava>();
        this.jeZamceny = jeZamceny;
        this.x = x;
        this.y = y;

    }

    /**
     * Definuje vĂ˝chod z prostoru (sousednĂ­/vedlejsi prostor). Vzhledem k tomu,
     * Ĺľe je pouĹľit Set pro uloĹľenĂ­ vĂ˝chodĹŻ, mĹŻĹľe bĂ˝t sousednĂ­ prostor uveden
     * pouze jednou (tj. nelze mĂ­t dvoje dveĹ™e do stejnĂ© sousednĂ­ mĂ­stnosti).
     * DruhĂ© zadĂˇnĂ­ stejnĂ©ho prostoru tiĹˇe pĹ™epĂ­Ĺˇe pĹ™edchozĂ­ zadĂˇnĂ­ (neobjevĂ­ se
     * ĹľĂˇdnĂ© chybovĂ© hlĂˇĹˇenĂ­). Lze zadat tĂ©Ĺľ cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, kterĂ˝ sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnĂˇnĂ­ dvou prostorĹŻ. PĹ™ekrĂ˝vĂˇ se metoda equals ze
     * tĹ™Ă­dy Object. Dva prostory jsou shodnĂ©, pokud majĂ­ stejnĂ˝ nĂˇzev. Tato
     * metoda je dĹŻleĹľitĂˇ z hlediska sprĂˇvnĂ©ho fungovĂˇnĂ­ seznamu vĂ˝chodĹŻ (Set).
     *
     * BliĹľĹˇĂ­ popis metody equals je u tĹ™Ă­dy Object.
     *
     * @param o object, kterĂ˝ se mĂˇ porovnĂˇvat s aktuĂˇlnĂ­m
     * @return hodnotu true, pokud mĂˇ zadanĂ˝ prostor stejnĂ˝ nĂˇzev, jinak false
     */  
    @Override
    public boolean equals(Object obj) {
        // porovnĂˇvĂˇme zda se nejednĂˇ o dva odkazy na stejnou instanci
        if (this == obj) {
            return true;
        }
        // porovnĂˇvĂˇme jakĂ©ho typu je parametr 
        if (!(obj instanceof Prostor)) {
            return false;    // pokud parametr nenĂ­ typu Prostor, vrĂˇtĂ­me false
        }
        // pĹ™etypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) obj;

        //metoda equals tĹ™Ă­dy java.util.Objects porovnĂˇ hodnoty obou nĂˇzvĹŻ. 
        //VrĂˇtĂ­ true pro stejnĂ© nĂˇzvy a i v pĹ™Ă­padÄ›, Ĺľe jsou oba nĂˇzvy null,
        //jinak vrĂˇtĂ­ false.

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
     * VracĂ­ nĂˇzev prostoru (byl zadĂˇn pĹ™i vytvĂˇĹ™enĂ­ prostoru jako parametr
     * konstruktoru)
     *
     * @return nĂˇzev prostoru
     */

    public String getNazev() {
        return nazev;       
    }

    /**
     * VracĂ­ "dlouhĂ˝" popis prostoru, kterĂ˝ mĹŻĹľe vypadat nĂˇsledovnÄ›: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return DlouhĂ˝ popis prostoru
     */

    public String dlouhyPopis() {
        return "Si v miestnosti " + popis + ".\n"
        + popisVychodu() + "\n" + "veci v miestnosti: " + nazvyVeci() + "\n" + "postavy v miestnosti: " + nazvyPostav();
    }

    /**
     * VracĂ­ textovĂ˝ Ĺ™etÄ›zec, kterĂ˝ popisuje sousednĂ­ vĂ˝chody, napĹ™Ă­klad:
     * "vychody: hala ".
     *
     * @return Popis vĂ˝chodĹŻ - nĂˇzvĹŻ sousednĂ­ch prostorĹŻ
     */

    public String popisVychodu() {
        String vracenyText = "vĂ˝chody:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
            if (sousedni.jeZamceny()) { // ak je priestor zamknutĂ˝, vypiĹˇe sa to pri Ĺ�om
                vracenyText += "(zamÄŤenĂ˝)";
            }
        }
        return vracenyText;
    }

    /**
     * VracĂ­ prostor, kterĂ˝ sousedĂ­ s aktuĂˇlnĂ­m prostorem a jehoĹľ nĂˇzev je zadĂˇn
     * jako parametr. Pokud prostor s udanĂ˝m jmĂ©nem nesousedĂ­ s aktuĂˇlnĂ­m
     * prostorem, vracĂ­ se hodnota null, priestor sa vyhledĂˇvĂˇ v listu prostoru.
     *
     * @param nazevSouseda JmĂ©no sousednĂ­ho prostoru (vĂ˝chodu)
     * @return Prostor, kterĂ˝ se nachĂˇzĂ­ za pĹ™Ă­sluĹˇnĂ˝m vĂ˝chodem, nebo hodnota
     * null, pokud prostor zadanĂ©ho jmĂ©na nenĂ­ sousedem.
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
     * VracĂ­ kolekci obsahujĂ­cĂ­ prostory, se kterĂ˝mi tento prostor sousedĂ­.
     * Takto zĂ­skanĂ˝ seznam sousednĂ­ch prostor nelze upravovat (pĹ™idĂˇvat,
     * odebĂ­rat vĂ˝chody) protoĹľe z hlediska sprĂˇvnĂ©ho nĂˇvrhu je to plnÄ›
     * zĂˇleĹľitostĂ­ tĹ™Ă­dy Prostor.
     *
     * @return NemodifikovatelnĂˇ kolekce prostorĹŻ (vĂ˝chodĹŻ), se kterĂ˝mi tento
     * prostor sousedĂ­.
     */

    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    /** 
     * VypĂ­Ĺˇe nĂˇzvy vÄ›cĂ­
     */

    public String nazvyVeci () {
        String nazvy = "";
        for (String jmenoVeci : seznamVeci.keySet()){
            nazvy += jmenoVeci + " ";
        }
        return nazvy;
    }

    /**
     * MetĂłda vloĹľĂ­ postavu do priestoru.
     */

    public void vlozPostavu(Postava postava)
    {
        seznamPostav.put(postava.getJmeno(), postava);
    }

    /**
     * MetĂłda vloĹľĂ­ vec do priestoru.
     */

    public void vlozVec(Vec vec){
        seznamVeci.put(vec.getJmeno(), vec);
    }

    /**
     * MetĂłda vyberie vec z priestoru.
     * 
     */

    public Vec vyberVec(String jmenoVeci)
    {
        Vec vyberam = null;
        //for (String nazev : seznamVeci.keySet()){
           // if (nazev.equals(jmenoVeci) && seznamVeci.get(nazev).jePrenositelna() ) {
               // vyberam = seznamVeci.get(nazev);
              //  break;
           // }
       // }
        if ((seznamVeci.containsKey(jmenoVeci)) && (seznamVeci.get(jmenoVeci).jePrenositelna() )){
            vyberam = seznamVeci.get(jmenoVeci);
            seznamVeci.remove(jmenoVeci);
        }
        return vyberam; 

    }

    /**
     * MetĂłda, ÄŤi priestor obsahuje vec.
     * 
     */

    public boolean obsahujeVec (String jmenoVeci) {

        return seznamVeci.containsKey(jmenoVeci);
    }

    /**
     * Metoda nĂˇjde postavu.
     */

    public Postava najdiPostavu(String jmeno)
    {
        return seznamPostav.get(jmeno);
    }

    /** 
     * VypĂ­Ĺˇe nĂˇzvy postav v priestore.
     */

    public String nazvyPostav () {
        String nazvy = "";
        for (String jmenoPostavy : seznamPostav.keySet()){
            nazvy += jmenoPostavy + " ";
        }
        return nazvy;
    }

    /** 
     * NĂˇjde vec v priestore.
     */

    public Vec najdiVecVProstoru(String jmeno) {
        return seznamVeci.get(jmeno);
    }

    /** 
     * ÄŚi je priestor zamknutĂ˝
     */

    public boolean jeZamceny()
    {
        return jeZamceny;
    }

    /** 
     * NastavĂ­, ÄŤi je priestor zamknutĂ˝, alebo nie.
     */

    public void setZamceny(boolean value)
    {
        this.jeZamceny = value;
    }
    public Collection<Vec> getVeci() {
    	return Collections.unmodifiableCollection(seznamVeci.values());
    }
    
    public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
