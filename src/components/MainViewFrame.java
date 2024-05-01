package components;

import javax.swing.*;
import java.awt.*;

public class MainViewFrame extends JFrame {
    public MainViewFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
}
