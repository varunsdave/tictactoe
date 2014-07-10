package com.varunsdave.tictactoe;

import java.util.Random;

public class GameDecisions {

	// define a game board array of 9 characters
	private char [] gameBoard;
	private final static int BOARD_SIZE = 9;
	
	public final static char X_VALUE = 'X';
	public final static char O_VALUE = 'O';
	public final static char EMPTY_VALUE = ' ';
	
	private Random rand_num;
	
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
	    }
    	else{
    		moveLocation = determineWinningPosition();
    	}
    	
    	return moveLocation;
    }
    
    public boolean isBoardEmpty(){
    	
    	
    	for (int i=0; i<BOARD_SIZE;i++){
    		if (gameBoard[i] == X_VALUE || gameBoard[i] == O_VALUE){
    			return false;
    		}
    	}
    	return true;
    }
    
    // tries to return a winning positions location if one exists,
    // otherwise returns -1
    public int determineWinningPosition(){
    	
    	
    	
        return -1;  	
    }
}
