/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.Acceso;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iAccesoDAO {
    public boolean crear(Acceso obj) throws SQLException;

    public List<Acceso> readAll() throws SQLException;

    public List<Acceso> readAllForInput(String searchValue) throws SQLException;

    public Acceso readByID(int primaryKey) throws SQLException;

    public boolean update(Acceso obj) throws SQLException;

    public boolean delete(Acceso obj) throws SQLException;

    public boolean deleteByID(int primaryKey) throws SQLException;

    public boolean alreadyExisting(int primaryKey) throws SQLException;

    public boolean alreadyExisting(Acceso obj) throws SQLException;
}
