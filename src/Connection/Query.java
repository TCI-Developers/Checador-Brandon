/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Enums.PostgresEnum;
import Enums.SQLServerEnum;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Modelos.ModeloBase;

/**
 *
 * @author jorge
 */
public class Query {
    
    
    public static ResultSet ConsultaSQL(String fecha) throws SQLException{
        //llega el modelo 
        //ModeloBase myModel2 = new ModeloBase(SQLServerEnum.SVFRESH);
        ModeloBase myModel = new ModeloBase(SQLServerEnum.SVFRESH);
        myModel.setFecha(fecha);
        Connection conn = myModel.getConexion();
        try {
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(myModel.getQuery());
            return rst;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " +e.getMessage()
                    ,"Error de Conexión",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
