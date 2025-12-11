package Presentación;
import Dominio.RecursosElectronicos;
import Dominio.UsuarioBiblioteca;
import Servicio.ServicioAccesoRecursos;
import Servicio.GestionAccesoRecursosException;
import Servicio.ServicioGestionUsuarios;
import Servicio.GestionUsuariosException;
import java.sql.*;
import java.util.*;
public class VentanaAccesoRecursos {
	Scanner sc=new Scanner(System.in);
	private final ServicioGestionUsuarios servicioUsuarios;
	private final ServicioAccesoRecursos servicioRecursos;
	public VentanaAccesoRecursos() {
		try {
			this.servicioRecursos=new ServicioAccesoRecursos();
			this.servicioUsuarios=new ServicioGestionUsuarios();
		}
		catch(SQLException e) {
			throw new RuntimeException("Error al inicializar la capa de servicio "+e.getMessage());
		}
	}
	public boolean validarCredenciales(String dni) throws GestionUsuariosException{
		List<UsuarioBiblioteca> usuariosDisponibles=servicioUsuarios.allMaterial();
		boolean existeLogin=false;
		for(int i=0;i<usuariosDisponibles.size();i++) {
			if(usuariosDisponibles.get(i).getDni().equals(dni)) {
				existeLogin=true;
			}
			else {
				throw new GestionUsuariosException("Inicio de sesion incorrecto");
			}
		}
		return existeLogin;
	}
	public String mostrarLogin() {
		return "Inicia sesion con tu DNI";
	}
	public String iniciarSesion() {
		String dni=sc.nextLine();
		return dni;
	}
	public String validarFormatoLogin(boolean existeLogin) {
		if(existeLogin) {
			return "Inicio de sesión correcto";
		}
		else {
			return "Inicio de sesión incorrecto";
		}
	}
	public String solicitarRecurso() {
		System.out.println("Inctroduce el ID del recurso que desea solicitar:");
		String id;
		id=sc.nextLine();
		return id;
	}
	public boolean obtenerRecurso(String id) throws GestionAccesoRecursosException{
		boolean obtenido=false;
		List<RecursosElectronicos> rs=servicioRecursos.allRecursos();
		for(int i=0;i<rs.size();i++) {
			if(rs.get(i).getId().equals(id)) {
				obtenido=true;
			}
		}
		return obtenido;
	}
	public void mostrarRecursos(List<RecursosElectronicos> r) {
		for(int i=0;i<r.size();i++) {
			System.out.println(r.get(i).toString());
		}
	}
	public String mostrarResultados(boolean obtenido) {
		if(obtenido) {
			return "Recurso obtenido";
		}
		else {
			return "No se pudo obtener el recurso porque no existe";
		}
	}
	public String buscar() {
		System.out.println("Introduce el ID del recurso que desea buscar:");
		String id=sc.nextLine();
		return id;
	}
	public RecursosElectronicos buscarRecurso(String id) throws GestionAccesoRecursosException{
		return servicioRecursos.searchRecurso(id);
	}
	public List<RecursosElectronicos> obtenerRecursos() throws GestionAccesoRecursosException{
		return servicioRecursos.allRecursos();
	}
}
