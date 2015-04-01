package javaLesson7;

import java.util.Arrays;

public class Monster_2 {

	// Class Variables or Fields
	// You declare constants with final
	
	public final String TOMBSTONE = "Here Lies a Dead monster";
		
	// public variables are visible outside of the class
	// You should have as few as possible public fields
	public String name = "Big Monster";
	
	//Creating the array for the game
	static char[][] battleBoard = new char[10][10];
	
	public static void buildBoard(){
		//for each possition in the array I want to set the value to "*"
		for(char[] row : battleBoard){
			//for each char array as row in battleboard
			//fill each value in the array row with *
			Arrays.fill(row, '*');
		}
	}
	
	//creating the board so that it can be drawn.
	public static void reDrawBoard(){
		int k = 1;
		
		//creating a dash of lines "---" 30 long
		while(k < 30){System.out.println("-"); k++;}
		
		for(int i = 0; i < battleBoard.length; i++){
			for(int j = 0; j < battleBoard[i].length; j++){
				System.out.print("|" + battleBoard[i][j] + "|");
			}
			//after each row is completed we want to print a new line
			System.out.println("");
		}
		
		//print a new line on the bottom of the board
		k = 1;
		while(k < 30){System.out.println("-"); k++;}
		System.out.println("");
	}
	
	
	// private fields are not visible outside of the class
	private int health = 500;
	private int attack = 20;
	private int movement = 2;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean alive = true;
	
	// Class Methods
	// Accessor Methods are used to get and set the values of private fields
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getMovement()
	{
		return movement;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	// You can create multiple versions using the same method name
	// Now setHealth can except an attack that contains decimals
	// When overloading a method you can't just change the return type
	// Focus on creating methods that except different parameters
	
	public void setHealth(int decreaseHealth)
	{
		health = health - decreaseHealth;
		if (health < 0)
		{
			alive = false;
		}
	}
	
	//When passing a decreaseHealth that is a double it will cast it as an int.
	//That mean it will round the number down ALWAYS
	
	public void setHealth(double decreaseHealth)
	{
		int intDecreaseHealth = (int) decreaseHealth;
		health = health - intDecreaseHealth;
		if (health < 0)
		{
			alive = false;
		}
	}
	
	//Now we want to be able to set the name and attributes of the monster so we will
	//use a constructor to do that.
	//also whenever a new monster is created we want to set it on the board at a random
	//position.
	
	public Monster_2(int health, int attack, int movement, String name){
		this.health = health;
		this.attack = attack;
		this.movement = movement;
		this.name = name;
		
		//set the position of the monster on the board.
		int maxXBoardSpace = battleBoard.length - 1;
		int maxYBoardSpace = battleBoard[0].length - 1;
		
		int randNumX, randNumY;
		
		//We are trying to set the monster to a random spawn location.
		//the loop will choose a random number between 0 and 1 then multiply it but the
		//board size ie; 0.8 * maxXBoardSpace = 7.2
		//then convert it to an int. 
		
		do {
			randNumX = (int)(Math.random()*maxXBoardSpace);
			randNumY = (int)(Math.random()*maxYBoardSpace);
		} while(battleBoard[randNumX][randNumY] != '*');
	}
}
