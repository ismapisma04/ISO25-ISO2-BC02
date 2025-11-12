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
            System.out.println("MySQL se ha conectado correctamente");
            return conexion;
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos de MySQL: " + e.getMessage());
            return null;
        }
    }
    public Cliente.Dominio.MaterialBibliografico consultarBD(String criterio) {
        Connection conn = conectar();
        Cliente.Dominio.MaterialBibliografico material = null;

        if (conn == null) return null;

        String sql = "SELECT titulo, autor, categoria, año FROM materialbibliografico " +
                     "WHERE titulo LIKE ? OR autor LIKE ? OR categoria LIKE ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            String param = "%" + criterio + "%";
            stmt.setString(1, param);
            stmt.setString(2, param);
            stmt.setString(3, param);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                material = new Cliente.Dominio.MaterialBibliografico(
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("categoria"),
                    rs.getInt("año")
                );
            } else {
                System.out.println("No se encontraron resultados para el criterio de búsqueda " + criterio);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
        return material;
    }
}