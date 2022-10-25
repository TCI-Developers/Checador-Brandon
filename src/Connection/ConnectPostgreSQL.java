
package Connection;

import Enums.PostgresEnum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author jorge
 */
public class ConnectPostgreSQL {
    private static ConnectPostgreSQL instance;
    private Connection connection;
    PostgresEnum postgres = PostgresEnum.SVFRESH;
   public ConnectPostgreSQL(){
       try {
           this.connection = DriverManager.getConnection("jdbc:postgresql://"+postgres.getUrl(),postgres.getUsuario(), postgres.getContrasena());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
            e.printStackTrace();
        }   
   }
    
    
   public Connection getConnection(){
      return connection;
   }
   
   public static ConnectPostgreSQL getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectPostgreSQL();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectPostgreSQL();
        }
        return instance;
    }  
}
