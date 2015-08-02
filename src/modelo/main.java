package modelo;

import javax.swing.JFrame;

import vista.VistaJuego;

public class main {
	public static void main(String[] args) throws Exception {
		Juego juego = new Juego();
		VistaJuego vg = new VistaJuego(juego);
		JFrame frame = new JFrame("Columns");
		frame.add(vg);
		//Harcodeo para que se vea bien
		frame.setSize(Constantes.anchoPantalla  + 16 , Constantes.altoPantalla + 38);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			vg.repaint();
			Thread.sleep(10);
		}
	}
}