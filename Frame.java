import javax.swing.JFrame;

import java.awt.Color;
import java.awt.FlowLayout;

public class Frame extends JFrame {
    public Frame() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setSize(600, 600);
        this.getContentPane().setBackground(new Color(0x222222));
        setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
