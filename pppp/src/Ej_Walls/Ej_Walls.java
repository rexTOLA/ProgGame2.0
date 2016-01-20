//No Editable
package Ej_Walls;

import Capa_de_Presentacion.VentanaJuego;

public class Ej_Walls {
	
	Tile ph = new Pared ('-');
	Tile pv = new Pared ('|');
	Tile pe = new Pared (' ');
	Tile s = new Salida();
	Tile f = new Tile(' ');
	
	Tile tablero [][] = {{pe, ph, ph, ph, ph, ph, ph, ph, pe},
						{pv, f, f, f, f, f, f, s, pv}, //1
						{pv, ph, f, f, f, f, f, f, pv}, //2
						{pv, f, pv, f, f, f, f, f, pv}, //3
						{pv, ph, f, f, f, f, f, f, pv}, //4
						{pv, f, f, f, f, f, f, f, pv}, //5
						{pe, ph, ph, ph, ph, ph, ph, ph, pe}};
	
	Personaje p = new Personaje();
		
	public void printTablero(){
			
			for(int i = 0; i<7; i++){
				for(int j = 0; j<9; j++){
					if (i == p.getY() && j == p.getX()){
						VentanaJuego.print(p.toString());
					}
					else{
						VentanaJuego.print(tablero[i][j].toString());
					}
				}
				VentanaJuego.println("");
			}
		}
	
	public boolean checkMove(String movement){
		int x = p.getX();
		int y = p.getY();
		Coordenada cord = new Coordenada(x, y);
		if(Mover.direcciones(cord, movement) == false){
			return false;
		}
		x = cord.x;
		y = cord.y;
		return p.moverPersonaje(tablero, x, y);
	}

}