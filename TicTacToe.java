import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    JButton[][] buttons = new JButton[3][3];
    boolean playerX = true; // true = X, false = O
    JLabel statusLabel;
    JButton restartButton;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Status Label
        statusLabel = new JLabel("Player X's Turn", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(statusLabel, BorderLayout.NORTH);

        // Game Panel
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        gamePanel.setBackground(Color.BLACK);

        Font btnFont = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(btnFont);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                gamePanel.add(buttons[i][j]);
            }
        }

        add(gamePanel, BorderLayout.CENTER);

        // Restart Button
        restartButton = new JButton("Restart Game");
        restartButton.setFont(new Font("Arial", Font.BOLD, 16));
        restartButton.addActionListener(e -> resetGame());
        add(restartButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.getText().equals("")) {
            return;
        }

        if (playerX) {
            clickedButton.setText("X");
            clickedButton.setForeground(Color.BLUE);
            statusLabel.setText("Player O's Turn");
        } else {
            clickedButton.setText("O");
            clickedButton.setForeground(Color.RED);
            statusLabel.setText("Player X's Turn");
        }

        if (checkWinner()) {
            statusLabel.setText("Player " + (playerX ? "X" : "O") + " Wins!");
            disableButtons();
            return;
        }

        if (isDraw()) {
            statusLabel.setText("It's a Draw!");
            return;
        }

        playerX = !playerX;
    }

    private boolean checkWinner() {
        String[][] board = new String[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = buttons[i][j].getText();

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals("") &&
                board[i][0].equals(board[i][1]) &&
                board[i][1].equals(board[i][2]))
                return true;

            if (!board[0][i].equals("") &&
                board[0][i].equals(board[1][i]) &&
                board[1][i].equals(board[2][i]))
                return true;
        }

        // Diagonals
        if (!board[0][0].equals("") &&
            board[0][0].equals(board[1][1]) &&
            board[1][1].equals(board[2][2]))
            return true;

        if (!board[0][2].equals("") &&
            board[0][2].equals(board[1][1]) &&
            board[1][1].equals(board[2][0]))
            return true;

        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (buttons[i][j].getText().equals(""))
                    return false;
        return true;
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setEnabled(false);
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }

        playerX = true;
        statusLabel.setText("Player X's Turn");
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
