/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logika.*;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class BatohTest
{
    //== KONSTRUKTORY A TOVĂ�RNĂŤ METODY =========================================
    //-- TestovacĂ­ tĹ™Ă­da vystaÄŤĂ­ s prĂˇzdnĂ˝m implicitnĂ­m konstruktorem ----------

	 /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()    {
        //inicializacia
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
     * Testovanie kapaciy a prenositelnosti.
     */
    @Test
    public void testBatohu(){
        Batoh batoh = new Batoh();

        Vec stadion = new Vec ("stadion", false);
        Vec voda = new Vec ("voda", true);
        Vec kniha = new Vec ("kniha", true);
        Vec jedlo = new Vec ("jedlo", true);
        Vec pero = new Vec ("pero", true);
        Vec zosit = new Vec ("zosit", true);

        assertEquals (false, batoh.vlozVecDoBatohu(stadion));
        batoh.vlozVecDoBatohu(voda);
        assertEquals (true, (batoh.vlozVecDoBatohu(voda) ) );

        batoh.vlozVecDoBatohu(jedlo);
        assertEquals (true, batoh.vlozVecDoBatohu(jedlo));

        batoh.vlozVecDoBatohu(kniha);
        assertEquals (true, (batoh.obsahujeVecBatoh("kniha") ) );

        batoh.vlozVecDoBatohu(pero);
        assertEquals (true, (batoh.obsahujeVecBatoh("pero") ) );

        batoh.vlozVecDoBatohu(zosit);
        assertEquals (false, (batoh.obsahujeVecBatoh("zosit") ) );


        
    }

    /***************************************************************************
     * Testovanie vyberania.
     */
    @Test
    public void testVyberania(){
        Batoh batoh = new Batoh();
        Vec kniha = new Vec ("kniha", true);

        batoh.vyberVecZBatohu("kniha");
        assertEquals (false, (batoh.obsahujeVecBatoh("zosit") ) );
    }

    /***************************************************************************
     * Testovanie obsahu.
     */
    @Test
    public void testObsahu(){
        Batoh batoh = new Batoh();
        Vec kniha = new Vec ("kniha", true);
        Vec jedlo = new Vec ("jedlo", true);

        batoh.vlozVecDoBatohu(kniha);
        batoh.vlozVecDoBatohu(jedlo);
        assertEquals ("kniha jedlo ", (batoh.nazvyVeciVBatohu() ) );
    }
}
