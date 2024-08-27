import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

   Thread gameThread;
   public static boolean sudokuFinished = false;
   public static boolean tilePressed = false;
   public static boolean fullGrid = false;
   
   public static String tileSelected = "";
   public static int numberSelected = 0;
   public static ArrayList<String> addedNumbers = new ArrayList<String>();

   public static Random rand = new Random();
   public static ArrayList<String> numbers = new ArrayList<String>();
   public static int[][] numbersOnGrid = new int[9][9];
   
   
   KeyManager keyH = new KeyManager();
   MouseManager MM = new MouseManager();
   NumberManager nM = new NumberManager(this);
   
   public GamePanel() {
   
      this.setPreferredSize(new Dimension(900,900));
      this.setFocusable(true);
      this.addKeyListener(keyH);
      this.addMouseListener(MM);
   
   }
   
   public void startGameThread() {
   
      gameThread = new Thread(this);
      gameThread.start();
   
   }
   
   @Override
   public void run() {
   
      while(gameThread != null) {
      
         try {
         
            TimeUnit.MILLISECONDS.sleep(16);
            repaint();
            checkIfFullGrid();
            
         } catch(InterruptedException e) {

         }
      
      }
   
   }
   
   public void paintComponent(Graphics g) {
   
      super.paintComponent(g);
      drawBackground(g);
      drawNumbers(g);
      addNewNumbers(g);
   
   }
   
   public void addNewNumbers(Graphics g) {
   
      if(numberSelected != 0 && !tileSelected.equals("")) {
      
         String num = Integer.toString(numberSelected);
         
         int row = Integer.valueOf(tileSelected.substring(0,1));
         
         int col = Integer.valueOf(tileSelected.substring(2));
         
         numbersOnGrid[row][col] = Integer.valueOf(num);
         
         addedNumbers.add(num + "," + row + "," + col);
         
         numberSelected = 0;
         tileSelected = "";
         
      }
      
      if(fullGrid == false) {
       
         for (int f = 0; f < addedNumbers.size(); f++) {
   
            String info = addedNumbers.get(f);
            
            String num = info.substring(0,1);
            
            int row = Integer.valueOf(info.substring(2,3));
            
            int column = Integer.valueOf(info.substring(4,5));
            
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman",Font.BOLD,25));
            
            g.drawString(num,100*column + 50,100*row + 50);
         
         }
         
      }
   
   }
   
   public static void backSpace() {
   
      if(addedNumbers.size() > 0) {
      
         String removedNumber = addedNumbers.get(addedNumbers.size() - 1);
         
         int row = Integer.valueOf(removedNumber.substring(2,3));
         
         int column = Integer.valueOf(removedNumber.substring(4,5));
         
         numbersOnGrid[row][column] = 0;
         
         addedNumbers.remove(addedNumbers.get(addedNumbers.size() - 1));
         
      }
   
   }
   
   public void checkIfFullGrid() {
   
      int counter = 0;
   
      for (int i = 0; i < 9; i++) {
      
         for (int j = 0; j < 9; j++) {
         
            if(numbersOnGrid[i][j] != 0) {
            
               counter++;
            
            }
         
         }
      
      }
      
      if(counter == 81) {
      
         fullGrid = true;
      
      } else {
      
         fullGrid = false;
      
      }
      
   
   }
   
   public void drawNumbers(Graphics g) {
   
      if(fullGrid == true) {
      
         for (int i = 0; i < 9; i++) {
         
            for (int j = 0; j < 9; j++) {
            
               String info = Integer.toString(numbersOnGrid[i][j]);
                  
               String num = info.substring(0,1);
                  
               
               if(nM.sudokuSolution[i][j] == numbersOnGrid[i][j]) {
 
                  g.setColor(Color.green);
                  g.setFont(new Font("TimesRoman",Font.BOLD,25));
                  
                  g.drawString(num,100*j + 50,100*i + 50);
               
               } else {
               
                  g.setColor(Color.red);
                  g.setFont(new Font("TimesRoman",Font.BOLD,25));
                  
                  g.drawString(num,100*j + 50,100*i + 50);
               
               }
            }
         }
      
      
      } else if(sudokuFinished == true) {
      
         for (int i = 0; i < 9; i++) {
         
            for (int j = 0; j < 9; j++) {
            
               int prob = rand.nextInt(1,82);
               
               if(prob < 35) {
               
                  String num = Integer.toString(nM.sudokuSolution[i][j]);
                  
                  numbersOnGrid[i][j] = Integer.valueOf(num);
                  
                  numbers.add(num + "," + i + "," + j);
               
               } else {
               
                  numbersOnGrid[i][j] = 0;
               
               }
            
            }
         
         }
      
         sudokuFinished = false;
      }
      
      if(fullGrid == false) {
      
         for (int f = 0; f < numbers.size(); f++) {
   
            String info = numbers.get(f);
            
            String num = info.substring(0,1);
            
            int row = Integer.valueOf(info.substring(2,3));
            
            int column = Integer.valueOf(info.substring(4,5));
            
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman",Font.BOLD,25));
            
            g.drawString(num,100*column + 50,100*row + 50);
         
         }
      }
   }
   
   public void drawBackground(Graphics g) {
   
      g.setColor(Color.gray);
      for (int i = 1; i < 10; i++) {
      
         if(i == 3 || i == 6) {
         
            g.setColor(Color.red);
         
         } else {
         
            g.setColor(Color.black);
            
         }
         
         
         g.drawLine(100*i,0,100*i,900);
      
      }
      
      for (int j = 1; j < 10; j++) {
      
         if(j == 3 || j == 6) {
         
            g.setColor(Color.red);
         
         } else {
         
            g.setColor(Color.black);
            
         }
         
         g.drawLine(0,100*j,900,100*j);
      
      }
   
   }
   

}