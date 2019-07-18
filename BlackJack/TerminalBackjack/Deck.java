/**
 * Deck class represents the poker deck used in the BlackJack game.
 */

public class Deck
{
  private Card [] theDeck;
  private int topCard;
  
  /**
   * The Deck is initialized with an array of length 52 with all the shapes from 1 to K.
   * J, Q, K are represented as 11, 12, 13 respectively.
   */
  public Deck()
  {
    int topCard = 0;
    int [] shapes = 
    {Card.HEART, Card.SPADE, Card.CLUB, Card.DIAMOND};
    
    theDeck = new Card[52];
    
    for(int s = 0; s < shapes.length; s++)
    {
      for(int n = 0; n < 13; n++)
      {
        theDeck[s*13+n] = new Card(n+1, shapes[s]);
      }
    }
  }
  
  /**
   * @param n is the times the deck shuffles.
   */
  public void shuffle(int n)
  {
    for(int i = 0; i < n; i++)
    {
      int pick = (int)(Math.random()*theDeck.length);
      Card c = theDeck[pick];
      Card temp = theDeck[0];
      theDeck[0] = c;
      theDeck[pick] = temp;
    }
    
    theDeck[0].flip();
    theDeck[1].flip();
  }
  
  /**
   * toString() method returns all the values in a well shuffled deck.
   */
  public String toString()
  {
    String temp = "";
    for(Card c : theDeck)
    {
      c.flip();
      temp = temp + " " + c.toString();
      c.flip();
    }
    return temp;
  }
  
  /**
   * @return Retruns a card drawn from the deck.
   */
  public Card drawCard()
  {
    if(topCard < theDeck.length)
    {
      Card top = theDeck[topCard];
      topCard++;
      return top;
    }
    else
    {
      System.out.println("no more cards hahaha");
      return null;
    }
  }
}