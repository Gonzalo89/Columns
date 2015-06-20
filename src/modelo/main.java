package modelo;

import javax.swing.JFrame;

import vista.VistaJuego;

public class main {
	public static void main(String[] args) throws Exception {
		Juego juego = new Juego();
		VistaJuego vg = new VistaJuego(juego);
		JFrame frame = new JFrame("Columns");
		frame.add(vg);		
		frame.setSize(Constantes.anchoPantalla, Constantes.altoPantalla);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			vg.repaint();
			Thread.sleep(10);
		}
	}
}