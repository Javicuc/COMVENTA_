/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.JornadasTrabajo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iJornadasTrabajoDAO {
    
    public boolean crear(JornadasTrabajo obj) throws SQLException;

    public List<JornadasTrabajo> readAll() throws SQLException;

    public List<JornadasTrabajo> readAllForInput(String searchValue) throws SQLException;

    public JornadasTrabajo raadByID(String primaryKey) throws SQLException;

    public boolean update(JornadasTrabajo obj) throws SQLException;

    public boolean delete(JornadasTrabajo obj) throws SQLException;

    public boolean deleteByID(String ID) throws SQLException;

    public boolean alreadyExisting(String primaryKey) throws SQLException;

    public boolean alreadyExisting(JornadasTrabajo obj) throws SQLException;
}
