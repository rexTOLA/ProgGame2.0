//No Editable
package Ej_Enemigo;

public class Enemigo extends Tile implements Printeable{

	final int MAX_RANGE = 6;
	private Coordenada coord;
	
	public Enemigo(Coordenada coord){
		super('X');
		this.coord = coord;
	}
	
	public int getX() {
		return coord.x;
	}

	public int getY() {
		return coord.y;
	}
	
	public int getSafeRange(){
		return (coord.y - MAX_RANGE);
	}
	
	@Override
	public int go() {
		return DIE;
	}
	
}
