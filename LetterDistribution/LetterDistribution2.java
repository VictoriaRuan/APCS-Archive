import doodlepad.*;
import java.io.File;
import java.util.Scanner;

public class LetterDistribution2{
  public static int[] myArray = new int[26];
  public static void main(String[] args) throws Exception{
    Pad p = new Pad(600,600);
    letterArray();
    for(int i=0; i<myArray.length;i++){
      Text myText = new Text(""+ (char)(i+'A'), 50.0+500/26*i,580.0);
      int freq = myArray[i];
      if(freq!=0){
        Rectangle bar = new Rectangle(48.0+500/26*i, 560.0-22*freq, 14, 22*freq);
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