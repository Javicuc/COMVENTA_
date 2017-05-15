/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Cliente;
import Modelo.InterfaceDAO.iClienteDAO;
import SQL.Tablas.COLCLIENTE;
import SQL.Tablas.Tabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javicuc
 */
public class ClienteDAO implements iClienteDAO{

    private Connection con;
    
    final String INSERT = "INSERT INTO " + Tabla.CLIENTE + " ("
            + COLCLIENTE.NOMBRE + ", " + COLCLIENTE.APELLIDOS + ", " + COLCLIENTE.TELEFONO + ", " + COLCLIENTE.DIRECCION + ")" + " VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE " + Tabla.CLIENTE + " SET " + COLCLIENTE.NOMBRE + " = ?, " +
            COLCLIENTE.APELLIDOS + " = ?, " + COLCLIENTE.TELEFONO +" = ?, " + COLCLIENTE.DIRECCION + " = ? WHERE " + COLCLIENTE.ID_CLIENTE + " = ?";
    final String GETALL = "SELECT * FROM " + Tabla.CLIENTE + " ORDER BY " + COLCLIENTE.NOMBRE;
    final String GETONE = "SELECT * FROM " + Tabla.CLIENTE + " WHERE " + COLCLIENTE.ID_CLIENTE + " = ?" ;
    final String DELETE = "DELETE FROM " + Tabla.CLIENTE + " WHERE " + COLCLIENTE.ID_CLIENTE + " = ?";
    
    public ClienteDAO(Connection con) {
        this.con = con;
    }

    @Override
    public boolean crear(Cliente obj) throws SQLException {
        boolean insertar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(INSERT);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getTelefono());
            ps.setString(4, obj.getDireccion());
            if(ps.execute())
                insertar = true;
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
        return insertar;
    } 

    @Override
    public List<Cliente> readAll() throws SQLException {
        List<Cliente> list = new ArrayList<Cliente>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente obj = convertirRS(rs);
                list.add(obj);
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
    public List<Cliente> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente raadByID(int primaryKey) throws SQLException {
        Cliente obj = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETONE);
            ps.setInt(1, primaryKey);
            rs = ps.executeQuery();
            while (rs.next()) 
                obj = convertirRS(rs);
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
        return obj;
    }

    @Override
    public boolean update(Cliente obj) throws SQLException {
        boolean actualizar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getTelefono());
            ps.setString(4, obj.getDireccion());
            ps.setInt(5, obj.getID_Cliente());
            ps.executeUpdate();
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
    public boolean delete(Cliente obj) throws SQLException {
        boolean eliminar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, obj.getID_Cliente());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alreadyExisting(int primaryKey) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean alreadyExisting(Cliente obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Cliente convertirRS(ResultSet rs){
        Cliente obj = null;
        try {
            int    id     = rs.getInt(COLCLIENTE.ID_CLIENTE);
            String nombre = rs.getString(COLCLIENTE.NOMBRE);
            String ape    = rs.getString(COLCLIENTE.APELLIDOS);
            String tel    = rs.getString(COLCLIENTE.TELEFONO);
            String dir    = rs.getString(COLCLIENTE.DIRECCION);
            obj = new Cliente(id, nombre, ape, tel, dir);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
}
