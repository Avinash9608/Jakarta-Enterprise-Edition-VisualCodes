//package jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUpdatebleRes_PrintUpdatedBookName {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//AvinashKumar:1521/XE", "advjavabatch5", "mystudents");
            System.out.println("Connection opened to the DB successfully!");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT subject, bookprice, bookname FROM allbooks");
            List<String> result = new ArrayList<>();
            while (rs.next()) {
                String sub = rs.getString(1);
                if (sub.equalsIgnoreCase("jee")) {
                    double amt = rs.getDouble(2);
                    amt = amt + amt * 0.1; // Increasing price by 10%
                    rs.updateDouble(2, amt);
                    rs.updateRow();
                    result.add(rs.getString(3)); // Add updated book name to the list
                }
            }
            // Print the names of the updated books
            for (String name : result) {
                System.out.println(name);
            }
            System.out.println("Total books updated: " + result.size());
        } catch (ClassNotFoundException cnf) {
            System.out.println("Cannot load the driver class: " + cnf.getMessage());
        } catch (SQLException sqlex) {
            System.out.println("Problem in DB: " + sqlex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection closed successfully!");
                }
            } catch (SQLException sqlex) {
                System.out.println("Problem in closing the connection: " + sqlex.getMessage());
            }
        }
    }
}
