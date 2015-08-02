package modelo;

import java.util.Random;
import java.util.Vector;

public class Juego {
	private Vector<Bloque> bloques;
	private Pieza piezaParaAgregar = null;
	private Pieza piezaActual;

	public Juego() {
		bloques = new Vector<Bloque>();
		this.piezaNueva();
		new ThreadBajarBloque(this).start();
	}

	public Vector<Bloque> getBloques() {
		return bloques;
	}

	private void piezaNueva() {
		int randomPos = randomPos();
		int randomNumColor1 = randomColor();
		int randomNumColor2 = randomColor();
		int randomNumColor3 = randomColor();
		Bloque bloqueActual1 = new Bloque(randomPos,
				-2 * Constantes.altoBloque, randomNumColor1);
		Bloque bloqueActual2 = new Bloque(randomPos, -Constantes.altoBloque,
				randomNumColor2);
		Bloque bloqueActual3 = new Bloque(randomPos, 0, randomNumColor3);
		this.piezaActual = new Pieza(bloqueActual1, bloqueActual2, bloqueActual3);
		bloques.add(bloqueActual1);
		bloques.add(bloqueActual2);
		bloques.add(bloqueActual3);
		this.piezaParaAgregar = this.piezaActual;
	}

	private int randomPos() {
		Random rnd = new Random();
		int resultado = rnd.nextInt(Constantes.cantBloquesX)
				* Constantes.anchoBloque;
		return resultado;
	}

	private int randomColor() {
		Random rnd = new Random();
		int resultado = rnd.nextInt(5);
		return resultado;
	}

	public void bajarBloque() {
		if (piezaActual != null) {
			int posFinal = piezaActual.getBloque3().getY() + 2
					* Constantes.altoBloque;
			if (posFinal <= Constantes.altoPantalla) {
				piezaActual.getBloque1().bajar();
				piezaActual.getBloque2().bajar();
				piezaActual.getBloque3().bajar();
			}else{
				this.piezaNueva();
			}
		}
	}

	public void moverDerecha() {
		if (piezaActual != null) {
			int posFinal = piezaActual.getBloque1().getX() + 2 * Constantes.anchoBloque;
			if (posFinal <= Constantes.anchoPantalla) {
				piezaActual.getBloque1().derecha();
				piezaActual.getBloque2().derecha();
				piezaActual.getBloque3().derecha();
			}
		}
	}

	public void moverIzquierda() {
		if (piezaActual != null) {
			int posFinal = piezaActual.getBloque1().getX() - Constantes.anchoBloque;
			if (posFinal >= 0) {
				piezaActual.getBloque1().izquierda();
				piezaActual.getBloque2().izquierda();
				piezaActual.getBloque3().izquierda();
			}
		}
	}

	public void moverArriba() {
		piezaActual.subir();
	}

	public void moverAbajo() {
		piezaActual.bajar();
	}

	public boolean faltaAgregarPieza() {
		if (this.piezaParaAgregar != null)
			return true;
		return false;
	}

	public Pieza getPiezaParaAgregar() {
		return piezaParaAgregar;
	}

	public void setPiezaParaAgregar(Pieza piezaParaAgregar) {
		this.piezaParaAgregar = piezaParaAgregar;
	}
	
	
}
