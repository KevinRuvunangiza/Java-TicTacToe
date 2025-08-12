package obj;

import controllers.GameController;

public class AIPlayer {

    GameController _gameController;
    String _aiPlayerSymbol;
    // Constructor for AIPlayer
    public AIPlayer(GameController gameController) {
        this._gameController = gameController;
        this._aiPlayerSymbol = "O"; // Assuming AI plays with 'O'
        
    }

    public void makeRandomMove() {

        int rows = _gameController.getRow();
        int cols = _gameController.getCol();

        // Find a random empty position on the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (_gameController.board[i][j].isEmpty()) {
                    _gameController.makeMove(i, j);
                    return; // Move made, exit the method
                }
            }
        }
    }
    
}
