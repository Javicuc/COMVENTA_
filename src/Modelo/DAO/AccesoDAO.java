/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Acceso;
import Modelo.InterfaceDAO.iAccesoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Javicuc
 */
public class AccesoDAO implements iAccesoDAO{

    private Connection con;
    
    final String INSERT = "INSERT INTO Acceso (ID_Empleado,Usuario,Clave) VALUES(?,?,?)";
    final String UPDATE = "UPDATE Acceso SET Usuario = ?, Clave = ?, WHERE ID_Empleado = ?";
    final String GETALL = "SELECT * FROM Acceso ORDER BY Usuario";
    final String GETONE = "SELECT * FROM Acceso WHERE ID_Empleado = ";
    final String DELETE = "DELETE FROM Acceso WHERE ID_Empleado = ";
    
    public AccesoDAO(Connection con){
        this.con = con;
    }
    
    @Override
    public boolean crear(Acceso obj) throws SQLException {
        boolean insertar = false;
        
        return insertar;
    }

    @Override
    public List<Acceso> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Acceso> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceso raadByID(int primaryKey) throws SQLException {
        Acceso acceso = new Acceso();
       
        return acceso;
    }

    @Override
    public boolean update(Acceso obj) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean actualizar = false;
        
        return actualizar;
    }

    @Override
    public boolean delete(Acceso obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteByID(int primaryKey) throws SQLException {
        boolean eliminar = false;
        try /*(Connection cn = con.conexion())*/ {
            PreparedStatement ps = con.prepareCall(DELETE + String.valueOf(primaryKey));
            
            if (JOptionPane.showConfirmDialog(null, "Está seguro que quiere eliminarlo?", "!", JOptionPane.YES_NO_OPTION) == 0) {
                if (ps.execute()) {
                    JOptionPane.showMessageDialog(null, "El usuario de elimino correctamente...");
                    eliminar = true;
                }
            }
            
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion "+ex);
        }
        return eliminar;
    }

    @Override
    public boolean alreadyExisting(int primaryKey) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alreadyExisting(Acceso obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
