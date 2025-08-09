package obj;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.GameController;

public class BoardPanel extends JPanel implements ActionListener {

   public int _rows = 3;
   public int _cols = 3;
   public int _hGap = 5;
   public int _vGap = 5;
   public int _numOfGrids = _rows * _cols;

   JButton[][] gridButtons = new JButton[_rows][_cols];

   public BoardPanel() {
      this.setBackground(Color.DARK_GRAY);
      this.setLayout(new GridLayout(_rows, _cols, _hGap, _vGap));

      for (int i = 0; i < _rows; i++) {
         for (int j = 0; j < _cols; j++) {

            gridButtons[i][j] = new JButton();

            gridButtons[i][j].addActionListener(e -> actionPerformed(e));
            gridButtons[i][j].setActionCommand(i + "," + j);
            gridButtons[i][j].setFont(gridButtons[i][j].getFont().deriveFont(24f));
            gridButtons[i][j].setForeground(Color.BLACK);
            gridButtons[i][j].setBackground(Color.white);
            gridButtons[i][j].setOpaque(true);
            gridButtons[i][j].setBorderPainted(false);
            this.add(gridButtons[i][j]);
         }
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      GameController gameController = new GameController();
      String command = e.getActionCommand();
      String[] indices = command.split(",");
      int row = Integer.parseInt(indices[0]);
      int col = Integer.parseInt(indices[1]);
      boolean moveMade = gameController.makeMove(row, col);
   }
}
