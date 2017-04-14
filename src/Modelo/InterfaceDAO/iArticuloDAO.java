/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.Articulo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iArticuloDAO {
    public boolean crear(Articulo obj) throws SQLException;

    public List<Articulo> readAll() throws SQLException;

    public List<Articulo> readAllForInput(String searchValue) throws SQLException;

    public Articulo raadByID(int primaryKey) throws SQLException;

    public boolean update(Articulo obj) throws SQLException;

    public boolean delete(Articulo obj) throws SQLException;

    public boolean deleteByID(int primaryKey) throws SQLException;

    public boolean alreadyExisting(int primaryKey) throws SQLException;

    public boolean alreadyExisting(Articulo obj) throws SQLException;
}
