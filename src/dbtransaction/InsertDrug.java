package dbtransaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamid
 */
public class InsertDrug extends CreateConnection {    
    public InsertDrug() throws SQLException {
        super();
    }
    
    public void InsertToTable(String name, String category, int total) {
        try {
            ps = conn.prepareStatement("INSERT INTO DRUGS "
                    + "VALUES (?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setInt(4, total);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(InsertDrug.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    public List retrieveNamesFromTable() {
        List list = new ArrayList<String>();
        try {    
            ResultSet rs = sm.executeQuery("SELECT NAME FROM DRUGS");
            while (rs.next()) {
                list.add(rs.getString("name"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(InsertDrug.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            return list;    
        }
    }
}
