import java.util.Scanner;

public class Battleship {
		public static void main(String[] args){
		
		System.out.println("*****BATTLESHIP******");
		Scanner in = new Scanner(System.in);  
        System.out.print("Enter your name: "); 
		String player1 = in.next();   
         System.out.println("Player 1: " + player1); 
		 System.out.println("Player 2: Computer");
		Player userPlayer = new Player();				//creates a new player variable
		setup(userPlayer);								//calls setup function to set up board. Next step is to confirm. Then set up computer player
		
		
		
		}
	
	
	
	
	
	
	
	
	
}
