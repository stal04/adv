/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance tĹ™Ă­dy Vec pĹ™edstavujĂ­ ...
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   ĹˇkolskĂ˝ rok 2017/2018
 */
public class Vec
{
    private String jmeno;
    private boolean prenositelna;

    /***************************************************************************
     * Konstruktor
     */
    public Vec (String jmeno, boolean prenositelna) 
    {
        this.jmeno = jmeno;
        this.prenositelna = prenositelna;
    }

    /**
     * @return vracia meno veci
     */
    public String getJmeno () {
        return jmeno;
    }

    /**
     * @return vracia, ÄŤi je vec prenositeÄľnĂˇ, zobrateÄľnĂˇ
     */
    public boolean jePrenositelna() {
        return prenositelna;
    }
}
