package Projekt;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Punkty extends JPanel {
	private static JPanel polaPunktow= new JPanel();
	private JLabel punktyBorgo;
	private JLabel punktyHege;
	private static JTextField wartoscBorgo;
	private static JTextField wartoscHege;
		
	Punkty()
	{    
		punktyBorgo=new JLabel(" Sztab Borgo: ");
		wartoscBorgo=new JTextField("20");
		punktyHege=new JLabel(" Sztab Hege: ");
		wartoscHege=new JTextField("20");
		polaPunktow.add(punktyBorgo);
		polaPunktow.add(wartoscBorgo);
		polaPunktow.add(punktyHege);
		polaPunktow.add(wartoscHege);		
		add(polaPunktow);
	}
public static JTextField getBorgo()
{
	return wartoscBorgo;
}
public static JTextField getHege()
{
	return wartoscHege;
}
}
