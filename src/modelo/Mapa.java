package modelo;

public class Mapa {
	private static Mapa mapa;
	private static Bloque[][] matriz;

	private Mapa() {
		// TODO Agregar mas cantidad de bloques para mostrar solo el primero?
		matriz = new Bloque[Constantes.cantBloquesX][Constantes.cantBloquesY];
	}

	public static Mapa getInstance() {
		if (mapa == null)
			mapa = new Mapa();

		return mapa;
	}

	public void agregar(Bloque bloque, int x, int y) {
		matriz[x][y] = bloque;
	}

	public void borrar(int x, int y) {
		matriz[x][y] = null;
	}

	public Bloque get(int x, int y) {
		return matriz[x][y];
	}

	public boolean estaLibre(int x, int y) {
		if (x >= Constantes.cantBloquesX || y >= Constantes.cantBloquesY)
			return false;

		if (x < 0 || y < 0)
			return false;

		if (matriz[x][y] == null)
			return true;

		return false;
	}

	// TODO borrar si hay tres bloques del mismo color en todas direcciones
	public void actualizarMapa() {
		boolean cambio;

		// Borra tres bloques horizontales del mismo color
		for (int i = 0; i <= Constantes.cantBloquesX - 3; i++) {
			for (int j = 0; j < Constantes.cantBloquesY; j++) {
				if (matriz[i][j] != null && matriz[i + 1][j] != null
						&& matriz[i + 2][j] != null) {
					int color1 = matriz[i][j].getColor();
					int color2 = matriz[i + 1][j].getColor();
					int color3 = matriz[i + 2][j].getColor();

					if (color1 == color2 && color2 == color3) {
						matriz[i][j].eliminar();
						matriz[i + 1][j].eliminar();
						matriz[i + 2][j].eliminar();
					}
				}
			}
		}

		// Borra tres bloques verticales del mismo color
		for (int i = 0; i < Constantes.cantBloquesX; i++) {
			for (int j = 0; j <= Constantes.cantBloquesY - 3; j++) {
				if (matriz[i][j] != null && matriz[i][j + 1] != null
						&& matriz[i][j + 2] != null) {
					int color1 = matriz[i][j].getColor();
					int color2 = matriz[i][j + 1].getColor();
					int color3 = matriz[i][j + 2].getColor();

					if (color1 == color2 && color2 == color3) {
						matriz[i][j].eliminar();
						matriz[i][j + 1].eliminar();
						matriz[i][j + 2].eliminar();
					}
				}
			}
		}

		// Borra tres bloques en diagonal de izquierda a derecha de arriba hacia
		// abajo del mismo color
		for (int i = 0; i <= Constantes.cantBloquesX - 3; i++) {
			for (int j = 0; j <= Constantes.cantBloquesY - 3; j++) {
				if (matriz[i][j] != null && matriz[i + 1][j + 1] != null
						&& matriz[i + 2][j + 2] != null) {
					int color1 = matriz[i][j].getColor();
					int color2 = matriz[i + 1][j + 1].getColor();
					int color3 = matriz[i + 2][j + 2].getColor();

					if (color1 == color2 && color2 == color3) {
						matriz[i][j].eliminar();
						matriz[i + 1][j + 1].eliminar();
						matriz[i + 2][j + 2].eliminar();
					}
				}
			}
		}

		// Borra tres bloques en diagonal de izquierda a derecha de abajo hacia
		// arriba del mismo color
		for (int i = 0; i <= Constantes.cantBloquesX - 3; i++) {
			for (int j = 2; j < Constantes.cantBloquesY; j++) {
				if (matriz[i][j] != null && matriz[i + 1][j - 1] != null
						&& matriz[i + 2][j - 2] != null) {
					int color1 = matriz[i][j].getColor();
					int color2 = matriz[i + 1][j - 1].getColor();
					int color3 = matriz[i + 2][j - 2].getColor();

					if (color1 == color2 && color2 == color3) {
						matriz[i][j].eliminar();
						matriz[i + 1][j - 1].eliminar();
						matriz[i + 2][j - 2].eliminar();
					}
				}
			}
		}

		// Pongo en null bloques eliminados
		for (int i = 0; i < Constantes.cantBloquesX; i++) {
			for (int j = 0; j < Constantes.cantBloquesY; j++) {
				if (matriz[i][j] != null) {
					if (matriz[i][j].estaEliminado()) {
						matriz[i][j] = null;
					}
				}
			}
		}

		// Baja bloques (Efecto gravedad)
		do {
			cambio = false;
			for (int i = 0; i <= Constantes.cantBloquesX - 3; i++) {
				for (int j = Constantes.cantBloquesY - 1; j > 0; j--) {
					if (matriz[i][j] == null && matriz[i][j - 1] != null) {
						matriz[i][j - 1].bajar();
						cambio = true;
					}
				}
			}
		} while (cambio);
	}
}
