import java.io.File;
import java.util.Scanner;

public class AgeTest {
  public static void main(String[] args)throws Exception{
    AgeTest a = new AgeTest();
  }
  
  public AgeTest()throws Exception{
    slide();
  }
  
  public void slide()throws Exception{
    double [][] genderArray = getData("continent+gender.txt",1,6);
    
      for(int k=0; k<genderArray[0].length; k++){
        for(int i=0; i< genderArray.length; i++){
        System.out.println(genderArray[i][k]);
        }
    }
  }

   public double[] getAverage(double[][] dataArray){
    double [] dataTotal = new double[dataArray.length];
    for(int i=0; i<dataArray.length; i++){
      double total = 0;
      for(int j=0; j<dataArray[j].length; j++){
        total += dataArray[i][j];
      }
      dataTotal[i] = total;
    }
    return dataTotal;
  }
  
  public double[][] getData(String fileNameRead, int start, int end) throws Exception{
    int row = 0;
    int number = end-start;
    String myLine = "";
    File readFile = new File(fileNameRead);

    Scanner sc = new Scanner(readFile);
    myLine = sc.nextLine();
    while(sc.hasNextLine()){
      myLine = sc.nextLine();
      row += 1;
    }
    sc.close();
    
    double[][] dataArray = new double[number][row];
    
    Scanner sc2= new Scanner(readFile);
    myLine = sc2.nextLine();
    int j=0;
    while(sc2.hasNextLine()){
      myLine = sc2.nextLine();
      String[] lineArray = myLine.split(",");
      for(int i=0; i<number;i++){
          dataArray[i][j] = Double.parseDouble(lineArray[start+i]);
      }
      j++;
    }
    return dataArray;
  }
  
}