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
	public static String[][] setPiece(String[][] playerBoard){								//This function sets up a boat for the human player
			
		int [] boats ={5,4,3,3,2};															//set up the boat lengths						
		for (int j=0; j<5; j++){															//for loop to set up each boat
			int L = boats[j];																//new int to pull length
			System.out.println("Where would you like to place this boat("+L+" Length)");
			Scanner in = new Scanner(System.in);											//Scanner function to read in inputs
			System.out.print("Column of ship (1-10):");										//Ask player for which column boat will start in
			String input1 = in.next();														//Next input is brought in as a string
			int C = Integer.parseInt(input1);												//set string input to a int variable C
			
			System.out.print("Row of ship (1-10):");										//Ask player for which row boat will start in
			String input2 = in.next();														//Next input is brought in as a string
			int R = Integer.parseInt(input2);												//set string input to a int variable R
			
			System.out.print("Vertical or Horizontal? (V=1 Or H=2):");						//Ask player if they want the boat vertical or Horizontal
			String input4 = in.next();														//Next input is brought in as a string
			int P = Integer.parseInt(input4);												//set string input to a int Variable P
		
			System.out.println();
			
			if(P==2){																		//if P==2, then print L across the designated spaces horizontally
				for (int i=C;i<L+C;i++){
					playerBoard[R][i]=" "+L+" ";
				}
			}
			else{																			//else, then print L across the designated spaces vertiacally
				for (int i=R;i<L+R;i++){
					playerBoard[i][C]=" "+L+" ";
				}
			}
			drawBoard(playerBoard);															//draws the board using the draw board function. will run after each placement
		}
		return playerBoard;																	//returns the array to the main function
	}
		
	//************FUNCTION 3**************
	public static String[][] cpuSetup(String[][] cpuBoard){			 
			
		int [] boats ={5,4,3,3,2};										//set the length of each boat

		for (int j=0; j<5; j++){										//for each boat do the following
			int L = boats[j];											//set length
			int C = (int)(Math.random()*(10-L))+1;						//randomly set a C (within bounds of array)
			int R = (int)(Math.random()*(10-L))+1;						//randomly set a R (within bounds of array)
			double P =Math.random();									//randomly set P. P>.5 is horizontally. Else vertiacally
			
			if(P>.5){
				for (int i=C;i<L+C;i++){								//print L acorss the designated spaces horizontally
					cpuBoard[R][i]=" "+L+" ";
				}
			}
			else{
				for (int i=R;i<L+R;i++){
					cpuBoard[i][C]=" "+L+" ";							//print L across the designated spaces vertiacally
				}
			}
		}	
			return cpuBoard;											//returns the array to the main function
			
		}
		
		
	//************FUNCTION 4**************
	public static void drawBoard (String[][] Board){				//Function 4: DrawBaord -Prints out the board for the player
			for (int i=0; i < Board.length;i++) {
			for(int j=0; j < Board.length;j++) {
				System.out.printf(Board[i][j]);						//simple double array printing
			}
			System.out.println();
			}
	}

	//***********FUNCTION 5*************
	public static int[] playerGuess (int[] playerGuess){		//Function 5: Input the player's guess
	
			System.out.println("Please make a Guess");			//Asks player for a column. Parses it as an int and sets it to variable C
			Scanner in = new Scanner(System.in);											
			System.out.print("Column(1-10):");										
			String input1 = in.next();														
			int C = Integer.parseInt(input1);
			while (C<1||C>10){									//Checks if that is whithin boundries. Aks player to guess again if outside.
				System.out.println("This is not a valid Column. Pick another");
				System.out.print("Column(1-10):");										
				input1 = in.next();														
				C = Integer.parseInt(input1);
			}
			
			System.out.print("Row (1-10):");				//Asks player for a row. Parses it as an int and sets it to variable R							
			String input2 = in.next();
			int R = Integer.parseInt(input2);
			while (R<1||R>10){								//Checks if that is whithin boundries. Aks player to guess again if outside.
				System.out.println("This is not a valid Row. Pick another");
				System.out.print("Row(1-10):");										
				input2 = in.next();														
				R = Integer.parseInt(input2);
			}
			playerGuess[0]=R;								//sets the array to the player's guess. Passes it back to main function
			playerGuess[1]=C;
	
		return playerGuess;	
	}
	
	
	//***********FUNCTION 6*************
	public static int[] cpuGuess (int[] cpuGuess){		//Function 6: Randomized guess for CPS
															
			int C = (int)(Math.random()*11);			//random Row and column are selected. 
			while (C<1||C>10){							//if outside boundries it will randomize a new number																
				C = (int)(Math.random()*11);
			}
			
			int R = (int)(Math.random()*11);
			while (R<1||R>10){
				R=(int)(Math.random()*11);
			}
			cpuGuess[0]=R;								//sets the array to the cpu's guess. Passes it back to main function
			cpuGuess[1]=C;
	
		return cpuGuess;	
	}


}