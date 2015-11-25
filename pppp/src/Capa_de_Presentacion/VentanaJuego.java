package Capa_de_Presentacion;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** Cierra la ventana de consola.
	 */
	static public void finish() {
		
	}
	/** Lee una línea desde la línea de entrada de la ventana
	 * @return	Línea leída
	 */
	static public String leerLinea() {
		
	}
	/** Escribe en la ventana una línea
	 * @param s	String a visualizar en la ventana
	 */
	static public void println( String s ) {
		
	}
	/** Comprueba si el ejercicio está bien
	 */
	static public void check() {
		
	}
	/** crea un nivel nuevo y vacío
	 */
	static public void crear_Nivel() {
		
	}
	/** crea una clase nueva nueva en blanco
	 */
	static public void crear_Clase() {
		
	}
	/** Imprime por consola una lista de los comandos accesibles
	 */
	static public void help() {
		
	}
	/** Imprime por consola todos los comandos relacionados por la palabra clave
	 * @param String key palabra clave a buscar
	 */
	static public void help(String key) {
		
	}
	/** busca en el directorio marcado todas las carpetas y ficheros que hay y los muestra por pantalla
	 * @param String dir dirección que se introduce
	 */
	static public void search(String dir) {
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JEditorPane editorPane = new JEditorPane();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
