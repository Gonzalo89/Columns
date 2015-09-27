package vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;

import modelo.Bloque;
import modelo.Constantes;
import modelo.Juego;
import modelo.Mapa;

public class VistaJuego  extends JPanel{
	private static final long serialVersionUID = 1L;
	private Juego miJuego;
    private Vector<VistaBloque> vBloques = new Vector<VistaBloque>();
  	
	public VistaJuego(Juego miJuego) {
		super();
		this.miJuego = miJuego;
		KeyListener  listener = new MyKeyListener(this);
		addKeyListener(listener);
		setFocusable(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		g2.clearRect(0, 0, Constantes.anchoPantalla, Constantes.altoPantalla);
		
		if(miJuego.faltaAgregarPieza()){
			VistaBloque vBloque = new VistaBloque(miJuego.getPiezaParaAgregar().getBloque1());
			vBloques.add(vBloque);
			vBloque = new VistaBloque(miJuego.getPiezaParaAgregar().getBloque2());
			vBloques.add(vBloque);
			vBloque = new VistaBloque(miJuego.getPiezaParaAgregar().getBloque3());			
			vBloques.add(vBloque);
			miJuego.setPiezaParaAgregar(null);
		}
		
		Iterator<VistaBloque> it = this.vBloques.iterator();
		while(it.hasNext()) {
			VistaBloque vBloque = it.next();
			if(!vBloque.estaEliminado()){
				vBloque.dibujar(g2);
			}else{
				it.remove();	
			}			
		}
	 }	
	
	//KeyListener
		public class MyKeyListener implements KeyListener{
			private VistaJuego vJuego;
			
			public MyKeyListener(VistaJuego vJuego) {
				this.vJuego = vJuego;
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				this.vJuego.apretoTecla(arg0);
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		}

	public void apretoTecla(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {			
		case KeyEvent.VK_RIGHT:
			this.miJuego.moverDerecha();
			break;
		case KeyEvent.VK_LEFT:
			this.miJuego.moverIzquierda();
			break;
		case KeyEvent.VK_UP:
			this.miJuego.moverArriba();
			break;	
		case KeyEvent.VK_DOWN:
			this.miJuego.bajarBloque();
			break;	
		}
	}
}
