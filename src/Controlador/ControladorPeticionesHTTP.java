/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Frames.ventana;
import Frames.ventanaCustomDate;
import Utils.Fecha;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import servicios.PreparePost;

/**
 *
 * @author jorge
 */
public class ControladorPeticionesHTTP {
    ControladorRelojChecador ctrlChecador = new ControladorRelojChecador();
    JSONObject jsonChecadas;
    
    PreparePost preparePost = new PreparePost();
     
    public void enviarInformacion(){
        ventana.enableBtn = !ventana.enableBtn;
        ventana.jpbEnvio.setVisible(!ventana.enableBtn);
        ventana.jpbEnvio.setString("Enviando información...");
        ventana.btnEnviar.setEnabled(ventana.enableBtn);
        ventana.lblLeyenda.setVisible(ventana.enableBtn);
        
        if(!ControladorRelojChecador.argsChecadas.isEmpty()){
            preparePost.sendJson(jsonChecadas);
        }else{
            ventana.lblLeyenda.setText("<html><body>No hay registros pro subir!<br><br></body></html>");
           
            habilitarComponentes();
            try {    
             Thread.sleep(3000);
             System.exit(0);
            } catch (InterruptedException ex) {
                 Logger.getLogger(ControladorPeticionesHTTP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void cargarRegitros(){
        String fecha = Fecha.before();
        jsonChecadas = ctrlChecador.getChecadas(fecha);  
        //System.out.println(jsonChecadas);
        habilitarComponentes();
        
        try {    
            System.out.println("Termino");
             Thread.sleep(500);
             enviarInformacion();
        } catch (InterruptedException ex) {
             Logger.getLogger(ControladorPeticionesHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void habilitarComponentes(){
        ventana.enableBtn = !ventana.enableBtn;
        ventana.jpbEnvio.setVisible(!ventana.enableBtn);
        ventana.btnEnviar.setEnabled(ventana.enableBtn);
        ventana.lblLeyenda.setVisible(ventana.enableBtn);
    }
}
