package Dominio;

import java.time.LocalDate;

public class Reserva {
	private LocalDate fecha_solicitud;
	private String estado;
	public Reserva(LocalDate Fecha_solicitud, String Estado) {
		super();
		this.fecha_solicitud = Fecha_solicitud;
		this.estado = Estado;
	}

	public LocalDate getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(LocalDate fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String toString() {
		return "Reserva con fecha de solicitud=" + fecha_solicitud + ", y estado=" + estado + "]";
	}
	
}
