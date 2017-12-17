package Projekt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
	int k=-1;
	Icon inny= new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex3.png");
	static ArrayList<String> ArmiaWczytana = new ArrayList<String>();
	static ArrayList<String> ListaGrafik = new ArrayList<String>();
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
		wczytaj();
		zapiszGrafike();
	}
	public void wczytaj()
	{
	 BufferedReader br = null;
			FileReader fr = null;
	        String sciezka = "C:\\Users\\Merida\\Documents\\Moje!\\Repozytorium Gry\\Neuroshima Hex\\Borgo.csv";
			try {

				
				fr = new FileReader(sciezka);
				br = new BufferedReader(fr);

				String sCurrentLine;

				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
					ArmiaWczytana.add(sCurrentLine);}
				
			  }

			catch (IOException h) {

				h.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				    }  catch (IOException ex) {

					ex.printStackTrace(); }
			        }	
	}
	
	public void zapiszGrafike()
	{
		java.util.Iterator<String> ite= ArmiaWczytana.iterator();
	
		while ( ite.hasNext( ) ) {        	   
           	String dane= ite.next();
           	k++;
           	if(dane.indexOf("Sciezka")==-1)
           	{}
           	else
           	{
       	    String Parametr=ArmiaWczytana.get(k);
  			String[] Czesci = Parametr.split(";");
  			String Fragment= Czesci[0];
  			String Fragment2= Czesci[1];
  			ListaGrafik.add(Fragment2);
  			System.out.print(Czesci[1]);
          	 }  }}
          	 
          	 
           	 
           	
		
	
           	 
           	
		
	
	@Override
	public void actionPerformed(ActionEvent e)  
	{
    	 
		Object source = e.getSource();
        
	    if(source == dodaj)
	    {
	    for(int y=0;y<3;y++)
	    {
	       Random liczba = new Random();
	       int losowa;
	       losowa=liczba.nextInt(2);
	       Icon inna= new ImageIcon(ListaGrafik.get(losowa));
	       polawyboru[y].setIcon(inna);	    
	    }
	    }
	}
	 public static void main(String[] args) {	        

    System.out.print("dupa"); 
  
	}
}
