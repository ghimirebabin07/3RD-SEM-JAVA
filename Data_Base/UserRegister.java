package Data_Base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegister {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            System.out.print("Enter Name: ");
            String name = br.readLine();

            System.out.print("Enter Email: ");
            String email = br.readLine();

            System.out.print("Enter Password: ");
            String password = br.readLine();

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("User Registered Successfully!");
            } else {
                System.out.println("Registration Failed");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
