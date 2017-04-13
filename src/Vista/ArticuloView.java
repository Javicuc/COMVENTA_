/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ArticuloController;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

/**
 *
 * @author Javicuc
 */
public class ArticuloView extends javax.swing.JFrame {

    DatePickerSettings dateSettings;
    private ArticuloController controller;
    private Dimension d;
    
    public ArticuloView() throws SQLException {
        initComponents();
        this.dateSettings = new DatePickerSettings();
        this.dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
        this.dateSettings.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");
        this.dpCaducidad.setSettings(dateSettings);
        this.d = Toolkit.getDefaultToolkit().getScreenSize(); 
        this.setLocation(d.width/2-this.getSize().width/2, d.height/2-this.getSize().height/2);
        this.setResizable(false);
        this.controller = new ArticuloController(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableArticulos = new javax.swing.JTable();
        tfNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCosto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        tfCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dpCaducidad = new com.github.lgooddatepicker.components.DatePicker();
        jToolBar1 = new javax.swing.JToolBar();
        btNuevo = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableArticulos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableArticulos);

        tfNombre.setEnabled(false);

        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        taDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(taDescripcion);

        jLabel1.setText("Nombre");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Costo");

        tfCosto.setEnabled(false);

        jLabel4.setText("Caducidad");

        jLabel5.setText("Categoria");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCategoria.setEnabled(false);

        tfCodigo.setEnabled(false);

        jLabel6.setText("Codigo");

        dpCaducidad.setEnabled(false);
        dpCaducidad.setRequestFocusEnabled(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btNuevo.setText("NUEVO");
        btNuevo.setFocusable(false);
        btNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btNuevo);

        btModificar.setText("MODIFICAR");
        btModificar.setEnabled(false);
        btModificar.setFocusable(false);
        btModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btModificar);

        btGuardar.setText("GUARDAR");
        btGuardar.setEnabled(false);
        btGuardar.setFocusable(false);
        btGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btGuardar);

        btEliminar.setText("ELIMINAR");
        btEliminar.setEnabled(false);
        btEliminar.setFocusable(false);
        btEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btEliminar);

        btCancelar.setText("CANCELAR");
        btCancelar.setEnabled(false);
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(dpCaducidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbCategoria, jLabel1, jLabel3, jLabel4, jLabel5, jLabel6, tfCodigo, tfCosto, tfNombre});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbCategoria, dpCaducidad, tfCodigo, tfCosto, tfNombre});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btNuevo;
    private javax.swing.JComboBox<String> cbCategoria;
    private com.github.lgooddatepicker.components.DatePicker dpCaducidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextArea taDescripcion;
    private javax.swing.JTable tableArticulos;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCosto;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables


    /**
     * @return the controller
     */
    public ArticuloController getController() {
        return controller;
    }

    /**
     * @return the btAgregar
     */
    public javax.swing.JButton getBtNuevo() {
        return btNuevo;
    }

    /**
     * @return the btEliminar
     */
    public javax.swing.JButton getBtEliminar() {
        return btEliminar;
    }

    /**
     * @return the btModificar
     */
    public javax.swing.JButton getBtModificar() {
        return btModificar;
    }

    /**
     * @return the cbCategoria
     */
    public javax.swing.JComboBox<String> getCbCategoria() {
        return cbCategoria;
    }

    /**
     * @return the taDescripcion
     */
    public javax.swing.JTextArea getTaDescripcion() {
        return taDescripcion;
    }

    /**
     * @return the tableArticulos
     */
    public javax.swing.JTable getTableArticulos() {
        return tableArticulos;
    }
    /**
     * @return the tfCosto
     */
    public javax.swing.JTextField getTfCosto() {
        return tfCosto;
    }

    /**
     * @return the tfNombre
     */
    public javax.swing.JTextField getTfNombre() {
        return tfNombre;
    }

    /**
     * @return the tfCodigo
     */
    public javax.swing.JTextField getTfCodigo() {
        return tfCodigo;
    }

    /**
     * @return the btGuardar
     */
    public javax.swing.JButton getBtGuardar() {
        return btGuardar;
    }

    /**
     * @return the btCancelar
     */
    public javax.swing.JButton getBtCancelar() {
        return btCancelar;
    }

    /**
     * @return the dpCaducidad
     */
    public com.github.lgooddatepicker.components.DatePicker getDpCaducidad() {
        return dpCaducidad;
    }
}
