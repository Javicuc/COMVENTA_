/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CompraController;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author javilubz
 */
public class VentasView extends javax.swing.JFrame {

    private CompraController controller;
            
    public VentasView() throws SQLException {
        initComponents();
        this.setResizable(false);
        this.controller = new CompraController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        btAgregar = new javax.swing.JButton();
        tfBuscar = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btProdComun = new javax.swing.JButton();
        btBuscarProd = new javax.swing.JButton();
        btEliminarProd = new javax.swing.JButton();
        btVentasDia = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTicket = new javax.swing.JTable();
        btCobrar = new javax.swing.JButton();
        tfTotalTabla = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfCantidadProds = new javax.swing.JTextField();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        tfTotalFinal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfCambio = new javax.swing.JTextField();
        tfEfectivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();

        jLabel8.setText("jLabel6");

        jTextField6.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CODIGO DEL PRODUCTO:");

        btAgregar.setText("AGREGAR PRODUCTO");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btProdComun.setText("PRODUCTO COMUN");
        btProdComun.setFocusable(false);
        btProdComun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btProdComun.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btProdComun);

        btBuscarProd.setText("BUSCAR PRODUCTO");
        btBuscarProd.setEnabled(false);
        btBuscarProd.setFocusable(false);
        btBuscarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBuscarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btBuscarProd);

        btEliminarProd.setText("ELIMINAR PRODUCTO");
        btEliminarProd.setEnabled(false);
        btEliminarProd.setFocusable(false);
        btEliminarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEliminarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btEliminarProd);

        btVentasDia.setText("VENTAS DEL DIA");
        btVentasDia.setFocusable(false);
        btVentasDia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btVentasDia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btVentasDia);

        tablaTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaTicket);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("TICKET", jPanel1);

        btCobrar.setText("COBRAR");

        tfTotalTabla.setEditable(false);
        tfTotalTabla.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTotalTabla.setText("0.0");
        tfTotalTabla.setToolTipText("");

        jLabel2.setText("PRODUCTOS EN TICKET");

        tfCantidadProds.setEditable(false);
        tfCantidadProds.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCantidadProds.setText("0");
        tfCantidadProds.setToolTipText("");
        tfCantidadProds.setEnabled(false);
        tfCantidadProds.setFocusable(false);

        tfTotalFinal.setEditable(false);
        tfTotalFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTotalFinal.setText("0.0");

        jLabel3.setText("TOTAL");

        jLabel5.setText("CAMBIO");

        tfCambio.setEditable(false);
        tfCambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCambio.setText("0.0");
        tfCambio.setToolTipText("");

        tfEfectivo.setEditable(false);
        tfEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEfectivo.setText("0.0");
        tfEfectivo.setToolTipText("");

        jLabel4.setText("EFECTIVO");

        jDesktopPane2.setLayer(tfTotalFinal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(tfCambio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(tfEfectivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tfCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfCambio, tfEfectivo, tfTotalFinal});

        jDesktopPane2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, jLabel5});

        btImprimir.setText("IMPRIMIR");
        btImprimir.setEnabled(false);

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(tfBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btCobrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(tfTotalTabla, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(tfCantidadProds, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDesktopPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btImprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(tfCantidadProds, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotalTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTotalTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCantidadProds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btImprimir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAgregar, jLabel1, tfBuscar});

        jDesktopPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCobrar, tfTotalTabla});

        jDesktopPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, tfCantidadProds});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btBuscarProd;
    private javax.swing.JButton btCobrar;
    private javax.swing.JButton btEliminarProd;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btProdComun;
    private javax.swing.JButton btVentasDia;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaTicket;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField tfCambio;
    private javax.swing.JTextField tfCantidadProds;
    private javax.swing.JTextField tfEfectivo;
    private javax.swing.JTextField tfTotalFinal;
    private javax.swing.JTextField tfTotalTabla;
    // End of variables declaration//GEN-END:variables

    public JButton getBtAgregar() {
        return btAgregar;
    }

    public void setBtAgregar(JButton btAgregar) {
        this.btAgregar = btAgregar;
    }

    public JButton getBtBuscarProd() {
        return btBuscarProd;
    }

    public void setBtBuscarProd(JButton btBuscarProd) {
        this.btBuscarProd = btBuscarProd;
    }

    public JButton getBtCobrar() {
        return btCobrar;
    }

    public void setBtCobrar(JButton btCobrar) {
        this.btCobrar = btCobrar;
    }

    public JButton getBtEliminarProd() {
        return btEliminarProd;
    }

    public void setBtEliminarProd(JButton btEliminarProd) {
        this.btEliminarProd = btEliminarProd;
    }

    public JButton getBtImprimir() {
        return btImprimir;
    }

    public void setBtImprimir(JButton btImprimir) {
        this.btImprimir = btImprimir;
    }

    public JButton getBtProdComun() {
        return btProdComun;
    }

    public void setBtProdComun(JButton btProdComun) {
        this.btProdComun = btProdComun;
    }

    public JButton getBtVentasDia() {
        return btVentasDia;
    }

    public void setBtVentasDia(JButton btVentasDia) {
        this.btVentasDia = btVentasDia;
    }

    public JTable getTablaTicket() {
        return tablaTicket;
    }

    public void setTablaTicket(JTable tablaTicket) {
        this.tablaTicket = tablaTicket;
    }

    public JTextField getTfBuscar() {
        return tfBuscar;
    }

    public void setTfBuscar(JTextField tfBuscar) {
        this.tfBuscar = tfBuscar;
    }

    public JTextField getTfCambio() {
        return tfCambio;
    }

    public void setTfCambio(JTextField tfCambio) {
        this.tfCambio = tfCambio;
    }

    public JTextField getTfCantidadProds() {
        return tfCantidadProds;
    }

    public void setTfCantidadProds(JTextField tfCantidadProds) {
        this.tfCantidadProds = tfCantidadProds;
    }

    public JTextField getTfEfectivo() {
        return tfEfectivo;
    }

    public void setTfEfectivo(JTextField tfEfectivo) {
        this.tfEfectivo = tfEfectivo;
    }

    public JTextField getTfTotalFinal() {
        return tfTotalFinal;
    }

    public void setTfTotalFinal(JTextField tfTotalFinal) {
        this.tfTotalFinal = tfTotalFinal;
    }

    public JTextField getTfTotalTabla() {
        return tfTotalTabla;
    }

    public void setTfTotalTabla(JTextField tfTotalTabla) {
        this.tfTotalTabla = tfTotalTabla;
    }

    
}
