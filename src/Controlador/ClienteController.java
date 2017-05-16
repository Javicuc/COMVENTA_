/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Modelo.DAO.DAOManager;
import Vista.ClientesView;
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
public class ClienteController implements ActionListener{
    
    private boolean      tfEdit;
    private Cliente      unObj;
    private ClienteDAO   objDAO;
    private ClientesView objVista;
    
    private ClienteTableModel tableModel;
    private JTable            tabla;
    
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnCancelar;
    
    public ClienteController(ClientesView vista) throws SQLException {
        this.objDAO = new DAOManager().getClienteDAO();
        this.objVista = vista;
        
        this.tableModel = new ClienteTableModel(objDAO);
        this.tableModel.updateTable();
        this.tabla = objVista.getTableClientes();
        this.tabla.setModel(tableModel);
        
        this.btnNuevo     = objVista.getBtNuevo();
        this.btnEliminar  = objVista.getBtEliminar();
        this.btnModificar = objVista.getBtModificar();
        this.btnGuardar   = objVista.getBtGuardar();
        this.btnCancelar  = objVista.getBtCancelar();
        this.btnNuevo.addActionListener(this);
        this.btnModificar.addActionListener(this);
        this.btnEliminar.addActionListener(this);
        this.btnGuardar.addActionListener(this);
        this.btnCancelar.addActionListener(this);
        this.tabla.getSelectionModel().addListSelectionListener(c ->{
            boolean isSelect = (tabla.getSelectedRow() != -1);
            btnModificar.setEnabled(isSelect);
            btnEliminar.setEnabled(isSelect);
            btnCancelar.setEnabled(isSelect);
        });
    }
    
    public void loadTextFields() {
        if(getUnObj() != null){
            objVista.getTfNombre().setText(getUnObj().getNombre());
            objVista.getTfApellidos().setText(getUnObj().getApellidos());
            objVista.getTfTelefono().setText(getUnObj().getTelefono());
            objVista.getTfDireccion().setText(getUnObj().getDireccion());
            
        } else {
            objVista.getTfNombre().setText("");
            objVista.getTfApellidos().setText("");
            objVista.getTfTelefono().setText("");
            objVista.getTfDireccion().setText("");
        }
    }
    
    private void saveTextFields() {
        if(getUnObj() == null)
            setUnObj(new Cliente());
        getUnObj().setNombre(objVista.getTfNombre().getText());
        getUnObj().setApellidos(objVista.getTfApellidos().getText());
        getUnObj().setTelefono(objVista.getTfTelefono().getText());
        getUnObj().setDireccion(objVista.getTfDireccion().getText());

    }
    
    private void modificarActionPerformed() {                                             
        try {
            Cliente obj = getSelect();
            setUnObj(obj);
            btnGuardar.setEnabled(true);
            setTfEdit(true);
            loadTextFields();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void eliminarActionPerformed() {
        try {
            Cliente temp = getSelect();
            int sel = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
            if(sel == JOptionPane.YES_OPTION){
                try {
                    if(objDAO.delete(temp))
                        JOptionPane.showMessageDialog(null, "Cliente eliminado!");
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    tableModel.updateTable();
                    tableModel.fireTableDataChanged();
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
                Cliente temp = getUnObj();
                if(temp.getID_Cliente() == 0){
                   objDAO.crear(temp);
                   JOptionPane.showMessageDialog(null, "Cliente guardado!");
                } else{
                    objDAO.update(temp);
                    JOptionPane.showMessageDialog(null, "Cliente actualizado!");
                }
                
                setUnObj(null);
                setTfEdit(false);
                loadTextFields();
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(false);
                tabla.clearSelection();
                tableModel.updateTable();
                tableModel.fireTableDataChanged();
                
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }                                          

    private void cancelarActionPerformed() {                                            
        setUnObj(null);
        setTfEdit(false);
        loadTextFields();
        tabla.clearSelection();
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }                                                                                    

    private void nuevoActionPerformed() {
        setUnObj(null);
        loadTextFields();
        setTfEdit(true);
        tabla.clearSelection();
        objVista.getTfNombre().requestFocusInWindow();
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }
    
    private Cliente getSelect() throws SQLException {
        int select = (int) tabla.getValueAt(tabla.getSelectedRow(),0);
        return objDAO.raadByID(select);
    }
    
    private boolean isEmpty(){
        boolean isEmpty = false;
        if(objVista.getTfNombre().getText().equals("") ||
                objVista.getTfApellidos().getText().equals("") ||
                objVista.getTfTelefono().getText().equals("") ||
                objVista.getTfDireccion().getText().equals("")) {
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

    public Cliente getUnObj() {
        return unObj;
    }

    public void setUnObj(Cliente unObj) {
        this.unObj = unObj;
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
        objVista.getTfNombre().setEnabled(tfEdit);
        objVista.getTfApellidos().setEnabled(tfEdit);
        objVista.getTfTelefono().setEnabled(tfEdit);
        objVista.getTfDireccion().setEnabled(tfEdit);
    }
    
}
