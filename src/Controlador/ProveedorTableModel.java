/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.ProveedorDAO;
import Modelo.Proveedor;
import SQL.Tablas.COLPROVEEDOR;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Javicuc
 */
public class ProveedorTableModel extends AbstractTableModel{

    private ProveedorDAO proveedorDAO;
    private List<Proveedor> data = new ArrayList<>();
    
    public ProveedorTableModel(ProveedorDAO pDAO){
        this.proveedorDAO = pDAO;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return COLPROVEEDOR.ID_PROVEEDOR;
            case 1: return COLPROVEEDOR.NOMBRE;
            case 2: return COLPROVEEDOR.DIRECCION;
            case 3: return COLPROVEEDOR.TELEFONO;
            case 4: return COLPROVEEDOR.WEB;
            default: return "";
        }
    }
 
    public void updateTable() throws SQLException{
        data = proveedorDAO.readAll();
        for(Proveedor tem:data)
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
        Proveedor getDataProveedor = data.get(rowIndex);
        switch(columnIndex){
            case 0: return getDataProveedor.getID_Proveedor();
            case 1: return getDataProveedor.getNombre();
            case 2: return getDataProveedor.getDireccion();
            case 3: return getDataProveedor.getTelefono();
            case 4: return getDataProveedor.getWeb();
            default: return "";
        }
    }
    
}
