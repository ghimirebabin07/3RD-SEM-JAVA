import javax.swing.*;
import java.awt.*;

public class PanelDemo extends JFrame {

    // Declare text fields
    JTextField nameField1, ageField1;
    JTextField nameField2, ageField2;

    PanelDemo() {

        // Frame layout
        setLayout(new GridLayout(2, 1, 10, 10)); // 2 rows, 1 column, 10px gap

        // ---------------- Panel 1 ----------------
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.CYAN);
        panel1.setLayout(new FlowLayout());

        // Create text fields for panel1
        nameField1 = new JTextField(20);
        ageField1 = new JTextField(20);

        // Add tooltips
        nameField1.setToolTipText("Enter your name");
        ageField1.setToolTipText("Enter your age");

        // Add text fields to panel1
        panel1.add(new JLabel("Name:"));
        panel1.add(nameField1);
        panel1.add(new JLabel("Age:"));
        panel1.add(ageField1);

        // ---------------- Panel 2 ----------------
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.PINK);
        panel2.setLayout(new FlowLayout());

        // Create text fields for panel2
        nameField2 = new JTextField(20);
        ageField2 = new JTextField(20);

        // Add tooltips
        nameField2.setToolTipText("Enter your friend's name");
        ageField2.setToolTipText("Enter your friend's age");

        // Add text fields to panel2
        panel2.add(new JLabel("Friend Name:"));
        panel2.add(nameField2);
        panel2.add(new JLabel("Friend Age:"));
        panel2.add(ageField2);

        // Add panels to frame
        add(panel1);
        add(panel2);

        // Frame settings
        setTitle("Two Panel Demo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PanelDemo();
    }
}
