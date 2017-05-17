
package Controlador;

import Modelo.Articulo;
import Modelo.Compra;
import Modelo.DAO.ArticuloDAO;
import Modelo.DAO.CompraDAO;
import Modelo.DAO.DAOManager;
import Modelo.DAO.DetalleCompraDAO;
import Modelo.DetalleCompra;
import Modelo.Ticket;
import SQL.BD_Conexion;
import Vista.Reportes.frmProdsCat;
import Vista.Reportes.frmVentas;
import Vista.VentasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Javicuc
 */
public class CompraController implements ActionListener{
    
    private VentasView       vistaVentas;
    private CompraDAO        compraManger;
    private DetalleCompraDAO detalleManager;
    private ArticuloDAO      articuloManager;
    private boolean tfEdit;
    private int cantidad;
            
    private Ticket  objTicket;
    private Compra  objCompra;
    private Articulo objArticulo;
    private DetalleCompra objDetalle;
    
    private JButton btAgregar;
    private JButton btBuscarProd;
    private JButton btCobrar;
    private JButton btEliminarProd;
    private JButton btImprimir;
    private JButton btProdComun;
    private JButton btVenta;
    private JButton btVentasDia;
    private JTable  tablaTicket;
    private JTextField tfBuscar;
    private JTextField tfCambio;
    private JTextField tfCantidadProds;
    private JTextField tfEfectivo;
    private JTextField tfTotalFinal;
    private JTextField tfTotalTabla;
    private CompraTableModel compraTableModel;
    
    public CompraController(VentasView view) throws SQLException{
        this.vistaVentas     = view;
        this.articuloManager = new DAOManager().getArticuloDAO();
        this.compraManger    = new DAOManager().getCompraDAO();
        this.detalleManager  = new DAOManager().getDetalleCompraDAO();
        
        
        this.compraTableModel = new CompraTableModel(detalleManager);
        this.tablaTicket      = vistaVentas.getTablaTicket();
        this.tablaTicket.setModel(compraTableModel);
        
        this.tfBuscar = vistaVentas.getTfBuscar();
        this.tfCambio = vistaVentas.getTfCambio();
        this.tfCantidadProds = vistaVentas.getTfCantidadProds();
        this.tfEfectivo = vistaVentas.getTfEfectivo();
        this.tfTotalFinal = vistaVentas.getTfTotalFinal();
        this.tfTotalTabla = vistaVentas.getTfTotalTabla();
        
        this.btAgregar        = vistaVentas.getBtAgregar();
        this.btBuscarProd     = vistaVentas.getBtBuscarProd();
        this.btCobrar         = vistaVentas.getBtCobrar();
        this.btEliminarProd   = vistaVentas.getBtEliminarProd();
        this.btImprimir       = vistaVentas.getBtImprimir();
        this.btProdComun      = vistaVentas.getBtProdComun();
        this.btVentasDia      = vistaVentas.getBtVentasDia();
        
        this.btAgregar.addActionListener(this);
        this.btBuscarProd.addActionListener(this);
        this.btCobrar.addActionListener(this);
        this.btEliminarProd.addActionListener(this);
        this.btImprimir.addActionListener(this);
        this.btProdComun.addActionListener(this);
        this.btVentasDia.addActionListener(this);
        
         this.tablaTicket.getSelectionModel().addListSelectionListener(c ->{
            boolean isSelect = (tablaTicket.getSelectedRow() != -1);
            btEliminarProd.setEnabled(isSelect);
            tfCantidadProds.setText(String.valueOf(compraTableModel.getRowCount()));
        }); 
    }
    
    
    private DetalleCompra getDetalleSelect() throws SQLException{
        int select = (int) tablaTicket.getValueAt(tablaTicket.getSelectedRow(),1);
        return detalleManager.raadByID(select);
    }      
    
    public void agregarArticuloPerformed() throws SQLException{
        if(this.tfBuscar.getText() != null){
            objArticulo = articuloManager.readByCodigo(this.tfBuscar.getText());
            if(objArticulo != null){
                if(objCompra == null){
                    objCompra = new Compra(new Timestamp(System.currentTimeMillis()));
                    compraManger.crear(objCompra);
                }
                this.cantidad = 1;
                objCompra  = compraManger.getLast();
                objDetalle = new DetalleCompra(objCompra.getID_Compra(), objArticulo.getID_Articulo(), cantidad, objArticulo.getCosto() * 1);
                detalleManager.crear(objDetalle);
                this.compraTableModel.updateTable(objCompra.getID_Compra());
                this.compraTableModel.fireTableDataChanged();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Articulo no encontrado!");
    }
    public void cobrarPerformed() throws SQLException{
        if(compraTableModel.getRowCount() > 0){
            imprimirTicket(this.objCompra.getID_Compra());
            this.objCompra = null;
            tablaTicket.clearSelection();
            compraTableModel.updateTable(0);
            compraTableModel.fireTableDataChanged();
        }else{
            JOptionPane.showMessageDialog(null, "Genere una venta!");
        }
            
    }
    public void buscarPerformed(){
        
    }
    private void eliminarPerformed() {
        try {
            DetalleCompra temp = getDetalleSelect();
            int sel = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
            if(sel == JOptionPane.YES_OPTION){
                try {
                    if(detalleManager.delete(temp))
                        JOptionPane.showMessageDialog(null, "Articulo eliminado!");
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    compraTableModel.updateTable(this.objCompra.getID_Compra());
                    compraTableModel.fireTableDataChanged();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirPerformed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ventaPerformed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void prodComunPerformed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ventasDiaPerformed() {
        new frmVentas(BD_Conexion.getInstance());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btAgregar){
            try {
                agregarArticuloPerformed();
            } catch (SQLException ex) {
                Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(source == btCobrar){
            try {
                cobrarPerformed();
            } catch (SQLException ex) {
                Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(source == btBuscarProd)
            buscarPerformed();
        else if(source == btEliminarProd)
            eliminarPerformed();
        else if(source == btImprimir)
            imprimirPerformed();
        else if(source == btVenta)
            ventaPerformed();
        else if(source == btProdComun)
            prodComunPerformed();
        else if(source == btVentasDia)
            ventasDiaPerformed();
    }
    
    private void imprimirTicket(int id) {
        File miDir = new File (".");
        try{
            String archivo = miDir.getCanonicalPath() + "/src/Vista/Reportes/Ticket.jasper";
            Map parametro = new HashMap();
            parametro.put("idCompra", id);
            JasperPrint  jp = JasperFillManager.fillReport(archivo,parametro,BD_Conexion.getInstance());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.setTitle("Ticket");
        } catch (JRException ex) {
            Logger.getLogger(frmProdsCat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmProdsCat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isTfEdit() {
        return tfEdit;
    }

    public void setTfEdit(boolean tfEdit) {
        this.tfEdit = tfEdit;
    }

    public Ticket getObjTicket() {
        return objTicket;
    }

    public void setObjTicket(Ticket objTicket) {
        this.objTicket = objTicket;
    }

    public Compra getObjCompra() {
        return objCompra;
    }

    public void setObjCompra(Compra objCompra) {
        this.objCompra = objCompra;
    }

    public DetalleCompra getObjDetalle() {
        return objDetalle;
    }

    public void setObjDetalle(DetalleCompra objDetalle) {
        this.objDetalle = objDetalle;
    }

    public Articulo getObjArticulo() {
        return objArticulo;
    }

    public void setObjArticulo(Articulo objArticulo) {
        this.objArticulo = objArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
