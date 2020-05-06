package edu.purdue.liu1589.cs180;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    TicTacToeView view;
    TicTacToe myObj;

    //Consider onCreate the public static void main in Android. This gets called when you run your application
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Default onCreate statement which is a MUST to be specified
        setContentView(R.layout.activity_main); //Sets the layout of the application as to the one specified in activity_main
        Button b00 = (Button) findViewById(R.id.button00); //Declares and initializes button at (0, 0)
        Button b01 = (Button) findViewById(R.id.button01); //Declares and initializes button at (0, 1)
        Button b02 = (Button) findViewById(R.id.button02); //Declares and initializes button at (0, 2)
        Button b10 = (Button) findViewById(R.id.button10); //Declares and initializes button at (1, 0)
        Button b11 = (Button) findViewById(R.id.button11); //Declares and initializes button at (1, 1)
        Button b12 = (Button) findViewById(R.id.button12); //Declares and initializes button at (1, 2)
        Button b20 = (Button) findViewById(R.id.button20); //Declares and initializes button at (2, 0)
        Button b21 = (Button) findViewById(R.id.button21); //Declares and initializes button at (2, 1)
        Button b22 = (Button) findViewById(R.id.button22); //Declares and initializes button at (2, 2)
        Button newGame = (Button) findViewById(R.id.newGame); //Declares and initializes the New Game button
        Button[][] myButtons = {{b00, b01, b02}, {b10, b11, b12}, {b20, b21, b22}}; //Creates a 2d array of buttons

        view = new TicTacToeView(myButtons, newGame); //Initializes the TicTacToeView object
        myObj = new TicTacToe(view); //Initializes the TicTacToe object
    }

    /**
     * Gets called whenever a button is clicked as we had specified in the activity_main layout file
     * @param v : The current view
     */
    public void buttonClicked(View v) {
        switch (v.getId()) { //Create a switch for all the IDs we have in the view
            case R.id.button00: //If the element clicked was button at (0, 0)
                myObj.updateGameBoard(0, 0); //Call updateGameBoard with (0, 0) as arguments
                break;
            case R.id.button01:
                myObj.updateGameBoard(0, 1);
                break;
            case R.id.button02:
                myObj.updateGameBoard(0, 2);
                break;
            case R.id.button10:
                myObj.updateGameBoard(1, 0);
                break;
            case R.id.button11:
                myObj.updateGameBoard(1, 1);
                break;
            case R.id.button12:
                myObj.updateGameBoard(1, 2);
                break;
            case R.id.button20:
                myObj.updateGameBoard(2, 0);
                break;
            case R.id.button21:
                myObj.updateGameBoard(2, 1);
                break;
            case R.id.button22:
                myObj.updateGameBoard(2, 2);
                break;
            case R.id.newGame:
                myObj.newGame();
                break;
        }
    }
}


