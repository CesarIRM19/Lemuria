/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.model;

import java.util.Random;


import mx.uaemex.fi.paradigams_1.Lemurian.Error.Sala404Exception;

public class Mapa {
	private int columnas;
	private int renglones;
	private Sala[][] cuadrantes;
	private Coordenada posicionActual;
	private Random rand;
	
	public void setSala (Sala s, int r, int c) {
		this.cuadrantes[r][c]=s;
	}
	public int getNumeroNull() {
		int a = 0;
		for (int i = 0; i < cuadrantes.length; i++) {
			for (int j = 0; j < cuadrantes[i].length; j++) {
				if (cuadrantes [i][j] == null) {
					a++;
				}
			}
		}
		return a;
	}
	
	public Mapa (int r, int c) {
		this.rand= new Random();
		this.cuadrantes = new Sala[r][c];
		
		this.posicionActual = new Coordenada(rand.nextInt(this.cuadrantes[0].length),rand.nextInt(this.cuadrantes.length));
	}
	public Mapa (Sala[][] sala) {
		this.rand= new Random();
		this.cuadrantes = sala;

		//System.out.println("Este es el cuadrante "+this.cuadrantes);
		this.posicionActual = new Coordenada(rand.nextInt(this.cuadrantes[0].length),rand.nextInt(this.cuadrantes.length));
	}
	public Sala getSala () {
		
		Sala s = cuadrantes[posicionActual.getX()][posicionActual.getY()];
		System.out.println(s.getNombre() + ": [" + posicionActual.getX()+", "+posicionActual.getY()+"]");
		if (s == null) {
			throw new Sala404Exception("El juego no esta completamente configurado");
		}
		return s;
	}
	
	public void cambiarSala(int dir) {
		int val;
		
		switch (dir) {
		case Direccion.DERECHA:
			val = this.posicionActual.getY();
			if (this.cuadrantes[0].length-1 == val) {
				this.posicionActual.setY(0);
			} else {
				val++;
				this.posicionActual.setY(val);
			}
			
			break;
		case Direccion.IZQUIERDA:
			val = this.posicionActual.getY();
			if (val == 0) {
				this.posicionActual.setY(this.cuadrantes[0].length-1);
			} else {
				val--;
				this.posicionActual.setY(val);
			}
			
			break;
		case Direccion.ABAJO: 
			val = this.posicionActual.getX(); 
			if (this.cuadrantes.length-1 == val) {
				this.posicionActual.setX(0);
			}else {
				val++;
				this.posicionActual.setX(val);
			}
			
			break;
		case Direccion.ARRIBA: 
			val = this.posicionActual.getX(); 
			if (val == 0) {
				this.posicionActual.setX(this.cuadrantes.length-1);
			} else {
				val--;
				this.posicionActual.setX(val);
			}
			
			break;
		default:
			throw new RuntimeException("Direccion no valida");
		}
	}
}
//soy el 12