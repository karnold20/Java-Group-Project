package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class controlB {

	public String mysteryWord;
	public int numGuesses = 6;
	
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
		
		// set mysteryWord
		mysteryWord = "apple";
		
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
	
	// checks the number of guess and makes hangman limbs
	// visible depending on how many guesses remain
	public void makeVisible(int guess) {
		
		// 
		if (guess == 5)
		{
			
			headShape.setVisible(true);
		}
		else if (guess == 4)
		{
			
			spine.setVisible(true);
		}
		else if (guess == 3)
		{
			
			leftArmLine.setVisible(true);
		}
		else if (guess == 2)
		{
			
			rightArmLine.setVisible(true);
		}
		else if (guess == 1)
		{
			
			leftLegLine.setVisible(true);
		}
		else if (guess == 0)
		{
			
			rightLegLine.setVisible(true);
		
		
			// game is over disable the textfield and two buttons
			// and output that user lost game in the textfield
			
			guessBttn.setVisible(false);
			
			guessFullWord.setVisible(false);
			
			
			AnswerBox.setDisable(true); // 
			
			AnswerBox.setText("You lost");	
			
			
		}
		
		
	}
	
	
	
	// used to grab the category word from the first scenes controller
	public void SetCategory(String text) {
		
		
		Category_label.setText(text);
	}
	
	
	
	
	// button event for guessing the entire word 
	public void GuessFullWordEvent(String text) {
		
		
		
		
	}
	

	
	
	/*
	
	public void onButtonClicked(){
		String newWord;
		String guess = AnswerBox.getText(); //convert char obtained from TextField to String
		char myGuess = guess.charAt(0); //convert String to char
		if(guessIsRight(mysteryWord,myGuess)){ //test to see if letter is in secretWord
			newWord = updateWordState(); //change _ to letter if player made correct guess
			wordDashes.setText(newWord); //convert String to label
		}
		else{
			//update hangman picture  
			
			//make part of hangmanPicture visible if player made incorrect guess
			
			numGuesses--;
			makeVisible(numGuesses);
		}
	}
	//checks if letter is in secret word
	public boolean guessIsRight(String secretWord, char guess){
		for (int i=0; i<secretWord.length(); i++){
			char secretLetter = secretWord.charAt(i);
			if (secretLetter == guess){
				return true;
			}
		}
		return false;
	}
	
	
	//updates word state
	public String updateWordState(String secretWord,String wordDashes,char guess){
		String word = wordDashes.toString();     //convert Label to String
		  char [] myword = word.toCharArray();        //convert String to charArray
		for (int i=0; i<secretWord.length(); i++){
			
			char secretLetter = secretWord.charAt(i);
			
			if (secretLetter == guess){
				myword[i] = secretLetter;      //update letters
			}
		}
		word = String.valueOf(myword); //convert to String
		return word;	
	}

	
	*/
	
	

}
