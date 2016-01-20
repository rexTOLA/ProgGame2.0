//No Editable
package Ej_Enemigo;

public class Tile extends ObjetoJuego{

	final static int DIE = 0;
	final static int GO = 1;
	final static int WIN = 2;

	
	public Tile(Character type) {
		super(type);
	}	
	
	public int go(){
		return GO;
	}
}
