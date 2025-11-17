package es.uclm.iso2.biblioteca.servicio;


import es.uclm.iso2.biblioteca.dao.MaterialDAO;
import es.uclm.iso2.biblioteca.dominio.MaterialBibliografico;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

public class ServicioGestionMaterial {

    private final MaterialDAO materialDAO;

    public ServicioGestionMaterial() throws SQLException {
        this.materialDAO = new MaterialDAO();
    }

    
    
    
    public int insertMaterial(MaterialBibliografico m) throws GestionMaterialException {
    	validarMaterial(m);
    	
    	MaterialBibliografico existente = this.materialDAO.findByIsbn(m.getIsbn());
    	if(existente != null) {
    		throw new GestionMaterialException("Ya existe un material con ese ISBN.");
    	}
    	
    	return this.materialDAO.insert(m);
    }
    
    
    public int deleteMaterial(String isbn) throws GestionMaterialException {
    	
    	MaterialBibliografico existente = this.materialDAO.findByIsbn(isbn);	
    	if(existente == null) {
    		throw new GestionMaterialException("No existe un Libro con ese ISBN.");
    	}
    	
    	return this.materialDAO.delete(isbn);
    }
    
    
    public int uptadeMaterial(MaterialBibliografico m) throws GestionMaterialException {
    	validarMaterial(m);
    	
    	MaterialBibliografico existente = this.materialDAO.findByIsbn(m.getIsbn());	
    	if(existente == null) {
    		throw new GestionMaterialException("No existe un Libro con ese ISBN.");
    	}
    	
    	return this.materialDAO.update(m);
    }
    
    
    
    public MaterialBibliografico searchMaterial(String isbn) throws GestionMaterialException {
    	
    	MaterialBibliografico existente = this.materialDAO.findByIsbn(isbn);	
    	if(existente == null) {
    		throw new GestionMaterialException("No existe un Libro con ese ISBN.");
    	}
    	
    	return this.materialDAO.findByIsbn(isbn);
    }
    
    
    public List<MaterialBibliografico> allMaterial() throws GestionMaterialException {
    	
    	List<MaterialBibliografico> lista = materialDAO.readAll();
    	if(lista == null || lista.isEmpty()) {
    		throw new GestionMaterialException(" No hay libros.");
    	}
    	
    	return this.materialDAO.readAll();
    }
    
    
    
    private void validarMaterial(MaterialBibliografico m) throws GestionMaterialException {

        if (m == null) {
            throw new GestionMaterialException("El material no puede ser nulo.");
        }

        if (m.getTitulo() == null || m.getTitulo().isBlank()) {
            throw new GestionMaterialException("El título es obligatorio.");
        }

        if (m.getAutor() == null || m.getAutor().isBlank()) {
            throw new GestionMaterialException("El autor es obligatorio.");
        }

        if (m.getIsbn() == null || m.getIsbn().isBlank()) {
            throw new GestionMaterialException("El ISBN es obligatorio.");
        }
        
        if (m.getCategoria() == null || m.getCategoria().isBlank()) {
            throw new GestionMaterialException("La categoria es obligatoria.");
        }

        if (m.getAnioPublicacion() < 0) {
            throw new GestionMaterialException("El año de publicación no puede ser negativo.");
        }
    }
    
}
