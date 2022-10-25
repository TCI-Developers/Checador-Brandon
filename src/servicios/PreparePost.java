/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Controlador.ControladorPeticionesHTTP;
import Frames.ventana;
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
public class PreparePost {
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
            texto = "<html><body>Registros enviados!<br><br></body></html>";
        }else if("error".equals(status)){
            texto = "<html><body>Ha ocurrido un error!<br><br></body></html>";   
        }
        
        ventana.lblLeyenda.setText(texto);
        ventana.enableBtn = !ventana.enableBtn;
        ventana.jpbEnvio.setVisible(!ventana.enableBtn);
        ventana.btnEnviar.setEnabled(ventana.enableBtn);
        ventana.lblLeyenda.setVisible(ventana.enableBtn);

        try {    
             Thread.sleep(3000);
             System.exit(0);
        } catch (InterruptedException ex) {
             Logger.getLogger(ControladorPeticionesHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
