
package es.uclm.iso2.biblioteca.presentacion;

import es.uclm.iso2.biblioteca.api.API_GestionarUsuarios;
import es.uclm.iso2.biblioteca.dominio.UsuarioBiblioteca;
import es.uclm.iso2.biblioteca.servicio.GestionUsuariosException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class VentanaGestionUsuarios extends JFrame {

	private API_GestionarUsuarios api_u = new API_GestionarUsuarios();
	
	
	//esta es la interfaz para todo lo que tenga que ver con los usuarios
	
	
	//iteracion 3 cdu 12
	public void interfaz () {
		//este metodo va a hacer la interfaz para hacer las distintas gestiones de los usuarios
		
	}
	
	//iteracion 3 cdu 12
		public int insertUsuario (UsuarioBiblioteca u) throws GestionUsuariosException {
			//este metodo trata de añadir un usuario
			return api_u.insertUsuaio(u);
		}
		
	//iteracion 3 cdu 12
		public int deleteUsuario (String dni) throws GestionUsuariosException {
			//este metodo trata de eliminar un usuario por el dni
			return api_u.deleteUsuario(dni);		
		}
		
	//iteracion 3 cdu 12
		public int updateUsuario (UsuarioBiblioteca u) throws GestionUsuariosException {
			//este metodo va a actualizar la informacion de un usuario
			return api_u.updateUsuaio(u);		
		}
		
	//iteracion 3 cdu 12
		public UsuarioBiblioteca searchUsuario (String dni) throws GestionUsuariosException {
			//este metodo va a buscar a un usuario por el dni	
			return api_u.searchUsuario(dni);		
		}
			
	
	
}

