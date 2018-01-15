package Projekt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controllers.ZetonControllers;

public class Obsluga  {
static ArrayList<String> ListaObrotu = new ArrayList<String>();
static String sciezka = "C:\\Users\\Merida\\Documents\\Moje!\\Repozytorium Gry\\Neuroshima Hex\\Grafika\\Borgo\\";
static String  obrocony;
static Icon obraz;
public static String klucz;
	public static void  wyszukaj(Plansza plansza)
	{
	
		String Parametr=Panel.sciezka[0];
		String koniec=Parametr.substring(78);
		String[] Czesci=koniec.split("\\.");
	    klucz=Czesci[0];
		for(int i=1;i<7;i++)
		{
		obrocony=sciezka+klucz+i+".png";
		ListaObrotu.add(obrocony);
		}				
	}

	

}
