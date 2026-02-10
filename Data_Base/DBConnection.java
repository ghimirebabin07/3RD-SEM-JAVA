package Data_Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.Console;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Console console = System.console();

            if (console == null) {
                System.out.println("Run this program from TERMINAL, not IDE Run button");
                return null;
            }

            char[] passwordArray = console.readPassword("Enter PostgreSQL Password: ");
            String password = new String(passwordArray);

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/authdb",
                "postgres",   // DB username
                password      // password from terminal
            );

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }

        return con;
    }
}
