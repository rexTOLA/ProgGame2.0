package Capa_De_Negocios;

import java.util.ArrayList;

public class ObjetoNivel {

	String name;
	String code;
	ArrayList<ObjetoClase> clases;
	
	public ObjetoNivel(String name, String code, ArrayList<ObjetoClase> clases){
		this.name = name;
		this.code = code;
		this.clases = clases;
	}

}
