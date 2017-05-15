/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.DAOManager;
import Modelo.DAO.ProveedorDAO;
import Modelo.Proveedor;
import Vista.ProveedoresView;
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
public class ProveedorController implements ActionListener {
    private boolean tfEdit;
    private Proveedor unProveedor;
    private ProveedorDAO proveedorDAO;
    private ProveedoresView proveedorVista;
    
    private ProveedorTableModel ptm;
    private JTable tablaProveedores;
    
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnCancelar;
    
    public ProveedorController(ProveedoresView pView) throws SQLException {
        this.proveedorDAO = new DAOManager().getProveedorDAO();
        this.proveedorVista = pView;
        
        this.ptm = new ProveedorTableModel(proveedorDAO);
        this.ptm.updateTable();
        this.tablaProveedores = proveedorVista.getTablaProveedores();
        this.tablaProveedores.setModel(ptm);
        
        this.btnNuevo = proveedorVista.getBtnNuevo();
        this.btnEliminar = proveedorVista.getBtnEliminar();
        this.btnModificar = proveedorVista.getBtnModificar();
        this.btnGuardar = proveedorVista.getBtnGuardar();
        this.btnCancelar = proveedorVista.getBtnCancelar();
        this.btnNuevo.addActionListener(this);
        this.btnModificar.addActionListener(this);
        this.btnEliminar.addActionListener(this);
        this.btnGuardar.addActionListener(this);
        this.btnCancelar.addActionListener(this);
        this.tablaProveedores.getSelectionModel().addListSelectionListener(c ->{
            boolean isSelect = (tablaProveedores.getSelectedRow() != -1);
            btnModificar.setEnabled(isSelect);
            btnEliminar.setEnabled(isSelect);
            btnCancelar.setEnabled(isSelect);
        });
    
    }
    
    public void loadTextFields() {
        if(getUnProveedor() != null){
            proveedorVista.getTxtNombre().setText(getUnProveedor().getNombre());
            proveedorVista.getTxtDireccion().setText(getUnProveedor().getDireccion());
            proveedorVista.getTxtTelefono().setText(getUnProveedor().getTelefono());
            proveedorVista.getTxtWeb().setText(getUnProveedor().getWeb());
            
        } else {
            proveedorVista.getTxtNombre().setText("");
            proveedorVista.getTxtDireccion().setText("");
            proveedorVista.getTxtTelefono().setText("");
            proveedorVista.getTxtWeb().setText("");
        }
    }
    
    private void saveTextFields() {
        if(getUnProveedor() == null)
            setUnProveedor(new Proveedor());
        getUnProveedor().setNombre(proveedorVista.getTxtNombre().getText());
        getUnProveedor().setDireccion(proveedorVista.getTxtDireccion().getText());
        getUnProveedor().setTelefono(proveedorVista.getTxtTelefono().getText());
        getUnProveedor().setWeb(proveedorVista.getTxtWeb().getText());

    }
    
    private void modificarActionPerformed() {                                             
        try {
            Proveedor proveedor = getProveedorSelect();
            setUnProveedor(proveedor);
            btnGuardar.setEnabled(true);
            setTfEdit(true);
            loadTextFields();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void eliminarActionPerformed() {
        try {
            Proveedor temp = getProveedorSelect();
            int sel = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
            if(sel == JOptionPane.YES_OPTION){
                try {
                    if(proveedorDAO.delete(temp))
                        JOptionPane.showMessageDialog(null, "Proveedor eliminado!");
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    ptm.updateTable();
                    ptm.fireTableDataChanged();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarActionPerformed() {
        if(!isEmpty()){
            try {
                saveTextFields();
                Proveedor temp = getUnProveedor();
                if(temp.getID_Proveedor() == 0)
                    proveedorDAO.crear(temp);
                else{
                    proveedorDAO.update(temp);
                }
                
                setUnProveedor(null);
                setTfEdit(false);
                loadTextFields();
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(false);
                tablaProveedores.clearSelection();
                ptm.updateTable();
                ptm.fireTableDataChanged();
                
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }                                          

    private void cancelarActionPerformed() {                                            
        setUnProveedor(null);
        setTfEdit(false);
        loadTextFields();
        tablaProveedores.clearSelection();
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }                                                                                    

    private void nuevoActionPerformed() {
        setUnProveedor(null);
        loadTextFields();
        setTfEdit(true);
        tablaProveedores.clearSelection();
        proveedorVista.getTxtNombre().requestFocusInWindow();
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }
    
    private Proveedor getProveedorSelect() throws SQLException {
        int select = (int) tablaProveedores.getValueAt(tablaProveedores.getSelectedRow(),0);
        return proveedorDAO.readByID(select);
    }
    
    private boolean isEmpty(){
        boolean isEmpty = false;
        if(proveedorVista.getTxtNombre().getText().equals("") ||
                proveedorVista.getTxtDireccion().getText().equals("") ||
                proveedorVista.getTxtTelefono().getText().equals("") ||
                proveedorVista.getTxtWeb().getText().equals("")) {
            isEmpty = true;
        }
        return isEmpty;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btnModificar)
            modificarActionPerformed();
        else if(source == btnNuevo)
            nuevoActionPerformed();
        else if(source == btnEliminar)
            eliminarActionPerformed();
        else if(source == btnGuardar)
            guardarActionPerformed();
        else if (source == btnCancelar)
            cancelarActionPerformed();
        
    }
    
    public Proveedor getUnProveedor() {
        return unProveedor;
    }

    public void setUnProveedor(Proveedor unProveedor) {
        this.unProveedor = unProveedor;
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
        proveedorVista.getTxtNombre().setEnabled(tfEdit);
        proveedorVista.getTxtDireccion().setEnabled(tfEdit);
        proveedorVista.getTxtTelefono().setEnabled(tfEdit);
        proveedorVista.getTxtWeb().setEnabled(tfEdit);
    }
}
