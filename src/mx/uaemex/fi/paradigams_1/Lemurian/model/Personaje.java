/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.model;

public class Personaje extends Entidad {
	private Item[] mochila;
	private Personaje perso;
	private Item ItemUso, cofre;
	private int vida;
	public Personaje() {
		super();
	}
	
	public Personaje crearPersonaje() {
		perso = new Personaje();
		perso.setNombre("Heroe");
		perso.setVida(5);
		perso.setItemUso(null);
		perso.setCofre(null);
		perso.setAtaque(5);
		perso.setDefensa(5);
		perso.crearMochila();
		
		return perso;
	
	}
	public void aumentarDaño (Item item, Personaje per) {
		int aumento;
		
		per.setAtaque(5);
		aumento = per.getAtaque()+item.getAtaque();
		per.setAtaque(aumento);
		per.setItemUso(item);
	}
	
	public void aumentarDefensa (Item item, Personaje per) {
		int aumento;
		
		per.setDefensa(5);
		aumento = per.getDefensa()+item.getDefensa();
		per.setDefensa(aumento);
		per.setItemUso(item);
	}
	public void retonarAtaque(Personaje per) {
		per.setAtaque(5);
		
	}
	public void retonarDefensa(Personaje per) {
		per.setDefensa(5);
	}
	
	

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Item getCofre() {
		return cofre;
	}

	public void setCofre(Item cofre) {
		this.cofre = cofre;
	}

	public Item getItemUso() {
		return ItemUso;
	}

	public void setItemUso(Item itemUso) {
		ItemUso = itemUso;
	}

	public Item[] getMochila() {
		return mochila;
	}
	public void setMochila(Item[] mochila) {
		this.mochila = mochila;
	}
	
	public void crearMochila() {
		this.mochila = new Item [2];
	}
}
