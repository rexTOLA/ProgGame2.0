package Ej_Enemigos;

public class Tile extends ObjetoJuego{

	final static int STOP = 0;
	final static int GO = 1;
	final static int WIN = 2;

	
	public Tile(Character type) {
		super(type);
	}	
	
	public int go(){
		return GO;
	}
}
