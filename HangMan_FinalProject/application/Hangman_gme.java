package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/// original hangman console game 
// just for reference 
public class Hangman_gme {

	public static void main(String[] args)throws IOException {

		  //the game explanation
			System.out.println ("\n        WELCOME TO HANGMAN!!");
			System.out.println("---------------------------------------");
			System.out.println ("In this game, there is a secret word, and you have to guess the word.\n"+
			"You need to enter one character at a time"+ 
			", but don't forget!\nYou have 6 tries. If you don't guess the word, you lose!\n");
			System.out.println ("---------------------------------------");
	    
			Scanner input = new Scanner(System.in);

	    //calling the choose category function
			String word= null;
			word = chooseCategory(word);

	    //check the secret word
			//System.out.println("The secret word is: "+ word);
		   
			Hangman myGame= new Hangman(word);
			boolean gameOver = false;
		    
			while (!gameOver)
			{
	      boolean isAlpha = false;
	      //display game
				myGame.displayGame();

	      //user puts in answer 
				char answer = input.next().charAt(0);
	      
	      //converts character to lower case
	      answer = Character.toLowerCase(answer);

	      //ensures user input is valid
	      while(!isAlpha)
	      {
	        if(answer >='a' && answer <= 'z')
	          isAlpha = true;
	        else
	        {
	          System.out.println("You input an invalid character. Please enter a letter.");

	          System.out.print("Next Guess: ");
	          answer = input.next().charAt(0);
	          answer = Character.toLowerCase(answer);
	        }
	      }

	      //send answer here 
				myGame.makeGuess(answer);
				myGame.draw();

	      //give the user chance to guess the whole word, 
	      //if their guess is correct, they will win the game.
	      //if it's not correct the game is over
	      System.out.println("Guess the word? (y/n)");
	      Scanner sc = new Scanner(System.in);
	      char in=sc.next().charAt(0);

	      if(in=='y')
	      {
	        myGame.guessWord();
	        gameOver=true;
	      }

				
				if (myGame.isWin() == true)
				{
					System.out.print("You win the game");
					gameOver = true;
				}
				
				
				if(myGame.isLost() == true)
				{
					System.out.print("You lost");
					break;
				}
				
			}
		  }
	    
	    public static String chooseCategory(String word) throws IOException {
				
			//Choose the category
			System.out.println ("Let's start the game.....\n\nChoose a category from the list below:\n"
					+ "1- animal category!\n"
					+ "2- country category!\n"
					+ "3- fruit category!\n"
					+ "4- movies category!\n"
					+ "5- restaurants category!");
			
			//get the number of category from the user
			Scanner keyboard = new Scanner (System.in);
			int Category_number = keyboard.nextInt();
			
			
			String option = null;
			//switch statement is to open the text file that the user choose
			switch (Category_number)
			{
					case 1:
						option = "animal.txt"; //animal text file
						break;
					case 2:
						option = "country.txt"; //country text file
						break;
					case 3:
						option = "fruit.txt"; //fruit text file
						break;
					case 4:
						option = "movies.txt"; //movies text file
						break;
					case 5:
						option = "restaurants.txt"; //restaurants text file
						break;
			}
			
			
			//read the file contents
			FileReader file_Reader = new FileReader (option);
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
			while ((string = Buff_Reader.readLine()) != null) {
				allWords[count]=string;
				count++;	
			}
			
			//instance of random class
		  Random rand = new Random(); 

	    //generate random values from 1 to number store in count
		  int upperbound = count;    
		  int int_random = rand.nextInt(upperbound); 
		    
	    //return the secret word
			return allWords[int_random];
		}
	}
	
	
	
	
	
	
	
	
	


