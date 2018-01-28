package Projekt;

//klasa definiuje podstawowe wlasciwosci obiektu Pole 

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pole extends JButton{	
	
	public int x;
	public int y;
	public boolean zajete;
	protected Plansza plansza;	
	
	Pole(int x, int y, boolean zajete){
		super();
		this.x=x;
		this.y=y;
		this.zajete=zajete;
		
		ImageIcon grafikaPola=new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex2.png");
		ImageIcon grafikaPolaRollover=new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex2.png");
		ImageIcon grafikaPolaPressed=new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex3.png");
		setIcon(grafikaPola);
		setRolloverIcon(grafikaPolaRollover);
		setPressedIcon(grafikaPolaPressed);
		setContentAreaFilled(false);
		setBorder(null);
		setOpaque(false);
		setBackground( new Color( 0, 0, 0, 0 ) );
		setPreferredSize(new Dimension(Program.getSzerokoscHexa(),Program.getWysokoscHexa()));
	

	}
		Pole(Plansza plansza, int x, int y, boolean zajete){
			this(x,y,zajete);
			this.plansza=plansza;
		}
		
	
		
	

}