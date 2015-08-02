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
		int aux = bloque3.getColor();
		bloque3.setColor(bloque2.getColor());
		bloque2.setColor(bloque1.getColor());
		bloque1.setColor(aux);		
	}
	
	public void subir() {
		int aux = bloque1.getColor();
		bloque1.setColor(bloque2.getColor());
		bloque2.setColor(bloque3.getColor());
		bloque3.setColor(aux);			
	}
}
