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
            // Error técnico al inicializar la capa de servicio
            throw new RuntimeException("Error inicializando el servicio de material", e);
        }
    }


    public int insertMaterial(UsuarioBiblioteca u) throws GestionUsuariosException {
        return this.servicio.insertUsuario(u);
    }

    public int deleteMaterial(String dni) throws GestionUsuariosException {
        return this.servicio.deleteUsuario(dni);
    }

    public int updateMaterial(UsuarioBiblioteca u) throws GestionUsuariosException {
        return this.servicio.uptadeUsuario(u);
    }

    public UsuarioBiblioteca searchMaterial(String dni) throws GestionUsuariosException {
        return this.servicio.searchMaterial(dni);
    }

    public List<UsuarioBiblioteca> allMaterial() throws GestionUsuariosException{
        return this.servicio.allMaterial();
    }
}
