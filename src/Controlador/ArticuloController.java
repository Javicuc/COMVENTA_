  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulo;
import Modelo.DAO.ArticuloDAO;
import Modelo.DAO.CategoriaDAO;
import Modelo.DAO.DAOManager;
import Modelo.DAO.ProveedorDAO;
import Vista.ArticuloView;
import Vista.CategoriaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Javicuc
 */
public class ArticuloController implements ActionListener{
    
    private ArticuloView vistaArticulo; // Vista que recibimos del actual contexto
    
    private ArticuloDAO  managerArticulo;  // Dao que usaremos para manipular articulos
    private CategoriaDAO managerCategoria; // Dao que usaremos para el combobox categoria
    private ProveedorDAO managerProveedor; // Dao que usaremos para el combobox proveedor
    
    private Articulo objArticulo;
    private boolean tfEdit;
    private ArticuloTableModel articuloTableModel;
    private JTable tableArticulos;
    private JButton btModificar;
    private JButton btEliminar;
    private JButton btNuevo;
    private JButton btGuardar;
    private JButton btCancelar;
    private JButton btCategorias;
    private JComboBox cbCategoria;
    private JComboBox cbProveedor;
    
    public ArticuloController(ArticuloView vista) throws SQLException {
        this.managerArticulo  = new DAOManager().getArticuloDAO(); // Generamos el Dao de articulos
        this.managerCategoria = new DAOManager().getCategoriaDAO(); // Generamos el Dao de categorias
        this.managerProveedor = new DAOManager().getProveedorDAO(); // Generamos el Dao de proveedores
        this.vistaArticulo = vista;                                // Obtenemos la vista del actual contexto
        
        this.articuloTableModel = new ArticuloTableModel(managerArticulo);
        this.articuloTableModel.updateTable();
        this.tableArticulos = vistaArticulo.getTableArticulos();
        this.tableArticulos.setModel(articuloTableModel);
        
        this.btNuevo      = vistaArticulo.getBtNuevo();
        this.btEliminar   = vistaArticulo.getBtEliminar();
        this.btModificar  = vistaArticulo.getBtModificar();
        this.btGuardar    = vistaArticulo.getBtGuardar();
        this.btCancelar   = vistaArticulo.getBtCancelar();
        this.btCategorias = vistaArticulo.getBtCategorias();
        this.cbCategoria  = vistaArticulo.getCbCategoria();
        this.cbProveedor  = vistaArticulo.getCbProveedor();
        
        this.btNuevo.addActionListener(this);
        this.btModificar.addActionListener(this);
        this.btEliminar.addActionListener(this);
        this.btGuardar.addActionListener(this);
        this.btCancelar.addActionListener(this);
        this.btCategorias.addActionListener(this);
        this.tableArticulos.getSelectionModel().addListSelectionListener(c ->{
            boolean isSelect = (tableArticulos.getSelectedRow() != -1);
            btModificar.setEnabled(isSelect);
            btEliminar.setEnabled(isSelect);
            btCancelar.setEnabled(isSelect);
        }); 
        this.cbCategoria.setModel(new DefaultComboBoxModel(managerCategoria.readAll().toArray()));
        this.cbProveedor.setModel(new DefaultComboBoxModel(managerProveedor.readAll().toArray()));
    }
    
    public void loadTextFields(){
        if(getObjArticulo() != null){
            vistaArticulo.getTfNombre().setText(getObjArticulo().getNombre());
            vistaArticulo.getTaDescripcion().setText(getObjArticulo().getDescripcion());
            vistaArticulo.getTfCosto().setText(String.valueOf(getObjArticulo().getCosto()));
            vistaArticulo.getDpCaducidad().setText(String.valueOf(getObjArticulo().getCaducidad()));
            vistaArticulo.getTfCodigo().setText(getObjArticulo().getCodigo());
            vistaArticulo.getCbCategoria().setSelectedIndex(getObjArticulo().getFK_Categoria() - 1);
            vistaArticulo.getCbProveedor().setSelectedIndex(getObjArticulo().getFK_Proveedor() - 1);
        } else {
            vistaArticulo.getTfNombre().setText("");
            vistaArticulo.getTaDescripcion().setText("");
            vistaArticulo.getTfCosto().setText("");
            vistaArticulo.getDpCaducidad().setText("");
            vistaArticulo.getTfCodigo().setText("");
            vistaArticulo.getCbCategoria().setSelectedIndex(0);
            vistaArticulo.getCbProveedor().setSelectedIndex(0);
        }
    }
    public void saveTextFields(){
        if(getObjArticulo() == null)
            setObjArticulo(new Articulo());
        getObjArticulo().setNombre(vistaArticulo.getTfNombre().getText());
        getObjArticulo().setDescripcion(vistaArticulo.getTaDescripcion().getText());
        getObjArticulo().setCosto(Double.parseDouble(vistaArticulo.getTfCosto().getText()));
        getObjArticulo().setCaducidad(Date.valueOf(vistaArticulo.getDpCaducidad().getText()));
        getObjArticulo().setCodigo(vistaArticulo.getTfCodigo().getText());
        getObjArticulo().setFK_Categoria(cbCategoria.getSelectedIndex() + 1);
        getObjArticulo().setFK_Proveedor(cbProveedor.getSelectedIndex() + 1); // Aun no cargamos los proveedores
    }
    
