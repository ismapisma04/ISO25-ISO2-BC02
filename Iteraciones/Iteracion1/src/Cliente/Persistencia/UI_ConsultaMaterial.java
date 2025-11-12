package Cliente.Persistencia;
import java.util.*;
public class UI_ConsultaMaterial {
	final static Scanner TECLADO=new Scanner(System.in);
	private String criterioBusqueda;
	public void mostrarFormulario() {
		System.out.println("Bienvenido a la consulta de material bibliográfico");
		System.out.println("¿Como desea buscar, por título, autor, categoría, o año?: ");
	}
}
