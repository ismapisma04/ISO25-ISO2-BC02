package es.uclm.iso2.biblioteca.api;

import es.uclm.iso2.biblioteca.dominio.UsuarioBiblioteca;
import es.uclm.iso2.biblioteca.servicio.GestionUsuariosException;
import es.uclm.iso2.biblioteca.servicio.ServicioGestionUsuarios;

import java.sql.SQLException;
import java.util.List;

public class API_GestionarUsuarios {

    private final ServicioGestionUsuarios servicio;

    public API_GestionarUsuarios() {
        try {
            this.servicio = new ServicioGestionUsuarios();
        } catch (SQLException e) {
            throw new RuntimeException("Error inicializando ServicioGestionUsuarios: " + e.getMessage(), e);
        }
    }

    public int insertUsuaio(UsuarioBiblioteca u) throws GestionUsuariosException {
        return servicio.insertUsuario(u);
    }

    public int deleteUsuario(String dni) throws GestionUsuariosException {
        return servicio.deleteUsuario(dni);
    }

    public int updateUsuaio(UsuarioBiblioteca u) throws GestionUsuariosException {
        return servicio.uptadeUsuario(u);
    }

    public UsuarioBiblioteca searchUsuario(String dni) throws GestionUsuariosException {
        return servicio.searchMaterial(dni);
    }

    public List<UsuarioBiblioteca> allUsuarios() throws GestionUsuariosException {
        return servicio.allMaterial();
    }
}

