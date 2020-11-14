package application;

import java.util.Scanner;
import javax.swing.JOptionPane;

/// part of original hangman console game 
//just for reference 


public class Hangman{
    
	//stores word user needs to guess to win the game
	  private static String secretWord;  

    //stores the letters the user inputs
	  private static String lettersGuessed=""; 

    //stores the number of guesses allowed to be made in the game
	  private static final int NUM_GUESSES_ALLOWED = 6;

    //stores the number of guesses user has made in the game so far
	  private static int numGuessesMade=0;

    //stores the state of the word showing _ for characters user hasn't 
    //guessed and filled in letter for the ones that they have
	  private static String wordState ="";  
	 
   //stores the number of chances that the user has until
   //the end of the game
	  private static int numGuessesRemaining=6;

	  //Construct Hangman Object
	  Hangman(){}

	  Hangman(String newSecretWord)
	  {
	    secretWord = newSecretWord;
	   
	    
	  //show the "*" character for the number of the letters in 
      //the secret word should give the player a hint
      //of how close they are to guessing the word
	    for (int i = 0; i < secretWord.length();i++) 
	    {											
      		if (secretWord.charAt(i) == ' ' )
	    	  {
	    		  wordState+=' ';
	    	  }
	    	  else
	    	  {
	    		  wordState+= "*";	
	    	  }
	    } 
	 
	  
	  }
	  
    
	//give the user an option to end the game early 
    //by guessing the whole secret word
      public void guessWord()
	  {
      //user guesses the word
        System.out.println("Enter word guess: ");
        Scanner sc = new Scanner(System.in);
        String finalGuess=sc.nextLine();
        finalGuess = finalGuess.toLowerCase();

        //if the user guess the whole word correct, they will win,
        //if the word is wrong, they will lose
        if(finalGuess.equals(secretWord))
        {
          System.out.println("You win");
        }
        else
        {
          System.out.println("You lost");
        }
	  }
	 
	  
    //the function isLost is to check if the number of Guesses
    //that the user use is equal to 6 or not
	  public boolean isLost()
	  {
	    if(numGuessesMade == NUM_GUESSES_ALLOWED){
	    	
	      return true;
	    }
	    else {
	      return false;
	    }
	  }

    
	  //the function isWin should return true if all the letters in the
    //secret word have been guessed and there are still more guesses left remaining
	  public boolean isWin()
	  {
	    if(numGuessesMade < NUM_GUESSES_ALLOWED)
	    {
	    	int cnt = 0;
	    	for(int i = 0; i < secretWord.length(); i++)
	    	{
	    		if (wordState.charAt(i) == secretWord.charAt(i))
	    		{	
	    			cnt+=1;	
	    		}
	    	}
	    	
	    	if (cnt == secretWord.length())
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }
	    else
	    {
	      return false;
	    }
	  }
	  
	  
	//this function will initially be an empty string.
    //Then, will append characters as user makes guesses throughout the game
    //and only will add the wrong characters to the list.
    //if its correct, the letter will show in wordState
	  public void addLettersGuessed(char letter)
	  {
		  if (secretWord.indexOf(letter) == -1)
		  {
			  lettersGuessed += letter; 
		  }
	  }


	  //this method will print the state of the game
	  public void displayGame()
	  {
	    System.out.println("\nSecret Word: "+ wordState);
		  System.out.println("Letters guessed: " + lettersGuessed);
	    System.out.println("Guesses Remaining: "+(numGuessesRemaining));
	    System.out.println();
	    System.out.print("Next Guess: ");
	  }
	  

    //this function will check if the secret word contains the
    //letter that the user guess
	  public boolean isCorrectGuess(char ch){

		  int check = secretWord.indexOf(ch);
		
		  if (check > -1){
	      return true;
	    }
	    return false;
	  }


	  //this function will draw the stick man in the screen.. 
	  //counts the number of guess that the user made and will output the figure
	  //when the number of guesses increments. will pull up a display box 
	  //saying user has lost game once user uses up 6 tries
	  public void draw()
	  {
	    int num =  numGuessesMade;
	    String hangman;
	    if (num == 1)
	            { hangman =  "\n____________" + "\n|           |" + "\n|           O" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
	            	System.out.print(hangman);
	            }
	            else if (num == 2)
	            {   hangman =  "\n____________" + "\n|           |" + "\n|           O" + "\n|           |" + "\n|" + "\n|" + "\n|_______________________\n";
	           		System.out.print(hangman);
	            }
	            else if (num == 3)
	            {	hangman =  "\n____________" + "\n|           |" + "\n|           O" + "\n|        ---|" + "\n|" + "\n|" + "\n|_______________________\n";
	            	System.out.print(hangman);
	            }
	            else if (num == 4)
	            { hangman =  "\n____________" + "\n|           |"  + "\n|           O" + "\n|        ---|---" + "\n|" + "\n|" + "\n|_______________________\n";
	            	System.out.print(hangman);
	            }
	           
	            else if (num == 5)
	            {
	                hangman = "\n____________" + "\n|           |"   + "\n|           O" + "\n|        ---|---" + "\n|          /" + "\n|         /" + "\n|_______________________\n";
	                System.out.print(hangman);
	            }
	            else if (num == 6)
	            {
	            	 
	                JOptionPane.showMessageDialog(null,"You lost!" + "\n______________" + "\n|                   |" + "\n|                   O" + "\n|                ---|---" + "\n|                   /\\" + "\n|                 /    \\" + "\n|_______________________" + "\nSorry, you lost.\nThe stick man is Dead!\nThe secret word was: \"" + secretWord + "\"");
	            }  
		 }


	  //this method is what triggers the logic to move from one state to the next. 
    //the method will figure out whats going on in the game and update all
    //the state variables appropiately
	  public void makeGuess(char ch)
	  {
	    //append character user guessed 
	    addLettersGuessed(ch);

      //turns wordState into array so we can replace the "*" with actual letter 
	    char [] myword = wordState.toCharArray(); 
	    
	    //check if the word state needs to show character
	    if (isCorrectGuess(ch))
	    {
	      System.out.println("Great!\nYour guess is correct.\nKeep going.\n");
	       
	      	for (int i=0;i<secretWord.length();i++)
	        {
	        	char compare = secretWord.charAt(i);
	        	
	        	if (compare == ch)
	        	{
	            myword[i] = ch;
	        	}
	        }
	    }
	    else 
      {
	      //show message stating that the user made incorrect guess
	      System.out.println("Nope!\nTry again.\n");
	      numGuessesMade+=1;
	      numGuessesRemaining--;
	    }

      //convert the character array back into String and set back to wordState    
	    wordState = String.valueOf(myword); 
	  }
	}







