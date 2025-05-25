package myapp;

import java.sql.*;

public class JDBCInsertUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/registerdb";
        String user = "root";
        String password = "Hari14#10!";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String insertQuery = "INSERT INTO demo(name,rollno) VALUES (?, ?)";
            PreparedStatement pstmtInsert = conn.prepareStatement(insertQuery);
            pstmtInsert.setInt(1, 1);
            pstmtInsert.setString(2, "Ria");
            pstmtInsert.executeUpdate();

            String updateQuery = "UPDATE students SET name = ? WHERE id = ?";
            PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery);
            pstmtUpdate.setString(1, "Banu");
            pstmtUpdate.setInt(2, 1);
            pstmtUpdate.executeUpdate();

            System.out.println("Insert and update successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
