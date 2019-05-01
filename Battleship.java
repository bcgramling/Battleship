import java.util.Scanner;

public class Battleship {
	
	public static void main(String[] args){				//Main Function: Starts program and calls each function to set up board and play game
		int playerScore=0;															
		int cpuScore=0;
		int turn=0;
		
		System.out.println(" ");
		System.out.println("***********BATTLESHIP***********");
		System.out.println();
		System.out.println("Players boats");
		
		String [][] playerBoard = new String[11][11];		//creates a new double array for the player's board
		setup.createBoard(playerBoard);						//calls create board function to create the player's board
		setup.drawBoard(playerBoard);						//Draws the board for the player		
		playerBoard= setup.setPiece(playerBoard);			//Calls setPiece function to have player set up their boats			
		//setup.cpuSetup(playerBoard);						//shortcut for randomized player start. Commented out for normal play
		setup.drawBoard(playerBoard);						//draws the player's board
		
		System.out.println();
		System.out.println("Player's guesses");			
		String [][] playerGuessBoard = new String[11][11];	//Creates a new double array for the player's guesses	
		setup.createBoard(playerGuessBoard);				//calls create board function to create the player's board
		setup.drawBoard(playerGuessBoard);					//draws the player's guessing board
		
		System.out.println();
		//System.out.println("Cpu's boats");				//for testing. Not used for normal play
		String [][] cpuBoard = new String[11][11];			//creates a new double array for the cpu's board
		setup.createBoard(cpuBoard);						//Calls create board function to create the cpu's board
		setup.cpuSetup(cpuBoard);							//Calls the cput setup function to randomize cpu's boats
		//setup.drawBoard(cpuBoard);						//for testing. Draws the cpu's board. Commented out for regular play
		
		System.out.println();
		//System.out.println("Cpu's guesses");				//for testing. Not used for normal play
		String [][] cpuGuessBoard = new String[11][11];		//creates a new double array for the cpu's guesses
		setup.createBoard(cpuGuessBoard);					//Calls create board function to create cpu's gueesing board
		//setup.drawBoard(cpuGuessBoard);					//for testing. Draws the cpu's guessing board. Commented out for regular play
		
		
		//********Sart of Game!*************
		while (playerScore<17 && cpuScore<17){											//Starts the game. While neither player has the score limit, do the following
			//****Player's guess*****
			turn++;
			int [] playerGuess= new int [2];											//new array for players guess.
			setup.playerGuess(playerGuess);												//playerGuess function will ask user for a guess
			int r= playerGuess[0];														//set first value returned from function as row of guess
			int c= playerGuess[1];														//set second value returned from function as col of guess
			
			while (playerGuessBoard[r][c]==" X " || playerGuessBoard[r][c]==" O "){		//checks if player already guess this spot
				System.out.println("Sorry, you already made this guess. Try again!");	//tells player to make a new guess. Runs function again.
				setup.playerGuess(playerGuess);
				r= playerGuess[0];
				c= playerGuess[1];
				
			}
			if(cpuBoard[r][c]==" - "){													//check if player's guess missed. Player does not score a point.
				playerGuessBoard[r][c]=" O ";											//marks miss as a O
				setup.drawBoard(playerGuessBoard);										//draws the new guess board
				System.out.println("The player Missed!");
				System.out.println();
			}
			else{																		//if other conditions aren't met, it means player hit a cpu's boat
				playerGuessBoard[r][c]=" X ";											//marks hit as an X									
				playerScore++;															//players score increases by one
				setup.drawBoard(playerGuessBoard);										//draws the new guess board
				System.out.println("Hit!");
				System.out.println("Player's Score:"+playerScore);						//displays players new score. 
				System.out.println("Cpu Score: "+cpuScore);								//displays the Cpu's score
				System.out.println();
			}
			
			//****Cpu's guess*****
			
			int [] cpuGuess= new int [2];												//new array for cpu's guess.
			setup.cpuGuess(cpuGuess);													//cpuGuess function will randomize a guess for cpu
			int cr= cpuGuess[0];														//set first value returned from function as row of guess
			int cc= cpuGuess[1];														//set second value returned from function as col of guess
			
			while (cpuGuessBoard[cr][cc]==" X " || cpuGuessBoard[cr][cc]==" O "){		//checks if player already guess this spot. randomizes new guess if needed
				System.out.println("1");
				setup.cpuGuess(cpuGuess);
				cr= cpuGuess[0];
				cc= cpuGuess[1];
				
			}
			System.out.println("The Computer guessed "+cr+","+cc);
			if(playerBoard[cr][cc]==" - "){												//check if player's guess missed. Player does not score a point.
				cpuGuessBoard[cr][cc]=" O ";											//marks miss as a O
				//setup.drawBoard(cpuGuessBoard);										//draws the new guess board
				System.out.println("The Computer Missed!");
				System.out.println();
			}
			else{																		//if other conditions aren't met, it means player hit a cpu's boat
				cpuGuessBoard[cr][cc]=" X ";											//marks hit as an X									
				cpuScore++;																//players score increases by one
				//setup.drawBoard(cpuGuessBoard);										//draws the new guess board
				System.out.println("Hit!");
				System.out.println("Player's Score:"+playerScore);						//displays players score.
				System.out.println("Cpu Score: "+cpuScore);								//displays cpu's new score. 
				System.out.println();
			}
		}	
		
		//*******End of Game**********
		System.out.println();
		System.out.println();
		
		if(playerScore>cpuScore){													//if player wins
			System.out.println("You Sunk My Battleship!");
			System.out.println("***Congradulations!***");
			System.out.println("***Winner!***");
			System.out.println("It took "+turn+"'s for you to win");
		}
		else{																		//else, CPU wins
			System.out.println("The Computer won?");	
			System.out.println("***Loser!***");
			System.out.println("It took "+turn+" turn's for the cpu to win");
		}
	}
}
