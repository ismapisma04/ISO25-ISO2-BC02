package BC02_it1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ServicioConsultaTest {
	
	@Test
	void busquedaMaterial() {
		ServicioConsulta s = new ServicioConsulta();
		MaterialBibliografico mb = s.buscarMaterial("Informatica");
		assertNotNull(mb);
		assertEquals("Informatica",mb.getDatos());
		
	}
	
	@Test
	void formateoRespuesta() {
		ServicioConsulta s = new ServicioConsulta();
		MaterialBibliografico mb = new MaterialBibliografico("El Quijote","Cervantes","Novela",1605);
		
		MaterialBibliografico mb2 = s.formatearRespuesta(mb);
		assertSame(mb,mb2); //mismo objeto
		
	}
}
