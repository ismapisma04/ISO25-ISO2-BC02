/*
package es.uclm.iso2.biblioteca.presentacion;

import es.uclm.iso2.biblioteca.api.API_GestionarUsuarios;
import es.uclm.iso2.biblioteca.dominio.UsuarioBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class VentanaGestionUsuarios extends JFrame {

    private final API_GestionarUsuarios api;

    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtEmail;
    private JTextField txtDni;
    private JTextArea txtMensajes;
    private JList<UsuarioBiblioteca> listaUsuarios;
    private DefaultListModel<UsuarioBiblioteca> listaModel;

    public VentanaGestionUsuarios() throws Exception {
        this.api = new API_GestionarUsuarios();

        setTitle("Gestión de Usuarios - Biblioteca");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);

        initComponents();
        cargarUsuarios();
    }

    private void initComponents() {
        JPanel panelMain = new JPanel(new BorderLayout());

        // Panel formulario
        JPanel panelForm = new JPanel(new GridLayout(4, 2));
        panelForm.setBorder(BorderFactory.createTitledBorder("Datos usuario"));

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panelForm.add(txtApellidos);

        panelForm.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panelForm.add(txtEmail);

        panelForm.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panelForm.add(txtDni);

        // Panel botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnNuevo = new JButton("Crear nuevo");
        JButton btnGuardar = new JButton("Guardar cambios");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar = new JButton("Buscar por DNI");

        btnNuevo.addActionListener(this::accionNuevo);
        btnGuardar.addActionListener(this::accionGuardar);
        btnEliminar.addActionListener(this::accionEliminar);
        btnBuscar.addActionListener(this::accionBuscar);

        panelBotones.add(btnNuevo);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);

        // Lista de usuarios
        listaModel = new DefaultListModel<>();
        listaUsuarios = new JList<>(listaModel);
        listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaUsuarios.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                UsuarioBiblioteca sel = listaUsuarios.getSelectedValue();
                if (sel != null) {
                    mostrarUsuarioEnFormulario(sel);
                }
            }
        });

        JScrollPane scrollLista = new JScrollPane(listaUsuarios);
        scrollLista.setBorder(BorderFactory.createTitledBorder("Usuarios"));

        // Mensajes
        txtMensajes = new JTextArea(4, 20);
        txtMensajes.setEditable(false);
        JScrollPane scrollMensajes = new JScrollPane(txtMensajes);
        scrollMensajes.setBorder(BorderFactory.createTitledBorder("Mensajes"));

        panelMain.add(panelForm, BorderLayout.NORTH);
        panelMain.add(panelBotones, BorderLayout.CENTER);

        JPanel panelDerecha = new JPanel(new BorderLayout());
        panelDerecha.add(scrollLista, BorderLayout.CENTER);
        panelDerecha.add(scrollMensajes, BorderLayout.SOUTH);

        panelMain.add(panelDerecha, BorderLayout.EAST);

        setContentPane(panelMain);
    }

    private void cargarUsuarios() {
        listaModel.clear();
        try {
            List<UsuarioBiblioteca> usuarios = api.listarUsuarios();
            for (UsuarioBiblioteca u : usuarios) {
                listaModel.addElement(u);
            }
        } catch (Exception e) {
            txtMensajes.setText("ERROR cargando usuarios: " + e.getMessage());
        }
    }

    private void mostrarUsuarioEnFormulario(UsuarioBiblioteca u) {
        txtNombre.setText(u.getNombre());
        txtApellidos.setText(u.getApellidos());
        txtEmail.setText(u.getEmail());
        txtDni.setText(u.getDni());
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEmail.setText("");
        txtDni.setText("");
    }

    private void accionNuevo(ActionEvent e) {
        limpiarFormulario();
        txtMensajes.setText("Introduce los datos de un nuevo usuario y pulsa 'Guardar cambios'.");
    }

    private void accionGuardar(ActionEvent e) {
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String email = txtEmail.getText();
        String dni = txtDni.getText();
        

        try {
            UsuarioBiblioteca existente = api.buscarPorDni(dni);
            UsuarioBiblioteca u = new UsuarioBiblioteca(nombre, apellidos, email, dni, 0);

            if (existente == null) {
                api.crearUsuario(u);
                txtMensajes.setText("Usuario creado correctamente.");
            } else {
                api.modificarUsuario(u);
                txtMensajes.setText("Usuario modificado correctamente.");
            }

            cargarUsuarios();
        } catch (Exception ex) {
            txtMensajes.setText("ERROR: " + ex.getMessage());
        }
    }

    private void accionEliminar(ActionEvent e) {
        String dni = txtDni.getText();
        if (dni == null || dni.isBlank()) {
            txtMensajes.setText("ERROR: Introduce el DNI del usuario a eliminar.");
            return;
        }

        int res = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas eliminar este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (res != JOptionPane.YES_OPTION) return;

        try {
            api.eliminarUsuarioPorDni(dni);
            txtMensajes.setText("Usuario eliminado correctamente.");
            cargarUsuarios();
            limpiarFormulario();
        } catch (Exception ex) {
            txtMensajes.setText("ERROR: " + ex.getMessage());
        }
    }

    private void accionBuscar(ActionEvent e) {
        String dni = txtDni.getText();
        if (dni == null || dni.isBlank()) {
            txtMensajes.setText("ERROR: Introduce un DNI para buscar.");
            return;
        }

        try {
            UsuarioBiblioteca u = api.buscarPorDni(dni);
            if (u == null) {
                txtMensajes.setText("No se ha encontrado ningún usuario con ese DNI.");
            } else {
                mostrarUsuarioEnFormulario(u);
                txtMensajes.setText("Usuario encontrado.");
            }
        } catch (Exception ex) {
            txtMensajes.setText("ERROR: " + ex.getMessage());
        }
    }
}
*/
