import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

public class Korisnik_funkcije {
	static int broj_karte = 0;
	static int simbol_karte = 0;
	static int kolicina_novca_Korisnik = 0;
	static boolean as_proso = false;
	static int bet = 0;
	static int velicina_karti_korisnik = 0;
	static boolean as = false;
static int brojac_karti=0;
	public static boolean betovanje(int kolicina_novca_bet) {
		boolean a = false;
		try {
			if (kolicina_novca_Korisnik < kolicina_novca_bet) {
				JOptionPane.showMessageDialog(null, "Nemate toliko novca!");
				throw new InputMismatchException();
			} else if (kolicina_novca_Korisnik >= kolicina_novca_bet && kolicina_novca_bet % 5 == 0 && kolicina_novca_bet!=0) {
				kolicina_novca_Korisnik -= kolicina_novca_bet;
				bet = kolicina_novca_bet;
				a = true;
			}else if (kolicina_novca_bet<5) {
				JOptionPane.showMessageDialog(null, "Premalo novca za betovanje");
				throw new InputMismatchException();
			}else if (kolicina_novca_bet%5!=0) {
				JOptionPane.showMessageDialog(null, "Moguci unosi su : 5, 10, 15, 20 ,25 ...");
				throw new InputMismatchException();
			}
		} catch (Exception e) {
			
		}
		return a;
	}

	public static int hit() {
		int a = 0;

		if (velicina_karti_korisnik > 21) {
			a = 1;
			System.out.println("Presli ste 21");

		} else if (velicina_karti_korisnik == 21) {
			System.out.println("BlackJack");
			a = 2;
		}

		else if (velicina_karti_korisnik < 21) {
			System.out.println("Imate slobodno za unjet");
			a = 3;
		}
		return a;
	}

	public static void korisnikov_novac() {
		try {
			double a = Math.random() * 100;
			int b = (int) a;

			if (b >= 10 && b <= 50 && b % 5 == 0) {
				kolicina_novca_Korisnik = b;

			} else {
				throw new InputMismatchException();
			}

		} catch (Exception e) {
			korisnikov_novac();
		}
	}

	public static boolean random_karte() {
		Random rnd = new Random();
		boolean a = true;

		int broj_karte2 = rnd.nextInt(100);
		int simbol_karte2 = rnd.nextInt(10);

		try {
			if (broj_karte2 > 0 && broj_karte2 <= 13 && simbol_karte2 > 0 && simbol_karte2 <= 4) {

				broj_karte = broj_karte2;
				simbol_karte = simbol_karte2;
				System.out.println("Simbol " + simbol_karte + " broj " + broj_karte);
				
				// uvjet dobre karte
				brojac_karti++;
				
				
				
				if (broj_karte2 >= 10) {
					broj_karte2=10;
					velicina_karti_korisnik += broj_karte2;
					
					
				}  else if (broj_karte2<10 && broj_karte2!=1){
					velicina_karti_korisnik+=broj_karte2;
					System.out.println("nije as");
				}else if (broj_karte2 == 1 && brojac_karti==1 && velicina_karti_korisnik==0) {
					as=true;
					System.out.println("As na prvoj poziciji");
						velicina_karti_korisnik += 11;
					
				}else if (broj_karte2 == 1 && brojac_karti!=1 && velicina_karti_korisnik<=10) {
					as=true;
					System.out.println("As na drugoj poziciji ali moze 11");
					velicina_karti_korisnik += 11;
				
			}else if (broj_karte2 == 1 && brojac_karti!=1 && velicina_karti_korisnik>10) {
			as_proso=true;
				System.out.println("As na drugoj poziciji ali ne moze 11");
				velicina_karti_korisnik += 1;
			
		}
				
				if (as==true && velicina_karti_korisnik>21 && as_proso!=false) {
					velicina_karti_korisnik-=10;
					
				}
			
			
			}

			else {
				a = false;
				throw new InputMismatchException("Vas unos izlazi iz specificno odredjenih mogucih izlaza");
			}
			
			System.out.println("Broj karti korisnik "+brojac_karti);
			System.out.println("Ukupno K: " + velicina_karti_korisnik);
		} catch (Exception e) {
			random_karte();
		}

		return a;

	}public static void reset() {
		 broj_karte = 0;
		 simbol_karte = 0;
		
		 as_proso = false;
		 bet = 0;
		 velicina_karti_korisnik = 0;
	 as = false;
	brojac_karti=0;
	}
}
