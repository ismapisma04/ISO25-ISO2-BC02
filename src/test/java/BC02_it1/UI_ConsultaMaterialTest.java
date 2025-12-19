package BC02_it1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UI_ConsultaMaterialTest {
	@Test
	void resultadoConMaterial() {
		UI_ConsultaMaterial uic = new UI_ConsultaMaterial();
		MaterialBibliografico mb = new MaterialBibliografico("El Quijote","Cervantes","Novela",1605);
		assertDoesNotThrow(()->uic.mostrarResultado(mb));
	}
	
	@Test
	void resultadoSinMaterial() {
		UI_ConsultaMaterial uic = new UI_ConsultaMaterial();
		assertDoesNotThrow(()->uic.mostrarResultado(null));
	}
}
