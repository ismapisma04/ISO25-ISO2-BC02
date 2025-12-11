package es.uclm.iso2.biblioteca.dominio;

import java.time.LocalDate;

public class PrestamosBiblioteca {

    private String idUsuario;
    private String idEjemplar;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    public PrestamosBiblioteca() {
        this.idUsuario = "";
        this.idEjemplar = "";
        this.fechaInicio = null;
        this.fechaFin = null;
        this.estado = "";
    }

    public PrestamosBiblioteca(String idUsuario, String idEjemplar,
                               LocalDate fechaInicio, LocalDate fechaFin, String estado) {

        this.idUsuario = idUsuario;
        this.idEjemplar = idEjemplar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public String getDatos() {
        return idUsuario + ";" + idEjemplar + ";" +
               fechaInicio + ";" + fechaFin + ";" + estado;
    }

    @Override
    public String toString() {
        return "Préstamo para el usuario " + idUsuario + " del ejemplar " + idEjemplar ;
    }

    public void setId(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsuario_dni(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFecha_devolucion(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDevuelto(String estado) {
        this.estado = estado;
    }
}

