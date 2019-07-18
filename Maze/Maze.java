import doodlepad.*;
import java.io.File;
import java.util.Scanner;

public class Maze{
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
  
  public static void main(String[] args) throws Exception{
    getMaze();
    Maze myUserDriver = new Maze();
  }

  //draw single block
  public static void drawBlock(int width, int height, int x, int y, int color){
    Rectangle box = new Rectangle(x, y, width, height);
    if(color=='0')
      box.setFillColor(255,255,255);
    else if(color=='1')
      box.setFillColor(109, 109, 109);
    else if(color=='2')
      box.setFillColor(225,0,0);
    else
      box.setFillColor(0,225,0);
  }
  
  // draw the background constructed by individual blocks
  public static void drawBackground(){
    int width = 600/maze[0].length;
    int height = 600/maze.length;
    for(int i=0; i<maze.length;i++){
      for(int j=0; j<maze[i].length; j++){
        drawBlock(width,height,j*width,i*height,maze[i][j]);
      }
    }
  }
  
  private Rectangle user;
  public Maze() throws Exception{
        Pad p = new Pad(600, 600);
        int startRow = 0; 
        int startColumn = 0;
        int width = 600/maze[0].length;
        int length = 600/maze.length;
        drawBackground();
        for(int i=0; i<maze.length;i++){
          for(int j=0; j<maze[i].length;j++){
            if(maze[i][j]== '2'){
              startRow = i;
              startColumn = j;
            }
          }
        }
        p.setKeyPressedHandler( this::onKeyPressed );
        user = new Rectangle(width*startColumn, length*startRow, width, length);
        user.setFillColor(255, 0, 255);
    }
  
  public void onKeyPressed(Pad p, String keyText, String keyMods){
        int width = 600/maze[0].length;
        int height = 600/maze.length;
        if (keyText.equals("Left") || keyText.equals("←")) {
          int nextColumn = ((int)user.getX()-width)/width;
          int nextRow = (int)user.getY()/height;
          if(maze[nextRow][nextColumn]!='1')
            user.move(-width, 0);
        } else if (keyText.equals("Right") || keyText.equals("→")) {
          int nextColumn = ((int)user.getX()+width)/width;
          int nextRow = (int)user.getY()/height;
          if(maze[nextRow][nextColumn]!='1')
            user.move(width, 0);
        } else if (keyText.equals("Up") || keyText.equals("↑")) {
          int nextColumn = (int)user.getX()/width;
          int nextRow = ((int)user.getY()-height)/height;
          System.out.print(nextColumn +""+ nextRow);
          if(maze[nextRow][nextColumn]!='1')
            user.move(0, -height);
        } else if (keyText.equals("Down") || keyText.equals("↓")) {
          int nextColumn = (int)user.getX()/width;
          int nextRow = ((int)user.getY()+height)/height;
          if(maze[nextRow][nextColumn]!='1')
            user.move(0, height);
        }
    }
  
}