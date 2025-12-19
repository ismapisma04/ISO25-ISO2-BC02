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
            throw new RuntimeException("Error inicializando ServicioGestionMaterial: " + e.getMessage(), e);
        }
    }

    public int insertMaterial(MaterialBibliografico m) throws GestionMaterialException {
        return servicio.insertMaterial(m);
    }

    public int deleteMaterial(String isbn) throws GestionMaterialException {
        return servicio.deleteMaterial(isbn);
    }

    public int updateMaterial(MaterialBibliografico m) throws GestionMaterialException {
        return servicio.uptadeMaterial(m);
    }

    public MaterialBibliografico searchMaterial(String isbn) throws GestionMaterialException {
        return servicio.searchMaterial(isbn);
    }

    public List<MaterialBibliografico> allMaterial() throws GestionMaterialException {
        return servicio.allMaterial();
    }
}

