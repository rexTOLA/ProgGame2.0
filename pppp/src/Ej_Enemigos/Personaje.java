package Ej_Enemigos;

public class Personaje extends ObjetoJuego implements Printeable{
	 
	private Coordenada cord;

	public Personaje() {
		super('p');
		cord = new Coordenada(1, 3);
	}
	
	public int getX() {
		return cord.x;
	}

	public int getY() {
		return cord.y;
	}

	public int moverPersonaje(Tile[][] tablero, int x, int y, Printeable[][] tab2){
		if(y<9 && y>=0 && x<9 && x>=0){
			if(tablero[y][x].go() == Tile.GO){
				if(tab2[x][y]!=null){
					return ((Tile)tab2[x][y]).go();
				}
				tab2[cord.x][cord.y] = null;
				cord = new Coordenada(x, y);
				tab2[x][y] = this;
			}
			return tablero[y][x].go();
		}
		else{
			System.out.println("Las coordendadas de destino no son v�lidas");
			return -1;
		}
	}
	
}
