import doodlepad.*;
import java.io.File;
import java.util.Scanner;

public class TestArray{
  //get the 2D char array
  static char[][] maze;
  public static void getMaze() throws Exception{
    int row = 0;
    int row2 = 0;
    
    String fileNameRead = "myMap.txt";
    File readFile = new File(fileNameRead);
    Scanner sc = new Scanner(readFile);
    String myLine = "";
    while(sc.hasNextLine()){
      myLine = sc.nextLine();
      row += 1;
    }
    maze = new char[row][myLine.length()];
    sc.close();
    Scanner sc2= new Scanner(readFile);

    while(sc2.hasNextLine()){
      myLine = sc2.nextLine();
      for(int i=0; i<myLine.length();i++){
        maze[row2][i] = myLine.charAt(i);
        //System.out.println(maze[row2][i]);
      }
      row2++;
    }
   }
  
  public static void main(String[] args)throws Exception{
    getMaze();
    System.out.println(maze[0]);
    
  }
}