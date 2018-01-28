package Projekt;

//klasa uruchamia gre

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Program{	
	
	//dekklaracja kluczowych zmiennych do tworzenia planszy
	
	private static int szerokoscHexa = 120;
	private static int wysokoscHexa = 138;
	
	
 public static void main(String[] args) 
	 { 	 		 		 		
		 EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					JFrame okno =new JFrame();
					okno.setSize(1500,1500);
					okno.setExtendedState(JFrame.MAXIMIZED_BOTH);
					okno.setTitle("Neuroshima");
					okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					okno.setVisible(true);					
					okno.add(new Gra());
					
				}
			}); 
	 }	
 
 public static int getSzerokoscHexa()
 {
	 return szerokoscHexa;
 }
 public static int getWysokoscHexa()
 {
	 return wysokoscHexa;
 }
}
