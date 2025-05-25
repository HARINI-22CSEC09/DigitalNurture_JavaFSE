package myapp;

import java.sql.*;

public class JDBCTransaction {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/registerdb";
        String user = "root";
        String password = "Hari14#10!";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);

            String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

                debitStmt.setDouble(1, 100);
                debitStmt.setInt(2, 1);
                debitStmt.executeUpdate();

                creditStmt.setDouble(1, 100);
                creditStmt.setInt(2, 2);
                creditStmt.executeUpdate();

                conn.commit();
                System.out.println("Transaction successful.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction failed, rolled back.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

