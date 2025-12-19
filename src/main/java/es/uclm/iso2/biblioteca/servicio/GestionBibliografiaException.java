package es.uclm.iso2.biblioteca.servicio;

/**
 * Excepción específica para errores en la gestión
 * de bibliografía de docentes.
 * 
 * // It7:
 */
public class GestionBibliografiaException extends Exception {

    public GestionBibliografiaException(String message) {
        // Llamar al constructor de la superclase Exception con el mensaje recibido
        super(message);
    }
}
