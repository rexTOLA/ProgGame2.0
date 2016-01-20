//No Editable
package Ej_Deslizar;

public abstract class Tile extends ObjetoJuego{

	final static int STOP = 0;
	final static int SLIDE = 1;
	final static int WIN = 2;
	
	public Tile(Character type) {
		super(type);
	}	
	
	public abstract int stop_slide();
}
