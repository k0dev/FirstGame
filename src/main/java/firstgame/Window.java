package firstgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Window extends JFrame {

    public Window(int width, int height, Game game) {
        //setPreferredSize(new Dimension(width, height));
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.add(game);
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
