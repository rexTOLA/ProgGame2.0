//No Editable
package Ej_Deslizar;

import Capa_de_Presentacion.VentanaJuego;

public class Ej_Deslizar {
	 
	Tile ph = new Pared ('M');
	Tile pv = new Pared ('|');
	Tile pe = new Pared (' ');
	Tile h = new Hielo();
	Tile h2 = new Hielo2();
	Tile s = new Salida();
	
	Tile tablero [][] = {{pe, ph, ph, ph, ph, ph, s, ph, ph, pe},
						{pv, h, h, h, h, h, h, h, h, pv},  //1
						{pv, h, h, h, h, h, h, h, h, pv},  //2
						{pv, h, h2, h, h, h, h, h, h, pv}, //3
						{pv, h, h, h, h, h, h, h2, h, pv}, //4
						{pv, h, h, h, h, h, h, h, h, pv},  //5
						{pv, h, h, h2, h, h, h, h, h, pv}, //6
						{pv, h, h, h, h, h, h, h, h, pv},  //7
						{pv, h, h, h, h, h, h2, h, h, pv}, //8
						{pe, ph, ph, ph, ph, ph, ph, ph, ph, pe}};

	Personaje p = new Personaje();
	
	public void printTablero(){
		
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++){
				if (i == p.actualY && j == p.actualX){
					VentanaJuego.print(p.toString());
				}
				else{
					VentanaJuego.print(tablero[i][j].toString());
				}
			}
			VentanaJuego.println("");
		}
	}
	public boolean move(String movement){
		switch(movement){
		case ("w"):
			p.moveUp();
			break;
		case("s"):
			p.moveDown();
			break;
		case("a"):
			p.moveLeft();
			break;
		case("d"):
			p.moveRight();
			break;
		default:
			VentanaJuego.println("Invalid movement character, try again");
			return false;
		}
		int x = p.actualX;
		int y = p.actualY;
		
		if(tablero[y][x].stop_slide()==Tile.SLIDE){
			p.move();
			if(move(movement)){
				return true;
			}
			return false;
		}
		else if(tablero[y][x].stop_slide()==Tile.STOP){
			p.notMove();
			return false;
		}
		else if(tablero[y][x].stop_slide()==Tile.WIN){
			return true;
		}
		else{
			VentanaJuego.println("An unkonwn error has occurred. Try to move again.");
			return false;
		}
	}

}
