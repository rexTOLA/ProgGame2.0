package Capa_de_Datos;

public class AccesosBD {
	
//Inicio de sesión
	
	/**
	 * Método que registra un nuevo usuario en la BD
	 * @param nombre Nombre del usuario
	 * @param pass Contraseña del usuario
	 * @return código que el usuario tiene asignado en la BD
	 */
	public int reg(String nombre, String pass);
	
	/**
	 * Método que comprueba si lo datos introducidos corresponden a algún usuario de la BD
	 * @param nombre Nombre del usuario
	 * @param pass Contraseña del usuario
	 * @return código que el usuario tiene asignado en la BD
	 */
	public int log(String nombre, String pass);
	
//Juego

	/**
	 * Método que devuelve un objeto Nivel con la información del nivel pedido por parámetros y con la información específica del usuario indicado
	 * @param Cod_u Código del usuario que desdea resolver el nivel
	 * @param paquete Paquete de ejercicios al que pertenece el nivel
	 * @param nombre Nombre del nivel
	 * @return Objeto Nivel con la información del ejercicio
	 */
	public Nivel getNivel(int Cod_u, String paquete, String nombre);
	
	/**
	 * Devuelve el código asignado en la BD al paquete indicado por parámteros
	 * @param paquete Nombre del paquete en cuestión
	 * @return Código del paquete
	 */
	private int traductorPaquete(String paquete);
	
	/**
	 * Devuelve el código asignado en la BD al nivel indicado por parámteros
	 * @param nivel Nombre del nivel
	 * @return Códgio del nivel
	 */
	private int traductorNivel(String nivel);

	/**
	 * Crea un objeto Nivel con la información del nivel referenciado por parámetros que saca de la BD
	 * @param paquete Código del paquete
	 * @param nivel Código del nivel
	 * @return Objeto Nivel
	 */
	private Nivel crearNivel(int paquete, int nivel);
	
	/**
	 * Guarda un ejercicio en el ordenador del usuario con las modificaciones que ha hecho respecto al original
	 * @param Cod_u Código del usuario que ha realizado el ejericio
	 * @param tiempo Tiempo en el que lo a realizado (si ha sido completado con éxito, si no 0:00)
	 * @param Cod_n Código del nivel resuelto
	 * @return True si se ha guardado con éxito, Falso en caso contrario
	 */
	public boolean guardarEjercicio(int Cod_u, int tiempo, int Cod_n);
	
	/**
	 * Introduce a un usuario en una posición del ranking dependiendo de cómo de bien ha resuelto el ejercicio
	 * @param tiempo El parámtero sobre el que se evalua el ejercicio
	 * @param Cod_n Nivel resuelto
	 * @param Cod_u Usuairo que lo ha resuelto
	 * @return True si se ha podidio guardar, False en caso contrario
	 */
	private boolean ranking(int tiempo, int Cod_n, int Cod_u);
	
	/**
	 * Devuelve un ArrayList con los nombres de los niveles que haya en el paquete dado en los parámteros y con la información referente al usuario de cada uno
	 * @param paquete Nombre del paquete
	 * @param Cod_u Código del usuario que desdea ver los niveles disponibles
	 * @return ArrayList<String> con los nombres de los niveles, en los nombres estará el numero del nivel + el nombre
	 */
	public ArrayList<String> mostrarNiveles(String paquete, int Cod_u);
}