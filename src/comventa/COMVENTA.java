/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comventa;

import SQL.BD_Conexion;
import Vista.ArticulosView;
import java.sql.Connection;

/**
 *
 * @author Javicuc
 */
public class COMVENTA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection con = BD_Conexion.getInstance();
        ArticulosView accv = new ArticulosView();
        if(con != null){
            System.out.println("Driver Encontrado");
            accv.setVisible(true);
        }
    }
    
}
