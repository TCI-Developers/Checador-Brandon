package Enums;

/**
 *
 * @author Jorge Gonzalez
 */
public enum PostgresEnum {
    BONANZA("postgres",
            "Bon4nz4*20",
            "7496",
            "biotime",
            "localhost"),
    TCI("postgres",
            "qwertyuiop10",
            "7496",
            "biotime",
            "localhost"),
    /*SVFRESH("postgres",
            "qwertyuiop10",
            "7496",
            "biotime",
            "localhost");*/
    SVFRESH("postgres",
            "root",
            "5432",
            "BioTime",
            "localhost"),
    
    MONAR("postgres",
            "biotime123456",
            "7496",
            "biotime",
            "localhost"
    ),
    BRANDON("postgres",
            "Tci-2023$",
            "7496",
            "biotime",
            "localhost"
    );
    
    private final String usuario;
    private final String contrasena;
    private final String puerto;
    private final String nombreBD;
    private final String host;
    private final String url;

    private PostgresEnum(String usuario,String contrasena,String puerto,String nombreBD,String host){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.puerto = puerto;
        this.nombreBD = nombreBD;
        this.host = host;
        this.url = host+":"+puerto+"/"+nombreBD;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
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

    public String getUrl() {
        return url;
    }

}
