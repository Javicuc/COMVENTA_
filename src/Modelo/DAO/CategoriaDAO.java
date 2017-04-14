/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Categoria;
import Modelo.InterfaceDAO.iCategoriaDAO;
import SQL.Tablas;
import SQL.Tablas.Tabla;
import SQL.Tablas.COLCATEGORIA;
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
public class CategoriaDAO implements iCategoriaDAO{

    private Connection con;
    
    
    final String INSERT = "INSERT INTO " + Tabla.CATEGORIA + "(" + COLCATEGORIA.NOMBRE + ")" + " VALUES(?)";
    final String UPDATE = "UPDATE " + Tabla.CATEGORIA + " SET " + COLCATEGORIA.NOMBRE + " = ?" + " WHERE " + COLCATEGORIA.ID_CATEGORIA + " = ?";
    final String GETALL = "SELECT * FROM " + Tabla.CATEGORIA + " ORDER BY " + COLCATEGORIA.NOMBRE;
    final String GETONE = "SELECT * FROM " + Tabla.CATEGORIA + " WHERE " + COLCATEGORIA.ID_CATEGORIA + " = ?"; 
    final String DELETE = "DELETE FROM " + Tabla.CATEGORIA + " WHERE " + COLCATEGORIA.ID_CATEGORIA + " = ?";
    final String GETALLORDERBY = "SELECT * FROM " + Tabla.CATEGORIA + " ORDER BY %s";
    
    
    public CategoriaDAO(Connection con){
        this.con = con;
    }
    
    @Override
    public boolean crear(Categoria obj) throws SQLException {
        boolean insertar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(INSERT);
            ps.setString(1, obj.getNombre());
            ps.executeUpdate();
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
    public List<Categoria> readAll() throws SQLException {
        List<Categoria> list = new ArrayList<Categoria>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cat = convertirRS(rs);
                list.add(cat);
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
    public List<Categoria> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria raadByID(int primaryKey) throws SQLException {
        Categoria cat = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETONE);
            ps.setInt(1, primaryKey);
            rs = ps.executeQuery();
            while (rs.next()) 
                cat = convertirRS(rs);
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
        return cat;
    }

    @Override
    public boolean update(Categoria obj) throws SQLException {
        boolean actualizar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, obj.getNombre());
            ps.setInt(2, obj.getID_CategoriaArticulo());
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
    public boolean delete(Categoria obj) throws SQLException {
        boolean eliminar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, obj.getID_CategoriaArticulo());
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
    public boolean alreadyExisting(Categoria obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Categoria convertirRS(ResultSet rs){
        Categoria categoria = null;
        try {
            int    id     = rs.getInt(COLCATEGORIA.ID_CATEGORIA);
            String nombre = rs.getString(COLCATEGORIA.NOMBRE);
            categoria = new Categoria(id, nombre);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;
    }
    
}
