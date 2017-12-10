package Projekt;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pole extends JButton{	//Tworzy pole-przycisk, przysz³osciowo bedzie przechowywac info o lezacym zetonie
	
	Zeton zeton;
	
	//Image grafika;
	
	Pole(int szerokosc, int wysokosc){
		super();
		ImageIcon grafikaPola=new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex1.png");
		ImageIcon grafikaPolaRollover=new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex2.png");
		ImageIcon grafikaPolaPressed=new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex3.png");
		setIcon(grafikaPola);
		setRolloverIcon(grafikaPolaRollover);
		setPressedIcon(grafikaPolaPressed);
		setContentAreaFilled(false);
		setBorder(null);
		setOpaque(false);
		setBackground( new Color( 0, 0, 0, 0 ) );
		setPreferredSize(new Dimension(szerokosc,wysokosc));
		
		//Stworz zeton
		zeton = new Zeton();
		//zeton.grafika=;
		//...
	}
	
	void ZmienZeton(Zeton z){
		zeton=z;
		//Zmieñ grafikê
		//...
	}
}
