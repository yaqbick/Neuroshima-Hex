package Projekt;

import java.util.ArrayList;

public class Zeton1 {
	
    public int id; 
	public String nazwa;
	public int mobilnosc;
	public int wytrzymalosc;
	//public RodzajZetonu rodzajZetonu;
	public int inicjatywa;
	public String grafika;
	public int ilosc;
	public int wspolrzednaX;
	public int wspolrzednaY;
	public static ArrayList<Integer> sciana = new ArrayList<Integer>();
	public static ArrayList<Integer> scianaAktywna = new ArrayList<Integer>();
	public Zeton1(int id,String nazwa,  int mobilnosc, int wytrzymalosc, int inicjatywa, String grafika, 
			int ilosc, int wspolrzednaX, int wspolrzednaY, ArrayList<Integer> sciana,ArrayList<Integer> scianaAktywna) 
	{
		this.id=id;
	    this.nazwa=nazwa;
		this.mobilnosc=mobilnosc;
		this.wytrzymalosc=wytrzymalosc;	
		//this.rodzajZetonu= rodzajZetonu;
		this.inicjatywa=inicjatywa;
		this.grafika=grafika;
		this.ilosc=ilosc;
		this.wspolrzednaX=wspolrzednaX;
		this.wspolrzednaY=wspolrzednaY;
		this.sciana=sciana;
		this.scianaAktywna=scianaAktywna;
	}

	public Zeton1() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		
		return "Ten zeton to: "+nazwa+" o inicjawie: "+inicjatywa;
	}
}