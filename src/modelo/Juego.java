package modelo;

import java.util.Random;
import java.util.Vector;

public class Juego {
	private Vector<Bloque> bloques;
	private Pieza piezaParaAgregar = null; //Para que se dibuje la pieza
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
		Mapa miMapa = Mapa.getInstance();
		int randomPos = randomPos();
		int randomNumColor1 = randomColor();
		int randomNumColor2 = randomColor();
		int randomNumColor3 = randomColor();
		Bloque bloqueActual1 = new Bloque(randomPos,
				0, randomNumColor1);
		Bloque bloqueActual2 = new Bloque(randomPos, 1,
				randomNumColor2);
		Bloque bloqueActual3 = new Bloque(randomPos, 2, randomNumColor3);
		miMapa.agregar(bloqueActual1, randomPos, 0);
		miMapa.agregar(bloqueActual2, randomPos, 1);
		miMapa.agregar(bloqueActual3, randomPos, 2);		
		
		this.piezaActual = new Pieza(bloqueActual1, bloqueActual2, bloqueActual3);
		bloques.add(bloqueActual1);
		bloques.add(bloqueActual2);
		bloques.add(bloqueActual3);
		this.piezaParaAgregar = this.piezaActual;
	}

	private int randomPos() {
		Random rnd = new Random();
		int resultado = rnd.nextInt(Constantes.cantBloquesX);				
		return resultado;
	}

	private int randomColor() {
		Random rnd = new Random();
		int resultado = rnd.nextInt(5);
		return resultado;
	}

	public void bajarBloque() { // Si no puede bajar crea bloque nuevo
		if (piezaActual != null) {
			if(Mapa.getInstance().estaLibre(piezaActual.getBloque3().getX(),
					piezaActual.getBloque3().getY() + 1)) {
				piezaActual.getBloque3().bajar(); //Dejar en ese orden
				piezaActual.getBloque2().bajar();
				piezaActual.getBloque1().bajar();
			}else{
				this.piezaNueva();
			}
		}
	}

	public void moverDerecha() {
		if (piezaActual != null) {
			if(Mapa.getInstance().estaLibre(piezaActual.getBloque3().getX() + 1,
					piezaActual.getBloque3().getY())) {			
				piezaActual.getBloque1().derecha();
				piezaActual.getBloque2().derecha();
				piezaActual.getBloque3().derecha();
			}
		}
	}

	public void moverIzquierda() {
		if (piezaActual != null) {
			if(Mapa.getInstance().estaLibre(piezaActual.getBloque3().getX() - 1,
					piezaActual.getBloque3().getY())) {						
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
