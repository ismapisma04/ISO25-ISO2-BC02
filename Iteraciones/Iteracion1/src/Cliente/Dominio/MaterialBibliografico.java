package Cliente.Dominio;
public class MaterialBibliografico {
	private String titulo;
	private String autor;
	private String categoria;
	private int año;
	public MaterialBibliografico(String Titulo, String Autor, String Categoria, int Año) {
		this.titulo=Titulo;
		this.autor=Autor;
		this.categoria=Categoria;
		this.año=Año;
	}
	public String getDatos() {
		return "Título: " + titulo + ", Autor: " + autor + ", Categoría: " + categoria + ", Año: " + año;
	}
}
