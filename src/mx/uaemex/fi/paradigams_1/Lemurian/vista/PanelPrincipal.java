/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mx.uaemex.fi.paradigams_1.Lemurian.controller.ControlMapa;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Direccion;

public class PanelPrincipal extends JPanel {
	private ControlMapa ctrlM;
	public static final String ATACAR = "5";
	private BufferedImage fondo;
	private BackgroundPanel escenario;
	private JButton btn;
	private List<JButton> jB;
	public PanelPrincipal(ControlMapa ctrlM) {
		super(null);
		
		try {
			jB = new ArrayList<>();
			this.ctrlM = ctrlM;
			this.fondo = ImageIO.read(getClass().getResource("/scrips/Consola.png"));
			
			btn = new JButton();
			
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(877, 67, 48, 48);
			btn.setActionCommand(Direccion.ARRIBA+"");
			btn.addActionListener(this.ctrlM);
			jB.add(btn);
			this.add(btn);
			
			btn = new JButton();
			
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(877, 163, 48, 48);
			btn.setActionCommand(Direccion.ABAJO+"");
			btn.addActionListener(this.ctrlM);
			jB.add(btn);
			this.add(btn);
			
			btn = new JButton();
			
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(829, 115, 48, 48);
			btn.setActionCommand(Direccion.IZQUIERDA+"");
			btn.addActionListener(this.ctrlM);
			jB.add(btn);
			this.add(btn);
			
			btn = new JButton();
			
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(925, 115, 48, 48);
			btn.setActionCommand(Direccion.DERECHA+"");
			btn.addActionListener(this.ctrlM);
			jB.add(btn);
			this.add(btn);
			
			btn = new JButton();
			
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(23, 172, 71, 71);
			btn.setActionCommand(this.ATACAR);
			btn.addActionListener(this.ctrlM);
			jB.add(btn);
			this.add(btn);
			
			btn = new JButton();
			
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(112, 279, 71, 72);
			btn.setActionCommand(9+"");
			btn.addActionListener(this.ctrlM);
			jB.add(btn);
			this.add(btn);
			
			btn = new JButton();
			
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(271, 473, 225, 27);
			btn.setActionCommand(7+"");
			btn.addActionListener(this.ctrlM);
			jB.add(btn);
			this.add(btn);
			
			btn = new JButton();
			
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(521, 473, 225, 27);
			btn.setActionCommand(1+"");
			btn.addActionListener(this.ctrlM);
			jB.add(btn);
			this.add(btn);
			
		}catch(IOException ie){
			JOptionPane.showMessageDialog(null, "Mal");
			
		}
		
	}
	
	
	public List<JButton> getjB() {
		return jB;
	}


	public void setjB(List<JButton> jB) {
		this.jB = jB;
	}


	public JButton getBtn() {
		return btn;
	}


	public void setBtn(JButton btn) {
		this.btn = btn;
	}


	public void setPanelEscenario(BackgroundPanel b) {
		this.escenario = b;
		this.escenario.setBounds(230, 90, 540, 360);
		this.add(escenario);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(this.fondo, 0, 0, null);
	}
	
}
