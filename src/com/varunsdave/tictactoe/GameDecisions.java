package com.varunsdave.tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class GameDecisions {

	// define a game board array of 9 characters
	private char [] gameBoard;
	private final static int BOARD_SIZE = 9;
	
	public final static char X_VALUE = 'X';
	public final static char O_VALUE = 'O';
	public final static char EMPTY_VALUE = ' ';
	
	private Random rand_num;
	
	private static char computer_char;
	private static char human_char;
	
	private static String player_x;
	private static String player_o;
	
    public static int returnBoardSize() {
    	return BOARD_SIZE;
    }
    
    public static void setPlayer_x(String player_name){
    	player_x = player_name;
    }
    public static void setPlayer_o(String player_name){
    	player_o = player_name;
    }
    
    public static String getPlayer_x(){
    	return player_x;
    }
    
    public static String getPlayer_o(){
    	return player_o;
    }
	
    public GameDecisions(String player_name_x, String player_name_o) {
    	
    	//initialize a board
    	gameBoard = new char [BOARD_SIZE];
    	setPlayer_x(player_name_x);
    	setPlayer_o(player_name_o);
    	
    	human_char = X_VALUE;
    	computer_char = O_VALUE;
    	
    	clearBoard();
    	
    	rand_num = new Random();
    }
    
    public void clearBoard(){
    	for (int i = 0; i < BOARD_SIZE; i++){
    		gameBoard[i] = EMPTY_VALUE;
    	}
    }
    
    public void assignMove(int location, String playerName){
    	
    	if (playerName.equals(getPlayer_o())){
    		gameBoard[location] = X_VALUE;
    	}
    	else{
    		gameBoard[location] = O_VALUE;
    	}
    	
    }
    
    public int computerMoveEasy(){
    	int moveLocation;
    	if (isBoardEmpty()){
    		moveLocation = rand_num.nextInt(10);
    		return moveLocation;
	    }
    	moveLocation = determineWinningPosition();
    	// select any random space from the available ones
    	if (moveLocation == -1){
    		moveLocation = randomSpotEasyPosition();
    	}
    	assignMove(moveLocation,"computer");
    	return moveLocation;
    }
    
    // very easy method for selecting computer move
    // it simply finds an random empty space and nothing is done
    // to improve chances later in the game
    private int randomSpotEasyPosition() {
		
    	ArrayList<Integer> emptyPositions = new ArrayList<Integer>();
    	
    	for (int i =0; i < BOARD_SIZE; i++){
    		if (gameBoard[i] == EMPTY_VALUE){
    			emptyPositions.add(i);
    		}
    	}
    	
    	int randomIndexPos = rand_num.nextInt(emptyPositions.size());
    	
	 	return emptyPositions.get(randomIndexPos);
	}

	public boolean isBoardEmpty(){
    	
    	
    	for (int i=0; i<BOARD_SIZE;i++){
    		if (gameBoard[i] == X_VALUE || gameBoard[i] == O_VALUE){
    			return false;
    		}
    	}
    	return true;
    }
    
	
	// finds if the game has finished. 
	// returns an int to determine which player has one
	// 0 == tie
	// 1 == human wins
	// 2 == computer wins
	// -1 == possible moves still valid
 	public int findWinner(){
 		
 		// check horrizontal rows
 		for (int i=0; i < 6; i+=3){
 			if (gameBoard[i] == human_char && gameBoard[i+1] == human_char && gameBoard[i+2] == human_char){
 				return 1;
 			}
 			else if (gameBoard[i] == computer_char && gameBoard[i+1] == computer_char && gameBoard[i+2] == computer_char){
 				return 2;
 			}
 			
 		}
 		
 		// check vertical rows
 		for (int i=0; i < 3; i++){
 			if (gameBoard[i] == human_char && gameBoard[i+3] == human_char && gameBoard[i+6] == human_char){
 				return 1;
 			}
 			else if (gameBoard[i] == computer_char && gameBoard[i+3] == computer_char && gameBoard[i+6] == computer_char){
 				return 2;
 			}
 		}
 		// check diagonals
 		if (gameBoard[0] == human_char && gameBoard[4] == human_char && gameBoard[8] == human_char){
			return 1;
		}
 		if (gameBoard[2] == human_char && gameBoard[4] == human_char && gameBoard[6] == human_char){
			return 1;
 		}
 		
 		if (gameBoard[0] == computer_char && gameBoard[4] == computer_char && gameBoard[8] == computer_char){
			return 2;
		}
 		
 		if (gameBoard[2] == computer_char && gameBoard[4] == computer_char && gameBoard[6] == computer_char){
			return 2;
 		}
 		
 		// check for a possible tie
 		// if there is an empty square -- in easy version a tie can
 		int filledSquares = 0;
 		for (int i =0; i<9;i++){
 			if (gameBoard[i] == EMPTY_VALUE){
 				return -1;
 			}
 			filledSquares ++;
 		}
 		if (filledSquares == BOARD_SIZE){
 			return 0;
 		}
 		return -1;
	}
	
    // tries to return a winning positions location if one exists,
    // otherwise returns -1
    public int determineWinningPosition(){
    	
    	// check horizontal rows
    	for (int i = 0; i < 6; i+=3){
    		if (gameBoard[i] == computer_char && gameBoard[i+1] == computer_char && gameBoard[i+2] == EMPTY_VALUE){
    			return i+2;
    		}
    		if (gameBoard[i] == computer_char && gameBoard[i+1] == EMPTY_VALUE && gameBoard[i+2] == computer_char){
    			return i+1;
    		}
    		if (gameBoard[i] == EMPTY_VALUE && gameBoard[i+1] == computer_char && gameBoard[i+2] == computer_char){
    			return i+2;
    		}
    	}

    	// check vertical rows
    	for (int i = 0; i< 3; i ++ ){
    		if (gameBoard[i] == computer_char && gameBoard[i+3] == computer_char && gameBoard[i+6] == EMPTY_VALUE){
    			return i+6;
    		}
    		if (gameBoard[i] == computer_char && gameBoard[i+3] == EMPTY_VALUE && gameBoard[i+6] == computer_char){
    			return i+3;
    		}
    		if (gameBoard[i] == EMPTY_VALUE && gameBoard[i+3] == computer_char && gameBoard[i+6] == computer_char){
    			return i;
    		}
    	}
    	
    	// check horizontal 
    	
    	for (int i=0; i<1; i++){
    		if (gameBoard[i] == computer_char && gameBoard[i+4] == computer_char && gameBoard[i+8] == EMPTY_VALUE){
    			return i+8;
    		}
    		if (gameBoard[i] == computer_char && gameBoard[i+4] == EMPTY_VALUE && gameBoard[i+8] == computer_char){
    			return i+5;
    		}
    		if (gameBoard[i] == EMPTY_VALUE && gameBoard[i+4] == computer_char && gameBoard[i+8] == computer_char){
    			return i;
    		}
    	}
    	for (int i=2; i<3; i++){
    		if (gameBoard[i] == computer_char && gameBoard[i+2] == computer_char && gameBoard[i+5] == EMPTY_VALUE){
    			return i+6;
    		}
    		if (gameBoard[i] == computer_char && gameBoard[i+2] == EMPTY_VALUE && gameBoard[i+5] == computer_char){
    			return i+2;
    		}
    		if (gameBoard[i] == EMPTY_VALUE && gameBoard[i+2] == computer_char && gameBoard[i+5] == computer_char){
    			return i;
    		}
    	}
    	
    	
        return -1;  	
    }
}
