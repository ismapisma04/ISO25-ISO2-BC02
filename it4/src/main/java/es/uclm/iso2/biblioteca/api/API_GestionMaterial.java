package es.uclm.iso2.biblioteca.api;

import es.uclm.iso2.biblioteca.dominio.MaterialBibliografico;
import es.uclm.iso2.biblioteca.servicio.GestionMaterialException;
import es.uclm.iso2.biblioteca.servicio.ServicioGestionMaterial;

import java.sql.SQLException;
import java.util.List;

public class API_GestionMaterial {

    private final ServicioGestionMaterial servicio;

    public API_GestionMaterial() {
        try {
            this.servicio = new ServicioGestionMaterial();
        } catch (SQLException e) {
            // Error técnico al inicializar la capa de servicio
            throw new RuntimeException("Error inicializando el servicio de material", e);
        }
    }

    public int insertMaterial(MaterialBibliografico m) throws GestionMaterialException {
        return this.servicio.insertMaterial(m);
    }

    public int deleteMaterial(String isbn) throws GestionMaterialException {
        return this.servicio.deleteMaterial(isbn);
    }

    public int updateMaterial(MaterialBibliografico m) throws GestionMaterialException {
        return this.servicio.uptadeMaterial(m);
    }

    public MaterialBibliografico searchMaterial(String isbn) throws GestionMaterialException {
        return this.servicio.searchMaterial(isbn);
    }

    public List<MaterialBibliografico> allMaterial() throws GestionMaterialException{
        return this.servicio.allMaterial();
    }
}

