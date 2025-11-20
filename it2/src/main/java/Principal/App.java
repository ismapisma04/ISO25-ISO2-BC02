package Principal;
import API.API_AccesoRecursos;
import Servicio.GestionUsuariosException;
import Servicio.GestionAccesoRecursosException;
import Dominio.RecursosElectronicos;
import java.util.*;
public class App {
	final static Scanner TECLADO=new Scanner(System.in);
	public static void main(String[] args) throws GestionUsuariosException, GestionAccesoRecursosException{
		API_AccesoRecursos api=new API_AccesoRecursos();
		System.out.println(api.mostrarLogin());
		String dni=api.iniciarSesion();
		boolean valido=api.validarCredenciales(dni);
		System.out.println(api.validarFormatoLogin(valido));
		System.out.println("¿Qué desea hacer?: ");
		System.out.println("1)Buscar recursos");
		System.out.println("2)Solicitar un recurso");
		System.out.println("3)Mostrar los recursos disponibles");
		int opcion=TECLADO.nextInt();
		switch(opcion) {
		 case 1:
			 String id=api.buscar();
			 RecursosElectronicos recursoBuscado=api.buscarRecuso(id);
			 System.out.println(recursoBuscado.toString());
		 break;
		 case 2:
			 String idSolicitado=api.solicitarRecurso();
			 boolean obtenido=api.obtenerRecurso(idSolicitado);
			 System.out.println(api.mostrarResultados(obtenido));
		 break;
		 case 3:
			 List<RecursosElectronicos> rs=api.obtenerRecursos();
			 api.mostrarRecursos(rs);
		 break;
		 default:
			 System.out.println("Opcion ilegal");
		}
	}
}
