/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mx.uaemex.fi.paradigams_1.Lemurian.controller.ControlMapa;

public class BackgroundPanel extends JPanel {
	private BufferedImage fondo;
	int i = 0;
	private BufferedImage enemigo;
	private BufferedImage item;
	
	public void setEnemigo(String nombreE) {
		try {
			enemigo = ImageIO.read(getClass().getResource("/scrips/Enemigos/"+nombreE+".png"));

		} catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "El juego tiene errores, por favor restaurar");
		}
	}
	public void setItem(String item) {
		try {
			this.item = ImageIO.read(getClass().getResource("/scrips/Items/"+item+".png"));
			i++;
			
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "El juego tiene errores, por favor restaurar");
		}
	}
	public BackgroundPanel (String fondoImg) {
		try {
			fondo = ImageIO.read(getClass().getResource("/scrips/"+fondoImg+".jpg"));

		} catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "El juego tiene errores, por favor restaurar");
		}
	}
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(fondo, 0, 0, null);
		
		if (this.enemigo!=null) {
			g.drawImage(this.enemigo, 300, 160, null);
		}else {
			if (this.item != null) {
				g.drawImage(item, 250, 190, null);
			}
		}
	}
	
}
