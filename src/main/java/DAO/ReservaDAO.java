package DAO;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import Persistencia.DBBroker;
import Dominio.Reserva;
public class ReservaDAO {
	private final DBBroker broker;
	public ReservaDAO() throws SQLException {
		this.broker= DBBroker.instance();
	}
	public int insert(Reserva r) {
		String sql="INSERT INTO reservas (idUsuario,idEjemplar,fechaSolicitud,estado)"+
					"VALUES ('"+r.getIdUsuario()+"', '"+r.getIdEjemplar()+"', '"+r.getFechaSolicitud()
					+"', "+r.getEstado()+")";
		
		return broker.instance().change(sql);
	}
	public int delete(String idUsuario) {
		String sql="DELETE FROM reservas WHERE idUsuario = '" + idUsuario +"'";
		return broker.instance().change(sql);
	}
	public Reserva buscarPorEjemplar(String idEjemplar) {
		Reserva r = new Reserva();
        String sql = "SELECT * FROM reservas WHERE idEjemplar = '" + idEjemplar +"'";
        List<String[]> table = DBBroker.instance().read(sql);
        if (!table.isEmpty()) {
            String[] row = table.get(0);
            r.setIdUsuario(row[0]);
            r.setIdEjemplar(row[1]);
            r.setFechaSolicitud(LocalDate.parse(row[2]));
            r.setEstado(row[3]);
        }
        return r;
	}
	public boolean reservaActiva(Reserva r) {
		return r.getFechaSolicitud().isAfter(LocalDate.now());
	}
}
