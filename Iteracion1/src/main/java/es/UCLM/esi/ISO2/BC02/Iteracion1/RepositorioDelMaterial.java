package es.UCLM.esi.ISO2.BC02.Iteracion1;
import java.sql.*;
public class RepositorioDelMaterial {
	private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root"; // <-- Cambia según tu configuración
    private static final String PASSWORD = "1234"; // <-- Añade tu contraseña

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado a MySQL correctamente.");
            return conexion;
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }

    public MaterialBibliografico consultarBD(String criterio) {
        Connection conn = conectar();
        MaterialBibliografico material = null;

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
                material = new MaterialBibliografico(
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("categoria"),
                    rs.getInt("año")
                );
            } else {
                System.out.println("No se encontraron resultados para el criterio: " + criterio);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
        return material;
    }
}
