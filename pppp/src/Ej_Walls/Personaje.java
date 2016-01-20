//No Editable
package Ej_Walls;

import Capa_de_Presentacion.VentanaJuego;

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
		if(y<7 && y>=0 && x<9 && x>=0){
			if(tablero[y][x].go() == Tile.GO){
				cord = new Coordenada(x, y);
			}
			else if (tablero[y][x].go() == Tile.STOP){
				VentanaJuego.println("No puedes ir en esa dirección");
			}
			else if(tablero[y][x].go() == Tile.WIN){
				return true;
			}
		}
		else{
			VentanaJuego.println("Las coordendadas de destino no son válidas");
		}
		return false;
	}
	
}
