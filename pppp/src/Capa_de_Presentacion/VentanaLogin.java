package Capa_de_Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Capa_de_Datos.AccesosBD;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public String username;
	public String contraseña;
	public static String cod_u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
		}catch(Exception e){

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});




	}


	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/Capa_de_Presentacion/logo64x64.png")));
		setTitle("ProgGaming-LogIn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.ORANGE);
		lblUsername.setFont(new Font("Power Red and Blue Intl", Font.BOLD, 20));

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setFont(new Font("Power Red and Blue Intl", Font.BOLD, 20));
		final JLabel lblNewLabel = new JLabel("Contraseña mala");
		lblNewLabel.setVisible(false);
		textField = new JTextField();
		textField.setColumns(10);

		passwordField = new JPasswordField();

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				username=textField.getText();
				contraseña=passwordField.getText();
				cod_u=AccesosBD.log(username, contraseña);
				if(!cod_u.equals("")){
					dispose();
					VentanaJuego.init();

				}else{
					lblNewLabel.setVisible(true);
				}

			}

		});

		JButton btnSingIn = new JButton("Sing In");
		btnSingIn.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				username=textField.getText();
				contraseña=passwordField.getText();
				cod_u= AccesosBD.reg(username, contraseña);
				dispose();
				VentanaJuego.init();
			}
		});

		JPanel panel = new JPanel();

		JLabel lblProgGaming = new JLabel("PROG GAMING");
		lblProgGaming.setForeground(Color.ORANGE);
		lblProgGaming.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgGaming.setFont(new Font("Power Red and Blue Intl", Font.BOLD, 37));


		lblNewLabel.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(btnLogIn, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(btnSingIn, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
														.addComponent(passwordField))))
								.addComponent(lblProgGaming, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(10)
										.addComponent(lblNewLabel)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(167, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblProgGaming, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGap(15)
						.addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUsername)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLogIn)
								.addComponent(btnSingIn))
						.addContainerGap(52, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(45)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 170, Short.MAX_VALUE)
						.addGap(36))
				);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Capa_de_Presentacion/logo160x160.png")));
		panel.add(label);
		contentPane.setLayout(gl_contentPane);
	}
}
