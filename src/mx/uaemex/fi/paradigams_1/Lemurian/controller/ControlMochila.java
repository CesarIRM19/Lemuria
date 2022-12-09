/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.controller;

import javax.swing.JOptionPane;

import mx.uaemex.fi.paradigams_1.Lemurian.Error.ItemMochilaException;
import mx.uaemex.fi.paradigams_1.Lemurian.Error.OpcionException;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Item;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Personaje;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Sala;
import mx.uaemex.fi.paradigams_1.Lemurian.vista.BackgroundPanel;
import mx.uaemex.fi.paradigams_1.Lemurian.vista.VentanaMochila;

public class ControlMochila {
	private ControlMapa cM;
	public Item recoger (Item it, Personaje per) {
		
		VentanaMochila vMonchila = new VentanaMochila();
		Item itemtemp = null;
		Item itemMochila;
		int pos = 0;
		if (it.getTipo()!=2) {
			for (int i = 0; i < per.getMochila().length; i++) {
				itemMochila = per.getMochila()[i];
				if(itemMochila == null) {
					per.getMochila()[i]=it;
					break;
				}
				
				if (i==per.getMochila().length-1) {
					
					try {
						itemMochila = vMonchila.mostrarMochila(per, "intercambiar");
						Item temp2= null;
						if (itemMochila.getNombre() == per.getItemUso().getNombre()) {
							System.out.println(itemMochila.getNombre()+". Estas usando: "+per.getItemUso().getNombre());
							for (int j = 0; j < per.getMochila().length; j++) {
								if (per.getMochila()[i].getNombre() == itemMochila.getNombre()) {
									temp2 = itemMochila;
									per.getMochila()[i] = null;
									
									break;
								}
								
								if(j==per.getMochila().length) {
									JOptionPane.showMessageDialog(null, "No puedes tirar algo que no tienes");
								}
								
							}

							for (int k = 0; k < per.getMochila().length; k++) {
								itemMochila = per.getMochila()[k];
								if(itemMochila == null) {
									per.getMochila()[k]=it;
									break;
								}
							}
							itemtemp=temp2;
						}else {
							System.out.println("Entraste aqui 2");
							
							for (int k = 0; k < per.getMochila().length; k++) {
								if (per.getMochila()[k] != null) {
									if (per.getMochila()[k].getNombre() == itemMochila.getNombre()) {
										itemtemp = itemMochila;
										per.getMochila()[k] = null;
										break;
									}
									pos++;
									if (k == per.getMochila().length-1) {
										JOptionPane.showMessageDialog(null, "No puedes tirar algo que no tienes");
									}
								}
							}
							per.getMochila()[pos] = it;
						}
						if (per.getItemUso().getTipo()== 0) {
							per.retonarDefensa(per);
							
						} else if (per.getItemUso().getTipo() == 1) {
							per.retonarAtaque(per);
						}else{
							JOptionPane.showMessageDialog(null, "No puedes tirar nada");
						}
					} catch (ItemMochilaException e) {
						e.printStackTrace();
					} catch (OpcionException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			this.retornoCofre(per, it);
		}
		
		return itemtemp;
	}
	
	public void abrirMochila (Personaje per, Sala s) {
		VentanaMochila vMochila = new VentanaMochila();
		vMochila.elejirMochila(per, s);
	}
	
	public void tirarItem(Item item, Sala s, Personaje perso) throws ItemMochilaException {
		Item itemtemp = null;
		int pos=0;
		if (s.getMasSIOsare()==null) {
			if (item != null) {
				if (item == perso.getItemUso()) {
					for (int i = 0; i < perso.getMochila().length; i++) {
						if (perso.getMochila()[i] != null) {
							if (perso.getMochila()[i].getNombre() == item.getNombre()) {
								itemtemp = item;
								perso.getMochila()[i] = null;
								break;
							}
							if (i == perso.getMochila().length-1) {
								JOptionPane.showMessageDialog(null, "No puedes tirar algo que no tienes");
							}
						}
	
					}
					if (s.getCoso() != null) {
						Item itemtemp2 = null;
						for (int k = 0; k < perso.getMochila().length; k++) {
							itemtemp2 = perso.getMochila()[k];
							if(itemtemp2 == null) {
								perso.getMochila()[k]=s.getCoso();
								break;
							}
						}
						s.setCoso(itemtemp);
					} else {
						s.setCoso(itemtemp);
					}
				} else {
					System.out.println("Entro aqui");
					for (int i = 0; i < perso.getMochila().length; i++) {
						if (perso.getMochila()[i] != null) {
							if (perso.getMochila()[i].getNombre() == item.getNombre()) {
								itemtemp = item;
								perso.getMochila()[i] = null;
								break;
							}
							if (i == perso.getMochila().length-1) {
								JOptionPane.showMessageDialog(null, "No puedes tirar algo que no tienes");
							}
						}	
					}
					if (perso.getItemUso()!=null) {
						if (perso.getItemUso().getTipo()== 0) {
							perso.retonarDefensa(perso);
						} else if (perso.getItemUso().getTipo() == 1) {
							perso.retonarAtaque(perso);
						}else{
							JOptionPane.showMessageDialog(null, "No puedes tirar nada");
						}
						s.setCoso(item);
					} else {
						s.setCoso(item);
					}
				}
			} else {
				throw new ItemMochilaException("No haz seleccionado ningun item");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Hay un enemigo, no puedes tirar tus objetos");
		}
	}
	
	public void usarItem(Item item, Personaje perso) throws ItemMochilaException {
		
		if (item!=null) {
			int tipoItem = item.getTipo();
			Item itemtemp = null;
			
			
			if (tipoItem == 0) {
				perso.aumentarDefensa(item, perso);
				for (int i = 0; i < perso.getMochila().length; i++) {
					if (perso.getMochila()[i] != null) {
						if (perso.getMochila()[i].getNombre() == item.getNombre()) {
							itemtemp = perso.getMochila()[i];
							perso.getMochila()[i] = perso.getMochila()[1];
							perso.getMochila()[1] = itemtemp;
							break;
						}
					}
					 
				}
				
			} else if (tipoItem == 1) {
				perso.aumentarDaño(item, perso);
				for (int i = 0; i < perso.getMochila().length; i++) {
					
					if (perso.getMochila()[i] != null) {
						if (perso.getMochila()[i].getNombre() == item.getNombre()) {
							System.out.println(perso.getMochila()[i].getNombre()+"");
							itemtemp = perso.getMochila()[i];
							perso.getMochila()[i] = perso.getMochila()[0];
							perso.getMochila()[0] = itemtemp;
							break;
						} 
					}
				}
			} else{
				JOptionPane.showMessageDialog(null, "No hay algun item");
			}
		} else {
			throw new ItemMochilaException("No hay algun item");
		}
		
	}
	
	public void retornoCofre (Personaje per, Item item) {
		per.setCofre(item);
	}
}
