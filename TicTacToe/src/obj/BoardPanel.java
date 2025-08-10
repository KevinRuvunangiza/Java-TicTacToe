package obj;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.GameController;

public class BoardPanel extends JPanel implements ActionListener {

   public int _rows = 3;
   public int _cols = 3;
   public int _hGap = 5;
   public int _vGap = 5;
   public int _numOfGrids = _rows * _cols;

   JButton[][] _gridButtons = new JButton[_rows][_cols];
   GameController _gameController;
   JLabel _statusLabel;

   // BoardPanel constructor
   public BoardPanel(GameController gameController, JLabel statusLabel) {

      this.setBackground(Color.black);
      this.setLayout(new GridLayout(_rows, _cols, _hGap, _vGap));
      this._gameController = gameController;
      this._statusLabel = statusLabel;

      for (int i = 0; i < _rows; i++) {
         for (int j = 0; j < _cols; j++) {

            _gridButtons[i][j] = new JButton();

            _gridButtons[i][j].addActionListener(e -> actionPerformed(e));
            _gridButtons[i][j].setActionCommand(i + "," + j);
            _gridButtons[i][j].setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 60));
            _gridButtons[i][j].setForeground(Color.BLACK);
            _gridButtons[i][j].setBackground(Color.white);
            _gridButtons[i][j].setBorder(null);
            _gridButtons[i][j].setOpaque(true);

            this.add(_gridButtons[i][j]);
         }
      }

   }

   public void actionPerformed(ActionEvent e) {

      String command = e.getActionCommand();
      String[] indices = command.split(",");

      int row = Integer.parseInt(indices[0]);
      int col = Integer.parseInt(indices[1]);

      String currentPlayerBeforeMove = _gameController.getCurrentPlayer();
      String moveMade = _gameController.makeMove(row, col);

      if (!moveMade.equals("Position already occupied.")) {
         _gridButtons[row][col].setText(currentPlayerBeforeMove);
         _statusLabel.setText(moveMade);
         // _gridButtons[row][col].setEnabled(false);

         // Lock the grid buttons if the game is over
         if (_gameController.isGameOver) {
            for (int i = 0; i < _rows; i++) {
               for (int j = 0; j < _cols; j++) {

                  _gridButtons[i][j].setEnabled(false);
               }
            }

         }

         if (currentPlayerBeforeMove.equals("X")) {
            _gridButtons[row][col].setForeground(Color.decode("#3A86FF")); // Blue for player X
         } else {
            _gridButtons[row][col].setForeground(Color.decode("#FF9F1C")); // Orange for player O

         }
      }

   }
}
