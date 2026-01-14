import java.io.*;
import java.net.*;

public class TicTacToeServer {
    private static final int PORT = 9999;
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public TicTacToeServer() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    private void printBoard(PrintWriter out1, PrintWriter out2) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < 3; i++) {
            sb.append(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + "\n");
            if (i < 2) sb.append("---+---+---\n");
        }
        out1.println(sb.toString());
        out2.println(sb.toString());
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer) return true;
            if (board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer) return true;
        }
        if (board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer) return true;
        if (board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer) return true;
        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server running on port " + PORT);
            System.out.println("Waiting for 2 players...");

            Socket player1 = serverSocket.accept();
            PrintWriter out1 = new PrintWriter(player1.getOutputStream(), true);
            BufferedReader in1 = new BufferedReader(new InputStreamReader(player1.getInputStream()));
            out1.println("WELCOME Player 1 (X)");

            Socket player2 = serverSocket.accept();
            PrintWriter out2 = new PrintWriter(player2.getOutputStream(), true);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(player2.getInputStream()));
            out2.println("WELCOME Player 2 (O)");

            out1.println("Both players connected. Game starts!");
            out2.println("Both players connected. Game starts!");
            printBoard(out1, out2);

            boolean running = true;
            while (running) {
                PrintWriter currentOut = (currentPlayer=='X')?out1:out2;
                BufferedReader currentIn = (currentPlayer=='X')?in1:in2;

                currentOut.println("Your move (row col):");
                String input = currentIn.readLine();
                if (input == null) break;

                String[] parts = input.split(" ");
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                if (row<0 || row>2 || col<0 || col>2 || board[row][col]!=' ') {
                    currentOut.println("Invalid move, try again.");
                    continue;
                }

                board[row][col] = currentPlayer;
                printBoard(out1, out2);

                if (checkWin()) {
                    out1.println("Player " + currentPlayer + " wins!");
                    out2.println("Player " + currentPlayer + " wins!");
                    running = false;
                } else if (isDraw()) {
                    out1.println("Game Draw!");
                    out2.println("Game Draw!");
                    running = false;
                } else {
                    currentPlayer = (currentPlayer=='X')?'O':'X';
                }
            }

            player1.close();
            player2.close();
            System.out.println("Game over. Server closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TicTacToeServer().start();
    }
}
