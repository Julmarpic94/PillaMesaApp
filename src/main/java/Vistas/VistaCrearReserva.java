package Vistas;

import Controlador.ControladorClientes;
import Controlador.ControladorMesas;
import Modelos.Reserva;
import Servicios.ReservaServicio;
import java.awt.HeadlessException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

public class VistaCrearReserva extends javax.swing.JPanel {

    private DefaultTableModel dtmClientes, dtmMesas;
    private ControladorClientes controladorClientes;
    private ControladorMesas controladorMesas;
    private ReservaServicio servicio;
    private Reserva reserva;

    Object[][] datosClientes, datosMesas;

    public VistaCrearReserva() {
        initComponents();

        controladorClientes = new ControladorClientes();
        controladorMesas = new ControladorMesas();
        servicio = new ReservaServicio();

        datosClientes = controladorClientes.obtenerDatosClientes();
        datosMesas = controladorMesas.obtenerDatosMesas();

        cargarDatosClientes(datosClientes);
        cargarDatosMesas(datosMesas);
        cargarCamareros();

        configurarSpinnerFecha();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        labelTelef = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        txfId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMesas = new javax.swing.JTable();
        spnFecha = new javax.swing.JSpinner();
        cmbHora = new javax.swing.JComboBox<>();
        labelCama = new javax.swing.JLabel();
        cmbCamarero = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crear Reserva");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(528, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnReservar.setText("Hacer Reserva");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNombre.setText("Fecha:");

        labelTelef.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTelef.setText("Hora: ");

        labelId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelId.setText("Reserva: ");

        txfId.setEditable(false);
        txfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIdActionPerformed(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        tablaMesas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaMesas);

        spnFecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1752339240000L), new java.util.Date(1752339240000L), new java.util.Date(1817071200000L), java.util.Calendar.DAY_OF_MONTH));

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- --", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "-- --", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", " " }));

        labelCama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCama.setText("Camarero:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReservar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelNombre)
                                .addGap(18, 18, 18)
                                .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelTelef, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelCama)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCamarero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(labelTelef)
                    .addComponent(labelId)
                    .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCama)
                    .addComponent(cmbCamarero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnReservar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        realizarReserva();

    }//GEN-LAST:event_btnReservarActionPerformed

    private void txfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked


    }//GEN-LAST:event_tablaClientesMouseClicked
    public void cargarDatosClientes(Object[][] datos) {
        String[] columnasClientes = {"ID", "Nombre", "Teléfono", "Email"};
        dtmClientes = new DefaultTableModel(datos, columnasClientes);
        tablaClientes.setModel(dtmClientes);
    }

    public void cargarDatosMesas(Object[][] datos) {
        String[] columnasMesas = {"Número", "Capacidad", "Disponibilidad"};
        dtmMesas = new DefaultTableModel(datos, columnasMesas);
        tablaMesas.setModel(dtmMesas);
    }

    public void configurarSpinnerFecha() {

        SpinnerDateModel datemodel = new SpinnerDateModel();
        spnFecha.setModel(datemodel);

        // Configurar el formato de la fecha como "yyyy-MM-dd"
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnFecha, "yyyy-MM-dd");
        spnFecha.setEditor(dateEditor);

        spnFecha.setValue(java.util.Date.from(LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()));
    }

    public String getClienteSeleccionado() {
        int fila = tablaClientes.getSelectedRow();
        if (fila != -1) {
            Object valor = dtmClientes.getValueAt(fila, 0);
            return valor != null ? valor.toString() : null; // ✅ Conversión segura
        }
        return null;
    }

    public String getMesaSeleccionada() {
        int fila = tablaMesas.getSelectedRow();
        if (fila != -1) {
            Object valor = dtmMesas.getValueAt(fila, 0);
            return valor != null ? valor.toString() : null; // ✅ Conversión segura
        }
        return null;
    }

    public String getNombreCliente() {
        int fila = tablaClientes.getSelectedRow();
        if (fila != -1) {
            Object valor = dtmClientes.getValueAt(fila, 1); // ✅ Acceder a la tabla correcta
            return valor != null ? valor.toString() : null; // ✅ Conversión segura
        }
        return null;
    }

    private void realizarReserva() {
        String clienteStr = getClienteSeleccionado();
        String mesaStr = getMesaSeleccionada();
        String nombreCliente = getNombreCliente();
        String camareroStr = (String) cmbCamarero.getSelectedItem(); // Obtener el camarero seleccionado

        // Validar selección de cliente y mesa
        if (clienteStr == null || mesaStr == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente y una mesa.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar selección de camarero
        if (camareroStr == null || camareroStr.equals("-- Seleccione un camarero --")) {
            JOptionPane.showMessageDialog(this, "Seleccione un camarero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer clienteId = Integer.valueOf(clienteStr);
        Integer mesaNumero = Integer.valueOf(mesaStr);
        Integer usuarioId = Integer.valueOf(camareroStr); // Convertir el ID del camarero a Integer

        // ✅ Verificar si la fecha es válida
        Object fechaObj = spnFecha.getValue();
        LocalDate fecha = null;
        if (fechaObj instanceof java.util.Date) {
            fecha = ((java.util.Date) fechaObj).toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
        } else {
            JOptionPane.showMessageDialog(this, "Fecha seleccionada no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ✅ Verificar si la hora es válida
        String horaSeleccionada = (String) cmbHora.getSelectedItem();
        if (horaSeleccionada.equals("-- --")) {
            JOptionPane.showMessageDialog(this, "Seleccione una hora válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LocalTime hora;
        try {
            hora = LocalTime.parse(horaSeleccionada, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Formato de hora inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear reserva con los valores obtenidos
        reserva = new Reserva(clienteId, mesaNumero, usuarioId, fecha, hora);

        try {
            servicio.insertar(reserva);
            JOptionPane.showMessageDialog(this, "✅ Reserva realizada con éxito para el cliente: " + nombreCliente);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "❌ Error al insertar la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void cargarCamareros() {
        cmbCamarero.removeAllItems();
        cmbCamarero.addItem("--Seleciona un Camarero--");

        // Obtener los datos de los usuarios (camareros)
        Object[][] datosUsuarios = obtenerUsuarios();

        if (datosUsuarios != null) {
            for (Object[] usuario : datosUsuarios) {
                cmbCamarero.addItem(usuario[0].toString()); // Agregar el ID del usuario
            }
        } else {
            System.err.println("❌ Error: No se encontraron usuarios.");
        }
    }

    private Object[][] obtenerUsuarios() {
        Servicios.UsuarioServicio usuarioServicio = new Servicios.UsuarioServicio();
        return usuarioServicio.obtenerTodosLosUsuarios();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> cmbCamarero;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCama;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelef;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaMesas;
    private javax.swing.JTextField txfId;
    // End of variables declaration//GEN-END:variables
}
