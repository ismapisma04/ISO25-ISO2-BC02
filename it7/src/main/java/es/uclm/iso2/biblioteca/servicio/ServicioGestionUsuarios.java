package es.uclm.iso2.biblioteca.servicio;

import es.uclm.iso2.biblioteca.dao.UsuarioDAO;
import es.uclm.iso2.biblioteca.dominio.MaterialBibliografico;
import es.uclm.iso2.biblioteca.dominio.UsuarioBiblioteca;

import java.sql.SQLException;
import java.util.List;

public class ServicioGestionUsuarios {

    private final UsuarioDAO usuarioDAO;

    public ServicioGestionUsuarios() throws SQLException {
        this.usuarioDAO = new UsuarioDAO();
    }

   
    
    
    public int insertUsuario(UsuarioBiblioteca u) throws GestionUsuariosException{
    	validarUsuario(u);
    	
    	UsuarioBiblioteca existe = this.usuarioDAO.findByDni(u.getDni());
    	if(existe != null){
    		throw new GestionUsuariosException("Ya existe un Usuario con ese DNI.");
    	}
    	
    	return this.usuarioDAO.insert(u);
    }
    
    
    public int deleteUsuario(String dni) throws GestionUsuariosException{
    	UsuarioBiblioteca existe = this.usuarioDAO.findByDni(dni);
    	
    	if(existe == null) {
    		throw new GestionUsuariosException("No existe un usuario con ese DNI.");
    	}
    	
    	return this.usuarioDAO.delete(dni);
    }
    
    
    public int uptadeUsuario(UsuarioBiblioteca u) throws GestionUsuariosException{
    	validarUsuario(u);
    	
    	UsuarioBiblioteca existe = this.usuarioDAO.findByDni(u.getDni());
    	if(existe == null) {
    		throw new GestionUsuariosException("No existe un usuario con ese DNI.");
    	}
    	
    	return this.usuarioDAO.update(u);
    }
    
    
    
    public UsuarioBiblioteca searchMaterial(String dni) throws GestionUsuariosException{
    	
    	UsuarioBiblioteca existe = this.usuarioDAO.findByDni(dni);
    	if(existe == null) {
    		throw new GestionUsuariosException("No existe un usuario con ese DNI.");
    	}
    	
    	return this.usuarioDAO.findByDni(dni);
    }
    
    
    public List<UsuarioBiblioteca> allUsuario() throws GestionUsuariosException{
    	
    	List<UsuarioBiblioteca> lista = this.usuarioDAO.readAll();
    	if(lista == null || lista.isEmpty()) {
    		throw new GestionUsuariosException(" No hay libros.");
    	}
    	
    	return this.usuarioDAO.readAll();
    }
    
    
    
    
    
    
    
    
    private void validarUsuario(UsuarioBiblioteca u) throws GestionUsuariosException {

        if (u == null) {
            throw new GestionUsuariosException("El usuario no puede ser nulo.");
        }

        if (u.getNombre() == null || u.getNombre()=="") {
            throw new GestionUsuariosException("El nombre es obligatorio.");
        }

        if (u.getApellidos() == null || u.getApellidos()=="") {
            throw new GestionUsuariosException("El apellido es obligatorio.");
        }

        if (u.getEmail() == null || u.getEmail()=="") {
            throw new GestionUsuariosException("El email es obligatorio.");
        }

        if (u.getDni() == null || u.getDni()=="") {
            throw new GestionUsuariosException("El DNI es obligatorio.");
        }
        
        if (u.getFechaCreacion() < 0) {
            throw new GestionUsuariosException("El año de creacion no puede ser negativo.");
        }
    }
    
    
    
}
