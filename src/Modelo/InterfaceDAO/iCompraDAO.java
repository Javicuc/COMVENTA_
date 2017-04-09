/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.Compra;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iCompraDAO {
    public boolean crear(Compra obj) throws SQLException;

    public List<Compra> readAll() throws SQLException;

    public List<Compra> readAllForInput(String searchValue) throws SQLException;

    public Compra raadByID(String primaryKey) throws SQLException;

    public boolean update(Compra obj) throws SQLException;

    public boolean delete(Compra obj) throws SQLException;

    public boolean deleteByID(String ID) throws SQLException;

    public boolean alreadyExisting(String primaryKey) throws SQLException;

    public boolean alreadyExisting(Compra obj) throws SQLException;

}
