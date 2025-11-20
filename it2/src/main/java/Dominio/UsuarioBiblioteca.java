package Dominio;

public class UsuarioBiblioteca {

   
    private String nombre;
    private String apellidos;
    private String email;
    private String dni;
    private String fechaCreacion;

    
    public UsuarioBiblioteca() {
	this.nombre = "";
	this.apellidos = "";
	this.email = "";
	this.dni = "";
	this.fechaCreacion = "";
	}
    
    
    public UsuarioBiblioteca(String nombre, String apellidos,
                             String email, String dni, String fechaCreacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.dni = dni;
        this.fechaCreacion = fechaCreacion;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }
    
    public String getFechaCreacion() {
    	return fechaCreacion;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public void setFechaCreacion(String fechaCreacion) {
    	this.fechaCreacion = fechaCreacion;	
    }

    public String getDatos() {
        return nombre + ";" + apellidos + ";" + email + ";" + dni;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + dni + ")";
    }
}
