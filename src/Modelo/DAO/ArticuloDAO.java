/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Articulo;
import Modelo.InterfaceDAO.iArticuloDAO;
import SQL.Tablas.COLARTICULO;
import SQL.Tablas.Tabla;
import java.sql.Connection;
import java.sql.Date;
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
public class ArticuloDAO implements iArticuloDAO{

    private Connection con;
    
    final String INSERT = "INSERT INTO " + Tabla.ARTICULO + "(" + COLARTICULO.NOMBRE + ", " + COLARTICULO.DESCRIPCION 
                           + ", " + COLARTICULO.COSTO + ", " + COLARTICULO.CADUCIDAD + "," + COLARTICULO.CODIGO + ","
                           + COLARTICULO.FK_CATEGORIA + ", " + COLARTICULO.FK_PROVEEDOR + ")" + " VALUES(?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE " + Tabla.ARTICULO + " SET " + COLARTICULO.NOMBRE + " = ?, " + COLARTICULO.DESCRIPCION
                           + " = ?, " + COLARTICULO.COSTO + " = ?, " + COLARTICULO.CADUCIDAD + " = ?, " + COLARTICULO.CODIGO
                           + " = ?, " + COLARTICULO.FK_CATEGORIA + " = ?, " + COLARTICULO.FK_PROVEEDOR + " = ? WHERE " 
                           + COLARTICULO.ID_ARTICULO + " = ?";
    final String GETALL = "SELECT * FROM " + Tabla.ARTICULO;
    final String GETONE = "SELECT * FROM " + Tabla.ARTICULO + " WHERE " + COLARTICULO.ID_ARTICULO + " = ?";
    final String GETONECOD = "SELECT * FROM " + Tabla.ARTICULO + " WHERE " + COLARTICULO.CODIGO + " = ?";
    final String DELETE = "DELETE FROM " + Tabla.ARTICULO + " WHERE " + COLARTICULO.ID_ARTICULO + " = ?";
    final String GETALLORDERBY = "SELECT * FROM " + Tabla.ARTICULO + " ORDER BY %s";
            
    public ArticuloDAO(Connection con){
        this.con = con;
    }
    
    @Override
    public boolean crear(Articulo obj) throws SQLException {
        boolean insertar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(INSERT);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setDouble(3, obj.getCosto());
            ps.setDate(4, obj.getCaducidad());
            ps.setString(5, obj.getCodigo());
            ps.setInt(6, obj.getFK_Categoria());
            ps.setInt(7, obj.getFK_Proveedor());
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
    public List<Articulo> readAll() throws SQLException {
        List<Articulo> list = new ArrayList<Articulo>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo art = convertirRS(rs);
                list.add(art);
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
    public List<Articulo> readAllForInput(String searchValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Articulo readByID(int primaryKey) throws SQLException {
        Articulo art = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETONE);
            ps.setInt(1, primaryKey);
            rs = ps.executeQuery();
            while (rs.next()) 
                art = convertirRS(rs);
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
        return art;
    }

    @Override
    public boolean update(Articulo obj) throws SQLException {
        boolean actualizar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setDouble(3, obj.getCosto());
            ps.setDate(4, obj.getCaducidad());
            ps.setString(5, obj.getCodigo());
            ps.setInt(6, obj.getFK_Categoria());
            ps.setInt(7, obj.getFK_Proveedor());
            ps.setInt(8, obj.getID_Articulo());
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
    public boolean delete(Articulo obj) throws SQLException {
        boolean eliminar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, obj.getID_Articulo());
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
    public boolean alreadyExisting(Articulo obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Articulo convertirRS(ResultSet rs){
        Articulo articulo = null;
        try {
            int    id     = rs.getInt(COLARTICULO.ID_ARTICULO);
            String nombre = rs.getString(COLARTICULO.NOMBRE);
            String desc   = rs.getString(COLARTICULO.DESCRIPCION);
            Double costo  = rs.getDouble(COLARTICULO.COSTO);
            Date   cadud  = rs.getDate(COLARTICULO.CADUCIDAD);
            String codigo = rs.getString(COLARTICULO.CODIGO);
            int    fk_cat = rs.getInt(COLARTICULO.FK_CATEGORIA);
            int    fk_pro = rs.getInt(COLARTICULO.FK_PROVEEDOR);
            articulo = new Articulo(id, nombre, desc, costo, cadud, codigo, fk_cat, fk_pro);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulo;
    }
    
    public Articulo readByCodigo(String codigo) throws SQLException{
        Articulo obj = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(GETONECOD);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next())
                obj = convertirRS(rs);
        } catch (SQLException e){
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
    public List<Articulo> Buscar(String busqueda) throws SQLException{
        final String BUSCAR = "SELECT *  FROM articulo WHERE Nombre LIKE %" + busqueda + "% AND Descripcion LIKE %" + busqueda +"%";
        List<Articulo> list = new ArrayList<Articulo>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(BUSCAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo art = convertirRS(rs);
                list.add(art);
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
    
}
