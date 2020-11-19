package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controlA {

	
	@FXML
	private ChoiceBox choicebox;
	
	@FXML
	private Button Select_Bttn;
	
	
	Stage prevStage;
	
	
	
	public void initialize() {
		
		
		// sets the intial text in choicebox 
		choicebox.setValue("Select Category");
		
		// sets the choicebox items 
		choicebox.getItems().add("fruit");
	    choicebox.getItems().add("movies");
	    choicebox.getItems().add("animals");
	    choicebox.getItems().add("country");
	    choicebox.getItems().add("restaurants");
		
	}
	


public void setPrevStage(Stage stage) {
		
		this.prevStage = stage; // set stage to SceneA
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
	
	
	//controlB control = loader3.getController();
	
	

	//prevStage.close(); // close Scene A
	
	stage.show();
	
	
	}catch (IOException io) {
		io.printStackTrace();
	}

	
	
}


	// button to select item from choice box 
	public void ButtonEvent() {
		
		
		if (choicebox.getValue() != "Select Category")
		{
			
			 // load fxml file and display it in the stage:
			// need to send the chosen category to Scene B
				
				try {
					Stage stage = new Stage();
					FXMLLoader loader2 = new FXMLLoader(getClass().getResource("SceneB.fxml"));
					
					
					Parent root2 = loader2.load();
					Scene sceneB = new Scene(root2);
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
