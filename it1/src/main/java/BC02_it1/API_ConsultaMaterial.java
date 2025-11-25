package BC02_it1;

public class API_ConsultaMaterial {
	public MaterialBibliografico recibirSolicitud(String criterio) {
        System.out.println("Servidor recibió solicitud con criterio: " + criterio);
        ServicioConsulta servicio = new ServicioConsulta();
        return servicio.buscarMaterial(criterio);
    }

    public void devolverRespuesta(MaterialBibliografico resultado) {
        if (resultado != null) {
            System.out.println("Resultado encontrado:");
            System.out.println(resultado.getDatos());
        } else {
            System.out.println("No se encontraron materiales bibliográficos.");
        }
    }
}
