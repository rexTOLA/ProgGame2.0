package Ej_Walls;

public class Personaje extends ObjetoJuego{
	 
	private Coordenada cord;

	//Janette
	public Personaje() {
		super('8');
		cord = new Coordenada(1, 3);
	}
	
	public int getX() {
		return cord.x;
	}

	public int getY() {
		return cord.y;
	}

	public boolean moverPersonaje(Tile[][] tablero, int x, int y){
		if(tablero[y][x].go() == Tile.GO){
			cord = new Coordenada(x, y);
		}
		else if (tablero[y][x].go() == Tile.STOP){
			System.out.println("No puedes ir en esa dirección");
		}
		else if(tablero[y][x].go() == Tile.WIN){
			return true;
		}
		return false;
		
	}
	
}
