package Presentacion;
import java.util.*;
import Dominio.Reserva;
import Servicio.GestionReservasException;
import API.APIGestionReservas;
import java.sql.*;
public class VentanaGestionReservas {
	final static Scanner sc=new Scanner(System.in);
	private APIGestionReservas api;
	private Reserva r;
	private String idUsuario;
	private String idEjemplar;
	public VentanaGestionReservas() throws SQLException, InputMismatchException{
		this.api=new APIGestionReservas();
		System.out.println("Bienvenido a la gestión de reservas de la biblioteca");
		System.out.print("Para empezar, introduce su identificador de  usuario: ");
		this.idUsuario=sc.nextLine();
		System.out.print("!Perfecto¡, ahora introduce el identificador del ejemplar que desea reservar o cancelar: ");
		this.idEjemplar=sc.nextLine();
		this.r=new Reserva(idUsuario,idEjemplar);
	}
	public void Reservar() throws GestionReservasException {
		api.hacerReserva(r);
	}
	public void Cancelar() throws GestionReservasException {
		api.eliminarReserva(idEjemplar);
	}
}
