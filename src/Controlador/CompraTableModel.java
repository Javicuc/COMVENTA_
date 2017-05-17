/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.DetalleCompraDAO;
import Modelo.Ticket;
import SQL.Tablas.COLARTICULO;
import SQL.Tablas.COLDETALLECOMPRA;
import SQL.Tablas.COLCOMPRA;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author javilubz
 */
class CompraTableModel extends AbstractTableModel {

    private DetalleCompraDAO objDAO;
    private List<Ticket> data = new ArrayList<>();
    
    public CompraTableModel(DetalleCompraDAO detalleManager) {
        this.objDAO = detalleManager;
    }
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return COLCOMPRA.ID_COMPRA;
            case 1: return COLDETALLECOMPRA.ID_DETALLECOMPRA;
            case 2: return COLARTICULO.ID_ARTICULO;
            case 3: return COLARTICULO.NOMBRE;
            case 4: return COLARTICULO.DESCRIPCION;
            case 5: return COLDETALLECOMPRA.CANTIDAD;
            case 6: return COLARTICULO.COSTO;
            case 7: return COLDETALLECOMPRA.IMPORTE;
            case 8: return COLCOMPRA.FECHA;
            default: return "";
        }
    }
    void updateTable(int id) throws SQLException {
        data = objDAO.readAllForInput(id);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ticket getData = data.get(rowIndex);
        switch(columnIndex){
            case 0: return getData.getID_Compra();
            case 1: return getData.getID_DetalleCompra();
            case 2: return getData.getID_Articulo();
            case 3: return getData.getNombre();
            case 4: return getData.getDescripcion();
            case 5: return getData.getCantidad();
            case 6: return getData.getPrecio();
            case 7: return getData.getImporte();
            case 8: return getData.getFechaHora();
            default: return "";
        }
    }
}
