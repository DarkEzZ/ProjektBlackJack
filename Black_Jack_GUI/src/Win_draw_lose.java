
public class Win_draw_lose extends Korisnik_funkcije {

	static String potreban3 = "";
static boolean z=false;
	public static String stanje() { 
		int velicina_diler = Diler_funkcije.velicina_karti_diler;
		String stanje = "";
		boolean a = true;
		System.out.println("DILER: "+velicina_diler);
		System.out.println("KORISNIK: "+velicina_karti_korisnik);
		while (a) {
if (velicina_diler==velicina_karti_korisnik) {
	System.out.println("Izjednaceno");
	stanje = "Izjednaceno";
	kolicina_novca_Korisnik += bet;
	velicina_karti_korisnik = 0;
	velicina_diler = 0;

	a = false;

	break;
}else {
	
	if (velicina_karti_korisnik == 21 &&brojac_karti>2) {
				if (velicina_diler != 21) {
					System.out.println("Pobjeda");
					stanje = "Pobjeda";
					kolicina_novca_Korisnik += (2 * bet) ;
					velicina_karti_korisnik = 0;
					velicina_diler = 0;

					a = false;

					break;
				} else if (velicina_diler == 21) {
					System.out.println("Izjednaceno");
					stanje = "Izjednaceno";
					kolicina_novca_Korisnik += bet;
					velicina_karti_korisnik = 0;
					velicina_diler = 0;
					a = false;

					break;
				}
			} else if (velicina_karti_korisnik == 21 &&brojac_karti==2) {
				if (velicina_diler != 21) {
					System.out.println("Pobjeda");
					stanje = "Pobjeda";
					kolicina_novca_Korisnik += (2 * bet)*2 ;
					velicina_karti_korisnik = 0;
					velicina_diler = 0;

					a = false;

					break;
				} else if (velicina_diler == 21) {
					System.out.println("Izjednaceno");
					stanje = "Izjednaceno";
					kolicina_novca_Korisnik += bet;
					velicina_karti_korisnik = 0;
					velicina_diler = 0;
					a = false;

					break;
				}
			}
	else if (velicina_karti_korisnik > 21) {
				a=false;
					System.out.println("Poraz");
					stanje = "Poraz";

					velicina_karti_korisnik = 0;
					velicina_diler = 0;
					a = false;
z=true;
					break;
				
			} else if (velicina_karti_korisnik < 21) {
				if (velicina_diler > 21) {
					System.out.println("Pobjeda");
					stanje = "Pobjeda";
					kolicina_novca_Korisnik += (2 * bet);
					velicina_karti_korisnik = 0;
					velicina_diler = 0;

					a = false;

					break;
				} else if (velicina_diler < 21 && velicina_diler < velicina_karti_korisnik) {
					System.out.println("Pobjeda");
					stanje = "Pobjeda";
					kolicina_novca_Korisnik += (2 * bet);
					velicina_karti_korisnik = 0;
					velicina_diler = 0;

					a = false;

					break;
				} else if (velicina_diler < 21 && velicina_diler > velicina_karti_korisnik) {
					System.out.println("Poraz");
					stanje = "Poraz";

					velicina_karti_korisnik = 0;
					velicina_diler = 0;
					a = false;

					break;
				}else if (velicina_diler==21) {
					System.out.println("Poraz");
					stanje = "Poraz";

					velicina_karti_korisnik = 0;
					velicina_diler = 0;
					a = false;

					break;
				}
			}
}
			

		}

		return stanje;
	}

	public static void pretvorba2(int sifra_osobe) {// pretvorba potrbne stvati
		StringBuffer pretvorba1 = new StringBuffer();
		pretvorba1.append(sifra_osobe);

		// naso na internetu, uglavnom buffer pohranjuje niz u sebe
		potreban3 = pretvorba1.toString();
		// deklarianje globalnog stringa zbog lakseg koristenja te info
	}
}
