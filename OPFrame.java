import javax.swing.JFrame;

import java.awt.Color;
import java.awt.GridLayout;

public class OPFrame extends JFrame {
    public OPFrame() {
        setLayout(new GridLayout(2,1));
        this.setSize(600, 600);
        this.getContentPane().setBackground(new Color(0x222222));
        setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
