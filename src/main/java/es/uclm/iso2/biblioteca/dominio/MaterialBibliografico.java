package es.uclm.iso2.biblioteca.dominio;

public class MaterialBibliografico {

    private String titulo;
    private String autor;
    private String isbn; 
    private String categoria;
    private int anioPublicacion;

    
    public MaterialBibliografico() {
    	this.titulo = "";
    	this.autor = "";
    	this.isbn = "";
    	this.categoria = "";
    	this.anioPublicacion = 0;
    }
    
    
    
    public MaterialBibliografico(String titulo, String autor,
                                 String isbn, String categoria, int anioPublicacion) {
        
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.anioPublicacion = anioPublicacion;
    }

   

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getDatos() {
        return titulo + ";" + autor + ";" + isbn + ";" +
               categoria + ";" + anioPublicacion;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

}
