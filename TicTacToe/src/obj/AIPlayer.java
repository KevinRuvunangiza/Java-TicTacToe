package obj;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import controllers.GameController;

public class AIPlayer {

    int _rows = 3;
    int _cols = 3;
    List<int[]> _availableMoves = new ArrayList<>();

    public GameController _gameController;

    public AIPlayer(GameController gameController) {

        this._gameController = gameController;
    }

    public int[] findRandomMoves() {
        _availableMoves.clear();
        for (int i = 0; i < _rows; i++) {
            for (int j = 0; j < _cols; j++) {

                if (_gameController.getBoard()[i][j].isEmpty()) {
                    _availableMoves.add(new int[] { i, j });

                }

            }

        }

        for (int[] position : _availableMoves) {
            System.out.println(
                    "Available Moves: " + _availableMoves.size() + "\nMove: " + Arrays.toString(position) + "\n");
        }
        return _availableMoves.get((int) (Math.random() * _availableMoves.size()));
    }
}
