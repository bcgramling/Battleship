import java.util.Scanner;

public class Battleship {
	
		public static void main(String[] args){
		
		int playerScore=0;
		int cpuScore=0;
		
		System.out.println(" ");
		System.out.println("***********BATTLESHIP***********");
		System.out.println();
		System.out.println("Board for displaying players boats");
		
		String [][] playerBoard = new String[11][11];							//creates a new double array for the player's board
		setup.createBoard(playerBoard);
		
		
		setup.drawBoard(playerBoard);
		//playerBoard= setup.setPiece(playerBoard);
		setup.cpuSetup(playerBoard);
		setup.drawBoard(playerBoard);
		
		System.out.println();
		System.out.println("Board for displaying player's guesses");
		String [][] playerGuessBoard = new String[11][11];	
		setup.createBoard(playerGuessBoard);
		setup.drawBoard(playerGuessBoard);
		
		
		System.out.println();
		System.out.println("Board for displaying Cpu's boats");
		String [][] cpuBoard = new String[11][11];								//creates a new double array for the cpu's board
		setup.createBoard(cpuBoard);
		setup.cpuSetup(cpuBoard);
		//setup.drawBoard(cpuBoard);											//Draws the cpu's board. Commented out for regular play
		
		while (playerScore<17 && cpuScore<17){
			int [] playerGuess= new int [2];
			setup.playerGuess(playerGuess);
			int r= playerGuess[0];
			int c= playerGuess[1];
			
			while (playerGuessBoard[r][c]==" X " || playerGuessBoard[r][c]==" O "){
				System.out.println("Sorry, you already made this guess. Try again!");
				setup.playerGuess(playerGuess);
				r= playerGuess[0];
				c= playerGuess[1];
				
			}
		if(cpuBoard[r][c]==" - "){
					playerGuessBoard[r][c]=" O ";
					setup.drawBoard(playerGuessBoard);
					System.out.println("The player Missed!");
				}
				else{
					playerGuessBoard[r][c]=" X ";
					playerScore++;
					setup.drawBoard(playerGuessBoard);
					System.out.println("Hit!");
					System.out.println("Score:"+playerScore);
				}
		
		//make cpu make a random guess
		
		
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		if(playerScore>cpuScore){
			System.out.println("You Sunk My Battleship!");
			System.out.println("***Congradulations!***");
			System.out.println("***Winner!***");
		}
		else{
			System.out.println("The Computer won?");
			System.out.println("***Loser!***");
		}
		}
}
