/**
 * Cards clas represented each individual card used in the game
 */

public class Card{
    private int value;
    private int shape;
    private boolean faceDown;
    
    public static final int HEART = 0;
    public static final int DIAMOND = 1;
    public static final int CLUB = 2;
    public static final int SPADE = 3;
    public static final int JOKER = -1;
    
    /**
     * @param value is the literal value of the card.
     * @shape represents the shape of the card (Heart/Diamond/Club/Spade)
     */
    public Card(int value, int shape){
      this.value = value;
      this.shape = shape;
      faceDown = true;
    }
    
    /**
     * The flip() method has no parameter, just flips the card.
     */
    public void flip(){
      faceDown = !faceDown;
    }
    
    /**
     * Return the literal value of the card.
     */
    public int getValue(){
      return value;
    }
    
    /**
     * Combine the value and the shape of the card to a string and return the string.
     * The values are XX for cards that are facing down.
     */
    public String toString(){
      String valueS = "";
      if(value == 11)
        valueS = "J";
      else if(value == 12)
        valueS = "Q";
      else if(value == 13)
        valueS = "K";
      
      String shapeS = "";
      if(shape == HEART)
        shapeS = "H";
      else if(shape == DIAMOND)
        shapeS = "D";
      else if(shape == CLUB)
        shapeS = "C";
      else if(shape == SPADE)
        shapeS = "S";
      else if(shape ==JOKER)
        shapeS = "J";
        
      
      String temp = "";
      if(faceDown){
        temp = "XX";
      }else if(value > 11){
        temp = valueS + shapeS;
      }else{
        temp = "" + value + shapeS;
      }
      return temp;
    }
}
