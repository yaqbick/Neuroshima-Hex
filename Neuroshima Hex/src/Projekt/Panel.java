package Projekt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
// stworzylem klase, ktora bedzie obslugiwac dodawanie i wyswietlanie zetonow obok planszy

public class Panel extends JPanel implements ActionListener{
	
	
	JButton[] polawyboru=new JButton[6];
	JButton dodaj=new JButton("+");
	static JPanel polafunkcyjne= new JPanel();
	int poziom=50;
	int pion=50;
	Icon inny= new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex3.png");
	
	Panel()
	{
		 setLayout(null);
		 JFrame okienko=new JFrame();
		 okienko.setSize(200,600);
	     okienko.setTitle("Test Panelu");
	     okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         okienko.setVisible(true);
		
		dodaj.setBounds(50, 50, 70, 70);
		dodaj.addActionListener(this);
        polafunkcyjne.add(dodaj); 
		for(int i=0; i<3;i++)
		{
		polawyboru[i] = new JButton(new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex2.png"));	
		polawyboru[i].setBounds(poziom, pion+50, 50,50);
		polawyboru[i].setContentAreaFilled(false);
		polawyboru[i].setBorder(null);
		polafunkcyjne.add(polawyboru[i]);
		pion=pion+50;
		}
		okienko.add(polafunkcyjne);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)  
	{
    	 
		Object source = e.getSource();
        
	    if(source == dodaj)
	    {
	    for(int y=0;y<3;y++)
	    {
	    	polawyboru[y].setIcon(inny);	    
	    }
	    }
	}
	 public static void main(String[] args) {	        

    System.out.print("dupa"); 
  
	}
}
