package modelo;

public class ThreadBajarBloque extends Thread{//podria no ser necesario
	private Juego juego;

	public ThreadBajarBloque(Juego juego) {
		super();
		this.juego = juego;
	}

	@Override
	public void run() {
		try {
			while(true) {
			Thread.sleep(Constantes.tiempoBajada);
			this.juego.bajarBloque();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}