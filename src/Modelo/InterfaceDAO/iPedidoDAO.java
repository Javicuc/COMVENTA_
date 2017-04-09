/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.Pedido;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iPedidoDAO {
    public boolean crear(Pedido obj) throws SQLException;

    public List<Pedido> readAll() throws SQLException;

    public List<Pedido> readAllForInput(String searchValue) throws SQLException;

    public Pedido raadByID(String primaryKey) throws SQLException;

    public boolean update(Pedido obj) throws SQLException;

    public boolean delete(Pedido obj) throws SQLException;

    public boolean deleteByID(String ID) throws SQLException;

    public boolean alreadyExisting(String primaryKey) throws SQLException;

    public boolean alreadyExisting(Pedido obj) throws SQLException;
}
