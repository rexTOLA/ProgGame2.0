package Ej_Walls;

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
			System.out.println("Movimiento no v�lido");
		}
		return true;
	}
	
}
