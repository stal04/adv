package test;

import logika.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování třídy Prostor
 *
 * @author Jarmila Pavlíčková, Lenka Šťastná
 * @version pro skolní rok 2017/2018
 */
public class ProstorTest {
	// == Datové atributy (statické i
	// instancí)======================================

	// == Konstruktory a tovární metody
	// =============================================
	// -- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

	// == Příprava a úklid přípravku
	// ================================================

	/***************************************************************************
	 * Metoda se provede před spuštěním každé testovací metody. Používá se k
	 * vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty), s
	 * nimiž budou testovací metody pracovat.
	 */
	@Before
	public void setUp() {
		// inicializacia
	}

	/***************************************************************************
	 * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
	 */
	@After
	public void tearDown() {
		// uklid
	}

	// == Soukromé metody používané v testovacích metodách
	// ==========================

	// == Vlastní testovací metody
	// ==================================================

	/**
	 * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
	 * nemusí odpovídat vlastní hře,
	 */
	@Test
	public void testLzeProjit() {
		Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě");
		Prostor prostor2 = new Prostor("bufet", "bufet, kam si můžete zajít na svačinku");
		prostor1.setVychod(prostor2);
		prostor2.setVychod(prostor1);
		assertEquals(prostor2, prostor1.vratSousedniProstor("bufet"));
		assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
	}

	/**
	 * postavy
	 */
	@Test
	public void testPostava() {
		Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě");
		Postava postava1 = new Postava("Ivana", "ahoj");

		prostor1.vlozPostavu(postava1);

		assertEquals(postava1, prostor1.najdiPostavu("Ivana"));
	}

	/**
	 * veci
	 */
	@Test
	public void testVec() {
		Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě");
		Vec vec = new Vec("kniha", true);

		prostor1.vlozVec(vec);

		assertEquals(true, prostor1.obsahujeVec("kniha"));
	}

}
