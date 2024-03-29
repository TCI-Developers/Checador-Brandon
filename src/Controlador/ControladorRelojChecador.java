/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Utils.PrepareJSON;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author jorge
 */
public class ControladorRelojChecador {
    PrepareJSON prepareJson = new PrepareJSON();
    public static ArrayList<String> argsChecadas = new ArrayList<>();
    
    public JSONObject getChecadas(String fecha) {
        //System.out.println(fecha);
        argsChecadas = new ArrayList<>();   //now()     CURRENT_DATE
        try {
            ResultSet resultSet = Connection.Query.ConsultaSQL(fecha);
            while(resultSet.next()){
              agregarRegistro(resultSet);  
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorRelojChecador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prepareJson.encodeJson(argsChecadas,"7");//bonanza mergeId: 174 - TCI mergeId: 7
    }
    
     public void agregarRegistro(ResultSet resultSet) throws SQLException{
        String fecha = resultSet.getString("fecha");
//        argsChecadas.add( resultSet.getString("emp_code")+","+ resultSet.getString("fecha")+","+ resultSet.getString("mergeid")+",1");
        argsChecadas.add( resultSet.getString("emp_code")+","+ resultSet.getString("fecha")+","+ resultSet.getString("mergeid")+",1,"+resultSet.getString("detail_cheq"));
        //8.6.7.9
    }
}
