package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class controlA {

	
	@FXML
	private ChoiceBox<String> choicebox;
	
	@FXML
	private Button Select_Bttn;
	
	
	Stage prevStage;
	
	
	public void initialize() {
		
		
		// sets the choicebox to have the category lists
		choicebox.getItems().add("fruit");
	    choicebox.getItems().add("movies");
	    choicebox.getItems().add("animals");
	    choicebox.getItems().add("country");
	    choicebox.getItems().add("restaurants");
	}
	


// set stage to SceneA
public void setPrevStage(Stage stage) {
		
		this.prevStage = stage; 
	}
	
	

// about page button should open another window
public void Menu_AboutEvent() {
	
	try {
	Stage stage = new Stage();
	FXMLLoader loader3 = new FXMLLoader(getClass().getResource("AboutScene.fxml"));
	
	
	Parent root3 = loader3.load();
	Scene sceneC = new Scene(root3);
	stage.setResizable(false);
	stage.setTitle("About Hangman");
	stage.setScene(sceneC);
	
	stage.show();
	
	
	}catch (IOException io) {
		io.printStackTrace();
	}

	
	
}


	// button to select item from choice box 
	public void ButtonEvent() {
		
		
		if (choicebox.getValue() != "Select Category")
		{
			
				// load the fxml file and display it in the stage
				// then send the chosen category to the sceneB
				try {
					Stage stage = new Stage();
					FXMLLoader loader2 = new FXMLLoader(getClass().getResource("SceneB.fxml"));
					
					
					Parent root2 = loader2.load();
					Scene sceneB = new Scene(root2);
					stage.setTitle("Hangman Game");
					stage.setScene(sceneB);
					controlB control = loader2.getController();
					
					
					// grabs the chosen category and sends it to the second scene 
					control.SetCategory(choicebox.getValue().toString());
					
					stage.show();
					
					
					Stage stage2 = (Stage) Select_Bttn.getScene().getWindow();
				    stage2.close();
				
				
				}catch (IOException io) {
					io.printStackTrace();
				}

		}
	
	
	
}
	
}