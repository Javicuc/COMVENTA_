/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Empleado;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Javicuc
 */
public class MainView extends javax.swing.JFrame {

    private Empleado empleadoActual; 
    
    public MainView(Empleado actual) {
        ImageIcon img = new ImageIcon("Images/logo.png");
        setUndecorated(true);
        setResizable(true);
        setVisible(true);
        this.empleadoActual = actual;
        initComponents();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        
        this.setSize(xsize,ysize);
        LBL_Icon.setIcon(img);
        LBL_Icon.setHorizontalAlignment(JLabel.CENTER);
        LBL_Icon.setVerticalAlignment(JLabel.CENTER);
        lblUser.setText(getEmpleadoActual().getNombre());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBL_Icon = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btVentas = new javax.swing.JButton();
        btProductos = new javax.swing.JButton();
        btClientes = new javax.swing.JButton();
        btProveedores = new javax.swing.JButton();
        btEmpleados = new javax.swing.JButton();
        btInventario = new javax.swing.JButton();
        btReportes = new javax.swing.JButton();
        btCorte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelViews = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        btSession = new javax.swing.JButton();
        btConfiguracion = new javax.swing.JButton();
        btExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btVentas.setText("VENTAS");
        btVentas.setFocusable(false);
        btVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVentasActionPerformed(evt);
            }
        });
        jToolBar1.add(btVentas);

        btProductos.setText("PRODUCTOS");
        btProductos.setFocusable(false);
        btProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProductosActionPerformed(evt);
            }
        });
        jToolBar1.add(btProductos);

        btClientes.setText("CLIENTES");
        btClientes.setFocusable(false);
        btClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });
        jToolBar1.add(btClientes);

        btProveedores.setText("PROVEEDORES");
        btProveedores.setFocusable(false);
        btProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProveedoresActionPerformed(evt);
            }
        });
        jToolBar1.add(btProveedores);

        btEmpleados.setText("EMPLEADOS");
        btEmpleados.setFocusable(false);
        btEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpleadosActionPerformed(evt);
            }
        });
        jToolBar1.add(btEmpleados);

        btInventario.setText("INVENTARIO");
        btInventario.setFocusable(false);
        btInventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btInventario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInventarioActionPerformed(evt);
            }
        });
        jToolBar1.add(btInventario);

        btReportes.setText("REPORTES");
        btReportes.setFocusable(false);
        btReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btReportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReportesActionPerformed(evt);
            }
        });
        jToolBar1.add(btReportes);

        btCorte.setText("CORTE");
        btCorte.setFocusable(false);
        btCorte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCorte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btCorte);

        panelViews.setLayout(new javax.swing.OverlayLayout(panelViews));
        jScrollPane1.setViewportView(panelViews);

        lblUser.setText("Usuario:");

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btSession.setText("CERRAR");
        btSession.setFocusable(false);
        btSession.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSession.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btSession);

        btConfiguracion.setText("CONFIGURACION");
        btConfiguracion.setFocusable(false);
        btConfiguracion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btConfiguracion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfiguracionActionPerformed(evt);
            }
        });
        jToolBar2.add(btConfiguracion);

        btExit.setText("SALIR");
        btExit.setFocusable(false);
        btExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        jToolBar2.add(btExit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(LBL_Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(594, 594, 594)
                        .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProductosActionPerformed
        ArticuloView viewArticulo = null;
        try {
           viewArticulo  = new ArticuloView();
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelViews.removeAll();
        panelViews.updateUI();
        viewArticulo.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panelViews.add(viewArticulo.getContentPane(),BorderLayout.CENTER);
        
    }//GEN-LAST:event_btProductosActionPerformed

    private void btProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProveedoresActionPerformed
        ProveedoresView view = null;
        try {
           view  = new ProveedoresView();
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelViews.removeAll();
        panelViews.updateUI();
        view.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panelViews.add(view.getContentPane(),BorderLayout.CENTER);
        
    }//GEN-LAST:event_btProveedoresActionPerformed

    private void btEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpleadosActionPerformed
        EmpleadoView view = null;
        try {
           view  = new EmpleadoView();
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelViews.removeAll();
        panelViews.updateUI();
        view.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panelViews.add(view.getContentPane(),BorderLayout.CENTER);
        
    }//GEN-LAST:event_btEmpleadosActionPerformed

    private void btInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btInventarioActionPerformed

    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        ClientesView view = null;
        try {
            view = new ClientesView();
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelViews.removeAll();
        panelViews.updateUI();
        view.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panelViews.add(view.getContentPane(),BorderLayout.CENTER);
        
    }//GEN-LAST:event_btClientesActionPerformed

    private void btConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfiguracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btConfiguracionActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

    private void btVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVentasActionPerformed
        VentasView view = null;
        try {
            view = new VentasView(getEmpleadoActual());
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelViews.removeAll();
        panelViews.updateUI();
        view.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panelViews.add(view.getContentPane(),BorderLayout.CENTER);
        view.setEmpActual(empleadoActual);
    }//GEN-LAST:event_btVentasActionPerformed

    private void btReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReportesActionPerformed
        ReportesView view = null;
        view = new ReportesView();
        panelViews.removeAll();
        panelViews.updateUI();
        view.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panelViews.add(view.getContentPane(),BorderLayout.CENTER);    
    
    }//GEN-LAST:event_btReportesActionPerformed

    public Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    public void setEmpleadoActual(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBL_Icon;
    private javax.swing.JButton btClientes;
    private javax.swing.JButton btConfiguracion;
    private javax.swing.JButton btCorte;
    private javax.swing.JButton btEmpleados;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btInventario;
    private javax.swing.JButton btProductos;
    private javax.swing.JButton btProveedores;
    private javax.swing.JButton btReportes;
    private javax.swing.JButton btSession;
    private javax.swing.JButton btVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelViews;
    // End of variables declaration//GEN-END:variables
}
