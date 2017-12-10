package Projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTMLDocument.Iterator;





public class Edytor extends JFrame implements ActionListener {
ArrayList ComboLista = new ArrayList<>(); 	
static ArrayList<String> Armia = new ArrayList<String>(); 
static JComboBox [] sciana= new JComboBox[12];
static JComboBox[] inicjatywa = new JComboBox[2];
JComboBox List;
JButton [] zetony = new JButton[30];
static String[] name = new String[10]; 
static String Wybrany;
String [] parametry= {"mobilnosc","wytrzymalosc","wrog","sojusznik", "inicjatywa1","inicjatywa2", "Sciezka", "Ilezetonow"};
static JRadioButton zolnierz;
static JRadioButton modul;
JFileChooser obraz; 
JLabel numersciany; 
JLabel polenazwy; 
JLabel poleIle; 
JLabel poleinicjatywy; 
JButton dodajEfekt;
JButton dodajInicjatywe;
JButton wybierzplik; 
JButton zapisz; 
JButton podglad;
JButton dodaj;
JButton wyczysc;
static JRadioButton mobilnosc;
static JRadioButton wytrzymalosc;
static JTextField Nazwa; 
static JTextField Ile; 
static BufferedImage obrazek; 
String sciezka; 
int x; 
int wspolrzednax;
int wspolrzednay;
int kombo=6; 
int wytrzymaly;
int sojusznik;
int wrog;
int dodany;
int n=0;
int odcieta=600;
int rzedna=50; 
int numer = 5000;
int in=0;
int j;
JPanel panel;
JLabel poleobrazu; 
static String [] wybrany= new String[15];
int m=0;
int c;


