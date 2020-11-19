package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class controlB {

	public String mysteryWord;
	public int numGuesses = 6;
	public String wordState = "";
	public String lettersGuessed = "";
	@FXML
	private Label Category_label; // used to grab text from the 
	
	@FXML
	private TextField AnswerBox; // where the user will input their text
	
	@FXML
	private Label resultMessage; // where the lost, won messages go
	
	@FXML
	private Button guessBttn; // button for guess letters of mystery word
	
	@FXML
	private Button guessFullWord; // button thats selected when user wants to guess full word
	
	@FXML
	private Label wordDashes; // used to put the ___ for the word
	
	
	@FXML
	private Label missedLetters; // all missed letters user guess will get added to this label
	
	@FXML
	private Button playAgain; // playAgain button to reset game
	
	@FXML
	private Label revealLabel;

	@FXML
	private ChoiceBox<String> choicebox;
	
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
	
	
	
	
	
	
	
	public void initialize() throws IOException {
		
		// set all limbs of hangman to invisible when game first starts up
		makeInvisible(); 
		
		Platform.runLater(() -> { 
		
			String filename = Category_label.getText();

		
			String option = null;
			switch (filename)
				{
					case "animals":
						option = "animals.txt"; //animal text file
						break;
					case "country":
						option = "country.txt"; //country text file
						break;
					case "fruit":
						option = "fruit.txt"; //fruit text file
						break;
					case "movies":
						option = "movies.txt"; //movies text file
						break;
					case "restaurants":
						option = "restaurants.txt"; //restaurants text file
						break;
				}
		
		
			//read the file contents
			FileReader file_Reader = null;
			try {
				file_Reader = new FileReader (option);
				} catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
			
			
			BufferedReader Buff_Reader = new BufferedReader (file_Reader);
		
		
			//declare an array to hold the number of the words
			//and initilize it with 30 words maximum
			String allWords[];
			allWords = new String[30];
		
			String string;
		
		
			//declare and initilize count to zero to hold
			//the the numbers of lines in the file
			int count = 0; 
		
		
			//check that the file is not empty
			try {
				while ((string = Buff_Reader.readLine()) != null) {
				allWords[count]=string;
				count++;	
				}
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		
			//instance of random class
			Random rand = new Random(); 
	
			//generate random values from 1 to number store in count
			int upperbound = count;    
			int int_random = rand.nextInt(upperbound); 
			
			// set mysteryWord
			mysteryWord = allWords[int_random];
			
			printStars(); // print the dashes for mystery word 
			
		});
	}
	
	
	
	// prints the dashes for mystery word 
	public void printStars()
	{
		for( int i = 0; i < mysteryWord.length() ; i++)
		{
			if (mysteryWord.charAt(i) == ' ')
			{
				
				wordState+=' ';	
			}
			else
			{
				wordState+="*"; 
			}
		}
		wordDashes.setText(wordState);
	}
	
	
	
	// set all the limbs of hangman to invisible
	public void makeInvisible() {
		
		headShape.setVisible(false);
		spine.setVisible(false);
		leftArmLine.setVisible(false);
		rightArmLine.setVisible(false);
		leftLegLine.setVisible(false);
		rightLegLine.setVisible(false);
		playAgain.setVisible(false);
		revealLabel.setVisible(false);
		
		
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
			GameOver();
		
		}
		
	}
	
	
	
	
	// used to grab the category word from the first scenes controller
	public void SetCategory(String text) {
		
		
		Category_label.setText(text);
	}
	
	
	
	
	// function that informs user they won the game
	// by printing a win message in the screen
	public void GameWin () {
		
		wordDashes.setText(mysteryWord);
		guessBttn.setVisible(false);
		guessFullWord.setVisible(false);
		AnswerBox.setDisable(true); //can no longer use the text box
		resultMessage.setText("          Great Job!!\nYou Guessed the Word!!");
		playAgain.setVisible(true); 
		
	}
	
	
	
	// function that informs user they lost the game
	// by printing a lost message in the screen
	public void GameOver(){

		guessBttn.setVisible(false);
		guessFullWord.setVisible(false);
		AnswerBox.setDisable(true); //can no longer use the text box
		resultMessage.setText("      Sorry!! You Lost.\nLet's Try to Play Again!");
		playAgain.setVisible(true);
		revealLabel.setText("The mystery word was:");
		revealLabel.setVisible(true);
		wordDashes.setText(mysteryWord);
	}
	
	
	
	// button event for guessing the entire word 
	public void GuessFullWordEvent() {
		
		String finalGuess = AnswerBox.getText();
		finalGuess = finalGuess.toLowerCase(); // the answer is not case sensitive

		if(finalGuess.equals(mysteryWord))
		{
			resultMessage.setText("You win!!");
			GameWin ();
		}
		else
		{
			resultMessage.setText("You Lose.");
			GameOver();
		}
	}
	
	
	
	// function to let the user play the game again
	// if they either win or lose
	public void playAgainEvent() {

	 	Stage stage = (Stage) playAgain.getScene().getWindow();
	    stage.close();
	
	try {
		Stage stage2 = new Stage();
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("SceneA.fxml"));
	
		Parent root2 = loader2.load();
		Scene sceneA = new Scene(root2);
		stage2.setScene(sceneA);
		controlA control = loader2.getController();
		
		 // close Scene B
		stage2.show();

		}catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	
	
	// create a guess button event 
	public void onButtonClicked(){
		
		// protect against empty textbox and non char text
		if (AnswerBox.getText() != "" && AnswerBox.getText().length() ==  1)
		{
			//convert char obtained from TextField to String
			String guess = AnswerBox.getText(); 
			
			//convert String to char
			char myGuess = guess.charAt(0);
			
			//test to see if letter is in secretWord
			if(guessIsRight(mysteryWord,myGuess)){ 
			
				//change _ to letter if player made correct guess
				updateWordState(mysteryWord,myGuess); 

				if (wordState.compareTo(mysteryWord)==0) {
					GameWin();} 
				
			}
			else{
				//update hangman picture  
				//make part of hangmanPicture visible if player made incorrect guess
				
				// add missed letters to incorrect letters bank
				addLettersGuessed(myGuess); 
				
				numGuesses--;
				makeVisible(numGuesses);
			}
			
			AnswerBox.requestFocus(); // set focus on textbox 
		}
		else
		{
			// print a message if the user didn't write a letter
			AnswerBox.setText("Your guess must be a single letter");
			AnswerBox.requestFocus(); 
		}
	}
	
	
	
	// add missed letters to incorrect letters bank
	public void addLettersGuessed(char letter)
	  {
		
		  if (mysteryWord.indexOf(letter) == -1)
		  {
			  lettersGuessed += letter + " "; 
		  }
		  
		  missedLetters.setText(lettersGuessed);
		  
	  }
	
	
	
	
	// check if the letter is in secret word
	public boolean guessIsRight(String secretWord, char guess){
		boolean isCorrect = false;
		for (int i=0; i<secretWord.length(); i++){
			char secretLetter = secretWord.charAt(i);
			if (secretLetter == guess){
				 isCorrect =  true;
			}
		}
		return isCorrect;
	}
	
	
	//updates word state
	public void updateWordState(String secretWord,char guess){
		
		//convert String to charArray
		char [] myword = wordState.toCharArray();  
		
		  for (int i=0; i<secretWord.length(); i++){
			
			char secretLetter = secretWord.charAt(i);
			
			if (secretLetter == guess){
				
				//update letters
				myword[i] = guess;      
			}
		}
		 
		
		// set the wordState variable to the string value of myword char array
		wordState = String.valueOf(myword); 
		
		// set wordDash text to value of wordState String
		wordDashes.setText(wordState); 
		
	}


	
	

}