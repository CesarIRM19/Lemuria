/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.vista;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import mx.uaemex.fi.paradigams_1.Lemurian.controller.ControlMapa;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Direccion;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Sala;
public class SalaVista extends JFrame {
	private Sala salon;
	
	private JButton btnNorte,btnSur,btnEste,btnOeste;
	private JButton btnAtaque, btnMochila;
	private JPanel panelData, panelControl;
	private BackgroundPanel BGP;
	private ControlMapa ctrlM;
	private PanelPrincipal panel;

	public SalaVista(ControlMapa ctrlM) {
		panel = new PanelPrincipal(ctrlM);
		this.add(panel);
		
	}
	public void setPanel(BackgroundPanel p) {
		this.panel.setPanelEscenario(p);
		this.setContentPane(this.panel);
		this.validate();
	}
	
	public String muestra(Sala salon) {
		return salon.getNombre();
	}
	
}
