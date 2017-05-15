/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.DAO.CategoriaDAO;
import SQL.Tablas.COLCATEGORIA;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author javilubz
 */
public class CategoriaTableModel extends AbstractTableModel{
    private CategoriaDAO categoria;
    private List<Categoria> data = new ArrayList<>();
    
    CategoriaTableModel(CategoriaDAO managerCategoria) {
        this.categoria = managerCategoria;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return COLCATEGORIA.ID_CATEGORIA;
            case 1: return COLCATEGORIA.NOMBRE;
            default: return "";
        }
    }
    @Override
    public int getRowCount() {
       return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria getDataCategoria = data.get(rowIndex);
        switch(columnIndex){
            case 0: return getDataCategoria.getID_CategoriaArticulo();
            case 1: return getDataCategoria.getNombre();
            default: return "";
        }
    }
      public void updateTable() throws SQLException{
        data = categoria.readAll();
    }
    
    
}
