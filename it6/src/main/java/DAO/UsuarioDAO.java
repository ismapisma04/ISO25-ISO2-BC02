package DAO;


import Dominio.UsuarioBiblioteca;
import Persistencia.DBBroker;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static DBBroker broker;

    public UsuarioDAO() throws SQLException {
        this.broker = DBBroker.instance();
    }
    
    
    
    
    

    public int insert(UsuarioBiblioteca u) {

        String sql =
            "INSERT INTO usuarios_biblioteca (dni, nombre, apellidos, email, fecha_creacion) " +
            "VALUES ('" + u.getDni() + "', '" + u.getNombre() + "', '" + u.getApellidos() + "', '" +
            u.getEmail() + "', '" + u.getFechaCreacion() + "')";

        return broker.instance().change(sql);
    }
    
    
    public int delete(String dni) {
    	String sql = "DELETE FROM usuarios_biblioteca WHERE dni = '"+dni+"'";
    	
        return DBBroker.instance().change(sql);
    }


    public int update(UsuarioBiblioteca u) {
        String sql = (
                "UPDATE usuarios_biblioteca SET nombre = '"+u.getNombre()+"', apellidos = '"+u.getApellidos()+
                "', email = '"+u.getEmail()+"', fecha_creacion = '"+u.getFechaCreacion()+ "' WHERE dni = '"+u.getDni()+"'");
        
        
        return broker.instance().change(sql);
    }
    
    
    public UsuarioBiblioteca findByDni(String dni) {
    	
    	UsuarioBiblioteca u = new UsuarioBiblioteca();
        String sql = "SELECT * FROM usuarios_biblioteca WHERE dni = '"+dni+"'";
        
        List<String[]> table = DBBroker.instance().read(sql);
        if (!table.isEmpty()) {
            String[] row = table.get(0);

            u.setNombre(row[0]);
            u.setApellidos(row[1]);
            u.setEmail(row[2]);
            u.setDni(row[3]);
            u.setFechaCreacion(row[4]);
        }

        return u;
    }

  
    public List<UsuarioBiblioteca> readAll() {
    	List<UsuarioBiblioteca> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios_biblioteca ORDER BY email ASC";
        List<String[]> rows = broker.instance().read(sql);
        

        for (String[] row : rows) {
        	UsuarioBiblioteca u = new UsuarioBiblioteca();
            
        	u.setDni(row[0]);
            u.setNombre(row[1]);
            u.setApellidos(row[2]);
            u.setEmail(row[3]);
            u.setFechaCreacion(row[4]);
            
            lista.add(u);
        }
        
        
        return lista;
    }

}
