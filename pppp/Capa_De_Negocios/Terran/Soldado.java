package Capa_De_Negocios.Terran;

public class Soldado {
	protected int vida;
	protected int armadura;
	protected int ataque;
	protected int vMovimiento;
	
	
	public Soldado(int vida, int armadura, int ataque, int vMovimiento) {
		super();
		this.vida = vida;
		this.armadura = armadura;
		this.ataque = ataque;
		this.vMovimiento = vMovimiento;
	}

	//Constructor vacio
	public Soldado() {
		super();
	}
	
	//Getters y Setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
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

	public void setvMovimiento(int vMovimiento) {
		this.vMovimiento = vMovimiento;
	}

	//Main de prueba
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
