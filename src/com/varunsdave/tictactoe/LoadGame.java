package com.varunsdave.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
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
    
    public void gameBoardClick(View bt){
    	
    	if (bt.getId() == R.id.b01){
    		Button btn = (Button)findViewById(R.id.b01);
    		btn.setText(placeText(1));
    		game.assignMove(0, "human");
    	}
    	else if (bt.getId() == R.id.b02){
    		Button btn = (Button)findViewById(R.id.b02);
    		btn.setText(placeText(2));
    		game.assignMove(1, "human");    	
    	}
    	else if (bt.getId() == R.id.b03){
    		Button btn = (Button)findViewById(R.id.b03);
    		btn.setText(placeText(3));
    		game.assignMove(2, "human");
    	}
    	else if (bt.getId() == R.id.b04){
    		Button btn = (Button)findViewById(R.id.b04);
    		btn.setText(placeText(4));
    		game.assignMove(3, "human");
    	}	
    	else if (bt.getId() == R.id.b05){
    		Button btn = (Button)findViewById(R.id.b05);
    		btn.setText(placeText(5));
    		game.assignMove(4, "human");
    	}
		else if (bt.getId() == R.id.b06){
			Button btn = (Button)findViewById(R.id.b06);
    		btn.setText(placeText(6));
    		game.assignMove(5, "human");
		}
		else if (bt.getId() == R.id.b07){
			Button btn = (Button)findViewById(R.id.b07);
    		btn.setText(placeText(7));
    		game.assignMove(6, "human");
		}
		else if (bt.getId() == R.id.b08){
			Button btn = (Button)findViewById(R.id.b08);
    		btn.setText(placeText(8));
    		game.assignMove(7, "human");
		}
		else if (bt.getId() == R.id.b09){
			Button btn = (Button)findViewById(R.id.b09);
    		btn.setText(placeText(9));
    		game.assignMove(8, "human");
		}
		
    	flipTurn();
    	playComputerTurn(game.computerMoveEasy());
    }
    
    public String placeText(int location){
    	
    	if (turn == 1){
    		return "X";
    	}
    	else{
    		return "O";
    	}
    	
    }
    public void flipTurn(){
    	if (turn == 1){
    		turn = 0;
    	}
    	else {
    		turn = 1;
    	}
    }
    public void playComputerTurn(int computerLocation){
    	Toast.makeText(getApplicationContext(), Integer.toString(computerLocation), Toast.LENGTH_SHORT).show();
    	if (computerLocation == 0){
    		Button bt = (Button)findViewById(R.id.b01);
    		bt.setText(placeText(computerLocation+1));
    	}
    	else if (computerLocation == 1){
    		Button bt = (Button)findViewById(R.id.b02);
    		bt.setText(placeText(computerLocation+1));
    	}
    	else if (computerLocation == 2){
    		Button bt = (Button)findViewById(R.id.b03);
    		bt.setText(placeText(computerLocation+1));
    	}
    	else if (computerLocation == 3){
    		Button bt = (Button)findViewById(R.id.b04);
    		bt.setText(placeText(computerLocation+1));
    	}
    	else if (computerLocation == 4){
    		Button bt = (Button)findViewById(R.id.b05);
    		bt.setText(placeText(computerLocation+1));    		
    	}
    	else if (computerLocation == 5){
    		Button bt = (Button)findViewById(R.id.b06);
    		bt.setText(placeText(computerLocation+1));
    	}
    	else if (computerLocation == 6){
    		Button bt = (Button)findViewById(R.id.b07);
    		bt.setText(placeText(computerLocation+1));
    	}
    	else if (computerLocation == 7){
    		Button bt = (Button)findViewById(R.id.b08);
    		bt.setText(placeText(computerLocation+1));
    	}
    	else if (computerLocation == 8){
    		Button bt = (Button)findViewById(R.id.b09);
    		bt.setText(placeText(computerLocation+1));
    	}

    	flipTurn();
    }
}
