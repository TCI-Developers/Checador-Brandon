package Enums;

/**
 *
 * @author Cristian Mondragón
 */
public enum SQLServerEnum {
    SVFRESH("BioTime",
    "B10T1m3#2022*",
    "1433",
    "BioTime",
    "CONTABILIDAD\\BIOTIME"),
    
    SVFRESHTEST("sa",
    "root",
    "1433",
    "BioTime",
    "localhost");
    
    private final String usuario;
    private final String contrasena;
    private final String puerto;
    private final String nombreBD;
    private final String host;
    private final String url;

    
    private SQLServerEnum(String usuario,String contrasena,String puerto,String nombreBD,String host){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.puerto = puerto;
        this.nombreBD = nombreBD;
        this.host = host;
        this.url = host+":"+puerto+"/"+nombreBD;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public String getPuerto(){
        return puerto;
    }
    
    public String getNombreBD(){
        return nombreBD;
    }
    
    public String getHost(){
        return host;
    }
    
    public String getUrl(){
        return url;
    }
}
