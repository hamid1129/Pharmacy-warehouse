package dbtransaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamid
 */
public class RetrieveCount extends CreateConnection {

    public RetrieveCount() throws SQLException {
        super();
    }

    public int getDrugCount(String name) {
        int count = 0;
        
        try {
            ResultSet rs = sm.executeQuery("SELECT TOTAL FROM DRUGS WHERE "
                    + "NAME= \""
                    +name
                    +"\" ;");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(RetrieveCount.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return 0;
    }
    public String getAllRowCount() throws SQLException{
        ResultSet rs = sm.executeQuery("SELECT COUNT(*) FROM DRUGS");
        int count=0;
        while (rs.next()){
            count = rs.getInt(1);
        }
      //  sm.close();
      //  conn.close();
        System.out.println("All count ="+count);
        return String.format("%d", count);
        
        
    }
}
