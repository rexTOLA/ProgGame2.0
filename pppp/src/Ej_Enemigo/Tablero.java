//Editable
package Ej_Enemigo;

import Capa_de_Presentacion.VentanaJuego;

public class Tablero {
	
	Tile h;
	Tile f;
	Tile tab[][];
	
	public Tablero(){
		h = new Hole ('O');
		f = new Tile(' ');
		
		Tile tabl[][] = {{h, h, h, h, h, h, h, h, h},
						{h, f, f, f, f, f, f, f, h}, //1
						{h, f, f, f, f, f, f, f, h}, //2
						{h, f, f, f, f, f, f, f, h}, //3
						{h, f, f, f, f, f, f, f, h}, //4
						{h, f, f, f, f, f, f, f, h}, //5
						{h, f, f, f, f, f, f, f, h}, //6
						{h, f, f, f, f, f, f, f, h}, //7
						{h, h, h, h, h, h, h, h, h}};
		tab = tabl;
	}
	
	public void printTablero(Ej_Enemigo ej){
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				Printeable print = ej.checkPrinteable(i, j);
				if (print!=null){
					VentanaJuego.print(print.toString());
				}
				else{
					VentanaJuego.print(tab[i][j].toString());
				}
			}
			VentanaJuego.println("");
		}
	}
}
