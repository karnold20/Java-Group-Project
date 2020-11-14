package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private static final int APP_W = 900; //application width
	private static final int APP_H = 500; //application height
	
	@Override
	public void start(Stage primaryStage) throws Exception {

	   // load fxml file and display it in the stage:
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneB.fxml"));
		Parent root = loader.load();
	    Scene scene = new Scene(root);
	    primaryStage.setResizable(false);
	    primaryStage.setWidth(APP_W);
	    primaryStage.setHeight(APP_H);
	    primaryStage.setTitle("Hangman_Game");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	   
	 }
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
