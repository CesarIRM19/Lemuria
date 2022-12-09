/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */
package mx.uaemex.fi.paradigams_1.Lemurian.model;

import java.util.ArrayList;
import java.util.List;

public class Sala extends ElementosConNombre{
	private Enemigo masSIOsare;
	private Item coso;
	private List<String> listaSalas ;

	public Sala(Enemigo masSIOsare, Item coso, String nombre) {
		super(nombre);
		this.masSIOsare = masSIOsare;
		this.coso = coso;

	}
	
	public Sala(String nombre) {
		super(nombre);
	}
	public Sala() {
		super();
	}

	public Enemigo getMasSIOsare() {
		return masSIOsare;
	}
	public void setMasSIOsare(Enemigo masSIOsare) {
		this.masSIOsare = masSIOsare;
	}
	public Item getCoso() {
		return coso;
	}
	public void setCoso(Item coso) {
		this.coso = coso;
	}

	public List<String> getListaSalas() {
		return listaSalas;
	}

	public void setListaSalas(List<String> listaSalas) {
		this.listaSalas = listaSalas;
	}

	public void listasDeSalas() {
		listaSalas = new ArrayList<>();
		//0
		listaSalas.add("Calabozo");
		//1
		listaSalas.add("Laberinto");
		//2
		listaSalas.add("Bosque");
		//3
		listaSalas.add("Casa del Bosque");
		//4
		listaSalas.add("Castillo");
		//5
		listaSalas.add("Montana");
		//6
		listaSalas.add("Rio");
		//7
		listaSalas.add("Ruina");
		//8
		listaSalas.add("Camino");
	}
	
	
	
}
