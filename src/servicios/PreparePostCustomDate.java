/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Controlador.ControladorPeticionesHTTP;
import Frames.ventana;
import Frames.ventanaCustomDate;
import Utils.PrepareJSON;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author Jorge Gonzalez
 */
public class PreparePostCustomDate {
     PrepareJSON utilJson = new PrepareJSON();
    public String sendJson(JSONObject json){ 
        String responseJson = null;  
        StringEntity requestEntity = new StringEntity( json.toString(),
                                                        ContentType.APPLICATION_JSON);   
        HttpPost httpPost = new HttpPost("https://tciconsultoria.com.mx/app/Services/importEmcor.php");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(requestEntity);
      
        HttpClient httpClient = HttpClients.createDefault();
        try { 
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if(statusCode == 200){
                HttpEntity entidad = httpResponse.getEntity();
                responseJson = EntityUtils.toString(entidad);
                System.out.println(responseJson);
                peticiones(responseJson);
            }else{
                HttpEntity entidad = httpResponse.getEntity();
                responseJson = EntityUtils.toString(entidad);
                mostrarEstatusPeticiones("error");
                System.out.println("Error status code: "+statusCode);
            } 
        } catch (IOException ex) {
            mostrarEstatusPeticiones("error");
            Logger.getLogger(PreparePost.class.getName()).log(Level.SEVERE, null, ex);
        }
       return responseJson;
    }
    
    void peticiones(String responseJson){
        String reponse = utilJson.response(responseJson);
        if("No error".equals(reponse)){
            mostrarEstatusPeticiones("ok");
        }else{
            mostrarEstatusPeticiones("error");
            System.out.println(responseJson);
        }
        
    }
    
    void mostrarEstatusPeticiones(String status){
        String texto = "";
        if("ok".equals(status)){
            texto = "<html><body>Registros enviados correctamente.<br></body></html>";
        }else if("error".equals(status)){
            texto = "<html><body>Ha ocurrido un error!<br></body></html>";   
        }
        
        ventanaCustomDate.lblLeyenda.setText(texto);
        ventanaCustomDate.jpbEnvio.setVisible(ventana.enableBtn);
        ventanaCustomDate.btnEnviar.setEnabled(!ventana.enableBtn);
        ventanaCustomDate.lblLeyenda.setVisible(!ventana.enableBtn);        
    }
}
