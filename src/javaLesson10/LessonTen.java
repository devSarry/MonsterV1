package javaLesson10;



/* The Goal of this tutorial is to make a game like this
------------------------------
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||M||F||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
|P||*||*||*||*||*||*||*||*||*|
|*||*||*||*||D||*||*||*||*||*|
|*||*||*||*||*||*||*||*||*||*|
------------------------------
[9,9]

 */

import java.util.Scanner;

public class LessonTen {
	
	public static void main(String[] args){
		
		Scanner keyboard = new Scanner(System.in);
		String input = "c";
		Monster_2.buildBoard();
		
		char[][] tempBattleBoard = new char[10][10];
		Monster_2[] monsters = new Monster_2[4];
		
		monsters[0] = new Monster_2(1000, 10, 1, "Bob");
		monsters[1] = new Monster_2(500, 20, 2, "Frank");
		monsters[2] = new Monster_2(1000, 10, 1, "Joe");
		monsters[3] = new Monster_2(1000, 10, 1, "Steve");
		
		
		Monster_2.reDrawBoard();
		
		System.out.println("press c to continue");
		input = keyboard.nextLine();
		
		while(input != "c"){
			for(Monster_2 tempMonster: monsters){
				Monster_2 monsterToAttack = tempMonster.monsterToAttack(monsters);
				if(monsterToAttack != null){
					System.out.println("");
					System.out.println("monsterToAttack " + monsterToAttack.name + " temp Monster" + tempMonster.name);
					tempMonster.attack(monsterToAttack);
				}else {
					System.out.println("");
					System.out.println("Moving " + tempMonster.name);
					tempMonster.move();		
				}
			}
			Monster_2.reDrawBoard();
			
			System.out.println("press c to continue");
			input = keyboard.nextLine();
			
		}

	
		
		Monster_2.reDrawBoard();
		
		
	}
	


}
