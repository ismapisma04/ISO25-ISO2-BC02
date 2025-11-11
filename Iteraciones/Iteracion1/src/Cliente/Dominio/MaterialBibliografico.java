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
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public int getAño() {
		return año;
	}
}
