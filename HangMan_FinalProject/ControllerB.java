package hangman;
//imports....
public class Controller {
  @FXML
  private Label wordState;
  @FXML
  private TextField myGuess;
  
  private StringProperty wordStateProperty = new StringProperty();
  private StringProperty secretWordProperty = new StringProperty();
  private StringProperty myGuessProperty = new StringProperty();
  myGuessProperty.bind(myGuess);
  
  public void onButtonClicked(){
    if(guessIsRight(myGuessProperty,secretWordProperty,wordStateProperty)){
      wordState.bind(wordStateProperty); //update wordState
    }
    else{
      //update hangmanImage
    }
  }
  public bool guessIsRight(StringProperty myGuess,StringProperty secret,StringProperty word){
    
  }
}//end of Controller
