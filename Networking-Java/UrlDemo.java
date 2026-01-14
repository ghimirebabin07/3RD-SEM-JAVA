import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;

public class UrlDemo {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;

        try {
            // Create UDP socket on port 9999
            serverSocket = new DatagramSocket(9999);
            System.out.println("UDP Server is running...");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Receive message from client
            serverSocket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message from client: " + message);
            System.out.println("Client address: " + packet.getAddress());

        } catch (IOException e) {
            System.out.println("Error in UDP Server:");
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                System.out.println("Server socket closed");
            }
        }
    }
}
