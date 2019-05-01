import java.util.Scanner;

public class setup{
	
	//************FUNCTION 1**************
	public static void createBoard(String[][] board){					//This function sets up each board. Takes a double array as input from 			
		for(int r = 0; r<board.length; r++){							//main function and modifies it to have standard board setup
			for(int c = 0; c<board[0].length; c++){						//enters the first row and column to have numbers and letters.
				board[r][c] = " - ";									//1.) set up each "space" as blank "-".
			}
		}
		for(int r=1;r<board.length; r++){								//2.)Sets the top row to numbers 1-10 "|N|"
			board[0][r]="|"+Integer.toString(r)+"|";
		}
		String[] columns = {"A","B","C","D","E","F","G","H","I","J"};	//3.)Set up the string of letters for rows
		for(int c=1;c<board.length; c++){								//   Sets the first column to these letters "|A|"
			board[c][0]="|"+columns[c-1]+"|";
		}
			board[0][0]="   ";											//4.)Formats the top "Space" to blank. 
	}	
	
	
	//************FUNCTION 2**************
	public static String[][] setPiece(String[][] playerBoard){			//This function allows the player to set each boat. Takes the players board					
																		//from the main function as input and will return the new board. 
		int [] boats ={5,4,3,3,2};										//This function uses scanner util to ask player questions and take response
		for (int j=0; j<5; j++){										//as an input. There is a checking part to check if requested placement is ok
			int L = boats[j];											//then will set the "spaces" in on player's board to the length of the boat
			int C =0;
			int R =0;													//Variables are initiated to prevent errors in while loop.
			int check =0;												//R=Row,C=col, L=length, P=position(V OR H), check if for placement check.
			int P = 0;													
			
			while(check!=L){											//while loop to check if placement is allowed. Reset check to 0 after each attempt.
				check=0;												//Check is increased for each sucessful test of placement of boat. 
				Scanner in = new Scanner(System.in);					//Each time it checks, it will ask player the following questions and set C,R,and P
				System.out.println("Where would you like to place this boat("+L+" Length)");
				System.out.print("Column of ship (1-10):");										
				String input1 = in.next();														
				C = Integer.parseInt(input1);
				
				System.out.print("Row of ship (1-10):");				
				String input2 = in.next();														
				R = Integer.parseInt(input2);
				
				System.out.print("Vertical or Horizontal? (V=1 Or H=2):");						
				String input4 = in.next();														
				P = Integer.parseInt(input4);
				
				if(C+L<12 || C>0 || R+L <12 || R<0){							//Checks horizontal placement of boats by checking each "space" and
					if(P==2){													//increasing check if it works. If Check is same as length at end of 
						for(int i=C;i<L+C;i++){									//loop, then the placement passes test. 
							if(playerBoard[R][i]==" - "){
							check++;}
						}
					}
					else{
						for(int i=R;i<L+R;i++){									//Checks verticle placement of boats.
							if(playerBoard[i][C]==" - "){
							check++;}
						}
					}
				}
				
				if(check!=L){													//if check fails, it will tell the playe, and run while loop again. 
					System.out.println("This is not a valid placement for this boat. Please try again.");
				}
			}
			
			System.out.println();
			if(P==2){																//if P==2, then print L across the designated spaces horizontally
				for (int i=C;i<L+C;i++){
					playerBoard[R][i]=" "+L+" ";									//sets each space to the N of the boat length.
				}
			}
			else{																	//else, then print L across the designated spaces vertiacally
				for (int i=R;i<L+R;i++){
					playerBoard[i][C]=" "+L+" ";
				}
			}
			drawBoard(playerBoard);													//draws the board using the draw board function. will run after each placement
		}
		return playerBoard;															//returns the array to the main function
	}
	
	
		
	//************FUNCTION 3**************
	public static String[][] cpuSetup(String[][] cpuBoard){				//This function will set up the cpu's board. The cpu will randomly generate a  
																		//staring "space" and a direction (V or H). Then will check if placement is ok.
		int [] boats ={5,4,3,3,2};										//If placement not ok, then will try again. 
		int check=0;													//This function requires the cpu board as input from main. Modifies and returns to main. 
		int L=1;														//Variables initiated for function. Same as used for player setup
		int C=0;														//L is first set to 1 to avoid conflict in while loop below.
		int R=0;
		double P=0;
		
		for (int j=0; j<5; j++){										//for each boat do the following
			check=0;													//reset check variable
			while(check!=L){											//while loop for checking if placement if ok
				check=0;												//resets check again. There seemed be error if not done
				L = boats[j];											// Sets length of boat to the next length given in string array above
				C = (int)(Math.random()*(11-L))+1;						//randomly selects a starting column. (11-L) will prevent bad starting spot
				R = (int)(Math.random()*(11-L))+1;						//randomly selects a starting row
				P =Math.random();										//randomly create a double variable P. For V or H placement
	
				if(P>.5){												//if horizontally, check all horizontal spaces if ok.
					for(int i=C;i<L+C;i++){								//as before, checks if placement ok for each "space" and 
						if(cpuBoard[R][i]==" - "){						//increases check by 1 for each ok space. If all spaces ok, 
						check++;}										//then check passes
					}
				}
				else{
					for(int i=R;i<L+R;i++){
						if(cpuBoard[i][C]==" - "){
							check++;}
					}
				}
			}
				
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
	public static void drawBoard (String[][] Board){			//Function 4: DrawBaord -Prints out the board for the player
			for (int i=0; i < Board.length;i++) {				//Takes any board from main. and prints it for the player.
			for(int j=0; j < Board.length;j++) {
				System.out.printf(Board[i][j]);					//simple double array printing
			}
			System.out.println();
			}
	}

	//***********FUNCTION 5*************
	public static int[] playerGuess (int[] playerGuess){		//Function 5: Input the player's guess. The function uses scanner util to take
																//in player's answers. Then checks if it's a logical guess. Returns to guess to main
			System.out.println("Please make a Guess");			//Asks player for a column. Parses it as an int and sets it to variable C
			Scanner in = new Scanner(System.in);											
			System.out.print("Column(1-10):");										
			String input1 = in.next();														
			int C = Integer.parseInt(input1);
			while (C<1||C>11){									//Checks if that is whithin boundries. Asks player to guess again if outside.
				System.out.println("This is not a valid Column. Pick another");
				System.out.print("Column(1-10):");										
				input1 = in.next();														
				C = Integer.parseInt(input1);
				}
			
			System.out.print("Row (1-10):");				//Asks player for a row. Parses it as an int and sets it to variable R							
			String input2 = in.next();
			int R = Integer.parseInt(input2);
			while (R<1||R>11){								//Checks if that is whithin boundries. Aks player to guess again if outside.
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
	public static int[] cpuGuess (int[] cpuGuess){		//Function 6: Randomized guess for CPU. Takes an int string from main. Returns
														//a randomized guess back to main. Will check if guess is logical.
			int C = (int)(Math.random()*11);			//random Row and column are selected. 
			while (C<1||C>11){							//if outside boundries it will randomize a new number																
				C = (int)(Math.random()*11);
			}
			
			int R = (int)(Math.random()*11);
			while (R<1||R>11){
				R=(int)(Math.random()*11);
			}
			cpuGuess[0]=R;								//sets the array to the cpu's guess. Passes it back to main function
			cpuGuess[1]=C;
	
		return cpuGuess;								
	}


}