package Presentation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int FRAME_WIDTH = 1024;
    public static final int FRAME_HEIGHT = 640;
    public static final int MINIMUM_WIDTH = 400;
    public static final int MINIMUM_HEIGHT = 300;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
        setTitle("City Building Education - Iteration0");
        setLayout(new GridBagLayout());
    }
}
