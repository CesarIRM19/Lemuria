/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */
package mx.uaemex.fi.paradigams_1.Lemurian.model;

import java.util.ArrayList;
import java.util.List;

public class Enemigo extends Entidad {
	private List<Enemigo> listaEnemigos ;
	private Enemigo enemy;
	
	public Enemigo() {
		super();
	}
	
	public List<Enemigo> getListaEnemigos() {
		return listaEnemigos;
	}

	public void setListaEnemigos(List<Enemigo> listaEnemigos) {
		this.listaEnemigos = listaEnemigos;
	}

	public void ListaDeEnemigos() {
		listaEnemigos = new ArrayList<>();
		//1
		enemy = new Enemigo();
		enemy.setNombre("SabreWulf");
		enemy.setAtaque(8);
		enemy.setDefensa(4);
		listaEnemigos.add(enemy);
		
		//2
		enemy = new Enemigo();
		enemy.setNombre("Alien");
		enemy.setAtaque(5);
		enemy.setDefensa(3);
		listaEnemigos.add(enemy);
		
		//3
		enemy = new Enemigo();
		enemy.setNombre("Demonio");
		enemy.setAtaque(6);
		enemy.setDefensa(4);
		listaEnemigos.add(enemy);
		
		//4
		enemy = new Enemigo();
		enemy.setNombre("Ente");
		enemy.setAtaque(3);
		enemy.setDefensa(7);
		listaEnemigos.add(enemy);
		
		//5
		enemy = new Enemigo();
		enemy.setNombre("Esqueleto");
		enemy.setAtaque(9);
		enemy.setDefensa(7);
		listaEnemigos.add(enemy);
		
		//6
		enemy = new Enemigo();
		enemy.setNombre("Fantasma");
		enemy.setAtaque(7);
		enemy.setDefensa(4);
		listaEnemigos.add(enemy);
		
		//7
		enemy = new Enemigo();
		enemy.setNombre("Hormiga");
		enemy.setAtaque(4);
		enemy.setDefensa(8);
		listaEnemigos.add(enemy);

		//8
		enemy = new Enemigo();
		enemy.setNombre("Masa de Carne");
		enemy.setAtaque(1);
		enemy.setDefensa(9);
		listaEnemigos.add(enemy);
		
		//9
		enemy = new Enemigo();
		enemy.setNombre("Ogro");
		enemy.setAtaque(10);
		enemy.setDefensa(9);
		listaEnemigos.add(enemy);
	}
	
}
