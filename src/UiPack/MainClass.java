package UiPack;

import dbtransaction.CreateTable;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author hamid
 */
public class MainClass {

    CreateTable cr;

    public MainClass() throws SQLException {
        File db = new File("drugs.db");
        if (db.exists()) {
            System.out.println("Perfect !!");
        } else {
            cr = new CreateTable();
            cr.createTbl();
        }
    }

    public static void main(String args[]) throws SQLException {
        MainClass m = new MainClass();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
