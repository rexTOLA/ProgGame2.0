//Editable
package Ej_Walls;

import Capa_de_Presentacion.VentanaJuego;

public class Mover {

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
			cord.x = cord.x + 2; 
			break;
		default:
			VentanaJuego.println("Movimiento no válido");
		}
		return true;
	}
	
}
