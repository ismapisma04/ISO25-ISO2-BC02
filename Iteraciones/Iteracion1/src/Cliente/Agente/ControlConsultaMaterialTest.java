package Cliente.Agente;
import java.io.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Cliente.Agente.ControlConsultaMaterial;


public class ControlConsultaMaterialTest {

	@Test
	public void validarBusquedaIncorrecta() {
		ControlConsultaMaterial cm = new ControlConsultaMaterial();
		assertFalse(cm.validarBusqueda(null));
		assertFalse(cm.validarBusqueda(""));
		assertFalse(cm.validarBusqueda(" "));
			
	}
	
	@Test
	public void validarBusquedaCorrecta() {
		ControlConsultaMaterial cm = new ControlConsultaMaterial();
		assertTrue(cm.validarBusqueda("Informatica"));
		assertTrue(cm.validarBusqueda("Ingenieria del Software"));
		assertTrue(cm.validarBusqueda("02468"));
		assertTrue(cm.validarBusqueda("Autor: Moises Rodriguez"));
	
	}
	
	@Test
	public void enviarSolicitudConCriterios() {
		ControlConsultaMaterial cm = new ControlConsultaMaterial();
		
		String[] criterios = {"Informatica","Ingenieria del Software","02468","Autor: Moises Rodriguez"};
		for(int i=0; i<criterios.length; i++) {
			String criterio = criterios[i];
			String res = cm.enviarSolicitudServidor(criterio);
			
			assertEquals(criterio,res);
		}
	}
}
