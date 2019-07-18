import doodlepad.*;
import java.io.File;
import java.util.Scanner;

public class Suicide{
  public int dimensionX = 1280;
  public int dimensionY = 800;
  Pad p;
  public Suicide()
  {
    p = new Pad(dimensionX, dimensionY);
    p.setBackground(194,231,250);
    firstSlide(); 
    p.setKeyPressedHandler(this::onKeyPressed);
  }
  
  public void onKeyPressed(Pad p, String keyText, String keyMods){
    if (keyText.equals("1")) {
      firstSlide();
    }else if(keyText.equals("2")){
      secondSlide();
    }else if(keyText.equals("3")){
      thirdSlide();
    }else if(keyText.equals("4")){
      fourthSlide();
    }else if(keyText.equals("5")){
      fifthSlide();
    }else if(keyText.equals("6")){
      lastSlide();
    }else if(keyText.equals("0")){
      addSlide();
    }
  }
  
  public void firstSlide(){
    p.clear();
    Image titleImage = new Image("suicideTitleBackground.jpg",0,dimensionY-600,600,600);
    Text firstSlideTitle = new Text("Suicide",dimensionX * 0.55,300,80);
    Text myName = new Text("By Victoria Ruan",dimensionX* 0.55,450,35);
  }
  
  public void secondSlide(){
    p.clear();
    
    Text secondSlideTitle = new Text("Introduction",60,90,30);
    Text line1 = new Text("Every suicide is a tragedy. According to estimates",80, 200, 20);
    Text line2 = new Text("from the World Health Organisation (WHO), over ",80, 230, 20);
    Text line3 = new Text("800,000 people die due to suicide every year. ",80, 260, 20);
    Text line4 = new Text("This corresponds to an age-standardized suicide", 80, 290, 20);
    Text line5 = new Text("rate of around 11.5 per 100,000 people – a figure",80, 320, 20);
    Text line6 = new Text("equivalent to someone dying of suicide every 40",80, 350, 20);
    Text line7 = new Text("seconds.",80, 380, 20);
    Text line8 = new Text("However, suicide rate is not just a figure. It ",80, 430, 20); 
    Text line9 = new Text("depends on many factors, for example: regions,",80, 460, 20);
    Text line10 = new Text("gender and age.",80, 490, 20);
    Image secondImage = new Image("Pictures/WHO.jpg",600,200,600,400);
  }
  
  public void thirdSlide(){
    p.clear();
    Text thirdSlideTitle = new Text("1. Suicide rate by continent per 100,000",60,90,30);
    double [][] continentArray = getData("continent+gender.txt",1,6);
    Line x = new Line(150, 600, 1150, 600);
    Line y = new Line(150, 600, 150, 150);
    for(int i=0; i<23; i++){
      Text yUnit = new Text(Integer.toString(i),120,600 - i*20,20);
    }
    
    for(int k=0; k<continentArray[0].length; k++){
        for(int i=0; i< continentArray.length; i++){
          double yValue1 = continentArray[i][k];
          double yValue2 = yValue1;
          if(i+1 < continentArray.length){
            yValue2 = continentArray[i+1][k];
          }
          
          drawLine(180+i*150, 600-yValue1*20,180+(i+1)*150,600-yValue2*20,k);
          Text xUnit = new Text(Integer.toString(2012+i),180+i*150,650,20);
        }
        writeContinentName(k);
    }
    
  }
  
  public void fourthSlide(){
    p.clear();
    Text fourthSlideTitle = new Text("2. Suicide rate by gender per 100,000",60,90,30);
    int imageWidth = 500;
    int imageHeight = 300;
    Image gender = new Image("Pictures/Gender.png",dimensionX*0.3,
                             dimensionY/2 - imageHeight/2,imageWidth,imageHeight);
    
    double [][] genderArray = getData("gender.txt",3,5);
    //double [] genderAverage = getAverage(genderArray);
    double [] genderAverage = {19.158,6.170};
    
    for(int i=0; i<genderAverage[1]; i++){
      drawCircle(200-1.5*i,dimensionY*0.8-20*i,5+i*3,1);
    }
    
    for(int i=0; i<genderAverage[0]; i++){
      drawCircle(1100-1.5*i,dimensionY*0.8-30*i,5+i*3,0);
    }
    
    Text female = new Text(Double.toString(genderAverage[1]),180,dimensionY*0.83,20);
    Text male = new Text(Double.toString(genderAverage[0]),1080,dimensionY*0.83,20);
    
      
  }
  
