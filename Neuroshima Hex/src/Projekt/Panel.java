package Projekt;

//klasa tworzy panel do losowania zetonow

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

import Controllers.ZetonControllers;

public class Panel extends JPanel implements ActionListener{
	
	
	private JButton[] polawyboru=new JButton[6];
	private JButton dodaj=new JButton("+");
	private JButton szukaj=new JButton("szukaj");
	private static JPanel polafunkcyjne= new JPanel();
	private int poziom=50;
	private int pion=50;
	private int k=-1;
	private Icon inny= new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex3.png");
	private  ArrayList<String> ArmiaPierwsza = new ArrayList<String>();
	private  ArrayList<String> ArmiaDruga = new ArrayList<String>();
	private  ArrayList<String> ListaGrafikBorgo = new ArrayList<String>();
	private  ArrayList<String> ListaGrafikHege = new ArrayList<String>();
	private  ArrayList<String> Sterta = new ArrayList<String>();
	private static String []sciezka=new String[4];
	int g;
	int r=9;
	int wcisniety=0;
	private Icon Borgo=new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Borgo\\sztab.png");
	private Icon Hege=new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hegemonia\\SztabHege.png");
	private JButton Sztab1=new JButton(Borgo);
	private JButton Sztab2=new JButton(Hege);

	Panel()
	{		
		dodaj.setBounds(50, 50, 70, 70);
		dodaj.addActionListener(this);	
        polafunkcyjne.add(dodaj);
        Sztab1.setContentAreaFilled(false);
        Sztab1.setBorder(null);
        Sztab1.addActionListener(this);
        polafunkcyjne.add(Sztab1);
        Sztab2.setContentAreaFilled(false);
        Sztab2.setBorder(null);
        Sztab2.addActionListener(this);
        polafunkcyjne.add(Sztab2);
        
        
		for(int i=0; i<3;i++)
		{
		polawyboru[i] = new JButton(new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex2.png"));	
		polawyboru[i].setBounds(poziom, pion+50, 50,50);
		polawyboru[i].setContentAreaFilled(false);
		polawyboru[i].setBorder(null);
		polawyboru[i].addActionListener(this);
		polafunkcyjne.add(polawyboru[i]);
		pion=pion+50;		
		}
		add(polafunkcyjne);
		wczytaj();
		zapiszGrafike();
		ZetonControllers.stworzObiekty(); 
		//System.out.println(ListaGrafikHege.get(9));
	}
	
	//metoda wczytuje dane o armii z pliku csv i zapisuje je na liscie ArmiaWczytana
	
	public void wczytaj()
	{
	ArrayList<String> Armie= new ArrayList<String>();
	Armie.add("\\Borgo.csv");
	Armie.add("\\Hegemonia.csv");
	 for( g=0;g<2;g++)
	 {
	 BufferedReader br = null;
			FileReader fr = null;
	        String sciezka = System.getProperty("user.dir")+Armie.get(g);
			try {
				
				fr = new FileReader(sciezka);
				br = new BufferedReader(fr);

				String sCurrentLine;
                switch(g)
                {
                case 0: {while ((sCurrentLine = br.readLine()) != null) {
					ArmiaPierwsza.add(sCurrentLine);}}	
                case 1: {while ((sCurrentLine = br.readLine()) != null) {
					ArmiaDruga.add(sCurrentLine);}}	
                }
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
	}
	
	// metoda zczytuje wszystkie sciezki do grafiki poszczególnych zetonów i dodaje do listy ListaGrafik
	
	public void zapiszGrafike()
	{
		String bitwa="\\Grafika\\Borgo\\bitwa.png";
		ListaGrafikBorgo.add(bitwa);
		
		java.util.Iterator<String> ite= ArmiaPierwsza.iterator();
	
		while ( ite.hasNext( ) ) {        	   
           	String dane= ite.next();
           	k++;
           	if(dane.indexOf("Sciezka")==-1)
           	{}
           	else
           	{
       	    String Parametr=ArmiaPierwsza.get(k);
  			String[] Czesci = Parametr.split(";");
  			String Fragment= Czesci[0];
  			String Fragment2= Czesci[1];
  			ListaGrafikBorgo.add(Fragment2);
  			//System.out.println(Czesci[1]);			
  			}  }
		java.util.Iterator<String> iter= ArmiaDruga.iterator();
		k=-1;
		while ( iter.hasNext( ) ) {        	   
           	String dane= iter.next();
           	k++;
           	if(dane.indexOf("Sciezka")==-1)
           	{}
           	else
           	{
       	    String Parametr=ArmiaDruga.get(k);
       	   // System.out.print(Parametr);
  			String[] Czesci = Parametr.split(";");
  			String Fragment= Czesci[0];
  			String Fragment2= Czesci[1];
  			ListaGrafikHege.add(Fragment2);
           	}}
		}	
	
	@Override
	
	//obsluga przycisków
	
	public void actionPerformed(ActionEvent e)  
	{  	 
		Object source = e.getSource();
        
	    if(source == dodaj)
	    {
	      
	      for(int y=0;y<3;y++)
	      {
	       Random liczba = new Random();
	       Random liczba2 = new Random();
	       int losowa;
	       int losowa2;
	       Icon inna;
	    
	    
	       if(wcisniety%2==0)
	       {
	    	losowa=liczba.nextInt(ListaGrafikBorgo.size());
	    	inna= new ImageIcon(System.getProperty("user.dir")+ListaGrafikBorgo.get(losowa));
	        ListaGrafikBorgo.remove(losowa);
	       }
	       else
	       {
	    	losowa2=liczba2.nextInt(ListaGrafikHege.size());
	    	inna= new ImageIcon(System.getProperty("user.dir")+ListaGrafikHege.get(losowa2));
	        ListaGrafikHege.remove(losowa2);
	       }  
	       
	       polawyboru[y].setIcon(inna);	
	       sciezka[y+1]=inna.toString();
	       
	       }
	      wcisniety++;
	      //System.out.println(wcisniety);
	    }
	    
	    
	    if(source == polawyboru[0])
	    {
	    	sciezka[0]=sciezka[1];
	    	polawyboru[0].setIcon(inny);
	    	ZetonControllers.przerwij=1;
	    	if(sciezka[0].indexOf("bitwa")==-1)
	    	{}	
	    }
	    if(source == polawyboru[1])
	    {
	    	sciezka[0]=sciezka[2];
	    	polawyboru[1].setIcon(inny);
	    	ZetonControllers.przerwij=1;
	    }
	    if(source == polawyboru[2])
	    {
	    	sciezka[0]=sciezka[3];
	    	polawyboru[2].setIcon(inny);  
	    	ZetonControllers.przerwij=1;
	    }
	    if(source == Sztab1)
	    {
	    	sciezka[0]=Borgo.toString();
	    	Sztab1.setIcon(null);  
	    	ZetonControllers.przerwij=1;
	    	wcisniety=1;
	    	ListaGrafikBorgo.remove(9);
	    	
	    }
	    if(source == Sztab2)
	    {
	    	sciezka[0]=Hege.toString();
	    	Sztab2.setIcon(null);  
	    	ZetonControllers.przerwij=1;
	    	wcisniety=2;
	    	ListaGrafikHege.remove(9);
	    }
	}
	

	
	public static String[] getSciezka()
	{
		return sciezka;
	}
	 public static void main(String[] args) {	        

    System.out.print(""); 
  
	}
}