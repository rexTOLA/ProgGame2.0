package Ej_Enemigos;

public class ObjetoJuego {
 
	Character type;
	
	public ObjetoJuego(Character type){
		this.type = type;
	}

	public String toString(){
		return type.toString();
	}
	
}
