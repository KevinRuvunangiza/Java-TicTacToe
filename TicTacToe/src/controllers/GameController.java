package controllers;

public class GameController {

    private String player1Symbol = "X";
    private String player2Symbol = "O";
    private String currentPlayerSymbol = player1Symbol;
    private boolean isGameOver = false;

    public String [][] board = new String[3][3]; 

    public GameController(){

        currentPlayerSymbol = player1Symbol;
        isGameOver = false;


        for(int i = 0; i<3;i++){
            for(int j = 0; j<3; j++){
                board[i][j] = "";
            }
        }

        System.out.println("GameController initialized with empty board.");
    }

    public boolean makeMove(int row,int col){

        if (board[row][col].isEmpty()) {
            board[row][col] = currentPlayerSymbol;
            switchPlayer();
            System.out.println("Move made at (" + row + ", " + col + ") by player: " + currentPlayerSymbol);     
            System.out.println(board);       
            return true;
        }else{
            System.out.println("Position already occupied.");
            System.out.println(board);
            return false;
        }
    }

    private void switchPlayer(){
       
        if (currentPlayerSymbol == player1Symbol) {
            currentPlayerSymbol = player2Symbol;
        }else if(currentPlayerSymbol == player2Symbol){
             currentPlayerSymbol = player1Symbol;
        }
    }

   public String getCurrentPlayer(){
    return currentPlayerSymbol;
   }
}
