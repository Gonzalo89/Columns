package modelo;

public class Pieza {
	Bloque bloque1 ;
	Bloque bloque2 ;
	Bloque bloque3 ;
	
	public Pieza(Bloque bloque1, Bloque bloque2,Bloque bloque3) {
		this.bloque1 = bloque1;
		this.bloque2 = bloque2;
		this.bloque3 = bloque3;
	}

	public Bloque getBloque1() {
		return bloque1;
	}

	public Bloque getBloque2() {
		return bloque2;
	}

	public Bloque getBloque3() {
		return bloque3;
	}
	
	public void bajar() {
		Bloque aux = new Bloque();
		bloque3.copiarA(aux);
		bloque2.copiarA(bloque3);
		bloque1.copiarA(bloque2);
		aux.copiarA(bloque1);
	}
	
	public void subir() {
		Bloque aux = bloque1;
		bloque1 = bloque2;
		bloque2 = bloque3;
		bloque3 = aux;		
	}
}
