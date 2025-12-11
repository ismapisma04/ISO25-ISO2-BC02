package es.uclm.iso2.biblioteca.dao;

import es.uclm.iso2.biblioteca.dominio.PrestamosBiblioteca;
import es.uclm.iso2.biblioteca.persistencia.DBBroker;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDAO {

    private final DBBroker broker;

    public PrestamosDAO() throws SQLException {
        this.broker = DBBroker.getInstance();
    }

    
    
    
    
    
    public int insert(PrestamosBiblioteca p) {

        String sql =
            "INSERT INTO prestamos_biblioteca " +
            "(usuario_dni, material_isbn, fecha_prestamo, fecha_devolucion, devuelto) VALUES (" +
            "'" + p.getUsuario_dni() + "', " +
            "'" + p.getMaterial_isbn() + "', " +
            "'" + p.getFecha_prestamo() + "', " +
            "'" + p.getFecha_devolucion() + "', " +
            (p.getDevuelto() ? 1 : 0) +
            ")";

        return broker.change(sql);
    }

    
    public int delete(int id) {
        String sql = "DELETE FROM prestamos_biblioteca WHERE id = " + id;
        return broker.change(sql);
    }

    
    public int update(PrestamosBiblioteca p) {

        String sql =
            "UPDATE prestamos_biblioteca SET " +
            "usuario_dni = '" + p.getUsuario_dni() + "', " +
            "material_isbn = '" + p.getMaterial_isbn() + "', " +
            "fecha_prestamo = '" + p.getFecha_prestamo() + "', " +
            "fecha_devolucion = '" + p.getFecha_devolucion() + "', " +
            "devuelto = " + (p.getDevuelto() ? 1 : 0) + " " +
            "WHERE id = " + p.getId();

        return broker.change(sql);
    }


    public PrestamosBiblioteca findById(int id) {

        PrestamosBiblioteca p = null;
        String sql = "SELECT * FROM prestamos_biblioteca WHERE id = " + id;

        List<String[]> table = broker.read(sql);

        if (!table.isEmpty()) {
            String[] row = table.get(0);
            // Asumiendo el orden de columnas:
            // 0:id, 1:usuario_dni, 2:material_isbn, 3:fecha_prestamo, 4:fecha_devolucion, 5:devuelto
            p = new PrestamosBiblioteca();

            p.setId(Integer.parseInt(row[0]));
            p.setUsuario_dni(row[1]);
            p.setMaterial_isbn(row[2]);

            p.setFecha_prestamo(row[3] != null && !row[3].isEmpty()
                    ? LocalDate.parse(row[3])
                    : null);

            p.setFecha_devolucion(row[4] != null && !row[4].isEmpty()
                    ? LocalDate.parse(row[4])
                    : null);

            boolean devuelto =
                    "1".equals(row[5]) ||
                    "true".equalsIgnoreCase(row[5]) ||
                    "t".equalsIgnoreCase(row[5]);
            p.setDevuelto(devuelto);
        }

        return p;
    }

    public List<PrestamosBiblioteca> readAll() {
        List<PrestamosBiblioteca> lista = new ArrayList<>();

        String sql = "SELECT * FROM prestamos_biblioteca ORDER BY id ASC";
        List<String[]> rows = broker.read(sql);

        for (String[] row : rows) {
            // 0:id, 1:usuario_dni, 2:material_isbn, 3:fecha_prestamo, 4:fecha_devolucion, 5:devuelto
            PrestamosBiblioteca p = new PrestamosBiblioteca();

            p.setId(Integer.parseInt(row[0]));
            p.setUsuario_dni(row[1]);
            p.setMaterial_isbn(row[2]);

            p.setFecha_prestamo(row[3] != null && !row[3].isEmpty()
                    ? LocalDate.parse(row[3])
                    : null);

            p.setFecha_devolucion(row[4] != null && !row[4].isEmpty()
                    ? LocalDate.parse(row[4])
                    : null);

            boolean devuelto =
                    "1".equals(row[5]) ||
                    "true".equalsIgnoreCase(row[5]) ||
                    "t".equalsIgnoreCase(row[5]);
            p.setDevuelto(devuelto);

            lista.add(p);
        }

        return lista;
    }
}
