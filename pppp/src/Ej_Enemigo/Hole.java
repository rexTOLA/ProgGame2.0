//No Editable
package Ej_Enemigo;

public class Hole extends Tile {

	public Hole(Character type){
		super(type);
	}

	@Override
	public int go() {
		return DIE;
	}
}
