package Projekt;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Program{	//Inicjuje aplikacjê okienkow¹ i startuje Grê
	
	// klasa main otwiera okienko	
	 public static void main(String[] args) 
	 { 	 		 		 
		 //Najbli¿sze 3 linijki to podobno najbardziej zalecany sposób startowania aplikacji okienkowych w Javie
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
}
