/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */

package mx.uaemex.fi.paradigams_1.Lemurian.vista;

import javax.swing.JFrame;

import mx.uaemex.fi.paradigams_1.Lemurian.controller.ControlAsignacionAleatoria;
import mx.uaemex.fi.paradigams_1.Lemurian.controller.ControlMapa;
import mx.uaemex.fi.paradigams_1.Lemurian.Error.DireccionNoValida;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Direccion;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Enemigo;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Item;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Mapa;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Personaje;
import mx.uaemex.fi.paradigams_1.Lemurian.model.Sala;

public class TestVentana extends JFrame {
	
	public static void main(String[] args) {
		
		ControlAsignacionAleatoria cAA = new ControlAsignacionAleatoria();
		ControlMapa ctrlMapa;
		Enemigo enemy;
		Mapa map;
		Sala[][] salas;
		Item item;
		item = new Item();
		item.setNombre("PocionDefensa");
		Personaje perso = new Personaje();
		
		salas = cAA.asignarEscenaro();
		cAA.asignarEnemigo();
		cAA.asignarItem();
		perso = perso.crearPersonaje();
		
		map = new Mapa(salas);
		
		ctrlMapa = new ControlMapa();
		ctrlMapa.setMapa(map);
		ctrlMapa.setPerso(perso);
		
		SalaVista ventana = new SalaVista(ctrlMapa);
		ctrlMapa.SetVista(ventana);
		
		
		BackgroundPanel panel = new BackgroundPanel("Pantalla de Inicio");
		ctrlMapa.despliega(panel);
	}

}
