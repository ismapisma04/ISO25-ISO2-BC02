package API;
import Dominio.RecursosElectronicos;
import Servicio.ServicioAccesoRecursos;
import Servicio.GestionAccesoRecursosException;
import Servicio.GestionUsuariosException;
import Presentación.VentanaAccesoRecursos;
import java.sql.*;
import java.util.*;
public class API_AccesoRecursos {
	private final ServicioAccesoRecursos servicioRecursos;
	private final VentanaAccesoRecursos ventanaRecursos;
	public API_AccesoRecursos() {
		try {
			this.servicioRecursos=new ServicioAccesoRecursos();
			this.ventanaRecursos=new VentanaAccesoRecursos();
		}
		catch(SQLException e) {
			throw new RuntimeException("Error al inicializar el servicio del material "+e.getMessage());
		}
	}
	public int insertarRecurso(RecursosElectronicos r) throws GestionAccesoRecursosException{
		return servicioRecursos.insertRecursos(r);
	}
	public int eliminarRecurso(String id) throws GestionAccesoRecursosException{
		return servicioRecursos.deleteRecursos(id);
	}
	public int actualizarRecurso(RecursosElectronicos r) throws GestionAccesoRecursosException{
		return servicioRecursos.uptadeRecurso(r);
	}
	public RecursosElectronicos buscarRecuso(String id) throws GestionAccesoRecursosException {
		return ventanaRecursos.buscarRecurso(id);
	}
	public String buscar() {
		return ventanaRecursos.buscar();
	}
	public List<RecursosElectronicos> obtenerRecursos() throws GestionAccesoRecursosException{
		return ventanaRecursos.obtenerRecursos();
	}
	public boolean validarCredenciales(String dni) throws GestionUsuariosException{
		return ventanaRecursos.validarCredenciales(dni);
	}
	public String mostrarLogin() {
		return ventanaRecursos.mostrarLogin();
	}
	public String iniciarSesion() {
		return ventanaRecursos.iniciarSesion();
	}
	public String validarFormatoLogin(boolean existe) {
		return ventanaRecursos.validarFormatoLogin(existe);
	}
	public String solicitarRecurso() {
		return ventanaRecursos.solicitarRecurso();
	}
	public boolean obtenerRecurso(String id) throws GestionAccesoRecursosException {
		return ventanaRecursos.obtenerRecurso(id);
	}
	public void mostrarRecursos(List<RecursosElectronicos> rs) {
		ventanaRecursos.mostrarRecursos(rs);
	}
	public String mostrarResultados(boolean b) {
		return ventanaRecursos.mostrarResultados(b);
	}
}
