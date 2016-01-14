package Capa_de_Presentacion;


import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
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
//ssd
public class VentanaJuego extends JFrame {
	protected static VentanaJuego miVentana = null;
	private boolean lineaLeida = false;
	protected JPanel contentPane;
	protected JPanel panel;
	protected JTextArea textArea = new JTextArea();
	protected JScrollPane scrollPane = new JScrollPane(textArea);
	protected JTextField tfLineaEntrada = new JTextField();
	protected JTextArea taEnunciado = new JTextArea();
	protected JScrollPane spEnunciado = new JScrollPane(taEnunciado);
	protected JTextArea taSalida = new JTextArea();
	protected JScrollPane spSalida = new JScrollPane(taSalida);
	protected TreeClass treeClass=new TreeClass();
	public String cod_u;

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

		
		
		JButton btnCheck = new JButton("CHECK");
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
		
		tabbedPane.addTab("Class Folder", null, treeClass, null);
	


		//Add the tabbed pane to this panel.
		panel.setLayout(new GridLayout(1, 1)); 
		panel.add(tabbedPane);


		taSalida.setEditable(false);
		taEnunciado.setEditable(false);
		contentPane.setLayout(gl_contentPane);
		// Pol�tica de visualizaci�n de caret -cursor en textarea-
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


	/** Escribe en la ventana de la consola una l�nea
	 * @param s	String a visualizar en la ventana
	 */
	public static void println( String s ) {
		if (miVentana == null) init();
		miVentana.taSalida.append( s + "\n" );
	}
	/** Escribe en la ventana del enunciado una l�nea
	 * @param s	String a visualizar en la ventana
	 */
	public static void printEnunciado( String s ) {
		if (miVentana == null) init();
		miVentana.taEnunciado.append( s + "\n" );
	}
	/** Lee una l�nea desde la l�nea de entrada de la ventana
	 * @return	L�nea le�da
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
	static public void finish(){
		miVentana.dispose();
	}
	static public void init() {

		miVentana = new VentanaJuego();
		miVentana.setVisible( true );
		miVentana.tfLineaEntrada.requestFocus();
		

		Consola con=new Consola();


	}
}