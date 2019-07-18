import doodlepad.*;
import java.io.File;
import java.util.Scanner;

public class Original {
  public int dimensionX = 1280;
  public int dimensionY = 800;
  Pad p;
  
  public Original(){
    p = new Pad(dimensionX, dimensionY);
    p.setBackground(194,231,250);
    slide();
  }
  
  public void slide(){
    double [][] ageArray = getData("age.txt",4,8);
    double [] ageAverage = getAverage(ageArray);
    for(int i=0; i<ageAverage.length; i++){
      System.out.println(ageAverage[i]);
    }
  }
  
   public double[] getAverage(double[][] ageArray){
    double [] ageTotal = new double[ageArray.length];
    for(int i=0; i<ageArray.length; i++){
      double total = 0;
      for(int j=0; j<ageArray[0].length; j++){
        total += ageArray[i][j];
      }
      ageTotal[i] = total;
    }
    return ageTotal;
  }
  
  
  public double[][] getData(String fileNameRead, int start, int end){
    int row = 0;
    int number = end-start;
    String myLine = "";
    File readFile = new File(fileNameRead);
    try{
    Scanner sc = new Scanner(readFile);
    myLine = sc.nextLine();
    while(sc.hasNextLine()){
      myLine = sc.nextLine();
      row += 1;
    }
    sc.close();
    } catch(Exception ex){
    }
    
    double[][] ageArray = new double[number][row];
    
    try{
      Scanner sc2= new Scanner(readFile);
      myLine = sc2.nextLine();
      int j=0;
    while(sc2.hasNextLine()){
      myLine = sc2.nextLine();
      String[] lineArray = myLine.split(",");
      for(int i=0; i<number;i++){
        ageArray[i][j] = Double.parseDouble(lineArray[start+i]);
      }
      j++;
    }
    }catch(Exception ex){
    }
    return ageArray;
  }
  
  
  public static void main(String[] args)throws Exception{
    Original a = new Original();
  }
}