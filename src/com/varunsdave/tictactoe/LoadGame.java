package com.varunsdave.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoadGame extends Activity {

	GameDecisions game;
	String boardValue;
	
	
	private int turn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
        
       
        game = new GameDecisions("player","computer");
        turn = 1;
        
        
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.load_game, menu);
        return true;
    }
    
    // reset board, clean game
    public void newGameClick (View newGameButton){
//    	Button newBt = (Button)findViewById(R.id.newGameButton); //may not need this
    	game.clearBoard();
    	
    	clearBoardTiles();
    	enableBoardTiles();
    	
    	
    	
    }
    
    


	public void gameBoardClick(View bt){
    	
    	if (bt.getId() == R.id.b01){
    		Button btn = (Button)findViewById(R.id.b01);
    		btn.setText(placeText(1));
    		bt.setEnabled(false);
    		game.assignMove(0, "human");
    	}
    	else if (bt.getId() == R.id.b02){
    		Button btn = (Button)findViewById(R.id.b02);
    		btn.setText(placeText(2));
    		bt.setEnabled(false);
    		game.assignMove(1, "human");    	
    	}
    	else if (bt.getId() == R.id.b03){
    		Button btn = (Button)findViewById(R.id.b03);
    		btn.setText(placeText(3));
    		bt.setEnabled(false);
    		game.assignMove(2, "human");
    	}
    	else if (bt.getId() == R.id.b04){
    		Button btn = (Button)findViewById(R.id.b04);
    		btn.setText(placeText(4));
    		bt.setEnabled(false);
    		game.assignMove(3, "human");
    	}	
    	else if (bt.getId() == R.id.b05){
    		Button btn = (Button)findViewById(R.id.b05);
    		btn.setText(placeText(5));
    		bt.setEnabled(false);
    		game.assignMove(4, "human");
    	}
		else if (bt.getId() == R.id.b06){
			Button btn = (Button)findViewById(R.id.b06);
    		btn.setText(placeText(6));
    		bt.setEnabled(false);
    		game.assignMove(5, "human");
		}
		else if (bt.getId() == R.id.b07){
			Button btn = (Button)findViewById(R.id.b07);
    		btn.setText(placeText(7));
    		bt.setEnabled(false);
    		game.assignMove(6, "human");
		}
		else if (bt.getId() == R.id.b08){
			Button btn = (Button)findViewById(R.id.b08);
    		btn.setText(placeText(8));
    		bt.setEnabled(false);
    		game.assignMove(7, "human");
		}
		else if (bt.getId() == R.id.b09){
			Button btn = (Button)findViewById(R.id.b09);
    		btn.setText(placeText(9));
    		bt.setEnabled(false);
    		game.assignMove(8, "human");
		}
		
    	// TODO finish it up with proper implementation once all the layout elements
    	// have been added for player information, the required text fields
    	if (!isGameFinished()){
    		flipTurn();
    		playComputerTurn(game.computerMoveEasy());
    	}
//    	else {
//    		Toast.makeText(getApplicationContext(), "Game finished", Toast.LENGTH_SHORT).show();
//    	}
    }
    
    private boolean isGameFinished() {
		// TODO Auto-generated method stub
    	
    	if (game.findWinner() == -1){
    		return false;
    	}
    	else
    	{
    		TextView txtView = (TextView)findViewById(R.id.turnTextField);
        	txtView.setText("Game Finished");
    		return true;
    	}
	}


	private String placeText(int location){
    	
    	if (turn == 1){
    		//return GameDecisions.X_VALUE;
    		return "X";
    	}
    	else{
    		//return GameDecisions.O_VALUE;
    		return "O";
    	}
    	
    }
    
    // change the player turn
    private void flipTurn(){
    	TextView turnView = (TextView)findViewById(R.id.turnTextField);
    	if (turn == 1){
    		turnView.setText("Player 2 Turn");
    		turn = 0;
    	}
    	else {
    		turnView.setText("Player 1 Turn");
    		turn = 1;
    	}
    }
    
    private void playComputerTurn(int computerLocation){
    	Toast.makeText(getApplicationContext(), Integer.toString(computerLocation), Toast.LENGTH_SHORT).show();
    	if (computerLocation == 0){
    		Button bt = (Button)findViewById(R.id.b01);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}
    	else if (computerLocation == 1){
    		Button bt = (Button)findViewById(R.id.b02);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}
    	else if (computerLocation == 2){
    		Button bt = (Button)findViewById(R.id.b03);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}
    	else if (computerLocation == 3){
    		Button bt = (Button)findViewById(R.id.b04);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}
    	else if (computerLocation == 4){
    		Button bt = (Button)findViewById(R.id.b05);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}
    	else if (computerLocation == 5){
    		Button bt = (Button)findViewById(R.id.b06);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}
    	else if (computerLocation == 6){
    		Button bt = (Button)findViewById(R.id.b07);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}
    	else if (computerLocation == 7){
    		Button bt = (Button)findViewById(R.id.b08);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}
    	
    	else if (computerLocation == 8){
    		Button bt = (Button)findViewById(R.id.b09);
    		bt.setText(placeText(computerLocation+1));
    		bt.setEnabled(false);
    		game.assignMove(computerLocation, "computer");
    	}

    	if (!isGameFinished()){
    		flipTurn();
    	}
//    	else{
//    		Toast.makeText(getApplicationContext(),"Game Finished", Toast.LENGTH_SHORT).show();
//    	}
    }

    //
    private void clearBoardTiles(){
    	
    	Button bt = (Button)findViewById(R.id.b01);
    	bt.setText(" ");
    	
    	bt = (Button)findViewById(R.id.b02);
    	bt.setText(" ");
    	
    	bt = (Button)findViewById(R.id.b03);
    	bt.setText(" ");
    	
    	bt = (Button)findViewById(R.id.b04);
    	bt.setText(" ");
    	
    	bt = (Button)findViewById(R.id.b05);
    	bt.setText(" ");
    	
    	bt = (Button)findViewById(R.id.b06);
    	bt.setText(" ");
    	
    	bt = (Button)findViewById(R.id.b07);
    	bt.setText(" ");
    	
    	bt = (Button)findViewById(R.id.b08);
    	bt.setText(" ");
    	
    	bt = (Button)findViewById(R.id.b09);
    	bt.setText(" ");
    }
    
    // enables board tiles
    private void enableBoardTiles() {
		
    	Button bt = (Button)findViewById(R.id.b01);
    	bt.setEnabled(true);
    	
    	bt = (Button)findViewById(R.id.b02);
    	bt.setEnabled(true);
    	
    	bt = (Button)findViewById(R.id.b03);
    	bt.setEnabled(true);
    	
    	bt = (Button)findViewById(R.id.b04);
    	bt.setEnabled(true);
    	
    	bt = (Button)findViewById(R.id.b05);
    	bt.setEnabled(true);
    	
    	bt = (Button)findViewById(R.id.b06);
    	bt.setEnabled(true);
    	
    	bt = (Button)findViewById(R.id.b07);
    	bt.setEnabled(true);
    	
    	bt = (Button)findViewById(R.id.b08);
    	bt.setEnabled(true);
    	
    	bt = (Button)findViewById(R.id.b09);
    	bt.setEnabled(true);
		
	}
}
