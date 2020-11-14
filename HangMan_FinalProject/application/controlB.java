package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class controlB {

	
	@FXML
	private Label Category_label; // used to grab text from the 
	
	@FXML
	private TextField AnswerBox; // where the user will input their text
	
	@FXML
	private Button guessBttn; // button for guess letters of mystery word
	
	@FXML
	private Button guessFullWord; // button thats selected when user wants to guess full word
	
	@FXML
	private Label wordDashes; // used to put the ___ for the word
	
	
	@FXML
	private Label missedLetters; // all missed letters user guess will get added to this label
	
	
	// these are the diffrent body parts of the hangman they will all initially be set to 
	// invisible depending on the missed guesses of the user will set the visible property
	// of each bodypart to true
	
	@FXML 
	private Circle headShape; // the head of the hangman
	
	@FXML 
	private Line spine; // the hangman spine 
	
	
	@FXML 
	private Line leftArmLine; // hangman left arm 
	
	
	@FXML 
	private Line rightArmLine; // hangman right arm
	
	
	@FXML 
	private Line leftLegLine; // hangman left leg
	
	
	@FXML
	private Line rightLegLine; // hangman right leg
	
	

	
	public void initialize() {
		
		makeInvisible(); // set all limbs of hangman to invisible when game first starts up
		
		
		
		// grab the text from the Category_label  and use that to select matching txt file 
		
		// open and read file 

		// grab random word 
		
		
	}
	
	
	
	
	// set all the limbs of hangman to invisible
	public void makeInvisible() {
		
		headShape.setVisible(false);
		spine.setVisible(false);
		leftArmLine.setVisible(false);
		rightArmLine.setVisible(false);
		leftLegLine.setVisible(false);
		rightLegLine.setVisible(false);
		
		
	}
	
	
	// used to grab the category word from the first scenes controller
	public void SetCategory(String text) {
		
		
		Category_label.setText(text);
	}
	
	

}
