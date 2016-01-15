package Ej_Enemigos;

public class Personaje extends ObjetoJuego{
	 
	private Coordenada cord;

	public Personaje() {
		super('o');
		cord = new Coordenada(1, 3);
	}
	
	public int getX() {
		return cord.x;
	}

	public int getY() {
		return cord.y;
	}

	public boolean moverPersonaje(Tile[][] tablero, int x, int y){
		if(y<9 && y>=0 && x<9 && x>=0){
			if(tablero[y][x].go() == Tile.GO){
				cord = new Coordenada(x, y);
			}
			else if (tablero[y][x].go() == Tile.STOP){
				System.out.println("No puedes ir en esa dirección");
			}
			else if(tablero[y][x].go() == Tile.WIN){
				return true;
			}
		}
		else{
			System.out.println("Las coordendadas de destino no son válidas");
		}
		return false;
	}
	
}
