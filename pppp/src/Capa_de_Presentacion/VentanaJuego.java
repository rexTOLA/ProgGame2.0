package Capa_de_Presentacion;


import java.awt.GridLayout;

import java.awt.Toolkit;
import java.awt.event.*;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.DefaultCaret;
import javax.swing.tree.DefaultMutableTreeNode;

import Capa_De_Negocios.ObjetoClase;
import Capa_De_Negocios.ObjetoNivel;
import Capa_De_Negocios.Tests;
import Capa_de_Datos.AccesosBD;
import Ej_Deslizar.Hielo2;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaJuego extends JFrame {
	protected static VentanaJuego miVentana= null;
	private boolean lineaLeida = false;
	protected JPanel contentPane;
	protected static JPanel panel;
	protected static JTree tree;
	protected static JTextArea textArea = new JTextArea();
	protected static JScrollPane scrollPane = new JScrollPane(textArea);
	protected JTextField tfLineaEntrada = new JTextField();
	protected JTextArea taEnunciado = new JTextArea();
	protected JScrollPane spEnunciado = new JScrollPane(taEnunciado);
	protected JTextArea taSalida = new JTextArea();
	protected JScrollPane spSalida = new JScrollPane(taSalida);

	protected static DefaultMutableTreeNode selectedNode;
	public static String nom_nivel;
	protected static JTabbedPane tabbedPane;
	protected static boolean editable=false;
	protected static ObjetoClase obEditable;
	protected static String ruta;
	protected static ArrayList<String> pestañas=new ArrayList<>();
	protected static Thread hiloJueg;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		try{
			UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
		}catch(Exception e){}

		VentanaJuego.init();

	}

	/**
	 * Create the frame.
	 */
	public VentanaJuego() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/Capa_de_Presentacion/logo64x64.png")));
		setTitle("ProgGaming");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		panel= new JPanel();
		tfLineaEntrada = new JTextField();
		JLabel jLabelImagen=new JLabel();
		jLabelImagen.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelImagen.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Capa_de_Presentacion/logo240x240.png")));



		JButton btnCheck = new JButton("PLAY");
		btnCheck.addActionListener(new ActionListener(){


			public void actionPerformed(ActionEvent e) {
				try {
					escribeFichero();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				//				try {
				//					if(hiloJueg.isAlive()){
				//					
				//					}
				//				} catch (Exception e2) {
				//					// TODO: handle exception
				//				}
//				ClassLoader classLoader = VentanaJuego.class.getClassLoader();
//				try {
//					Class aClass = classLoader.loadClass("/Ej_Deslizar/Hielo2.java");
//					
//				} catch (ClassNotFoundException e1) {
//					e1.printStackTrace();
//				}

				
					hiloJueg = new Thread( new hiloJuego());
					hiloJueg.start();
				

			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCheck, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(spSalida, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
												.addComponent(spEnunciado, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
												.addComponent(tfLineaEntrada, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(spEnunciado, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spSalida, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
										.addComponent(tfLineaEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnCheck)
						.addGap(8))
				);

		tabbedPane = new JTabbedPane();
		tabbedPane.add("ProgGaming", jLabelImagen);
		taEnunciado.setEditable(false);
		//tabbedPane.addTab("Class", null, scrollPane, null);

		//Add the tabbed pane to this panel.
		panel.setLayout(new GridLayout(1, 1)); 
		panel.add(tabbedPane);
		taSalida.setForeground(Color.WHITE);
		taSalida.setBackground(Color.BLACK);


		taSalida.setEditable(false);
		contentPane.setLayout(gl_contentPane);
		// Política de visualización de caret -cursor en textarea-
		DefaultCaret caret = (DefaultCaret) taSalida.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);       
		// Escuchadores
		tfLineaEntrada.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lineaLeida = true;
			}
		});

	}

	public static void crearTree(String nom_nivel){

		nom_nivel=nom_nivel.toUpperCase();

		if(AccesosBD.mostrarNiveles().contains(nom_nivel)){
			tabbedPane.remove(0);
			switch (nom_nivel) {
			case "EJ_DESLIZAR":{VentanaJuego.printEnunciado("Mueve al personaje(0) para llegar a la salida(*).\n Para moverte usa wasd. Y cuidado con el hielo,\n ¡resvala!\n"
					+ "La clase que puedes modificar es Hielo2");
			}
				break;
			case "EJ_ENEMIGO":{
				VentanaJuego.printEnunciado("Mueve al personaje(p) para llegar a la salida($).\n Para moverte usa wasd.\n Atento a los agujeros, no vaya a ser que te caigas.\n"
						+ " Y cuidado con los enemigos, si te ven, ¡te dispararán!\nLa clase que puedes modificar es Tablero");
				break;
			}case "EJ_WALLS":{
				VentanaJuego.printEnunciado("Mueve al personaje(8) para llegar a la salida(O).\n Para moverte usa wasd, si puedes...\nLa clase que puedes modificar es Mover");
				break;
			}

			default:
				break;
			}

			ObjetoNivel nivel=AccesosBD.getNivel(nom_nivel);
			final ArrayList<ObjetoClase> clasearray= nivel.clases;

			DefaultMutableTreeNode root = new DefaultMutableTreeNode(nivel.name);
			for(ObjetoClase ob: clasearray){
				root.add(new DefaultMutableTreeNode(ob.name));
				if(ob.alter){
					obEditable=ob;
				}

			}			

			tree = new JTree(root);
			tree.setShowsRootHandles(true);
			tree.setRootVisible(true);

			tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
				@Override
				public void valueChanged(TreeSelectionEvent e) {
					selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					String s=tree.getLastSelectedPathComponent().toString();

					for (int i = 0; i < clasearray.size(); i++) {
						if(clasearray.get(i).name.equals(s)){
							ruta=clasearray.get(i).ruta;
							editable=clasearray.get(i).alter;

						}
					}

					textArea=new JTextArea();
					scrollPane=new JScrollPane(textArea);


					if(obEditable.name.equals(s)){
						textArea.setEditable(obEditable.alter);
					}else {
						textArea.setEditable(false);
					}

					String algo="";
					try {
						algo=muestraContenido();
					} catch (IOException e1) {

						e1.printStackTrace();
					}



					int j=0;
					for (int i = 0; i < pestañas.size(); i++) {
						if(pestañas.contains(s)){
							j=i;
						}
					}
					if(!pestañas.contains(s)){
						pestañas.add(s);
						textArea.setText(algo);
						tabbedPane.addTab(s,null,scrollPane,null);
					}


				}
			});

			tabbedPane.addTab("Class Folder",null,tree,null);


		}else{
			VentanaJuego.println("Nombre del nivel incorrecto\n");
			seleccionarNivel();
		}


	}





	/** Escribe en la ventana de la consola una línea
	 * @param s	String a visualizar en la ventana
	 */
	public static void println( String s ) {
		if (miVentana == null) init();
		miVentana.taSalida.append( s + "\n" );
	}
	/** Escribe en la ventana de la consola una línea
	 * @param s	String a visualizar en la ventana
	 */
	public static void print( String s ) {
		if (miVentana == null) init();
		miVentana.taSalida.append( s+"" );
	}
	/** Escribe en la ventana del enunciado una línea
	 * @param s	String a visualizar en la ventana
	 */
	public static void printEnunciado( String s ) {
		if (miVentana == null) init();
		miVentana.taEnunciado.append( s + "\n" );
	}
	/** Lee una línea desde la línea de entrada de la ventana
	 * @return	Línea leída
	 */
	static public String readLine() {
		if (miVentana == null) init();
		while (!miVentana.lineaLeida) {
			// Espera hasta que se lea algo
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
		}
		miVentana.lineaLeida = false;
		String ret  = miVentana.tfLineaEntrada.getText();
		miVentana.tfLineaEntrada.setText( "" );
		return ret;
	}

	public static String muestraContenido() throws FileNotFoundException, IOException {
		String cadena;
		String ficheroEntero = "";
		File fil=new File(ruta);
		FileReader f = new FileReader(fil);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine())!=null) {
			ficheroEntero=ficheroEntero+"\n"+cadena;
		}
		b.close();
		return ficheroEntero;
	}

	public static void escribeFichero() throws IOException{
		if(editable){
			FileWriter fw=new FileWriter(obEditable.ruta);
			PrintWriter pw = null;
			try
			{
				pw = new PrintWriter(fw); 
				pw.println(textArea.getText());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {

					if (null != fw)
						fw.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}



	static public void finish(){
		miVentana.dispose();
	}

	public static void consola(){

		VentanaJuego.println("JUGAR\n"); {
			seleccionarNivel();
		}

	}

	private static void seleccionarNivel(){
		VentanaJuego.println("Elige el tipo de nivel que deseas: \n");
		for (int i = 0; i < AccesosBD.mostrarNiveles().size(); i++) {

			VentanaJuego.println("-"+AccesosBD.mostrarNiveles().get(i)+": "+AccesosBD.mostrarNiveles().get(i+1));
			i++;
		}
		nom_nivel=VentanaJuego.readLine();
		crearTree(nom_nivel);



	}



	static public void init() {

		miVentana = new VentanaJuego();
		miVentana.setVisible(true);
		miVentana.tfLineaEntrada.requestFocus();

		Thread hiloConsola = new Thread( new MiHilo());

		hiloConsola.start();

	}
}


class MiHilo implements Runnable {
	public void run() {

		VentanaJuego.consola();
	}
}

class hiloJuego implements Runnable{
	public void run(){

		ObjetoNivel nivel=AccesosBD.getNivel(VentanaJuego.nom_nivel);

		if(Tests.principal(nivel.code)==true){
			AccesosBD.resueltos(nivel.code, VentanaLogin.cod_u);
		}
	}
}
