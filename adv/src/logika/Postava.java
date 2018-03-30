/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;


/*******************************************************************************
 * Instance tĹ™Ă­dy Postava pĹ™edstavujĂ­ ...
 *
 * @author    Lenka Ĺ ĹĄastnĂˇ
 * @version   ĹˇkolskĂ˝ rok 2017/2018
 */
public class Postava
{
    private String jmeno;
    private String rec;

    /***************************************************************************
     * KonĹˇtruktor nastavĂ­ meno a reÄŤ postĂˇv
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
     * Metoda vracia reÄŤ postavy.
     * 
     * @return   String reÄŤ
     */
    public String getRec() {
        return rec; 
    }
}
