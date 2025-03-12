
package Vistas;

import Controlador.ControladorReservas;
import Modelos.Filtro;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author User
 */
public class VistaReservas extends javax.swing.JFrame {

    private ControladorReservas controlador;
    private VistaUsuarios vistaUsuarios;

    public VistaReservas(String rol) {
        initComponents();

        controlador = new ControladorReservas();

        vistaUsuarios = new VistaUsuarios();

        cargarVistas();
        comprobarRol(rol);
        configurarSpinnerFecha();
        chkFecha.setSelected(false);
        labelFiltros.setVisible(false);
        aplicarFiltros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbPanel = new javax.swing.JTabbedPane();
        Reservas = new javax.swing.JPanel();
        jPanelFiltros = new javax.swing.JPanel();
        labelnombre = new javax.swing.JLabel();
        jTFNombreCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbMesa = new javax.swing.JComboBox<>();
        spnFecha = new javax.swing.JSpinner();
        cmbHora = new javax.swing.JComboBox<>();
        btnFiltros = new javax.swing.JToggleButton();
        btnFechaAct = new javax.swing.JButton();
        chkFecha = new javax.swing.JCheckBox();
        labelFiltros = new javax.swing.JLabel();
        tablaReservas = new di_componentetabla.Tabla();
        jPanel1 = new javax.swing.JPanel();
        labelReserva = new javax.swing.JLabel();
        usuarios = new javax.swing.JPanel();
        crearReserva = new javax.swing.JPanel();
        clientes = new javax.swing.JPanel();
        mesas = new javax.swing.JPanel();
        informes = new javax.swing.JPanel();
        ayuda = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelnombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelnombre.setText("Nombre Cliente:");

        jTFNombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getSize()+2f));
        jLabel2.setText("Número Mesa:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Fecha:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Hora:");

        cmbMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- --", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmbMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesaActionPerformed(evt);
            }
        });

        spnFecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1752339240000L), new java.util.Date(1752339240000L), new java.util.Date(1817071200000L), java.util.Calendar.DAY_OF_MONTH));

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- --", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "-- --", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", " " }));

        btnFiltros.setText("Aplicar Filtros");
        btnFiltros.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnFiltrosStateChanged(evt);
            }
        });
        btnFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrosActionPerformed(evt);
            }
        });

        btnFechaAct.setText("Fecha Actual");
        btnFechaAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaActActionPerformed(evt);
            }
        });

        chkFecha.setSelected(true);
        chkFecha.setText("Desactivar Fecha");
        chkFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFechaActionPerformed(evt);
            }
        });

        labelFiltros.setForeground(new java.awt.Color(204, 0, 0));
        labelFiltros.setText("Filtros Aplicados");

        javax.swing.GroupLayout jPanelFiltrosLayout = new javax.swing.GroupLayout(jPanelFiltros);
        jPanelFiltros.setLayout(jPanelFiltrosLayout);
        jPanelFiltrosLayout.setHorizontalGroup(
            jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFNombreCliente)
                    .addComponent(cmbMesa, 0, 106, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(cmbHora, 0, 100, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFechaAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(labelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanelFiltrosLayout.setVerticalGroup(
            jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnombre)
                    .addComponent(jTFNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechaAct)
                    .addComponent(chkFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFiltros)
                        .addComponent(labelFiltros)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        labelReserva.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelReserva.setForeground(new java.awt.Color(255, 255, 255));
        labelReserva.setText("Lista de Reservas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReserva)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ReservasLayout = new javax.swing.GroupLayout(Reservas);
        Reservas.setLayout(ReservasLayout);
        ReservasLayout.setHorizontalGroup(
            ReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablaReservas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ReservasLayout.setVerticalGroup(
            ReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablaReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbPanel.addTab("Reservas", Reservas);

        javax.swing.GroupLayout usuariosLayout = new javax.swing.GroupLayout(usuarios);
        usuarios.setLayout(usuariosLayout);
        usuariosLayout.setHorizontalGroup(
            usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        usuariosLayout.setVerticalGroup(
            usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jtbPanel.addTab("Usuarios", usuarios);

        javax.swing.GroupLayout crearReservaLayout = new javax.swing.GroupLayout(crearReserva);
        crearReserva.setLayout(crearReservaLayout);
        crearReservaLayout.setHorizontalGroup(
            crearReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        crearReservaLayout.setVerticalGroup(
            crearReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jtbPanel.addTab("Crear Reserva", crearReserva);

        javax.swing.GroupLayout clientesLayout = new javax.swing.GroupLayout(clientes);
        clientes.setLayout(clientesLayout);
        clientesLayout.setHorizontalGroup(
            clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        clientesLayout.setVerticalGroup(
            clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jtbPanel.addTab("Clientes", clientes);

        javax.swing.GroupLayout mesasLayout = new javax.swing.GroupLayout(mesas);
        mesas.setLayout(mesasLayout);
        mesasLayout.setHorizontalGroup(
            mesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        mesasLayout.setVerticalGroup(
            mesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jtbPanel.addTab("Mesas", mesas);

        javax.swing.GroupLayout informesLayout = new javax.swing.GroupLayout(informes);
        informes.setLayout(informesLayout);
        informesLayout.setHorizontalGroup(
            informesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        informesLayout.setVerticalGroup(
            informesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jtbPanel.addTab("Informes", informes);

        javax.swing.GroupLayout ayudaLayout = new javax.swing.GroupLayout(ayuda);
        ayuda.setLayout(ayudaLayout);
        ayudaLayout.setHorizontalGroup(
            ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        ayudaLayout.setVerticalGroup(
            ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jtbPanel.addTab("Ayuda", ayuda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtbPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jtbPanel)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFechaActionPerformed
        spnFecha.setEnabled(!chkFecha.isSelected());
        aplicarFiltros();
    }//GEN-LAST:event_chkFechaActionPerformed

    private void btnFechaActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaActActionPerformed
        spnFecha.setValue(java.util.Date.from(LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()));

        chkFecha.setSelected(false);
        spnFecha.setEnabled(true);

        aplicarFiltros();
    }//GEN-LAST:event_btnFechaActActionPerformed

    private void btnFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrosActionPerformed

        if (btnFiltros.isSelected()) {
            labelFiltros.setVisible(true);
            btnFiltros.setText("Limpiar Filtros");
            aplicarFiltros();

        } else {
            labelFiltros.setVisible(false);
            btnFiltros.setText("Aplicar Filtros");
            limpiarFiltros();
        }
    }//GEN-LAST:event_btnFiltrosActionPerformed

    private void btnFiltrosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnFiltrosStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFiltrosStateChanged

    private void cmbMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMesaActionPerformed

    public void configurarSpinnerFecha() {

        SpinnerDateModel datemodel = new SpinnerDateModel();
        spnFecha.setModel(datemodel);

        // Configurar el formato de la fecha como "yyyy-MM-dd"
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnFecha, "yyyy-MM-dd");
        spnFecha.setEditor(dateEditor);

        spnFecha.setValue(java.util.Date.from(LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()));
    }

    public void cargarDatosTabla(Object[][] datos) {
        String[] columnas = {"Reserva", "Fecha", "Hora", "Nombre", "Telefono", "Mesa", "Camarero"};

        tablaReservas.setColumnas(columnas);
        tablaReservas.setDatos(datos);

    }

    public void aplicarFiltros() {
        // Comprobadores y poner nulo por defecto
        String nombreCliente = jTFNombreCliente.getText().trim();
        nombreCliente = nombreCliente.isEmpty() ? null : nombreCliente;

        // Captar mesa y poner null por defecto en "-- --"
        String selectedMesa = (String) cmbMesa.getSelectedItem();
        Integer numeroMesa = (selectedMesa != null && !selectedMesa.equals("-- --"))
                ? Integer.valueOf(selectedMesa.replace("Mesa ", ""))
                : null;

        // Captar fecha y checkbox activo
        LocalDate fecha = chkFecha.isSelected() ? null
                : ((java.util.Date) spnFecha.getValue()).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        LocalTime hora = null;
        if (cmbHora.getSelectedIndex() > 0) {
            hora = LocalTime.parse(cmbHora.getSelectedItem().toString());
        }

        // Crear objeto Filtro con los valores seleccionados
        Filtro filtro = new Filtro(nombreCliente, numeroMesa, fecha, hora);
        System.out.println("DEBUG - Filtro creado: " + filtro);

        // Llamar al controlador para obtener los datos filtrados
        Object[][] datos = controlador.obtenerDatosConFiltro(filtro);

        // Cargar datos en la tabla
        cargarDatosTabla(datos);

    }

    private void cargarVistas() {
        vistaUsuarios = new VistaUsuarios();
        jtbPanel.setComponentAt(1, vistaUsuarios);
        jtbPanel.setComponentAt(2, new VistaCrearReserva());
        jtbPanel.setComponentAt(3, new VistaClientes());
        jtbPanel.setComponentAt(4, new VistaMesas());
        jtbPanel.setComponentAt(5, new VistaInformes());
        jtbPanel.setComponentAt(6, new VistaAyuda());
    }

    //  Comprobar el rol y ocultar la pestaña de "Usuarios"
    private void comprobarRol(String rol) {
        if (!"ENCARGADO".equalsIgnoreCase(rol)) {
            int index = jtbPanel.indexOfTab("Usuarios");
            if (index != -1) {
                jtbPanel.removeTabAt(index);
            }
        }
    }

    public void limpiarFiltros() {
        jTFNombreCliente.setText("");
        cmbMesa.setSelectedIndex(0);
        cmbHora.setSelectedIndex(0);
        chkFecha.setSelected(true);
        spnFecha.setEnabled(false);
        labelFiltros.setVisible(false);

        // Recargar la tabla con todos los datos sin filtro
        Object[][] datos = controlador.obtenerDatosParaTabla();
        cargarDatosTabla(datos);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Reservas;
    private javax.swing.JPanel ayuda;
    private javax.swing.JButton btnFechaAct;
    private javax.swing.JToggleButton btnFiltros;
    private javax.swing.JCheckBox chkFecha;
    private javax.swing.JPanel clientes;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbMesa;
    private javax.swing.JPanel crearReserva;
    private javax.swing.JPanel informes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JTextField jTFNombreCliente;
    private javax.swing.JTabbedPane jtbPanel;
    private javax.swing.JLabel labelFiltros;
    private javax.swing.JLabel labelReserva;
    private javax.swing.JLabel labelnombre;
    private javax.swing.JPanel mesas;
    private javax.swing.JSpinner spnFecha;
    private di_componentetabla.Tabla tablaReservas;
    private javax.swing.JPanel usuarios;
    // End of variables declaration//GEN-END:variables
}
