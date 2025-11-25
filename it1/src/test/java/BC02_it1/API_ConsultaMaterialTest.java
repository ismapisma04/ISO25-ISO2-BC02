package BC02_it1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class API_ConsultaMaterialTest {
	@Test
	void recibimientoSolicitud() {
		API_ConsultaMaterial apicm = new API_ConsultaMaterial();
		MaterialBibliografico mb = apicm.recibirSolicitud("Informatica");
		
		assertNotNull(mb);
		assertTrue(mb.getDatos().contains("Informatica"));
	}
	@Test
	void devolverRespuestaMaterial() {
		API_ConsultaMaterial apicm = new API_ConsultaMaterial();
		MaterialBibliografico mb = new MaterialBibliografico("El Quijote","Cervantes","Novela",1605);
		assertDoesNotThrow(()->apicm.devolverRespuesta(mb));
	}
	
	@Test
	void devolverRespuestaSinMaterial() {
		API_ConsultaMaterial apicm = new API_ConsultaMaterial();
		assertDoesNotThrow(()->apicm.devolverRespuesta(null));
	}
}
