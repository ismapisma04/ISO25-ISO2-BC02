package Servicio;
import java.sql.*;
import DAO.ReservaDAO;
import Dominio.Reserva;
public class ServicioGestionReservas {
	private ReservaDAO reservaDAO;
	public ServicioGestionReservas() throws SQLException {
		this.reservaDAO=new ReservaDAO();
	}
	public void enviarReserva(Reserva r) throws GestionReservasException{
		Reserva existe=reservaDAO.buscarPorEjemplar(r.getIdEjemplar());
		if(existe.getIdUsuario()!=null) {
			throw new GestionReservasException("Error. Esta reserva ya existe");
		}
	}
	public void solicitarCancelacion(String idEjemplar) throws GestionReservasException{
		Reserva r=reservaDAO.buscarPorEjemplar(idEjemplar);
		if(r==null) {
			throw new GestionReservasException("Error. La reserva solicitada no existe");
		}
		else if(reservaDAO.reservaActiva(r)) {
			throw new GestionReservasException("Error. La reserva que desea cancelar está todavía activa");
		}
	}
	public void procesarCancelacionReserva(String idEjemplar) throws GestionReservasException{
		Reserva r=reservaDAO.buscarPorEjemplar(idEjemplar);
		reservaDAO.delete(r.getIdUsuario());
	}
	public void registrarReserva(Reserva r) {
		reservaDAO.insert(r);
	}
    public void validarFormatoReserva(Reserva r) throws GestionReservasException {

        if (r == null) {
            throw new GestionReservasException("La reserva no puede ser nula.");
        }

        if (r.getIdUsuario() == null || r.getIdUsuario()=="") {
            throw new GestionReservasException("El id del usuario es obligatorio.");
        }

        if (r.getIdEjemplar() == null || r.getIdEjemplar()=="") {
            throw new GestionReservasException("El id del ejemplar es obligatorio.");
        }

        if (r.getFechaSolicitud() == null) {
            throw new GestionReservasException("La fecha de solicitud es obligatoria.");
        }
        
        if (r.getEstado() == null || r.getEstado()=="") {
            throw new GestionReservasException("El estado es obligatorio.");
        }
    }
}
