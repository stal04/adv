/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

import java.util.Map;
import java.util.HashMap;

/*******************************************************************************
 * Instance třídy Batoh představují ...
 *
 * @author    Lenka Šťastná
 * @version   školský rok 2017/2018
 */
public class Batoh
{
    private static final int KAPACITA = 4; //maximĂˇlna kapacita
    private Map<String, Vec> seznamVeci; //Mapa vecĂ­, kÄľĂşÄŤ a priradenĂ© veci

    /**
     * konštruktor
     */
    public Batoh(){
        seznamVeci = new HashMap<String, Vec>();
    }

    /**
     * Vloží do batohu ak vojde
     * @return true ak sa vloží, false, ak sa nevložila
     * @param objekt triedy Vec
     */
    public boolean vlozVecDoBatohu (Vec vec) {
        if (seznamVeci.size() < KAPACITA & vec.jePrenositelna() ) {
            seznamVeci.put(vec.getJmeno(), vec);
            return true;
        }
        return false;
    }

    /**
     * Či sa v batohu nachádza vec.
     * @return true alebo false, podľa toho, či sa vec v batohu nachádza.
     */
    public boolean obsahujeVecBatoh (String jmenoVeci) {
        return seznamVeci.containsKey(jmenoVeci);
    }

    /**
     * Vyberie vec z batohu.
     * @return vec, alebo ak neni v batohu tak null.
     * @param String pri zadaní, čo sa má vybrať.
     */
    public Vec vyberVecZBatohu (String jmenoVeci) {
        Vec nalezenaVec;
        if (seznamVeci.containsKey(jmenoVeci)) {
            nalezenaVec = seznamVeci.get(jmenoVeci);
            seznamVeci.remove(jmenoVeci);
            return nalezenaVec;
        }
        return null;
    }

    /**
     * Vypíše veci, ktoré sú v batohu.
     * @return názvy vecí
     */
    public String nazvyVeciVBatohu() {
        String nazvy = "";
        for (String jmenoVeci : seznamVeci.keySet()){
            nazvy += jmenoVeci + " ";
        }
        return nazvy;

    }

    /**
     * Vypíše kapacitu batohu
     */
    public int getKapacitaBatohu() {
        return KAPACITA;
    }

}

