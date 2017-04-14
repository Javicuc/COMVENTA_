/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.Empleado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Javicuc
 */
public interface iEmpleadoDAO {
   public boolean crear(Empleado obj) throws SQLException;

    public List<Empleado> readAll() throws SQLException;

    public List<Empleado> readAllForInput(String searchValue) throws SQLException;

    public Empleado raadByID(int primaryKey) throws SQLException;

    public boolean update(Empleado obj) throws SQLException;

    public boolean delete(Empleado obj) throws SQLException;

    public boolean deleteByID(int primaryKey) throws SQLException;

    public boolean alreadyExisting(int primaryKey) throws SQLException;

    public boolean alreadyExisting(Empleado obj) throws SQLException; 
}
