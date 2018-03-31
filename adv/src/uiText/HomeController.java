package uiText;

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
import javafx.scene.layout.AnchorPane;
import logika.IHra;
import logika.Prostor;
import logika.Vec;
import logika.Hra;


public class HomeController extends AnchorPane{
	
	@FXML private TextArea vystup;
	@FXML private TextField vstupniText;
	

	private IHra hra;

	@FXML public void odeslaniPrikazu() {
		String radek = vstupniText.getText();
		String odpoved = hra.zpracujPrikaz(radek);
		vystup.setText(odpoved);
		vstupniText.setText("");
	}
	
	




	
}
