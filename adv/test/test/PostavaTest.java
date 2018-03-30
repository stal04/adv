/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package test;
import logika.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída PostavaTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PostavaTest
{
    //== KONSTRUKTORY A TOVĂ�RNĂŤ METODY =========================================
    //-- TestovacĂ­ tĹ™Ă­da vystaÄŤĂ­ s prĂˇzdnĂ˝m implicitnĂ­m konstruktorem ----------

	/***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {//inicializacia
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
        //uklid
    }

    /***************************************************************************
     * Test vzniku postáv.
     */
    @Test
    public void testik(){
        Postava postava1 = new Postava("Pes", "ahojky");
        assertEquals("Pes", postava1.getJmeno());
        assertEquals("ahojky", postava1.getRec());

    }
}
