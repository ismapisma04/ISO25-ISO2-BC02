package Servidor.Dominio;
import java.sql.*;
public class RepositorioDeMaterial {
	private String url="jdbc:mysql://localhost:3306/biblioteca";
	private String user="root";
	private String password="1234";
	public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado a MySQL correctamente.");
            return conexion;
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }
}