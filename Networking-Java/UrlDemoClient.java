import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UrlDemoClient {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 9999);
            System.out.println("Connected to TCP Server");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello");
            System.out.println("Sent 'Hello' to server");

            // Receive reply from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = in.readLine();
            System.out.println("Server replied: " + serverMessage);

        } catch (IOException e) {
            System.out.println("Error in TCP Client:");
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                System.out.println("Client socket closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
