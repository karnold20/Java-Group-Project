package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

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
	
	@FXML
	private Button playAgain; // playAgain button to reset game
	
	@FXML
	private Label revealLabel;



	@FXML
	private ChoiceBox<String> choicebox;
	
	public void initialize() throws IOException {
		
		makeInvisible(); // set all limbs of hangman to invisible when game first starts up
		
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
	
	
	
	// function that informs user they won game
	public void GameWin () {
		
		
		
	}
	
	
	
	
	public void GameOver(){
		// game is over disable the textfield and two buttons
		// and output that user lost game in the textfield

		guessBttn.setVisible(false);
		guessFullWord.setVisible(false);
		AnswerBox.setDisable(true); //can no longer use the text box
		AnswerBox.setText("You lost!!");
		playAgain.setVisible(true);
		revealLabel.setText("You lost!! The mystery word was:");
		revealLabel.setVisible(true);
		wordDashes.setText(mysteryWord);
	}
	
	
	// button event for guessing the entire word 
	public void GuessFullWordEvent() {
		
		String finalGuess = AnswerBox.getText();
		finalGuess = finalGuess.toLowerCase(); //so the answer is not case sensitive

		if(finalGuess.equals(mysteryWord))
		{
			AnswerBox.setText("You win!!");
			// need a game win function here
		}
		else
		{
			AnswerBox.setText("You Lose.");
			GameOver();
		}

		
	}
	
	
	// logic for restart the game button event
	public void playAgainEvent() {
		
		
		
	}
	
	
	// make guess button event 
	public void onButtonClicked(){
		
		// protect against empty textbox and non char text
		if (AnswerBox.getText() != "" && AnswerBox.getText().length() ==  1)
		{
			
			String guess = AnswerBox.getText(); //convert char obtained from TextField to String
			//String wordState = wordDashes.getText();
			char myGuess = guess.charAt(0); //convert String to char
			if(guessIsRight(mysteryWord,myGuess)){ //test to see if letter is in secretWord
			
				updateWordState(mysteryWord,myGuess); //change _ to letter if player made correct guess
				
			}
			else{
				//update hangman picture  
				//make part of hangmanPicture visible if player made incorrect guess
				
				
				addLettersGuessed(myGuess); // add missed letters to incorrect letters bank
				
				numGuesses--;
				makeVisible(numGuesses);
			
			}
			
			AnswerBox.requestFocus(); // set focus on textbox 
			
		}
		
		else
		{
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
	
	
	
	
	//checks if letter is in secret word
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
		
		   //convert Label to String
		char [] myword = wordState.toCharArray();  //convert String to charArray
		
		  for (int i=0; i<secretWord.length(); i++){
			
			char secretLetter = secretWord.charAt(i);
			
			if (secretLetter == guess){
				
				myword[i] = guess;      //update letters
			}
		}
		 
		
		wordState = String.valueOf(myword); // set the wordState variable to the string value of myword char array
		wordDashes.setText(wordState); // set wordDash text to value of wordState String
		
	}


	
	

}
