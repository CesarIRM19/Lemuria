/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

import mx.uaemex.fi.paradigams_1.Lemurian.model.Enemigo;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Item;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Sala;

public class ControlAsignacionAleatoria {
	private Enemigo enemy;
	private Item item;
	private Random rand;
	private Sala[][] salas;
	private Sala s;

	public Sala[][] asignarEscenaro() {
		salas = new Sala[3][3];
		this.rand = new Random();
		s = new Sala();
		s.listasDeSalas();

		int pos=-1;

	    int[] numerosAleatorios = IntStream.rangeClosed(0, 8).toArray();
	    Random r = new Random();
	    for (int i = numerosAleatorios.length; i > 0; i--) {
	        int posicion = r.nextInt(i);
	        int tmp = numerosAleatorios[i-1];
	        numerosAleatorios[i - 1] = numerosAleatorios[posicion];
	        numerosAleatorios[posicion] = tmp;
	    }
	    
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pos++;
				salas[i][j] = new Sala(s.getListaSalas().get(pos)  /*listaSalas.get(numerosAleatorios[pos])*/);
			}
		}
		return salas;
	}
	
	public void asignarEnemigo() {
		this.rand = new Random();
		this.enemy = new Enemigo();
		
		enemy.ListaDeEnemigos();
		int pos=-1;

	    int[] numerosAleatorios = IntStream.rangeClosed(0, 8).toArray();
	    Random r = new Random();
	    for (int i = numerosAleatorios.length; i > 0; i--) {
	        int posicion = r.nextInt(i);
	        int tmp = numerosAleatorios[i-1];
	        numerosAleatorios[i - 1] = numerosAleatorios[posicion];
	        numerosAleatorios[posicion] = tmp;
	    }
	    
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				pos++;
				salas[i][j].setMasSIOsare(enemy.getListaEnemigos().get(numerosAleatorios[pos]));    
			}
		}
	}
	public void asignarItem() {
		this.rand = new Random();
		this.item = new Item();
		
		item.ListadoDeItems();
		int pos=-1;

	    int[] numerosAleatorios = IntStream.rangeClosed(0, 8).toArray();
	    Random r = new Random();
	    for (int i = numerosAleatorios.length; i > 0; i--) {
	        int posicion = r.nextInt(i);
	        int tmp = numerosAleatorios[i-1];
	        numerosAleatorios[i - 1] = numerosAleatorios[posicion];
	        numerosAleatorios[posicion] = tmp;
	    }
	    
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				pos++;
				salas[i][j].setCoso(item.getListaItem().get(numerosAleatorios[pos]));    
			}
		}
	}
}
