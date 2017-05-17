/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Empleado;
import Modelo.InterfaceDAO.iEmpleadoDAO;
import SQL.Tablas.COLEMPLEADO;
import SQL.Tablas.Tabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Javicuc
 */
public class EmpleadoDAO implements iEmpleadoDAO{

    private Connection con;
    
    final String INSERT = "INSERT INTO " + Tabla.EMPLEADO + " (" +
            COLEMPLEADO.NOMBRE + ", " + COLEMPLEADO.APELLIDOS + ", " + COLEMPLEADO.TELEFONO + ")" + " VALUES(?,?,?)";
    final String UPDATE = "UPDATE " + Tabla.EMPLEADO + " SET " + COLEMPLEADO.NOMBRE + " = ?, " +
            COLEMPLEADO.APELLIDOS + " = ?, " + COLEMPLEADO.TELEFONO + " = ? WHERE "+ COLEMPLEADO.ID_EMPLEADO +" = ?";
    final String GETALL = "SELECT * FROM " + Tabla.EMPLEADO + " ORDER BY " + COLEMPLEADO.NOMBRE;
    final String GETONE = "SELECT * FROM " + Tabla.EMPLEADO + " WHERE " + COLEMPLEADO.ID_EMPLEADO + " = ?" ;
    final String DELETE = "DELETE FROM " + Tabla.EMPLEADO + " WHERE " + COLEMPLEADO.ID_EMPLEADO + " = ?";
    
    public EmpleadoDAO(Connection con) {
        this.con = con;
    }

    @Override
    public boolean crear(Empleado obj) throws SQLException {
        boolean insertar = false;
        try {
            
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getTelefono());
            
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
    public List<Empleado> readAll() throws SQLException {
        List<Empleado> list = new ArrayList<Empleado>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = convertirRS(rs);
                list.add(emp);
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
    public List<Empleado> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado readByID(int primaryKey) throws SQLException {
        Empleado emp = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETONE);
            ps.setInt(1, primaryKey);
            rs = ps.executeQuery();
            while (rs.next()) 
                emp = convertirRS(rs);
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
        return emp;
    }

    @Override
    public boolean update(Empleado obj) throws SQLException {
        boolean actualizar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getTelefono());
            ps.setInt(4, obj.getID_Empleado());
            if (!ps.execute()) {
                JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente...");
                actualizar = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar...");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion " + e);
        } finally {
            if(ps != null)
                try{
                    ps.close();
                }catch(SQLException e){
                    throw new SQLException(e);
                }
        }
        return actualizar;
    }

    @Override
    public boolean delete(Empleado obj) throws SQLException {
        boolean eliminar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, obj.getID_Empleado());
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
                    JOptionPane.showMessageDialog(null, "El usuario de elimino correctamente...");
                    eliminar = true;
                }
            }
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
    public boolean alreadyExisting(Empleado obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Empleado convertirRS(ResultSet rs) {
        Empleado empleado = null;
        try {
            int    id     = rs.getInt(COLEMPLEADO.ID_EMPLEADO);
            String nombre = rs.getString(COLEMPLEADO.NOMBRE);
            String aped   = rs.getString(COLEMPLEADO.APELLIDOS);
            String tel    = rs.getString(COLEMPLEADO.TELEFONO);
            empleado = new Empleado(id, nombre, aped, tel);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleado;
    }
    
}
