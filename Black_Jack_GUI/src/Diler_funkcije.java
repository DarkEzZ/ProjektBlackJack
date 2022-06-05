import java.util.InputMismatchException;
import java.util.Random;

public class Diler_funkcije {
	static int broj_karte = 0;
	static int simbol_karte = 0;
static boolean as=false;
static boolean as_proso=false;
	static int velicina_karti_diler = 0;
static int brojac_karti=0;
	public static boolean random_karte_diler() {

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
					velicina_karti_diler += broj_karte2;
					
					
				}  else if (broj_karte2<10 && broj_karte2!=1){
					velicina_karti_diler+=broj_karte2;
					
				}else if (broj_karte2 == 1 && brojac_karti==1 && velicina_karti_diler==0) {
					as=true;
					System.out.println("As na prvoj poziciji");
						velicina_karti_diler += 11;
					
				}else if (broj_karte2 == 1 && brojac_karti!=1 && velicina_karti_diler<=10) {
					as=true;
					System.out.println("As na drugoj poziciji ali moze 11");
					velicina_karti_diler += 11;
				
			}else if (broj_karte2 == 1 && brojac_karti!=1 && velicina_karti_diler>10) {
				as_proso=true;
				System.out.println("As na drugoj poziciji ali ne moze 11");
				velicina_karti_diler += 1;
			
		}
				

				
			if (as==true && velicina_karti_diler>17&& as_proso!=false) {
				velicina_karti_diler-=10;
				
			}
				
				
			//glavni uslov
				
				
				
			}

			else {
				a = false;
				throw new InputMismatchException("Vas unos izlazi iz specificno odredjenih mogucih izlaza");
			}System.out.println("Ukupno D: " + velicina_karti_diler);
			
			System.out.println("Broj karti diler "+brojac_karti);
		} catch (Exception e) {
			random_karte_diler();
		}

		return a;
	}public static void reset() {
		 broj_karte = 0;
		 simbol_karte = 0;
		
		 as_proso = false;
	
		 velicina_karti_diler = 0;
	 as = false;
	brojac_karti=0;
	}
}