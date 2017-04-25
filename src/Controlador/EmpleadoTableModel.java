/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.DAO.EmpleadoDAO;
import SQL.Tablas.COLEMPLEADO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Javicuc
 */
public class EmpleadoTableModel extends AbstractTableModel{

    private EmpleadoDAO empleadoDAO;
    private List<Empleado> data = new ArrayList<>();
    
    public EmpleadoTableModel(EmpleadoDAO eDAO){
        this.empleadoDAO = eDAO;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return COLEMPLEADO.ID_EMPLEADO;
            case 1: return COLEMPLEADO.NOMBRE;
            case 2: return COLEMPLEADO.APELLIDOS;
            case 3: return COLEMPLEADO.TELEFONO;
            default: return "";
        }
    }
 
    public void updateTable() throws SQLException{
        data = empleadoDAO.readAll();
        for(Empleado tem:data)
            System.out.println(tem.toString());
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // Se puede calcular de otra forma, de momento lo dejaremos así
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado getDataEmpleado = data.get(rowIndex);
        switch(columnIndex){
            case 0: return getDataEmpleado.getID_Empleado();
            case 1: return getDataEmpleado.getNombre();
            case 2: return getDataEmpleado.getApellidos();
            case 3: return getDataEmpleado.getTelefono();
            default: return "";
        }
    }
    
}
