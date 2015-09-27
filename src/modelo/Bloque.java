package modelo;

public class Bloque {
	private int x;
	private int y;
	private int color;
	
	public Bloque(int x, int y, int color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public Bloque() {
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public synchronized void bajar() {
		Mapa miMapa = Mapa.getInstance();
		miMapa.borrar(x, y);
		miMapa.agregar(this, x, y + 1);
		this.y += 1;		
	}

	public void derecha() {
		Mapa miMapa = Mapa.getInstance();
		miMapa.borrar(x, y);
		miMapa.agregar(this, x + 1, y);
		this.x += 1;		
	}

	public void izquierda() {
		Mapa miMapa = Mapa.getInstance();
		miMapa.borrar(x, y);
		miMapa.agregar(this, x - 1, y);
		this.x -= 1;		
	}
	
	public void copiarA(Bloque unBloque) {
		unBloque.setColor(color);
		unBloque.setX(x);
		unBloque.setY(y);
	}
	
	public void set(Bloque unBloque) {
		this.color = unBloque.getColor();
		this.y = unBloque.getY();
		this.x = unBloque.getX();
	}

	public void setColor(int color) {
		this.color = color;
	}
	
}
