/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance třídy Vec představují ...
 *
 * @author    Lenka Šťastná
 * @version   školský rok 2017/2018
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
     * @return vracia, či je vec prenositeľná, zobrateľná
     */
    public boolean jePrenositelna() {
        return prenositelna;
    }
    @Override
    public String toString() {
    	return getJmeno();
    }
    
}
