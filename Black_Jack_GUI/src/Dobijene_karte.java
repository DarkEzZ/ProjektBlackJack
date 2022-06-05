import javax.swing.ImageIcon;

public class Dobijene_karte extends Karte_ikone{
	
	public ImageIcon dobijena_karta(int broj, int simbol) {
		
		ImageIcon karta = null;
		if (simbol == 1) {
			karta = herz[broj];
		} else if (simbol == 2) {
			karta = pik[broj];
		} else if (simbol == 3) {
			karta = tref[broj];
		} else if (simbol == 4) {
			karta = karo[broj];
		}
		return karta;
	}
}
