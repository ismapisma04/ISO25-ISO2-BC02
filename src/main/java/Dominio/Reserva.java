package Dominio;

import java.time.LocalDate;

public class Reserva {
	private LocalDate fechaSolicitud;
	private String estado;
	private String idUsuario;
	private String idEjemplar;
	public Reserva() {
		this.idUsuario="";
		this.idEjemplar="";
		this.fechaSolicitud=LocalDate.now();
		this.estado="";
	}
	public Reserva(String idUsuario, String idEjemplar) {
		this.idUsuario=idUsuario;
		this.idEjemplar=idEjemplar;
		this.fechaSolicitud=LocalDate.now();
		this.estado="Activa";
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(String idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String toString() {
		return "Reserva para el usuario "+idUsuario+", del ejemplar "+idEjemplar+ ", fecha de solicitud " + fechaSolicitud + ", y estado " + estado ;
	}
}
