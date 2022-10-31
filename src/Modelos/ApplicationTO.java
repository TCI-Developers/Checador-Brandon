package Modelos;

import Enums.AplicationEnum;

/**
 *
 * @author Cristian Mondragón
 */
public class ApplicationTO {
    
    private final String userToken;
    private final String appToken;
    private final String checadorBD;
    private final String clist;
    
    public ApplicationTO(){
        
        AplicationEnum enum1 = AplicationEnum.BONANZA;
        this.userToken = enum1.getUserToken();
        this.appToken = enum1.getAppToken();
        this.checadorBD = enum1.getChecadorBD();
        this.clist = enum1.getClist();           
    }

    public String getUserToken() {
        return userToken;
    }

    public String getAppToken() {
        return appToken;
    }

    public String getChecadorBD() {
        return checadorBD;
    }

    public String getClist() {
        return clist;
    }
    
    
}
