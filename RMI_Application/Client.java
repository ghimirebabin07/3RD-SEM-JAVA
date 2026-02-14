package RMI_Application;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            Adder adder = (Adder) Naming.lookup("rmi://localhost/AdderService");
            int result = adder.add(10, 20);

            System.out.println("Result from server: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while communicating with the RMI server.");
        }
    }
}
