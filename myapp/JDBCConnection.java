package myapp;
import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/registerdb";
        String user = "root";
        String password = "Hari14#10!";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, rollno FROM demo")) {

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                                   ", Roll No: " + rs.getInt("rollno"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