  public void fifthSlide() {
    p.clear();
    Text fifthSlideTitle = new Text("3. Suicide rate by age per 100,000",60,90,30); 
    Text note = new Text("NOTE: About 65% of people who commit suicide are in the age group 14-59.",120,225,20); 
    Image noteMark = new Image("mark.png",60,220,30,30);
    String[] ageImage = {"p5-14.png","p15-49.png","p50-69.png","p70.png"};
    double[][] imageDimension = {{170,200,0,0},{230,300,15,-30},{150,300,0,15},{250,280,0,0}};
    for(int i=0; i<4; i++){
      double x=i*dimensionX/4.5+50+imageDimension[i][3];
      double y=dimensionY-50-imageDimension[i][1]+imageDimension[i][2];
      Image age = new Image("Pictures/"+ageImage[i],x,
                            y,imageDimension[i][0],
                            imageDimension[i][1]);
      if(i==0){
        Text a = new Text("Age group: 5-14",x,y-50,20); 
      }else if(i==1){
        Text a = new Text("Age group: 15-49",x,y-50,20); 
      }else if(i==2){
        Text a = new Text("Age group: 50-69",x,y-50,20);
      }else{
         Text a = new Text("Age group: 70+",x,y-50,20);
      }
      
    }
    
    double [][] ageArray = getData("age.txt",4,8);
    double [] ageAverage = getAverage(ageArray);
    
    int[] barPosition = {230,530,820,1200};
    for(int i=0; i<4; i++){
      double height = ageAverage[3-i];
      drawBar(barPosition[i],dimensionY-50-height*20,30,height,1);
    }
    
  }
  
   public void lastSlide(){
    p.clear();
    Text lastSlideTitle = new Text("Conclusion",60,90,30); 
    Text line1 = new Text("1. Suicide rates rised in almost every continent in the past few years.",60,200,20); 
    Text line2 = new Text("2. Males' average suicide rate is 3 times higher than female, particularly in high-income countries.",60,250,20);
    Text line3 = new Text("3. There is a positive correlation between suicide rates and age. Nevertheless, even though old people have higher suicide rates,",60,300,20);
    Text line4 = new Text("   the largest share of suicides is still contributed by people in 15-49 category.",60,350,20);
  }
   
   public void addSlide(){
     p.clear();
     Image m = new Image("SuicideMap.png",0,0,dimensionX,dimensionY);
   }
  
   
   
  // ______________________________
   
  public double[] getAverage(double[][] dataArray){
    double [] average = new double[dataArray.length];
    for(int i=0; i<dataArray.length; i++){
      double total = 0;
      for(int j=0; j<dataArray[0].length; j++){
        total += dataArray[i][j];
      }
      average[i] = total/dataArray[0].length;
    }
    return average;
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
    
    double[][] dataArray = new double[number][row];
    
    try{
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
    }catch(Exception ex){
    }
    return dataArray;
  }
  
  
  public void drawBar(double positionX, double positionY,double width,double height,int color){
    Rectangle bar = new Rectangle(positionX, positionY, width, height*20);
    bar.setStroked(false);
    bar.setFillColor(255,255,255);
    Text number = new Text(Double.toString(Math.round(height*1000d)/1000d),positionX,positionY-30,15);
  }
  
  public void drawCircle(double positionX, double positionY,double radius, int color){
    Oval circle = new Oval(positionX,positionY,radius,radius);
    circle.setStroked(false);
    if(color == 0){
      circle.setFillColor(0,0,0);
    }else{
      circle.setFillColor(255,255,255);
    }
  }
  
  public void drawLine(double x1, double y1, double x2, double y2,int color){
    Line x = new Line(x1, y1, x2, y2);
    x.setStrokeWidth(4);
    if(color==0){
      x.setStrokeColor(228,64,64);
    }else if(color==1){
      x.setStrokeColor(48,147,154);
    }else if(color==2){
      x.setStrokeColor(239,158,53);
    }else if(color==3){
      x.setStrokeColor(173,100,190);
    }else if(color==4){
      x.setStrokeColor(70,111,174);
    }else if(color==5){
      x.setStrokeColor(57,151,67);
    }else{
      x.setStrokeColor(255,255,255);
    }
    
    Oval circle = new Oval(x1-3,y1-3,6,6);
    circle.setStroked(false);
    circle.setFillColor(0,0,0);
  }
  
  public void writeContinentName(int a){
    int x = 1000;
    int x2= 1160;
    int y = 200+a*30;
    if(a==0){
      Text c = new Text("Africa",x,y,15);
      Rectangle b = new Rectangle(x2,y,60,20);
      b.setFillColor(228,64,64);
      b.setStroked(false);
    }else if(a==1){
      Text c = new Text("Americas",x,y,15);
      Rectangle b = new Rectangle(x2,y,60,20);
      b.setFillColor(48,147,154);
      b.setStroked(false);
    }else if(a==2){
      Text c = new Text("South-East Asia",x,y,15);
      Rectangle b = new Rectangle(x2,y,60,20);
      b.setFillColor(239,158,53);
      b.setStroked(false);
    }else if(a==3){
      Text c = new Text("Europe",x,y,15);
      Rectangle b = new Rectangle(x2,y,60,20);
      b.setFillColor(173,100,190);
      b.setStroked(false);
    }else if(a==4){
      Text c = new Text("Eastern Mediterranean",x,y,15);
      Rectangle b = new Rectangle(x2,y,60,20);
      b.setFillColor(70,111,174);
      b.setStroked(false);
    }else if(a==5){
      Text c = new Text("Western Pacific",x,y,15);
      Rectangle b = new Rectangle(x2,y,60,20);
      b.setFillColor(57,151,67);
      b.setStroked(false);
    }else{
      Text c = new Text("(WHO) Global",x,y,15);
      Rectangle b = new Rectangle(x2,y,60,20);
      b.setFillColor(255,255,255);
      b.setStroked(false);
    }
  }
  
  // ______________________________
  
  
  public static void main(String[] args){
    Suicide s = new Suicide();
  }
}