import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Karte_ikone {
	ImageIcon herz[] = new ImageIcon[14];
	ImageIcon pik[] = new ImageIcon[14];
	ImageIcon tref[] = new ImageIcon[14];
	ImageIcon karo[] = new ImageIcon[14];
ImageIcon okrenuta=new ImageIcon();
ImageIcon crno=new ImageIcon();
ImageIcon start=new ImageIcon();
	public Karte_ikone() {
		okrenuta= new ImageIcon(getClass().getClassLoader().getResource(  "okrenuta.png"));
		crno= new ImageIcon(getClass().getClassLoader().getResource(  "crna6.jpg"));
		start= new ImageIcon(getClass().getClassLoader().getResource(  "start8.png"));
		for (int i = 1; i < 14; i++) {

			herz[i] = new ImageIcon(getClass().getClassLoader().getResource(i + "herz.png"));
			pik[i] = new ImageIcon(getClass().getClassLoader().getResource(i + "pik.png"));
			tref[i] = new ImageIcon(getClass().getClassLoader().getResource(i + "tref.png"));
			karo[i] = new ImageIcon(getClass().getClassLoader().getResource(i + "karo.png"));
		}
	}

	
}
