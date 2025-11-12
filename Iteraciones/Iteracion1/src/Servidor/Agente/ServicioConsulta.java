package Servidor.Agente;

public class ServicioConsulta {
	public Cliente.Dominio.MaterialBibliografico buscarMaterial(String criterio) {
        Servidor.Dominio.RepositorioDeMaterial repo = new Servidor.Dominio.RepositorioDeMaterial();
        return repo.consultarBD(criterio);
    }

    public Cliente.Dominio.MaterialBibliografico formatearRespuesta(Cliente.Dominio.MaterialBibliografico material) {
        return material; 
    }
}
