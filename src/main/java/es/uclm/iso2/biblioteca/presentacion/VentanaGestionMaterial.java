package es.uclm.iso2.biblioteca.presentacion;

import javax.swing.JFrame;

import es.uclm.iso2.biblioteca.api.API_GestionMaterial;
import es.uclm.iso2.biblioteca.dominio.MaterialBibliografico;
import es.uclm.iso2.biblioteca.servicio.GestionMaterialException;



public class VentanaGestionMaterial extends JFrame{
	
	private API_GestionMaterial api_mat = new API_GestionMaterial();
	
	
	//interfaz para las gestiones del material
	
	//iteracion 4 cdu 13
	public int insertMaterial(MaterialBibliografico m) throws GestionMaterialException {
		//clase para insertar un material en la BBDD
		return api_mat.insertMaterial(m);
	}
	
	//iteracion 4 cdu 13
	public int deleteMaterial(String isbn) throws GestionMaterialException {
		//clase para eliminar un material en la BBDD
		return api_mat.deleteMaterial(isbn);
	}
	
	//iteracion 4 cdu 13
	public int updateMaterial(MaterialBibliografico m) throws GestionMaterialException {
		//clase para actualizar un material en la BBDD
		return api_mat.updateMaterial(m);
	}
	
	//iteracion 4 cdu 13
	public MaterialBibliografico searchMaterial(String isbn) throws GestionMaterialException {
		//clase para buscar un material en la BBDD por la isbn
		return api_mat.searchMaterial(isbn);
	}
	
}
