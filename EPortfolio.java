import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class EPortfolio {
    private static PortfolioManager portfolio;
    static ArrayList<String> Investmentsrecords = new ArrayList<>();
    static HashMap<String, String> index = new HashMap<String, String>(50);

    final static double stockCommission = 9.99;
    final static double mutualFundCommission = 45;
    static int iter = 0;

    public static void main(String[] args) {
        portfolio = new PortfolioManager();
        // Instantiating the Frame for Home Menu
        class Frame extends JFrame {
            public Frame() {
                setLayout(new FlowLayout(FlowLayout.LEFT));
                this.setSize(600, 600);
                this.getContentPane().setBackground(new Color(0x222222));
                setLocationRelativeTo(null);
                this.setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }
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

        // Initialising the frames
        OPFrame buy = new OPFrame();
        OPFrame sell = new OPFrame();
        OPFrame update = new OPFrame();
        OPFrame getgain = new OPFrame();
        OPFrame search = new OPFrame();

        // Adding Action Listeners to the Menu Items
        // Adding action listener to the Buy Menu Item

        op1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                buy.getContentPane().removeAll();
                buy.repaint();
                buy.setTitle("Buy Investments");
                buy.setJMenuBar(mb);

                // Creating Panels for Displaying Components
                JPanel actionpanel = new JPanel();
                actionpanel.setLayout(new GridLayout(1, 2, 16, 16));
                actionpanel.setBackground(new Color(0x222222));
                actionpanel.setBounds(40, 80, 200, 200);

                // Panel for input fields
                JPanel inputs = new JPanel();
                inputs.setLayout(new FlowLayout(FlowLayout.CENTER));
                inputs.setBackground(new Color(0x222222));
                Border inputborder = new EmptyBorder(10, 10, 10, 10);
                inputs.setBorder(inputborder);

                JLabel buyhead = new JLabel("Buying an Investment");
                buyhead.setFont(new Font("Verdana", Font.BOLD, 21));
                buyhead.setForeground(new Color(0xff4709));
                Border inputhead = new EmptyBorder(10, 10, 10, 10);
                inputs.setBorder(inputhead);
                inputs.add(buyhead);

                // Input for type
                JLabel type = new JLabel("Type : ");
                type.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                type.setForeground(new Color(0xffffff));
                inputs.add(type);
                String[] choices = { "Stock", "Mutual Fund" };
                final JComboBox<String> cb = new JComboBox<String>(choices);
                cb.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(cb);

                // Input for Symbol
                JLabel symbol = new JLabel("Symbol : ");
                symbol.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                symbol.setForeground(new Color(0xffffff));
                inputs.add(symbol);
                JTextField t1 = new JTextField(10);
                t1.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t1);

                // Input for Name
                JLabel name = new JLabel("Name : ");
                name.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                name.setForeground(new Color(0xffffff));
                inputs.add(name);
                JTextField t2 = new JTextField(10);
                t2.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t2);

                // Input for Quantity
                JLabel qty = new JLabel("Quantity : ");
                qty.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                qty.setForeground(new Color(0xffffff));
                inputs.add(qty);
                JTextField t3 = new JTextField(6);
                t3.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t3);

                // Input for Price
                JLabel price = new JLabel("Price : ");
                price.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                price.setForeground(new Color(0xffffff));
                inputs.add(price);
                JTextField t4 = new JTextField(6);
                t4.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t4);

                // Panel for buttons
                JPanel btns = new JPanel();
                btns.setLayout(new FlowLayout(FlowLayout.CENTER));
                btns.setBackground(new Color(0x222222));
                Border btnborder = new EmptyBorder(60, 50, 50, 50);
                btns.setBorder(btnborder);

                JButton reset = new JButton("Reset");
                JButton buyinv = new JButton("Buy");

                reset.setFocusable(false);
                buyinv.setFocusable(false);

                // Styling the Buttons
                reset.setBackground(new Color(0xff4709));
                reset.setForeground(new Color(0xffffff));
                buyinv.setBackground(new Color(0xff4709));
                buyinv.setForeground(new Color(0xffffff));
                reset.setFont(new Font("Arial", Font.BOLD, 30));
                buyinv.setFont(new Font("Arial", Font.BOLD, 30));
                reset.setPreferredSize(new Dimension(140, 50));
                btns.add(reset);
                buyinv.setPreferredSize(new Dimension(140, 50));
                btns.add(buyinv);

                actionpanel.add(inputs);
                actionpanel.add(btns);

                // Panel for displaying the results
                JPanel msgpanel = new JPanel();
                msgpanel.setLayout(new GridLayout(1, 1));
                msgpanel.setBackground(new Color(0xff4709));
                msgpanel.setBounds(40, 80, 200, 200);

                // Initialising the Display textarea
                JTextArea display = new JTextArea(5, 36);
                display.setFont(new Font("Arial", Font.BOLD, 20));
                display.setLineWrap(true);
                display.setWrapStyleWord(true);
                Border displayborder = new EmptyBorder(25, 25, 25, 25);
                display.setBorder(displayborder);
                JScrollPane scroll = new JScrollPane(display);
                scroll.setForeground(new Color(0xffffff));
                scroll.setOpaque(false);
                msgpanel.add(scroll);
                display.setEditable(false);

                // Displaying the results
                buyinv.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String invtype = cb.getItemAt(cb.getSelectedIndex());
                            String invsymbol = t1.getText();
                            String invname = t2.getText();
                            int invqty = Integer.parseInt(t3.getText());
                            double invprice = Double.parseDouble(t4.getText());

                            if (invtype.equals("Stock")) {
                                // to check if stock already exists
                                Investment symbol = portfolio.checkInvestment(invsymbol);
                                Investment investment = symbol;
                                if (symbol != null) {
                                    if (investment.getType().equals("stock")) {
                                        if (invqty > 0) {
                                            double price = invprice;
                                            if (price > 0) {
                                                double bookValue = ((invqty * price) + stockCommission)
                                                        + investment.getBookValue();
                                                investment.setQuantity(investment.getQuantity() + invqty);
                                                investment.setBookValue(bookValue);
                                                investment.setPrice(price);
                                                String out = "Updated the quantity to " + investment.getQuantity()
                                                        + " and price to " + invprice + " for " + invname
                                                        + " stocks.\n";
                                                display.setText(out);
                                                display.setEditable(false);
                                            } else {
                                                String out = "Price can't be Negative or Zero";
                                                display.setText(out);
                                                display.setEditable(false);
                                            }
                                        } else {
                                            String out = "Quantity can't be Negative or Zero";
                                            display.setText(out);
                                            display.setEditable(false);
                                        }
                                    }
                                } else {
                                    String name = invname;
                                    int qnt = invqty;
                                    if (qnt > 0) {
                                        double price = invprice;
                                        if (price > 0) {
                                            Stock stockk = new Stock(invsymbol, name, qnt, price, "stock");
                                            stockk.symbol = invsymbol;
                                            stockk.name = name;
                                            stockk.quantity = qnt;
                                            stockk.price = price;
                                            double bv = price * qnt + stockCommission;
                                            stockk.setBookValue((price * qnt) + stockCommission);
                                            stockk.bookValue = bv;
                                            portfolio.addInvestments(stockk);
                                            String out = "Added " + invqty + " " + invname + " stocks at " + price
                                                    + " per stock.\n";
                                            display.setText(out);
                                            display.setEditable(false);
                                        } else {
                                            String out = "Price can't be Negative or Zero";
                                            display.setText(out);
                                            display.setEditable(false);
                                        }
                                    } else {
                                        String out = "Quantity can't be Negative or Zero";
                                        display.setText(out);
                                        display.setEditable(false);
                                    }
                                }
                            } else {
                                // to check if mutual fund already exits
                                Investment symbol = portfolio.checkInvestment(invsymbol);
                                if (symbol != null) {
                                    // to manupilate quantity
                                    int mfquantity = invqty;
                                    Investment investment = symbol;
                                    if (investment.getType().equals("mutualfund")) {
                                        if (mfquantity > 0) {
                                            double price = invprice;
                                            if (price > 0) {
                                                double bookValue = ((mfquantity * price) + investment.getBookValue());
                                                int newQuantity = investment.getQuantity() + mfquantity;
                                                investment.setPrice(price);
                                                investment.setQuantity(newQuantity);
                                                investment.setBookValue(bookValue);

                                                String out = "Updated the quantity to " + investment.getQuantity()
                                                        + " and price to " + invprice + " for " + invname
                                                        + " Mutual Fund.\n";
                                                display.setText(out);
                                                display.setEditable(false);
                                            } else {
                                                String out = "Price can't be Negative or Zero";
                                                display.setText(out);
                                                display.setEditable(false);
                                            }
                                        } else {
                                            String out = "Quantity can't be Negative or Zero";
                                            display.setText(out);
                                            display.setEditable(false);
                                        }
                                    }
                                } else {
                                    // to buy new mutual fund
                                    String name = invname;
                                    int qnt = invqty;
                                    if (qnt > 0) {
                                        double price = invprice;
                                        if (price > 0) {
                                            MutualFund mutualFund = new MutualFund(invsymbol, name, qnt, price,
                                                    "mutualfund");
                                            mutualFund.setBookValue(price * qnt);
                                            portfolio.addInvestments(mutualFund);
                                            String out = "Added " + invqty + " " + invname + " Mutual Fund units at "
                                                    + price + " per unit.\n";
                                            display.setText(out);
                                            display.setEditable(false);
                                        } else {
                                            String out = "Price can't be Negative or Zero";
                                            display.setText(out);
                                            display.setEditable(false);
                                        }
                                    } else {
                                        String out = "Quantity can't be Negative or Zero";
                                        display.setText(out);
                                        display.setEditable(false);
                                    }
                                }
                            }
                        } catch (Exception error) {
                            String out = "Something Went Wrong, Please Try Again.\n\nPlease make sure that\n1)You have not left any Field Blank\n2)You have entered an integer value only for Quantity.\n3)You have not entered any text in the Price and Quanity fields.";
                            display.setText(out);
                            display.setEditable(false);
                        }
                    }
                });
                // reset button to clear out all the fields
                reset.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cb.setSelectedIndex(0);
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        display.setText("");
                    }
                });
                // Adding the Panels
                buy.add(actionpanel);
                buy.add(msgpanel);
                buy.setVisible(true);

                // Disposing the Panels
                sell.dispose();
                home.dispose();
                update.dispose();
            }
        });
        // Adding action listener to the sell Menu Item
        op2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                sell.getContentPane().removeAll();
                sell.repaint();
                sell.setTitle("Sell Investments");
                sell.setJMenuBar(mb);

                // Creating Panels for Displaying Components
                JPanel actionpanel = new JPanel();
                actionpanel.setLayout(new GridLayout(1, 2, 16, 16));
                actionpanel.setBackground(new Color(0x222222));
                actionpanel.setBounds(40, 80, 200, 200);

                // Panel for input fields
                JPanel inputs = new JPanel();
                inputs.setLayout(new FlowLayout(FlowLayout.CENTER));
                inputs.setBackground(new Color(0x222222));
                Border inputborder = new EmptyBorder(10, 10, 10, 10);
                inputs.setBorder(inputborder);

                JLabel buyhead = new JLabel("Selling an Investment");
                buyhead.setFont(new Font("Verdana", Font.BOLD, 21));
                buyhead.setForeground(new Color(0xff4709));
                Border inputhead = new EmptyBorder(10, 10, 10, 10);
                inputs.setBorder(inputhead);
                inputs.add(buyhead);

                // Input for Symbol
                JLabel symbol = new JLabel("Symbol : ");
                symbol.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                symbol.setForeground(new Color(0xffffff));
                inputs.add(symbol);
                JTextField t1 = new JTextField(10);
                t1.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t1);

                // Input for Quantity
                JLabel qty = new JLabel("Quantity : ");
                qty.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                qty.setForeground(new Color(0xffffff));
                inputs.add(qty);
                JTextField t3 = new JTextField(6);
                t3.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t3);

                // Input for Price
                JLabel price = new JLabel("Price : ");
                price.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                price.setForeground(new Color(0xffffff));
                inputs.add(price);
                JTextField t4 = new JTextField(6);
                t4.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t4);

                // Panel for buttons
                JPanel btns = new JPanel();
                btns.setLayout(new FlowLayout(FlowLayout.CENTER));
                btns.setBackground(new Color(0x222222));
                Border btnborder = new EmptyBorder(60, 50, 50, 50);
                btns.setBorder(btnborder);

                JButton reset = new JButton("Reset");
                JButton buyinv = new JButton("Sell");

                reset.setFocusable(false);
                buyinv.setFocusable(false);

                // Styling the Buttons
                reset.setBackground(new Color(0xff4709));
                reset.setForeground(new Color(0xffffff));
                buyinv.setBackground(new Color(0xff4709));
                buyinv.setForeground(new Color(0xffffff));
                reset.setFont(new Font("Arial", Font.BOLD, 30));
                buyinv.setFont(new Font("Arial", Font.BOLD, 30));
                reset.setPreferredSize(new Dimension(140, 50));
                btns.add(reset);
                buyinv.setPreferredSize(new Dimension(140, 50));
                btns.add(buyinv);

                actionpanel.add(inputs);
                actionpanel.add(btns);

                // Panel for displaying the results
                JPanel msgpanel = new JPanel();
                msgpanel.setLayout(new GridLayout(1, 1));
                msgpanel.setBackground(new Color(0xff4709));
                msgpanel.setBounds(40, 80, 200, 200);

                // Initialising the Display textarea
                JTextArea display = new JTextArea(5, 36);
                display.setFont(new Font("Arial", Font.BOLD, 20));
                display.setLineWrap(true);
                display.setWrapStyleWord(true);
                Border displayborder = new EmptyBorder(25, 25, 25, 25);
                display.setBorder(displayborder);
                JScrollPane scroll = new JScrollPane(display);
                scroll.setForeground(new Color(0xffffff));
                scroll.setOpaque(false);
                msgpanel.add(scroll);
                display.setEditable(false);

                // Displaying the results
                buyinv.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String invsymbol = t1.getText();
                            int invqty = Integer.parseInt(t3.getText());
                            double invprice = Double.parseDouble(t4.getText());
                            String symbol = invsymbol;
                            if (portfolio.getInvestments() != null) {
                                for (Investment investment : portfolio.getInvestments()) {
                                    Investment mutualFund = investment;
                                    if (investment.getType().equals("mutualfund")) {
                                        investment = portfolio.checkInvestment(symbol); // checks if mutaul fund exists
                                        if (investment != null) {
                                            if (mutualFund.getType().equals("mutualfund")) {
                                                double price = invprice;
                                                if (price > 0) {
                                                    mutualFund.setPrice(price);
                                                    int quantity = invqty;
                                                    if (quantity > 0) {
                                                        if (quantity <= mutualFund.getQuantity()) { // checking if there
                                                                                                    // are sufficient
                                                                                                    // funds
                                                            int newQuantity = mutualFund.getQuantity() - quantity;
                                                            if (newQuantity > 0) {
                                                                double bookValue = mutualFund.getBookValue()
                                                                        * newQuantity / mutualFund.getQuantity();
                                                                mutualFund
                                                                        .setBookValue(bookValue - mutualFundCommission);
                                                                mutualFund.setQuantity(newQuantity);
                                                            } else {
                                                                portfolio.getInvestments().remove(mutualFund);
                                                            }
                                                            String out = "Successfully Sold the Mutual Funds!";
                                                            display.setText(out);
                                                            display.setEditable(false);
                                                        } else {
                                                            String out = "You don't have enough Mutual Funds to sell!";
                                                            display.setText(out);
                                                            display.setEditable(false);
                                                        }
                                                    } else {
                                                        String out = "Quanity can't be Negative or Zero";
                                                        display.setText(out);
                                                        display.setEditable(false);
                                                    }
                                                } else {
                                                    String out = "Price can't be Negative or Zero";
                                                    display.setText(out);
                                                    display.setEditable(false);
                                                }
                                            }
                                        }
                                        break;
                                    } else if (investment.getType().equals("stock")) {
                                        investment = portfolio.checkInvestment(symbol); // checks if mutaul fund exists
                                        if (investment != null) {
                                            // sell stock using symbol
                                            Investment stock = investment;
                                            if (stock.getType().equals("stock")) {
                                                stock.setOldPrice(stock.getPrice());
                                                double price = invprice;
                                                if (price > 0) {
                                                    stock.setPrice(price);
                                                    int quantity = invqty;
                                                    if (quantity > 0) {
                                                        stock.sellqty(quantity);
                                                        if (quantity <= stock.getQuantity()) { // checking if we have
                                                                                               // sufficient stocks
                                                            int newQuantity = stock.getQuantity() - quantity;
                                                            if (newQuantity > 0) {
                                                                double val1 = newQuantity;
                                                                double val2 = stock.getQuantity();
                                                                double bookValue = stock.getBookValue()
                                                                        - (stock.getBookValue() * (val1 / val2));
                                                                stock.setBookValue(bookValue);
                                                                stock.setQuantity(newQuantity);
                                                            } else {
                                                                portfolio.getInvestments().remove(stock);
                                                            }
                                                            String out = "Successfully Sold the Stock!";
                                                            display.setText(out);
                                                            display.setEditable(false);
                                                        } else {
                                                            String out = "You don't have enough stocks to sell in your Portfolio!";
                                                            display.setText(out);
                                                            display.setEditable(false);
                                                        }
                                                    } else {
                                                        String out = "Quanity can't be Negative or Zero.";
                                                        display.setText(out);
                                                        display.setEditable(false);
                                                    }
                                                }
                                            } else {
                                                String out = "Price can't be Negative or Zero.";
                                                display.setText(out);
                                                display.setEditable(false);
                                            }
                                            break;
                                        } else {
                                            String out = "Uh oh! There is no such investment in your Portfolio.";
                                            display.setText(out);
                                            display.setEditable(false);
                                        }
                                    }
                                }
                            } else {
                                String out = "Investment Not Found.";
                                display.setText(out);
                                display.setEditable(false);
                            }
                        } catch (Exception error) { // Catching the thrown exceptions
                            String out = "Something Went Wrong, Please Try Again.\n\nPlease make sure that\n1)You have not left any Field Blank\n2)You have entered an integer value only for Quantity.\n3)You have not entered any text in the Price and Quanity fields.";
                            display.setText(out);
                            display.setEditable(false);
                        }
                    }
                });

                reset.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        t1.setText("");
                        t3.setText("");
                        t4.setText("");
                        display.setText("");
                    }
                });
                sell.add(actionpanel);
                sell.add(msgpanel);
                sell.setVisible(true);

                // Disposing the Panels
                home.dispose();
                buy.dispose();
                update.dispose();
            }
        });

        op3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                update.getContentPane().removeAll();
                update.repaint();
                update.setTitle("Sell Investments");
                update.setJMenuBar(mb);

                // Creating Panels for Displaying Components
                JPanel actionpanel = new JPanel();
                actionpanel.setLayout(new GridLayout(1, 2, 16, 16));
                actionpanel.setBackground(new Color(0x222222));
                actionpanel.setBounds(40, 80, 200, 200);

                // Panel for input fields
                JPanel inputs = new JPanel();
                inputs.setLayout(new FlowLayout(FlowLayout.CENTER));
                inputs.setBackground(new Color(0x222222));
                Border inputborder = new EmptyBorder(10, 10, 10, 10);
                inputs.setBorder(inputborder);

                JLabel buyhead = new JLabel("Updating Investments");
                buyhead.setFont(new Font("Verdana", Font.BOLD, 21));
                buyhead.setForeground(new Color(0xff4709));
                Border inputhead = new EmptyBorder(10, 10, 10, 10);
                inputs.setBorder(inputhead);
                inputs.add(buyhead);

                // Input for Symbol
                JLabel symbol = new JLabel("Symbol : ");
                symbol.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                symbol.setForeground(new Color(0xffffff));
                inputs.add(symbol);
                JTextField t1 = new JTextField(10);
                t1.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t1);

                // Input for Name
                JLabel name = new JLabel("Name : ");
                name.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                name.setForeground(new Color(0xffffff));
                inputs.add(name);
                JTextField t2 = new JTextField(10);
                t2.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t2);

                // Input for Price
                JLabel price = new JLabel("Price : ");
                price.setFont(new Font("Sans-Serif", Font.BOLD, 20));
                price.setForeground(new Color(0xffffff));
                inputs.add(price);
                JTextField t4 = new JTextField(6);
                t4.setFont(new Font("Arial", Font.BOLD, 18));
                inputs.add(t4);

                // Panel for buttons
                JPanel btns = new JPanel();
                btns.setLayout(new FlowLayout(FlowLayout.CENTER));
                btns.setBackground(new Color(0x222222));
                Border btnborder = new EmptyBorder(60, 50, 50, 50);
                btns.setBorder(btnborder);

                JButton reset = new JButton("Prev");
                JButton buyinv = new JButton("Next");
                JButton save = new JButton("Save");

                reset.setFocusable(false);
                buyinv.setFocusable(false);
                save.setFocusable(false);

                // Styling the Buttons
                reset.setBackground(new Color(0xff4709));
                reset.setForeground(new Color(0xffffff));
                save.setBackground(new Color(0xff4709));
                save.setForeground(new Color(0xffffff));
                buyinv.setBackground(new Color(0xff4709));
                buyinv.setForeground(new Color(0xffffff));
                reset.setFont(new Font("Arial", Font.BOLD, 30));
                save.setFont(new Font("Arial", Font.BOLD, 30));
                buyinv.setFont(new Font("Arial", Font.BOLD, 30));
                reset.setPreferredSize(new Dimension(140, 50));
                btns.add(reset);
                buyinv.setPreferredSize(new Dimension(140, 50));
                btns.add(buyinv);
                save.setPreferredSize(new Dimension(140, 50));
                btns.add(save);

                actionpanel.add(inputs);
                actionpanel.add(btns);

                // Panel for displaying the results
                JPanel msgpanel = new JPanel();
                msgpanel.setLayout(new GridLayout(1, 1));
                msgpanel.setBackground(new Color(0xff4709));
                msgpanel.setBounds(40, 80, 200, 200);

                // Initialising the Display textarea
                JTextArea display = new JTextArea(5, 36);
                display.setFont(new Font("Arial", Font.BOLD, 20));
                display.setLineWrap(true);
                display.setWrapStyleWord(true);
                Border displayborder = new EmptyBorder(25, 25, 25, 25);
                display.setBorder(displayborder);
                JScrollPane scroll = new JScrollPane(display);
                scroll.setForeground(new Color(0xffffff));
                scroll.setOpaque(false);
                msgpanel.add(scroll);
                t1.setEditable(false);
                t2.setEditable(false);
                display.setEditable(false);

                // Next Button
                try {
                    iter = -1;
                    if (portfolio.getInvestments() != null) { // if investment exist
                        reset.setEnabled(true);
                        iter++;
                        String symb = portfolio.getInvestments().get(iter).getName();
                        t1.setText(symb);
                        t1.setEditable(false);
                        String nameinv = portfolio.getInvestments().get(iter).getName();
                        t2.setText(nameinv);
                        t2.setEditable(false);
                        Double priceinv = portfolio.getInvestments().get(iter).getPrice();
                        t4.setText(priceinv.toString());
                    }
                    if (iter > (portfolio.getInvestments().size()) - 2) {
                        buyinv.setEnabled(false);
                    }
                    buyinv.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (portfolio.getInvestments() != null) { // if investment exist
                                if (iter > (portfolio.getInvestments().size() - 2)) {
                                    buyinv.setEnabled(false);
                                } else {
                                    reset.setEnabled(true);
                                    ++iter;
                                    String symb = portfolio.getInvestments().get(iter).getName();
                                    t1.setText(symb);
                                    t1.setEditable(false);
                                    String nameinv = portfolio.getInvestments().get(iter).getName();
                                    t2.setText(nameinv);
                                    t2.setEditable(false);
                                    Double priceinv = portfolio.getInvestments().get(iter).getPrice();
                                    t4.setText(priceinv.toString());
                                }
                            }
                        }
                    });

                    // Previous Button
                    if (iter <= 0) {
                        reset.setEnabled(false);
                    }
                    reset.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (portfolio.getInvestments() != null) { // if investment exist
                                if (iter <= 0) {
                                    reset.setEnabled(false);
                                } else {
                                    buyinv.setEnabled(true);
                                    --iter;
                                    String symb = portfolio.getInvestments().get(iter).getName();
                                    t1.setText(symb);
                                    t1.setEditable(false);
                                    String nameinv = portfolio.getInvestments().get(iter).getName();
                                    t2.setText(nameinv);
                                    t2.setEditable(false);
                                    Double priceinv = portfolio.getInvestments().get(iter).getPrice();
                                    t4.setText(priceinv.toString());
                                }
                            }
                        }
                    });
                } catch (Exception error) {
                    String out = "Your portfolio seems to be empty, please add some items first.";
                    display.setText(out);
                    display.setEditable(false);
                }

                // Save Button
                save.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            double invprice = Double.parseDouble(t4.getText());
                            if (portfolio.getInvestments() != null) { // if investment exist
                                if (invprice > 0) {
                                    if (invprice != portfolio.getInvestments().get(iter).getPrice()) {
                                        Double priceinv = portfolio.getInvestments().get(iter).getPrice();
                                        portfolio.getInvestments().get(iter).setOldPrice(priceinv);
                                        portfolio.getInvestments().get(iter).setPrice(invprice);
                                        String out = "Price updated to " + invprice + " per unit for "
                                                + portfolio.getInvestments().get(iter).getName();
                                        display.setText(out);
                                        display.setEditable(false);
                                    } else {
                                        String out = "The Price has not changed, No need to save it again.";
                                        display.setText(out);
                                        display.setEditable(false);
                                    }
                                } else {
                                    String out = "Price can't be Negative or zero";
                                    display.setText(out);
                                    display.setEditable(false);
                                }
                            }
                        } catch (Exception error) {
                            String out = "Something Went Wrong, Please Try Again.\n\nPlease make sure that you have not entered any text in the Price field or left it blank.";
                            display.setText(out);
                            display.setEditable(false);
                        }
                        iter--;
                    }
                });
                update.add(actionpanel);
                update.add(msgpanel);
                update.setVisible(true);

                // Disposing the Panels
                home.dispose();
                buy.dispose();
                sell.dispose();
            }
        });

        op6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });

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
