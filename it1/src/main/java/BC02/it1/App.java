package src.main.java.BC02.it1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UI_ConsultaMaterial ui = new UI_ConsultaMaterial();
        ControlConsultaMaterial control = new ControlConsultaMaterial();
        API_ConsultaMaterial api = new API_ConsultaMaterial();

        ui.mostrarFormulario();
        String criterio = ui.capturarEntrada();

        if (control.validarBusqueda(criterio)) {
            String solicitud = control.enviarSolicitudServidor(criterio);
            MaterialBibliografico resultado = api.recibirSolicitud(solicitud);
            api.devolverRespuesta(resultado);
        } else {
            System.out.println("Criterio inválido. Intente nuevamente.");
        }  
     }
}
