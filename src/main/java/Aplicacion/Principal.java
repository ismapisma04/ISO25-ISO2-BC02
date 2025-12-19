package Aplicacion;
import Presentacion.VentanaGestionReservas;
import java.sql.*;
import Servicio.GestionReservasException;
import java.util.Scanner;
public class Principal {
	final static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws SQLException, GestionReservasException{
		VentanaGestionReservas v=new VentanaGestionReservas();
		System.out.print("¿Desea reservar, o cancelar una reserva? (0 reservar, 1 cancelar): ");
		int accion=sc.nextInt();
		if(accion==0) {
			v.Reservar();
			System.out.println("Reservado de ejemplar exitoso");
		}
		else if(accion==1){
			v.Cancelar();
			System.out.println("Reserva cancelada correctamente");
		}
	}
}
