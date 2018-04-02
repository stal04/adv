/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;


/*******************************************************************************
 * Instance třídy Postava představují ...
 *
 * @author    Lenka Šťastná
 * @version   školský rok 2017/2018
 */
public class Postava
{
    private String jmeno;
    private String rec;

    /***************************************************************************
     * Konštruktor nastaví meno a reč postáv
     */
    public Postava(String jmeno, String rec)
    {
        this.jmeno = jmeno;
        this.rec = rec;
    }

    /**
     * Metoda vracia meno.
     * 
     * @return   String meno postavy
     */
    public String getJmeno() {
        return jmeno; 
    }

    /**
     * Metoda vracia reč postavy.
     * 
     * @return   String reč
     */
    
    public String getRec() {
        return rec; 
    }
    
    @Override
    public String toString() {
    	return getJmeno();
    }
}
