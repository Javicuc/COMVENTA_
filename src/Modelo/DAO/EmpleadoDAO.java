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
import javax.swing.JOptionPane;

/**
 *
 * @author Javicuc
 */
public class EmpleadoDAO implements iEmpleadoDAO{

    private Connection con;
    
    final String INSERT = "INSERT INTO " + Tabla.EMPLEADO + " (" + COLEMPLEADO.ID_EMPLEADO + "," +
            COLEMPLEADO.NOMBRE + "," + COLEMPLEADO.APELLIDOS +","+ COLEMPLEADO.TELEFONO + ")" + "VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE " + Tabla.EMPLEADO + " SET " + COLEMPLEADO.NOMBRE + " = ?," +
            COLEMPLEADO.APELLIDOS + " = ?," + COLEMPLEADO.TELEFONO + " = ?, WHERE "+ COLEMPLEADO.ID_EMPLEADO +"= ?";
    final String GETALL = "SELECT * FROM " + Tabla.EMPLEADO + " ORDER BY " + COLEMPLEADO.NOMBRE;
    final String GETONE = "SELECT * FROM " + Tabla.EMPLEADO + "WHERE " + COLEMPLEADO.ID_EMPLEADO + " = ?" ;
    final String DELETE = "DELETE FROM " + Tabla.EMPLEADO + " WHERE " + COLEMPLEADO.ID_EMPLEADO + " = ?";
    
    public EmpleadoDAO(Connection con) {
        this.con = con;
    }

    @Override
    public boolean crear(Empleado obj) throws SQLException {
        boolean insertar = false;
        try {
            
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, String.valueOf(obj.hashCode()));
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellidos());
            ps.setString(4, obj.getTelefono());
            
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
        ArrayList empleados = new ArrayList();
        Empleado empleado = new Empleado();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(GETALL);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                empleado.setID_Empleado(Integer.parseInt(res.getString(1)));
                empleado.setNombre(res.getString(2));
                empleado.setApellidos(res.getString(3));
                empleado.setTelefono(res.getString(4));
                empleados.add(empleado);
            }
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return empleados;
    }

    @Override
    public List<Empleado> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado readByID(int primaryKey) throws SQLException {
        Empleado empleado = new Empleado();
        try {
            
            PreparedStatement ps = con.prepareStatement(GETONE);
            ps.setInt(1, primaryKey);
            ResultSet res = ps.executeQuery();
        
            if (res.next()) {
                empleado.setID_Empleado(Integer.parseInt(res.getString(1)));
                empleado.setNombre(res.getString(2));
                empleado.setApellidos(res.getString(3));
                empleado.setTelefono(res.getString(4));
            }
            con.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion "+ex);
        }
        
        return empleado;
    }

    @Override
    public boolean update(Empleado obj) throws SQLException {
        boolean actualizar = false;
        try {

            PreparedStatement ps = con.prepareStatement(UPDATE);
            ps.setInt(1, obj.getID_Empleado());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellidos());
            ps.setString(4, obj.getTelefono());
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
    public boolean delete(Empleado obj) throws SQLException {
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
    public boolean alreadyExisting(Empleado obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
