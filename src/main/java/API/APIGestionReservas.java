package API;
import Dominio.Reserva;
import java.sql.*;
import Servicio.*;
public class APIGestionReservas {
	private ServicioGestionReservas servicio;
	public APIGestionReservas() throws SQLException{
		this.servicio= new ServicioGestionReservas();
	}
	public void hacerReserva(Reserva r) throws GestionReservasException{
		try {
			servicio.validarFormatoReserva(r);
			servicio.enviarReserva(r);
		}
		catch(GestionReservasException e) {
			System.out.println(e.getMessage());
			return;
		}
		servicio.registrarReserva(r);
	}
	public void eliminarReserva(String idEjemplar)throws GestionReservasException {
		try {
			servicio.solicitarCancelacion(idEjemplar);
		}
		catch(GestionReservasException e) {
			System.out.println(e.getMessage());
			return;
		}
		servicio.procesarCancelacionReserva(idEjemplar);
	}
}
