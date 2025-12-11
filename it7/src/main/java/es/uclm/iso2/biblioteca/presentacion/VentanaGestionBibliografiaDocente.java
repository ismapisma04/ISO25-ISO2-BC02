package es.uclm.iso2.biblioteca.presentacion;

import es.uclm.iso2.biblioteca.api.API_GestionBibliografiaDocente;
import es.uclm.iso2.biblioteca.dominio.BibliografiaAsignatura;
import es.uclm.iso2.biblioteca.servicio.GestionBibliografiaException;

import java.util.List;
import java.util.Scanner;

/**
 * Ventana de gestión de bibliografía para docentes (lado cliente).
 * Podría ser consola o la lógica interna de una interfaz Swing.
 * // It7:
 */
public class VentanaGestionBibliografiaDocente {

    private final Scanner sc = new Scanner(System.in);

    // API para comunicarse con el "servidor"
    private final API_GestionBibliografiaDocente apiBibliografia =
            new API_GestionBibliografiaDocente();

    // DNI del docente que ha iniciado sesión
    private String dniDocente;

    /**
     * Flujo principal de la ventana:
     *  - Asumir que el docente ya se ha autenticado y su DNI está disponible
     *  - Mostrar asignaturas/proyectos disponibles
     *  - Permitir seleccionar una
     *  - Mostrar y gestionar referencias (alta, baja, modificación)
     *  
     *  // It7:
     */
    public void ejecutarGestionBibliografia(String dniDocenteLogueado) {
        // 1. Guardar el DNI del docente logueado en el atributo dniDocente
        // 2. Mostrar un menú principal:
        //    - Seleccionar asignatura/proyecto
        //    - Salir
        // 3. Al seleccionar una asignatura/proyecto:
        //    - Llamar a un método que gestione las operaciones de bibliografía
    	
    	// It7:
        this.dniDocente = dniDocenteLogueado;
    }

    /**
     * Muestra las asignaturas/proyectos disponibles para el docente.
     * (por ahora se puede simular o dejar como comentario si aún no tienes esa parte)
     * 
     * // It7:
     */
    public void mostrarAsignaturasYProyectos() {
        // 1. Recuperar la lista de asignaturas/proyectos del docente
        //    (desde otro servicio o API que no hemos definido todavía)
        // 2. Mostrar la lista por pantalla o en la interfaz gráfica
        // 3. Si no hay asignaturas/proyectos, mostrar un mensaje informativo
    }

    /**
     * Permite al docente seleccionar una asignatura/proyecto de la lista.
     * 
     * // It7:
     */
    public String seleccionarAsignaturaOProyecto() {
        // 1. Pedir al usuario que introduzca el código de la asignatura/proyecto
        // 2. Leer el código desde Scanner o componente de UI
        // 3. Devolver el código seleccionado
        return null;
    }

    /**
     * RF1 (cliente): visualizar las referencias bibliográficas
     * asociadas a la asignatura/proyecto seleccionada.
     * 
     * // It7:
     */
    public void visualizarBibliografia(String codigoAsignaturaProyecto) {
        try {
            // 1. Invocar apiBibliografia.obtenerBibliografiaDocente(dniDocente, codigoAsignaturaProyecto)
            List<BibliografiaAsignatura> lista =
                    apiBibliografia.obtenerBibliografiaDocente(dniDocente, codigoAsignaturaProyecto);

            // 2. Si la lista está vacía, mostrar mensaje informativo
            //    "No hay referencias asociadas"
            // 3. Si hay elementos, mostrarlos uno a uno
        } catch (GestionBibliografiaException e) {
            // 4. Si ocurre un error, mostrar mensaje de error genérico o el detalle
            //    según lo que se pida en el enunciado
        }
    }

    /**
     * RF2: alta de nueva referencia bibliográfica.
     * 
     * // It7:
     */
    public void altaReferencia(String codigoAsignaturaProyecto) {
        // 1. Pedir al usuario los datos de la nueva referencia (ISBN, etc.)
        // 2. Validar en cliente los campos obligatorios (si falta algo, mostrar error y no llamar al servidor)
        // 3. Crear un objeto BibliografiaAsignatura y rellenar sus campos
        BibliografiaAsignatura nueva = new BibliografiaAsignatura();
        //    - setDniDocente(dniDocente)
        //    - setCodigoAsignaturaProyecto(codigoAsignaturaProyecto)
        //    - setIsbnMaterial(...)

        try {
            // 4. Llamar a apiBibliografia.altaReferencia(nueva)
            int filas = apiBibliografia.altaReferencia(nueva);

            // 5. Si filas > 0, mostrar mensaje de éxito
            // 6. Si filas == 0, mostrar mensaje de que no se realizó ninguna operación
        } catch (GestionBibliografiaException e) {
            // 7. Si la excepción indica referencia duplicada, mostrar mensaje específico
            // 8. Para otros errores, mostrar mensaje genérico de error
        }
    }

    /**
     * RF3: modificación de una referencia existente.
     * 
     * // It7:
     */
    public void modificarReferencia(String codigoAsignaturaProyecto) {
        // 1. Mostrar la lista de referencias actuales (puede llamar a visualizarBibliografia)
        // 2. Pedir al docente que seleccione la referencia a modificar (por id o por ISBN)
        // 3. Pedir los nuevos datos para la referencia
        // 4. Validar en cliente los campos obligatorios
        // 5. Crear un objeto BibliografiaAsignatura con los datos modificados
        BibliografiaAsignatura modificada = new BibliografiaAsignatura();
        //    - setId(idReferenciaSeleccionada)
        //    - setDniDocente(dniDocente)
        //    - setCodigoAsignaturaProyecto(codigoAsignaturaProyecto)
        //    - setIsbnMaterial(nuevoIsbn)

        try {
            // 6. Llamar a apiBibliografia.modificarReferencia(modificada)
            int filas = apiBibliografia.modificarReferencia(modificada);

            // 7. Según el resultado, mostrar mensaje de éxito o aviso si filas == 0
        } catch (GestionBibliografiaException e) {
            // 8. Mostrar mensaje de error específico o genérico según el tipo de fallo
        }
    }

    /**
     * RF4: eliminación de una referencia bibliográfica.
     * 
     * // It7:
     */
    public void eliminarReferencia(String codigoAsignaturaProyecto) {
        // 1. Mostrar la lista de referencias actuales para esa asignatura/proyecto
        // 2. Pedir al usuario que seleccione qué referencia quiere eliminar (por id)
        int idReferenciaSeleccionada = 0; // Este valor debería leerse de la entrada del usuario

        try {
            // 3. Llamar a apiBibliografia.eliminarReferencia(idReferenciaSeleccionada, dniDocente)
            int filas = apiBibliografia.eliminarReferencia(idReferenciaSeleccionada, dniDocente);

            // 4. Si filas > 0, mostrar mensaje de confirmación
            // 5. Si filas == 0, mostrar mensaje indicando que no se eliminó nada
        } catch (GestionBibliografiaException e) {
            // 6. Si el error indica "No autorizado", mostrar ese mensaje
            // 7. Para otros errores, mostrar mensaje genérico
        }
    }

    /**
     * RF5: método genérico para mostrar mensajes de confirmación o error.
     * 
     * // It7:
     */
    public void mostrarMensajeOperacion(String mensaje, boolean esError) {
        // Si esError es true, mostrar el mensaje como error (por ejemplo, en rojo o con prefijo "ERROR:")
        // Si esError es false, mostrar el mensaje como confirmación/éxito
        // Este método se puede reutilizar en toda la clase para centralizar la lógica de mensajes
    }
}

