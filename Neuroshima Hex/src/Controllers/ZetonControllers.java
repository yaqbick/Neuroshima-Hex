package Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Projekt.Edytor;
import Projekt.Obsluga;
import Projekt.Plansza;
import Projekt.RodzajZetonu;
import Projekt.Zeton1;

public class ZetonControllers {
	static ArrayList<Zeton1> ZetonyWyjsciowe = new ArrayList<Zeton1>();
	public static ArrayList<Zeton1> ListaObiektowNaPlanszy = new ArrayList<Zeton1>();
	public static Zeton1 wybrany;
	static int modyfikator=0;
	
	public static Zeton1 wyszukajPoNazwie() //trzeba siê po³¹czyæ z csv i pobraæ ¿eton po nazwie(name)
	{
		Iterator<Zeton1> ite= ZetonyWyjsciowe.iterator();
          while ( ite.hasNext( ) ) {        	   
          	Zeton1 dane= ite.next();
          	if(dane.nazwa.indexOf(Obsluga.klucz)==-1)
          	{}
          	else
          	{    wybrany=new Zeton1();
          		 wybrany=dane;         
          	}
          	
		//Zeton1 resultList = new Zeton1();		
		//return resultList;
	}
		return wybrany;
	}
	
	public static Zeton1 wyszukajPoWspolrzednychNaPlanszy() 
	{
		Iterator<Zeton1> ite= ListaObiektowNaPlanszy.iterator();
          while ( ite.hasNext( ) ) {        	   
          	Zeton1 dane2= ite.next();
          	if(dane2.wspolrzednaX==Plansza.xx&&dane2.wspolrzednaY==Plansza.yy)
          	{ 
          		wybrany=dane2; 
          	}
          	else
          	{  
          		      
          	}
          	
		//Zeton1 resultList = new Zeton1();		
		//return resultList;
	}
		return wybrany;
	}
	
	public static  boolean DodajNowyZetonDoCsv(Zeton1 dodawanyZeton) {
		// zapisujesz do pliku CSV
		
		
		
		// jezeli doda sie poprawnie zwrawsza true, jezeli nie to false;
		return true;
	}
	
	public static Zeton1 GetZetonById(int id) {	//to samo co wy¿ej dla id
		Zeton1 resultObj = new Zeton1();
		
		return resultObj;
	}
	
	public static ArrayList<Zeton1> GetAllByUser(int userId)// ³¹czymy siê z csv i sprawdzamy czy user.equals(userID), jesli tak, dodajesz do listy wyników
	{
		ArrayList<Zeton1> resultList = new ArrayList<Zeton1>();
		
		return resultList;
	}
	
	public static ArrayList<Zeton1> stworzObiekty()
	{	
		ArrayList<String> ArmiaWczytana = new ArrayList<String>();
	    		
		BufferedReader br = null;
		FileReader fr = null;
        String sciezka = "C:\\Users\\Merida\\Documents\\Moje!\\Repozytorium Gry\\Neuroshima Hex\\Borgo.csv";
        
		try {			
			fr = new FileReader(sciezka);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				ArmiaWczytana.add(sCurrentLine);}						
		  }
		catch (IOException h) {

			h.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			    }  catch (IOException ex) {

				ex.printStackTrace(); }
		        }	
	
		for(int i=0;i<=ArmiaWczytana.size();i++) 
		{			
		    int id=Integer.parseInt(ArmiaWczytana.get(0+modyfikator));
			String nazwa = ArmiaWczytana.get(1+modyfikator); //trzeba zrobiæ split(;) i pobrac odpowiednie wartosci
			int mobilnosc=	Integer.parseInt(ArmiaWczytana.get(2+modyfikator).split(";")[1]);	
			int wytrzymalosc=	Integer.parseInt(ArmiaWczytana.get(3+modyfikator).split(";")[1]);
			//RodzajZetonu rodzajzetonu=RodzajZetonu.Sztab ;// okresl rodzaj zetonu(z listy/bazy danych- tu przyk³¹dowo sztab)
			int inicjatywa=	Integer.parseInt(ArmiaWczytana.get(4+modyfikator).split(";")[1]);
			String grafika=ArmiaWczytana.get(5+modyfikator).split(";")[1];
			int ilosc=Integer.parseInt(ArmiaWczytana.get(7+modyfikator).split(";")[1]);
			int wspolrzednaX=0;
			int wspolrzednaY=0;
			ArrayList<Integer> sciana=new ArrayList<Integer>();
			ArrayList<Integer> scianaAktywna=new ArrayList<Integer>();
			int c=8;
			for(int m=0;m<6;m++)
			{
				int ktora= Integer.parseInt(ArmiaWczytana.get(c+modyfikator).split(";")[1]);
				String parametr=ArmiaWczytana.get(c+modyfikator).split(";")[0];
			    if(parametr.indexOf("pusty")==0)
				{}
				else
				{scianaAktywna.add(ktora);System.out.println(ktora);}
				c++;
			}
			
			Zeton1 zetonTemp = new Zeton1(id,nazwa,mobilnosc,wytrzymalosc, inicjatywa,grafika,ilosc, wspolrzednaX,wspolrzednaY,sciana,scianaAktywna);//tu dodaj resztê parametrów do konstruktora pobranych z csv
		
			ZetonyWyjsciowe.add(zetonTemp);
			modyfikator=modyfikator+14;
		}
	
		return ZetonyWyjsciowe;
	}
}
