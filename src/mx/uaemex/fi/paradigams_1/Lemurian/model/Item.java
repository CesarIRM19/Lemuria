/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.model;

import java.util.ArrayList;
import java.util.List;

public class Item extends ElementosConNombre {
	private int ataque, defensa, tipo;
	private List<Item> listaItem ;
	private Item item;
	

	public Item() {
		super();
		
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public List<Item> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}

	public void ListadoDeItems() {
		listaItem = new ArrayList<>();
		
		item = new Item();
		item.setNombre("Daga");
		item.setAtaque(1);
		item.setTipo(1);
		listaItem.add(item);
		
		item = new Item();
		item.setNombre("Escudo de Mithril");
		item.setDefensa(5);
		item.setTipo(0);
		listaItem.add(item);
		
		item = new Item();
		item.setNombre("Lanza de piedra");
		item.setAtaque(2);
		item.setTipo(1);
		listaItem.add(item);
		
		item = new Item();
		item.setNombre("Escudo de Hierro");
		item.setDefensa(4);
		item.setTipo(0);
		listaItem.add(item);
		
		item = new Item();
		item.setNombre("Mazo");
		item.setAtaque(4);
		item.setTipo(1);
		listaItem.add(item);
		
		item = new Item();
		item.setNombre("Escudo de madera");
		item.setDefensa(2);
		item.setTipo(0);
		listaItem.add(item);
		
		item = new Item();
		item.setNombre("Espada Maestra");
		item.setAtaque(5);
		item.setTipo(1);
		listaItem.add(item);
		
		item = new Item();
		item.setNombre("PocionDefensa");
		item.setDefensa(1);
		item.setTipo(0);
		listaItem.add(item);
		
		item = new Item();
		item.setNombre("Tesoro");
		item.setTipo(2);
		listaItem.add(item);
		
		
		
		

		
	}
	

}
