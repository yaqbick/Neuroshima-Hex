package Projekt;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Metody {
	
	Edytor edytor;
	static int x;
	
	public static void zeruj(Edytor edytor)
	{
		Edytor.Nazwa.setText("");
		for(int i=0; i<6; i++)
		{
			Edytor.sciana[i].setSelectedItem("pusty");
		}
		Edytor.mobilnosc.setSelected(false);       
        Edytor.wytrzymalosc.setSelected(false);
        Edytor.zolnierz.setSelected(false);
        Edytor.modul.setSelected(false);
        Edytor.inicjatywa[0].setSelectedItem("0");
        Edytor.Ile.setText("");
        
	}
	
	public static void wypelnij(Edytor edytor)
	{
	  	 java.util.Iterator<String> ite= Edytor.Armia.iterator();
       	 int k=2;
           while ( ite.hasNext( ) ) {        	   
           	String dane= ite.next();
           	if(dane.indexOf(Edytor.Wybrany)==-1)
           	{}
           	else
           	{
           	 while ( ite.hasNext( ) ) {	
          	 if(dane.indexOf("mo")==-1)
          	 {
       	    String Parametr=Edytor.Armia.get(k);
  			String[] Czesci = Parametr.split(";");
  			String Fragment= Czesci[0];
  			String Fragment2= Czesci[1];
  			try {
  			int wartosc= Integer.parseInt(Fragment2);
  			Edytor.sciana[wartosc].setSelectedItem(Fragment);
  			}
  			catch(NumberFormatException e){System.out.print("error");}
  			k++;
          	 }
          	 else
          	 {break;}
           
           } 
         	
           }
         
           }
	}

	public static void weryfikacja(Edytor edytor)
	{
		x=0;
		for(int i=0; i<6; i++)
		{
		String parametr= Edytor.sciana[x].getSelectedItem().toString();
		String drugiparametr= Edytor.sciana[x+6].getSelectedItem().toString();
		if(parametr.length()<10)
		   {
			 if(drugiparametr.startsWith(parametr)==true)
			 {
				 if(parametr.startsWith("pusty")==true)
				 {}
				 else
				 {
					 JOptionPane.showMessageDialog(null, "Nie mozesz uzyc tych samych efektow na jednej scianie!");
					 System.exit(0);
				 }				
			 }
			 else
			 {				 
			 }
		   }
		else
		   {
			String[] czesci = parametr.split("\\s+");
			String fragment= czesci[1];
			   if(drugiparametr.indexOf(fragment)==-1)
			   {			   
			   }
			   else
			   {
					 JOptionPane.showMessageDialog(null, "Nie mozesz uzyc tych samych efektow na jednej scianie!");
					 System.exit(0);   
			   }
		   }
		x++;
		}
	}
	
	 public static void main(String[] args) {	        
		 System.out.println("dupa");
	}
}
