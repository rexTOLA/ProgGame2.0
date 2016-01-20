//No Editable
package Ej_Deslizar;

public class Salida extends Tile{

	public Salida() {
		super('*');
	}

	@Override
	public int stop_slide() {
		return WIN;
	}

	
}
