package Ej_Enemigos;

public class Hole extends Tile {

	public Hole(Character type){
		super(type);
	}

	@Override
	public int go() {
		return DIE;
	}
}
