/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulo;
import Modelo.DAO.ArticuloDAO;
import SQL.Tablas.COLARTICULO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Javicuc
 */
public class ArticuloTableModel extends AbstractTableModel{

    private ArticuloDAO articulo;
    private List<Articulo> data = new ArrayList<>();
    
    public ArticuloTableModel(ArticuloDAO art){
        this.articulo = art;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return COLARTICULO.ID_ARTICULO;
            case 1: return COLARTICULO.NOMBRE;
            case 2: return COLARTICULO.DESCRIPCION;
            case 3: return COLARTICULO.COSTO;
            case 4: return COLARTICULO.CADUCIDAD;
            case 5: return COLARTICULO.CODIGO;
            case 6: return COLARTICULO.FK_CATEGORIA;
            default: return "";
        }
    }
 
    public void updateTable() throws SQLException{
        data = articulo.readAll();
        for(Articulo tem:data)
            System.out.println(tem.toString());
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 7; // Se puede calcular de otra forma, de momento lo dejaremos así
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Articulo getDataArticulo = data.get(rowIndex);
        switch(columnIndex){
            case 0: return getDataArticulo.getID_Articulo();
            case 1: return getDataArticulo.getNombre();
            case 2: return getDataArticulo.getDescripcion();
            case 3: return getDataArticulo.getCosto();
            case 4: 
                DateFormat df = DateFormat.getDateInstance(); // Debido al formato que maneja SQL necesitamos (AÑO/MES/DIA)
                return df.format(getDataArticulo.getCaducidad()); // formatearlo para que sea entendible (DIA/MES/AÑO)
            case 5: return getDataArticulo.getCodigo();
            case 6: return getDataArticulo.getFK_Categoria();
            default: return "";
        }
    }
    
}
