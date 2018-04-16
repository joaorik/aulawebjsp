package org.aulaweb.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author john
 */
public class MySqlConnect {

    public static Connection conn = null;
    
    public static Connection ConnectTo() {
        
        if (conn != null) {
            return conn;
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Mysql Driver Loaded...");
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/aula_web", "root", "mysql");
                System.out.println("Connection OK!");;
            } catch (SQLException e) {
                System.out.println("Database error connection: ");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Class not found error: ");
                ex.printStackTrace();
            }
        }
        return conn;
    }
}
