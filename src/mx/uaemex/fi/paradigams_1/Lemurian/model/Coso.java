/**
 * @author Cesar Ivan Ramirez Martinez, Arturo Dante Mendez Reyez
 */
package mx.uaemex.fi.paradigams_1.Lemurian.model;

import java.util.Random;

public class Coso {

	public static void main(String[] args) {
		Random r= new Random(25);
		
		for(int i=0;i<10;i++){
			System.out.println(r.nextInt(3));
		}
      System.out.println("____________");
      r= new Random(25);
      for(int i=0;i<10;i++){
			System.out.println(r.nextInt(3));
		}
	}

}
