package Capa_de_Presentacion;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class VentanaJuego extends JFrame {
	protected static VentanaJuego miVentana = null;
	private boolean lineaLeida = false;
	protected JPanel contentPane;
	protected JTextField tfLineaEntrada = new JTextField();
	protected JTextArea textArea = new JTextArea();
	protected JScrollPane scrollPane = new JScrollPane(textArea);
	protected JTextArea taEnunciado = new JTextArea();
	protected JScrollPane spEnunciado = new JScrollPane(taEnunciado);
	protected JTextArea taSalida = new JTextArea();
	protected JScrollPane spSalida = new JScrollPane(taSalida);




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

		tfLineaEntrada = new JTextField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(12)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(spSalida, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
								.addComponent(spEnunciado, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
								.addComponent(tfLineaEntrada, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(spEnunciado, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spSalida, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tfLineaEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(37, Short.MAX_VALUE))
				);


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