import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.BorderLayout;

public class EPortfolio {
    public static void main(String[] args) {
        GUIFrame frame = new GUIFrame();// Instantiating the Frame

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(200, 50));
        panel1.setBackground(new Color(0x222222));
        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        JComboBox<String> petList = new JComboBox<String>(petStrings);
        petList.setFont(new Font("Sans-Serif", Font.PLAIN, 30));
        panel1.add(petList);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(100, 10));
        panel2.setBackground(new Color(0x222222));
        JLabel intro = new JLabel();// Creating the Intro Label
        intro.setText("Welcome to Your EPortfolio");
        intro.setFont(new Font("Sans-Serif", Font.BOLD, 36));
        intro.setForeground(new Color(0xff4709));
        panel2.add(intro);

        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(100, 450));
        panel3.setBackground(new Color(0x222222));
        JTextArea textArea = new JTextArea(2, 44);
        textArea.setText(
                "Choose a command from the “Commands” menu to buy or sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program.");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(UIManager.getColor("Label.background"));
        textArea.setBorder(UIManager.getBorder("Label.border"));
        textArea.setFont(new Font("Sans-Serif", Font.BOLD, 13));
        textArea.setForeground(new Color(0xFFFFFF));
        panel3.add(textArea);

        frame.add(panel1, BorderLayout.WEST);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}