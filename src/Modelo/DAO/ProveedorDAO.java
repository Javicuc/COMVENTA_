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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Javicuc
 */
public class ProveedorDAO implements iProveedorDAO{

    private Connection con;
    
    final String INSERT = "INSERT INTO " + Tabla.PROVEEDOR + " (" +
            COLPROVEEDOR.NOMBRE + ", " + COLPROVEEDOR.DIRECCION +", " + COLPROVEEDOR.TELEFONO + ", " + 
            COLPROVEEDOR.WEB + ")" + " VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE " + Tabla.PROVEEDOR + " SET " + COLPROVEEDOR.NOMBRE + " = ?, " +
            COLPROVEEDOR.DIRECCION + " = ?, " + COLPROVEEDOR.TELEFONO + " = ?, " + COLPROVEEDOR.WEB +
            " = ? WHERE " + COLPROVEEDOR.ID_PROVEEDOR + " = ?";
    final String GETALL = "SELECT * FROM " + Tabla.PROVEEDOR + " ORDER BY " + COLPROVEEDOR.ID_PROVEEDOR;
    final String GETONE = "SELECT * FROM " + Tabla.PROVEEDOR + " WHERE " + COLPROVEEDOR.ID_PROVEEDOR + " = ?";
    final String DELETE = "DELETE FROM " + Tabla.PROVEEDOR + " WHERE " + COLPROVEEDOR.ID_PROVEEDOR + " = ?";
    
    public ProveedorDAO(Connection con) {
        this.con = con;
    }

    @Override
    public boolean crear(Proveedor obj) throws SQLException {
        boolean insertar = false;
        try {
            
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.setString(3, obj.getTelefono());
            ps.setString(4, obj.getWeb());
            
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
        List<Proveedor> list = new ArrayList<Proveedor>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pro = convertirRS(rs);
                list.add(pro);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new SQLException(e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new SQLException(e);
                }    
            }
        }
        return list;
    }

    @Override
    public List<Proveedor> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proveedor readByID(int primaryKey) throws SQLException {
        Proveedor pro = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETONE);
            ps.setInt(1, primaryKey);
            rs = ps.executeQuery();
            while (rs.next()) 
                pro = convertirRS(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new SQLException(e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new SQLException(e);
                }    
            }
        }
        return pro;
    }

    @Override
    public boolean update(Proveedor obj) throws SQLException {
        boolean actualizar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.setString(3, obj.getTelefono());
            ps.setString(4, obj.getWeb());
            ps.setInt(5, obj.getID_Proveedor());
            if(ps.executeUpdate() != 0)
                actualizar = true;
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            if(ps != null){
                try {
                    ps.close();
                } catch(SQLException e) {
                    throw new SQLException(e);
                }
            }
        }
        return actualizar;
    }

    @Override
    public boolean delete(Proveedor obj) throws SQLException {
        boolean eliminar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, obj.getID_Proveedor());
            if(ps.executeUpdate() != 0)
                eliminar = true;
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            if(ps != null){
                try {
                    ps.close();
                } catch(SQLException e) {
                    throw new SQLException(e);
                }
            }
        }
        return eliminar;
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

    private Proveedor convertirRS(ResultSet rs) {
        Proveedor prov = null;
        try {
            int    id     = rs.getInt(COLPROVEEDOR.ID_PROVEEDOR);
            String nombre = rs.getString(COLPROVEEDOR.NOMBRE);
            String direc  = rs.getString(COLPROVEEDOR.DIRECCION);
            String tel    = rs.getString(COLPROVEEDOR.TELEFONO);
            String web    = rs.getString(COLPROVEEDOR.WEB);
            System.out.println(id+" "+nombre+" "+direc+" "+tel+" "+web);
            prov = new Proveedor(id, nombre, direc,tel,web);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prov;
    }
    
}
