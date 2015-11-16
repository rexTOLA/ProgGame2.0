package Capa_de_Datos;

public class AccesosBD {
	
//Inicio de sesi�n
	
	/**
	 * M�todo que registra un nuevo usuario en la BD
	 * @param nombre Nombre del usuario
	 * @param pass Contrase�a del usuario
	 * @return c�digo que el usuario tiene asignado en la BD
	 */
	public int reg(String nombre, String pass);
	
	/**
	 * M�todo que comprueba si lo datos introducidos corresponden a alg�n usuario de la BD
	 * @param nombre Nombre del usuario
	 * @param pass Contrase�a del usuario
	 * @return c�digo que el usuario tiene asignado en la BD
	 */
	public int log(String nombre, String pass);
	
//Juego

	/**
	 * M�todo que devuelve un objeto Nivel con la informaci�n del nivel pedido por par�metros y con la informaci�n espec�fica del usuario indicado
	 * @param Cod_u C�digo del usuario que desdea resolver el nivel
	 * @param paquete Paquete de ejercicios al que pertenece el nivel
	 * @param nombre Nombre del nivel
	 * @return Objeto Nivel con la informaci�n del ejercicio
	 */
	public Nivel getNivel(int Cod_u, String paquete, String nombre);
	
	/**
	 * Devuelve el c�digo asignado en la BD al paquete indicado por par�mteros
	 * @param paquete Nombre del paquete en cuesti�n
	 * @return C�digo del paquete
	 */
	private int traductorPaquete(String paquete);
	
	/**
	 * Devuelve el c�digo asignado en la BD al nivel indicado por par�mteros
	 * @param nivel Nombre del nivel
	 * @return C�dgio del nivel
	 */
	private int traductorNivel(String nivel);

	/**
	 * Crea un objeto Nivel con la informaci�n del nivel referenciado por par�metros que saca de la BD
	 * @param paquete C�digo del paquete
	 * @param nivel C�digo del nivel
	 * @return Objeto Nivel
	 */
	private Nivel crearNivel(int paquete, int nivel);
	
	/**
	 * Guarda un ejercicio en el ordenador del usuario con las modificaciones que ha hecho respecto al original
	 * @param Cod_u C�digo del usuario que ha realizado el ejericio
	 * @param tiempo Tiempo en el que lo a realizado (si ha sido completado con �xito, si no 0:00)
	 * @param Cod_n C�digo del nivel resuelto
	 * @return True si se ha guardado con �xito, Falso en caso contrario
	 */
	public boolean guardarEjercicio(int Cod_u, int tiempo, int Cod_n);
	
	/**
	 * Introduce a un usuario en una posici�n del ranking dependiendo de c�mo de bien ha resuelto el ejercicio
	 * @param tiempo El par�mtero sobre el que se evalua el ejercicio
	 * @param Cod_n Nivel resuelto
	 * @param Cod_u Usuairo que lo ha resuelto
	 * @return True si se ha podidio guardar, False en caso contrario
	 */
	private boolean ranking(int tiempo, int Cod_n, int Cod_u);
	
	/**
	 * Devuelve un ArrayList con los nombres de los niveles que haya en el paquete dado en los par�mteros y con la informaci�n referente al usuario de cada uno
	 * @param paquete Nombre del paquete
	 * @param Cod_u C�digo del usuario que desdea ver los niveles disponibles
	 * @return ArrayList<String> con los nombres de los niveles, en los nombres estar� el numero del nivel + el nombre
	 */
	public ArrayList<String> mostrarNiveles(String paquete, int Cod_u);
}