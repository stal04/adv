package uiText;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logika.*;

/**
 * Třída slouží ke spuštění adventury.
 * Při spuštění bez parametru konstruuje okno aplikace,
 * s parametrem -text se spouští v textovém režimu
 * 
 * @author Filip Vencovsky
 *
 */
public class Application extends javafx.application.Application {
	
    public static void main(String[] args) {
    if (args.length == 0) {
        launch(args);
    } else {
        if (args[0].equals("-text")) {
            IHra hra = new Hra();
            TextoveRozhrani ui = new TextoveRozhrani(hra);
            ui.hraj();
        } else {
            System.out.println("Neplatný parameter");
        }
    }
}

    /**
	 * Metoda, ve které se konstruuje okno, kontroler a hra,
	 * která se předává kontroleru
	 */
    
public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        
	
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		         .getResource("Home.fxml"));
	  Parent root = loader.load();

	
     
		HomeController controller = loader.getController();
		controller.inicializuj(new Hra());
		
        primaryStage.setTitle("title");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
       
}
}

