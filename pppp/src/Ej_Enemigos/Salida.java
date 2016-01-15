package Ej_Enemigos;

public class Salida extends Tile{

	public Salida() {
		super('$');
	}

	@Override
	public int go() {
		return WIN;
	}

	
}
