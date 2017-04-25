/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.InterfaceDAO.iProveedorDAO;
import Modelo.Proveedor;
import SQL.Tablas.COLPROVEEDOR;
import SQL.Tablas.Tabla;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Javicuc
 */
public class ProveedorDAO implements iProveedorDAO{

    private Connection con;
    
    final String INSERT = "INSERT INTO " + Tabla.PROVEEDOR + " (" + COLPROVEEDOR.ID_PROVEEDOR + "," +
            COLPROVEEDOR.NOMBRE + "," + COLPROVEEDOR.DIRECCION +","+ COLPROVEEDOR.TELEFONO + "," + 
            COLPROVEEDOR.WEB + ")" + "VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE " + Tabla.PROVEEDOR + " SET " + COLPROVEEDOR.NOMBRE + " = ?," +
            COLPROVEEDOR.DIRECCION + " = ?," + COLPROVEEDOR.TELEFONO + COLPROVEEDOR.WEB + " = ?," +
            " = ?, WHERE " + COLPROVEEDOR.ID_PROVEEDOR +"= ?";
    final String GETALL = "SELECT * FROM " + Tabla.PROVEEDOR + " ORDER BY " + COLPROVEEDOR.NOMBRE;
    final String GETONE = "SELECT * FROM " + Tabla.PROVEEDOR + "WHERE " + COLPROVEEDOR.ID_PROVEEDOR + " = ?" ;
    final String DELETE = "DELETE FROM " + Tabla.PROVEEDOR + " WHERE " + COLPROVEEDOR.ID_PROVEEDOR + " = ?";
    
    public ProveedorDAO(Connection con) {
        this.con = con;
    }

    @Override
    public boolean crear(Proveedor obj) throws SQLException {
        boolean insertar = false;
        try {
            
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, String.valueOf(obj.hashCode()));
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getDireccion());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getWeb());
            
            if (!ps.execute()) {
                JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente...");
                insertar = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar...");
            }
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return insertar;
    }

    @Override
    public List<Proveedor> readAll() throws SQLException {
        ArrayList proveedores = new ArrayList();
        Proveedor proveedor = new Proveedor();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(GETALL);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                proveedor.setID_Proveedor(Integer.parseInt(res.getString(1)));
                proveedor.setNombre(res.getString(2));
                proveedor.setDireccion(res.getString(3));
                proveedor.setTelefono(res.getString(4));
                proveedor.setWeb(res.getString(5));
                proveedores.add(proveedor);
            }
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return proveedores;
    }

    @Override
    public List<Proveedor> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proveedor readByID(int primaryKey) throws SQLException {
        Proveedor proveedor = new Proveedor();
        try {
            
            PreparedStatement ps = con.prepareStatement(GETONE);
            ps.setInt(1, primaryKey);
            ResultSet res = ps.executeQuery();
        
            if (res.next()) {
                proveedor.setID_Proveedor(Integer.parseInt(res.getString(1)));
                proveedor.setNombre(res.getString(2));
                proveedor.setDireccion(res.getString(3));
                proveedor.setTelefono(res.getString(4));
                proveedor.setWeb(res.getString(5));
            }
            con.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion "+ex);
        }
        
        return proveedor;
    }

    @Override
    public boolean update(Proveedor obj) throws SQLException {
        boolean actualizar = false;
        try {

            PreparedStatement ps = con.prepareStatement(UPDATE);
            ps.setInt(1, obj.getID_Proveedor());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getDireccion());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getWeb());
            
            if (!ps.execute()) {
                JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente...");
                actualizar = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar...");
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion "+e);
        
        }
        return actualizar;
    }

    @Override
    public boolean delete(Proveedor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteByID(int primaryKey) throws SQLException {
        boolean eliminar = false;
        try {
            PreparedStatement ps = con.prepareStatement(DELETE);
            ps.setInt(1, primaryKey);
            
            if (JOptionPane.showConfirmDialog(null, "Esta seguro que quiere eliminarlo?", "!", JOptionPane.YES_NO_OPTION) == 0) {
                if (ps.execute()) {
                    JOptionPane.showMessageDialog(null, "El proveedor de elimino correctamente...");
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
    public boolean alreadyExisting(Proveedor obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
