package Modelos;

import Connection.ConnectPostgreSQL;
import Connection.ConnectSQLServer;
import Enums.PostgresEnum;
import Enums.SQLServerEnum;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Cristian Mondragón
 */
public class ModeloBase {
    
    private final String usuario;
    private final String contrasena;
    private final String puerto;
    private final String nombreBD;
    private final String host;
    private final String url;
    private String fecha;
    private Object obj;
    public static Connection conexion;
   
    
    public ModeloBase(PostgresEnum myEnum) throws SQLException {
        this.usuario = myEnum.getUsuario();
        this.contrasena = myEnum.getContrasena();
        this.puerto = myEnum.getPuerto();
        this.nombreBD = myEnum.getNombreBD();
        this.host = myEnum.getHost();
        this.url = myEnum.getUrl();
        this.conexion = ConnectPostgreSQL.getInstance(this).getConnection();
        this.obj = myEnum;
    }
    
    public ModeloBase(SQLServerEnum myEnum) throws SQLException{
        this.usuario = myEnum.getUsuario();
        this.contrasena = myEnum.getContrasena();
        this.puerto = myEnum.getPuerto();
        this.nombreBD = myEnum.getNombreBD();
        this.host = myEnum.getHost();
        this.url = myEnum.getUrl();
        this.conexion = ConnectSQLServer.getInstance(this).getConnection();
        this.obj = myEnum;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getPuerto() {
        return puerto;
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public String getHost() {
        return host;
    }

    public String getUrl() {
        return url;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setFecha(String fecha){
       this.fecha = fecha;
    }
    
    public String getQuery(){
        if(this.obj instanceof PostgresEnum){
            //si el objeto es una instancia de Postgres
            return "SELECT emp_code,to_char(punch_time,'DD-MM-YYYY HH24:MI:SS') as fecha,concat(extract(year from punch_time),extract(week from punch_time),'-',emp_code) as detail_cheq,concat(id,'-',emp_code) as mergeid" +
            " FROM iclock_transaction" +
            " where punch_time >= date('"+fecha+" 00:00:00') -1;";
        }
        else{
            return "SELECT emp_code,\n" +
            "punch_time AS fecha,\n" +
            "CONCAT(DATEPART(yy,punch_time), DATEPART(ww, punch_time)-1,'-',emp_code) AS detail_cheq,\n" +
            "CONCAT(id,'-',emp_code) as mergeid\n" +
            "FROM iclock_transaction\n" +
            "WHERE DATEDIFF(DAY, punch_time, '"+fecha+"')=0 OR DATEDIFF(DAY, punch_time, DATEADD(DAY, -1, '"+fecha+"'))=0;";
            
            //SELECT person.emp_code,
            //		person.id,
            //punch_time AS fecha,
            //CONCAT(DATEPART(yy,punch_time), DATEPART(ww, punch_time)-1,'-',person.emp_code) AS detail_cheq,
            //CONCAT(t.id,'-',person.emp_code) as mergeid
            //FROM iclock_transaction t
            //		INNER JOIN personnel_employee person ON person.id =  t.emp_code
            //WHERE DATEDIFF(DAY, punch_time, '2022-12-27')=0 OR DATEDIFF(DAY, punch_time, DATEADD(DAY, -1, '2022-12-27'))=0;
        }
    }
       
}
