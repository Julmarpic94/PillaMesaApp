package di_componentetabla;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JPanel implements Serializable {

    private DefaultTableModel dtm;
    private JTable tabla;
    private JScrollPane scrollTabla;
    private JButton btnSig;
    private JButton btnAnt;
    private JLabel verNumPag;
    private JPanel panelBotones;
    private int numPag = 0;
    private int filaXPag = 5;
    private Object[][] datos = {};
    private String[] columnas = {};

    private cuandoCambioPag listener;

    public Tabla() {
        // Inicialización de componentes
        this.dtm = new DefaultTableModel(columnas, 0);
        this.tabla = new JTable(dtm);
        this.scrollTabla = new JScrollPane(tabla);

        this.panelBotones = new JPanel(new FlowLayout());
        this.btnSig = new JButton("Siguiente");
        this.btnAnt = new JButton("Anterior");
        this.verNumPag = new JLabel("Página: " + (numPag + 1));
        btnAnt.setEnabled(false);

        panelBotones.add(btnAnt);
        btnAnt.addActionListener((e) -> {
            botonAntAcc();
            if (listener != null) {
                listener.cambioPaginaEvento(new PaginaEvento(this));
            }
        });

        panelBotones.add(verNumPag);
        panelBotones.add(btnSig);
        btnSig.addActionListener((e) -> {
            botonSigAcc();
            if (listener != null) {
                listener.cambioPaginaEvento(new PaginaEvento(this));
            }
        });

        // Listener para selección de fila
        tabla.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting() && tabla.getSelectedRow() != -1) {
                if (listener != null) {
                    listener.cuandoSelecFila(new FilaEvento(this));
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.add(scrollTabla, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);
    }

    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getSelectedRow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getValueAt(int filaSeleccionada, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Interfaz para los listeners 
    public interface cuandoCambioPag extends EventListener {
        void cambioPaginaEvento(PaginaEvento event);
        void cuandoSelecFila(FilaEvento event);
    }

    // Método para registrar el listener
    public void setTablaListener(cuandoCambioPag listener) {
        this.listener = listener;
    }

    // Método para establecer elementos por página
    public void setNumElementosPagina(int filaXPag) {
        this.filaXPag = filaXPag;
        actualizarTabla(paginar(datos));
    }

    // Método para establecer columnas
    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
        actualizarModeloTabla();
    }

    // Método para establecer datos y manejar datos vacíos
    public void setDatos(Object[][] datos) {
        if (datos == null || datos.length == 0) { 
            System.out.println("⚠️ No hay datos disponibles para mostrar.");
            dtm.setRowCount(0); // Limpia la tabla sin llamar a paginar
            numPag = 0; // Reinicia la paginación
            actualizarNumPag();
            btnSig.setEnabled(false);
            btnAnt.setEnabled(false);
            return;
        }

        this.datos = datos;
        numPag = 0; // Reiniciar la paginación al agregar nuevos datos
        actualizarTabla(paginar(datos));
    }

    private void actualizarModeloTabla() {
        this.dtm = new DefaultTableModel(columnas, 0);
        this.tabla.setModel(dtm);
    }

    // Método para actualizar la tabla con los datos paginados
    private void actualizarTabla(Object[][] datos) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        for (Object[] fila : datos) {
            if (fila[0] != null) {
                model.addRow(fila);
            }
        }

        actualizarNumPag();
        // Habilitar o deshabilitar los botones de navegación
        btnAnt.setEnabled(numPag > 0);
        btnSig.setEnabled((numPag + 1) * filaXPag < this.datos.length);
    }

    // Método para paginar correctamente
    public Object[][] paginar(Object[][] datos) {
        if (datos == null || datos.length == 0) { 
            return new Object[0][0]; // Devuelve tabla vacía sin errores
        }

        int inicio = numPag * filaXPag;
        int fin = Math.min(inicio + filaXPag, datos.length);

        // Crear una matriz solo si hay datos disponibles
        Object[][] pagina = new Object[fin - inicio][datos[0].length];

        for (int i = inicio; i < fin; i++) {
            pagina[i - inicio] = datos[i];
        }

        return pagina;
    }

    // Método para actualizar la numeración de páginas
    private void actualizarNumPag() {
        verNumPag.setText("Página: " + (numPag + 1));
    }

    // Acción del botón siguiente
    private void botonSigAcc() {
        if ((numPag + 1) * filaXPag < datos.length) {
            numPag++;
            actualizarTabla(paginar(datos));
        }
    }

    // Acción del botón anterior
    private void botonAntAcc() {
        if (numPag > 0) {
            numPag--;
            actualizarTabla(paginar(datos));
        }
    }

    // Interfaces para los listeners
    public interface PagSiguienteListener extends EventListener {
        void onPaginaSiguiente(int paginaActual);
    }

    public interface PagAnteriorListener extends EventListener {
        void onPaginaAnterior(int paginaActual);
    }

    public interface FilaSeleccionListener extends EventListener {
        void onFilaSeleccionada(int filaSeleccionada, Object[] datosFila);
    }
}
