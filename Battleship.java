import java.util.Scanner;

public class Battleship {
		
		public static void drawBoard (String[][] playerBoard){				//Function 3: DrawBaord -Prints out the board for the player
			for (int i=0; i < playerBoard.length;i++) {
			for(int j=0; j < playerBoard.length;j++) {
				System.out.printf(playerBoard[i][j]);
			}
			System.out.println();
			}
		}
		
	
		public static void main(String[] args){
			
		int playerScore =0;
		int cpuScore = 0;
		
		System.out.println(" ");
		System.out.println("***********BATTLESHIP***********");
		System.out.println();
		System.out.println("Board for displaying players boats");
		
		String [][] playerBoard = new String[11][11];							//creates the players game board
		setup.createBoard(playerBoard);
		
		drawBoard(playerBoard);
		playerBoard= setup.setPiece(playerBoard,5);
		drawBoard(playerBoard);
		playerBoard= setup.setPiece(playerBoard,4);
		drawBoard(playerBoard);
		playerBoard= setup.setPiece(playerBoard,3);
		drawBoard(playerBoard);
		playerBoard= setup.setPiece(playerBoard,3);
		drawBoard(playerBoard);
		playerBoard= setup.setPiece(playerBoard,2);
		System.out.println("Board for displaying players boats");
		drawBoard(playerBoard);
		
		System.out.println();
		System.out.println("Board for displaying Cpu's boats");
		String [][] cpuBoard = new String[11][11];
		setup.createBoard(cpuBoard);
		setup.cpuSetup(cpuBoard);
		drawBoard(cpuBoard);
		
		
		}
		
	
}
