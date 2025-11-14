package Cliente.Agente;
public class ControlConsultaMaterial {
	public boolean validarBusqueda(String criterio) {
        return criterio != null && !criterio.trim().isEmpty();
    }

    public String enviarSolicitudServidor(String criterio) {
        System.out.println("Enviando solicitud al servidor con el criterio de búsqueda " + criterio);
        return criterio;
    }
}
