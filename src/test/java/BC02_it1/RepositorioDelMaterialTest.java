package BC02_it1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class RepositorioDelMaterialTest {
	@Test
	void conexion() {
		RepositorioDelMaterial rm = new RepositorioDelMaterial();
		assertDoesNotThrow(() -> rm.conectar());
	}
}
