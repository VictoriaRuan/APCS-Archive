import java.io.File; 
import java.io.FileWriter; 
import java.util.*;

public class Ghost{
  String fileName;
  File readFile;
  Scanner scDic;
  Scanner sc;
  String word = "";
  Random r;
  ArrayList<String> matchList;
  boolean have = true;
  
  public Ghost() throws Exception{
    fileName = "dictionary.txt";
    readFile = new File(fileName);
    scDic = new Scanner(readFile);
    sc = new Scanner(System.in);
    r = new Random();
    matchList = new ArrayList<String>(1);
    start();
  }
  
  public void start(){
    //Welcom
    System.out.println("Welcome to the Ghost Game!\nIn the game  players take turns adding letters to a growing word fragment, trying not to be the one to complete a valid word. The word should be at least 5 letters");
    System.out.println("\nDo you want to start first? Type 0 to represent no, and 1 for yes.");
    int start = sc.nextInt();
    if(start == 1){
      addLetter(false);
    }else if(start == 0){
      System.out.println("I will generate first.");
      addLetter(true);
    }
  }
  
  public void generateList(){
    boolean continueL = true;
    while(scDic.hasNextLine() && continueL){
      String newWord = scDic.next();
      if(newWord.charAt(0)==word.charAt(0)){
        matchList.add(newWord);
      }
      else if(scDic.next().charAt(0)==word.charAt(0)+1){
        continueL = false;
      }
    }
  }
  
  public void change(int bound){
    ArrayList<String> possible = new ArrayList<String>(1);
    int i=0;
    while(i<matchList.size()){
      if(matchList.get(i).length()<word.length()){
        matchList.remove(i);
        i--;
      }else if(!word.equals(matchList.get(i).substring(0,bound))){
        matchList.remove(i);
        i--;
      }
      i++;
    }
    if(matchList.size()>0){
      for(String s: matchList){
        possible.add(""+s.charAt(bound));
      }
      word += possible.get(r.nextInt(possible.size()-1));
    }else{
      have = false;
    }
  }
  
  public boolean check(int round){
    if(round>4){
      for(String s : matchList){
        if(s.equals(word))
           return false;
      }
    }
    return true;
  }
  
  public void addLetter(boolean computer){
    int round = 0;
    if(computer){
      word += (char)(r.nextInt(26) + 'a');
      System.out.println(word);
    }
    while(check(round) && have && round<15){
      if(round %2 == 1){
        System.out.println("My turn: ");
        if(round == 1){
          generateList();
        }
        if(computer){
          change(round+1);
        }else{
          change(round);
        }
      }else{
        System.out.println("Your turn: ");
        word += sc.next().charAt(0);
      }
      System.out.println(word);
      round++;
    }
    
    if(round > 15 || !have){
      System.out.println("\nOps, a tie");
    }else if(round %2 == 1){
      System.out.println("\nYou lose!");
    }else{
        System.out.println("\nI lose!");
    }
  }
  

  public static void main(String[] args) throws Exception{
    Ghost myGame = new Ghost();
  }
}