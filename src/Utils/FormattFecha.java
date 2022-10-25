/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jorge Gonzalez
 */
public class FormattFecha {
    public static String FormateToDate(Date fecha){
        SimpleDateFormat formato = new SimpleDateFormat(Estaticas.FormattDate.FORMAT);
            if(fecha != null)
                return formato.format(fecha);
            else
                return null;
    }
}
