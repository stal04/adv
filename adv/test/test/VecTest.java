/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package test;

import logika.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída VecTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class VecTest
{
   

	 /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        //inicial
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    { //uklid
    }

    /***************************************************************************
     * Testujeme, či sa dajú veci vložiť a vytvoriť a aj prenositelnosť.
     */
    @Test
    public void testVlozVeci()
    {
        HerniPlan plan = new HerniPlan();
        Vec vec1 = new Vec("kniha", true);
        Vec vec2 = new Vec("lopta", true);
        Vec vec3 = new Vec("stadion", false);
        Vec vec4 = new Vec("mesiac", false);

        assertEquals (true, plan.getBatoh().vlozVecDoBatohu(vec1));
        assertEquals (true, plan.getBatoh().vlozVecDoBatohu(vec2));
        assertEquals (false, (plan.getBatoh().vlozVecDoBatohu(vec3))); //vec sa nevloĹľĂ­
        assertEquals (false, (plan.getBatoh().vlozVecDoBatohu(vec4))); //vec sa nevloĹľĂ­
    }
}
