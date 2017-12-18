package Projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class Gra extends JPanel {	//Inicjuje now¹ planszê, a póŸniej tak¿e graczy 

	Plansza plansza;
	Panel panel;
	Test test;
	Druzyna druzyny[];
	JButton przykladowePole; 
	Gra(){
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
		
		test=new Test();
		
		
	}


}