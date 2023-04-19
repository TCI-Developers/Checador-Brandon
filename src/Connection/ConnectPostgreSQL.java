package Connection;

import Enums.PostgresEnum;
import Modelos.ModeloBase;
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
    PostgresEnum postgres = PostgresEnum.MONAR;
    //
    
    
    public ConnectPostgreSQL(ModeloBase myModel){
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://"+myModel.getUrl(),myModel.getUsuario(), myModel.getContrasena());
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
             System.exit(0);
             e.printStackTrace();
         }
    }
    
    
   public Connection getConnection(){
      return connection;
   }
   
   public static ConnectPostgreSQL getInstance(ModeloBase myModel) throws SQLException {
        if (instance == null) {
            instance = new ConnectPostgreSQL(myModel);
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectPostgreSQL(myModel);
        }
        return instance;
    }  
}
