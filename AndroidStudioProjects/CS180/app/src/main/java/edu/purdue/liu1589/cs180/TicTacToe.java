package edu.purdue.liu1589.cs180;

public class TicTacToe {

    TicTacToeViewInterface view; //The view interface used to make modifications to the view
    char[][] board; //The 3x3 board represented with characters
    char currentPlayer; //Keeps track of whose turn it is currently
    int cellsOccupied; //Keeps track of how many cells on the board are occupied
    char winner; //Keeps track of who won

    /**
     * Constructor. Initializes the instance variables.
     */
    public TicTacToe(TicTacToeViewInterface view) {
        this.view = view;
        this.board = new char [3][3];
        this.currentPlayer = 'X';
        this.cellsOccupied = 0;
        this.winner = ' ';
    }

    /**
     * This function is called to start a new game.
     *
     */
    public void newGame() {
        //TODO: Complete this method.
        //Hint : Call reset(). That's it :)
        reset();
    }

    /**
     * This function should reset each button on the grid.
     */
    public void reset() {
        //TODO: Complete this method.
        //Every time a new game begins, make sure to reset the view as well
        //as the board and the other instance variables.
        this.board = new char [3][3];
        this.currentPlayer = 'X';
        this.cellsOccupied = 0;
        view.resetButtons();
        this.winner = ' ';
    }

    /**
     * This function checks if the given player has won the game or not. The checks have to be made in each column, row, forward and backward diagonals. If a player has won, use a message alert box, toast, etc. to print the winner.
     */
    public boolean checkWinner(char player) {
        //TODO: Complete this method.
        //Iterate through the board matrix and check if you find a sequence of winning patters and set winner to the 'X' or 'O' accordingly. Further, return true if there is a winning pattern.
        // 0,1
        if (board [0][1] == player){
            if(board [0][0] == player && board [0][2] == player){
                return true;
            }
        }
        if (board [1][0] == player){
            if(board [0][0] == player && board [2][2] == player){
                return true;
            }
        }
        if (board [2][1] == player){
            if(board [2][0] == player && board [2][2] == player){
                return true;
            }
        }
        if (board [1][2] == player){
            if(board [0][2] == player && board [2][2] == player){
                return true;
            }
        }
        if (board [1][1] == player){
            if(board [0][0] == player && board [2][2] == player){
                return true;
            }
            if(board [0][2] == player && board [2][0] == player){
                return true;
            }
            if (board [0][1] == player&& board [2][1] == player){
                return true;
            }
            if (board [1][0] == player && board [1][2] == player){
                return true;
            }
        }

        return false;
    }

    public void gameOver(){
        System.out.println("Game is Over!");
    }
    /**
     * This function updates the game board whenever a user clicks on any of the game buttons, inside this function you need to call checkWinner to check if a player has won the last click on the board
     */
    public void updateGameBoard(int x, int y) {
        //TODO: Complete this method.
        //Step 1: Check if current player is a winner in which case, you'd not do further updates.
        //Step 2: Check if the count of cellsOccupied is 9, in which case the game would be over. You can perhaps make an additional method void gameOver() to handle this scenario and call it here.
        //Step 3: Update the view by setting the text of button at position (x,y) to the current player's symbol. Call the update method of the view object to do so.
        //Step 4: Update instance variables of this class as needed
        //Step 5: If current player is X, change it to O and vice-versa.
        //Step 6: Check again if the current player is a winner
        if (checkWinner(currentPlayer)){
            this.winner = currentPlayer;
            view.disableButtons();
        }
        if (cellsOccupied == 9){
            gameOver();
            view.disableButtons();
        }

        //Step 3:
        view.update(x, y, this.currentPlayer);

        //Step 4:
        this.cellsOccupied ++;
        board [x][y] = currentPlayer;
        if (checkWinner(currentPlayer)){
            this.winner = currentPlayer;
            view.disableButtons();
        }

        if (currentPlayer == 'X'){
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }

        if (checkWinner(currentPlayer)){
            System.out.printf("We have a Winner: %s", currentPlayer);
        }

    }
}