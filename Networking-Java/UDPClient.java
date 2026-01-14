import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        byte[] buf = new byte[1];
        ds.send(new DatagramPacket(buf, buf.length, ip, 5000));

        DatagramPacket dp = new DatagramPacket(buf = new byte[100], 100);
        ds.receive(dp);
        System.out.println("Server: " +
                new String(dp.getData(), 0, dp.getLength()));

        buf = "Hi".getBytes();
        ds.send(new DatagramPacket(buf, buf.length, ip, 5000));

        ds.close();
    }
}
