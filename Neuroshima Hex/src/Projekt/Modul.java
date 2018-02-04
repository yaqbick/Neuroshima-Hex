package Projekt;

import java.util.ArrayList;

public class Modul extends Zeton1 {


	
	public Modul()
	{
	}
	
	public Modul(int id,String nazwa,  int mobilnosc, int wytrzymalosc, int inicjatywa, String grafika, 
			String typ, int wspolrzednaX, int wspolrzednaY, ArrayList<Integer> sciana, ArrayList<Kierunek> scianaAktywna,
			ArrayList<String>ListaObrotow,int obrot,int wartoscAtaku, int zywotnosc, String armia)
	{
		super( id, nazwa, mobilnosc,wytrzymalosc,inicjatywa, grafika, 
			 typ,  wspolrzednaX, wspolrzednaY,sciana,scianaAktywna,ListaObrotow,
			obrot,zywotnosc, armia); 
		
	}
	
}
