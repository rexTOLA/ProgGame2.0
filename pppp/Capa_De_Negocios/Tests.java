package Capa_De_Negocios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Ej_Deslizar.Ej_Deslizar;
import Ej_Walls.Ej_Walls;

public class Tests {
	
    public static void principal(String cod_nivel) {
    	switch(cod_nivel){
    	case("N1"):
    		//Ejercicio deslizar
        	try {
    			if(ejercicioDeslizar()){
    				//ejercicio superado 
    				
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	break;
    	case("N2"):
    		//Ejercicio deslizar
        	try {
    			if(ejercicioWalls()){
    				//ejercicio superado 
    				
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	break;
    	}
    	//guardar en la BD que el usuario en cuestion a superado el nivel
		//mostrar al usuairo que ha superado el ejercicio
    }
	

    /**
	 * método para ejecutar el ejercicio deslizar
	 * @return
	 * @throws IOException
	 */
    public static boolean ejercicioDeslizar() throws IOException{
    	System.out.print("Move your character(0) to get to the exit (*). To move, type: Up: u; Down: d; Left: l; Right: r. And be carefull with the ice, you'll slide!!\n");
    	Ej_Deslizar ed = new Ej_Deslizar();
    	String s;
    	do{
    		ed.printTablero();
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		s = br.readLine();
    	}
		while(!ed.move(s));	
    	
    	System.out.println("Congratulations!!! You won!!!");
    	return true;
    }
    
    public static boolean ejercicioWalls() throws IOException{
		System.out.print("Mueve al personaje(8) para llegar a la salida(O). Para moverte usa wasd.\n");
    	Ej_Walls ew = new Ej_Walls();
    	String s;
    	do{
    		ew.printTablero();
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		s = br.readLine();
    	}
		while(!ew.checkMove(s));	
    	
    	System.out.println("¡¡¡Enhorabuena!!! ¡¡¡Has ganado!!!");
    	return true;
    }
    
    
    
}
