package Capa_De_Negocios.ej_Deslizar;

public class Ej_Deslizar {
	
	Tile ph = new Pared ('-');
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
					System.out.print(p);
				}
				else{
					System.out.print(tablero[i][j]);
				}
			}
			System.out.println();
		}
	}
	public boolean move(String movement){
		switch(movement){
		case ("u"):
			p.moveUp();
			break;
		case("d"):
			p.moveDown();
			break;
		case("l"):
			p.moveLeft();
			break;
		case("r"):
			p.moveRight();
			break;
		default:
			System.out.println("Invalid movement character, try again");
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
			System.out.println("An unkonwn error has occurred. Try to move again.");
			return false;
		}
	}
	
}
