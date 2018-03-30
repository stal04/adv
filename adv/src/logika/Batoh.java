/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

import java.util.Map;
import java.util.HashMap;

/*******************************************************************************
 * Instance tĹ™Ă­dy Batoh pĹ™edstavujĂ­ ...
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   ĹˇkolskĂ˝ rok 2017/2018
 */
public class Batoh
{
    private static final int KAPACITA = 4; //maximĂˇlna kapacita
    private Map<String, Vec> seznamVeci; //Mapa vecĂ­, kÄľĂşÄŤ a priradenĂ© veci

    /**
     * konĹˇtruktor
     */
    public Batoh(){
        seznamVeci = new HashMap<String, Vec>();
    }

    /**
     * VloĹľĂ­ do batohu ak vojde
     * @return true ak sa vloĹľĂ­, false, ak sa nevloĹľila
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
     * ÄŚi sa v batohu nachĂˇdza vec.
     * @return true alebo false, podÄľa toho, ÄŤi sa vec v batohu nachĂˇdza.
     */
    public boolean obsahujeVecBatoh (String jmenoVeci) {
        return seznamVeci.containsKey(jmenoVeci);
    }

    /**
     * Vyberie vec z batohu.
     * @return vec, alebo ak neni v batohu tak null.
     * @param String pri zadanĂ­, ÄŤo sa mĂˇ vybraĹĄ.
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
     * VypĂ­Ĺˇe veci, ktorĂ© sĂş v batohu.
     * @return nĂˇzvy vecĂ­
     */
    public String nazvyVeciVBatohu() {
        String nazvy = "";
        for (String jmenoVeci : seznamVeci.keySet()){
            nazvy += jmenoVeci + " ";
        }
        return nazvy;

    }

    /**
     * VypĂ­Ĺˇe kapacitu batohu
     */
    public int getKapacitaBatohu() {
        return KAPACITA;
    }

}

