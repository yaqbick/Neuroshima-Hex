package Projekt;

//klasa definiuj�ca podstawowe parametry �etonu

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Zeton1 {
	
    public int id; 
	public String nazwa;
	public int mobilnosc;
	public int wytrzymalosc;
	public int inicjatywa;
	public String grafika;
	public String typ;
	public int wspolrzednaX;
	public int wspolrzednaY;
	public ArrayList<Integer> sciana = new ArrayList<Integer>();
	public  ArrayList<Kierunek> scianaAktywna = new ArrayList<Kierunek>();
	public ArrayList<String> ListaObrotow= new ArrayList<String>();
	public int obrot;
	public int zywotnosc;
	public String armia;
	public Zeton1(int id,String nazwa,  int mobilnosc, int wytrzymalosc, int inicjatywa, String grafika, 
			String typ, int wspolrzednaX, int wspolrzednaY, ArrayList<Integer> sciana,ArrayList<Kierunek> scianaAktywna,
			ArrayList<String> ListaObrotow, int obrot, int zywotnosc, String armia) 
	{
		this.id=id;
	    this.nazwa=nazwa;
		this.mobilnosc=mobilnosc;
		this.wytrzymalosc=wytrzymalosc;	
		this.inicjatywa=inicjatywa;
		this.grafika=grafika;
		this.typ=typ;
		this.wspolrzednaX=wspolrzednaX;
		this.wspolrzednaY=wspolrzednaY;
		this.sciana=sciana;
		this.scianaAktywna=scianaAktywna;
		this.ListaObrotow= ListaObrotow;
		this.obrot=obrot; 
		this.zywotnosc=zywotnosc;
		this.armia=armia;
	}

	public Zeton1() {}		
	
	public String toString() {
		
		return "Ten zeton to: "+nazwa+" o inicjawie: "+inicjatywa;
	}
}