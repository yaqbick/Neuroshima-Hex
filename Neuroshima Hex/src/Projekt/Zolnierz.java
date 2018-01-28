package Projekt;

import java.util.ArrayList;
import java.util.TreeMap;

public class Zolnierz extends Zeton1 {

	int wartoscAtaku;
	
	public Zolnierz()
	{
	}
	
	public Zolnierz(int id,String nazwa,  int mobilnosc, int wytrzymalosc, int inicjatywa, String grafika, 
			int ilosc, int wspolrzednaX, int wspolrzednaY, ArrayList<Integer> sciana, ArrayList<Kierunek> scianaAktywna,
			ArrayList<String>ListaObrotow,int obrot,int wartoscAtaku)
	{
		super( id, nazwa, mobilnosc,wytrzymalosc,inicjatywa, grafika, 
			 ilosc,  wspolrzednaX, wspolrzednaY,sciana,scianaAktywna,ListaObrotow,
			obrot); 
		this.wartoscAtaku=wartoscAtaku;
	}
}