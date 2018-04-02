package uiText;

import java.util.Observable;
import java.util.Observer;

/*
 *
 * @author Lenka Šťastná, Filip Vencovský
 * @version pro školní rok 2017/2018
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logika.IHra;
import logika.Prostor;
import logika.Vec;
import logika.Hra;
import javafx.scene.layout.GridPane;

public class HomeController extends AnchorPane implements Observer{
	
	@FXML private TextArea vystup;
	@FXML private TextField vstupniText;
	@FXML private ImageView uzivatel;
	@FXML private ListView<Vec> seznamVeciMistnost;

	private IHra hra;

	@FXML public void odeslaniPrikazu() {
		String radek = vstupniText.getText();
		String odpoved = 
				hra.zpracujPrikaz(radek);
		
		
		vystup.appendText("\n----------\n"+vstupniText.getText()+"\n----------\n");
		vystup.appendText(odpoved);
		
		
		vstupniText.setText("");
		
		if(hra.konecHry()) {
			vstupniText.setDisable(true);
		}
	}

		
		public void inicializuj(IHra hra) {
			vystup.setText(hra.vratUvitani());
			vystup.setEditable(false);
			this.hra = hra;
			seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());
			uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
			uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
			hra.getHerniPlan().addObserver(this);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			seznamVeciMistnost.getItems().clear();
			seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());
			uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
			uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
			
		}
		
	}
	
	




	

