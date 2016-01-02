package Capa_de_Datos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Capa_De_Negocios.ObjetoClase;
import Capa_De_Negocios.ObjetoNivel;

public class AccesosBD implements Serializable{
	
//Conexión a la Base de Datos
	
		private static Connection connection;
		private static Statement statement;
		private static String nombreBD;
		
		/**
		 * Método para abrir una conexión con la base de datos
		 */
		private static void abrirConex() {
			try {
				connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
				statement = connection.createStatement();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Método para cerrar la conexión con la base de datos
		 */
		private static void cerrarConex() {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
//Inicio de sesión y registro
	
	/**
	 * Método que registra un nuevo usuario en la BD
	 * @param nombre Nombre del usuario
	 * @param pass Contraseña del usuario
	 * @return código que el usuario tiene asignado en la BD
	 */
	public static int reg(String nombre, String pass){
		return 0;
	}
	
	/**
	 * Método que comprueba si lo datos introducidos corresponden a algún usuario de la BD
	 * @param nombre Nombre del usuario
	 * @param pass Contraseña del usuario
	 * @return código que el usuario tiene asignado en la BD
	 */
	public static int log(String nombr1e, String pass){
		return 0;
	}
	
//Juego

	/**
	 * Método que devuelve un objeto Nivel con la información del nivel pedido por parámetros y con la información específica del usuario indicado
	 * @param Cod_u Código del usuario que desdea resolver el nivel
	 * @param nombre Nombre del nivel
	 * @return Objeto Nivel con la información del ejercicio
	 */
//	public static ObjetoNivel getNivel(int Cod_u, String nombre){
//		abrirConex();
//		String cod_nivel = traductorNivel(nombre);
//		ObjetoNivel nivel = crearNivel(cod_nivel);
//		cerrarConex();
//		return nivel;
//	}
	
		/**
		 * Devuelve el código asignado en la BD al nivel indicado por parámteros
		 * @param nivel Nombre del nivel
		 * @return Códgio del nivel
		 */
		private static String traductorNivel(String nivel){
			final String sent = "SELECT COD_NIVEL FROM NIVELES WHERE NOMBRE_NIVEL = " + nivel;
			ResultSet resultado = null;
			try {
				resultado = statement.executeQuery(sent);
			} catch (SQLException e) {
				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent);
				e.printStackTrace();
			}
			String cod_nivel = "";
			try {
				cod_nivel = resultado.getString(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cod_nivel;
		}

		/**
		 * Crea un objeto Nivel con la información del nivel referenciado por parámetros que saca de la BD
		 * @param nivel Código del nivel
		 * @return Objeto Nivel
		 */
//		private static ObjetoNivel crearNivel(String nivel){
//			final String sent = "SELECT COD_CLASE FROM CLASES WHERE COD_NIVEL = " + nivel;
//			ResultSet resultado = null;
//			try {
//				resultado = statement.executeQuery(sent);
//			} catch (SQLException e) {
//				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent);
//				e.printStackTrace();
//			}
//			ObjetoNivel oNivel = new ObjetoNivel();
//			try {
//				for(int i = 0; i<resultado.getFetchSize(); i++){
//					ObjetoClase oClase = crearClase(resultado.getString(i));
//					//Cuando se añada el parámetro del ArrayList al objetoNivel, guardar en él
//					//la clase que se cree en cada iteración
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}			
//			return oNivel;
//		}

		/**
		 * Crea un objeto Clase sacando de la BD la infromación de la clase cuyo código recive por prámetros
		 * @param nivel Código de la Clase
		 * @return Objeto Clase
		 */
//		private static ObjetoClase crearClase(String clase){
//			final String sent = "SELECT CONTENIDO FROM CLASE WHERE COD_CLASE = " + clase;
//			ResultSet resultado = null;
//			try {
//				resultado = statement.executeQuery(sent);
//			} catch (SQLException e) {
//				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent);
//				e.printStackTrace();
//			}
//			//Cuando se decida cómo pasar la clase, cambiar también la llamada
////			escribeFichero(clase, resultado.getString(1));
//			//Al crear el objeto, pasar los parámetros necesarios			
//			ObjetoClase oClase = new ObjetoClase();
//			return oClase;
//		}
		
		/**
		 * Escribe en un fichero la clase que se le pasa por parámetros
		 * @param nombre
		 * @param clase
		 */
		private static void escribeFichero(String nombre/*, Class<T> clase*/){
			//PARA PASAR LA CLASE EN SI??
			try{
				FileOutputStream fos = new FileOutputStream(nombre + ".dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
//				oos.writeObject(clase);
				oos.close();
			} catch (IOException e){
				System.out.println("ERROR");
			}
		}
		
		/**
		 * Lee la clase guardad en el fichero cuyo nombre recive por parámetros
		 * @param nombre
		 * @return
		 */
//		private static ObjetoClase leerFichero(String nombre){
//			ObjetoClase clase = new ObjetoClase();
//			try{
//				FileInputStream fis = new FileInputStream(nombre + ".dat");
//				ObjectInputStream ois = new ObjectInputStream(fis);
//				clase = (ObjetoClase) ois.readObject();
//				ois.close();
//			} catch (Exception e){
//				System.out.println("ERROR");
//			}
//			return clase;
//		}
	
	/**
	 * Guarda un ejercicio en el ordenador del usuario con las modificaciones que ha hecho respecto al original
	 * @param Cod_u Código del usuario que ha realizado el ejericio
	 * @param tiempo Tiempo en el que lo a realizado (si ha sido completado con éxito, si no 0:00)
	 * @param Cod_n Código del nivel resuelto
	 * @return True si se ha guardado con éxito, Falso en caso contrario
	 */
	public static boolean guardarEjercicio(int Cod_u, int tiempo, int Cod_n){
		return false;
	}
	
		/**
		 * Introduce a un usuario en una posición del ranking dependiendo de cómo de bien ha resuelto el ejercicio
		 * @param tiempo El parámtero sobre el que se evalua el ejercicio
		 * @param Cod_n Nivel resuelto
		 * @param Cod_u Usuairo que lo ha resuelto
		 * @return True si se ha podidio guardar, False en caso contrario
		 */
		private static boolean ranking(int tiempo, int Cod_n, int Cod_u){
			return false;
		}
	
	/**
	 * Devuelve un ArrayList con los nombres de los niveles que haya en el paquete dado en los parámteros y con la información referente al usuario de cada uno
	 * @param paquete Nombre del paquete
	 * @param Cod_u Código del usuario que desdea ver los niveles disponibles
	 * @return ArrayList<String> con los nombres de los niveles, en los nombres estará el numero del nivel + el nombre
	 */
	public static ArrayList<String> mostrarNiveles(String paquete, int Cod_u){
		ArrayList<String> a = new ArrayList<>();
		return a;
	}
	
		/**
		 * Método para crear y rellenar tablas
		 */
		private static void generateTables(){
			String s = "";
			try{
				do{
					System.out.println("EXIT: end program; NEW: create new table; INTO: insert data into an existing table"
							+ "; VIEW: check the content of a table");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					s = br.readLine();
		    		if(s.equals("NEW")){
		    			System.out.println("Table name:");
		    			br = new BufferedReader(new InputStreamReader(System.in));
		        		String tableName = br.readLine();
		        		System.out.println("Row information:");
		        		br = new BufferedReader(new InputStreamReader(System.in));
		        		String rowInfo = br.readLine();
		        		createTable(tableName, rowInfo);
		    		}
		    		else if(s.equals("INTO") || s.equals("VIEW")){
		    			final String sent = "SELECT * FROM TABLES;";
		    			ResultSet resultado = null;
		    			try {
		    				resultado = statement.executeQuery(sent);
		    			} catch (SQLException e) {
		    				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent);
		    				e.printStackTrace();
		    			}
		    			System.out.println("Choose a table:");
		    			try {
		    				resultado.next();
							do{
								System.out.println(resultado.getString(1));
							}
		    				while(resultado.next());
						} catch (SQLException e) {
							System.out.println("Error when trying next");
							e.printStackTrace();
						}
		    			br = new BufferedReader(new InputStreamReader(System.in));
		        		String tableName = br.readLine();
		    			if(s.equals("INTO")){
		    				
			        		System.out.println("Write the data you want to insert");
			        		br = new BufferedReader(new InputStreamReader(System.in));
			        		String row = br.readLine();
			        		insertRowInto(row, tableName);
		    			}
		    			else{
		    				viewTableContent(tableName);
		    			}
		    		}
		    		else if(s.equals("DEL")){
		    			final String sent = "DELETE FROM TABLES WHERE TABLE_NAME = 'NIVELES'";
		    			try {
		    				statement.executeUpdate(sent);
		    				System.out.println("Data deleted");
		    			} catch (SQLException e) {
		    				System.out.println("An error has occurred during the deletion");
		    				e.printStackTrace();
		    			}
		    		}
				}
				while(!s.equals("EXIT"));
			} catch (IOException e) {
				System.out.println("Error while reading the input");
				e.printStackTrace();
			}
		}
		
		/**
		 * Método para crear tablas
		 * @param tableName
		 * @param rowInfo
		 */
		private static void createTable(String tableName, String rowInfo){
			final String sent = "CREATE TABLE " + tableName + " (" + rowInfo + ");";
			try {
				statement.executeUpdate(sent);
				insertRowInto("'" + tableName + "'", "TABLES");
				System.out.println("Table created");
			} catch (SQLException e) {
				System.out.println("An error has occurred during the table creation");
				e.printStackTrace();
			}
		}
		
		/**
		 * Método para rellenar tablas
		 * @param row
		 * @param tableName
		 */
		private static void insertRowInto(String row, String tableName){
			final String sent = "INSERT INTO " + tableName + " VALUES (" + row + ");";
			try {
				statement.executeUpdate(sent);
				System.out.println("Data inserted");
			} catch (SQLException e) {
				System.out.println("An error has occurred during the data insertion");
				e.printStackTrace();
			}
		}
		
		private static void viewTableContent(String tableName){
			final String sent = "SELECT * FROM " + tableName + ";";
			ResultSet resultado = null;
			try {
				resultado = statement.executeQuery(sent);
			} catch (SQLException e) {
				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent);
				e.printStackTrace();
			}
			try {
				resultado.next();
				do{
					System.out.println(resultado.getString(1));
				}
				while(resultado.next());
			} catch (SQLException e) {
				System.out.println("Error when trying next");
				e.printStackTrace();
			}
		}
	
	/**
	 * main de la clase usado para la creación de tablas de la base de datos
	 * @param args
	 */
	public static void main(String args[]){
		abrirConex();
		generateTables();
		cerrarConex();
	}
}