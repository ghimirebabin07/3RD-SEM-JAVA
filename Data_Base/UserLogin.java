package Data_Base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            System.out.print("Enter Email: ");
            String email = br.readLine();

            System.out.print("Enter Password: ");
            String password = br.readLine();

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + rs.getString("name"));
            } else {
                System.out.println("Invalid credentials");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
