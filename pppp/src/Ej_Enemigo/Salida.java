//No Editable
package Ej_Enemigo;

public class Salida extends Tile implements Printeable{

	private Coordenada coord;
	
	public Salida() {
		super('*');
		coord = new Coordenada(7, 3);
	}

	@Override
	public int go() {
		return WIN;
	}

	public int getX() {
		return coord.x;
	}

	public int getY() {
		return coord.y;
	}

	
}
