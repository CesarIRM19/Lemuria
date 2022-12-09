/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.vista;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class VentanaProgreso extends JFrame {
	
	public VentanaProgreso(int aj, int dj, int ae, int de) {
		JPanel contentPane = new JPanel();
		
		setTitle("Niveles de poder");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar ataqueJugador = new JProgressBar();
		ataqueJugador.setBounds(37, 74, 277, 29);
		ataqueJugador.setValue(aj*10);
		ataqueJugador.setStringPainted(true);
		contentPane.add(ataqueJugador);
		
		JProgressBar ataqueEnemigo = new JProgressBar();
		ataqueEnemigo.setBounds(393, 74, 277, 29);
		ataqueEnemigo.setValue(ae*10);
		ataqueEnemigo.setStringPainted(true);
		contentPane.add(ataqueEnemigo);
		
		JProgressBar defensaJugador = new JProgressBar();
		defensaJugador.setBounds(37, 136, 277, 29);
		defensaJugador.setValue(dj*10);
		defensaJugador.setStringPainted(true);
		contentPane.add(defensaJugador);
		
		JProgressBar defensaEnemigo = new JProgressBar();
		defensaEnemigo.setBounds(393, 136, 277, 29);
		defensaEnemigo.setValue(de*10);
		defensaEnemigo.setStringPainted(true);
		contentPane.add(defensaEnemigo);
		
		JLabel lblNewLabel = new JLabel("JUGADOR");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.ITALIC, 17));
		lblNewLabel.setBounds(130, 10, 91, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnemigo = new JLabel("ENEMIGO");
		lblEnemigo.setFont(new Font("Segoe UI Black", Font.ITALIC, 17));
		lblEnemigo.setBounds(496, 10, 91, 29);
		contentPane.add(lblEnemigo);
		
		JLabel lblNewLabel_1 = new JLabel("Ataque");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(37, 51, 91, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Defensa");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(37, 113, 91, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Defensa");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1_1_1.setBounds(393, 113, 91, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ataque");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1_2.setBounds(393, 51, 91, 13);
		contentPane.add(lblNewLabel_1_2);
		
		 this.setLocationRelativeTo(null);
	}
	
	
	
	public void cambiarVentana() {
		this.dispose();
	}
}
