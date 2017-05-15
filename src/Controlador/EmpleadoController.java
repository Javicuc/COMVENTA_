/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.DAOManager;
import Modelo.DAO.EmpleadoDAO;
import Modelo.Empleado;
import Vista.EmpleadoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Javicuc
 */
public class EmpleadoController implements ActionListener {
    
    private boolean tfEdit;
    
    private Empleado unEmpleado;
    private EmpleadoDAO empleadoDAO;
    private EmpleadoView empleadoVista;
    
    private EmpleadoTableModel etm;
    private JTable tablaEmpleados;
    
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnCancelar;
    
    public EmpleadoController(EmpleadoView eView) throws SQLException {
        this.empleadoDAO = new DAOManager().getEmpleadoDAO();
        this.empleadoVista = eView;
        
        this.etm = new EmpleadoTableModel(empleadoDAO);
        this.etm.updateTable();
        this.tablaEmpleados = empleadoVista.getTablaEmpleados();
        this.tablaEmpleados.setModel(etm);
        
        this.btnNuevo = empleadoVista.getBtnNuevo();
        this.btnEliminar = empleadoVista.getBtnEliminar();
        this.btnModificar = empleadoVista.getBtnModificar();
        this.btnGuardar = empleadoVista.getBtnGuardar();
        this.btnCancelar = empleadoVista.getBtnCancelar();
        this.btnNuevo.addActionListener(this);
        this.btnModificar.addActionListener(this);
        this.btnEliminar.addActionListener(this);
        this.btnGuardar.addActionListener(this);
        this.btnCancelar.addActionListener(this);
        this.tablaEmpleados.getSelectionModel().addListSelectionListener(c ->{
            boolean isSelect = (tablaEmpleados.getSelectedRow() != -1);
            btnModificar.setEnabled(isSelect);
            btnEliminar.setEnabled(isSelect);
            btnCancelar.setEnabled(isSelect);
        });
    
    }
    
    public void loadTextFields() {
        if(getUnEmpleado() != null){
            empleadoVista.getTxtNombre().setText(getUnEmpleado().getNombre());
            empleadoVista.getTxtApellidos().setText(getUnEmpleado().getApellidos());
            empleadoVista.getTxtTelefono().setText(getUnEmpleado().getTelefono());
            
        } else {
            empleadoVista.getTxtNombre().setText("");
            empleadoVista.getTxtApellidos().setText("");
            empleadoVista.getTxtTelefono().setText("");
        }
    }
    
    private void saveTextFields() {
        if(getUnEmpleado() == null)
            setUnEmpleado(new Empleado());
        getUnEmpleado().setNombre(empleadoVista.getTxtNombre().getText());
        getUnEmpleado().setApellidos(empleadoVista.getTxtApellidos().getText());
        getUnEmpleado().setTelefono(empleadoVista.getTxtTelefono().getText());

    }
    
    private void modificarActionPerformed() {                                             
        try {
            Empleado empleado = getEmpleadoSelect();
            setUnEmpleado(empleado);
            btnGuardar.setEnabled(true);
            setTfEdit(true);
            loadTextFields();
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void eliminarActionPerformed() {
        try {
            Empleado temp = getEmpleadoSelect();
            int sel = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
            if(sel == JOptionPane.YES_OPTION){
                try {
                    if(empleadoDAO.delete(temp))
                        JOptionPane.showMessageDialog(null, "Empleado eliminado!");
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    etm.updateTable();
                    etm.fireTableDataChanged();
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
                Empleado temp = getUnEmpleado();
                if(temp.getID_Empleado() == 0)
                    empleadoDAO.crear(temp);
                else{
                    empleadoDAO.update(temp);
                }
                
                setUnEmpleado(null);
                setTfEdit(false);
                loadTextFields();
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(false);
                tablaEmpleados.clearSelection();
                etm.updateTable();
                etm.fireTableDataChanged();
                
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }                                          

    private void cancelarActionPerformed() {                                            
        setUnEmpleado(null);
        setTfEdit(false);
        loadTextFields();
        tablaEmpleados.clearSelection();
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }                                                                                    

    private void nuevoActionPerformed() {
        setUnEmpleado(null);
        loadTextFields();
        setTfEdit(true);
        tablaEmpleados.clearSelection();
        empleadoVista.getTxtNombre().requestFocusInWindow();
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }
    
    private Empleado getEmpleadoSelect() throws SQLException{
        int select = (int) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),0);
        return empleadoDAO.readByID(select);
    }
    
    private boolean isEmpty(){
        boolean isEmpty = false;
        if(empleadoVista.getTxtNombre().getText().equals("") ||
                empleadoVista.getTxtApellidos().getText().equals("") ||
                empleadoVista.getTxtTelefono().getText().equals("")) {
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
    
    public Empleado getUnEmpleado() {
        return unEmpleado;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }
    private boolean isTfEdit(){
        return tfEdit;
    }
    private void setTfEdit(boolean tfEdit) {
        this.tfEdit = tfEdit;
        empleadoVista.getTxtNombre().setEnabled(tfEdit);
        empleadoVista.getTxtApellidos().setEnabled(tfEdit);
        empleadoVista.getTxtTelefono().setEnabled(tfEdit);
    }
    
}
