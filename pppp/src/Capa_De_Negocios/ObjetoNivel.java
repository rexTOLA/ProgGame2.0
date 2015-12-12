package Capa_De_Negocios;

import java.util.ArrayList;

public class ObjetoNivel {
/**
 * Preguntar por los paquetes para ordenarlo todo bien
 */
	
	/**
	 * Arraylist de las clases para los niveles
	 */
	ArrayList<ObjetoClase>clases;
	/**
	 * Numero del nivel
	 */
	int numNivel = 0;
	
	/**
	 * Nombre de Nivel
	 */
	String nomNivel;
	
	/**
	 * Nivel completado (True) / Nivel no completado (False)
	 */
	boolean nivelCompletado = false;
	
	/**
	 * Codigo del nivel para la base de datos
	 */
	int cod_n;
	
	/**
	 * Tiempo de la ajecución del nivel.
	 * sirve para el ranking
	 * @param args
	 */
	int tiempoEjec;
	
	/**
	 * Enunciado del nivel
	 * @param args
	 */
	String enunciado;
	
	//Main de prueba de clase
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
