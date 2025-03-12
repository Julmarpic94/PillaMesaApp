package Vistas;

import Controlador.ControladorMesas;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class VistaMesas extends javax.swing.JPanel {

    private ControladorMesas controlador;
    private Object[][] datos;

    public VistaMesas() {
        initComponents();

        controlador = new ControladorMesas();
        datos = controlador.obtenerDatosMesas();
        cargarDatosTabla(datos);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        txfCapacidad = new javax.swing.JTextField();
        labelId = new javax.swing.JLabel();
        txfId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        rbtnDisponible = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestionar Mesas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        labelNombre.setText("Capadidad");

        txfCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCapacidadActionPerformed(evt);
            }
        });

        labelId.setText("Numero:");

        txfId.setEditable(false);
        txfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIdActionPerformed(evt);
            }
        });

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaReservas);

        rbtnDisponible.setText("Disponible");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelId)
                                .addGap(18, 18, 18)
                                .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(labelNombre)
                                .addGap(18, 18, 18)
                                .addComponent(txfCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnDisponible))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txfCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelId)
                    .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnDisponible))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txfId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Selecciona una mesa primero.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = Integer.parseInt(txfId.getText().trim());
        int capacidad = Integer.parseInt(txfCapacidad.getText().trim());
        boolean disponible = rbtnDisponible.isSelected();

        controlador.actualizarMesa(id, capacidad, disponible);
        JOptionPane.showMessageDialog(this, "Mesa actualizada correctamente.");
        cargarDatosTabla(controlador.obtenerDatosMesas());
        limpiarCampos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        int capacidad;
        try {
            capacidad = Integer.parseInt(txfCapacidad.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "⚠️ Ingresa una capacidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean disponible = rbtnDisponible.isSelected();
        controlador.insertarMesa(capacidad, disponible);
        JOptionPane.showMessageDialog(this, "✅ Mesa insertada correctamente.");
        cargarDatosTabla(controlador.obtenerDatosMesas());
        limpiarCampos();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txfId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Selecciona una mesa para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = Integer.parseInt(txfId.getText().trim());
        controlador.eliminarMesa(id);
        JOptionPane.showMessageDialog(this, "✅ Mesa eliminada correctamente.");
        cargarDatosTabla(controlador.obtenerDatosMesas());
        limpiarCampos();


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdActionPerformed

    private void txfCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCapacidadActionPerformed

    private void tablaReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReservasMouseClicked
        int fila = tablaReservas.getSelectedRow();
        if (fila == -1) {
            return;
        }

        txfId.setText(tablaReservas.getValueAt(fila, 0).toString());
        txfCapacidad.setText(tablaReservas.getValueAt(fila, 1).toString());
        rbtnDisponible.setSelected("Sí".equals(tablaReservas.getValueAt(fila, 2).toString()));
    }//GEN-LAST:event_tablaReservasMouseClicked

    public void cargarDatosTabla(Object[][] datos) {
        String[] columnas = {"Número", "Capacidad", "Disponible"};
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaReservas.setModel(modelo);
    }

    private void limpiarCampos() {
        txfId.setText("");
        txfCapacidad.setText("");
        rbtnDisponible.setSelected(false);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JRadioButton rbtnDisponible;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTextField txfCapacidad;
    private javax.swing.JTextField txfId;
    // End of variables declaration//GEN-END:variables
}
