/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mx.uaemex.fi.paradigams_1.Lemurian.Error.DireccionNoValida;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Direccion;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Enemigo;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Item;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Mapa;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Personaje;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Sala;
import mx.uaemex.fi.paradigams_1.Lemurian.vista.BackgroundPanel;
import mx.uaemex.fi.paradigams_1.Lemurian.vista.PanelPrincipal;
import mx.uaemex.fi.paradigams_1.Lemurian.vista.SalaVista;
import mx.uaemex.fi.paradigams_1.Lemurian.vista.VentanaProgreso;

public class ControlMapa implements ActionListener{
	private Mapa map;
	private SalaVista sv;
	private Sala s;
	private ControlMochila cM;
	private Personaje perso;
	private JFrame ventanaPri;
	private PanelPrincipal vis;
	private Boolean pos = true;
	private int huir = 0;
	private VentanaProgreso vP;
	public ControlMapa() {
		
		this.ventanaPri = new JFrame("Lemuria");
		this.ventanaPri.setBounds(0,0,1016,579);
		this.ventanaPri.setLocationRelativeTo(null);
		this.ventanaPri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void despliega (BackgroundPanel b) {
		
		vis = new PanelPrincipal(this);
		vis.setPanelEscenario(b);
		this.ventanaPri.setContentPane(vis);
		this.ventanaPri.setVisible(true);
		
	}
	public void desplazamiento(int dir) throws DireccionNoValida {
		
		if (dir == Direccion.ABAJO||dir == Direccion.ARRIBA||dir == Direccion.DERECHA ||dir ==  Direccion.IZQUIERDA) {
			this.map.cambiarSala(dir);		
			this.actualizarFondo();
		} else {
			throw new DireccionNoValida();
		}
	}
	
	public void actualizarFondo () {
		
		BackgroundPanel panel;
		Item item;
		Enemigo enemy;
		String nom;
		s = this.map.getSala();
		enemy = s.getMasSIOsare();
		nom = s.getNombre();
		panel = new BackgroundPanel(nom);
		
		if (enemy == null) {
			item = s.getCoso();
			if (item != null) {
				panel.setItem(item.getNombre());
			}
			
		} else {
			panel.setEnemigo(enemy.getNombre());
		}
		this.despliega(panel);
	}
	public void setMapa(Mapa m) {
		this.map = m;
	}
	
	public void SetVista(SalaVista v) {
		this.sv = v;
	}
	
	
	public Mapa getMap() {
		return map;
	}

	public SalaVista getSv() {
		return sv;
	}
	
	public Personaje getPerso() {
		return perso;
	}
	public void setPerso(Personaje perso) {
		this.perso = perso;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando;
		int dir; 
		ControlPelea ctrlP = new ControlPelea();
		ControlMochila cMochila = new ControlMochila();
		 
		comando = e.getActionCommand();
		
		dir = Integer.parseInt(comando);
		try {
			if (dir == Direccion.ABAJO||dir == Direccion.ARRIBA||dir == Direccion.DERECHA ||dir ==  Direccion.IZQUIERDA) {
				huir++;
				System.out.println("Victoria: "+ctrlP.getVictoria());
				if(huir > 3 && ctrlP.getVictoria() == 0 ) {
					JOptionPane.showMessageDialog(null, "Ya no puedes huir");
				}else {
					this.desplazamiento(dir);
				}
				
				
				if (pos==false) {
					System.out.println("Intento de cambio");
					vP.dispose();
					pos = true;
				} else {
					
				}
			} else if (dir == 1){
				try {
					vP = new VentanaProgreso(this.getPerso().getAtaque(), this.getPerso().getDefensa(),
							s.getMasSIOsare().getAtaque(), s.getMasSIOsare().getDefensa());

					if (pos==false) {
						JOptionPane.showMessageDialog(null, "Ya esta abierto");
					}else {
						
						vP.setVisible(true);
						pos=false;
					}
				}catch (Exception e1) {
					
				}
				
				
			}else if (dir == 5){
				if (s.getMasSIOsare() != null) {
					
					Enemigo enemy = ctrlP.combate(s.getMasSIOsare(),this.getPerso());
					
					if (ctrlP.getVictoria() == 0) {
						
					} else {
						huir=0;
					}
					
					
					if (this.getPerso().getVida()<=0) {
						BackgroundPanel bP = new BackgroundPanel("Game Over");
						this.despliega(bP);
						for (JButton i : vis.getjB()) {
							i.setEnabled(false);
						}
					} else {
						s.setMasSIOsare(enemy);
						this.actualizarFondo();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "No hay enemigo");
				}
				
			} else if (dir == 7){
				cMochila.abrirMochila(this.getPerso(), s);
				this.actualizarFondo();
				
			}else if (dir == 9) {
				if (s.getMasSIOsare() == null) {
					if (s.getCoso() == null) {
						JOptionPane.showMessageDialog(null, "No hay ningun item disponible");
					}else {
						cM = new ControlMochila();
						Item itemDejado = cM.recoger(s.getCoso(), this.getPerso());
						if (perso.getCofre()==null) {
							s.setCoso(itemDejado);
							JOptionPane.showMessageDialog(null, "Tomaste el item");
							this.actualizarFondo();
						} else {
							BackgroundPanel bP = new BackgroundPanel("Pantalla de Victoria");
							this.despliega(bP);
							for (JButton i : vis.getjB()) {
								i.setEnabled(false);
							}
						}
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "No has derrotado al enemigo");
				}
			}else {
				throw new DireccionNoValida();
			}
			
		} catch (DireccionNoValida e1) {
			e1.printStackTrace();
		}
		
	}
}