	public Edytor()
	{
	setLayout(null);
	wspolrzednax= 120;
	wspolrzednay = 60;
    x=0;
    
  
    Nazwa = new JTextField();
    Nazwa.setBounds(170,25,300,20);
    add(Nazwa);
    
	polenazwy=new JLabel("Nazwa:" ); 
	polenazwy.setBounds(120, 25,50,20);
	add(polenazwy);
    
	for(int i=0; i<6; i++)
	{
	numersciany=new JLabel("œciana" + x); 
	numersciany.setBounds(50, wspolrzednay,50,20);
	add(numersciany);
	
	sciana[x]= new JComboBox();
	sciana[x].setBounds(wspolrzednax,wspolrzednay,150,20);
	sciana[x].addItem("pusty");
	sciana[x].addItem("pojedynczy cios");
	sciana[x].addItem("podwojny cios");
	sciana[x].addItem("potrojny cios");
	sciana[x].addItem("pojedynczy strzal");
	sciana[x].addItem("podwojny strzal");
	sciana[x].addItem("siec");
	sciana[x].addItem("pancerz");
	sciana[x].addItem("dzialko Gaussa");
	add(sciana[x]);
	ComboLista.add(sciana[x]);
	

	wspolrzednay=wspolrzednay+30;
	x++;
	}
	dodajEfekt=new JButton("+");
    dodajEfekt.setBounds(220,240,50,20);
    add(dodajEfekt);
    dodajEfekt.addActionListener(this);
    
	mobilnosc=new JRadioButton("mobilnosc");
    mobilnosc.setBounds(50,270,100,20);
    add(mobilnosc);
    mobilnosc.setContentAreaFilled(false);
    mobilnosc.addActionListener(this);
    
	wytrzymalosc=new JRadioButton("wytzymalosc");
    wytrzymalosc.setBounds(180,270,100,20);
    add(wytrzymalosc);
    wytrzymalosc.setContentAreaFilled(false);
    wytrzymalosc.addActionListener(this);
    
    zolnierz=new JRadioButton("zolnierz");
    zolnierz.setBounds(50,300,100,20);
    add(zolnierz);
    zolnierz.setContentAreaFilled(false);
    zolnierz.addActionListener(this);
    
    modul=new JRadioButton("modul");
    modul.setBounds(180,300,100,20);
    add(modul);
    modul.setContentAreaFilled(false);
    modul.addActionListener(this);
    
    poleinicjatywy=new JLabel("Inicjatywa" ); 
	poleinicjatywy.setBounds(120, 360,100,20);
	add(poleinicjatywy);
	
    inicjatywa[0]= new JComboBox();
    inicjatywa[0].setBounds(100,400,50,20);
	inicjatywa[0].addItem("0");
	inicjatywa[0].addItem("1");
	inicjatywa[0].addItem("2");
	inicjatywa[0].addItem("3");
	inicjatywa[0].addItem("nieskonczona");
    add(inicjatywa[0]);
    
	dodajInicjatywe=new JButton("+");
    dodajInicjatywe.setBounds(100,450,50,20);
    add(dodajInicjatywe);
    dodajInicjatywe.addActionListener(this);
    
	poleIle=new JLabel("Ile Zetonow:" ); 
	poleIle.setBounds(70, 500,100,20);
	add(poleIle);
    
    Ile = new JTextField();
    Ile.setBounds(170,500,40,20);
    add(Ile);
    
    
	poleobrazu=new JLabel(); 
	poleobrazu.setBounds(380, 250,200,200);
	add(poleobrazu);
	
	wybierzplik=new JButton("wybierz plik");
    wybierzplik.setBounds(400,450,130,20);
    add(wybierzplik);
    wybierzplik.addActionListener(this);
    
	dodaj=new JButton("dodaj");
    dodaj.setBounds(400,500,100,20);
    add(dodaj);
    dodaj.addActionListener(this);
    
    zapisz=new JButton("zapisz");
    zapisz.setBounds(400,600,100,20);
    add(zapisz);
    zapisz.addActionListener(this);
    
    wyczysc=new JButton("wyczysc");
    wyczysc.setBounds(600,600,100,20);
    add(wyczysc);
    wyczysc.addActionListener(this);
    
    podglad=new JButton("podgl¹d");
    podglad.setBounds(600, 20, 100, 20);
    add(podglad);
    podglad.addActionListener(this);
    
	List=new JComboBox();
	List.setBounds(600, 50, 100, 20);
	add(List);
	List.addActionListener(this);
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e)  
	{
    	 
		Object source = e.getSource();
        
	    if(source == dodajEfekt)
	    {
	    	wspolrzednay=60;
	    	int y=0; 
	    	kombo=12;
	    	for(int i=0; i<6; i++)
	    	{	
	     sciana[x]= new JComboBox();
	     sciana[x].setBounds(350,wspolrzednay,150,20);
	 	 sciana[x].addItem("pusty");
		 sciana[x].addItem("pojedynczy cios");
		 sciana[x].addItem("podwojny cios");
		 sciana[x].addItem("potrojny cios");
		 sciana[x].addItem("pojedynczy strzal");
		 sciana[x].addItem("podwojny strzal");
		 sciana[x].addItem("siec");
		 sciana[x].addItem("pancerz"); 
		 sciana[x].addItem("dzialko Gaussa");
	     add(sciana[x]);
	     ComboLista.add(sciana[y]);
	 	wspolrzednay=wspolrzednay+30;
		x++;
		y++;
	     repaint();
	    	}	    	    	
	    }
	    if (wytrzymalosc.isSelected())
	    {
	    	wytrzymaly=1;
	    }
	    else
	    {
	    	wytrzymaly=0;
	    }	
	    if (zolnierz.isSelected())
	    {
	    	wrog=1;
	    }
	    else
	    {
	    	wrog=0;
	    }
	    if (modul.isSelected())
	    {
	    	sojusznik=1;
	    }
	    else
	    {
	    	sojusznik=0;
	    }
	    if(wrog==1&&sojusznik==1)
	    {
	    	 JOptionPane.showMessageDialog(null, "Albo ¿olnierz albo modu³- zdecyduj siê!");
			 System.exit(0);	
	    }
	    if(source == dodajInicjatywe) 
	    {    
	    inicjatywa[1]= new JComboBox();
	    inicjatywa[1].setBounds(160,400,50,20);
		inicjatywa[1].addItem("0");
		inicjatywa[1].addItem("1");
		inicjatywa[1].addItem("2");
		inicjatywa[1].addItem("3");
		inicjatywa[1].addItem("nieskonczona");
	    add(inicjatywa[1]);
	    repaint();
	    dodany=1;
	    }
	    
	    if(source==wybierzplik)
	    {
	    	obraz= new JFileChooser();
	    	if(obraz.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
	    	{
	    		File plik= obraz.getSelectedFile();
	    		 sciezka = plik.getAbsolutePath();
	    		
	    	
	    	    obrazek = null;
	    		try {
	    		    obrazek = ImageIO.read(new File(sciezka));
	    		} catch (IOException d) {
	    		};  
	    		
	    		poleobrazu.setIcon(new ImageIcon (obrazek));
	    		repaint();
	    	}
	    
	    }
	    
	    if(source == podglad) 
		  {

		  }
	    if(source == dodaj) 
	    {
	    	if(kombo==12)
	    	{
	    	Metody.weryfikacja(this);	    	
	    	}
	    	else
	    	{
	    	dodaj();
	    	}
	    }
	    if(source == zapisz) 
	    	if(kombo==12)
	    		Metody.weryfikacja(this);	    	
	    	else
	    		zapis();
	    
	    if(source==wyczysc)
	    { Metody.zeruj(this);}
	    
	    	    
	   // BufferedReader br = null;
		//FileReader fr = null;
      //  String sciezka = "C:\\Users\\Merida\\Documents\\Moje!\\Neuroshima\\Armia.csv";
		//try {

			
		//	fr = new FileReader(sciezka);
			//br = new BufferedReader(fr);

			//String sCurrentLine;

			//while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				//Lista.ArmiaWczytana.add(sCurrentLine);}
			
		//  }
	//	catch (IOException h) {

		//	h.printStackTrace();

		//} finally {

			//try {

				//if (br != null)
				//	br.close();

				//if (fr != null)
					//fr.close();

			  //  }  catch (IOException ex) {

				//ex.printStackTrace(); }
		       // }			
	   
	    if (source==List)
	    {
	    if(m==0)
	    {System.out.print("dupa");}
	    else
	    Wybrany= List.getSelectedItem().toString();	
	    for(c=0;c<10;c++)
	    if(Wybrany.equals(name[c]))
	    	Nazwa.setText(name[c]); 
	        Metody.wypelnij(this);
	        repaint();
	    }          
}
	    

	
	public void dodaj()
	{  
		numer++;
		String numerseryjny= String.valueOf(numer);
		Armia.add(numerseryjny);
		name[m]= Nazwa.getText();
		Armia.add(name[m]);
		x=0;
		for(int i=0; i<kombo; i++)
    	{
			String parametr= sciana[x].getSelectedItem().toString();
			if(parametr.equals("pusty"))
			{			
			}
			else
			{
			Armia.add(parametr+";"+x);	
			}
			x++;
    	}
		Armia.add(parametry[0]+";"+(mobilnosc.isSelected()? 1 : 0));	// Ternary Operator
		Armia.add(parametry[1]+";"+wytrzymaly);	
		Armia.add(parametry[2]+";"+wrog);	
		Armia.add(parametry[3]+";"+sojusznik);	

		Armia.add(parametry[6]+";"+sciezka);
		String ilosc= Ile.getText();
		Armia.add(parametry[7]+";"+ilosc);
				
        List.addItem(name[m]);
        m++;
		repaint();
		
	    java.util.Iterator<String> it= Armia.iterator();
        while ( it.hasNext( ) ) {
        	System.out.println( it.next( ) );
        	}

	}

		
		public void zapis()
		{
    
        	
        try {
        	  FileWriter writer = new FileWriter("Armia.csv");
              int size = Armia.size();
              for (int i=0;i<size;i++) {
                  String str = Armia.get(i).toString();
                  writer.write(str);
                  if(i < size-1)
                      writer.write("\n");
              }
              writer.close();
          
              }
   catch(IOException ioe)
       {
           System.out.println("Error!");
       }
        }
		 

	 public static void main(String[] args) {	        
		 Edytor okienko =new Edytor();
		 okienko.setSize(800,800);
	     okienko.setTitle("Edytor Armii");
	     okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         okienko.setVisible(true);
         okienko.getContentPane().setBackground(Color.orange);  
        
	}
}
