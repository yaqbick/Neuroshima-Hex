package Projekt;

import java.awt.Color;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ZetonControllers;

public class Plansza extends JPanel implements ActionListener,KeyListener{	//Tworzy tablicê Pól i je po koleji inicjuje
	static Pole[][] mapa;
	int rozmiar;
	int szerokoscHexa=120;
	int wysokoscHexa=138;

	Icon obraz;
	Icon nowaGrafika;
	int liczba=0;
	int v;
	int z;
	public static int xx;
	public static int yy;
    int n=0;
	
	
	Plansza(int rozmiar){
		//Rysowanie planszy
		this.rozmiar=rozmiar;
		setLayout(new GridLayout(rozmiar,1,0,-wysokoscHexa/4));
		setBackground( new Color( 0, 0, 0, 0 ) );
		setOpaque(false);
		setBorder(BorderFactory.createTitledBorder("Plansza"));
		

		mapa=new Pole[rozmiar][rozmiar];
		for(int y=0; y<rozmiar; y++)
		{
			JPanel rzad = new JPanel();
			rzad.setLayout(new GridLayout(1,rozmiar));
			rzad.setBackground( new Color( 0, 0, 0, 0 ) );
			rzad.setOpaque(false);
			if(y%2==0)rzad.setBorder(new EmptyBorder(0, szerokoscHexa/2, 0, szerokoscHexa/2));
			else rzad.setBorder(new EmptyBorder(0, 0, 0, szerokoscHexa));
			add(rzad);
			
			for(int x=0; x<rozmiar; x++)
			{				
				mapa[x][y]=new Pole(szerokoscHexa,wysokoscHexa);
				if(!isInsideHexagon(x,y))mapa[x][y].setVisible(false);
				mapa[x][y].addActionListener(this);
				mapa[x][y].addKeyListener(this);
				rzad.add(mapa[x][y]); //dodaje do JPanel obiekt Pole z tablicy, mogê tak zrobiæ bo dziêki dziedziczeniu Pole jest tak¿e JButton'em				
			}
		}

	
	}
	
	Boolean isInsideHexagon(int x, int y)
	{	//funkcja przysz³oœciowo bêdzie matematycznie sprawdzaæ czy pole le¿y wewn¹trz hexagonu planszy nie zaleznie od jej rozmiaru
		//oczywiœæie tylko jeœli zamierzamy daæ mo¿liwoœæ zmiany rozmiaru mapy
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
		obraz=new ImageIcon(Panel.sciezka[0]);
		mapa[z][v].setIcon(obraz);
		Obsluga obsluga=new Obsluga();
		obsluga.wyszukaj(this);
		ZetonControllers.wyszukajPoNazwie();
		ZetonControllers.wybrany.wspolrzednaX=z;
		ZetonControllers.wybrany.wspolrzednaY=v;
		String nazwa=ZetonControllers.wybrany.nazwa;
		int inicjatywa=ZetonControllers.wybrany.inicjatywa;
		System.out.println("Dodano Obiekt: "+nazwa+" o inicjatywie: "+inicjatywa);
		System.out.println("wspolrzedne: "+ZetonControllers.wybrany.wspolrzednaX+" i "+ZetonControllers.wybrany.wspolrzednaY);
		ZetonControllers.ListaObiektowNaPlanszy.add(ZetonControllers.wybrany);
		okreslSasiada();
		uruchomModul();
		
	}
	
	public void okreslSasiada()
	{
		xx=ZetonControllers.wybrany.wspolrzednaX;
	    yy=ZetonControllers.wybrany.wspolrzednaY;
	    ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana=new ArrayList<Integer>();
		int zero=xx*10+yy-1;
		int jeden=(xx+1)*10+yy;
		int dwa=(xx+1)*10+yy+1;
		int trzy=xx*10+yy+1;
		int cztery=(xx-1)*10+yy;
		int piec=(xx-1)*10+yy-1;
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(zero);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(jeden);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(dwa);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(trzy);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(cztery);
		ZetonControllers.ListaObiektowNaPlanszy.get(n).sciana.add(piec);	
		n++;
	}
	
	public void uruchomModul()
	{   
		 //ZetonControllers.ListaObiektowNaPlanszy.get(n).scianaAktywna=new ArrayList<Integer>();
		for(int d=0;d<3;d++)
		{			
			int k=ZetonControllers.ListaObiektowNaPlanszy.get(n-1).scianaAktywna.get(d);
		    int l=ZetonControllers.ListaObiektowNaPlanszy.get(n-1).sciana.get(k);
		    int x=l/10;
		    int y= l-x*10;
		    System.out.println("Nowe zasilone pole! Wspolrzedne: "+x+" oraz "+y);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
	
		
		if(source==mapa[2][1])		    
		{   
			z=2;
			v=1;
			obslugaPrzycisku();
		}
		if(source==mapa[3][3])
		{
		z=3;	
		v=3;	
		obslugaPrzycisku();
		}
		if(source==mapa[2][2])
		{
		ZetonControllers.wyszukajPoWspolrzednychNaPlanszy();
		System.out.println("Obiekt o wspolrzendych: "+ZetonControllers.wybrany.wspolrzednaX+" i "+
		ZetonControllers.wybrany.wspolrzednaY+" ma nastepujacych sasiadow: "+ZetonControllers.wybrany.sciana.get(0)+" "+
		ZetonControllers.wybrany.sciana.get(1)+" "+ ZetonControllers.wybrany.sciana.get(2)+" "+ZetonControllers.wybrany.sciana.get(3)
		+" "+ZetonControllers.wybrany.sciana.get(4)+" "+ZetonControllers.wybrany.sciana.get(5));
		System.out.println("aktywne œciany: ");
		}
	}

	@Override
	public void keyPressed(KeyEvent ddd) {
		 if(ddd.getKeyCode()== KeyEvent.VK_RIGHT)
		 {
			 nowaGrafika=new ImageIcon(Obsluga.ListaObrotu.get(liczba));
			 mapa[z][v].setIcon(nowaGrafika);
			 liczba++;
		 }
		 if(ddd.getKeyCode()== KeyEvent.VK_LEFT)
		 {
			 liczba--;
			 nowaGrafika=new ImageIcon(Obsluga.ListaObrotu.get(liczba));
			 mapa[2][2].setIcon(nowaGrafika);
			
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
}
