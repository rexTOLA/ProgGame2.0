package Capa_de_Datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public static String reg(String nombre, String pass){
		abrirConex();
		String a = "COD_" + nombre;
		String b = "'" + a + "', '" + nombre + "', '" + pass + "'";
		insertRowInto(b, "JUGADORES");
		cerrarConex();
		return a;
	}
	
	/**
	 * Método que comprueba si lo datos introducidos corresponden a algún usuario de la BD
	 * @param nombre Nombre del usuario
	 * @param pass Contraseña del usuario
	 * @return código que el usuario tiene asignado en la BD
	 */
	public static String log(String nombre, String pass){
		abrirConex();
		final String sent1 = "SELECT COD_JUG FROM JUGADORES WHERE USUARIO = '" + nombre + "' AND PASS = '" + pass + "';";
		ResultSet resultado = null;
		try {
			resultado = statement.executeQuery(sent1);
		} catch (SQLException e) {
			System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent1);
			e.printStackTrace();
		}
		String cod_jug = "";
		try {
			resultado.next();
			cod_jug = resultado.getString(1);
		} catch (SQLException e) {
		}
		cerrarConex();
		return cod_jug;
	}
	
//Juego

	/**
	 * Método que devuelve un objetoNivel con la información del nivel pedido por parámetros
	 * @param nom_nivel
	 * @return
	 */
	public static ObjetoNivel getNivel(String nombre){
		abrirConex();
		String nom_nivel = nombre.toUpperCase();
		String cod_nivel = traductorNivel(nom_nivel);
		ObjetoNivel oNivel = crearNivel(cod_nivel, nom_nivel);
		cerrarConex();
		return oNivel;
	}
	
		/**
		 * Devuelve el código asignado en la BD al nivel indicado por parámteros
		 * @param nivel Nombre del nivel
		 * @return Códgio del nivel
		 */
		private static String traductorNivel(String nivel){
			final String sent1 = "SELECT COD_NIVEL FROM NIVELES WHERE NOM_NIVEL = '" + nivel + "';";
			ResultSet resultado = null;
			try {
				resultado = statement.executeQuery(sent1);
			} catch (SQLException e) {
				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent1);
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
         * @param cod_nivel Código del nivel
         * @return
         */
        private static ObjetoNivel crearNivel(String cod_nivel, String nom_nivel){
            final String sent = "SELECT COD_CLASE FROM CLASES WHERE COD_NIVEL = '" + cod_nivel + "';";
            ResultSet resultado = null;
            try {
                resultado = statement.executeQuery(sent);
            } catch (SQLException e) {
                System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent);
                e.printStackTrace();
            }
            ArrayList<ObjetoClase> clasesDeN = new ArrayList<>();
            ArrayList<String> contenido = new ArrayList<>();
            try {
            	while(resultado.next()){
                	contenido.add(resultado.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for(String cod : contenido){
                ObjetoClase oClase = crearClase(cod, nom_nivel);
                clasesDeN.add(oClase);
            }
            nom_nivel = estandarizar(nom_nivel);
            ObjetoNivel oNivel = new ObjetoNivel(cod_nivel, nom_nivel, clasesDeN);
            return oNivel;
        }

		/**
		 * Crea un objeto Clase sacando de la BD la infromación de la clase cuyo código recive por prámetros
		 * @param cod_clase
		 * @return
		 */
		private static ObjetoClase crearClase(String cod_clase, String nom_nivel){
			final String sent = "SELECT * FROM CLASES WHERE COD_CLASE = '" + cod_clase + "';";
			ResultSet resultado = null;
			try {
				resultado = statement.executeQuery(sent);
			} catch (SQLException e) {
				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent);
				e.printStackTrace();
			}
			String nom_clase = "";
			boolean alterable = false;
			String cod_nivel = "";
			try {
				while(resultado.next()){
					nom_clase = resultado.getString(2);
					alterable = resultado.getBoolean(3);
					cod_nivel = resultado.getString(4);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			nom_nivel = estandarizar(nom_nivel);
			nom_clase = estandarizar(nom_clase);
			String ruta = "src/" + nom_nivel + "/" + nom_clase + ".java";
			ObjetoClase oClase = new ObjetoClase(cod_clase, nom_clase, alterable, cod_nivel, ruta);
			return oClase;
		}
		
		private static String estandarizar(String nombre){
			String primLetra = nombre.substring(0, 1);
			String segLetra = nombre.substring(1);
			segLetra = segLetra.toLowerCase();
			nombre = primLetra + segLetra;
			return nombre;
		}
		
		/**
		 * Escribe en un fichero la clase que se le pasa por parámetros
		 * @param nombre
		 * @param clase
		 */
//		private static void escribeFichero(String nombre/*, Class<T> clase*/){
//			//PARA PASAR LA CLASE EN SI??
//			try{
//				FileOutputStream fos = new FileOutputStream(nombre + ".dat");
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
////				oos.writeObject(clase);
//				oos.close();
//			} catch (IOException e){
//				System.out.println("ERROR");
//			}
//		}
		
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
	
	
	public static boolean resueltos(String Nom_nivel, String Cod_jug){
		String Cod_nivel = traductorNivel(Nom_nivel);
		insertRowInto("'" + Cod_nivel + "', '" + Cod_jug + "'", "RESUELTOS");
		return true;
	}
	
	/**
	 * Devuelve un ArrayList con los nombres de los niveles que haya en la BD
	 * @return ArrayList<String> con los nombres de los niveles
	 */
	public static ArrayList<String> mostrarNiveles(){
		abrirConex();
		ArrayList<String> a = viewTableContent("NIVELES");
		cerrarConex();
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
		    			final String sentence = "SELECT * FROM TABLASBD;";
		    			ResultSet resultado = null;
		    			try {
		    				resultado = statement.executeQuery(sentence);
		    			} catch (SQLException e) {
		    				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sentence);
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
		    				ArrayList<String> content = viewTableContent(tableName);
		    				for(String a : content){
		    					System.out.println(a);
		    				}
		    			}
		    		}
		    		else if(s.equals("DEL")){
		    			final String sent = "DELETE FROM RESUELTOS WHERE COD_NIVEL = 'N1';";
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
				insertRowInto("'" + tableName + "'", "TABLASBD");
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
		
		/**
		 * Returns an array with the content of the table specified by parameters
		 * @param tableName
		 * @return
		 */
		private static ArrayList<String> viewTableContent(String tableName){
			ArrayList<String> content = new ArrayList<>();
			final String sent = "SELECT * FROM " + tableName + ";";
			ResultSet resultado = null;
			try {
				resultado = statement.executeQuery(sent);
				resultado.next();
			} catch (SQLException e) {
				System.out.println( "Error al intentar recuperar datos de la BD a través de la sentencia: " + sent);
				e.printStackTrace();
			}
			try {
				do{
					int i = 1;
					try{
						while(true){
							String a = resultado.getString(i);
							content.add(a);
							i++;
						}
					}catch(SQLException e){
						
					}
				}
				while(resultado.next());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return content;
		}
	
	/**
	 * main de la clase usado para la creación de tablas de la base de datos
	 * @param args
	 */
	public static void main(String args[]){
		abrirConex();
//		resueltos("N1", "COD_AINHOA");
		generateTables();
		cerrarConex();
//		ObjetoNivel on = getNivel("Ej_Walls");
	}
}