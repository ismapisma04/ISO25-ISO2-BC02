package es.uclm.iso2.biblioteca.presentacion;

import es.uclm.iso2.biblioteca.api.API_GestionMaterial;
import es.uclm.iso2.biblioteca.api.API_GestionarUsuarios;
import es.uclm.iso2.biblioteca.dominio.MaterialBibliografico;
import es.uclm.iso2.biblioteca.dominio.UsuarioBiblioteca;
import es.uclm.iso2.biblioteca.servicio.GestionMaterialException;
import es.uclm.iso2.biblioteca.servicio.GestionUsuariosException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de "ventana" de consola que ACCEDE
 * a los recursos de la biblioteca usando las capas API/Servicio/DAO.
 */
public class VentanaAccesoRecursos {



    private final Scanner sc = new Scanner(System.in);
    private final API_GestionarUsuarios apiUsuarios = new API_GestionarUsuarios();
    private final API_GestionMaterial apiMaterial = new API_GestionMaterial();

    /** DNI del usuario actualmente logueado. */
    private String dniLogueado;

    public VentanaAccesoRecursos() {
    }


    /*// It7:
     * 
     * Hacemos un menu para la busqueda de un libro
     * */
    public void ejecutar() {
        System.out.println(mostrarLogin());
        dniLogueado = iniciarSesion();

        boolean loginOk = validarCredenciales(dniLogueado);
        System.out.println(validarFormatoLogin(loginOk));

        if (!loginOk) {
            // Si el login falla, salimos sin hacer nada más.
            return;
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Menú Acceso a Recursos ===");
            System.out.println("1. Listar recursos");
            System.out.println("2. Buscar recurso por ISBN");
            System.out.println("3. Solicitar recurso");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    mostrarRecursos();
                    break;
                case "2":
                    gestionarBusqueda();
                    break;
                case "3":
                    gestionarSolicitudRecurso();
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }




    /** Muestra el mensaje de login. 
     * // It7:*/
    public String mostrarLogin() {
        return "Inicia sesión con tu DNI:";
    }

    /** Pide por consola el DNI al usuario y lo devuelve. 
     * // It7:*/
    public String iniciarSesion() {
        System.out.print("Introduce tu DNI: ");
        return sc.nextLine();
    }

    /**
     * Valida el DNI usando la capa de usuarios.
     * It7:
     */
    public boolean validarCredenciales(String dni) {
        try {
            UsuarioBiblioteca u = apiUsuarios.searchUsuario(dni);
            return (u != null);
        } catch (GestionUsuariosException e) {
            // El servicio lanza excepción si el usuario no existe.
            return false;
        }
    }

    /**
     * Devuelve un mensaje de resultado del login,
     * a partir de si el DNI era válido o no.
     * // It7:
     */
    public String validarFormatoLogin(boolean existeLogin) {
        if (existeLogin) {
            return "Inicio de sesión correcto";
        } else {
            return "Inicio de sesión incorrecto";
        }
    }



    /**
     * Pide al usuario el ISBN del recurso que desea solicitar.
     * // It7:
     */
    public String solicitarRecurso() {
        System.out.print("Introduce el ISBN del recurso que deseas solicitar: ");
        return sc.nextLine();
    }

    /**
     * Comprueba si el recurso existe (vía API de material).
     * En una versión más avanzada, aquí se registraría un préstamo.
     * It7:
     */
    public boolean obtenerRecurso(String isbn) {
        try {
            MaterialBibliografico m = apiMaterial.searchMaterial(isbn);
            return (m != null);
        } catch (GestionMaterialException e) {
            return false;
        }
    }

    /**
     * Muestra todos los recursos disponibles consultando la BD.
     * // It7:
     */
    public void mostrarRecursos() {
        try {
            List<MaterialBibliografico> lista = apiMaterial.allMaterial();
            System.out.println("Recursos disponibles:");
            for (MaterialBibliografico m : lista) {
                System.out.println("- " + m.getIsbn() + " | " + m.getTitulo() + " - " + m.getAutor());
            }
        } catch (GestionMaterialException e) {
            System.out.println("No se pudieron obtener los recursos: " + e.getMessage());
        }
    }

    /**
     * Muestra el resultado de intentar obtener un recurso.
     * // It7:
     */
    public String mostrarResultados(boolean obtenido) {
        if (obtenido) {
            return "Recurso obtenido (simulado).";
        } else {
            return "No se pudo obtener el recurso porque no existe.";
        }
    }




    /**
     * Pide al usuario el ISBN del recurso que desea buscar.
     * // It7:
     */
    public String buscar() {
        System.out.print("Introduce el ISBN del recurso que deseas buscar: ");
        return sc.nextLine();
    }

    /**
     * Busca un recurso por ISBN usando la API de material.
     * Devuelve un mensaje si existe, o null si no existe (como en tu versión original).
     * // It7:
     */
    public String buscarRecurso(String isbn) {
        try {
            MaterialBibliografico m = apiMaterial.searchMaterial(isbn);
            if (m == null) {
                return null;
            }
            return "Recurso encontrado con ISBN: " + m.getIsbn() +
                   " | " + m.getTitulo() + " - " + m.getAutor();
        } catch (GestionMaterialException e) {
            return null;
        }
    }

    /**
     * Devuelve la lista de recursos disponibles como lista de ISBN,
     * utilizando la capa de material en lugar de una lista simulada.
     * // It7:
     */
    public List<String> obtenerRecursos() {
        List<String> resultado = new ArrayList<>();
        try {
            List<MaterialBibliografico> lista = apiMaterial.allMaterial();
            for (MaterialBibliografico m : lista) {
                resultado.add(m.getIsbn());
            }
        } catch (GestionMaterialException e) {
            // Si hay error, devolvemos la lista vacía.
        }
        return resultado;
    }



    /*
     * Se imprimen los recursos de un determinado isbn
     * // It7:
     * */
    private void gestionarBusqueda() {
        String isbn = buscar();
        String mensaje = buscarRecurso(isbn);
        if (mensaje != null) {
            System.out.println(mensaje);
        } else {
            System.out.println("No se encontró ningún recurso con ese ISBN.");
        }
    }

    /*Se comprueba que se obtiene el recurso
     * // It7:
     * */
    private void gestionarSolicitudRecurso() {
        String isbn = solicitarRecurso();
        boolean ok = obtenerRecurso(isbn);
        System.out.println(mostrarResultados(ok));
    }
}

