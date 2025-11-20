package Dominio;

public class RecursosElectronicos {
	private String id;
	private String titulo;
	private String categoria;
	private String contenido;
	public RecursosElectronicos() {
		this.id="";
		this.titulo="";
		this.categoria="";
		this.contenido="";
	}
	public RecursosElectronicos(String Id, String Titulo, String Categoria, String Contenido) {
		this.id=Id;
		this.titulo=Titulo;
		this.categoria=Categoria;
		this.contenido=Contenido;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String toString() {
		return "Recurso electrónico con id " + id + ", titulo " + titulo + ", categoria " + categoria + ", contenido "
				+ contenido;
	}	
}
