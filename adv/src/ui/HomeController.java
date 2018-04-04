package ui;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

import javax.swing.JMenuItem;

import javafx.event.ActionEvent;

/*
 *
 * @author Lenka Šťastná, Filip Vencovský
 * @version pro školní rok 2017/2018
 */

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logika.IHra;
import logika.Postava;
import logika.Prostor;
import logika.Vec;
import logika.HerniPlan;
import logika.Hra;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Class HomeController - třída představující mapu a stav adventury.
 * 
 * Tato třída inicializuje prvky ze kterých se hra skládá: vytváří všechny
 * prostory, propojuje je vzájemně pomocí východů a pamatuje si aktuální
 * prostor, ve kterém se hráč právě nachází.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Lenka Šťastná
 * @version pro školní rok 2017/2018
 */
public class HomeController extends AnchorPane implements Observer {

	@FXML
	private TextArea vystup;
	@FXML
	private TextField vstupniText;
	@FXML
	private ImageView uzivatel;
	@FXML
	private ListView<Vec> seznamVeciMistnost;
	@FXML
	private ListView<String> seznamVychodu;
	@FXML
	private ListView<Postava> seznamPostav;
	@FXML
	private Tooltip tooltip;
	@FXML
	private ContextMenu cm;
	private String postava;

	private IHra hra;
	private HerniPlan plan;

	/**
	 * Metóda, ktorá sa spája s fxml súborom, ktoý obsahuje grafiku programu,
	 * zakláda scénu.
	 */
	@FXML
	public void odeslaniPrikazu() throws MalformedURLException {
		String radek = vstupniText.getText();
		if (radek.equals("napoveda")) {
			vytvorNapovedu();
		} else if (radek.equals("konec")) {
			konecHry();
		} else {
			String odpoved = hra.zpracujPrikaz(radek);

			vystup.appendText("\n----------\n" + vstupniText.getText() + "\n----------\n");
			vystup.appendText(odpoved);

			vstupniText.setText("");

			if (hra.konecHry()) {
				vstupniText.setDisable(true);
			}
		}
	}

	/**
	 * Metóda, ktorá vracia html nápovedu po kliknutí na "Nápoveda" menuitem.
	 */
	public void vytvorNapovedu() throws MalformedURLException {
		File file = new File("C:\\Users\\Lenka Šťastná\\git\\adv\\resources\\main\\napoveda.html");
		URL url = file.toURI().toURL();
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load(url.toString());
		Scene scene = new Scene(browser);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Metóda, ktorá vracia koniec hry. Najskôr sa Alertom spýta, či naozaj chceš
	 * hru ukončiť, ak klikneš ok, hru ukončí.
	 */
	public void konecHry() {
		Alert al = new Alert(AlertType.CONFIRMATION, "Chcete hru naozaj ukončiť?");
		al.setHeaderText("Ukončenie hry");
		Optional<ButtonType> result = al.showAndWait();
		if (result.get() == ButtonType.OK) {
			String odpoved = hra.zpracujPrikaz("konec");
			vstupniText.setDisable(true);
			System.exit(0);
		}
		al.close();
	}

	/**
	 * Metóda, ktorá po kliknutí na menuitemn "Nová hra" vyhodí alert, či chceš
	 * naozaj hru ukončiť a začať novú. Ak Ok, spusší novú hru inak sa alert zavrie.
	 */
	public void novaHra() {
		Alert al = new Alert(AlertType.CONFIRMATION, "Chcete naozaj spustiť novú hru");
		al.setHeaderText("Nová hra");
		Optional<ButtonType> result = al.showAndWait();
		if (result.get() == ButtonType.OK) {
			String odpoved = hra.zpracujPrikaz("konec");
			IHra hra = new Hra();

			seznamVychodu.getItems().clear();
			seznamPostav.getItems().clear();
			seznamVeciMistnost.getItems().clear();
			inicializuj(hra);
		}
		al.close();
	}

	/**
	 * Metóda, ktorá inicializuje hru, vracia uvítanie, vyprázdnuje polia s vychodmi
	 * vecami a postavami.
	 */

	public void inicializuj(IHra hra) {
		vystup.setText(hra.vratUvitani());
		vystup.setEditable(false);
		this.hra = hra;
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().popisVychodu());
		seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());

		seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPostavy());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());

		Tooltip tooltip = new Tooltip();
		tooltip.setText("Zadaj vstupný príkaz");
		vstupniText.setTooltip(tooltip);

		tooltip.setText("Pravým kliknutím môžte inicializovať príkaz mluv.");
		seznamPostav.setTooltip(tooltip);

		hra.getHerniPlan().addObserver(this);
	}

	/**
	 * Metóda, ktorá updatuje polia s východom, postavami a východmi
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		seznamVychodu.getItems().clear();
		seznamPostav.getItems().clear();
		seznamVeciMistnost.getItems().clear();
		seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());

		seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPostavy());

		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().popisVychodu());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
	}

	/**
	 * Metóda, ktorá po kliknutí na contextmenu item vracia reč vybranej postavy
	 */
	public void mluv() {

		String odpoved = hra.zpracujPrikaz("mluv " + seznamPostav.getSelectionModel().getSelectedItem());

		vystup.appendText("\n----------\n" + vstupniText.getText() + "\n----------\n");
		vystup.appendText(odpoved);

	}

	/**
	 * Metóda, ktorá po kliknutí na contextmenu item vykoná príkaz seber predmet
	 */
	public void seber() {

		String odpoved = hra.zpracujPrikaz("seber " + seznamVeciMistnost.getSelectionModel().getSelectedItem());

		vystup.appendText("\n----------\n" + vstupniText.getText() + "\n----------\n");
		vystup.appendText(odpoved);

	}

}
