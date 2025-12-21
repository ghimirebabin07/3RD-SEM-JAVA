import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGame extends JFrame implements ActionListener {

    private JTextField guessField;
    private JLabel messageLabel, attemptLabel;
    private JButton guessButton, resetButton;

    private int randomNumber;
    private int attempts = 0;

    public NumberGuessingGame() {

        setTitle("Number Guessing Game");
        setSize(400, 250);
        setLayout(new GridLayout(5, 1, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;

        JLabel title = new JLabel("Guess a number between 1 and 100", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        guessField = new JTextField();
        guessField.setHorizontalAlignment(JTextField.CENTER);

        guessButton = new JButton("Guess");
        resetButton = new JButton("Reset Game");

        messageLabel = new JLabel("Enter your guess", JLabel.CENTER);
        attemptLabel = new JLabel("Attempts: 0", JLabel.CENTER);

        guessButton.addActionListener(this);
        resetButton.addActionListener(this);

        add(title);
        add(guessField);
        add(guessButton);
        add(messageLabel);
        add(attemptLabel);
        add(resetButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == guessButton) {
            try {
                int guess = Integer.parseInt(guessField.getText());
                attempts++;

                if (guess > randomNumber) {
                    messageLabel.setText("Too High!");
                } else if (guess < randomNumber) {
                    messageLabel.setText("Too Low!");
                } else {
                    messageLabel.setText("Correct! You guessed it 🎉");
                    guessButton.setEnabled(false);
                }

                attemptLabel.setText("Attempts: " + attempts);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number!");
            }
        }

        if (e.getSource() == resetButton) {
            Random rand = new Random();
            randomNumber = rand.nextInt(100) + 1;
            attempts = 0;
            guessField.setText("");
            messageLabel.setText("Game reset. Try again!");
            attemptLabel.setText("Attempts: 0");
            guessButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
