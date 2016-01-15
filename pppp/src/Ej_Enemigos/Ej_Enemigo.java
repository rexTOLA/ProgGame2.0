package Ej_Enemigos;

public class Ej_Enemigo {

	Tablero tablero = new Tablero();
	Personaje p = new Personaje();
	
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
		if(p.moverPersonaje(tablero.tab, x, y)){
			return 1;
		}
		//disparar
		if(disparar(tablero.e1) || disparar(tablero.e2) || disparar(tablero.e3)){
			return 2;
		}
		return 0;
	}
	
	/**
	 * Método que comprueba si el jugador será disparado por el enemigo pasado por parámetros
	 * @param t
	 * @return True si se ha disparado, False si no se ha disparado
	 */
	public boolean disparar(Tile t){
		Enemigo e = (Enemigo)t;
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
			System.out.println("Movimiento no válido");
			return false;
		}
		return true;
	}
	
	public void printTablero(){
		tablero.printTablero(p);
	}
	
}
