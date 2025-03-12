package Vistas;

import javax.swing.*;
import java.awt.*;

public class Logotipo extends JWindow {

    public Logotipo() {
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.WHITE);

        JLabel labelBienvenida = new JLabel("Pillando Mesa.....", SwingConstants.CENTER);
        labelBienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        labelBienvenida.setForeground(Color.BLACK);

        // ✅ Cargar el logotipo
        ImageIcon originalIcon = new ImageIcon("imagen.png");
        Image img = originalIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel logoLabel = new JLabel(scaledIcon, SwingConstants.CENTER);

        content.add(logoLabel, BorderLayout.CENTER);
        content.add(labelBienvenida, BorderLayout.NORTH);

        setContentPane(content);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(3000);
                return null;
            }

            @Override
            protected void done() {
                dispose();
                //Abrimos Login
                new VistaLogin().setVisible(true);
            }
        }.execute();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logotipo();

            }
        });
    }
}
