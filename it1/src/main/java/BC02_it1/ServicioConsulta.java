package BC02_it1;

public class ServicioConsulta {
	 public MaterialBibliografico buscarMaterial(String criterio) {
	        RepositorioDelMaterial repo = new RepositorioDelMaterial();
	        return repo.consultarBD(criterio);
	    }

	    public MaterialBibliografico formatearRespuesta(MaterialBibliografico material) {
	        return material; // En caso de querer aplicar transformaciones
	    }
}
