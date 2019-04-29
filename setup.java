import java.util.Scanner;

public class setup{
	//************FUNCTION 1**************
	public static void createBoard(String[][] board){								//This funtion sets up a board for the human player			
		for(int r = 0; r<board.length; r++){										//set up all spaces as empty
			for(int c = 0; c<board[0].length; c++){
				board[r][c] = " - ";
			}
		}
		for(int r=1;r<board.length; r++){											//set up the numbers across the top
			board[0][r]="|"+Integer.toString(r)+"|";
		}
		String[] columns = {"A","B","C","D","E","F","G","H","I","J"};				//set up the string of letters for rows
		for(int c=1;c<board.length; c++){											//set up the letters going down
			board[c][0]="|"+columns[c-1]+"|";
		}
			board[0][0]="   ";														//formats top left square to blank. 
	}	
	
	
	
	//************FUNCTION 2**************
	public static String[][] setPiece(String[][] playerBoard, int L){				//This function sets up a boat for the human player
			
			System.out.println("Where would you like to place this boat("+L+" Length)");
			Scanner in = new Scanner(System.in);									//Scanner function to read in inputs
			System.out.print("Column of ship (1-10):");								//Ask player for which column boat will start in
			String input1 = in.next();												//Next input is brought in as a string
			int C = Integer.parseInt(input1);										//set string input to a int variable C
			
			System.out.print("Row of ship (1-10):");								//Ask player for which row boat will start in
			String input2 = in.next();												//Next input is brought in as a string
			int R = Integer.parseInt(input2);										//set string input to a int variable R
			
			System.out.print("Vertical or Horizontal? (V=1 Or H=2):");
			String input4 = in.next();
			int P = Integer.parseInt(input4);
		
			System.out.println();
			
			if(P==2){
				for (int i=C;i<L+C;i++){
					playerBoard[R][i]=" "+L+" ";
				}
			}
			else{
				for (int i=R;i<L+R;i++){
					playerBoard[i][C]=" "+L+" ";
				}
			}
			return playerBoard;	
		}
		
		
	//************FUNCTION 3**************
	public static String[][] cpuSetup(String[][] cpuBoard){			 
			
		int [] boats ={5,4,3,3,2};

		for (int j=0; j<5; j++){
			int L = boats[j];
			int C = (int)(Math.random()*5)+1;
			int R = (int)(Math.random()*5)+1;
			double P =Math.random();
			
			if(P>.5){
				for (int i=C;i<L+C;i++){
					cpuBoard[R][i]=" "+L+" ";
				}
			}
			else{
				for (int i=R;i<L+R;i++){
					cpuBoard[i][C]=" "+L+" ";
				}
			}
		}	
			return cpuBoard;
			
		}
		
		
	//************FUNCTION 4**************
	//public static CheckMove(C,R,P,L){
		
	


}