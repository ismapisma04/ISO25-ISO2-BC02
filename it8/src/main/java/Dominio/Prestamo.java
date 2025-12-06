package Dominio;

import java.time.LocalDate;

public class Prestamo {

    private int id;
    private String usuario_dni;
    private String material_isbn;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion;
    private boolean devuelto;

    public Prestamo() {
        this.id = 0;
        this.usuario_dni = "";
        this.material_isbn = "";
        this.fecha_prestamo = null;
        this.fecha_devolucion = null;
        this.devuelto = false;
    }

    public Prestamo(int id, String usuario_dni, String material_isbn,
                               LocalDate fecha_prestamo, LocalDate fecha_devolucion, boolean devuelto) {

        this.id = id;
        this.usuario_dni = usuario_dni;
        this.material_isbn = material_isbn;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.devuelto = devuelto;
    }

    public int getId() {
        return id;
    }

    public String getUsuario_dni() {
        return usuario_dni;
    }

    public String getMaterial_isbn() {
        return material_isbn;
    }

    public LocalDate getFecha_prestamo() {
        return fecha_prestamo;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public boolean getDevuelto() {
        return devuelto;
    }

    public String getDatos() {
        return id + ";" + usuario_dni + ";" + material_isbn + ";" +
               fecha_prestamo + ";" + fecha_devolucion + ";" + devuelto;
    }

    @Override
    public String toString() {
        return "Préstamo " + id + " - " + usuario_dni + " - " + material_isbn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario_dni(String usuario_dni) {
        this.usuario_dni = usuario_dni;
    }

    public void setMaterial_isbn(String material_isbn) {
        this.material_isbn = material_isbn;
    }

    public void setFecha_prestamo(LocalDate fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
}
