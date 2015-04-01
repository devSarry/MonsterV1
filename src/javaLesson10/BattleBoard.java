package javaLesson10;

import java.util.Arrays;

public class BattleBoard {
    //Creating the array for the game
    static char[][] battleBoard = new char[10][10];
    public final int boardLength = battleBoard.length;
    public final int boardWidth = battleBoard[0].length;
   
    public static void buildBoard(){
            //for each possition in the array I want to set the value to "*"
            for(char[] row : battleBoard){
                    //for each char array as row in battleboard; Its taking 1 row
                    //fill each value in the array row with *
                    Arrays.fill(row, '*');
            }
    }
   
    //creating the board so that it can be drawn.
    public static void reDrawBoard(){
            int k = 1;
           
            //creating a dash of lines "---" 30 long
            while(k < 30){System.out.print("-"); k++;}
            System.out.println("");
            for(int i = 0; i < battleBoard.length; i++){
                    for(int j = 0; j < battleBoard[i].length; j++){
                            System.out.print("|" + battleBoard[i][j] + "|");
                    }
                    //after each row is completed we want to print a new line
                    System.out.println("");
            }
           
            //print a new line on the bottom of the board
            k = 1;
            while(k < 30){System.out.print("-"); k++;}
            System.out.println("");
    }    
    //end of board
    
    public BattleBoard(){
    	buildBoard();
    }
    
    public boolean isOpen(int x, int y){
    	if(battleBoard[x][y] == '*'){
    		return true;
    	}else return false;
    }
    
    public void resetPosition(int x, int y) {
    	battleBoard[x][y] = '*';
	}
    
    public void setMonsterPosition(Monster_2 m){
    	battleBoard[m.getXPos()][m.getYPos()] = m.name.charAt(0);
    	 System.out.println("getting these values" + m.getXPos() + " " + m.getYPos() + " " + m.name.charAt(0));
    }


}
