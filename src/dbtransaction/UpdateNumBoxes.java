package dbtransaction;

import java.sql.SQLException;

/**
 *
 * @author hamid
 */
public class UpdateNumBoxes extends CreateConnection {
    private int totalNumber;
    private int reqNumber;
    private int currentNumber;
    
    private String colName;
    
    public UpdateNumBoxes() throws SQLException{
        super();
    }
    public void SetNewCount(String colName, int totalNumber, int reqNumber){
        this.totalNumber = totalNumber;
        this.reqNumber = reqNumber;
        
        this.colName = colName;
        
        this.currentNumber = this.totalNumber - this.reqNumber;
    }
    public void UpdateRow() throws SQLException{
        ps = conn.prepareStatement("UPDATE DRUGS "
                + "SET TOTAL = ? "
                + "WHERE NAME = ? ;");
        ps.setInt(1, this.currentNumber);
        ps.setString(2, this.colName);
       
        ps.addBatch();
        ps.executeBatch();
        ps.close();
        conn.close();
        
        //******************************************
        System.out.println("total = "+totalNumber);
        System.out.println("request = "+reqNumber);
        System.out.println("Curr = "+currentNumber);
        System.out.println(colName);
        
        System.out.println("inja kam mikone :(");
    }
    
    
}
