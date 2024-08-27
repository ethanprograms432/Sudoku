import java.awt.event.*;
import java.awt.*;

public class MouseManager implements MouseListener {

   public static double mouseX;
   public static double mouseY;
   
   @Override
   public void mouseClicked(MouseEvent e) {
   
      mouseX = e.getX();
      mouseY = e.getY();
      detectTilePressed(mouseX,mouseY);
   }
   
   
   @Override
   public void mousePressed(MouseEvent e) {
   
   
   }
   
   @Override
   public void mouseReleased(MouseEvent e) {
   
   
   }
   
   @Override
   public void mouseEntered(MouseEvent e) {
   
   
   }
   
   @Override
   public void mouseExited(MouseEvent e) {
   
   
   }
   
   public void detectTilePressed(double X,double Y) {

      int row = 0;
      int column = 0;
      
      if(X < 100) {
      
         column = 0;
         
      } else if(X < 200) {
      
         column = 1;
         
      } else if(X < 300) {
      
         column = 2;
         
      } else if(X < 400) {
      
         column = 3;
         
      } else if(X < 500) {
      
         column = 4;
         
      } else if(X < 600) {
      
         column = 5;
         
      } else if(X < 700) {
      
         column = 6;
         
      } else if(X < 800) {
      
         column = 7;
         
      } else if(X < 900) {
      
         column = 8;
         
      }
      
      if(Y < 100) {
      
         row = 0;
         
      } else if(Y < 200) {
      
         row  = 1;
         
      } else if(Y < 300) {
      
         row = 2;
         
      } else if(Y < 400) {
      
         row = 3;
         
      } else if(Y < 500) {
      
         row = 4;
         
      } else if(Y < 600) {
      
         row = 5;
         
      } else if(Y < 700) {
      
         row = 6;
         
      } else if(Y < 800) {
      
         row = 7;
         
      } else if(X < 900) {
      
         row = 8;
         
      }
      
      GamePanel.tileSelected = (row + "," + column);
   
   }

}