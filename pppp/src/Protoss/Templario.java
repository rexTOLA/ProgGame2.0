package Protoss;

public class Templario {
	protected int vida;
	protected int escudo;
	protected int ataque;
	protected int vMovimiento;
	
	
	public Templario(int vida, int escudo, int ataque, int movimiento) {
		super();
		this.vida = vida;
		this.escudo = escudo;
		this.ataque = ataque;
		this.vMovimiento = movimiento;
	}

	//Constructor vacio
	public Templario() {
		super();
	}

	//Getters y Setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMovimiento() {
		return vMovimiento;
	}

	public void setMovimiento(int movimiento) {
		this.vMovimiento = movimiento;
	}

	//Main de prueba
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
