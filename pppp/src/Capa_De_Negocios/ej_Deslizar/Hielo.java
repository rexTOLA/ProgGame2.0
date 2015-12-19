package Capa_De_Negocios.ej_Deslizar;

public class Hielo extends Tile {

	public Hielo() {
		super('H');
	}
	
	public Hielo(Character type){
		super(type);
	}

	@Override
	public int stop_slide() {
		return SLIDE;
	}

}
