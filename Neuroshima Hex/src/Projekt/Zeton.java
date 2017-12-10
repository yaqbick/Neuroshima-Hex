package Projekt;

import java.util.LinkedList;
import java.util.List;

public class Zeton {
	int obrot;

	private class Cecha{
		String typ;
		int wartosc;
	}
	
	private class Efekt extends Cecha{
		int kierunki[];
		Cecha zasieg;
		boolean sojusznicy;
		boolean wrogowie;
	}
	
	List<Integer> inicjatywa = new LinkedList();
	boolean mobilnosc;
	int wytrzymalosc;
	List<Efekt> efekty = new LinkedList();
	
	
}
