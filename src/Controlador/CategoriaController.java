/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.DAO.CategoriaDAO;
import Modelo.DAO.DAOManager;
import Vista.CategoriaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Javicuc
 */
public class CategoriaController implements ActionListener{

    private CategoriaDAO  managerCategoria;
    private CategoriaView vistaCategoria;
    private CategoriaTableModel CategoriaTableModel;
    private Categoria objCategoria;
    private JTable tableCategoria;
    private CategoriaTableModel categoriaTableModel;
    private boolean tfEdit;
    private JButton btModificar;
    private JButton btNuevo;
    private JButton btEliminar;
    private JButton btGuardar;
    private JButton btCancelar;
    
    
    public CategoriaController(CategoriaView vista) throws SQLException {
        this.managerCategoria = new DAOManager().getCategoriaDAO();
        this.vistaCategoria   = vista;
        
        this.categoriaTableModel = new CategoriaTableModel(managerCategoria);
        this.categoriaTableModel.updateTable();
        this.tableCategoria = vistaCategoria.getTableCategorias();
        this.tableCategoria.setModel(categoriaTableModel);
        
        this.btNuevo = vistaCategoria.getBtNuevo();
        this.btEliminar = vistaCategoria.getBtEliminar();
        this.btModificar = vistaCategoria.getBtModificar();
        this.btGuardar = vistaCategoria.getBtGuardar();
        this.btCancelar = vistaCategoria.getBtCancelar();
        
        this.btNuevo.addActionListener(this);
        this.btModificar.addActionListener(this);
        this.btEliminar.addActionListener(this);
        this.btGuardar.addActionListener(this);
        this.btCancelar.addActionListener(this);
        this.tableCategoria.getSelectionModel().addListSelectionListener(c ->{
            boolean isSelect = (tableCategoria.getSelectedRow() != -1);
            btModificar.setEnabled(isSelect);
            btEliminar.setEnabled(isSelect);
            btCancelar.setEnabled(isSelect);
        }); 
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btModificar)
            modificarPerformed();
        else if(source == btNuevo)
            nuevoPerformed();
        else if(source == btEliminar)
            eliminarPerformed();
        else if(source == btGuardar)
            guardarPerformed();
        else if (source == btCancelar)
            cancelarPerformed();
    }
    
    public void loadTextFields(){
        if(getObjCategoria()!= null){
            vistaCategoria.getTfNombre().setText(getObjCategoria().getNombre());
        } else {
            vistaCategoria.getTfNombre().setText("");
        }
    }
    public void saveTextFields(){
        if(getObjCategoria() == null)
            setObjCategoria(new Categoria());
        getObjCategoria().setNombre(vistaCategoria.getTfNombre().getText());
    }
    
    private Categoria getCategoriaSelect() throws SQLException{
        int select = (int) tableCategoria.getValueAt(tableCategoria.getSelectedRow(),0);
        return managerCategoria.raadByID(select);
    }
    
    private void modificarPerformed(){
        try {
            Categoria categoria = getCategoriaSelect();
            setObjCategoria(categoria);
            btGuardar.setEnabled(true);
            setTfEdit(true);
            loadTextFields();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void nuevoPerformed(){
        setObjCategoria(null);
        loadTextFields();
        setTfEdit(true);
        tableCategoria.clearSelection();
        vistaCategoria.getTfNombre().requestFocusInWindow();
        btGuardar.setEnabled(true);
        btCancelar.setEnabled(true);
        
    }
    private boolean isEmpty(){
        boolean isEmpty = false;
        if(vistaCategoria.getTfNombre().getText().equals("")){
           isEmpty = true;
        }
        return isEmpty;
    }
    private void eliminarPerformed(){
        try {
            Categoria temp = getCategoriaSelect();
            int sel = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
            if(sel == JOptionPane.YES_OPTION){
                try {
                    if(managerCategoria.delete(temp))
                        JOptionPane.showMessageDialog(null, "Articulo eliminado!");
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    categoriaTableModel.updateTable();
                    categoriaTableModel.fireTableDataChanged();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void guardarPerformed(){ 
        if(!isEmpty()){
            try {
                saveTextFields();
                Categoria temp = getObjCategoria();
                if(temp.getID_CategoriaArticulo() == 0)
                    managerCategoria.crear(temp);
                else{
                    managerCategoria.update(temp);
                }
                
                setObjCategoria(null);
                setTfEdit(false);
                loadTextFields();
                btGuardar.setEnabled(false);
                btCancelar.setEnabled(false);
                tableCategoria.clearSelection();
                categoriaTableModel.updateTable();
                categoriaTableModel.fireTableDataChanged();
                
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    private void cancelarPerformed(){
        setObjCategoria(null);
        setTfEdit(false);
        loadTextFields();
        tableCategoria.clearSelection();
        btGuardar.setEnabled(false);
        btCancelar.setEnabled(false);
    }

    public Categoria getObjCategoria() {
        return objCategoria;
    }

    public void setObjCategoria(Categoria objCategoria) {
        this.objCategoria = objCategoria;
    }

    public boolean isTfEdit() {
        return tfEdit;
    }

    public void setTfEdit(boolean tfEdit) {
        this.tfEdit = tfEdit;
        vistaCategoria.getTfNombre().setEnabled(tfEdit);
    }
    
    
    
}
