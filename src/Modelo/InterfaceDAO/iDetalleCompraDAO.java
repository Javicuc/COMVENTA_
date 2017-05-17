/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.DetalleCompra;
import Modelo.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iDetalleCompraDAO {
    public boolean crear(DetalleCompra obj) throws SQLException;

    public List<DetalleCompra> readAll() throws SQLException;

    public List<Ticket> readAllForInput(int searchValue) throws SQLException;

    public DetalleCompra raadByID(int primaryKey) throws SQLException;

    public boolean update(DetalleCompra obj) throws SQLException;

    public boolean delete(DetalleCompra obj) throws SQLException;

    public boolean deleteByID(int primaryKey) throws SQLException;

    public boolean alreadyExisting(int primaryKey) throws SQLException;

    public boolean alreadyExisting(DetalleCompra obj) throws SQLException;

}
