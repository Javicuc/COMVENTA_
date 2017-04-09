/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iClienteDAO {
    public boolean crear(Cliente obj) throws SQLException;

    public List<Cliente> readAll() throws SQLException;

    public List<Cliente> readAllForInput(String searchValue) throws SQLException;

    public Cliente raadByID(String primaryKey) throws SQLException;

    public boolean update(Cliente obj) throws SQLException;

    public boolean delete(Cliente obj) throws SQLException;

    public boolean deleteByID(String ID) throws SQLException;

    public boolean alreadyExisting(String primaryKey) throws SQLException;

    public boolean alreadyExisting(Cliente obj) throws SQLException;
}
