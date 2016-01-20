//No Editable
package Ej_Enemigo;

import Capa_de_Presentacion.VentanaJuego;

public class Ej_Enemigo {

	Tablero tablero;
	Personaje p;
	Enemigo e1;
	Enemigo e2;
	Enemigo e3;
	Salida s;
	Printeable[][] tab2 = new Printeable[9][9];
	
	public Ej_Enemigo(){
		tablero = new Tablero();
		p = new Personaje();
		e1 = new Enemigo(new Coordenada(2, 7));
		e2 = new Enemigo(new Coordenada(4, 6));
		e3 = new Enemigo(new Coordenada(6, 5));
		s = new Salida();
		tab2[p.getX()][p.getY()] = p;
		tab2[e1.getX()][e1.getY()] = e1;
		tab2[e2.getX()][e2.getY()] = e2;
		tab2[e3.getX()][e3.getY()] = e3;
		tab2[s.getX()][s.getY()] = s;
	}
	
	public Printeable checkPrinteable(int x, int y){
		return tab2[y][x];
	}
	
	/**
	 * 
	 * @param movement
	 * @return 0 cuando no pasa nada, 1 cuando se ha ganado el juego, 2 cuando se ha perdido
	 */
	public int checkMove(String movement){
		int x = p.getX();
		int y = p.getY();
		Coordenada cord = new Coordenada(x, y);
		if(direcciones(cord, movement) == false){
			return 0;
		}
		x = cord.x;
		y = cord.y;
		switch(p.moverPersonaje(tablero.tab, x, y, tab2)){
		case(Tile.DIE):
			return 2;
		case(Tile.WIN):
			return 1;
		default:
			break;
		}
		if(disparar(e1) || disparar(e2) || disparar(e3)){
			return 2;
		}
		return 0;
	}
	
	/**
	 * Método que comprueba si el jugador será disparado por el enemigo pasado por parámetros
	 * @param t
	 * @return True si se ha disparado, False si no se ha disparado
	 */
	public boolean disparar(Enemigo e){
		if(p.getX() == e.getX()){
			if(p.getY()<e.getY()){
				int i = e.getSafeRange();
				if(p.getY()>=i){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean direcciones(Coordenada cord, String movement){
		switch(movement){
		case ("w"):
			cord.y--;
			break;
		case("s"):
			cord.y++;
			break;
		case("a"):
			cord.x--;
			break;
		case("d"):
			cord.x++;
			break;
		default:
			VentanaJuego.println("Movimiento no válido");
			return false;
		}
		return true;
	}
	
	public void printTablero(){
		tablero.printTablero(this);
	}
	
}
