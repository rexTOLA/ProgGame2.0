package Capa_de_Presentacion;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.DefaultCaret;
import javax.swing.tree.DefaultMutableTreeNode;

import Capa_de_Datos.AccesosBD;
import Ej_Deslizar.Ej_Deslizar;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.JButton;

public class VentanaJuego extends JFrame {
	protected static VentanaJuego miVentana = null;
	private boolean lineaLeida = false;
	protected JPanel contentPane;
	protected JPanel panel;
	protected static JTree tree;
	protected static JTextArea textArea = new JTextArea();
	protected JScrollPane scrollPane = new JScrollPane(textArea);
	protected JTextField tfLineaEntrada = new JTextField();
	protected JTextArea taEnunciado = new JTextArea();
	protected JScrollPane spEnunciado = new JScrollPane(taEnunciado);
	protected JTextArea taSalida = new JTextArea();
	protected JScrollPane spSalida = new JScrollPane(taSalida);
	public String cod_u;
	protected static DefaultMutableTreeNode selectedNode;
	protected static String nom_nivel;



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
		VentanaJuego.println("hola");
		//Hace sonar la musica
		try {
			File musica = new File("Disfigure   Blank [NCS Release].mp3");
			FileInputStream fis = new FileInputStream(musica);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Player player = new Player(bis);
			player.play();
		}
		catch (JavaLayerException e){
			e.printStackTrace();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

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



		JButton btnCheck = new JButton("PLAY");
		btnCheck.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
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


		


		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("Class", null, scrollPane, null);

		tabbedPane.addTab("Class Folder",null,tree,null);



		//Add the tabbed pane to this panel.
		panel.setLayout(new GridLayout(1, 1)); 
		panel.add(tabbedPane);


		taSalida.setEditable(false);
		taEnunciado.setEditable(false);
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
		switch (nom_nivel) {
		case "Ej_Deslizar":{//create the root node
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Nivel Deslizar");
			//create the child nodes
			DefaultMutableTreeNode EJ_Deslizar = new DefaultMutableTreeNode("EJ_Deslizar");
			DefaultMutableTreeNode Hielo = new DefaultMutableTreeNode("Hielo");
			DefaultMutableTreeNode Hielo2 = new DefaultMutableTreeNode("Hielo2");
			DefaultMutableTreeNode ObjetoJuego = new DefaultMutableTreeNode("ObjetoJuego");
			DefaultMutableTreeNode Pared = new DefaultMutableTreeNode("Pared");
			DefaultMutableTreeNode Personaje = new DefaultMutableTreeNode("Personaje");
			DefaultMutableTreeNode Salida = new DefaultMutableTreeNode("Salida");
			DefaultMutableTreeNode Tile = new DefaultMutableTreeNode("Tile");


			//add the child nodes to the root node
			root.add(EJ_Deslizar);
			root.add(Hielo);
			root.add(Hielo2);
			root.add(ObjetoJuego);
			root.add(Pared);
			root.add(Personaje);
			root.add(Salida);
			root.add(Tile);


			//create the tree by passing in the root node
			tree = new JTree(root);}	
		break;
		case "Ej_Enemigos":{//create the root node
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Nivel Enemigos");
			//create the child nodes
			DefaultMutableTreeNode Coordenada = new DefaultMutableTreeNode("Coordenada");
			DefaultMutableTreeNode Ej_Enemigo = new DefaultMutableTreeNode("Ej_Enemigo");
			DefaultMutableTreeNode Enemigo = new DefaultMutableTreeNode("Enemigo");
			DefaultMutableTreeNode ObjetoJuego = new DefaultMutableTreeNode("ObjetoJuego");
			DefaultMutableTreeNode Pared = new DefaultMutableTreeNode("Pared");
			DefaultMutableTreeNode Personaje = new DefaultMutableTreeNode("Personaje");
			DefaultMutableTreeNode Salida = new DefaultMutableTreeNode("Salida");
			DefaultMutableTreeNode Tablero = new DefaultMutableTreeNode("Tablero");
			DefaultMutableTreeNode Tile = new DefaultMutableTreeNode("Tile");


			//add the child nodes to the root node
			root.add(Coordenada);
			root.add(Ej_Enemigo);
			root.add(Enemigo);
			root.add(ObjetoJuego);
			root.add(Pared);
			root.add(Personaje);
			root.add(Salida);
			root.add(Tablero);
			root.add(Tile);


			//create the tree by passing in the root node
			tree = new JTree(root);}	
		break;
		case "Ej_Walls":{//create the root node
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Nivel Walls");
			//create the child nodes
			DefaultMutableTreeNode Coordenada = new DefaultMutableTreeNode("Coordenada");
			DefaultMutableTreeNode Ej_Walls = new DefaultMutableTreeNode("Ej_Walls");
			DefaultMutableTreeNode Mover = new DefaultMutableTreeNode("Mover");
			DefaultMutableTreeNode ObjetoJuego = new DefaultMutableTreeNode("ObjetoJuego");
			DefaultMutableTreeNode Pared = new DefaultMutableTreeNode("Pared");
			DefaultMutableTreeNode Personaje = new DefaultMutableTreeNode("Personaje");
			DefaultMutableTreeNode Salida = new DefaultMutableTreeNode("Salida");
			DefaultMutableTreeNode Tile = new DefaultMutableTreeNode("Tile");


			//add the child nodes to the root node
			root.add(Coordenada);
			root.add(Ej_Walls);
			root.add(Mover);
			root.add(ObjetoJuego);
			root.add(Pared);
			root.add(Personaje);
			root.add(Salida);
			root.add(Tile);


			//create the tree by passing in the root node
			tree = new JTree(root);}	
		break;
		default:{println("Nivel incoreecto");}
		break;
		}
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);

		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				String algo="";
				try {
					algo=muestraContenido();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(algo);

			}
		});
	}



	/** Escribe en la ventana de la consola una línea
	 * @param s	String a visualizar en la ventana
	 */
	public static void println( String s ) {
		if (miVentana == null) init();
		miVentana.taSalida.append( s + "\n" );
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
		File fil=new File("src/"+nom_nivel+"/"+selectedNode.getUserObject().toString()+".java");
		FileReader f = new FileReader(fil);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine())!=null) {
			ficheroEntero=ficheroEntero+"\n"+cadena;
		}
		b.close();
		return ficheroEntero;
	}

	static public void finish(){
		miVentana.dispose();
	}

	private static void consola(){

		String opcion;

		boolean defo=false;

		boolean back=false;



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
				{VentanaJuego.println("Elige el tipo de nivel que deseas\n");

				VentanaJuego.println("Ej_Deslizar\nEj_Enemigos\nEj_Walls");


				VentanaJuego.println("\n\nPara ir atrás escriba back");
				nom_nivel=VentanaJuego.readLine();
				crearTree(nom_nivel);				
				}
			}
			break;
			case "2": VentanaJuego.println("DISEÑAR");	defo=false;	
			break;	 
			default: VentanaJuego.println("Opción o comando no contemplado, introduzca de nuevo: \n"); defo=true;
			break;
			}}while(defo==true || back==true);



	}

	static public void init() {

		miVentana = new VentanaJuego();
		miVentana.setVisible( true );
		miVentana.tfLineaEntrada.requestFocus();
		consola();



	}
}