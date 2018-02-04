package Controllers;

//klasa do tworzenia oraz obs³ugi obiektów typu ¯eton

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import Projekt.Edytor;
import Projekt.Kierunek;
import Projekt.Panel;
import Projekt.Plansza;

import Projekt.Zeton1;
import Projekt.Zolnierz;

public class ZetonControllers {
	public static ArrayList<Zeton1> ZetonyWyjsciowe = new ArrayList<Zeton1>();
	public static ArrayList<Zeton1> ListaObiektowNaPlanszy = new ArrayList<Zeton1>();
	public static ArrayList<Integer> IdWylosowane=new ArrayList<Integer>();
	public static Zeton1 wybrany;
	public static Zeton1 zaatakowany;
	static int modyfikator;
	static int g;
    static int juzBylo;
    public static int przerwij=1; 
    static int c=0;
    private static String  obrocony;
    private static String sciezka1 = System.getProperty("user.dir")+"\\Grafika\\Borgo\\";
    private static String sciezka2 = System.getProperty("user.dir")+"\\Grafika\\Hegemonia\\";
    static int f;
  //  private static String kluczyk;

	//metoda wyszukujšca obiekty po nazwie

	public static Zeton1 wyszukajPoNazwie() 
	{
		IdWylosowane.add(5);
		Iterator<Zeton1> ite= ZetonyWyjsciowe.iterator();
          while ( ite.hasNext( )&& przerwij==1 ) {        	   
          	Zeton1 dane= ite.next();
          	if(dane.nazwa.indexOf(Plansza.getKlucz())==-1)
          	{}
          	else 
          	{
          		 for(int i=0;i<IdWylosowane.size();i++)
              	 {
          		 if(dane.id==IdWylosowane.get(i))
              	 {ZetonyWyjsciowe.remove(dane);}
              	 else
                 {                       
                 switch(juzBylo)
                 {
                 case 0:
                 {
          	     wybrany=new Zolnierz();
          	     wybrany=dane; 
          		 IdWylosowane.add(dane.id);
          		// System.out.println(dane.id);
          		 przerwij=0;
          		 break;
                 }}}}}}        
		     return wybrany; 
          }
	
          
	 
	
	//metoda wyszukuje obiekt po wspó³rzêdnych na planszy
	
	public static Zeton1 wyszukajPoWspolrzednychNaPlanszy() 
	{
		Iterator<Zeton1> ite= ListaObiektowNaPlanszy.iterator();
          while ( ite.hasNext( ) ) {        	   
          	Zeton1 dane2= ite.next();
          	if(dane2.wspolrzednaX==Plansza.getXX()&&dane2.wspolrzednaY==Plansza.getYY())
          	{ 
          		wybrany=dane2; 
          	}
          	else
          	{            		      
          	}
          	
	}
		return wybrany;
	}
	
	public static Zeton1 wyszukajZaatakowanego() 
	{
		Iterator<Zeton1> ite= ListaObiektowNaPlanszy.iterator();
         while ( ite.hasNext( ) ) {        	   
          	Zeton1 dane2= ite.next();
          	if(dane2.wspolrzednaX==Plansza.rzedna&&dane2.wspolrzednaY==Plansza.odcieta)
          	{ 
          		zaatakowany=dane2; 
          	}
          	else
          	{            		      
          	}
          	
	}
		return zaatakowany;
	}
		
	   // metoda wczytuje dane o armii z listy ArmiaWczytana i tworzy listê obiektów typu ¯eton
	
	public static ArrayList<Zeton1> stworzObiekty()
	{	
		ArrayList<String> Armie= new ArrayList<String>();
		Armie.add("\\Borgo.csv");
		Armie.add("\\Hegemonia.csv");
		for( f=0;f<2;f++)
		{
		modyfikator=0;
		ArrayList<String> ArmiaWczytana = new ArrayList<String>();
	    		
		BufferedReader br = null;
		FileReader fr = null;
        String sciezka = System.getProperty("user.dir")+Armie.get(f);
        
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
	
		for(int i=0;i<10;i++) 
		{			
		    int id=Integer.parseInt(ArmiaWczytana.get(0+modyfikator));
			String nazwa = ArmiaWczytana.get(1+modyfikator); //trzeba zrobiæ split(;) i pobrac odpowiednie wartosci
			int mobilnosc=	Integer.parseInt(ArmiaWczytana.get(2+modyfikator).split(";")[1]);	
			int wytrzymalosc=Integer.parseInt(ArmiaWczytana.get(3+modyfikator).split(";")[1]);
			//RodzajZetonu rodzajzetonu=RodzajZetonu.Sztab ;// okresl rodzaj zetonu(z listy/bazy danych- tu przyk³šdowo sztab)
			int inicjatywa=	Integer.parseInt(ArmiaWczytana.get(4+modyfikator).split(";")[1]);
			String grafika=ArmiaWczytana.get(6+modyfikator).split(";")[1];
			int ilosc=Integer.parseInt(ArmiaWczytana.get(7+modyfikator).split(";")[1]);
			int wspolrzednaX=0;
			int wspolrzednaY=0;
			int obrot=0;
			int c=8;
			int zywotnosc;
			if(nazwa.equals("sztab")||nazwa.equals("SztabHege"))
			{ zywotnosc=20;}
			else
			{ zywotnosc=1;}
			String armia;
		    if(f==0)
			{armia="Borgo";}
		    else
		    {armia="Hegemonia";} 
			ArrayList<Integer> sciana=new ArrayList<Integer>();
		    ArrayList<Kierunek> scianaAktywna=new ArrayList<Kierunek>();
		    ArrayList<String> ListaObrotow= new ArrayList<String>();
		    String Parametr=grafika;
		    String koniec;
		    if(f==0)
			{koniec=Parametr.substring(15);}
		    else
		    {koniec=Parametr.substring(19);} 	
			String[] Czesci=koniec.split("\\.");
		    String kluczyk=Czesci[0];
		    for(int m=1;m<7;m++)
		    {
		    	if(f==0)
		    	{obrocony=sciezka1+kluczyk+m+".png";}
		    	else
		    	{obrocony=sciezka2+kluczyk+m+".png";}	
				ListaObrotow.add(obrocony);
		    }
			for(int m=0;m<6;m++)
			{
				int ktora= Integer.parseInt(ArmiaWczytana.get(c+modyfikator).split(";")[1]);
				String parametr=ArmiaWczytana.get(c+modyfikator).split(";")[0];
				String parametr2=ArmiaWczytana.get(c+modyfikator).split(";")[2];
			    if(parametr.indexOf("pusty")==0)
				{}
				else
				{	
				int parametr1=Integer.parseInt(parametr);	
				Kierunek K= new Kierunek(ktora,parametr1, parametr2);	
				scianaAktywna.add(K);
				}
				c++;
			}

			Zeton1 zetonTemp = new Zeton1(id,nazwa,mobilnosc,wytrzymalosc, inicjatywa,grafika,ilosc, wspolrzednaX,wspolrzednaY,sciana,scianaAktywna, ListaObrotow, obrot, zywotnosc, armia);//tu dodaj resztê parametrów do konstruktora pobranych z csv
		
			ZetonyWyjsciowe.add(zetonTemp);
			modyfikator=modyfikator+14;
		}
		
		}
		return ZetonyWyjsciowe;
	}
	
}