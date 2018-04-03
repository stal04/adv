package ui;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

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
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

public class HomeController extends AnchorPane implements Observer{
	
	@FXML private TextArea vystup;
	@FXML private TextField vstupniText;
	@FXML private ImageView uzivatel;
	@FXML private ListView<String> seznamVeciMistnost;
	@FXML private ListView<String> seznamVychodu;
	@FXML private ListView<Postava> seznamPostav;
	
	private MenuItem napoveda;

	private IHra hra;
	private HerniPlan plan;

	@FXML public void odeslaniPrikazu() throws MalformedURLException {
		String radek = vstupniText.getText();
		 if(radek.equals("napoveda")) {
			 vytvorNapovedu();
			 
		} else {
		String odpoved = 
				hra.zpracujPrikaz(radek);
		
		
		vystup.appendText("\n----------\n"+vstupniText.getText()+"\n----------\n");
		vystup.appendText(odpoved);
		
		
		vstupniText.setText("");
		
		if(hra.konecHry()) {
			vstupniText.setDisable(true);
			}
		}
	}
	
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

		
		public void inicializuj(IHra hra) {
			vystup.setText(hra.vratUvitani());
			vystup.setEditable(false);
			this.hra = hra;
			seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().popisVychodu());
			seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().nazvyVeci());
			
			seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPostavy());
			uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
			uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
	
			
			
			hra.getHerniPlan().addObserver(this);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			seznamVychodu.getItems().clear();
			seznamPostav.getItems().clear();
			seznamVeciMistnost.getItems().clear();
			
			seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().nazvyVeci());
			seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPostavy());
			seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().popisVychodu());
			uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
			uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
			
		}
		
		@FXML public void mluv() {
			
		}
	}
	
	




	

