/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class Query {
     public static ResultSet ConsultaSQL(String consulta) throws SQLException{
        Connection conn = ConnectPostgreSQL.getInstance().getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(consulta);
            return rst;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " +e.getMessage()
                    ,"Error de Conexión",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
