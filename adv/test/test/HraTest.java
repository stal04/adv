package test;
import logika.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková, Lenka Šťastná
 * @version  pro školní rok 2017/2018
 */
public class HraTest {
    private Hra hra1;
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
        //uklid
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Testujem aj, či sa v miestnosti nachádza postava a vec.
     * 
     */
    @Test
    public void testPrubehHry() {
        
        assertEquals("kralovstvi", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi hospoda ");
        assertEquals("hospoda", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("seber pivo ");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi knihovna");
        assertEquals("knihovna", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals("recept ", hra1.getHerniPlan().getAktualniProstor().nazvyVeci());
        hra1.zpracujPrikaz("seber recept");

        hra1.zpracujPrikaz("jdi hospoda ");
        assertEquals("hospoda", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("seber tlacenka  ");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("dej recept krcmar");

        hra1.zpracujPrikaz("seber mapa");

        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("jdi vedec");
        assertEquals("vedec", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals("vedec ", hra1.getHerniPlan().getAktualniProstor().nazvyPostav());

        hra1.zpracujPrikaz("res_rovnici jedna");
        hra1.zpracujPrikaz("res_rovnici nula");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("seber diamant");
        assertEquals(false, hra1.konecHry());

        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());

    }
    
}
