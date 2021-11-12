import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GUIFrame extends JFrame {
    public GUIFrame() {
        this.setTitle("EPortfolio"); // Create a Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.getContentPane().setBackground(new Color(0x222222));
        this.setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }
}
