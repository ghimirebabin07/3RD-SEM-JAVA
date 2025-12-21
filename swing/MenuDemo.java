import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu color;
    JMenuItem red, green, blue;

    MenuDemo() {

        // Create MenuBar
        mb = new JMenuBar();

        // Create Menu
        color = new JMenu("Color");
        color.setToolTipText("Select a color to change background");

        // Create MenuItems
        red = new JMenuItem("Red");
        green = new JMenuItem("Green");
        blue = new JMenuItem("Blue");

        // ✅ Tooltip text for menu items
        red.setToolTipText("Change background to RED");
        green.setToolTipText("Change background to GREEN");
        blue.setToolTipText("Change background to BLUE");

        // Add ActionListener to menu items (fixed spelling)
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);

        // Add items to menu
        color.add(red);
        color.add(green);
        color.add(blue);

        // Add menu to menubar
        mb.add(color);

        // Set menubar to frame
        setJMenuBar(mb);

        // Frame settings
        setSize(400, 400);
        setTitle("Menu Demo with Tooltip");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Action performed method
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == red) {
            getContentPane().setBackground(Color.RED);
        } 
        else if (e.getSource() == green) {
            getContentPane().setBackground(Color.GREEN);
        } 
        else if (e.getSource() == blue) {
            getContentPane().setBackground(Color.BLUE);
        }
    }

    // Main method
    public static void main(String[] args) {
        new MenuDemo();
    }
}
