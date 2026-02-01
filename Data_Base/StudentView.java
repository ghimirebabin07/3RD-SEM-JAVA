package Data_Base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentView {

    public static void main(String[] args) {

        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            System.out.println("ID | Name | Roll | Semester | Faculty | Program");
            System.out.println("------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("student_id") + " | " +
                    rs.getString("student_name") + " | " +
                    rs.getInt("roll_no") + " | " +
                    rs.getInt("semester") + " | " +
                    rs.getString("faculty") + " | " +
                    rs.getString("program")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
