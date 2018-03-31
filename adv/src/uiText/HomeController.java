package uiText;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logika.IHra;
import logika.Hra;


public class HomeController extends AnchorPane{
	
	@FXML private TextArea vystup;
	@FXML private TextField vstupniText;
	private IHra hra;

	@FXML public void odeslaniPrikazu() {
		String prikaz = vstupniText.getText();
		String odpoved = hra.zpracujPrikaz(prikaz);
		vystup.setText(odpoved);
		vstupniText.setText("");
	}
	



	
}
