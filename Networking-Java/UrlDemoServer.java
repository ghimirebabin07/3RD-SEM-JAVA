import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UrlDemoServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("TCP Server is running on port 9999...");

            clientSocket = serverSocket.accept(); // Wait for client
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Read from client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("Message from client: " + clientMessage);

            // Reply to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hi");  // server reply
            System.out.println("Replied to client with 'Hi'");

        } catch (IOException e) {
            System.out.println("Error in TCP Server:");
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
                System.out.println("Server and client sockets closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
