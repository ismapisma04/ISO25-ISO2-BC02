package Servicio;
import DAO.RecursosElectronicosDAO;
import Dominio.RecursosElectronicos;
import java.util.*;
import java.sql.*;
public class ServicioAccesoRecursos {
	private final RecursosElectronicosDAO recusosDAO;
	public ServicioAccesoRecursos() throws SQLException {
		this.recusosDAO=new RecursosElectronicosDAO();
	}
	public int insertRecursos(RecursosElectronicos r) throws GestionAccesoRecursosException {
		validarRecurso(r);
		RecursosElectronicos existe=this.recusosDAO.findById(r.getId());
		if(existe!=null) {
			throw new GestionAccesoRecursosException("La ID ya existe");
		}
		return this.recusosDAO.insert(r);
	}
	public int deleteRecursos(String id) throws GestionAccesoRecursosException {
		RecursosElectronicos existe=this.recusosDAO.findById(id);
		if(existe==null) {
			throw new GestionAccesoRecursosException("Este recurso electrónico no existe");
		}
		return this.recusosDAO.delete(id);
	}
	public int uptadeRecurso(RecursosElectronicos r) throws GestionAccesoRecursosException{
    	validarRecurso(r);
    	
    	RecursosElectronicos existe = this.recusosDAO.findById(r.getId());
    	if(existe == null) {
    		throw new GestionAccesoRecursosException("No existe un recurso electrónico con ese ID.");
    	}
    	
    	return this.recusosDAO.update(r);
    }
	public RecursosElectronicos searchRecurso(String id) throws GestionAccesoRecursosException{
	    	
    	RecursosElectronicos existe = this.recusosDAO.findById(id);
    	if(existe == null) {
    		throw new GestionAccesoRecursosException("No existe un recurso electrónico con ese ID.");
    	}
    	
    	return this.recusosDAO.findById(id);
	}
	public List<RecursosElectronicos> allRecursos() throws GestionAccesoRecursosException{
    	
    	List<RecursosElectronicos> lista = this.recusosDAO.readAll();
    	if(lista == null || lista.isEmpty()) {
    		throw new GestionAccesoRecursosException(" No hay recursos electrónicos.");
    	}
    	
    	return this.recusosDAO.readAll();
    }
	private void validarRecurso(RecursosElectronicos r) throws GestionAccesoRecursosException {

        if (r == null) {
            throw new GestionAccesoRecursosException("El recurso no puede ser nulo.");
        }

        if (r.getId() == null || r.getId()=="") {
            throw new GestionAccesoRecursosException("La ID es obligatorio.");
        }

        if (r.getTitulo() == null || r.getTitulo()=="") {
            throw new GestionAccesoRecursosException("El titulo es obligatorio.");
        }

        if (r.getCategoria() == null || r.getCategoria()=="") {
            throw new GestionAccesoRecursosException("La categoría es obligatoria.");
        }

        if (r.getContenido() == null || r.getContenido()=="") {
            throw new GestionAccesoRecursosException("El contenido es obligatorio.");
        }
    }
}
