/*FINAL VERSION OF HANGMAN PROJECT
 * Developers: Karmen Freeman, Rukia Ambasha, Lorenzo McDaniel, Munayfah Albaqami, and Katherine Arnold
 * Instructor: Dr. Al-Tobasei
 * Class: CSCI 3033
 * Description: This is the main startup class for the game. 
 */
package application;
	
import javafx.application.Application; 
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	//application width
	private static final int APP_W = 700;
	
	//application height
	private static final int APP_H = 500; 
	
	@Override
	public void start(Stage primaryStage) throws Exception {

	   // load FXML file and display it in the stage
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneA.fxml"));
		
		Parent root = loader.load();
		Scene sceneA = new Scene(root);
		
		// loads the controller for SceneA
		controlA control = loader.getController(); 
		
		control.setPrevStage(primaryStage);

	    primaryStage.setResizable(false);
	    primaryStage.setWidth(APP_W);
	    primaryStage.setHeight(APP_H);
	    primaryStage.setTitle("Hangman Game");
	    primaryStage.setScene(sceneA);
	    primaryStage.show();
	   
	 }
	
	//launches the application
	public static void main(String[] args) {
		launch(args);
	}
}
