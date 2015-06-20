package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import modelo.Bloque;
import modelo.Constantes;
import modelo.Dibujable;

public class VistaBloque implements Dibujable{
	private Bloque bloque;

	public VistaBloque(Bloque bloque) {
		super();
		this.bloque = bloque;
	}
	
	private Color getColor(int numColor) {
		Color resultado = null;
		switch(numColor) {
		case 1:
			resultado = Color.BLACK;
			break;
		case 2:
			resultado = Color.BLUE;
			break;
		case 3:
			resultado = Color.CYAN;
			break;
		case 4:
			resultado = Color.GREEN;
			break;
		case 5:
			resultado = Color.RED;
			break;
		default:
			resultado = Color.PINK;
			}
		return resultado;
	}

	@Override
	public void dibujar(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		g2.setColor(this.getColor(this.bloque.getColor()));		
		g2.fillRect(this.bloque.getX(), this.bloque.getY(), Constantes.anchoBloque, Constantes.altoBloque);	
	}

}
