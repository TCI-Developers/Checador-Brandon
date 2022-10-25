/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Frames.ventanaCustomDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import servicios.PreparePostCustomDate;

/**
 *
 * @author Jorge Gonzalez
 */
public class ControladorPeticionesCustomDateHTTP {
    ControladorRelojChecador ctrlChecador = new ControladorRelojChecador();
    JSONObject jsonChecadas;
    
    PreparePostCustomDate preparePost = new PreparePostCustomDate();
     
    public void enviarInformacion(){
        
         try {    
//            System.out.println("Termino");
            Thread.sleep(500);
            preparePost.sendJson(jsonChecadas);
        } catch (InterruptedException ex) {
             Logger.getLogger(ControladorPeticionesHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void cargarRegitros(String fecha){
        jsonChecadas = ctrlChecador.getChecadas(fecha);
        System.out.println(jsonChecadas);       
        habilitarComponentes();
        
//        try {    
//            System.out.println("Termino");
//             Thread.sleep(500);
//             enviarInformacion();
//        } catch (InterruptedException ex) {
//             Logger.getLogger(ControladorPeticionesHTTP.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
     public void habilitarComponentes(){
        if(ControladorRelojChecador.argsChecadas.isEmpty()){
            ventanaCustomDate.lblLeyenda.setText("No hay registros por enviar");
            ventanaCustomDate.btnEnviar.setEnabled(ventanaCustomDate.enableBtn);
        }else{
            ventanaCustomDate.lblLeyenda.setText("Registros listos para envio.");
            ventanaCustomDate.btnEnviar.setEnabled(!ventanaCustomDate.enableBtn);
        }
        
        ventanaCustomDate.jpbEnvio.setVisible(ventanaCustomDate.enableBtn);
        ventanaCustomDate.lblLeyenda.setVisible(!ventanaCustomDate.enableBtn);
        
    }
     
   
}
