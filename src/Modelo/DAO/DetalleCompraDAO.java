/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DetalleCompra;
import Modelo.InterfaceDAO.iDetalleCompraDAO;
import Modelo.Ticket;
import SQL.Tablas;
import SQL.Tablas.COLDETALLECOMPRA;
import SQL.Tablas.Tabla;
import static SQL.Tablas.Tabla.DETALLECOMPRA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javicuc
 */
public class DetalleCompraDAO implements iDetalleCompraDAO{

    private Connection con;
    
    private final String INSERT = "INSERT INTO " + DETALLECOMPRA + " ("+ COLDETALLECOMPRA.FK_COMPRA + "," + COLDETALLECOMPRA.FK_ARTICULO 
            + "," + COLDETALLECOMPRA.CANTIDAD + ", " + COLDETALLECOMPRA.IMPORTE + "," 
            + COLDETALLECOMPRA.FK_EMPLEADO + "," + COLDETALLECOMPRA.FK_CLIENTE + ") VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE " + DETALLECOMPRA + " SET " + COLDETALLECOMPRA.FK_COMPRA + " = ?," + COLDETALLECOMPRA.FK_ARTICULO + " = ?,"
            + COLDETALLECOMPRA.CANTIDAD + " = ?," + COLDETALLECOMPRA.IMPORTE + "," + COLDETALLECOMPRA.FK_EMPLEADO + " = ?," 
            + COLDETALLECOMPRA.FK_CLIENTE + " = ? WHERE " + COLDETALLECOMPRA.ID_DETALLECOMPRA + " = ?";
    private final String DELETE = "DELETE FROM " + DETALLECOMPRA + " WHERE " + COLDETALLECOMPRA.ID_DETALLECOMPRA + " = ?";
    private final String GETALL = "SELECT * FROM " + DETALLECOMPRA + " ORDER BY " + COLDETALLECOMPRA.FK_COMPRA;
    private final String GETONE = "SELECT * FROM " + DETALLECOMPRA + " WHERE " + COLDETALLECOMPRA.ID_DETALLECOMPRA + " = ?";
    private final String GETFORINPUT = "SELECT compra.ID_Compra,detalle_compra.ID_DetalleCompra,articulo.ID_Articulo,articulo.Nombre,articulo.Descripcion,"
    + " detalle_compra.Cantidad,articulo.Costo,detalle_compra.Importe,compra.Fecha"
    + " FROM compra INNER JOIN detalle_compra ON compra.ID_Compra = detalle_compra.FK_Compra"
    + " INNER JOIN articulo ON detalle_compra.FK_Articulo = articulo.ID_Articulo"
    + " WHERE compra.ID_Compra = ? ORDER BY compra.ID_Compra";
    
    public DetalleCompraDAO(Connection con) {
        this.con = con;
    }

    @Override
    public boolean crear(DetalleCompra obj) throws SQLException {
        boolean insertar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(INSERT);
            ps.setInt(1, obj.getFK_Compra());
            ps.setInt(2, obj.getFK_Articulo());
            ps.setInt(3, obj.getCantidad());
            ps.setDouble(4, obj.getImporte());
            ps.setInt(5, obj.getFK_Empleado());
            ps.setInt(6, obj.getFK_Cliente());
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
    public List<DetalleCompra> readAll() throws SQLException {
        List<DetalleCompra> list = new ArrayList<DetalleCompra>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleCompra obj = convertirRS(rs);
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
    public List<Ticket> readAllForInput(int searchValue) throws SQLException {
        List<Ticket> list = new ArrayList<Ticket>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(GETFORINPUT);
            ps.setInt(1, searchValue);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ticket obj = convertirTicketRS(rs);
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
    public Ticket readForInput(int id){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleCompra raadByID(int primaryKey) throws SQLException {
        DetalleCompra obj = null;
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
    public boolean update(DetalleCompra obj) throws SQLException {
        boolean actualizar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setInt(1, obj.getFK_Compra());
            ps.setInt(2, obj.getFK_Articulo());
            ps.setInt(3, obj.getCantidad());
            ps.setDouble(4, obj.getImporte());
            ps.setInt(5, obj.getFK_Empleado());
            ps.setInt(6, obj.getFK_Cliente());
            ps.setInt(7, obj.getID_DetalleCompra());
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
    public boolean delete(DetalleCompra obj) throws SQLException {
        boolean eliminar = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, obj.getID_DetalleCompra());
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
    public boolean alreadyExisting(DetalleCompra obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private DetalleCompra convertirRS(ResultSet rs) {
        DetalleCompra obj = null;
        try {
            int    id    = rs.getInt(COLDETALLECOMPRA.ID_DETALLECOMPRA);
            int    fkC   = rs.getInt(COLDETALLECOMPRA.FK_COMPRA);
            int    fkA   = rs.getInt(COLDETALLECOMPRA.FK_ARTICULO);
            int    cant  = rs.getInt(COLDETALLECOMPRA.CANTIDAD);
            double imp   = rs.getDouble(COLDETALLECOMPRA.IMPORTE);
            int    fkE   = rs.getInt(COLDETALLECOMPRA.FK_EMPLEADO);
            int    fkCl  = rs.getInt(COLDETALLECOMPRA.FK_CLIENTE);
            obj = new DetalleCompra(id, fkC, fkA, cant, imp, fkE, fkCl);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    private Ticket convertirTicketRS(ResultSet rs) {
        Ticket obj = null;
        try {
            int idCompra = rs.getInt("ID_Compra");
            int idDeta   = rs.getInt("ID_DetalleCompra");
            int idProd   = rs.getInt("ID_Articulo");
            String prod  = rs.getString("Nombre");
            String desc  = rs.getString("Descripcion");
            int cantidad = rs.getInt("Cantidad");
            double costo = rs.getDouble("Costo");
            double impor = rs.getDouble("Importe");
            Timestamp fh = rs.getTimestamp("Fecha");
            obj = new Ticket(idCompra,idDeta, idProd, prod, desc, cantidad, costo, impor,fh);
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
}
