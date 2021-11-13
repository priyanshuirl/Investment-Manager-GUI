import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.event.ActionEvent;

public class EPortfolio {
    public static void main(String[] args) {

        // Instantiating the Frame for Home Menu
        Frame home = new Frame();
        home.setTitle("EPortfolio");

        // Creating the Menu and Menu Items
        JMenu menu;
        JMenuItem op1, op2, op3, op4, op5, op6;
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Commands Menu");
        op1 = new JMenuItem("Buy Investments");
        op2 = new JMenuItem("Sell Investments");
        op3 = new JMenuItem("Update Investments");
        op4 = new JMenuItem("Get Gain");
        op5 = new JMenuItem("Search");
        op6 = new JMenuItem("Quit");
        menu.add(op1);
        menu.add(op2);
        menu.add(op3);
        menu.add(op4);
        menu.add(op5);
        menu.add(op6);

        // Adding Action Listeners to the Menu Items
        op6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });

        // Adding styles to the Menu and Menu Items
        op1.setFont(new Font("Arial", Font.BOLD, 20));
        op2.setFont(new Font("Arial", Font.BOLD, 20));
        op3.setFont(new Font("Arial", Font.BOLD, 20));
        op4.setFont(new Font("Arial", Font.BOLD, 20));
        op5.setFont(new Font("Arial", Font.BOLD, 20));
        op6.setFont(new Font("Arial", Font.BOLD, 20));

        mb.add(menu);
        home.setJMenuBar(mb);

        Font f = new FontUIResource(mb.getFont().getFontName(), mb.getFont().getStyle(), 30);
        UIManager.put("Menu.font", f);
        SwingUtilities.updateComponentTreeUI(home);
        mb.setOpaque(true);
        mb.setBackground(new Color(0xff4709));
        menu.setForeground(new Color(0xffffff));
        Border emptyBorder3 = new EmptyBorder(10, 10, 10, 10);
        mb.setBorder(emptyBorder3);

        // Creating the Intro Label
        JLabel intro = new JLabel("Welcome To Your EPortfolio");
        intro.setFont(new Font("Arial", Font.BOLD, 30));
        intro.setForeground(new Color(0xff4709));
        Border emptyBorder = new EmptyBorder(120, 10, 10, 10);
        intro.setBorder(emptyBorder);

        // Creating the intro description
        JTextArea description = new JTextArea(5, 36);
        description.setText(
                "Choose a command by clicking an Option from the “Commands” menu above to buy or sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program.");
        description.setFont(new Font("Verdana", Font.PLAIN, 16));
        description.setForeground(new Color(0xffffff));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setEditable(false);
        Border emptyBorder2 = new EmptyBorder(30, 10, 10, 10);
        description.setBorder(emptyBorder2);

        // Adding the Elements to the Home Frame
        home.add(intro);
        home.add(description);
        home.setVisible(true);
    }
}
