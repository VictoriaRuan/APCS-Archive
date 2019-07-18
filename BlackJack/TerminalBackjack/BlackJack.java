import java.util.Scanner;

/**
 * Blackjack is a card game in which players try to acquire cards with a face value as close as possible to 21 without going over.
 * 
 */

public class BlackJack{
  private Player computer;
  private Player human;
  private Deck myDeck;
  private int indexCom = 0;
  private int indexHum = 0;
  private int round = 1;
  private boolean hum = true;
  private boolean com = true;
  private int winner = 0;
  
  /**
   * The constructor of BlackJack() has no parameter.
   */
  public BlackJack(){
     computer = new Player(0);
     human = new Player(1);
     myDeck =  new Deck();     
     play();
  }
  public static void main(String[] args){
    BlackJack myGame = new BlackJack();
  }
  
  /**
   * The method play() is the actual running process
   */
  public void play(){
    Scanner input = new Scanner(System.in);
    System.out.println("\n\nWelcome to the Black Jack Game!");
    System.out.println("What's your name?");
    String userName = input.nextLine();
    myDeck.shuffle(100000);
    System.out.println("\nHi, " + userName + "!" + " The deck has been shuffled. Let's begin.");
    
    for(int i=0; i<2; i++){
      computer.addCard(myDeck.drawCard());
      human.addCard(myDeck.drawCard());
    }
    
    System.out.println("\nNote that I can only know th value of your first card!\n");
 
    while(round < 12 && (hum || com)){
       System.out.println("My cards are " + computer.seeCard(computer.position));
       System.out.println("Your cards are " + human.seeCard(human.position));
       System.out.println("\nDo you want to add a card? (Type nubmer 0 to get a card, 1 to wait for next round, 2 to stop drawing)");
       int add = input.nextInt();
       if(add == 0){
         human.addCard(myDeck.drawCard());
         indexHum++;
       }else if (add == 2){
         hum = false;
       }

       if(computer.getSum() <= 15){
         System.out.println("\nI will draw a card\n");
         computer.addCard(myDeck.drawCard());
         indexCom ++;
       }else{
         System.out.println("\nI will not draw a card anymore");
         com = false;
       }
       round ++;
    }
    
    System.out.println("\n\n__________________________________\n\n");
    System.out.println("Let's see who wins!");
    System.out.println("\nMy cards are " + computer.getCard(computer.position) + "."
                      +"Your cards are " + human.seeCard(human.position) + ".");
    hum = com = true;
    int humDiff = 21 - human.getSum();
    int comDiff = 21 - computer.getSum();
    System.out.println("My sum is " + computer.getSum());
    System.out.println("Your sum is " +human.getSum());
    if(humDiff < 0){
      hum = false;
    }else if(comDiff < 0){
      com = false;
    }
    
    if(hum && com){
      if(humDiff > comDiff)
        winner = 0;
      else
        winner = 1; 
    }else if(hum || com){
      if(com)
        winner = 0;
      else
        winner = 1; 
    }else{
      winner = 2;
    }
    
    if(winner == 1){
      System.out.println("\nCongradulations! " + userName +", you are the winner!");
    }else if(winner ==2){
      System.out.println("\nOh, both of us are ove 20!");
    }else{
      System.out.println("\nAHA, I win!");
    }
    
    System.out.println("\nDo you want to reset? (number 1 to continue, 0 to stay)");
    if(input.nextInt() == 1){
      System.out.println("\nNew game begin!");
      BlackJack myGame = new BlackJack();
    }
  }
  
}