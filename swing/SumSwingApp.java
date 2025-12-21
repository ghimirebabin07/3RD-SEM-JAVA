import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumSwingApp extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton btn;

    public SumSwingApp() {

        setTitle("Sum of Two Numbers");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");
        JLabel l3 = new JLabel("Result:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t3.setEditable(false);

        btn = new JButton("Add");
        btn.addActionListener(this);

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(new JLabel());
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int num1 = Integer.parseInt(t1.getText());
        int num2 = Integer.parseInt(t2.getText());
        int sum = num1 + num2;
        t3.setText(String.valueOf(sum));
    }

    public static void main(String[] args) {
        new SumSwingApp();
    }
}
