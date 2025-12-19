package Persistencia;
import java.sql.*;
import java.util.*;
public class DBBroker {
	private static String cadenaConexion;
	private static Connection conexion;
	private static DBBroker instancia;
	public DBBroker() {
		try {
			DBBroker.cadenaConexion="jdbc:mysql://localhost:3306/biblioteca";
			String usuario="root";
			String contrasenia="1234";
			DBBroker.conexion=DriverManager.getConnection(cadenaConexion,usuario,contrasenia);
		}
		catch(SQLException e) {
			throw new RuntimeException("Error al conectar con la base de datos: "+e.getMessage());
		}
	}
	public static DBBroker instance() {
		if(instancia==null) {
			instancia=new DBBroker();
		}
		return instancia;
	}
	public void conectar() {
		try {
			if(conexion!=null&&conexion.isClosed()) {
				conexion=DriverManager.getConnection(cadenaConexion,"root","1234");
			}
		}
		catch(SQLException e) {
			throw new RuntimeException("Error al conectar con la base de datos: "+e.getMessage());
		}
	}
	public void desconectar() {
		try {
			if(conexion!=null&&!conexion.isClosed()) {
				conexion.close();
			}
		}
		catch(SQLException e) {
			throw new RuntimeException("Error al desconectar base de datos: "+e.getMessage());
		}
	}
	public List<String[]> read(String sql){
		List<String[]> resultado=new ArrayList<>();
		conectar();
		try(Statement stmt=conexion.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			int columnas=rs.getMetaData().getColumnCount();
			while(rs.next()) {
				String [] fila= new String[columnas];
				for(int i=0;i<columnas;i++) {
					fila[i]=rs.getString(i+1);
				}
				resultado.add(fila);
			}
		}
		catch(SQLException e) {
			throw new RuntimeException("Error en el READ: "+e.getMessage());
		}
		desconectar();
		return resultado;
	}
	public int change(String sql) {
		conectar();
		int filas=0;
		try (Statement stmt = conexion.createStatement()) {
            filas = stmt.executeUpdate(sql);
		}
		catch(SQLException e) {
			throw new RuntimeException("Error en el CHANGE "+e.getMessage());
		}
		desconectar();
		return filas;
	}
}
