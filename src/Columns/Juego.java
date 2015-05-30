package Columns;

import java.util.Random;
import java.util.Vector;

public class Juego {
	Vector<Bloque> bloques;
	Bloque bloqueActual1 ;
	Bloque bloqueActual2 ;
	Bloque bloqueActual3 ;
	
	public Juego() {
		bloques = new Vector<Bloque>();
		this.bloqueNuevo();
		new ThreadBajarBloque(this).start();
	}

	public Vector<Bloque> getBloques() {
		return bloques;
	}	
	
	public void bloqueNuevo() {
		int randomPos = randomPos();
		int randomNumColor1 = randomColor();
		int randomNumColor2 = randomColor();
		int randomNumColor3 = randomColor();
		this.bloqueActual1 = new Bloque(randomPos, -2 * Constantes.altoBloque, randomNumColor1);
		this.bloqueActual2 = new Bloque(randomPos, -Constantes.altoBloque, randomNumColor2);
		this.bloqueActual3 = new Bloque(randomPos, 0, randomNumColor3);
		bloques.add(this.bloqueActual1);
		bloques.add(this.bloqueActual2);
		bloques.add(this.bloqueActual3);		
	}
	
	private int randomPos() {
		Random rnd = new Random();
		int resultado = rnd.nextInt(Constantes.cantBloquesX) * Constantes.anchoBloque;		
		return resultado;
	}
	
	private int randomColor() {
		Random rnd = new Random();
		int resultado = rnd.nextInt(5);		
		return resultado;
	}
	
	public void bajarBloque() {
		if (this.bloqueActual1 != null) {
			this.bloqueActual1.bajar();
			this.bloqueActual2.bajar();
			this.bloqueActual3.bajar();			
		}
	}

	public void moverDerecha() {
		this.bloqueActual1.derecha();
		this.bloqueActual2.derecha();
		this.bloqueActual3.derecha();
		
	}
	
	public void moverIzquierda() {
		this.bloqueActual1.izquierda();
		this.bloqueActual2.izquierda();
		this.bloqueActual3.izquierda();
		
	}
}
