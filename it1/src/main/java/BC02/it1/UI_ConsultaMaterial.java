package src.main.java.BC02.it1;
import java.util.*;
public class UI_ConsultaMaterial {
	private String criterioBusqueda;
	final static Scanner TECLADO=new Scanner(System.in);
    public void mostrarFormulario() {
        System.out.println("=== Consulta de Material Bibliográfico ===");
        System.out.print("Ingrese criterio de búsqueda (título, autor o categoría): ");
    }

    public String capturarEntrada() {
        criterioBusqueda = TECLADO.nextLine();
        return criterioBusqueda;
    }

    public void mostrarResultado(MaterialBibliografico material) {
        if (material != null)
            System.out.println(material.getDatos());
        else
            System.out.println("No se encontró ningún resultado.");
    }
}
