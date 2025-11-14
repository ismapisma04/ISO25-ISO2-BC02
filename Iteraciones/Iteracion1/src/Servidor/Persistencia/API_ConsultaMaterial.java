package Servidor.Persistencia;

public class API_ConsultaMaterial {
	public Cliente.Dominio.MaterialBibliografico recibirSolicitud(String criterio) {
        System.out.println("Servidor recibió solicitud con criterio de búsqueda: " + criterio);
        Servidor.Agente.ServicioConsulta servicio = new Servidor.Agente.ServicioConsulta();
        return servicio.buscarMaterial(criterio);
    }

    public void devolverRespuesta(Cliente.Dominio.MaterialBibliografico resultado) {
        if (resultado != null) {
            System.out.println("Resultado encontrado:");
            System.out.println(resultado.getDatos());
        } else {
            System.out.println("No se encontraron materiales bibliográficos");
        }
    }
}
