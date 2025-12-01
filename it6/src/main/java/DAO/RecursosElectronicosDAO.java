package DAO;
import java.sql.*;
import java.util.*;
import Dominio.RecursosElectronicos;
import Persistencia.DBBroker;
public class RecursosElectronicosDAO {
	private DBBroker broker;
	public RecursosElectronicosDAO() throws SQLException{
		this.broker=DBBroker.instance();
	}
	public int insert(RecursosElectronicos r) {
		String sql="INSERT INTO recursos_electronicos (id, titulo, categoria, contenido) " +
    		    "VALUES ('" + r.getId() + "', '" + r.getTitulo() + "', '" +
    		    r.getCategoria() + "', '" + r.getContenido() + ")";
		return DBBroker.instance().change(sql);
	}
	public int delete(String id) {
    	String sql = "DELETE FROM recursos_electronicos WHERE id = '" + id +"'";
        return DBBroker.instance().change(sql);
    }
	public int update(RecursosElectronicos r) {

        String sql =
            "UPDATE recursos_electronicos SET " +
            "titulo='" + r.getTitulo() + "', " +
            "categoria='" + r.getCategoria() + "', " +
            "contenido=" + r.getContenido() + " " +
            "WHERE id='" + r.getId() + "'";

        return DBBroker.instance().change(sql);
    }
public RecursosElectronicos findById(String id) {
    	
    	RecursosElectronicos m = new RecursosElectronicos();
        String sql = "SELECT * FROM recursos_electronicos WHERE id = '" + id +"'";
        
        List<String[]> table = DBBroker.instance().read(sql);
        if (!table.isEmpty()) {
            String[] row = table.get(0);
            m.setId(row[0]);
            m.setTitulo(row[1]);
            m.setCategoria(row[2]);
            m.setContenido(row[3]);
        }
        return m;
    }

  
    public List<RecursosElectronicos> readAll() {
    	List<RecursosElectronicos> lista = new ArrayList<>();
        String sql = "SELECT * FROM recursos_electronicos ORDER BY titulo ASC";
        List<String[]> rows = broker.instance().read(sql);
        

        for (String[] row : rows) {
            RecursosElectronicos m = new RecursosElectronicos();
            
            m.setId(row[0]);
            m.setTitulo(row[1]);
            m.setCategoria(row[2]);
            m.setContenido(row[3]); 
            
            lista.add(m);
        }
        
        
        return lista;
    }

}
