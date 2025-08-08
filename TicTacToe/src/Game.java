import javax.swing.JFrame;

import obj.BoardPanel;

public class Game extends JFrame {

    public String _title;
    public int _width;
    public int _height;

    BoardPanel boardPanel = new BoardPanel();

    public Game(String title, int width, int height) {
        this._title = title;
        this._width = width;
        this._height = height;
    }

    public void createFrame() {
        this.setTitle(_title);
        this.setSize(_width, _height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(boardPanel);

        this.setVisible(true);
    }

}
