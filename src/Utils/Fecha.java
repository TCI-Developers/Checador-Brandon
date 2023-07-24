/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jorge Gonzalez
 */
public class Fecha {
    static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
    
    public static String fecha(){
        Date fecha = new Date();
        
        return FormattFecha.FormateToDate(fecha);
    }
    
    public static String before(){
        Date fecha = new Date();
        Calendar today = Calendar.getInstance();
        today.setTime(fecha);
        today.add(Calendar.DATE,-1);
        java.util.Date before = today.getTime();
        return FormattFecha.FormateToDate(before);
    }
    
    public static String now(){
        Date fecha = new Date();
        return FormattFecha.FormateToDate(fecha);
    }
     
     
    public static String FormateToText(JDateChooser jdcFecha){
             if(jdcFecha.getDate() != null){
                return FormattFecha.FormateToDate(jdcFecha.getDate());
            } 
       return null;
    }
    
    

}