    private Articulo getArticuloSelect() throws SQLException{
        int select = (int) tableArticulos.getValueAt(tableArticulos.getSelectedRow(),0);
        return managerArticulo.raadByID(select);
    }
    
    private void modificarPerformed(){
        try {
            Articulo articulo = getArticuloSelect();
            setObjArticulo(articulo);
            btGuardar.setEnabled(true);
            setTfEdit(true);
            loadTextFields();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void nuevoPerformed(){
        setObjArticulo(null);
        loadTextFields();
        setTfEdit(true);
        tableArticulos.clearSelection();
        vistaArticulo.getDpCaducidad().setDateToToday();
        vistaArticulo.getTfNombre().requestFocusInWindow();
        btGuardar.setEnabled(true);
        btCancelar.setEnabled(true);
        
    }
    private boolean isEmpty(){
        boolean isEmpty = false;
        if(vistaArticulo.getTfNombre().getText().equals("") || 
           vistaArticulo.getTfCosto().getText().equals("") || 
           Double.parseDouble(vistaArticulo.getTfCosto().getText())<= 0 ||
           vistaArticulo.getTfCodigo().getText().equals("") ||
           vistaArticulo.getTfCodigo().getText().length() < 13 ||
           vistaArticulo.getDpCaducidad().getText().equals("")){
           isEmpty = true;
        }
        return isEmpty;
    }
    private void eliminarPerformed(){
        try {
            Articulo temp = getArticuloSelect();
            int sel = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
            if(sel == JOptionPane.YES_OPTION){
                try {
                    if(managerArticulo.delete(temp))
                        JOptionPane.showMessageDialog(null, "Articulo eliminado!");
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    articuloTableModel.updateTable();
                    articuloTableModel.fireTableDataChanged();
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
                Articulo temp = getObjArticulo();
                if(temp.getID_Articulo() == 0)
                    managerArticulo.crear(temp);
                else{
                    managerArticulo.update(temp);
                }
                
                setObjArticulo(null);
                setTfEdit(false);
                loadTextFields();
                btGuardar.setEnabled(false);
                btCancelar.setEnabled(false);
                tableArticulos.clearSelection();
                articuloTableModel.updateTable();
                articuloTableModel.fireTableDataChanged();
                
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    private void cancelarPerformed(){
        setObjArticulo(null);
        setTfEdit(false);
        loadTextFields();
        tableArticulos.clearSelection();
        btGuardar.setEnabled(false);
        btCancelar.setEnabled(false);
    }
    
    private void categoriasPerformed(){
        try {
            new CategoriaView();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        else if(source == btCategorias)
            categoriasPerformed();
    }

    /**
     * @return the objArticulo
     */
    public Articulo getObjArticulo() {
        return objArticulo;
    }

    /**
     * @param objArticulo the objArticulo to set
     */
    public void setObjArticulo(Articulo objArticulo) {
        this.objArticulo = objArticulo;
    }

    /**
     * @return the tfEdit
     */
    public boolean isTfEdit() {
        return tfEdit;
    }

    /**
     * @param tfEdit the tfEdit to set
     */
    public void setTfEdit(boolean tfEdit) {
        this.tfEdit = tfEdit;
        vistaArticulo.getTfNombre().setEnabled(tfEdit);
        vistaArticulo.getTaDescripcion().setEnabled(tfEdit);
        vistaArticulo.getTfCosto().setEnabled(tfEdit);
        vistaArticulo.getDpCaducidad().setEnabled(tfEdit);
        vistaArticulo.getTfCodigo().setEnabled(tfEdit);
        vistaArticulo.getCbCategoria().setEnabled(tfEdit);
        vistaArticulo.getCbProveedor().setEnabled(tfEdit);
    }
}
