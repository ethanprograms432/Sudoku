import java.awt.event.*;
import java.awt.*;

public class KeyManager implements KeyListener {

   
   @Override
   public void keyPressed(KeyEvent e) {
   
      int code = e.getKeyCode();
      
      switch(code) {
      
      
         case(8):
         
            GamePanel.backSpace();
            break;
         
         
         case(49):
            
            GamePanel.numberSelected = 1;
            break;
         
         case(50):
         
            GamePanel.numberSelected = 2;
            break;
         
         case(51):
         
            GamePanel.numberSelected = 3;
            break;
         
         case(52):
         
            GamePanel.numberSelected = 4;
            break;
         
         case(53):
         
            GamePanel.numberSelected = 5;
            break;
         
         case(54):
         
            GamePanel.numberSelected = 6;
            break;
         
         case(55):
         
            GamePanel.numberSelected = 7;
            break;
         
         case(56):
         
            GamePanel.numberSelected = 8;
            break;
         
         case(57):
         
            GamePanel.numberSelected = 9;
            break;
      
      }
   
   }
   
   @Override
   public void keyReleased(KeyEvent e) {
   
   
   }
   
   @Override
   public void keyTyped(KeyEvent e) {
   
   
   }
   
   

}