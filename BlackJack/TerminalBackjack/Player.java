/**
 * Player class generates players in the BlackJack game.
 */

public class Player{
  private int role;
  private int sum;
  public int position;
  private Card[] hand;
  
  /**
   * @param r represents the role of the player: computer is 0, human is 1.
   */
  public Player(int r){
    role = r;
    sum = 0;
    hand = new Card[12];
    position = 0;
  }
  
  
  /**
   * @param c is the card that should be added to the hand array.
   */
  public void addCard(Card c){
    if(role == 1 && position!=0)
      c.flip();
    hand[position] = c;
    sum += hand[position].getValue();
    position ++;
  }
  
  /**
   * @return The literal values and the shape of the cards hold by the player.
   * @param index: the seeCard method will return all the values of the cards hold by the player before the position
   */
  public String seeCard(int index){
    String myCards = "";
    for(int i=0; i<index; i++)
      myCards = myCards + hand[i].toString() + " ";
    return myCards;
  }
  
  
  /**
   * Only the first card of the computer player can be seen by the human player.
   * This method will show all the cards drawn by the computer player at the end of the game.
   * @param index: the seeCard method will return all the values of the cards hold by the player before the position
   */
  public String getCard(int index){
    String myCards = hand[0].toString();
    for(int i=1; i<index; i++){
      hand[i].flip();
      myCards = myCards + " "+ hand[i].toString() ;
    }
    return myCards;
  }
  
  public int getSum(){
      return sum;
  }
}