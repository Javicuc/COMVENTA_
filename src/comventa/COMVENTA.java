/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comventa;

import Modelo.*;
import Modelo.DAO.DAOManager;
import Vista.MainView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        
/**
 *
 * @author Javicuc
 */
public class COMVENTA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
            Articulo objID = new Articulo(12,"Doritos Diablo", "Frituras", 8.50,Date.valueOf(LocalDate.now()), "AR-1234567890", 1);
            Articulo objNI = new Articulo("Chetos", "Frituras", 8.50,Date.valueOf(LocalDate.now()), "AR-1234567890", 1);
            Articulo objDI = new Articulo(8,"Chetos", "Frituras", 8.50,Date.valueOf(LocalDate.now()), "AR-1234567890", 1);
        */
        
        List<Categoria> list = new ArrayList<Categoria>();
        
        DAOManager dao = new DAOManager();
        try {
            list = dao.getCategoriaDAO().readAll();
        
        } catch (SQLException ex) {
            Logger.getLogger(COMVENTA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MainView main = new MainView();
        for(Categoria temp : list)
            System.out.println(temp.toString());
    }
    
}
