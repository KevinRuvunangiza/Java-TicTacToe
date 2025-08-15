package obj;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.GameController;

public class Game extends JFrame {

    public String _title;
    public int _width;
    public int _height;

    GameController gameController = new GameController();
    AIPlayer aiPlayer = new AIPlayer(gameController);
    JLabel statusLabel = new JLabel("It's Player " + gameController.getCurrentPlayer() + "'s turn");
    BoardPanel boardPanel = new BoardPanel(gameController, statusLabel,aiPlayer);

    public Game(String title, int width, int height) {
        this._title = title;
        this._width = width;
        this._height = height;
        statusLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 25));
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setOpaque(true);
    }

    public void createFrame() {
        this.setTitle(_title);
        this.setSize(_width, _height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(boardPanel, "Center");
        this.add(statusLabel, "North");

        this.setVisible(true);
    }

}
