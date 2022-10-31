/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Jorge Gonzalez
 */
public enum AplicationEnum {
    BONANZA("b4czaq_fwjc_c5bv4udcqnm4rsz2e5qi57natn",
            "cec8r5jcmprg7ub66qzhubg5xa6j",
            "bpiwix5wh",
            "21.6.174.177"),
    TCI("b4czat_fwjc_bsp8s76cidmnnuvykcmfw7rvbe",
            "ctfa892b5a2z44djur52jsjuj99",
            "bsggzfx2b",
            "8.6.7.9.17"),
    SVFRESH("b7tgyp_fwjc_0_c87veyjbug2j87cphcn3hcbdm4n2",
            "ccrx3accvncnkmbksgqkwbms3u38",
            "bsqfr8zg2",
            "30.6.7.9.31");
            //"30.6.7.9.31"
    private final String userToken;
    private final String appToken;
    private final String checadorBD;
    private final String clist;
        
    private AplicationEnum(String userToken,String appToken,String checadorBD,String clist){
        this.userToken = userToken;
        this.appToken = appToken;
        this.checadorBD = checadorBD;
        this.clist = clist;
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
