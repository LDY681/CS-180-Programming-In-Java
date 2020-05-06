package edu.purdue.liu1589.cs180;

import android.graphics.Color;
import android.widget.Button;

public class TicTacToeView implements TicTacToeViewInterface {

    static Button[][] myButtons; //The 3x3 matrix of buttons
    static Button newGameButton; //The "New Game" button

    /**
     * Constructor. Initializes the instance variables.
     */
    public TicTacToeView(Button[][] myButtons, Button newGameButton) {
        this.myButtons = myButtons;
        this.newGameButton = newGameButton;
    }

    @Override
    public void update(int x, int y, char player) {
        //TODO: Complete this method.
        //Step 1: Update the text of button at index (x, y) to the player's symbol. In order to convert a char to a String, you can do (charVariable + "")
        //Example usage : myButtons[x][y].setText("" + player);
        //Step 2: Disable the button at index (x, y) from being clicked further.
        //Example usage : myButtons[x][y].setEnabled(false);
        //Step 3: Set text color of the button to BLUE for O or RED for X.
        //Example usage : myButtons[x][y].setTextColor(Color.BLUE);
        myButtons [x][y].setText("" + player);
        myButtons[x][y].setEnabled(false);
        if ( player == 'O'){
            myButtons[x][y].setTextColor(Color.BLUE);
        }else {myButtons[x][y].setTextColor(Color.RED);}

    }

    @Override
    public void showWinner(String winner) {
        //NOT REQUIRED TO BE WRITTEN FOR THIS LAB
    }

    @Override
    public void resetButtons() {
        //TODO: Complete this method.
        //Step 1: Iterate through the myButton matrix.
        //Step 2: Reset the text of the current button.
        //Example usage : myButtons[i][j].setText("");
        //Step 3: Reset the color of text for the current button
        //Example usage : myButtons[x][y].setTextColor(Color.BLACK);
        //Step 4: Make the button clickable again
        //Example usage : myButtons[x][y].setEnabled(true);
        for (int i  = 0;i < myButtons.length; i++){
            for (int j = 0; j < myButtons.length; j++){
                myButtons[i][j].setText("");
                myButtons[i][j].setTextColor(Color.BLACK);
                myButtons[i][j].setEnabled(true);
            }
        }
    }

    @Override
    public void disableButtons() {
        //TODO: Complete this method.
        //Step 1: Iterate through the myButton matrix.
        //Step 2: Make the current button un-clickable
        //Example usage : myButtons[x][y].setEnabled(false);
        for (int i  = 0;i < myButtons.length; i++){
            for (int j = 0; j < myButtons.length; j++){
                myButtons[i][j].setEnabled(false);
            }
        }
    }

    @Override
    public void gameOver() {
        //NOT REQUIRED TO BE WRITTEN FOR THIS LAB
    }
}

