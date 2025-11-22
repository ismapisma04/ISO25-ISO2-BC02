/*
package es.uclm.iso2.biblioteca.presentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("Sistema Biblioteca - Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JButton btnGestionUsuarios = new JButton("Gestión de usuarios");

        btnGestionUsuarios.addActionListener(this::abrirGestionUsuarios);

        add(btnGestionUsuarios);
    }

    private void abrirGestionUsuarios(ActionEvent e) {
        try {
            VentanaGestionUsuarios v = new VentanaGestionUsuarios();
            v.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error al abrir gestión de usuarios: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
*/