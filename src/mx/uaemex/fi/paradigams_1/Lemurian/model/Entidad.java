/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */
 package mx.uaemex.fi.paradigams_1.Lemurian.model;

public abstract class Entidad {
	protected String nombre;
	protected int ataque;
	protected int defensa;

	public Entidad() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
}
