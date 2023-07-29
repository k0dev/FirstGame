package firstgame;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(int width, int height, Game game) {
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(game);
        setVisible(true);
    }
}
