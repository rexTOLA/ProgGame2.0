package Capa_De_Negocios;

import java.util.ArrayList;

public class ObjetoNivel {

	public String code;
	public String name;
	public ArrayList<ObjetoClase> clases;
	
	public ObjetoNivel(String code, String name, ArrayList<ObjetoClase> clases){
		this.code = code;
		this.name = name;
		this.clases = clases;
	}

}
