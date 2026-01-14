import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPserver  {
    public static void main (String args[]) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] b = new byte[100];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);
        String msg = "Hello client";
        b = msg.getBytes();
        ds.send(new DatagramPacket(b, b.length,dp.getAddress(), dp.getPort()));
        ds.receive(dp);
        System.out.println("Client"+ new String(dp.getData(),0,dp.getLength()));
        ds.close();
        

        
    }
    
}
