package es.uclm.iso2.biblioteca.dominio;

/**
 * Representa una referencia bibliográfica asociada
 * a una asignatura o proyecto concreto de un docente. 
 * 
 * // It7: (La clase entera pertenece a esta iteracion)
 */
public class BibliografiaAsignatura {

    // Identificador único de la entrada de bibliografía
    private int id;

    // DNI del docente propietario de esta bibliografía
    private String dniDocente;

    // Código de la asignatura o proyecto (por ejemplo "ISO2", "TFG-123")
    private String codigoAsignaturaProyecto;

    // ISBN del material bibliográfico referenciado
    private String isbnMaterial;

    // Constructor por defecto
    public BibliografiaAsignatura() {
        // Inicializar atributos a valores por defecto
    }

    // Constructor con parámetros
    public BibliografiaAsignatura(int id, String dniDocente,
                                  String codigoAsignaturaProyecto, String isbnMaterial) {
        // Asignar parámetros a atributos
    }

    // Getters y setters con comentarios explicando qué devuelven/asignan

    public int getId() {
        // Devolver el identificador de la entrada de bibliografía
        return id;
    }

    public void setId(int id) {
        // Asignar el identificador de la entrada de bibliografía
        this.id = id;
    }

    public String getDniDocente() {
        // Devolver el DNI del docente propietario
        return dniDocente;
    }

    public void setDniDocente(String dniDocente) {
        // Asignar el DNI del docente propietario
        this.dniDocente = dniDocente;
    }

    public String getCodigoAsignaturaProyecto() {
        // Devolver el código de asignatura o proyecto asociado
        return codigoAsignaturaProyecto;
    }

    public void setCodigoAsignaturaProyecto(String codigoAsignaturaProyecto) {
        // Asignar el código de asignatura o proyecto asociado
        this.codigoAsignaturaProyecto = codigoAsignaturaProyecto;
    }

    public String getIsbnMaterial() {
        // Devolver el ISBN del material referenciado
        return isbnMaterial;
    }

    public void setIsbnMaterial(String isbnMaterial) {
        // Asignar el ISBN del material referenciado
        this.isbnMaterial = isbnMaterial;
    }

    public String getDatos() {
        // Construir y devolver una representación en texto de la entrada
        // (por ejemplo: "dniDocente;codigo;isbn")
        return null;
    }

    @Override
    public String toString() {
        // Devolver una descripción amigable de la referencia
        // (por ejemplo: "codigoAsignaturaProyecto - isbnMaterial (dniDocente)")
        return null;
    }
}

