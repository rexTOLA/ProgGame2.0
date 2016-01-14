package Ej_Walls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
						System.out.print(p);
					}
					else{
						System.out.print(tablero[i][j]);
					}
				}
				System.out.println();
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
	
	public static void main (String args[]) throws IOException{
		System.out.print("Move your character(8) to get to the exit (O). To move use wasd.\n");
    	Ej_Walls ew = new Ej_Walls();
    	String s;
    	do{
    		ew.printTablero();
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		s = br.readLine();
    	}
		while(!ew.checkMove(s));	
    	
    	System.out.println("Congratulations!!! You won!!!");
//    	return true;
	}

}