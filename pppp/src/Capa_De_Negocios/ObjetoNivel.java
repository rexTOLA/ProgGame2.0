package Capa_De_Negocios;

import java.util.ArrayList;

public class ObjetoNivel {

	String code;
	String name;
	ArrayList<ObjetoClase> clases;
	
	public ObjetoNivel(String code, String name, ArrayList<ObjetoClase> clases){
		this.code = code;
		this.name = name;
		this.clases = clases;
	}

}
