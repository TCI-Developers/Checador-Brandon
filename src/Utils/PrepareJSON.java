/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Enums.AplicationEnum;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author jorge
 */
public class PrepareJSON {
    AplicationEnum aplication = AplicationEnum.SVFRESH;
    public JSONObject encodeJson(ArrayList<String> args,String... mergeId){
        JSONObject jsondata = new JSONObject();
        JSONObject json = new JSONObject();
            json.put("subdominio", "aortizdemontellanoarevalo");
            json.put("dbid", aplication.getChecadorBD() );
            json.put("userToken", aplication.getUserToken());
            json.put("appToken", aplication.getAppToken());
            json.put("values", args);
            json.put("clist", aplication.getClist() );
            json.put("mergeId", mergeId );
            json.put("skipfirst", false);
            jsondata.put("data", json);
        return jsondata;
    }
    
    public String response(String response){
        JSONObject convertedObject = new JSONObject(response);
        return convertedObject.getString("errtext");
    }
}
