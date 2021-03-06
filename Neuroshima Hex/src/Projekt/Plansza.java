package Projekt;

//klasa tworzy plansze

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ZetonControllers;

    public class Plansza extends JPanel implements ActionListener,KeyListener{	
	
	private int rozmiar;
    private	ArrayList<Pole> pola = new ArrayList<Pole>();
	private Pole kliknietePole;
	private Icon obraz;
	private Icon nowaGrafika;
	private static int xx;
	private static int yy;
	public static int rzedna;
	public static int odcieta;
    private int n=0;
    private  ArrayList<String> ListaObrotu = new ArrayList<String>();
    private static String sciezka = System.getProperty("user.dir")+"\\Grafika\\Borgo\\";
    private static String  obrocony;
    private static String klucz;
    public  Zeton1 wybrany;
    Gra gra;
    int c;
	Icon czarny= new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Borgo\\hexczarny.png");
	public Plansza(Gra gra,int rozmiar){
		
		//Rysowanie planszy
		
		super();
		this.gra=gra;
		this.rozmiar=rozmiar;
		if(this.rozmiar%2==0)this.rozmiar++;
		setLayout(new GridLayout(rozmiar,1,0,-Program.getWysokoscHexa()/4));
		setBackground( new Color( 0, 0, 0, 0 ) );
		setOpaque(false);
		setBorder(BorderFactory.createTitledBorder("Plansza"));


		for(int y=0; y<rozmiar; y++)
		{
			JPanel rzad = new JPanel();
			rzad.setLayout(new GridLayout(1,rozmiar));
			rzad.setBackground( new Color( 0, 0, 0, 0 ) );
			rzad.setOpaque(false);
			if(y%2==0)rzad.setBorder(new EmptyBorder(0, Program.getSzerokoscHexa()/2, 0, Program.getSzerokoscHexa()/2));
			else rzad.setBorder(new EmptyBorder(0, 0, 0, Program.getSzerokoscHexa()));
			add(rzad);
			boolean zajete = false;
			//dodawanie obiektow typu Pole
			
			for(int x=0; x<rozmiar; x++)
			{			
				Pole pole=new Pole(this,x,y,zajete);
				pole.addActionListener(this);
				pole.addKeyListener(this);
				pola.add(pole);
				rzad.add(pole);
				if(!isInsideHexagon(x,y))pole.setVisible(false);								
			}
		}
		for(int i=0; i<pola.size();i++)
        {
			if(pola.get(i).x==3 &&pola.get(i).y==0 )
			{pola.get(i).x=5; }
			if(pola.get(i).x==2 &&pola.get(i).y==0 )
			{pola.get(i).x=4; }
			if(pola.get(i).x==1 &&pola.get(i).y==0 )
			{pola.get(i).x=3; }
        }
		for(int i=0; i<pola.size();i++)
		{
			if(pola.get(i).y==1)
			{pola.get(i).x=pola.get(i).x+1; }
			
		}	
		for(int i=0; i<pola.size();i++)
		{
			if(pola.get(i).y==2)
			{pola.get(i).x=pola.get(i).x+1; }
			
		}
        }
	
	
	Boolean isInsideHexagon(int x, int y)
	
	{
		
		if(x==0 && y==0)return false;
		if(x==0 && y==1)return false;
		if(x==0 && y==3)return false;
		if(x==0 && y==4)return false;
		if(x==4 && y==0)return false;
		if(x==4 && y==4)return false;
		return true;
	}
	
	public void obslugaPrzycisku()
	{
		//metoda obslugujaca pola 
		
		obraz=new ImageIcon(Panel.getSciezka()[0]);
		kliknietePole.setIcon(obraz);
		wyszukaj();
		ZetonControllers.wyszukajPoNazwie();
		ZetonControllers.wybrany.wspolrzednaX=kliknietePole.x;
		ZetonControllers.wybrany.wspolrzednaY=kliknietePole.y;
		String nazwa=ZetonControllers.wybrany.nazwa;
		int inicjatywa=ZetonControllers.wybrany.inicjatywa;
		int id=ZetonControllers.wybrany.id;
		System.out.println("Dodano Obiekt: "+nazwa+" o inicjatywie: "+inicjatywa+" oraz o id "+id);
		System.out.println("wspolrzedne: "+ZetonControllers.wybrany.wspolrzednaX+" i "+ZetonControllers.wybrany.wspolrzednaY);
		ZetonControllers.ListaObiektowNaPlanszy.add(ZetonControllers.wybrany);
		okreslSasiada();
	}
	
	//metoda umozliwiajaca obracanie zeton�w
	
	public  void  wyszukaj()
	{
		int liczba=0;
		String Parametr=Panel.getSciezka()[0];
		System.out.println(Parametr);
		if(Parametr.indexOf("Borgo")==-1)
		{liczba=82;}		
		else
		{liczba=78;}
		System.out.println(liczba);
		String koniec=Parametr.substring(liczba);
		System.out.println(koniec);
		String[] Czesci=koniec.split("\\.");
	    klucz=Czesci[0];
	    System.out.println(klucz);

	}
	
	public void okreslSasiada()
	{
		xx=ZetonControllers.wybrany.wspolrzednaX;
	    yy=ZetonControllers.wybrany.wspolrzednaY;
	    ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana=new ArrayList<Integer>();
	    //ZetonControllers.ListaObiektowNaPlanszy.get(n).scianaAktywna=new ArrayList<Integer>();
		int zero=xx*10+yy-1;
		int jeden=(xx+1)*10+yy-1;
		int dwa=(xx+1)*10+yy;
		int trzy=xx*10+yy+1;
		int cztery=(xx-1)*10+yy+1;
		int piec=(xx-1)*10+yy;
		//int piec=(xx-1)*10+yy-1;
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(zero);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(jeden);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(dwa);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(trzy);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(cztery);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(piec);	
		n++;
	}
	
	Pole ZnajdzPole(int x, int y){
		for(int p=0; p<pola.size(); p++)
			if(pola.get(p).x==x && pola.get(p).y==y)
			   return(pola.get(p));
		       return(null);
	}
	
	public void analiza()
	{int tura;
	fazaModolow();
	JOptionPane.showMessageDialog(null, "Bitwa!");
	for(tura=3;tura>-1;tura--)
	{
		JOptionPane.showMessageDialog(null, "Inicjatywa "+tura);
		for(int i=0; i<pola.size();i++)
		{
			if(pola.get(i).zajete==false)
			{}
			else
			{
				 xx=pola.get(i).x;
			     yy=pola.get(i).y;
			     ZetonControllers.wyszukajPoWspolrzednychNaPlanszy();			    
			    System.out.println(ZetonControllers.wybrany.nazwa);
			    if(ZetonControllers.wybrany.inicjatywa==tura)
			    {			    				    			     
			     for(c=0;c<ZetonControllers.wybrany.scianaAktywna.size();c++)
			     {
			        ZetonControllers.wybrany.scianaAktywna.get(c).kierunek=ZetonControllers.wybrany.scianaAktywna.get(c).kierunek+ZetonControllers.wybrany.obrot;
			       // System.out.println(ZetonControllers.wybrany.scianaAktywna.size());
			    //	System.out.println(ZetonControllers.wybrany.scianaAktywna.get(c).kierunek);
			        przypiszSasiada();
			     }}else{}}
	    czysciciel(); 
	    for(int d=0; d<ZetonControllers.ListaObiektowNaPlanszy.size();d++)
	    {
	    	if(ZetonControllers.ListaObiektowNaPlanszy.get(d).nazwa.equals("sztab"))
	    	{
	    		String punktyBorgo=Integer.toString(ZetonControllers.ListaObiektowNaPlanszy.get(d).zywotnosc);
	    		Punkty.getBorgo().setText(punktyBorgo);;
	    	}
	    	if(ZetonControllers.ListaObiektowNaPlanszy.get(d).nazwa.equals("SztabHege"))
	    	{
	    	    String punktyHege=Integer.toString(ZetonControllers.ListaObiektowNaPlanszy.get(d).zywotnosc);
    		    Punkty.getHege().setText(punktyHege);;}
	    	else
	    	{}	
	    }
		}
	
	    }			     
	}
public void przypiszSasiada()
{
	int wartosc=ZetonControllers.wybrany.scianaAktywna.get(c).kierunek;
	int x=ZetonControllers.wybrany.sciana.get(wartosc)/10;
	int y=ZetonControllers.wybrany.sciana.get(wartosc)-(10*x);
	System.out.println("Zaatakowane pole!: "+x+" oraz "+y);
	for(int d=0; d<pola.size();d++)
    {
	 rzedna=pola.get(d).x;
	 odcieta=pola.get(d).y;
	 
	 if(x==rzedna&& y==odcieta)
	 {
		 if(pola.get(d).zajete==false)
		 {}
		 else		 
		 {
		 if(ZetonControllers.wybrany.inicjatywa==100)
		 { ZetonControllers.wyszukajWspieranego();
		 if(ZetonControllers.wspierany.armia.equals(ZetonControllers.wybrany.armia))
		 {okreslRodzajWsparcia();}
		 else
		 {}}
		 else
		 {
		 ZetonControllers.wyszukajZaatakowanego();		 
		 if(ZetonControllers.zaatakowany.armia.equals(ZetonControllers.wybrany.armia))
		 {}
		 else
		 {ZetonControllers.zaatakowany.zywotnosc=ZetonControllers.zaatakowany.zywotnosc-ZetonControllers.wybrany.scianaAktywna.get(c).pierwszyEfekt;}
		 }}}
	 else {}
    }
}
public void czysciciel()
{
	for(int m=0; m<pola.size();m++)
	{	
		if(pola.get(m).zajete==false)
		{}
		else
		{	
		int xxx=pola.get(m).x;
		int yyy=pola.get(m).y;
		for(int d=0; d<ZetonControllers.ListaObiektowNaPlanszy.size();d++)
		{
			if(ZetonControllers.ListaObiektowNaPlanszy.get(d).wspolrzednaX==xxx&&ZetonControllers.ListaObiektowNaPlanszy.get(d).wspolrzednaY==yyy)
			{
				if(ZetonControllers.ListaObiektowNaPlanszy.get(d).zywotnosc<1) {
				Pole atakowane=pola.get(m); 
			    atakowane.setIcon(czarny);
			    atakowane.zajete=false;
			    ZetonControllers.ListaObiektowNaPlanszy.remove(d);
				}
				else
				{}
			}
			else
			{}}}}}

public void fazaModolow()
{
	for(int i=0; i<pola.size();i++)
	{
		if(pola.get(i).zajete==false)
		{}
		else
		{
			 xx=pola.get(i).x;
		     yy=pola.get(i).y;
		     ZetonControllers.wyszukajPoWspolrzednychNaPlanszy();
		     if(ZetonControllers.wybrany.inicjatywa==100)
		     {
		    	  for(c=0;c<ZetonControllers.wybrany.scianaAktywna.size();c++)
		    	  {
		    		ZetonControllers.wybrany.scianaAktywna.get(c).kierunek=ZetonControllers.wybrany.scianaAktywna.get(c).kierunek+ZetonControllers.wybrany.obrot; 
		    		przypiszSasiada();
		    	  }
		     }
		     else {}
	}
	}
}

public void okreslRodzajWsparcia()
{
	if(ZetonControllers.wybrany.nazwa.equals("zwiadowca")||ZetonControllers.wybrany.nazwa.equals("ZwiadowcaHege"))
	{  
		if(ZetonControllers.wspierany.typ.equals("zolnierz"))
		ZetonControllers.wspierany.inicjatywa=ZetonControllers.wspierany.inicjatywa+ZetonControllers.wybrany.scianaAktywna.get(c).pierwszyEfekt;}
    if(ZetonControllers.wybrany.nazwa.equals("medyk")||ZetonControllers.wybrany.nazwa.equals("MedykHege"))
    {ZetonControllers.wspierany.zywotnosc=ZetonControllers.wspierany.zywotnosc+ZetonControllers.wybrany.scianaAktywna.get(c).pierwszyEfekt;}
    if(ZetonControllers.wybrany.nazwa.equals("oficer")||ZetonControllers.wybrany.nazwa.equals("OficerHege"))
    { for(int l=0;l<ZetonControllers.wspierany.scianaAktywna.size();l++)
      {
    	ZetonControllers.wspierany.scianaAktywna.get(l).pierwszyEfekt=ZetonControllers.wspierany.scianaAktywna.get(l).pierwszyEfekt+ZetonControllers.wybrany.scianaAktywna.get(c).pierwszyEfekt;
    	//System.out.println(ZetonControllers.wspierany.scianaAktywna.get(l).pierwszyEfekt);
      }
    }
}

	//obsluga klikniec
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
	
		for(int p=0; p<pola.size(); p++)
			if(pola.get(p)==source){
				if(pola.get(p).zajete==true)
				{System.out.println("zajete!");}
				else
				{
			    kliknietePole=pola.get(p);	
			    kliknietePole.zajete=true;
		
				obslugaPrzycisku();				
				}
			}
		
		{
		ZetonControllers.wyszukajPoWspolrzednychNaPlanszy();
		System.out.println("Obiekt o wspolrzendych: "+ZetonControllers.wybrany.wspolrzednaX+" i "+
		ZetonControllers.wybrany.wspolrzednaY+" ma nastepujacych sasiadow: "+ZetonControllers.wybrany.sciana.get(0)+" "+
		ZetonControllers.wybrany.sciana.get(1)+" "+ ZetonControllers.wybrany.sciana.get(2)+" "+ZetonControllers.wybrany.sciana.get(3)
		+" "+ZetonControllers.wybrany.sciana.get(4)+" "+ZetonControllers.wybrany.sciana.get(5));
		System.out.println("aktynwne sciany: "+ ZetonControllers.wybrany.scianaAktywna.get(0).pierwszyEfekt);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent ddd) {
		
		//obracanie zetonu
		 if(ddd.getKeyCode()== KeyEvent.VK_RIGHT)
		 {
			 
			 nowaGrafika=new ImageIcon(ZetonControllers.wybrany.ListaObrotow.get(ZetonControllers.wybrany.obrot));
			 kliknietePole.setIcon(nowaGrafika);
			// System.out.println(ZetonControllers.wybrany.ListaObrotow.get(ZetonControllers.wybrany.obrot));
		     ZetonControllers.wybrany.obrot++;
		 }
		 
		 if(ddd.getKeyCode()== KeyEvent.VK_LEFT)
		 {
			 ZetonControllers.wybrany.obrot--;
			 nowaGrafika=new ImageIcon(ListaObrotu.get(ZetonControllers.wybrany.obrot));
			 kliknietePole.setIcon(nowaGrafika);		
		 }	
		 if(ddd.getKeyCode()== KeyEvent.VK_ENTER)
		 {
			analiza();		
		 }	
		 if(ddd.getKeyCode()== KeyEvent.VK_SPACE)
		 {
			// System.out.println(ZetonControllers.ZetonyWyjsciowe.get(9).nazwa);
			System.exit(c);	
		 }	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static  String getKlucz()
	{
		return klucz;
	}
	public static int getXX()
	{
		return xx;
	}
	public static int getYY()
	{
		return yy;
	}
}