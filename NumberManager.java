import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class NumberManager {

   GamePanel gp;
   public int[][] sudokuSolution = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
   public static Random rand = new Random();
   public static int[] numbers = {1,2,3,4,5,6,7,8,9};
   
   public static int[] squareOne = {0,0,0,0,0,0,0,0,0};
   public static int[] squareTwo = {0,0,0,0,0,0,0,0,0};
   public static int[] squareThree = {0,0,0,0,0,0,0,0,0};
   public static int[] squareFour = {0,0,0,0,0,0,0,0,0};
   public static int[] squareFive = {0,0,0,0,0,0,0,0,0};
   public static int[] squareSix = {0,0,0,0,0,0,0,0,0};
   public static int[] squareSeven = {0,0,0,0,0,0,0,0,0};
   public static int[] squareEight = {0,0,0,0,0,0,0,0,0};
   public static int[] squareNine = {0,0,0,0,0,0,0,0,0};
   
   public static int[] rowOne = {0,0,0,0,0,0,0,0,0};
   public static int[] rowTwo = {0,0,0,0,0,0,0,0,0};
   public static int[] rowThree = {0,0,0,0,0,0,0,0,0};
   public static int[] rowFour = {0,0,0,0,0,0,0,0,0};
   public static int[] rowFive = {0,0,0,0,0,0,0,0,0};
   public static int[] rowSix = {0,0,0,0,0,0,0,0,0};
   public static int[] rowSeven = {0,0,0,0,0,0,0,0,0};
   public static int[] rowEight = {0,0,0,0,0,0,0,0,0};
   public static int[] rowNine = {0,0,0,0,0,0,0,0,0};
   
   public static int[] columnOne = {0,0,0,0,0,0,0,0,0};
   public static int[] columnTwo = {0,0,0,0,0,0,0,0,0};
   public static int[] columnThree = {0,0,0,0,0,0,0,0,0};
   public static int[] columnFour = {0,0,0,0,0,0,0,0,0};
   public static int[] columnFive = {0,0,0,0,0,0,0,0,0};
   public static int[] columnSix = {0,0,0,0,0,0,0,0,0};
   public static int[] columnSeven = {0,0,0,0,0,0,0,0,0};
   public static int[] columnEight = {0,0,0,0,0,0,0,0,0};
   public static int[] columnNine = {0,0,0,0,0,0,0,0,0};
   
   
   
   public NumberManager(GamePanel gp) {
   
      this.gp = gp;
      createSudokuSolution();
      
   }
   
   
   public void createSudokuSolution() {
   
      int currNum = rand.nextInt(1,9);
      
      sudokuSolution[0][0] = currNum;
      squareOne[0] = currNum;
      columnOne[0] = currNum;
      rowOne[0] = currNum;
      
      // ROW ONE
      for (int i = 1; i < 9; i++) {
      
         boolean fillAble = false;

         while(fillAble == false) {
         
           currNum = rand.nextInt(1,10);
           boolean isInSquare = false;
           boolean isInRow = false;
           boolean isInColumn = false;
           
           if(i < 3) {
           
               isInSquare = checkIfHasNumber(squareOne,currNum);
               
           } else if(i < 6) {
           
               isInSquare = checkIfHasNumber(squareTwo,currNum);
               
           } else {
           
               isInSquare = checkIfHasNumber(squareThree,currNum);
               
           }
           
           isInRow = checkIfHasNumber(rowOne,currNum);
           
           int[] reference = getColumn(i);
           
           isInColumn = checkIfHasNumber(reference,currNum);
           
           if(isInColumn == false && isInRow == false && isInSquare == false) {
           
              sudokuSolution[0][i] = currNum;
              
              if(i < 3) {
              
                 squareOne[i] = currNum;
                 
              } else if(i < 6) {
              
                 squareTwo[i-3] = currNum;
                 
              } else {
              
                 squareThree[i-6] = currNum;
                 
              }
              
              addToCorrectColumn(i,0,currNum);
              rowOne[i] = currNum;
              fillAble = true;
           
           }
           
           
         
         }
         
      
      }
      
      
      // ROW TWO
      
      for (int j = 0; j < 9; j++) {
      
         boolean fillAble = false;
         
         int counter = 0;
         currNum = rand.nextInt(1,10);
         
         while(fillAble == false) {

            currNum++;
            
            if(currNum == 10) {
            
               currNum = 1;
               
            }
           
            boolean isInSquare = false;
            boolean isInRow = false;
            boolean isInColumn = false;
            
            if(j < 3) {
            
               isInSquare = checkIfHasNumber(squareOne,currNum);
               
            } else if(j < 6) {
            
               isInSquare = checkIfHasNumber(squareTwo,currNum);
               
            } else {
            
               isInSquare = checkIfHasNumber(squareThree,currNum);
               
            }
            
            isInRow = checkIfHasNumber(rowTwo,currNum);
            
            int[] reference = getColumn(j);
           
            isInColumn = checkIfHasNumber(reference,currNum);
            
            if(isInColumn == false && isInSquare == false && isInRow == false) {
            
                 sudokuSolution[1][j] = currNum;
              
                 if(j < 3) {
                 
                    squareOne[j+3] = currNum;
                    
                 } else if(j < 6) {
                 
                    squareTwo[j] = currNum;
                    
                 } else {
                 
                    squareThree[j-3] = currNum;
                    
                 }
                 
                 addToCorrectColumn(j,1,currNum);
                 rowTwo[j] = currNum;
                 fillAble = true;
                 counter = 0;
            
            }
            
            counter++;
            
            if(counter > 9) {
            
               j = 0;
               counter = 0;
               
               for (int i = 0; i < 9; i++) {
               
                  sudokuSolution[1][i] = 0;
                  rowTwo[i] = 0;
                  
               }
               
               columnOne[1] = 0;
               columnTwo[1] = 0;
               columnThree[1] = 0;
               columnFour[1] = 0;
               columnFive[1] = 0;
               columnSix[1] = 0;
               columnSeven[1] = 0;
               columnEight[1] = 0;
               columnNine[1] = 0;
               
               squareOne[3] = 0;
               squareOne[4] = 0;
               squareOne[5] = 0;
               
               squareTwo[3] = 0;
               squareTwo[4] = 0;
               squareTwo[5] = 0;
               
               squareThree[3] = 0;
               squareThree[4] = 0;
               squareThree[5] = 0;
            
            }
            
            
            
        }
        
      
      }
      //("Row 2 complete");
      
      // ROW THREE
      
      for (int k = 0; k < 9; k++) {
      
         boolean fillAble = false;
         
         int counter = 0;
         currNum = rand.nextInt(1,10);
         
         while(fillAble == false) {

            currNum++;
            
            if(currNum == 10) {
            
               currNum = 1;
               
            }
           
            boolean isInSquare = false;
            boolean isInRow = false;
            boolean isInColumn = false;
            
            if(k < 3) {
            
               isInSquare = checkIfHasNumber(squareOne,currNum);
               
            } else if(k < 6) {
            
               isInSquare = checkIfHasNumber(squareTwo,currNum);
               
            } else {
            
               isInSquare = checkIfHasNumber(squareThree,currNum);
               
            }
            
            isInRow = checkIfHasNumber(rowThree,currNum);
            
            int[] reference = getColumn(k);
           
            isInColumn = checkIfHasNumber(reference,currNum);
            
            if(isInColumn == false && isInSquare == false && isInRow == false) {
            
                 sudokuSolution[2][k] = currNum;
              
                 if(k < 3) {
                 
                    squareOne[k+6] = currNum;
                    
                 } else if(k < 6) {
                 
                    squareTwo[k+3] = currNum;
                    
                 } else {
                 
                    squareThree[k] = currNum;
                    
                 }
                 
                 addToCorrectColumn(k,2,currNum);
                 rowThree[k] = currNum;
                 fillAble = true;
                 counter = 0;
            
            }
            
            counter++;
            
            if(counter > 9) {
            
               k = 0;
               counter = 0;
               
               for (int i = 0; i < 9; i++) {
               
                  sudokuSolution[2][i] = 0;
                  rowThree[i] = 0;
                  
               }
               
               columnOne[2] = 0;
               columnTwo[2] = 0;
               columnThree[2] = 0;
               columnFour[2] = 0;
               columnFive[2] = 0;
               columnSix[2] = 0;
               columnSeven[2] = 0;
               columnEight[2] = 0;
               columnNine[2] = 0;
               
               squareOne[6] = 0;
               squareOne[7] = 0;
               squareOne[8] = 0;
               
               squareTwo[6] = 0;
               squareTwo[7] = 0;
               squareTwo[8] = 0;
               
               squareThree[6] = 0;
               squareThree[7] = 0;
               squareThree[8] = 0;
            
            }
            
            
            
        }
        
      
      }
      
      //("Row 3 complete");
      // ROW FOUR
      
      for (int l = 0; l < 9; l++) {
      
         boolean fillAble = false;
         
         int counter = 0;
         currNum = rand.nextInt(1,10);
         
         while(fillAble == false) {

            currNum++;
            
            if(currNum == 10) {
            
               currNum = 1;
               
            }
           
            boolean isInSquare = false;
            boolean isInRow = false;
            boolean isInColumn = false;
            
            if(l < 3) {
            
               isInSquare = checkIfHasNumber(squareFour,currNum);
               
            } else if(l < 6) {
            
               isInSquare = checkIfHasNumber(squareFive,currNum);
               
            } else {
            
               isInSquare = checkIfHasNumber(squareSix,currNum);
               
            }
            
            isInRow = checkIfHasNumber(rowFour,currNum);
            
            int[] reference = getColumn(l);
           
            isInColumn = checkIfHasNumber(reference,currNum);
            
            if(isInColumn == false && isInSquare == false && isInRow == false) {
            
                 sudokuSolution[3][l] = currNum;
              
                 if(l < 3) {
                 
                    squareFour[l] = currNum;
                    
                 } else if(l < 6) {
                 
                    squareFive[l-3] = currNum;
                    
                 } else {
                 
                    squareSix[l-6] = currNum;
                    
                 }
                 
                 addToCorrectColumn(l,3,currNum);
                 rowFour[l] = currNum;
                 fillAble = true;
                 counter = 0;
            
            }
            
            counter++;
            
            if(counter > 9) {
            
               l = 0;
               counter = 0;
               
               for (int i = 0; i < 9; i++) {
               
                  sudokuSolution[3][i] = 0;
                  rowFour[i] = 0;
                  
               }
               
               columnOne[3] = 0;
               columnTwo[3] = 0;
               columnThree[3] = 0;
               columnFour[3] = 0;
               columnFive[3] = 0;
               columnSix[3] = 0;
               columnSeven[3] = 0;
               columnEight[3] = 0;
               columnNine[3] = 0;
               
               squareFour[0] = 0;
               squareFour[1] = 0;
               squareFour[2] = 0;
               
               squareFive[0] = 0;
               squareFive[1] = 0;
               squareFive[2] = 0;
               
               squareSix[0] = 0;
               squareSix[1] = 0;
               squareSix[2] = 0;
            
            }
            
            
            
        }
        
      
      }
      
      //("Row 4 complete");
      // ROW FIVE
      
      for (int m = 0; m < 9; m++) {
      
         boolean fillAble = false;
         
         int counter = 0;
         currNum = rand.nextInt(1,10);
         
         while(fillAble == false) {

            currNum++;
            
            if(currNum == 10) {
            
               currNum = 1;
               
            }
           
            boolean isInSquare = false;
            boolean isInRow = false;
            boolean isInColumn = false;
            
            if(m < 3) {
            
               isInSquare = checkIfHasNumber(squareFour,currNum);
               
            } else if(m < 6) {
            
               isInSquare = checkIfHasNumber(squareFive,currNum);
               
            } else {
            
               isInSquare = checkIfHasNumber(squareSix,currNum);
               
            }
            
            isInRow = checkIfHasNumber(rowFive,currNum);
            
            int[] reference = getColumn(m);
           
            isInColumn = checkIfHasNumber(reference,currNum);
            
            if(isInColumn == false && isInSquare == false && isInRow == false) {
            
                 sudokuSolution[4][m] = currNum;
              
                 if(m < 3) {
                 
                    squareFour[m+3] = currNum;
                    
                 } else if(m < 6) {
                 
                    squareFive[m] = currNum;
                    
                 } else {
                 
                    squareSix[m-3] = currNum;
                    
                 }
                 
                 addToCorrectColumn(m,4,currNum);
                 rowFive[m] = currNum;
                 fillAble = true;
                 counter = 0;
            
            }
            
            counter++;
            
            if(counter > 9) {
            
               m = 0;
               counter = 0;
               
               for (int i = 0; i < 9; i++) {
               
                  sudokuSolution[4][i] = 0;
                  rowFive[i] = 0;
                  
               }
               
               columnOne[4] = 0;
               columnTwo[4] = 0;
               columnThree[4] = 0;
               columnFour[4] = 0;
               columnFive[4] = 0;
               columnSix[4] = 0;
               columnSeven[4] = 0;
               columnEight[4] = 0;
               columnNine[4] = 0;
               
               squareFour[3] = 0;
               squareFour[4] = 0;
               squareFour[5] = 0;
               
               squareFive[3] = 0;
               squareFive[4] = 0;
               squareFive[5] = 0;
               
               squareSix[3] = 0;
               squareSix[4] = 0;
               squareSix[5] = 0;
            
            }
            
            
            
        }
        
      
      }
      
      //("Row 5 complete");
      
      // ROW SIX
      
      for (int n = 0; n < 9; n++) {
      
         boolean fillAble = false;
         
         int counter = 0;
         currNum = rand.nextInt(1,10);
         
         while(fillAble == false) {

            currNum++;
            
            if(currNum == 10) {
            
               currNum = 1;
               
            }
           
            boolean isInSquare = false;
            boolean isInRow = false;
            boolean isInColumn = false;
            
            if(n < 3) {
            
               isInSquare = checkIfHasNumber(squareFour,currNum);
               
            } else if(n < 6) {
            
               isInSquare = checkIfHasNumber(squareFive,currNum);
               
            } else {
            
               isInSquare = checkIfHasNumber(squareSix,currNum);
               
            }
            
            isInRow = checkIfHasNumber(rowSix,currNum);
            
            int[] reference = getColumn(n);
           
            isInColumn = checkIfHasNumber(reference,currNum);
            
            if(isInColumn == false && isInSquare == false && isInRow == false) {
            
                 sudokuSolution[5][n] = currNum;
              
                 if(n < 3) {
                 
                    squareFour[n+6] = currNum;
                    
                 } else if(n < 6) {
                 
                    squareFive[n+3] = currNum;
                    
                 } else {
                 
                    squareSix[n] = currNum;
                    
                 }
                 
                 addToCorrectColumn(n,5,currNum);
                 rowSix[n] = currNum;
                 fillAble = true;
                 counter = 0;
            
            }
            
            counter++;
            
            if(counter > 9) {
            
               n = 0;
               counter = 0;
               
               for (int i = 0; i < 9; i++) {
               
                  sudokuSolution[5][i] = 0;
                  rowSix[i] = 0;
                  
               }
               
               columnOne[5] = 0;
               columnTwo[5] = 0;
               columnThree[5] = 0;
               columnFour[5] = 0;
               columnFive[5] = 0;
               columnSix[5] = 0;
               columnSeven[5] = 0;
               columnEight[5] = 0;
               columnNine[5] = 0;
               
               squareFour[6] = 0;
               squareFour[7] = 0;
               squareFour[8] = 0;
               
               squareFive[6] = 0;
               squareFive[7] = 0;
               squareFive[8] = 0;
               
               squareSix[6] = 0;
               squareSix[7] = 0;
               squareSix[8] = 0;
            
            }
            
            
            
        }
        
        
        
      
      }
      
      //("Row 6 complete");
      
      // ROW SEVEN
      
      for (int o = 0; o < 9; o++) {
      
         boolean fillAble = false;
         
         int counter = 0;
         currNum = rand.nextInt(1,10);
         
         while(fillAble == false) {

            currNum++;
            
            if(currNum == 10) {
            
               currNum = 1;
               
            }
           
            boolean isInSquare = false;
            boolean isInRow = false;
            boolean isInColumn = false;
            
            if(o < 3) {
            
               isInSquare = checkIfHasNumber(squareSeven,currNum);
               
            } else if(o < 6) {
            
               isInSquare = checkIfHasNumber(squareEight,currNum);
               
            } else {
            
               isInSquare = checkIfHasNumber(squareNine,currNum);
               
            }
            
            isInRow = checkIfHasNumber(rowSeven,currNum);
            
            int[] reference = getColumn(o);
           
            isInColumn = checkIfHasNumber(reference,currNum);
            
            if(isInColumn == false && isInSquare == false && isInRow == false) {
            
                 sudokuSolution[6][o] = currNum;
              
                 if(o < 3) {
                 
                    squareSeven[o] = currNum;
                    
                 } else if(o < 6) {
                 
                    squareEight[o-3] = currNum;
                    
                 } else {
                 
                    squareNine[o-6] = currNum;
                    
                 }
                 
                 addToCorrectColumn(o,6,currNum);
                 rowSeven[o] = currNum;
                 fillAble = true;
                 counter = 0;
            
            }
            
            counter++;
            
            if(counter > 9) {
            
               o = 0;
               counter = 0;
               
               for (int i = 0; i < 9; i++) {
               
                  sudokuSolution[6][i] = 0;
                  rowSeven[i] = 0;
                  
               }
               
               columnOne[6] = 0;
               columnTwo[6] = 0;
               columnThree[6] = 0;
               columnFour[6] = 0;
               columnFive[6] = 0;
               columnSix[6] = 0;
               columnSeven[6] = 0;
               columnEight[6] = 0;
               columnNine[6] = 0;
               
               squareSeven[0] = 0;
               squareSeven[1] = 0;
               squareSeven[2] = 0;
               
               squareEight[0] = 0;
               squareEight[1] = 0;
               squareEight[2] = 0;
               
               squareNine[0] = 0;
               squareNine[1] = 0;
               squareNine[2] = 0;
            
            }
            
            
            
        }
        
        
        
      
      }
      
      //("Row 7 complete");
      
      // ROW EIGHT
      
      for (int p = 0; p < 9; p++) {
      
         boolean fillAble = false;
         
         int counter = 0;
         currNum = rand.nextInt(1,10);
         
         while(fillAble == false) {

            currNum++;
            
            if(currNum == 10) {
            
               currNum = 1;
               
            }
           
            boolean isInSquare = false;
            boolean isInRow = false;
            boolean isInColumn = false;
            
            if(p < 3) {
            
               isInSquare = checkIfHasNumber(squareSeven,currNum);
               
            } else if(p < 6) {
            
               isInSquare = checkIfHasNumber(squareEight,currNum);
               
            } else {
            
               isInSquare = checkIfHasNumber(squareNine,currNum);
               
            }
            
            isInRow = checkIfHasNumber(rowEight,currNum);
            
            int[] reference = getColumn(p);
           
            isInColumn = checkIfHasNumber(reference,currNum);
            
            if(isInColumn == false && isInSquare == false && isInRow == false) {
            
                 sudokuSolution[7][p] = currNum;
              
                 if(p < 3) {
                 
                    squareSeven[p+3] = currNum;
                    
                 } else if(p < 6) {
                 
                    squareEight[p] = currNum;
                    
                 } else {
                 
                    squareNine[p-3] = currNum;
                    
                 }
                 
                 addToCorrectColumn(p,7,currNum);
                 rowEight[p] = currNum;
                 fillAble = true;
                 counter = 0;
            
            }
            
            counter++;
            
            if(counter > 9) {
            
               p = 0;
               counter = 0;
               
               for (int i = 0; i < 9; i++) {
               
                  sudokuSolution[7][i] = 0;
                  rowEight[i] = 0;
                  
               }
               
               columnOne[7] = 0;
               columnTwo[7] = 0;
               columnThree[7] = 0;
               columnFour[7] = 0;
               columnFive[7] = 0;
               columnSix[7] = 0;
               columnSeven[7] = 0;
               columnEight[7] = 0;
               columnNine[7] = 0;
               
               squareSeven[3] = 0;
               squareSeven[4] = 0;
               squareSeven[5] = 0;
               
               squareEight[3] = 0;
               squareEight[4] = 0;
               squareEight[5] = 0;
               
               squareNine[3] = 0;
               squareNine[4] = 0;
               squareNine[5] = 0;
            
            }
            
            
        }
        
        
        
      
      }
      
      //("Row 8 complete");
      
      // ROW NINE
      
      for (int q = 0; q < 9; q++) {
      
         boolean fillAble = false;
         
         int counter = 0;
         currNum = rand.nextInt(1,10);
         
         while(fillAble == false) {

            currNum++;
            
            if(currNum == 10) {
            
               currNum = 1;
               
            }
           
            boolean isInSquare = false;
            boolean isInRow = false;
            boolean isInColumn = false;
            
            if(q < 3) {
            
               isInSquare = checkIfHasNumber(squareSeven,currNum);
               
            } else if(q < 6) {
            
               isInSquare = checkIfHasNumber(squareEight,currNum);
               
            } else {
            
               isInSquare = checkIfHasNumber(squareNine,currNum);
               
            }
            
            isInRow = checkIfHasNumber(rowNine,currNum);
            
            int[] reference = getColumn(q);
           
            isInColumn = checkIfHasNumber(reference,currNum);
            
            if(isInColumn == false && isInSquare == false && isInRow == false) {
            
                 sudokuSolution[8][q] = currNum;
              
                 if(q < 3) {
                 
                    squareSeven[q+6] = currNum;
                    
                 } else if(q < 6) {
                 
                    squareEight[q+3] = currNum;
                    
                 } else {
                 
                    squareNine[q] = currNum;
                    
                 }
                 
                 addToCorrectColumn(q,8,currNum);
                 rowNine[q] = currNum;
                 fillAble = true;
                 counter = 0;
            
            }
            
            counter++;
            
            if(counter > 9) {
            
               q = 0;
               counter = 0;
               
               for (int i = 0; i < 9; i++) {
               
                  sudokuSolution[8][i] = 0;
                  rowNine[i] = 0;
                  
               }
               
               columnOne[8] = 0;
               columnTwo[8] = 0;
               columnThree[8] = 0;
               columnFour[8] = 0;
               columnFive[8] = 0;
               columnSix[8] = 0;
               columnSeven[8] = 0;
               columnEight[8] = 0;
               columnNine[8] = 0;
               
               squareSeven[6] = 0;
               squareSeven[7] = 0;
               squareSeven[8] = 0;
               
               squareEight[6] = 0;
               squareEight[7] = 0;
               squareEight[8] = 0;
               
               squareNine[6] = 0;
               squareNine[7] = 0;
               squareNine[8] = 0;
            
            }
            
            
            
        }
        
        
        
      
      }
      
      //("Row 9 complete");
      
      gp.sudokuFinished = true;
      printList();
      
      
      
   
   }
   
   public void printList() {
   
      for (int g = 0; g < 9; g++) {
      
         for (int f = 0; f < 9; f++) {
         
            System.out.print(sudokuSolution[g][f]);
         
         }
         //();
      
      }
      //();
      
   
   }
   
   public boolean checkIfHasNumber(int[] array, int num) {
   
      boolean contains = false;
   
      for (int i = 0; i < array.length; i++) {
      
         int currNum = array[i];
         if(currNum == num) {
         
            contains = true;
         
         }
      
      }
      
      
      return contains;
   
   }
   
   public void addToCorrectColumn(int index, int row, int num) {
   
      switch(index) {
      
         case(0):
         
            columnOne[row] = num;
            break;
            
         case(1):
         
            columnTwo[row] = num;
            break;
            
         case(2):
         
            columnThree[row] = num;
            break;
            
         case(3):
         
            columnFour[row] = num;
            break;
            
         case(4):
         
            columnFive[row] = num;
            break;
            
         case(5):
         
            columnSix[row] = num;
            break;
            
         case(6):
         
            columnSeven[row] = num;
            break;
            
         case(7):
         
            columnEight[row] = num;
            break;
            
         case(8):
         
            columnNine[row] = num;
            break;
      
      }

   
   }
   
   public int[] getColumn(int index) {
   
      int[] array = new int[9];
      
      switch(index) {
      
         case(0):
         
            array = columnOne;
            break;
            
         case(1):
         
            array = columnTwo;
            break;
            
         case(2):
         
            array = columnThree;
            break;
            
         case(3):
         
            array = columnFour;
            break;
            
         case(4):
         
            array = columnFive;
            break;
            
         case(5):
         
            array = columnSix;
            break;
            
         case(6):
         
            array = columnSeven;
            break;
            
         case(7):
         
            array = columnEight;
            break;
            
         case(8):
         
            array = columnNine;
            break;
      
      }
      
      return array;
   
   }   
  
   


}