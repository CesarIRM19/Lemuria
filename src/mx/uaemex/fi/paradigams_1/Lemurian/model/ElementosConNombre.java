/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */
package mx.uaemex.fi.paradigams_1.Lemurian.model;

public abstract class ElementosConNombre {
	protected String nombre;
	
	public ElementosConNombre() {
		super();
		
	}
	
	public ElementosConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
