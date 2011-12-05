package dbtransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamid
 */
public abstract  class CreateConnection {
    PreparedStatement ps;
    Statement sm;
    Connection conn;

    public CreateConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        conn = 
                DriverManager.getConnection("jdbc:sqlite:drugs.db");
        sm =
                conn.createStatement();
    }
}
