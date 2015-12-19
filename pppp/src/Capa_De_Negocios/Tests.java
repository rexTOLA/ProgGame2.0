package src.Capa_De_Negocios;

import Capa_De_Negocios.ej_Deslizar.Ej_Deslizar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tests {
<<<<<<< HEAD
	 
	
    public static void main(String[] args) {
    	//Ejercicio deslizar
    	try {
			if(ejercicioDeslizar()){
				//ejercicio superado
			}
			else{
				//ejercicio no superado
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	

    public static boolean ejercicioDeslizar() throws IOException{
    	System.out.print("Move your character(X) to get to the exit (*). To move, type: Up: u; Down: d; Left: l; Right: r. And be carefull with the ice, you'll slide!!\n");
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
    
=======
	
	
    public static void main(String[] args) throws IOException { 
    	System.out.print("Move your character(X) to get to the exit (*). To move, type: Up: u; Down: d; Left: l; Right: r. And be carefull with the ice, you'll slide!!\n");
    	Ej_Deslizar ed = new Ej_Deslizar();
    	String s;
    	do{
    		ed.printTablero();
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		s = br.readLine();
    	}
		while(!ed.move(s));	
    	
    	System.out.println("Congratulations!!! You won!!!");
    }
	

>>>>>>> branch 'master' of https://github.com/rexTOLA/ProgGame2.0.git
}
