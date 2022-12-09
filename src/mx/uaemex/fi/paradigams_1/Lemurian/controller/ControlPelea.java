/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import mx.uaemex.fi.paradigams_1.Lemurian.model.Enemigo;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Item;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Mapa;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Personaje;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Sala;
import mx.uaemex.fi.paradigams_1.Lemurian.vista.BackgroundPanel;

public class ControlPelea{
	private int atqE, defE, atqP, defP;
	private int victoria=0;
	private Random rand;
	public Enemigo combate(Enemigo enemy, Personaje per) {
		this.rand= new Random();
		int vidaRestante;
		atqE = rand.nextInt(enemy.getAtaque())+1;
		defE = enemy.getDefensa();
		atqP = rand.nextInt(per.getAtaque())+1;
		defP = per.getDefensa();
		
		System.out.println("Ataque del enemigo: "+ atqE + ". Ataque del personaje: "+ atqP);
		if (atqP >= defE && atqE <= defP) {
			
			JOptionPane.showMessageDialog(null, "Ganaste");
			victoria=1;
			enemy = null;
		} else if (atqP <= defE && atqE >= defP) {
			JOptionPane.showMessageDialog(null, "Perdiste");
			victoria=0;
			vidaRestante = per.getVida() - 1;
			per.setVida(vidaRestante);
		}else {
			JOptionPane.showMessageDialog(null, "Empate");
			victoria=0;
		}
		return enemy;
		
	}
	public int getVictoria() {
		return victoria;
	}
	public void setVictoria(int victoria) {
		this.victoria = victoria;
	}
	
}
