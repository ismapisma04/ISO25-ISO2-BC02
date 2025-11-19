package BC02_it1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ControlConsultaMaterialTest {
	@Test
	void busquedaValida() {
		ControlConsultaMaterial ccm = new ControlConsultaMaterial();
		assertTrue(ccm.validarBusqueda("libros"));
	}
	
	@Test
	void busquedaInvalida() {
		ControlConsultaMaterial ccm = new ControlConsultaMaterial();
		assertFalse(ccm.validarBusqueda(null));
		assertFalse(ccm.validarBusqueda(""));
		assertFalse(ccm.validarBusqueda("  "));
	}
	
	void enviarSolicitud() {
		ControlConsultaMaterial ccm = new ControlConsultaMaterial();
		assertEquals("tema",ccm.enviarSolicitudServidor("tema"));
	}
}
