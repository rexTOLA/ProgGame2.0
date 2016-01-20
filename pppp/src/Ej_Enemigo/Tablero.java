//Editable
package Ej_Enemigo;

import Capa_de_Presentacion.VentanaJuego;

public class Tablero {
	
	Tile h;
	Tile hv;
	Tile f;
	Tile tab[][];
	
	public Tablero(){
		h = new Hole ('-');
		hv = new Hole ('|');
		f = new Tile(' ');
		
		Tile tabl[][] = {{h, h, h, h, h, h, h, h, h},
						{hv, f, f, f, f, f, f, f, hv}, //1
						{hv, f, f, f, f, f, f, f, hv}, //2
						{hv, f, f, f, f, f, f, f, hv}, //3
						{hv, f, f, f, f, f, f, f, hv}, //4
						{hv, f, f, f, f, f, f, f, hv}, //5
						{hv, f, f, f, f, f, f, f, hv}, //6
						{hv, f, f, f, f, f, f, f, hv}, //7
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
