package es.uclm.iso2.biblioteca.persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBBroker {

    private static String connectionString;
    private static Connection connection;
    private static DBBroker instance;


    public DBBroker() {
        try {
            // >>> AJUSTA AQUÍ TU BBDD <<<
            DBBroker.connectionString = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String pass = "1234"; 

            DBBroker.connection = DriverManager.getConnection(connectionString, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException("Error conectando con la BD: " + e.getMessage());
        }
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }



    public void connect() {
        try {
            if (connection != null && connection.isClosed()) {
                connection = DriverManager.getConnection(connectionString, "root", "1234");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al desconectar: " + e.getMessage());
        }
    }



    public List<String[]> read(String sql) {
        List<String[]> resultado = new ArrayList<>();

        connect();

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int columnas = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                String[] fila = new String[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                resultado.add(fila);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error en READ: " + e.getMessage());
        }

        disconnect();
        return resultado;
    }



    public int change(String sql) {
        connect();
        int filas = 0;

        try (Statement stmt = connection.createStatement()) {
            filas = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error en CHANGE: " + e.getMessage());
        }

        disconnect();
        return filas;
    }
}

