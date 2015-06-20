package modelo;

import java.util.Random;
import java.util.Vector;

public class Juego {
	private Vector<Bloque> bloques;
	private Pieza pieza;
	
	public Juego() {
		bloques = new Vector<Bloque>();
		this.piezaNueva();
		new ThreadBajarBloque(this).start();
	}

	public Vector<Bloque> getBloques() {
		return bloques;
	}	
	
	public void piezaNueva() {
		int randomPos = randomPos();
		int randomNumColor1 = randomColor();
		int randomNumColor2 = randomColor();
		int randomNumColor3 = randomColor();
		Bloque bloqueActual1 = new Bloque(randomPos, -2 * Constantes.altoBloque, randomNumColor1);
		Bloque bloqueActual2 = new Bloque(randomPos, -Constantes.altoBloque, randomNumColor2);
		Bloque bloqueActual3 = new Bloque(randomPos, 0, randomNumColor3);
		this.pieza = new Pieza(bloqueActual1, bloqueActual2, bloqueActual3);
		bloques.add(bloqueActual1);
		bloques.add(bloqueActual2);
		bloques.add(bloqueActual3);		
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
		if (pieza != null) {
			pieza.getBloque1().bajar();
			pieza.getBloque2().bajar();
			pieza.getBloque3().bajar();			
		}
	}

	public void moverDerecha() {
		pieza.getBloque1().derecha();
		pieza.getBloque2().derecha();
		pieza.getBloque3().derecha();
		
	}
	
	public void moverIzquierda() {
		pieza.getBloque1().izquierda();
		pieza.getBloque2().izquierda();
		pieza.getBloque3().izquierda();		
	}

	public void moverArriba() {
		pieza.subir();		
	}

	public void moverAbajo() {
		pieza.bajar();		
	}
}
