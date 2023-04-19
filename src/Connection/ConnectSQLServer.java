package Connection;

import Enums.SQLServerEnum;
import Modelos.ModeloBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Mondragón
 */
public class ConnectSQLServer {
    
    private static ConnectSQLServer instance;
    private Connection connection;
    //SQLServerEnum sqlserver = SQLServerEnum.SVFRESH;
    //
    
    
    public ConnectSQLServer(ModeloBase myModel){
        String ConexionUrl = "jdbc:sqlserver://"+myModel.getHost()+":"+myModel.getPuerto()+";"
                + "database="+myModel.getNombreBD()+";"
                + "user="+myModel.getUsuario()+";"
                + "password="+myModel.getContrasena()+";"
                + "loginTimeout=30;";
        try {
           this.connection = DriverManager.getConnection(ConexionUrl);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
            e.printStackTrace();
        }  
    }
    
    public Connection getConnection(){
        return connection;
    }
        
    public static ConnectSQLServer getInstance(ModeloBase myModel) throws SQLException {
        if (instance == null) {
            instance = new ConnectSQLServer(myModel);
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectSQLServer(myModel);
        }
        return instance;
    }
}
