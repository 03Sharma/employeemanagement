package Employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;
    public static Connection createDBConnection()  {

        // try catch block for exception handling
        try {
            // load the driver class
            Class.forName("com.mysql.jdbc.Driver");

            // get the connection
            String url="jdbc:mysql://localhost:3306/employeeDB";
            String username="root";
            String password="root";

            // DriverManager attempts to establish a connection to the specified database URL.
            con = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            // Catch Exception
            e.printStackTrace();
        }

        // Return the established connection. If an exception occurred, 'con' will be null.
        return con;
    }
}
