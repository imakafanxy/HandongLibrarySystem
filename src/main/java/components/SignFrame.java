package main.java.components;
import javax.swing.*;
import java.awt.*;

public class SignFrame extends JFrame {
    public SignFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
}
