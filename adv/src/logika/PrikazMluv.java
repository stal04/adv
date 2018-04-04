/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kĂłdovĂˇnĂ­: PĹ™Ă­liĹˇ ĹľluĹĄouÄŤkĂ˝ kĹŻĹ� ĂşpÄ›l ÄŹĂˇbelskĂ© Ăłdy. */
package logika;

/*******************************************************************************
 * Instance třídy Mluv představují ...
 *
 * @author Lenka Šťastná
 * @version školský rok 2017/2018
 */
public class PrikazMluv implements IPrikaz {
	private HerniPlan plan;
	private static final String NAZEV = "mluv";

	/**
	 * Konštruktor triedy.
	 *
	 */
	public PrikazMluv(HerniPlan plan) {
		this.plan = plan;
	}

	/**
	 * Príkaz mluv. Všetky postavy v hre vedia hovoriť a posúvajú v hre.
	 * 
	 * @param -
	 *            meno postavy
	 * @return - reč postavy
	 *
	 */

	@Override
	public String provedPrikaz(String... parametry) {
		if (parametry.length == 0) {
			return "Nezadal si s ktorou postavou chceš hovoriť.";
		}
		String jmeno = parametry[0];
		Prostor aktualniProstor = plan.getAktualniProstor();
		Postava postava = aktualniProstor.najdiPostavu(jmeno);
		if (postava == null) {
			return "Postava sa nenachádza v tomto priestore.";
		}
		if (postava.getJmeno().contains("carodej")) {
			return postava.getRec();
		}
		if (postava.getJmeno().contains("vedec")) {
			return postava.getRec();
		}
		if (postava.getJmeno().contains("krcmar")) {
			return postava.getRec();
		}
		if (postava.getJmeno().contains("straz")) {
			return postava.getRec();
		}

		return "Postava neexistuje, alebo sa s ňou nedá rozprávať.";

	}

	/**
	 * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání
	 * 
	 * @ return nazev prikazu
	 */
	@Override
	public String getNazev() {
		return NAZEV;
	}
}
