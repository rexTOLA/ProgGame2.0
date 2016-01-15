package Ej_Enemigos;

public class Tablero {
	
	Tile ph;
	Tile pv;
	Tile pe;
	Tile s;
	Tile f;
	Tile e1;
	Tile e2;
	Tile e3;
	Tile tab[][];
	
	public Tablero(){
		ph = new Pared ('-');
		pv = new Pared ('|');
		pe = new Pared (' ');
		s = new Salida();
		f = new Tile(' ');
		e1 = new Enemigo(new Coordenada(2, 7));
		e2 = new Enemigo(new Coordenada(4, 6));
		e3 = new Enemigo(new Coordenada(6, 5));
		Tile tabl[][] = {{pe, ph, ph, ph, ph, ph, ph, ph, pe},
						{pv, f, f, f, f, f, f, f, pv}, //1
						{pv, f, f, f, f, f, f, f, pv}, //2
						{pv, f, f, f, f, f, f, s, pv}, //3
						{pv, f, f, f, f, f, f, f, pv}, //4
						{pv, f, f, f, f, f, e3, f, pv}, //5
						{pv, f, f, f, e2, f, f, f, pv}, //6
						{pv, f, e1, f, f, f, f, f, pv}, //7
						{pe, ph, ph, ph, ph, ph, ph, ph, pe}};
		tab = tabl;

	}
	
	public void printTablero(Personaje p){
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				if (i == p.getY() && j == p.getX()){
					System.out.print(p);
				}
				else{
					System.out.print(tab[i][j]);
				}
			}
			System.out.println();
		}
	}
}
