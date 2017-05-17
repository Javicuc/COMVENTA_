/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Acceso;
import Modelo.InterfaceDAO.iAccesoDAO;
import SQL.Tablas;
import SQL.Tablas.COLACCESO;
import SQL.Tablas.Tabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Javicuc
 */
public class AccesoDAO implements iAccesoDAO{

    private Connection con;
    
    final String INSERT = "INSERT INTO " + Tabla.ACCESO + " (" 
            +COLACCESO.USUARIO+", " + COLACCESO.CLAVE + ", " + COLACCESO.TIPO + ", " + COLACCESO.ID_EMPLEADO + ")" + " VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE "+Tabla.ACCESO+" SET "+COLACCESO.USUARIO+" = ?,"+COLACCESO.CLAVE+" = ?,"
            +COLACCESO.TIPO + " = ?, WHERE " + COLACCESO.ID_EMPLEADO + " = ?";
    final String GETALL = "SELECT * FROM " + Tabla.ACCESO + " ORDER BY " + COLACCESO.USUARIO;
    final String GETONE = "SELECT * FROM " + Tabla.ACCESO+" WHERE " + COLACCESO.USUARIO + " = ? AND " + COLACCESO.CLAVE + " = ?";
    final String DELETE = "DELETE FROM " + Tabla.ACCESO+" WHERE " + COLACCESO.ID_EMPLEADO + " = ?";
    
    public AccesoDAO(Connection con){
        this.con = con;
    }
    
    @Override
    public boolean crear(Acceso obj) throws SQLException {
        boolean insertar = false;
        try {
            
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getClave());
            ps.setString(3, obj.getTipo());
            ps.setInt(4, obj.getFK_Empleado());
            
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
    public List<Acceso> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Acceso> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceso readByID(Acceso obj) throws SQLException {
        Acceso acceso = new Acceso();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETONE);
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getClave());
            rs = ps.executeQuery();
            while (rs.next()) 
                acceso = convertirRS(rs);
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
        return acceso;
    }

    @Override
    public boolean update(Acceso obj) throws SQLException {
        boolean actualizar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getClave());
            ps.setString(3, obj.getTipo());
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
    public boolean delete(Acceso obj) throws SQLException {
        boolean eliminar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            //ps.setInt(1, obj.getID_Empleado());
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
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, primaryKey);
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
    public boolean alreadyExisting(int primaryKey) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alreadyExisting(Acceso obj) throws SQLException {
        boolean exist = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(GETONE);
            //ps.setInt(1, obj.getID_Empleado());
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getClave());
            ResultSet rs = ps.executeQuery();
            if(rs.first())
                exist = true;
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
        return exist;
    }

   private Acceso convertirRS(ResultSet rs) {
        Acceso a = null;
        try {
            int    idAcce  = rs.getInt("ID_Acceso");
            String usuario = rs.getString(COLACCESO.USUARIO);
            String clave   = rs.getString(COLACCESO.CLAVE);
            String tipo    = rs.getString(COLACCESO.TIPO);
            int    idEmp   = rs.getInt(COLACCESO.ID_EMPLEADO);
            a = new Acceso(idAcce,usuario,clave,tipo,idEmp);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}