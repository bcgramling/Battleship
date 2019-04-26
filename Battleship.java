import java.util.Scanner;

public class Battleship {
	
		public static void createBoard(String[][] board){					//Function 1: greateBoard -creates a gameboard with standard game characteristics
			for(int r = 0; r<board.length; r++){							//set up all spaces as empty
				for(int c = 0; c<board[0].length; c++){
					board[r][c] = " - ";
				}
			}
			for(int r=1;r<board.length; r++){								//set up the numbers across the top
			board[0][r]="|"+Integer.toString(r)+"|";
			}
			String[] columns = {"A","B","C","D","E","F","G","H","I","J"};	//set up the string of letters for rows
			for(int c=1;c<board.length; c++){								//set up the letters going down
				board[c][0]="|"+columns[c-1]+"|";
			}
			board[0][0]="   ";												//formats top left square to blank. 
		}
		
		public static String[][] setPiece(String[][] playerBoard){
		
			Scanner in = new Scanner(System.in);
			System.out.print("Column of ship (1-10):");
			String input1 = in.next();
			int C = Integer.parseInt(input1);
			
			System.out.print("Row of ship (1-10):");
			String input2 = in.next();
			int R = Integer.parseInt(input2);
		
			System.out.print("Length of ship:");
			String input3 = in.next();
			int L = Integer.parseInt(input3);
			
			//System.out.print("Vertical or Horizontal? (0 Or 1):");
			//String input4 = in.next();
			//int P = Integer.parseInt(input3);
		
			System.out.println();
			
			if(Math.random()>.5){
				for (int i=C;i<L+C;i++){
					playerBoard[R][i]=" A ";
				}
			}
			else{
				for (int i=R;i<L+R;i++){
					playerBoard[i][C]=" A ";
				}
			}
			
			
			return playerBoard;
			
		}
	
		public static void main(String[] args){
		System.out.println(" ");
		System.out.println("***********BATTLESHIP***********");
		System.out.println();
		System.out.println("Board for displaying players boats");
		//Player userPlayer = new Player();
		
		String [][] playerBoard = new String[11][11];						//creates the players game board
		createBoard(playerBoard);
		for (int i=0; i < playerBoard.length;i++) {
			for(int j=0; j < playerBoard.length;j++) {
				System.out.printf(playerBoard[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Board for player's guesses");
		
		
		String [][] guessBoard = new String[11][11];						//creates board for the players guesses
		createBoard(guessBoard);
		for (int i=0; i < guessBoard.length;i++) {
			for(int j=0; j < guessBoard.length;j++) {
				System.out.printf(guessBoard[i][j]);
			}
			System.out.println();
		}
		
		playerBoard= setPiece(playerBoard);
		System.out.println();
		playerBoard= setPiece(playerBoard);
		
		
		for (int i=0; i < playerBoard.length;i++) {
			for(int j=0; j < playerBoard.length;j++) {
				System.out.printf(playerBoard[i][j]);
			}
			System.out.println();
		}
		
		
	
	
	//System.out.println("*****BATTLESHIP******");
		//Scanner in = new Scanner(System.in);  
        //System.out.print("Enter your name: "); 
		//String player1 = in.next();   
         //System.out.println("Player 1: " + player1); 
		 //System.out.println("Player 2: Computer");
		//Player userPlayer = new Player();				//creates a new player variable
		//setup(userPlayer);								//calls setup function to set up board. Next step is to confirm. Then set up computer player
	
	
	
	
	
	
		}
}
