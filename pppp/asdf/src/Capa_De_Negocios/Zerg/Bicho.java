package Capa_De_Negocios.Zerg;

public class Bicho {
	protected int vida;
	protected int ataque;
	protected int vMovimiento;
	
	public Bicho(int vida, int ataque, int vMovimiento) {
		super();
		this.vida = vida;
		this.ataque = ataque;
		this.vMovimiento = vMovimiento;
	}

	//Constructor vacio
	public Bicho() {
		super();
	}

	//Getters y Setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getvMovimiento() {
		return vMovimiento;
	}

	void setvMovimiento(int vMovimiento) {
		this.vMovimiento = vMovimiento;
	}

	//Main de prueba
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
