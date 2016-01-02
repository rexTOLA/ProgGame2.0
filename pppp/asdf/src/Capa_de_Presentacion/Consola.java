package Capa_de_Presentacion;



public class Consola {
	protected String opcion;
	protected String option;
	protected String escogernivel;
	protected boolean defo=false;
	protected boolean defo1=false;
	protected boolean back=false;
	protected boolean numnivelerror=false;
	protected String[] niveles={"Nivel1", "Nivel2","Nivel3","Nivel4","Nivel5"};


	public static void main(String[] args) {
		Consola con= new Consola();

	}


	public Consola(){
		back=true;
		do{
			if(back==true){
				VentanaJuego.println("-----MENU-----\nElige Opción: \n1-Jugar\n2-Diseñar\n\nEscriba fin para finalizar\n");
				back=false;
			}	

			opcion = VentanaJuego.readLine();
			switch (opcion) {
			case "fin": VentanaJuego.finish();			
			break;
			case "1": VentanaJuego.println("JUGAR\n"); {
				{VentanaJuego.println("Elige el tipo de nivel que deseas\n1-HERENCIA\n2-INTERFACES\n3-HILOS\n\nPara ir atrás escriba back");
				do{option=VentanaJuego.readLine();

				switch (option) {
				case "1":{ VentanaJuego.println("ESCOGE NIVEL DE HERENCIA: \n");
				for (int i = 0; i < niveles.length; i++) {
					VentanaJuego.println((i+1)+"-"  + niveles[i]);
				}
				do{escogernivel=VentanaJuego.readLine();
				int numniv= Integer.parseInt(escogernivel);
				
				if ((numniv)<=niveles.length && (numniv)>=0){
					VentanaJuego.println("Cargando nivel...");
					VentanaJuego.printEnunciado("Cargando enunciado...");
					numnivelerror=false;
				}else{
					VentanaJuego.println("Número incorrecto, introduce de nuevo el valor: \n");
					numnivelerror=true;
				}}while(numnivelerror==true);


				} defo1=false; back=false;
				break;
				case "2":{ VentanaJuego.println("ESCOGE NIVEL DE INTERFACES: \n");
				for (int i = 0; i < niveles.length; i++) {
					VentanaJuego.println((i+1)+"-" + niveles[i]);
				}

				} defo1=false; back=false;
				break;
				case "3":{ VentanaJuego.println("ESCOGE NIVEL DE HILOS: \n");
				for (int i = 0; i < niveles.length; i++) {
					VentanaJuego.println((i+1)+"-"  + niveles[i]);
				}


				} defo1=false; back=false;
				break;
				case "back":  defo1=false; back=true;
				break;

				default: VentanaJuego.println("Opción o comando no contemplado, introduzca de nuevo: "); defo1=true; back=false;
				break;
				}
				}while(defo1==true );}
			}defo=false;
			break;
			case "2": VentanaJuego.println("DISEÑAR");	defo=false;	
			break;	 
			default: VentanaJuego.println("Opción o comando no contemplado, introduzca de nuevo: \n"); defo=true;
			break;
			}}while(defo==true || back==true);


	}



}
