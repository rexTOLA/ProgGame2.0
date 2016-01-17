package Capa_de_Presentacion;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.UIManager;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ProgGaming {

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

}
