/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package test;
import logika.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * TestovacĂ­ tĹ™Ă­da PostavaTest slouĹľĂ­ ke komplexnĂ­mu otestovĂˇnĂ­ tĹ™Ă­dy ... 
 *
 * @author    jmĂ©no autora
 * @version   0.00.000
 */
public class PostavaTest
{
    //== KONSTRUKTORY A TOVĂ�RNĂŤ METODY =========================================
    //-- TestovacĂ­ tĹ™Ă­da vystaÄŤĂ­ s prĂˇzdnĂ˝m implicitnĂ­m konstruktorem ----------

    /***************************************************************************
     * Inicializace pĹ™edchĂˇzejĂ­cĂ­ spuĹˇtÄ›nĂ­ kaĹľdĂ©ho testu a pĹ™ipravujĂ­cĂ­ tzv.
     * pĹ™Ă­pravek (fixture), coĹľ je sada objektĹŻ, s nimiĹľ budou testy pracovat.
     */
    @Before
    public void setUp()
    {//inicializacia
    }

    /***************************************************************************
     * Ăšklid po testu - tato metoda se spustĂ­ po vykonĂˇnĂ­ kaĹľdĂ©ho testu.
     */
    @After
    public void tearDown()
    {
        //uklid
    }

    /***************************************************************************
     * Test vzniku postĂˇv.
     */
    @Test
    public void testik(){
        Postava postava1 = new Postava("Pes", "ahojky");
        assertEquals("Pes", postava1.getJmeno());
        assertEquals("ahojky", postava1.getRec());

    }
}
