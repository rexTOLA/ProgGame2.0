//No Editable
package Ej_Deslizar;

public class Personaje extends ObjetoJuego{
	 
	int actualX;
	int actualY;
	int previousX;
	int previousY;

	public Personaje() {
		super('0');
		previousX = actualX = 2;
		previousY = actualY = 8;
	}

	public void moveRight(){
		actualX++;
	}
	
	public void moveLeft(){
		actualX--;
	}
	
	public void moveUp(){
		actualY--;
	}
	
	public void moveDown(){
		actualY++;
	}
	
	public void move(){
		previousX = actualX;
		previousY = actualY;
	}
	
	public void notMove(){
		actualX = previousX;
		actualY = previousY;
	}
	
}
