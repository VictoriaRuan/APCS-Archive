import doodlepad.*;
import java.io.File;
import java.util.Scanner;

public class LetterDistribution{
  public static int[] myArray = new int[26];
  public static void main(String[] args)throws Exception{
    letterArray();
    Pad p = new Pad(600,600);
    for(int i=0; i<myArray.length;i++){
      Text myText = new Text(""+ (char)(i+'A'), 50.0,20.0+22*i);
      if(myArray[i]!=0){
        Rectangle bar = new Rectangle(80, 20.0+22*i, 10*myArray[i], 14);
        bar.setFillColor(225,255,0);
      }
    }
  }
  
  public static void letterArray() throws Exception{
    String fileRead = "myfile.txt";
    File readFile = new File(fileRead);
    Scanner sc = new Scanner(readFile);
    while(sc.hasNextLine()){
      String myLine = sc.nextLine().toUpperCase();
      for(int i=0;i<myLine.length();i++){
        int myLetter = (int)myLine.charAt(i);
        if(myLetter<=(int)'Z' && myLetter >= (int)'A' ){
          myArray[myLetter-(int)'A'] += 1;
        }
      }
    }
  }
}