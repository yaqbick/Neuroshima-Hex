package Projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controllers.ZetonControllers;

import javax.swing.BoxLayout;

public class Gra extends JPanel {	//Inicjuje now¹ planszê, a póŸniej tak¿e graczy 

	Plansza plansza;
	Panel panel;
	Druzyna druzyny[];
	JButton przykladowePole; 
	Gra(){
		
		
		//Zeton1 zetonTemp1 = ZetonControllers.GetZetonByName("strzelec");
		
		//zetonTemp1.toString();// metoda toString z klasy Zeton1- przes³ania domyœlne toString() i zastepuje trescia
		ArrayList<Zeton1> mojaListaNaPotrzebyJakiestam = ZetonControllers.GetAllByUser(1);
		
		ArrayList<Zeton1> mojaListaNaPotrzebyJakiestam2 = ZetonControllers.GetAllByUser(2);
		
		// tutaj pobierasz dany element z listy zetonow
		//mojaListaNaPotrzebyJakiestam.get(0).
		
		// w petli szukamy sztabu
		//if(mojaListaNaPotrzebyJakiestam.get(1).rodzajZetonu.equals(RodzajZetonu.Sztab))
			// jak tu przeszlo to znaczyze ten obiekt jest sztabem
			
			
		
		setBackground( new Color( 0, 0, 0, 0 ) );
		setOpaque(false);
		setBorder(BorderFactory.createTitledBorder("Gra"));
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		JPanel panelPlansza = new JPanel();
		panelPlansza.setLayout(new FlowLayout());
		panelPlansza.setBorder(BorderFactory.createTitledBorder("Panel - Plansza"));
		add(panelPlansza);
		JPanel panelStol = new JPanel();
		panelStol.setLayout(new FlowLayout());
		panelStol.setBorder(BorderFactory.createTitledBorder("Panel - Stó³"));
		add(panelStol);


		
		JLabel backgroundImage=new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\t³o.jpg"));
		//backgroundImage.setBounds(okno.getBounds());
		//add(backgroundImage);		
		
		plansza=new Plansza(5);		
		panelPlansza.add(plansza);
		
		panel=new Panel();
		panelPlansza.add(panel);
		
		
		
		
	}


}