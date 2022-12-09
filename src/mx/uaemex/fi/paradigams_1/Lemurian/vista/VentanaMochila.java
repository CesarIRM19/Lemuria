/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.vista;

import java.util.Iterator;

import javax.swing.JOptionPane;

import mx.uaemex.fi.paradigams_1.Lemurian.Error.ItemMochilaException;
import mx.uaemex.fi.paradigams_1.Lemurian.Error.OpcionException;
import mx.uaemex.fi.paradigams_1.Lemurian.controller.ControlMochila;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Item;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Personaje;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Sala;

public class VentanaMochila {
	Item opcionItem;
	ControlMochila ctrlMo;
	public void elejirMochila(Personaje perso, Sala s) {
		ctrlMo = new ControlMochila();
		String menu1 = "1.- Tirar \n"+ "2.- Usar";
		String opcion = JOptionPane.showInputDialog(null,  menu1,"Elija que decea hacer",1);
		try {
			if (opcion != null) {
				switch (opcion) {
				case "1":
					//Metodo tirar
					this.opcionItem = mostrarMochila(perso, "tirar");
					this.ctrlMo.tirarItem(opcionItem, s,perso);
					break;
				case "2":
					//Metodo usar
					this.opcionItem = mostrarMochila(perso, "usar");
					this.ctrlMo.usarItem(opcionItem, perso);
					System.out.println("Ataque del personaje: "+perso.getAtaque() + ". Defensa del personaje: "+ perso.getDefensa());
					break;
				
				default:
					JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna de las 2 opciones");
					break;
				}
			}else {
				throw new OpcionException("No se selecciono nada");
			}
			
		} catch (ItemMochilaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (OpcionException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		
	}
	public Item mostrarMochila(Personaje per, String Opcion) throws ItemMochilaException, OpcionException{
		String mochila = "Items \n";
		Item item = null;
		
		
		
		for (int i = 0; i < per.getMochila().length; i++) {
			
			if (per.getMochila()[i]!=null) {
				mochila += (i+1)+".- "+per.getMochila()[i].getNombre()+"\n";
			} else {
				
			}

		}
		String opcion = JOptionPane.showInputDialog(null, mochila,"Elija el objeto que dece "+ Opcion, 0);
		try {
			if (opcion != null) {
				switch (opcion) {
				case "1":
					if (per.getMochila()[0]!=null) {
						JOptionPane.showMessageDialog(null, "Has elegido "+per.getMochila()[0].getNombre());
						item = per.getMochila()[0];
					} else {
						JOptionPane.showMessageDialog(null, "No existe ningun item");
					}
					break;
				case "2":
					if (per.getMochila()[1]!=null) {
						JOptionPane.showMessageDialog(null, "Has elegido "+per.getMochila()[1].getNombre());
						item = per.getMochila()[1];
					} else {
						JOptionPane.showMessageDialog(null, "No existe ningun item");
					}
					break;
					
				case "3":
					if (per.getMochila()[2]!=null) {
						JOptionPane.showMessageDialog(null, "Has elegido "+per.getMochila()[2].getNombre());
						item = per.getMochila()[2];
					} else {
						JOptionPane.showMessageDialog(null, "No existe ningun item");
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "No se selecciono nada");
					break;
				}
			}else {
				throw new OpcionException("No se selecciono nada");
			}
		} catch (OpcionException e) {
			
		}
		

		return item;
	}
}
