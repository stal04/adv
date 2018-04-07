package logika;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Třída Hra - třída představující logiku adventury.
 * 
 * Toto je hlavní třída logiky aplikace. Tato třída vytváří instanci třídy
 * HerniPlan, která inicializuje mistnosti hry a vytváří seznam platných příkazů
 * a instance tříd provádějící jednotlivé příkazy. Vypisuje uvítací a ukončovací
 * text hry. Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Lenka Šťastná
 * @version pro školní rok 2017/2018
 */

public class Hra implements IHra {
	private SeznamPrikazu platnePrikazy; // obsahuje zoznam prípustných príkazov
	private HerniPlan plan;
	private boolean konecHry = false; // inicializácia
	private Batoh batoh;

	/**
	 * Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a
	 * seznam platných příkazů.
	 */
	public Hra() {
		plan = new HerniPlan();
		platnePrikazy = new SeznamPrikazu();
		platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
		platnePrikazy.vlozPrikaz(new PrikazJdi(plan));
		platnePrikazy.vlozPrikaz(new PrikazKonec(this));
		platnePrikazy.vlozPrikaz(new PrikazMluv(plan));
		platnePrikazy.vlozPrikaz(new PrikazSeber(plan));
		platnePrikazy.vlozPrikaz(new PrikazObsahBatohu(plan));
		platnePrikazy.vlozPrikaz(new PrikazDej(plan, batoh));
		platnePrikazy.vlozPrikaz(new PrikazResRovnici(plan));
		platnePrikazy.vlozPrikaz(new PrikazPomoc(plan));
		batoh = plan.getBatoh();
	}

	/**
	 * Vrátí úvodní zprávu pro hráče.
	 */
	public String vratUvitani() {
		return "Vitajte! " + "Toto je príbeh o ukradnotom drakovi a dvoch nepriateľských kráľovstvách.\n"
				+ "Napíšte 'napoveda', ak neviete základné vlastnosti hry. Napíšte 'pomoc', ak potrebujete pomoc konkrétne v miestnosti. Začni v hospode, tam vedia všetko. Nezabudni sa s každou postavou porozprávať.\n"
				+ plan.getAktualniProstor().dlouhyPopis();
	}

	/**
	 * Vrátí závěrečnou zprávu pro hráče.
	 */
	public String vratEpilog() {
		return "Ďakujeme za hru, zase nabudúce!";
	}

	/**
	 * Vracia true, ak hra skončila.
	 */
	public boolean konecHry() {
		return konecHry;
	}

	/**
	 * Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a
	 * další parametry. Pak otestuje zda příkaz je klíčovým slovem např. jdi. Pokud
	 * ano spustí samotné provádění příkazu.
	 *
	 * @param radek
	 *            text, který zadal uživatel jako příkaz do hry.
	 * @return vrací se řetězec, který se má vypsat na obrazovku
	 */
	public String zpracujPrikaz(String radek) {
		String[] slova = radek.split("[ \t]+");
		String slovoPrikazu = slova[0];
		String[] parametry = new String[slova.length - 1];
		for (int i = 0; i < parametry.length; i++) {
			parametry[i] = slova[i + 1];
		}
		String textKVypsani = " .... ";

		if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
			IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
			textKVypsani = prikaz.provedPrikaz(parametry);

			if (plan.jeProhra()) { // pri riešení rovnice a nesprávnych 3 odpovediach nastane koniec hry
				setKonecHry(true);
				textKVypsani = "Bohužial si neuhádol rovnicu.";
			} else {
				if (plan.nazevProstoru().equals("kralovstvi") && batoh.obsahujeVecBatoh("drak")) { // hra sa ukončuje,
																									// ak prinesie draka
																									// do kralovstva
					setKonecHry(true); //
					return "Gratulujem, vyhral si!";

				}
			}
		}

		else {
			textKVypsani = "Tento príkaz nepoznám. Vyber jeden zo zoznamu:  dej, seber, mluv, napoveda, konec, res_rovnici, jdi, obsah_batohu, pomoc";
		}
		return textKVypsani;
	}

	/**
	 * Nastaví, že je konec hry, metodu využívá třída PrikazKonec, mohou ji použít i
	 * další implementace rozhraní Prikaz.
	 * 
	 * @param konecHry
	 *            hodnota true=konec hry, false=hra pokračuje
	 */
	public void setKonecHry(boolean konecHry) {
		this.konecHry = konecHry;
	}

	/**
	 * Metoda vrátí odkaz na herní plán, je využita hlavně v testech, kde se jejím
	 * prostřednictvím získává aktualní místnost hry.
	 * 
	 * @return odkaz na herní plán
	 */
	public HerniPlan getHerniPlan() {
		return plan;
	}

}
