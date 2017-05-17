/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import SQL.Tablas.COLCLIENTE;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author javilubz
 */
public class ClienteTableModel extends AbstractTableModel{

    private ClienteDAO objDAO;
    private List<Cliente> data = new ArrayList<>();
    
    
    public ClienteTableModel(ClienteDAO cDAO){
        this.objDAO = cDAO;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return COLCLIENTE.ID_CLIENTE;
            case 1: return COLCLIENTE.NOMBRE;
            case 2: return COLCLIENTE.APELLIDOS;
            case 3: return COLCLIENTE.TELEFONO;
            case 4: return COLCLIENTE.DIRECCION;
            default: return "";
        }
    }
 
    public void updateTable() throws SQLException{
        data = objDAO.readAll();
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5; // Se puede calcular de otra forma, de momento lo dejaremos así
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente getData = data.get(rowIndex);
        switch(columnIndex){
            case 0: return getData.getID_Cliente();
            case 1: return getData.getNombre();
            case 2: return getData.getApellidos();
            case 3: return getData.getTelefono();
            case 4: return getData.getDireccion();
            default: return "";
        }
    }
    
}
