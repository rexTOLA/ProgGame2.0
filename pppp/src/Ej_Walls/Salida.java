//No Editable
package Ej_Walls;

public class Salida extends Tile{

	public Salida() {
		super('O');
	}

	@Override
	public int go() {
		return WIN;
	}

	
}
