package es.uclm.iso2.biblioteca.dao;

import es.uclm.iso2.biblioteca.dominio.MaterialBibliografico;
import es.uclm.iso2.biblioteca.persistencia.DBBroker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

	 private final DBBroker broker;

	 public MaterialDAO() throws SQLException {
		 this.broker = DBBroker.getInstance();
	 }



	 
	 
 
    public int insert(MaterialBibliografico m) {
    	String sql =
    		    "INSERT INTO material_bibliografico (titulo, autor, isbn, categoria, anio_publicacion) " +
    		    "VALUES ('" + m.getTitulo() + "', '" + m.getAutor() + "', '" +
    		    m.getIsbn() + "', '" + m.getCategoria() + "', " + m.getAnioPublicacion() + ")";

        
        return broker.getInstance().change(sql);
    }
    
    
    public int delete(String isbn) {
    	String sql = "DELETE FROM material_bibliografico WHERE isbn = '" + isbn +"'";
    	
        return DBBroker.getInstance().change(sql);
    }

  
    public int update(MaterialBibliografico m) {

        String sql =
            "UPDATE material_bibliografico SET " +
            "titulo='" + m.getTitulo() + "', " +
            "autor='" + m.getAutor() + "', " +
            "categoria='" + m.getCategoria() + "', " +
            "anio_publicacion=" + m.getAnioPublicacion() + " " +
            "WHERE isbn='" + m.getIsbn() + "'";

        return DBBroker.getInstance().change(sql);
    }

    
    
    public MaterialBibliografico findByIsbn(String isbn) {
    	
    	MaterialBibliografico m = new MaterialBibliografico();
        String sql = "SELECT * FROM material_bibliografico WHERE isbn = '" + isbn +"'";
        
        List<String[]> table = DBBroker.getInstance().read(sql);
        if (!table.isEmpty()) {
            String[] row = table.get(0);

            m.setTitulo(row[0]);
            m.setAutor(row[1]);
            m.setTitulo(row[2]);
            m.setIsbn(row[3]);
            m.setCategoria(row[4]);
            m.setAnioPublicacion(Integer.parseInt(row[4]));
        }

        return m;
    }

  
    public List<MaterialBibliografico> readAll() {
    	List<MaterialBibliografico> lista = new ArrayList<>();
        String sql = "SELECT * FROM material_bibliografico ORDER BY titulo ASC";
        List<String[]> rows = broker.getInstance().read(sql);
        

        for (String[] row : rows) {
            MaterialBibliografico m = new MaterialBibliografico();
            
            m.setTitulo(row[0]);
            m.setAutor(row[1]);
            m.setTitulo(row[2]);
            m.setIsbn(row[3]);
            m.setCategoria(row[4]);
            m.setAnioPublicacion(Integer.parseInt(row[4])); 
            
            lista.add(m);
        }
        
        
        return lista;
    }

}

