package controllers;

public class GameController {

    private String player1Symbol = "X";
    private String player2Symbol = "O";
    private String currentPlayerSymbol = player1Symbol;
    public boolean isGameOver = false;

    public String[][] board = new String[3][3];

    public GameController() {
        isGameOver = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }

        System.out.println("GameController initialized with empty board.");
    }

    public String makeMove(int row, int col) {

        if (isGameOver) {
        
            return "GAMEOVER!";
        } else {

            if (board[row][col].isEmpty()) {

                board[row][col] = currentPlayerSymbol;

                if (checkWin()) {
                    isGameOver = true;
                    return "Player " + currentPlayerSymbol + " wins!";
                } else if (isBoardFull()) {

                    isGameOver = true;
                    return "The game is a draw!";

                } else {
                    switchPlayer();
                    return "It's " + currentPlayerSymbol + " turn";
                    
                }

                // return true;
            } else {
                System.out.println("Position already occupied.");
                return "Position already occupied.";
            }

        }
    }

    private void switchPlayer() {

        if (currentPlayerSymbol.equals(player1Symbol)) {
            currentPlayerSymbol = player2Symbol;
        } else if (currentPlayerSymbol.equals(player2Symbol)) {
            currentPlayerSymbol = player1Symbol;
        }
    }

    public String getCurrentPlayer() {
        return currentPlayerSymbol;
    }

    private boolean checkWin() {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(currentPlayerSymbol) &&
                    board[i][1].equals(currentPlayerSymbol) &&
                    board[i][2].equals(currentPlayerSymbol)) {
                return true;

            }
        }

        // Check Columns

        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals(currentPlayerSymbol) &&
                    board[1][j].equals(currentPlayerSymbol) &&
                    board[2][j].equals(currentPlayerSymbol)) {
                return true;

            }
        }

        // Check Diagonals
        if (board[0][0].equals(currentPlayerSymbol) &&
                board[1][1].equals(currentPlayerSymbol) &&
                board[2][2].equals(currentPlayerSymbol)) {
            return true;
        }

        // Check Anti-Diagonal
        if (board[0][2].equals(currentPlayerSymbol) &&
                board[1][1].equals(currentPlayerSymbol) &&
                board[2][0].equals(currentPlayerSymbol)) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
