/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.Proveedor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iProveedorDAO {
    public boolean crear(Proveedor obj) throws SQLException;

    public List<Proveedor> readAll() throws SQLException;

    public List<Proveedor> readAllForInput(String searchValue) throws SQLException;

    public Proveedor readByID(int primaryKey) throws SQLException;

    public boolean update(Proveedor obj) throws SQLException;

    public boolean delete(Proveedor obj) throws SQLException;

    public boolean deleteByID(int primaryKey) throws SQLException;

    public boolean alreadyExisting(int primaryKey) throws SQLException;

    public boolean alreadyExisting(Proveedor obj) throws SQLException;
}
