//No Editable
package Ej_Walls;

public class Pared extends Tile {

	public Pared(Character type){
		super(type);
	}

	@Override
	public int go() {
		return STOP;
	}
}
