package BC02_it1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MaterialBibliograficoTest {

    @Test
    void probarDatos() {
        MaterialBibliografico mb = new MaterialBibliografico("El Quijote","Cervantes","Novela",1605);
        String data = mb.getDatos();
        assertTrue(data.contains("El Quijote"));
        assertTrue(data.contains("Cervantes"));
        assertTrue(data.contains("Novela"));
        assertTrue(data.contains("1605"));
    }
}