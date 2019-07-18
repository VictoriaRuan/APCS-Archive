import doodlepad.*;
import java.util.ArrayList;

public class Graphics{
  public static void main(String[] args){
    Rectangle r1 = new Rectangle(50,60,180,40);
    r1.setFillColor(0,0,0);
    Rectangle r2 = new Rectangle(50,100,180,40);
    r2.setFillColor(225,44,0);
    Rectangle r3 = new Rectangle(50,140,180,40);
    r3.setFillColor(255,199,0);
    r1.setStroked(false);
    r2.setStroked(false);
    r3.setStroked(false);
    
    Rectangle fi1 = new Rectangle(300,100,180,30);
    fi1.setFillColor(26,61,164);
    Rectangle fi2 = new Rectangle(350,60,30,120);
    fi2.setFillColor(26,61,164);
    Rectangle fi3 = new Rectangle(300,108,180,15);
    fi3.setFillColor(225,44,0);
    Rectangle fi4 = new Rectangle(358,60,15,120);
    fi4.setFillColor(225,44,0);
    fi1.setStroked(false);
    fi2.setStroked(false);
    fi3.setStroked(false);
    fi4.setStroked(false);
    
    //Tanzania
    Rectangle T1 = new Rectangle(50,250,180,120);
    T1.setFillColor(0,0,0);
    double[] Yx1 = {50,50,200}; 
    double[] Yy1 = {250,350,250}; 
    double[] Yx2 = {230,230,80}; 
    double[] Yy2 = {370,270,370};
    
    double[] Gx = {50,50,190};
    double[] Gy = {250,340,250};
    double[] Bx = {230,230,90};
    double[] By = {370,280,370};
    Polygon triYellow1 = new Polygon(Yx1,Yy1);
    Polygon triYellow2 = new Polygon(Yx2,Yy2);
    Polygon green = new Polygon(Gx,Gy);
    Polygon blue = new Polygon(Bx,By);
    
    triYellow1.setStroked(false);
    triYellow1.setFillColor(245,208,0);
    triYellow2.setStroked(false);
    triYellow2.setFillColor(245,208,0);
    green.setStroked(false);
    green.setFillColor(11,184,24);
    blue.setStroked(false);
    blue.setFillColor(30,140,216);
    T1.setStroked(false);
    
    Rectangle b1 = new Rectangle(300,250,180,40);
    b1.setFillColor(249,201,0);
    Rectangle b2 = new Rectangle(300,290,180,40);
    b2.setFillColor(35,181,15);
    Rectangle b3 = new Rectangle(300,330,180,40);
    b3.setFillColor(226,0,45);
    b1.setStroked(false);
    b2.setStroked(false);
    b3.setStroked(false);
    
    // Star
        ArrayList<Point> tri1 = new ArrayList<>();
        tri1.add( new Point( 345.0, 300.0) );
        tri1.add( new Point( 435.0, 300.0) );
        tri1.add( new Point( 390.0, 330.0) );
        Polygon p1 = new Polygon(tri1);
        
        ArrayList<Point> tri2 = new ArrayList<>();
        tri2.add( new Point( 390.0, 270.0) );
        tri2.add( new Point( 360.0, 350.0) );
        tri2.add( new Point( 400.0, 323.0) );
        Polygon p2 = new Polygon(tri2);
        
        ArrayList<Point> tri3 = new ArrayList<>();
        tri3.add( new Point( 345.0, 300.0) );
        tri3.add( new Point( 399.0, 300.0) );
        tri3.add( new Point( 410.0, 350.0) );
        Polygon p3 = new Polygon(tri3);
        p1.setStroked(false);
        p2.setStroked(false);
        p3.setStroked(false);
        
  }
}