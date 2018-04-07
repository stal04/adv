package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logika.Hra;
import logika.IHra;
import ui.HomeController;
import ui.TextoveRozhrani;

/**
 * Class Start - trieda, ktorá spúšťa celý program
 * 
 * Táto trieda je tvorená najdôležitejšou metódou celého programu, vďaka ktorej sa spustí.
 *
 * @author Filip Vencovský, Lenka Šťastná
 * @version pro školní rok 2017/2018
 */
public class Start extends javafx.application.Application {
 
	/**
	 * Metóda, ktorá sa spája s textovým rozhraním a spúšťa hru
	 */
	
	public static void main(String[] args) {
		if (args.length == 0) {
			launch(args);
		} else {
			if (args[0].equals("-text")) {
				IHra hra = new Hra();
				TextoveRozhrani ui = new TextoveRozhrani(hra);
				ui.hraj();
			} else {
				System.out.println("Neplatný parametr");
			}
		}
	}
	
	/**
	 * Metóda, ktorá sa spája s fxml súborom, ktoý obsahuje grafiku programu, zakláda scénu.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Home.fxml"));

		Parent root = loader.load();
		HomeController c = loader.getController();
		c.inicializuj(new Hra());

		primaryStage.setTitle("Adventúra Dračie kráľovstvo");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}
