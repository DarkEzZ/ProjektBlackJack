import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Omjer_img {
	public static Image oblikovanje_img(int duzina, int sirina, int scala, Image slika) {
		slika.getScaledInstance(duzina, sirina, scala);
		return slika;
	}

	public static ImageIcon oblikovanje_imgIcon(int duzina, int sirina, int scala, ImageIcon slika) {

		Image icon = slika.getImage();
		Image mjere = icon.getScaledInstance(duzina, sirina, scala);
		slika = new ImageIcon(mjere);

		return slika;
	}
}
