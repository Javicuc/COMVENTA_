/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.Categoria;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iCategoriaDAO {
    public boolean crear(Categoria obj) throws SQLException;

    public List<Categoria> readAll() throws SQLException;

    public List<Categoria> readAllForInput(String searchValue) throws SQLException;

    public Categoria raadByID(int primaryKey) throws SQLException;

    public boolean update(Categoria obj) throws SQLException;

    public boolean delete(Categoria obj) throws SQLException;

    public boolean deleteByID(int primaryKey) throws SQLException;

    public boolean alreadyExisting(int primaryKey) throws SQLException;

    public boolean alreadyExisting(Categoria obj) throws SQLException;
}
