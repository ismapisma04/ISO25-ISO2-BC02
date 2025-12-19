package es.uclm.iso2.biblioteca.servicio;

import es.uclm.iso2.biblioteca.dao.BibliografiaAsignaturaDAO;
import es.uclm.iso2.biblioteca.dao.MaterialDAO;
import es.uclm.iso2.biblioteca.dao.UsuarioDAO;
import es.uclm.iso2.biblioteca.dominio.BibliografiaAsignatura;
import es.uclm.iso2.biblioteca.dominio.MaterialBibliografico;
import es.uclm.iso2.biblioteca.dominio.UsuarioBiblioteca;

import java.sql.SQLException;
import java.util.List;

/**
 * Servicio del lado servidor que gestiona las operaciones
 * de bibliografía de docentes (consultar, crear, modificar, eliminar).
 * 
 * // It7:
 */
public class ServicioGestionBibliografia {

    private final BibliografiaAsignaturaDAO bibliografiaDAO;
    private final UsuarioDAO usuarioDAO;
    private final MaterialDAO materialDAO;

    public ServicioGestionBibliografia() throws SQLException {
        // Inicializar los DAOs necesarios (bibliografía, usuarios, material)
        bibliografiaDAO = new BibliografiaAsignaturaDAO();
        usuarioDAO = new UsuarioDAO();
        materialDAO = new MaterialDAO();
    }

    /**
     * RF1 (servidor): consultar bibliografía de un docente para una asignatura/proyecto.
     * 
     * // It7:
     */
    public List<BibliografiaAsignatura> consultarBibliografiaDocente(String dniDocente,
                                                                     String codigoAsignaturaProyecto)
            throws GestionBibliografiaException {
        // 1. Verificar que el docente existe usando usuarioDAO.findByDni(...)
        // 2. Verificar que la asignatura/proyecto pertenece al docente
        //    (aquí se podría consultar otro repositorio de asignaturas;
        //     si no existe aún, se documenta como pendiente o simulado).
        // 3. Usar bibliografiaDAO.findByDocenteYAsignatura(...) para obtener la lista
        // 4. Si la lista es nula o vacía, decidir si se lanza excepción o se devuelve lista vacía
        // 5. Devolver la lista obtenida
        return null;
    }

    /**
     * RF2: crear una nueva referencia bibliográfica.
     * 
     * // It7:
     */
    public int crearReferenciaBibliografica(BibliografiaAsignatura nuevaReferencia)
            throws GestionBibliografiaException {
        // 1. Validar que nuevaReferencia no es nula y que tiene todos los campos obligatorios
        // 2. Verificar que el docente existe (usuarioDAO.findByDni)
        // 3. Verificar que la asignatura/proyecto pertenece a ese docente
        // 4. Verificar que el material existe usando materialDAO.findByIsbn(...)
        // 5. Comprobar duplicados usando
        //    bibliografiaDAO.existeReferenciaDuplicada(dniDocente, codigoAsignaturaProyecto, isbnMaterial)
        //    y si existe lanzar GestionBibliografiaException con mensaje de "referencia duplicada"
        // 6. Si todo es correcto, llamar a bibliografiaDAO.insert(nuevaReferencia)
        // 7. Devolver el resultado de insert (filas afectadas)
        return 0;
    }

    /**
     * RF3: modificar una referencia bibliográfica existente.
     * 
     * // It7:
     */
    public int modificarReferenciaBibliografica(BibliografiaAsignatura referenciaModificada)
            throws GestionBibliografiaException {
        // 1. Validar que referenciaModificada no es nula y tiene campos obligatorios
        // 2. Verificar que el docente existe
        // 3. Verificar que la asignatura/proyecto pertenece al docente
        // 4. Verificar que el material (ISBN) existe
        // 5. Opcional: comprobar que la referencia original existía antes de modificar
        // 6. Llamar a bibliografiaDAO.update(referenciaModificada)
        // 7. Devolver filas afectadas
        return 0;
    }

    /**
     * RF4: eliminar una referencia bibliográfica.
     * 
     * 
     * // It7:
     */
    public int eliminarReferenciaBibliografica(int idReferencia, String dniDocente)
            throws GestionBibliografiaException {
        // 1. Verificar que el docente existe
        // 2. (Opcional) Recuperar la referencia por id y comprobar que pertenece a ese docente
        //    (si no pertenece, lanzar excepción "No autorizado")
        // 3. Llamar a bibliografiaDAO.delete(idReferencia)
        // 4. Devolver filas afectadas
        return 0;
    }

    /**
     * Validación genérica de datos de la referencia (lado servidor).
     * 
     * // It7:
     */
    private void validarDatosBibliografia(BibliografiaAsignatura ref)
            throws GestionBibliografiaException {
        // Comprobar nulos y cadenas vacías:
        // - dniDocente obligatorio
        // - codigoAsignaturaProyecto obligatorio
        // - isbnMaterial obligatorio
        // Si algo falla, lanzar GestionBibliografiaException con mensaje apropiado
    }

    /**
     * Verifica que la asignatura o proyecto pertenece al docente.
     * 
     * // It7:
     */
    private void verificarAsignaturaDeDocente(String dniDocente,
                                              String codigoAsignaturaProyecto)
            throws GestionBibliografiaException {
        // Consultar el repositorio de asignaturas/proyectos
        // (o simularlo si aún no existe)
        // Si el docente no tiene asociada esa asignatura/proyecto:
        //  - lanzar GestionBibliografiaException con mensaje "No autorizado"
    }
}
