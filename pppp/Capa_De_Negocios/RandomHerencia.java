package Capa_De_Negocios;

/**
 * Esta es la clase que va a sacar random el enunciado del ejercicio de erencia que se va amostrar en la ventana
 * es un simple random que de 3 opciones que seleccionara el enemigo al que debes enfrentarte
 * y te dira que debes hacer para hacerle contra
 * @author artop_000
 *
 */
public class RandomHerencia {
	//Pagina web para mirar los counters 
	// http://vaughnroyko.com/sciicounters/
	//Hay que meterla en la ventana final
	public static void enemigo (){
		double a = Math.random();
		if(a>=0 && a<=0.33){
			System.out.println("Tu enemigo es un Protoss");
			System.out.println("Tiene 2 Sentries y 5 Stalkers");
			System.out.println("¿Que vas a hacer?");
			
			
		}
		else if(a>0.33 && a<=0.66){
			//Tu enemigo es Zerg
			System.out.println("Tu enemigo es un Zerg");
			System.out.println("Tiene 5 Mutas y 3 Baneling");
			System.out.println("¿Que vas a hacer?");
		}
		else if(a>0.66 && a<=1){
			//Tu enemigo es Terran
			System.out.println("Tu enemigo es un Terran");
			System.out.println("Tiene 5 Marines y 2 Marauders");
			System.out.println("¿que vas a hacer?");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enemigo();
	}

}
