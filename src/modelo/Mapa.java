package modelo;

public class Mapa {
private static Mapa mapa;
private static Bloque [][] matriz; 

private Mapa () {
	//Agregar mas cantidad de bloques para mostrar solo el primero?
	matriz = new Bloque[Constantes.cantBloquesX][Constantes.cantBloquesY];
}

public static Mapa getInstance(){
	if (mapa == null) 
		mapa = new Mapa();
	
	return mapa;
}

public void agregar(Bloque bloque , int x, int y){
	matriz[x][y] = bloque;
}

public void borrar(int x, int y){
	matriz[x][y] = null;
}

public Bloque get(int x, int y){
	return matriz[x][y];
}

public boolean estaLibre (int x, int y){
	if(x >= Constantes.cantBloquesX || y >= Constantes.cantBloquesY)
		return false;

	if(x < 0 || y < 0)
		return false;
			
	if (matriz[x][y] == null)
		return true;
	
		return false;				
}
}
