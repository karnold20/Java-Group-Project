package hangman;
//imports....
public class Controller {
  @FXML
  private Label wordState;
  @FXML
  private TextField myGuess;
  
  StringProperty wordStateProperty = new StringProperty();
  StringProperty secretWordProperty = new StringProperty();
  StringProperty myGuessProperty = new StringProperty();
  
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
