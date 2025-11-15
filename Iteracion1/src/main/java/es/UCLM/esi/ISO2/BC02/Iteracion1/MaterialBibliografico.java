package es.UCLM.esi.ISO2.BC02.Iteracion1;

public class MaterialBibliografico {
	private String titulo;
    private String autor;
    private String categoria;
    private int año;

    public MaterialBibliografico(String titulo, String autor, String categoria, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.año = año;
    }

    public String getDatos() {
        return "Título: " + titulo + ", Autor: " + autor + 
               ", Categoría: " + categoria + ", Año: " + año;
    }
}
