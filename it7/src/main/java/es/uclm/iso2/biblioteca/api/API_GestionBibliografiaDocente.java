package es.uclm.iso2.biblioteca.api;

import es.uclm.iso2.biblioteca.dominio.BibliografiaAsignatura;
import es.uclm.iso2.biblioteca.servicio.GestionBibliografiaException;
import es.uclm.iso2.biblioteca.servicio.ServicioGestionBibliografia;

import java.sql.SQLException;
import java.util.List;

/**
 * It7: API que actúa como fachada entre la capa de presentación (cliente)
 * y el servicio de gestión de bibliografía (servidor).
 */
public class API_GestionBibliografiaDocente {

    private final ServicioGestionBibliografia servicio;

    public API_GestionBibliografiaDocente() {
        // Inicializar el servicio GestionBibliografia gestionando posibles SQLException
        // En caso de error, lanzar RuntimeException para simplificar la gestión en la capa de presentación
        servicio = inicializarServicio();
    }
    
    // It7: 
    private ServicioGestionBibliografia inicializarServicio() {
        // Crear y devolver una instancia de ServicioGestionBibliografia dentro de un try/catch
        // Capturar SQLException y envolverla en RuntimeException
        return null;
    }

    /**
     * RF1 (cliente): visualizar bibliografía asociada a una asignatura/proyecto.
     */
    // It7: 
    public List<BibliografiaAsignatura> obtenerBibliografiaDocente(String dniDocente,
                                                                   String codigoAsignaturaProyecto)
            throws GestionBibliografiaException {
        return servicio.consultarBibliografiaDocente(dniDocente, codigoAsignaturaProyecto);
    }

    /**
     * RF2 (cliente): alta de nueva referencia bibliográfica.
     */
    // It7:
    public int altaReferencia(BibliografiaAsignatura nuevaReferencia)
            throws GestionBibliografiaException {
        return servicio.crearReferenciaBibliografica(nuevaReferencia);
    }

    /**
     * RF3 (cliente): modificación de referencia existente.
     */
    // It7:
    public int modificarReferencia(BibliografiaAsignatura referenciaModificada)
            throws GestionBibliografiaException {
        return servicio.modificarReferenciaBibliografica(referenciaModificada);
    }

    /**
     * RF4 (cliente): baja de referencia.
     * // It7:
     */
    public int eliminarReferencia(int idReferencia, String dniDocente)
            throws GestionBibliografiaException {
        return servicio.eliminarReferenciaBibliografica(idReferencia, dniDocente);
    }
}

