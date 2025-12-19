package es.uclm.iso2.biblioteca.dao;

import es.uclm.iso2.biblioteca.dominio.BibliografiaAsignatura;
import es.uclm.iso2.biblioteca.persistencia.DBBroker;

import java.sql.SQLException;
import java.util.List;

public class BibliografiaAsignaturaDAO {

    // Referencia al broker de BD
    private final DBBroker broker;

    public BibliografiaAsignaturaDAO() throws SQLException {
        // Obtener la instancia singleton de DBBroker y asignarla al atributo broker
        broker = DBBroker.getInstance();
    }

    /**
     * Inserta una nueva entrada de bibliografía asociada
     * a un docente y una asignatura/proyecto.
     * // It7:
     */
    public int insert(BibliografiaAsignatura b) {
        // Construir la sentencia SQL de INSERT usando los datos de 'b'
        // Devolver el número de filas afectadas
        return 0;
    }

    /**
     * Actualiza una entrada de bibliografía existente.
     * // It7:
     */
    public int update(BibliografiaAsignatura b) {
        // Construir sentencia SQL de UPDATE según el id de 'b'
        // Devolver filas afectadas
        return 0;
    }

    /**
     * Elimina una entrada de bibliografía por id.
     * // It7: 
     */
    public int delete(int id) {
        // Construir sentencia SQL DELETE por id
        // Devolver filas afectadas
        return 0;
    }

    /**
     * Obtiene la lista de referencias bibliográficas
     * asociadas a una asignatura/proyecto concreta de un docente.
     * // It7:
     */
    public List<BibliografiaAsignatura> findByDocenteYAsignatura(String dniDocente,
                                                                 String codigoAsignaturaProyecto) {
        // Construir sentencia SELECT filtrando por dniDocente y codigoAsignaturaProyecto
        // Recorrer las filas y crear objetos BibliografiaAsignatura
        // Devolver la lista de referencias
        return null;
    }

    /**
     * Comprueba si ya existe una referencia bibliográfica duplicada
     * (mismo docente, misma asignatura/proyecto, mismo ISBN).
     * // It7:
     */
    public boolean existeReferenciaDuplicada(String dniDocente,
                                             String codigoAsignaturaProyecto,
                                             String isbnMaterial) {
        // Hacer un SELECT COUNT(*) con esos tres datos
        // Si el recuento > 0, devolver true
        // Si no, devolver false
        return false;
    }
}


