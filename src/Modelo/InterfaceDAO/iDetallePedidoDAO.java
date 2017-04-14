/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.DetallePedido;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iDetallePedidoDAO {
    public boolean crear(DetallePedido obj) throws SQLException;

    public List<DetallePedido> readAll() throws SQLException;

    public List<DetallePedido> readAllForInput(String searchValue) throws SQLException;

    public DetallePedido raadByID(int primaryKey) throws SQLException;

    public boolean update(DetallePedido obj) throws SQLException;

    public boolean delete(DetallePedido obj) throws SQLException;

    public boolean deleteByID(int primaryKey) throws SQLException;

    public boolean alreadyExisting(int primaryKey) throws SQLException;

    public boolean alreadyExisting(DetallePedido obj) throws SQLException;

}
