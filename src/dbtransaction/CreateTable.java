package dbtransaction;

import java.sql.SQLException;

/**
 *
 * @author hamid
 */
public class CreateTable extends CreateConnection {
    public CreateTable() throws SQLException{
        super();
    }
    public void createTbl() throws SQLException{
        sm.executeUpdate("CREATE TABLE DRUGS("
                + "ID INTEGER PRIMARY KEY,"
                + "NAME TEXT,"
                + "CATEGORY TEXT,"
                + "TOTAL INTEGER)");
    }
    
    
}
