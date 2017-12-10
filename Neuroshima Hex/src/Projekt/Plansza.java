package Projekt;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Plansza extends JPanel{	//Tworzy tablicê Pól i je po koleji inicjuje
	Pole[][] mapa;
	int rozmiar;
	int szerokoscHexa=120;
	int wysokoscHexa=138;
	
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
}
