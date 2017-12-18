package Projekt;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame implements ActionListener {
JButton przykladowePole;
BufferedImage img;
Icon pusty= new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex4.png");
	Test()
	{
		setLayout(null);
		 JFrame okienko=new JFrame();
		 okienko.setSize(400,400);
	     okienko.setTitle("Test Pola");
	     okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         okienko.setVisible(true);
         okienko.setLocationRelativeTo(null);
	
	przykladowePole=new JButton(new ImageIcon(System.getProperty("user.dir")+"\\Grafika\\Hex\\hex2.png"));
	przykladowePole.setContentAreaFilled(false);
	przykladowePole.setBorder(null);
    okienko.add(przykladowePole);
    przykladowePole.addActionListener(this);
    wczytajObraz();
	}
	
    public void wczytajObraz()
    {
     img = null;
    try {
        img = ImageIO.read(new File("C:\\Users\\Merida\\Documents\\Moje!\\Repozytorium Gry\\Neuroshima Hex\\Grafika\\Borgo\\medyk.png"));
    } catch (IOException e) {
    	System.out.print("Pora¿ka!");
    }
 
	}
    
    public void paint(Graphics g)
    {
    	super.paintComponents(g);
    	AffineTransform at=AffineTransform.getTranslateInstance(50, 50);
    	at.rotate(Math.toRadians(45));
    	Graphics2D obraz = (Graphics2D) g;
    	obraz.drawImage(img,at, null);
        
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e)  
	{
    	 
		Object source = e.getSource();
        
	    if(source == przykladowePole)
	    {
	    	przykladowePole.setIcon(pusty);
            this.repaint();
	    }
	}
	 public static void main(String[] args) {	        

		    System.out.print("dupa"); 
		  
			}
}

