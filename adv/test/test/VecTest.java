/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package test;

import logika.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * TestovacĂ­ tĹ™Ă­da VecTest slouĹľĂ­ ke komplexnĂ­mu otestovĂˇnĂ­ tĹ™Ă­dy ... 
 *
 * @author    jmĂ©no autora
 * @version   0.00.000
 */
public class VecTest
{
    //== KONSTRUKTORY A TOVĂ�RNĂŤ METODY =========================================
    //-- TestovacĂ­ tĹ™Ă­da vystaÄŤĂ­ s prĂˇzdnĂ˝m implicitnĂ­m konstruktorem ----------

    /***************************************************************************
     * Inicializace pĹ™edchĂˇzejĂ­cĂ­ spuĹˇtÄ›nĂ­ kaĹľdĂ©ho testu a pĹ™ipravujĂ­cĂ­ tzv.
     * pĹ™Ă­pravek (fixture), coĹľ je sada objektĹŻ, s nimiĹľ budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        //inicial
    }

    /***************************************************************************
     * Ăšklid po testu - tato metoda se spustĂ­ po vykonĂˇnĂ­ kaĹľdĂ©ho testu.
     */
    @After
    public void tearDown()
    { //uklid
    }

    /***************************************************************************
     * Testujeme, ÄŤi sa dajĂş veci vloĹľiĹĄ a vytvoriĹĄ a aj prenositelnosĹĄ.
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
