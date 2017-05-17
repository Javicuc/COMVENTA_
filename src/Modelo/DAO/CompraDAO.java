/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Compra;
import Modelo.InterfaceDAO.iCompraDAO;
import SQL.Tablas;
import SQL.Tablas.COLCOMPRA;
import SQL.Tablas.Tabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Javicuc
 */
public class CompraDAO implements iCompraDAO{

    private Connection con;
    private final String INSERT = "INSERT INTO " + Tabla.COMPRA + " (" + COLCOMPRA.FECHA + ") VALUES (?)";
    private final String UPDATE = "UPDATE " + Tabla.COMPRA + " SET " + COLCOMPRA.FECHA + " = ? WHERE " + COLCOMPRA.ID_COMPRA + " = ?";
    private final String GETALL = "SELECT * FROM " + Tabla.COMPRA + " ORDER BY " + COLCOMPRA.FECHA;
    private final String GETONE = "SELECT * FROM " + Tabla.COMPRA + " WHERE " + COLCOMPRA.ID_COMPRA + " = ?";
    private final String DELETE = "DELETE FROM " + Tabla.COMPRA + " WHERE " + COLCOMPRA.ID_COMPRA + " = ?";
    private final String GETLAST = "SELECT * FROM compra ORDER BY ID_Compra DESC LIMIT 1";
    public CompraDAO(Connection con) {
        this.con = con;
    }
    
    @Override
    public boolean crear(Compra obj) throws SQLException {
    boolean insertar = false;
        try {
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setTimestamp(1, obj.getFecha());
            if (!ps.execute())
                insertar = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return insertar;
    }

    @Override
    public List<Compra> readAll() throws SQLException {
        List<Compra> list = new ArrayList<Compra>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Compra obj = convertirRS(rs);
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
    public List<Compra> readAllForInput(int searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra raadByID(int primaryKey) throws SQLException {
        Compra obj = null;
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
    public boolean update(Compra obj) throws SQLException {
        boolean actualizar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setTimestamp(1, obj.getFecha());
            if (!ps.execute()) 
                actualizar = true;
        } catch (SQLException e) {
            throw new SQLException(e);
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
    public boolean delete(Compra obj) throws SQLException {
        boolean eliminar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, obj.getID_Compra());
            if(!ps.execute())
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
    public boolean alreadyExisting(Compra obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Compra convertirRS(ResultSet rs) {
        Compra obj = null;
        try {
            int id          = rs.getInt(COLCOMPRA.ID_COMPRA);
            Timestamp fecha = rs.getTimestamp(COLCOMPRA.FECHA);
            obj = new Compra(id, fecha);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    public Compra getLast() throws SQLException{
        Compra obj = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETLAST);
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
    
    
}
