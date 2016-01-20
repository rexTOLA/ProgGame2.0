package Capa_De_Negocios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Capa_de_Presentacion.VentanaJuego;
import Ej_Deslizar.Ej_Deslizar;
import Ej_Enemigo.Ej_Enemigo;
import Ej_Walls.Ej_Walls;

public class Tests {
	
    public static boolean principal(String cod_nivel) {
    	switch(cod_nivel){
    	case("N1"):
    		//Ejercicio deslizar
        	try {
    			if(ejercicioDeslizar()){
    				//ejercicio superado
    				return true;
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
    				return true;
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	break;
    	case("N3"):
    		//Ejercicio deslizar
        	try {
    			if(ejercicioEnemigos()){
    				//ejercicio superado 
    				return true;
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	break;
    	}
    	//guardar en la BD que el usuario en cuestion a superado el nivel
		//mostrar al usuairo que ha superado el ejercicio
    	return false;
    	//Si devuelve true:
//    	AccesosBD.resueltos(cod_nivel, cod_u);
    }
	

    /**
	 * método para ejecutar el ejercicio deslizar
	 * @return
	 * @throws IOException
	 */
    public static boolean ejercicioDeslizar() throws IOException{
    	
    	Ej_Deslizar ed = new Ej_Deslizar();
    	String s;
    	do{
    		ed.printTablero();
    		s=VentanaJuego.readLine();
    		
    	}
		while(!ed.move(s));	
    	
    	VentanaJuego.println("¡¡¡Enhorabuena!!! ¡¡¡Has ganado!!!");
    	return true;
    }
    
    public static boolean ejercicioWalls() throws IOException{
    	
    	Ej_Walls ew = new Ej_Walls();
    	String s;
    	do{
    		ew.printTablero();
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		s = br.readLine();
    	}while(!ew.checkMove(s));	
    	
    	VentanaJuego.println("¡¡¡Enhorabuena!!! ¡¡¡Has ganado!!!");
    	return true;
    }
    
    public static boolean ejercicioEnemigos() throws IOException{
    	
    	Ej_Enemigo en = new Ej_Enemigo();
    	String s;
    	int fin = 0;
    	do{
    		en.printTablero();
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		s = br.readLine();
    		fin = en.checkMove(s);
    	}
		while(fin == 0);	
    	if(fin == 1){
        	VentanaJuego.println("¡¡¡Enhorabuena!!! ¡¡¡Has ganado!!!");
        	return true;
    	}
    	else{
    		VentanaJuego.println("¡Oh, no! ¡Has muerto!");
    		return false;
    	}
    }
    
    public static void main(String args[]){
    	principal("N3");
    }
    
}
